package com.service;

import java.net.MalformedURLException;
import java.rmi.RemoteException;

import org.apache.axis.AxisFault;

public class TestClient {
public static void main(String[] args) throws MalformedURLException, RemoteException {
	java.net.URL endPointUrl=new java.net.URL("http://localhost:8085/CalculatorService/services/CalService");
	org.apache.axis.client.Service service=new org.apache.axis.client.Service();
	
	CalServiceSoapBindingStub stub=new CalServiceSoapBindingStub(endPointUrl,service);
	
	int addResult=stub.add(10, 20);
	System.out.println("Add result: "+addResult);
	
	int subResult=stub.sub(20, 10);
	System.out.println("Add result: "+subResult);
}
}
