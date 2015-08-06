import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import javax.naming.*;

public class WareHouseServer {
	public static void main(String[] args) throws RemoteException, NamingException {
		/*System.setProperty("java.security", "server.policy");
		System.setSecurityManager(new SecurityManager());*/
		
		System.out.println("创建服务器端实现...");
		
		WareHouseImpl backupWS = new WareHouseImpl(null);
		WareHouseImpl wareHouse1 = new WareHouseImpl(backupWS);
		
		wareHouse1.add("garmin", new Product("garmin 110", 200.0));
		backupWS.add("java", new Book("Core Java", 30.0,"1234565"));
		
		System.out.println("绑定服务端实现到注册表...");
		/*创建一个命名上下文，用来访问RMI注册表*/
		Context namingContext = new InitialContext();
		
		//解决端口没有注册，connection refused的问题
		
		LocateRegistry.createRegistry(1099);
		namingContext.bind("rmi://localhost:1099/wareHouseNO1", wareHouse1);
		System.out.println("等待远程客户端调用...");
	}
}
