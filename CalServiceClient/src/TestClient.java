import java.net.MalformedURLException;
import java.rmi.RemoteException;

import org.apache.axis.AxisFault;

import com.service.CalServiceSoapBindingStub;

public class TestClient {
public static void main(String[] args) throws MalformedURLException, RemoteException {
	java.net.URL endPoint=new java.net.URL("http://localhost:8085/CalculatorService/services/CalService");
	org.apache.axis.client.Service  service=new org.apache.axis.client.Service();
	CalServiceSoapBindingStub stub=new CalServiceSoapBindingStub(endPoint,service);
	int addresult=stub.add(10, 10);
	System.out.println("Addition: "+addresult);
	int subResult=stub.sub(20,10);
	System.out.println("Substraction: "+subResult);
}
}
