package com.demo.jdbc;

public class Emp {
	private int empId;
	private String empName;
	private String empAddress;
	private int empAge;
	private String companyName;
	
	public Emp() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Emp(int empId, String empName, String empAddress, int empAge, String companyName) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empAddress = empAddress;
		this.empAge = empAge;
		this.companyName = companyName;
	}
	
	@Override
	public String toString() {
		return "\n [empId=" + empId + ", empName=" + empName + ", empAddress=" + empAddress + ", empAge=" + empAge
				+ ", companyName=" + companyName + "]";
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpAddress() {
		return empAddress;
	}
	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}
	public int getEmpAge() {
		return empAge;
	}
	public void setEmpAge(int empAge) {
		this.empAge = empAge;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
}
