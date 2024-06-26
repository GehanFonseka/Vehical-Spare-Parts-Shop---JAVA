package VehicleSparepart.model;

public class Feedback {

	private int feedbackID;
	private String userID; 
	private String productID; 
	private String ratings; 
	private String message; 
	private String feedbackDate;
	
	public Feedback(int feedbackID, String userID, String productID, String ratings, String message,
			String feedbackDate) {
		super();
		this.feedbackID = feedbackID;
		this.userID = userID;
		this.productID = productID;
		this.ratings = ratings;
		this.message = message;
		this.feedbackDate = feedbackDate;
	}

	public Feedback(String userID, String productID, String ratings, String message, String feedbackDate) {
		super();
		this.userID = userID;
		this.productID = productID;
		this.ratings = ratings;
		this.message = message;
		this.feedbackDate = feedbackDate;
	}

	public int getFeedbackID() {
		return feedbackID;
	}

	public void setFeedbackID(int feedbackID) {
		this.feedbackID = feedbackID;
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

	public String getRatings() {
		return ratings;
	}

	public void setRatings(String ratings) {
		this.ratings = ratings;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getFeedbackDate() {
		return feedbackDate;
	}

	public void setFeedbackDate(String feedbackDate) {
		this.feedbackDate = feedbackDate;
	}
	
	
}
