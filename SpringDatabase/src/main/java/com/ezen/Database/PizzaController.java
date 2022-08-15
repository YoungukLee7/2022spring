package com.ezen.Database;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ezen.Database.dto.Employee;
import com.ezen.Database.dto.Pizza;
import com.ezen.Database.mapper.PizzaMapper;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
public class PizzaController {
	
	@Autowired
	PizzaMapper mapper;
	
	@GetMapping("/pizza")
	public String mainPage() {
		return "/pizza/pizza";
	}
	
	@GetMapping("/pizza/select")
	public String selectPizza(Model model) {
		
		model.addAttribute("pizzas", mapper.getList());
		
		log.info(mapper.getList());
		
		return "/pizza/select";
	}
	
	@GetMapping("/pizza/insert")
	public String insert() {
		return "/pizza/insert";
	}
	
	@RequestMapping(value="/pizza/insertPizza", method=RequestMethod.POST)
	public String insertPizza(
								Model model,
								@RequestParam("name") String name,
								@RequestParam("price") int price,
								@RequestParam("col") double col								
							 ) {
		
		log.info(name);
		log.info(price);
		log.info(col);
		
		mapper.insert(name, price, col);

		return "redirect:/pizza";
	}
	
	@RequestMapping(value="/pizza/update*", method=RequestMethod.GET)
	public String update(
							Model model,
							@RequestParam("id") Integer id
						) {
		
		
		Pizza pizza = mapper.findId(id);
		
		log.info(id);
		log.info(pizza.getPizza_id());
		log.info(pizza.getPizza_name());
		log.info(pizza.getPizza_price());
		log.info(pizza.getPizza_calories());

		model.addAttribute("ids", pizza.getPizza_id());
		model.addAttribute("names", pizza.getPizza_name());
		model.addAttribute("prices", pizza.getPizza_price());
		model.addAttribute("caloriess", pizza.getPizza_calories());
		
		return "/pizza/updatePizza";
	}

}
