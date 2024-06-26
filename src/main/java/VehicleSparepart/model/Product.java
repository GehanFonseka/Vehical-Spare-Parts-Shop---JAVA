package VehicleSparepart.model;

public class Product {
	
	private int productID;
	private String productName;
	private String description;
	private String category;
	private String price; 
	private String quantity;
	private String userID;
	
	public Product(int productID, String productName, String description, String category, String price,
			String quantity, String userID) {
		super();
		this.productID = productID;
		this.productName = productName;
		this.description = description;
		this.category = category;
		this.price = price;
		this.quantity = quantity;
		this.userID = userID;
	}

	public Product(String productName, String description, String category, String price, String quantity,
			String userID) {
		super();
		this.productName = productName;
		this.description = description;
		this.category = category;
		this.price = price;
		this.quantity = quantity;
		this.userID = userID;
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}
	
	

}
