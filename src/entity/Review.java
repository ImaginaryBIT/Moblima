package entity;

public class Review {
	private int reviewId;
	private int userRating;
	private String review;
	private MovieGoer movieGoer;

	public Review(String reviewContent, int userRating, MovieGoer movieGoer) {
		this.review = reviewContent;
		this.userRating = userRating;
		this.movieGoer = movieGoer;
	}

	public String getContent() {
		return review;
	}
	public int getUserRating()
	{
		return userRating;
	}
	public MovieGoer getMovieGoer()
	{
		return movieGoer;
	}
}
