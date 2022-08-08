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
	
	// �����ϴ� �ּ�
	@GetMapping("/fileupload/form")
	public String uploadForm() {
		// ���� ��ġ
		return "/upload/Form";
	}
	
	@PostMapping("/fileupload")
	public String handFileUpload(
			// @RequestParam ������̼��� HttpServletRequest ��ü�� ���� ������ �Ѵ�
			// HttpServletRequest�� getParameter() �޼ҵ带 �̿������� @RequestParam�� �̿��� �޾ƿ��� ����� �ִ�
			// ex : @RequestParam("������ �������� �̸�")[������ Ÿ��][������ �����͸� ���� ����]
			@RequestParam("file") MultipartFile file) {
		
		// ��ĥ ���� �ſ� �����Ѵٸ� ���ϸ� �������� �Ѵ�.
		Path rootLocation = Paths.get("target/files/" + Math.abs(new Random().nextLong()));
		//Path rootLocation = Paths.get("../../target/files/" + Math.abs(new Random().nextLong()));
		
		log.info("rootLocation: " + rootLocation);
		
		// ���� ���
		log.info("abs rootLocation: " + rootLocation.toAbsolutePath());
		
		if (file.isEmpty()) {
			log.error("����ִ� ������ ������ �� �����ϴ�.");
			return"redirect:/message";
		}
		
		// Path.resolve() : �ش� Path�κ��� �Ѱ��� ��� ��θ� ������ �ν��Ͻ� ��ȯ
		// Path.normalize() : �ش� Path�� ./, ../���� ��� ��ε��� �ּ�ȭ�� ��θ� ��ȯ
		// ���� �̸��� ��ġ�� �ʵ��� �տ� �ִ��� ��ġ�� �ʴ� ���ڸ� �־��ִ� ���� ����
		// UUID Ŭ������ ����� �� �ִ�.
		// �� ������ �ٽ� ã������ db�� �����ؼ� ã�´�.
		UUID uuid = UUID.randomUUID(); // ���� �ĺ���
		Path destinationFile = rootLocation.resolve(
				Paths.get(uuid + 
						"_" + file.getOriginalFilename())).normalize();
		
		log.info("destinationFile: " + destinationFile);
		
		// ���� ����
		try (InputStream in = file.getInputStream()){
			// nio�� mkdirs (�ش� ��ο� �ʿ��� ��� ���� ���丮���� �����Ѵ�)
			Files.createDirectories(destinationFile);
			// ������ �״�� ����
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
		// ��Ʈ�ѷ����� ��Ʈ����Ʈ�� ���� �� model�� Ȱ���� �� �ִ�.
		
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
	
	// files �ȿ� file �ȿ� �ִ� �͸� ����
	@GetMapping("/fileupload/target/files/{parent}/{filename:.+}")
	@ResponseBody
	public ResponseEntity<Resource> serveFile(
			// @GetMapping�� �ִ� ��θ� ������ ���
			@PathVariable String parent, @PathVariable String filename) {
		
		log.info("parent: " + parent);
		log.info("filename: " + filename);
		
		Path file = Paths.get("target/files/").resolve(parent).resolve(filename);
		
		try {
			Resource resource = new UrlResource(file.toUri());
			
			// ������ �ٿ������� �Ҷ��� ����� content-disposition �׺��� attachment�� �ٲ�� �Ѵ�.
			return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
					"attachment; filename=\"hello.jpg\"").body(resource);
		} catch (MalformedURLException e) {
			e.printStackTrace();
			return (ResponseEntity<Resource>) ResponseEntity.notFound();
		}
		
 		
	}
	
}
