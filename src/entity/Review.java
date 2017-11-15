package entity;

public class Review {
	private int reviewId;
	private float userRating;
	private String review;
	private String userName;
        private String userEmail;

	public Review(int reviewId, float userRating, String reviewContent, String name, String email) {
		this.reviewId = reviewId;
                this.review = reviewContent;
		this.userRating = userRating;
		this.userName = name;
                this.userEmail = email;
	}

	public String getContent() {
		return review;
	}
	public float getUserRating()
	{
		return userRating;
	}
	public String getUserName()
	{
		return userName;
	}
        
        public String getUserEmail()
	{
		return userEmail;
	}
}
