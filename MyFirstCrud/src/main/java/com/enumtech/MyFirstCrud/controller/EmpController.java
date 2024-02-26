package com.enumtech.MyFirstCrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.enumtech.MyFirstCrud.entity.Employee;
import com.enumtech.MyFirstCrud.service.EmpService;

@RestController
@RequestMapping(value="/sis")
public class EmpController {
	@Autowired
	EmpService empservice;
	
	@Value("${my.college}")
	String college;
	
	@RequestMapping(value="/college", method=RequestMethod.GET)
	public String college() 
	{
		return(college);
	}
	
	@RequestMapping(value="/display", method=RequestMethod.GET)
	public Employee display()
	{
	Employee e1=Employee.builder()
			.ename("Sofiya")
			.build();
			
	return e1;
		
	}
	
	@RequestMapping(value="/addemp", method=RequestMethod.POST)
	public Employee addEmp(@RequestParam String ename, @RequestParam double sal)
	{
		Employee e1=new Employee();
		e1.setEname(ename);
		e1.setSal(sal);
		return(empservice.addEmp(e1));
		
		
	}
	
	@RequestMapping(value="/addempbyreqbody", method = RequestMethod.POST)
	public Employee addEmpByRequestBody(@RequestBody Employee emp)
	{
		return(empservice.addEmpByRequestBody(emp));	
	}
	
	@RequestMapping(value="/addempbypathparam/{enami}/{saly}", method = RequestMethod.POST)
	public Employee addEmpByPathParam(@PathVariable("enami") String ename, @PathVariable("saly") double sal)
	{
		Employee e2=new Employee();
		e2.setEname(ename);
		e2.setSal(sal);
		return empservice.addEmpByPathParam(e2);
	}
	
	
	
	@RequestMapping(value="/getempbyid", method = RequestMethod.GET)
	public Employee searchEmpById(@RequestParam("en") int eno)
	{
		return empservice.searchEmpById(eno);
	}
	
	
	
	@RequestMapping(value="/getAllemp", method = RequestMethod.GET)
	public List<Employee> searchAllEmp()
	{
		return empservice.searchAllEmp();
	}
	
	
	
	@RequestMapping(value="/deleteEmpbyId", method = RequestMethod.DELETE)
	public String DeleteEmpById(@RequestParam("en") int eno)
	{
		 empservice.DeleteEmpById(eno);
		 return "Data deleted successfully";
	}
	
	
	
	@RequestMapping(value="/updateempbyid", method = RequestMethod.PUT)
	public Employee updateEmpById(@RequestParam("en") int eno, @RequestBody Employee uiobj)
	{
		return empservice.updateEmpById(eno,uiobj);
	}
	
	
	
	@RequestMapping(value="/searchbyename", method = RequestMethod.GET)
	public Employee searchEmpByEname(@RequestParam("name") String ename)
	{
		return empservice.searchempbyname(ename);
	}
	
	
	
	@RequestMapping(value="/searchbyenamelist", method = RequestMethod.GET)
	public List<Employee> searchEmpByEnameList(@RequestParam("name") String ename,@RequestParam("sal") double sal)
	{
		return empservice.searchempbynamelist(ename,sal);
	}
	
	
	@RequestMapping(value="/searchbyesal", method = RequestMethod.GET)
	public List<Employee> searchEmpBySal(@RequestParam("sal") double sal)
	{
		return empservice.searchempbysal(sal);
	}
	
	
}
