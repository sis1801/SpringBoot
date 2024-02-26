package com.enumtech.MyFirstCrud.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Builder;

@Builder
@Entity
public class Employee 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int eno;
	
	private String ename;
	
	private double sal;

	public int getEno() {
		return eno;
	}

	public void setEno(int eno) {
		this.eno = eno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public double getSal() {
		return sal;
	}

	public void setSal(double sal) {
		this.sal = sal;
	}
	public Employee () { }
	public Employee(String ename, double sal) {
		super();
		this.ename = ename;
		this.sal = sal;
	}
	

	@Override
	public String toString() {
		return "Employee [eno=" + eno + ", ename=" + ename + ", sal=" + sal + "]";
	}

	public Employee(int eno, String ename, double sal) {
		super();
		this.eno = eno;
		this.ename = ename;
		this.sal = sal;
	}
	
}