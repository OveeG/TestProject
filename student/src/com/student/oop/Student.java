package com.student.oop;

public class Student {

	private int studId;
	private String studName;
	private int studAge;
	static private String studCollege = "PICT";
	private double studFees;
	private Address address;
	
	
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(int studId, String studName, int studAge, double studFees, Address address) {
		super();
		this.studId = studId;
		this.studName = studName;
		this.studAge = studAge;
		this.studFees = studFees;
		this.address = address;
	}
	
	
	@Override
	public String toString() {
		return "\nStudent [studId=" + studId + ", studName=" + studName + ", studAge=" + studAge + ", studFees="
				+ studFees + ", address=" + address + "]";
	}
	public int getStudId() {
		return studId;
	}
	public void setStudId(int studId) {
		this.studId = studId;
	}
	public String getStudName() {
		return studName;
	}
	public void setStudName(String studName) {
		this.studName = studName;
	}
	public int getStudAge() {
		return studAge;
	}
	public void setStudAge(int studAge) {
		this.studAge = studAge;
	}
	public String getStudCollege() {
		return studCollege;
	}
	public void setStudCollege(String studCollege) {
		this.studCollege = studCollege;
	}
	public double getStudFees() {
		return studFees;
	}
	public void setStudFees(double studFees) {
		this.studFees = studFees;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
}