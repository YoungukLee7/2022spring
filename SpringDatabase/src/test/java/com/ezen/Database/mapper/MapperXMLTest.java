package com.ezen.Database.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class MapperXMLTest {

	@Autowired
	EmployeeMapperXML mapper;
	
	@Test
	public void test() {
		log.info(mapper.getList());
	}
	
	@Test
	public void test2() {
		log.info(mapper.getListByDept(50));
	}
}
