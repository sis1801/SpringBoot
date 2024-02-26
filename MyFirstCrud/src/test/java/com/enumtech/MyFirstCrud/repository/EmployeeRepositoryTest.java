package com.enumtech.MyFirstCrud.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.enumtech.MyFirstCrud.entity.Employee;
@SpringBootTest
class EmployeeRepositoryTest {

	@Autowired
	EmployeeRepository repo;
	
	
	@Test
	public void findByEnameTest()
	{
		Employee e1=new Employee(7,"Charles",1000);
		Employee actualEmp;
		
		repo.save(e1);
		actualEmp=repo.findByEname("Charles");
		assertEquals(actualEmp.getEname(), "Charles");
		
		
	}

	@Test
	public void findBySal()
	{
		Employee e2=new Employee(10,"Shruti",8000);
		Employee e3=new Employee(20,"Hasan",8000);
		List<Employee> actualEmp;
		repo.save(e2);
		repo.save(e3);
		actualEmp=(List<Employee>) repo.findBySal(8000);
		assertEquals(actualEmp.size(),2);
		
		
		
	}
	
}
