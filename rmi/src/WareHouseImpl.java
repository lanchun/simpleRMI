import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WareHouseImpl extends UnicastRemoteObject implements WareHouse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3409160775463152207L;
	private Map<String, Product> products;
	private WareHouse backup;

	protected WareHouseImpl(WareHouse backup) throws RemoteException {

		products = new HashMap<>();
		this.backup = backup;
	}

	public void add(String keyword, Product product) {
		product.setLocation(this);
		products.put(keyword, product);
	}

	@Override
	public double getPrice(String desc) throws RemoteException {
		for (Product p : products.values()) {
			if (p.getDesc().equals(desc))
				return p.getPrice();
		}
		if (backup == null)
			return 0;
		else
			return backup.getPrice(desc);
	}

	@Override
	public Product getProduct(List<String> keywords) throws RemoteException {
		for (String keyword : keywords) {
			Product p = products.get(keyword);
			if (p != null)
				return p;
		}

		if (backup != null)
			return backup.getProduct(keywords);
		else if (products.values().size() > 0)
			return products.values().iterator().next();
		else
			return null;
	}

}
