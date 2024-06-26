package VehicleSparepart.model;

public class Payment {
	
	private int paymentID;
	private String userID; 
	private String paymentAmount; 
	private String paymentMethod; 
	private String paymentDate;
	
	public Payment(int paymentID, String userID, String paymentAmount, String paymentMethod, String paymentDate) {
		super();
		this.paymentID = paymentID;
		this.userID = userID;
		this.paymentAmount = paymentAmount;
		this.paymentMethod = paymentMethod;
		this.paymentDate = paymentDate;
	}

	public Payment(String userID, String paymentAmount, String paymentMethod, String paymentDate) {
		super();
		this.userID = userID;
		this.paymentAmount = paymentAmount;
		this.paymentMethod = paymentMethod;
		this.paymentDate = paymentDate;
	}

	public int getPaymentID() {
		return paymentID;
	}

	public void setPaymentID(int paymentID) {
		this.paymentID = paymentID;
	}

	public String getuserID() {
		return userID;
	}

	public void setuserID(String userID) {
		this.userID = userID;
	}

	public String getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(String paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}
	
	
	
}
