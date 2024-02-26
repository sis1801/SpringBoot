package com.enumtech.MyFirstCrud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enumtech.MyFirstCrud.entity.Employee;
import com.enumtech.MyFirstCrud.repository.EmployeeRepository;

@Service
public class EmpService {
	
	@Autowired
	EmployeeRepository emprepo;
	public Employee addEmp(Employee e1) {
		
		return emprepo.save(e1);
	}
	public Employee addEmpByRequestBody(Employee emp)
	{
		
		return emprepo.save(emp);
	}
	public Employee addEmpByPathParam(Employee e2) {
		
		return emprepo.save(e2);
	}
	public Employee searchEmpById(int eno) {
		
		return emprepo.findById(eno).get();
	}
	public List<Employee> searchAllEmp() {
		
		return emprepo.findAll();
	}
	public void DeleteEmpById(int eno) {
		
		emprepo.deleteById(eno);
		
	}
	public Employee updateEmpById(int eno, Employee uiobj) {
		Employee dbobj=emprepo.findById(eno).get();
		dbobj.setEname(uiobj.getEname());
		dbobj.setSal(uiobj.getSal());
		return emprepo.save(dbobj);
	}
	public Employee searchempbyname(String ename) {
		
		return emprepo.findByEname(ename);
	}
	public List<Employee> searchempbynamelist(String ename,double sal) {
		// TODO Auto-generated method stub
		return emprepo.findByEnameAndSal(ename,sal);
	}
	public List<Employee> searchempbysal(double sal) {
		// TODO Auto-generated method stub
		return emprepo.findBySal( sal);
	}

	
	

}