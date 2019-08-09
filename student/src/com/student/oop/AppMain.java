package com.student.oop;

import java.util.Arrays;
import java.util.Scanner;

public class AppMain {

	
public static void main(String[] args) {
	  Scanner scanner = new Scanner(System.in);
	  System.out.println("***Create Student ID****");
	  System.out.println("Enter No. of students you want enter :  ");
	  int nostud =scanner.nextInt();
	  StudentServiceImpl impl=new StudentServiceImpl(nostud); 

	  for(int i=0;i<nostud;i++) { // will iterate no of times 
	  //stud 
		  
	 /*int counter = 0; 
	   
	  while(true) {
		 counter++; 
	*/ 
	   System.out.println("Enter studId");
	   int stId = scanner.nextInt();
	   System.out.println("Enter studName");
	   String stName = scanner.next(); 
	   System.out.println("Enter studAge"); 
	   int stAge =scanner.nextInt(); 
	   System.out.println("Enter studFees"); 
	   double stFees =scanner.nextDouble(); 
	   
	   //Address 
	   System.out.println("Enter AddressId"); 
	   int aid = scanner.nextInt();
	   System.out.println("Enter studPincode"); 
	   int stPincode = scanner.nextInt(); 
	   System.out.println("Enter studCity"); 
	   String stState = scanner.next();
	  
	   Address address = new Address(aid, stState, stPincode);
	  
	   Student st = new Student(stId,stName,stAge,stFees,address);
	  
	   System.out.println(impl.addStudent(st));
	   /*if(counter%2==0) { 
		  System.out.println("Do you want to continue...Zero for Break...or else continue!"); 
		  int no= scanner.nextInt();
		  if(no==0) { 
			  break; 
			  } 
		  }*/
	  
	  }
	  StudentServiceImpl.operation();
	  System.out.println("Select choice ");  
	  
	  while(true) {
		  int ch=scanner.nextInt();	 
	  switch(ch) {
	       
	  case 1:
		    System.out.println("UPDATE STUDENT");
		   
		    System.out.println("Enter student id to be update");
		    int stdUid=scanner.nextInt();
		    
		    Address address=new Address(10, "Jaipur", 410505);
		    Student newSt =new Student(stdUid, "Ganesh", 23, 50000.50,address );
		    System.out.println(impl.updateStudent(newSt)); 
		    break;
	  case 2:
		    System.out.println("DELETE STUDENT");
		    System.out.println("Enter student id to be deleted");
		    int stDid=scanner.nextInt();
		    System.out.println(impl.deleteStudent(stDid)); 
		   
		    break;
		     
	  case 3:
		    System.out.println("SELECT STUDENT");
		    System.out.println("Enter student id");
		    int stGid=scanner.nextInt();
		    System.out.println(impl.getStudent(stGid)); 
		    break;
		     
	  case 4:
		    System.out.println("SHOWALL STUDENT");
		    System.out.println(Arrays.toString(impl.getStudents()));
		    break;
	  case 5: 
		    System.out.println("DO YOU WANT TO CONTINUE...Y/N");
		    String s=scanner.next();
		    if(s.equalsIgnoreCase("y")){
		    	impl.operation();
		    }
		    else
		    {
		    	System.exit(0);
		    }
		    break;
	  }
	  impl.operation();
	  }
	
	 }
}



