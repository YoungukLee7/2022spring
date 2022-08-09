package com.ezen.Database.mapper;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ezen.Database.dto.Employee;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
	"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
	"file:src/main/webapp/WEB-INF/spring/root-context.xml"
})
public class MapperTest {
	
	@Autowired
	EmployeeMapper mapper;

	@Test
	public void getAllEmployees() {
		List<Employee> employees = mapper.getList();
		
		assertEquals(107, employees.size());
	}
	
	@Test
	public void findById() {

		Employee emp = mapper.findbyId(103);
		
		log.info(emp);
		
		assertNotNull(emp);
	}

}
