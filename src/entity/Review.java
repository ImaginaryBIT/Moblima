package entity;

import java.io.Serializable;

/**
 * 
 * @author Group5
 *
 */
public class Review implements Serializable{
	/**
	 * Used during deserialization to verify that the sender and receiver of a
	 * serialized object have loaded classes for that object that are compatible
	 * with respect to serialization
	 */
	private static final long serialVersionUID = 1L;
	/** Review Id */
	private int reviewId;
	/** User Rating */
	private float userRating;
	/** Comment */
	private String comment;
	/** User Name */
	private String userName;
	/** User Email */
    private String userEmail;
    
    
	/**
	 * Constructor to instantiate Review Object with following inputs
	 * @param reviewId
	 * @param userRating
	 * @param comment
	 * @param userName
	 * @param userEmail
	 */
	public Review(int reviewId, float userRating, String comment,
			String userName, String userEmail) {
		this.reviewId = reviewId;
		this.userRating = userRating;
		this.comment = comment;
		this.userName = userName;
		this.userEmail = userEmail;
	}

	/**
	 * @return the reviewId
	 */
	public int getReviewId() {
		return reviewId;
	}

	/**
	 * @param reviewId the reviewId to set
	 */
	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}

	/**
	 * @return the userRating
	 */
	public float getUserRating() {
		return userRating;
	}

	/**
	 * @param userRating the userRating to set
	 */
	public void setUserRating(float userRating) {
		this.userRating = userRating;
	}

	/**
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * @param comment the comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

	/**
	 * @return the userEmail
	 */
	public String getUserEmail() {
		return userEmail;
	}

	/**
	 * @param userEmail the userEmail to set
	 */
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	

}
