

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface WareHouse extends Remote{
	double getPrice(String desc) throws RemoteException;
	Product getProduct(List<String> keywords) throws RemoteException;
}
