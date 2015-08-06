import java.rmi.RemoteException;
import java.util.Arrays;
import java.util.Enumeration;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NameClassPair;
import javax.naming.NamingException;


public class WareHouseClient {

	public static void main(String[] args) throws NamingException, RemoteException {
		/*System.setProperty("java.security", "client.policy");
		System.setSecurityManager(new SecurityManager());
		*/
		Context namingContext = new InitialContext();
		
		System.out.println("rmi注册表上的所有对象:");
		Enumeration<NameClassPair> e = namingContext.list("rmi://localhost/");
		while(e.hasMoreElements()){
			System.out.println(e.nextElement().getName());
		}
		
		//客户端在rmi注册表上查找远程对象
		String url = "rmi:wareHouseNO1";
		
		//返回给定名字的对象
		WareHouse wareHouse1 = (WareHouse) namingContext.lookup(url);
		
		String desc = "test";
		Product p = wareHouse1.getProduct(Arrays.asList("min","gar","haha"));
		System.out.println(p.getDesc());
	}

}
