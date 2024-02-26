package com.enumtech.MyFirstCrud.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.enumtech.MyFirstCrud.entity.Employee;
import com.enumtech.MyFirstCrud.service.EmpService;

@SpringBootTest
class EmpControllerTest {
	
	@Autowired
	EmpService empserv;
	
	@Test
	void addEmpTest() 
	{
		Employee e1=new Employee();
		Employee actualEmp;
		e1.setEname("Nazish");
		e1.setSal(550);
		actualEmp=empserv.addEmp(e1);
		assertEquals(actualEmp.getEname(), "Nazish");
		
	}

}
