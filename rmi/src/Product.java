

import java.io.Serializable;

public class Product implements Serializable{

	private String desc;
	private double price;
	private WareHouse location;
	
	
	public Product(String desc, double price) {
		this.desc = desc;
		this.price = price;
	}
	
	
	public String getDesc() {
		return desc;
	}
	
	public double getPrice() {
		return price;
	}

	public WareHouse getLocation() {
		return location;
	}
	public void setLocation(WareHouse location) {
		this.location = location;
	}
	
	
	
}
