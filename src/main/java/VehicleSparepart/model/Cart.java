package VehicleSparepart.model;

public class Cart {

	private int cartID;
	private String userID; 
	private String productID; 
	private String productName;
	private String quantity;
	private String totalPrice;
	
	public Cart(int cartID, String userID, String productID, String productName, String quantity, String totalPrice) {
		super();
		this.cartID = cartID;
		this.userID = userID;
		this.productID = productID;
		this.productName = productName;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
	}

	public Cart(String userID, String productID, String productName, String quantity, String totalPrice) {
		super();
		this.userID = userID;
		this.productID = productID;
		this.productName = productName;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
	}

	public int getCartID() {
		return cartID;
	}

	public void setCartID(int cartID) {
		this.cartID = cartID;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getProductID() {
		return productID;
	}

	public void setProductID(String productID) {
		this.productID = productID;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	
}
