package com.test.one;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.one.pizza.dto.Pizza;
import com.test.one.pizza.service.PizzaService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
@RequestMapping("/pizza")
public class PizzaController {
	
	PizzaService service;
	
	@Autowired
	public PizzaController(PizzaService service) {
		this.service = service;
	}
	
	@GetMapping("list")
	public void pizzaList(Model model) {
		model.addAttribute("pizzaList", service.getList());
	}
	
	@GetMapping("/add")
	public void pizzaAddForm() {
		
	}
	
	@PostMapping("/add")
	public String pizzaAddinsert(Pizza pizza) {
		
		//log.info(pizza);
		
		// 아이디가 null이 올 수도 있어 Integer로 받아야 한다
		Integer id = service.addPizza(pizza);
		
		 log.info(id);
		
		return "redirect:/pizza/list";
	}
	
	@GetMapping("/update")
	public String pizzaUpdateForm(Model model, Integer id) {
		log.info("update id: " + id);
		
		if (id == null) {
			return "redirect:/pizza/list";
		}
		
		model.addAttribute("pizza", service.updatePizzaForm(id));
		return "pizza/update";
	}
	
	@PostMapping("/update")
	public String pizzaUpdate(Pizza pizza) {
		service.updatePizza(pizza);
		
		return "redirect:/pizza/list";
	}
	

}
