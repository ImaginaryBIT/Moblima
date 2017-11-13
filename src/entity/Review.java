package entity;

/**
 * 
 * @author Group5
 *
 */

public class Review {
	/** Review Id */
	private int reviewId;
	/** User Rating */
	private int userRating;
	/** Review Content*/
	private String review;
	/** MovieGoer */
	private MovieGoer movieGoer;
	
	
	/* ******************** Constructors *********************/
	/**
	 * @param reviewContent
	 * @param userRating
	 * @param movieGoer
	 */

	public Review(String reviewContent, int userRating, MovieGoer movieGoer) {
		this.review = reviewContent;
		this.userRating = userRating;
		this.movieGoer = movieGoer;
	}

	
	/* ******************** Getter and Setter Methods *********/
	/**
	 * @return the review
	 */
	public String getContent() {
		return review;
	}
	
	/**
	 * @return the userRating
	 */
	public int getUserRating()
	{
		return userRating;
	}
	
	/**
	 * @return the movieGoer
	 */
	public MovieGoer getMovieGoer()
	{
		return movieGoer;
	}
}
