package com.demo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

public class JDBCImpl {
	static String EMPLOYEE_INSERT_QUERY = "INSERT INTO EMPLOYEE VALUES(";
	static String EMPLOYEE_DELETE_QUERY = "DELETE FROM EMPLOYEE WHERE EID=";
	static String EMPLOYEE_UPDATE_QUERY = "UPDATE EMPLOYEE SET";
	static String EMPLOYEE_UPDATE_QUERY_WHERE_CONDITION= " WHERE EID=";
	
	static final private String CREATE_TABLE_SQL = "CREATE TABLE EMPLOYEE (  \r\n" + 
			"			EID INT  NOT NULL,  \r\n" + 
			"			ENAME VARCHAR (20) NOT NULL,  \r\n" + 
			"			EAGE INT  NOT NULL,  \r\n" + 
			"			EADDRESS CHAR (25),  \r\n" + 
			"			ECOMPANT CHAR (25),  \r\n" + 
			"			PRIMARY KEY (EID)  \r\n" + 
			"	)" ;
	
	static Connection connection=null; 
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
	if(connection==null) {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","root");
	}
		return connection;
	}
	
	static public void createTable() throws ClassNotFoundException, SQLException {
		Connection conn =null;
		Statement stmt =null;
		try {
			 conn = getConnection();
			stmt =conn.createStatement();
			stmt.execute(CREATE_TABLE_SQL);
			System.out.println("Table Created successfully...!");
		}catch(Exception e){
		}finally {
			if(conn!=null) {
				if(stmt!=null) {
					stmt.close();
				}
				conn.close();
			}
		}
		
	}
	
	public static boolean checkRecordExist(int empId) throws ClassNotFoundException, SQLException {
		String SELECT_SINGLE_RECORD = "SELECT * FROM EMPLOYEE WHERE EID="+empId;
		Connection conn = getConnection();
		Statement stmt = conn.createStatement();
		ResultSet resultset = stmt.executeQuery(SELECT_SINGLE_RECORD);
		return resultset.next();
	}
	
	static public void updateEmployeeRecords(Emp emp) throws ClassNotFoundException, SQLException {
		if(checkRecordExist(emp.getEmpId())) {
			EMPLOYEE_UPDATE_QUERY += " ENAME=\'"+emp.getEmpName()+"\', EAGE="+emp.getEmpAge()+", ECOMPANT=\'"+emp.getCompanyName()+"\', EADDRESS=\'"+emp.getEmpAddress()+"\'";
			EMPLOYEE_UPDATE_QUERY+=EMPLOYEE_UPDATE_QUERY_WHERE_CONDITION+emp.getEmpId();
			System.out.println(EMPLOYEE_UPDATE_QUERY);
			Connection conn = getConnection();
			Statement stmt = conn.createStatement();
			stmt.execute(EMPLOYEE_UPDATE_QUERY);
			System.out.println("Record updated successfully...!");
		}else {
			System.out.println("cannot update as record doent exist");
		}
		
	}
	
	
	static public void insertEmployeeRecords(Emp emp) throws ClassNotFoundException, SQLException {
		if(checkRecordExist(emp.getEmpId())) {
			System.out.println("record already exist...cannot use same number");
		}else {
		EMPLOYEE_INSERT_QUERY += emp.getEmpId()+",\'"+emp.getEmpName()+"\',"+emp.getEmpAge()+",\'"+emp.getEmpAddress()+"\',\'"+emp.getCompanyName()+"\')";
		System.out.println(EMPLOYEE_INSERT_QUERY);
		Connection conn = getConnection();
		Statement stmt = conn.createStatement();
		stmt.execute(EMPLOYEE_INSERT_QUERY);
		System.out.println("Record inserted successfully...!");
		}
		
	}
	
	
	static public void deleteEmployeeRecords(int empId) throws ClassNotFoundException, SQLException {
		if(checkRecordExist(empId)) {
			EMPLOYEE_DELETE_QUERY += empId;
			System.out.println(EMPLOYEE_DELETE_QUERY);
			Connection conn = getConnection();
			Statement stmt = conn.createStatement();
			stmt.execute(EMPLOYEE_DELETE_QUERY);
			System.out.println("Record deleted successfully...!");
		}else {
			System.out.println("cannot delete as record doent exist..!");
		}
	}
	
	
	public static  Emp[] getAllEmployees() throws SQLException, ClassNotFoundException {
		Emp [] employees = new Emp[10];
		String SELECT_ALL_RECORDS = "SELECT * FROM EMPLOYEE";
		Connection conn = getConnection();
		Statement stmt = conn.createStatement();
		ResultSet resultset = stmt.executeQuery(SELECT_ALL_RECORDS);
		Emp emp = null;
		int index =0;
		while(resultset.next()) {
			emp  = new Emp(resultset.getInt("eid"),resultset.getString("ename"),resultset.getString("eaddress"),resultset.getInt("eage"),resultset.getString("ecompant"));
			employees[index++]=emp;
		}
		return employees;
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		//createTable();
		//insertEmployeeRecords(new Emp(4,"satish","pune",29,"L&T"));
		//updateEmployeeRecords(new Emp(1,"shyam","Pune",29 , "TCS"));
		//deleteEmployeeRecords(2);
		
		//Emp[] employees = getAllEmployees();
		//System.out.println(Arrays.toString(employees));
		
	}
}