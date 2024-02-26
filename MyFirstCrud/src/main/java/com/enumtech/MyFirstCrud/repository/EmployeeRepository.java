package com.enumtech.MyFirstCrud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enumtech.MyFirstCrud.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

	public Employee findByEname(String ename);

	public List<Employee> findByEnameAndSal(String ename, double sal);

	public List<Employee> findBySal(double sal);

	
}
