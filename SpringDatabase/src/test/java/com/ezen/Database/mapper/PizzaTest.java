package com.ezen.Database.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ezen.Database.dto.Pizza;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
	"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
	"file:src/main/webapp/WEB-INF/spring/root-context.xml"
})
public class PizzaTest {
	
	@Autowired
	PizzaMapper mapper;
	
	@Test
	public void getPizza() {
		List<Pizza> pizza = mapper.getList();
		
		log.info(pizza);
	}

}
