

public class Book extends Product {

	private String isbn;

	public Book(String desc, double price,String isbn) {
		super(desc, price);
		this.isbn = isbn;
	}

	public String getDesc() {
		return super.getDesc() + " ISBN:" + isbn;
	}
}
