package com.student.oop;

public abstract class StudentService {
	public abstract String addStudent(Student student);
	public abstract Student getStudent(int studId);
	public abstract Student[] getStudents();
	public abstract Student updateStudent(Student student);
	public abstract String deleteStudent(int studId);
}
