package com.ezen.springmvc.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
public class FileController {
	
	// 접속하는 주소
	@GetMapping("/fileupload/form")
	public String uploadForm() {
		// 파일 위치
		return "/upload/Form";
	}
	
	@PostMapping("/fileupload")
	public String handFileUpload(
			// @RequestParam 어노테이션은 HttpServletRequest 객체와 같은 역할을 한다
			// HttpServletRequest는 getParameter() 메소드를 이용했지만 @RequestParam을 이용해 받아오는 방법도 있다
			// ex : @RequestParam("가져올 데이터의 이름")[데이터 타입][가져온 데이터를 담을 변수]
			@RequestParam("file") MultipartFile file) {
		
		// 겹칠 것을 매우 걱정한다면 파일명도 랜덤으로 한다.
		Path rootLocation = Paths.get("target/files/" + Math.abs(new Random().nextLong()));
		//Path rootLocation = Paths.get("../../target/files/" + Math.abs(new Random().nextLong()));
		
		log.info("rootLocation: " + rootLocation);
		
		// 절대 경로
		log.info("abs rootLocation: " + rootLocation.toAbsolutePath());
		
		if (file.isEmpty()) {
			log.error("비어있는 파일을 저장할 수 없습니다.");
			return"redirect:/message";
		}
		
		// Path.resolve() : 해당 Path로부터 넘겨준 상대 경로를 적용한 인스턴스 반환
		// Path.normalize() : 해당 Path의 ./, ../같은 상대 경로들을 최소화한 경로를 반환
		// 파일 이름이 겹치지 않도록 앞에 최대한 겹치지 않는 숫자를 넣어주는 것이 좋다
		// UUID 클래스를 사용할 수 있다.
		// 이 파일을 다시 찾으려면 db에 저장해서 찾는다.
		UUID uuid = UUID.randomUUID(); // 고유 식별자
		Path destinationFile = rootLocation.resolve(
				Paths.get(uuid + 
						"_" + file.getOriginalFilename())).normalize();
		
		log.info("destinationFile: " + destinationFile);
		
		// 파일 쓰기
		try (InputStream in = file.getInputStream()){
			// nio의 mkdirs (해당 경로에 필요한 모든 상위 디렉토리들을 생성한다)
			Files.createDirectories(destinationFile);
			// 파일을 그대로 복사
			Files.copy(in, destinationFile, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
//		ServletContext application = request.getServletContext();
//		log.info("real path: " + application.getRealPath("/"));
		
		log.info("file: " + file);
		
		log.info("file name: " + file.getOriginalFilename());
		
		log.info("file size: " + file.getSize() + "Byte(s)");
		
		return"redirect:/";
	}
	
	@GetMapping("/fileupload/")
	public String listUploadedFiles(Model model) {
		// 컨트롤러에서 어트리뷰트를 실을 때 model을 활용할 수 있다.
		
		List<File> files = new ArrayList<>();
		
		File rootLocation = new File("target/files/");
		//File rootLocation = new File("../../target/files/");
		
		int index = 1;
		for (File f : rootLocation.listFiles()) {
			if (f.isDirectory()) {
				for (File f2 : f.listFiles()) {
					files.add(f2);
				}
			}else {
				files.add(f);
			}
		}
		
		model.addAttribute("files", files);
		
		return "upload/list";
	}
	
	// files 안에 file 안에 있는 것만 가능
	@GetMapping("/fileupload/target/files/{parent}/{filename:.+}")
	@ResponseBody
	public ResponseEntity<Resource> serveFile(
			// @GetMapping에 있는 경로를 가져다 사용
			@PathVariable String parent, @PathVariable String filename) {
		
		log.info("parent: " + parent);
		log.info("filename: " + filename);
		
		Path file = Paths.get("target/files/").resolve(parent).resolve(filename);
		
		try {
			Resource resource = new UrlResource(file.toUri());
			
			// 파일을 다운받으라고 할때는 헤더의 content-disposition 항복을 attachment로 바꿔야 한다.
			return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
					"attachment; filename=\"hello.jpg\"").body(resource);
		} catch (MalformedURLException e) {
			e.printStackTrace();
			return (ResponseEntity<Resource>) ResponseEntity.notFound();
		}
		
 		
	}
	
}
