package entity;

import java.io.Serializable;
import java.util.List;

import utilities.Utilities;

/**
 * 
 * @author Group5
 * 
 */
public class Movie implements Serializable {

	/**
	 * Used during deserialization to verify that the sender and receiver of a
	 * serialized object have loaded classes for that object that are compatible
	 * with respect to serialization
	 */
	private static final long serialVersionUID = 1L;
	/** type of Movies  */
    public static final String BLOCKBUSTER = "Blockbuster";
    public static final String THREED = "3D";
    public static final String DIGITAL = "Digital";
	/** Movie Id */
	private int movieId;
	/** Movie Title */
	private String title;
	/** Movie Cast */
	private List<String> cast;
	/** Director of the Movie */
	private String director;
	/** Movie Language */
	private String language;
	/** Brief Summary of the Movie */
	private String synopsis;
	/** Movie Running Time (minute) */
	private int runningTime;
	/** Movie Reviews */
	private List<Review> reviews;
	/** Movie Type ( ) */
	private String movieType;
	/** Movie Restrict Level */
	private String rating;
	/** Show Times */
	private List<ShowTime> showTimes;
	/** Status */
	private String status;

	/* ******************** Constructors ******************** */

	/**
	 * @param movieId
	 * @param title
	 * @param cast
	 * @param director
	 * @param language
	 * @param synopsis
	 * @param runningTime
	 * @param overallUserRate
	 * @param reviews
	 * @param movieType
	 * @param rating
	 * @param showTimes
	 * @param status
	 */
	public Movie(int movieId, String title, List<String> cast, String director,
			String language, String synopsis, int runningTime,List<Review> reviews, String movieType,
			String rating, List<ShowTime> showTimes, String status) {

		this.movieId = movieId;
		this.title = title;
		this.cast = cast;
		this.director = director;
		this.language = language;
		this.synopsis = synopsis;
		this.runningTime = runningTime;
		this.reviews = reviews;
		this.movieType = movieType;
		this.rating = rating;
		this.showTimes = showTimes;
		this.status = status;
	}

	public Movie() {
		// TODO Auto-generated constructor stub
	}

	/* ******************** Getter and Setter Methods ******** */
	/**
	 * @return the movieId
	 */
	public int getMovieId() {
		return movieId;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @return the cast
	 */
	public List<String> getCast() {
		return cast;
	}

	/**
	 * @return the director
	 */
	public String getDirector() {
		return director;
	}

	/**
	 * @return the language
	 */
	public String getLanguage() {
		return language;
	}

	/**
	 * @return the synopsis
	 */
	public String getSynopsis() {
		return synopsis;
	}

	/**
	 * @return the runningTime
	 */
	public int getRunningTime() {
		return runningTime;
	}

	
	/**
	 * @return the reviews
	 */
	public List<Review> getReviews() {
		return reviews;
	}

	/**
	 * @return the movieType
	 */
	public String getMovieType() {
		return movieType;
	}

	/**
	 * @return the rating
	 */
	public String getRating() {
		return rating;
	}

	/**
	 * @return the showTimes
	 */
	public List<ShowTime> getShowTimes() {
		return showTimes;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param movieId
	 *            the movieId to set
	 */
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @param cast
	 *            the cast to set
	 */
	public void setCast(List<String> cast) {
		this.cast = cast;
	}

	/**
	 * @param director
	 *            the director to set
	 */
	public void setDirector(String director) {
		this.director = director;
	}

	/**
	 * @param language
	 *            the language to set
	 */
	public void setLanguage(String language) {
		this.language = language;
	}

	/**
	 * @param synopsis
	 *            the synopsis to set
	 */
	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	/**
	 * @param runningTime
	 *            the runningTime to set
	 */
	public void setRunningTime(int runningTime) {
		this.runningTime = runningTime;
	}

	
	/**
	 * @param reviews
	 *            the reviews to set
	 */
	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	/**
	 * @param movieType
	 *            the movieType to set
	 */
	public void setMovieType(String movieType) {
		this.movieType = movieType;
	}

	/**
	 * @param rating
	 *            the rating to set
	 */
	public void setRating(String rating) {
		this.rating = rating;
	}

	/**
	 * @param showTimes
	 *            the showTimes to set
	 */
	public void setShowTimes(List<ShowTime> showTimes) {
		this.showTimes = showTimes;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/* *******************Methods ********************** */
	/**
	 * Get the number of ticket sold
	 * 
	 * @return total number of ticket
	 */
	public int getTicketSold() {
		int total = 0;
		// loop through all the showTime and find the tickets that are sold
		for (int i = 0; i < showTimes.size(); i++) {
			ShowTime rv = (ShowTime) showTimes.get(i);
			total += rv.getNoOfTicketsSold();

		}
		return total;
	}

	/**
	 * Calculate Overall User Rating
	 * 
	 * @return rating
	 */
	public float getOverallUserRating() {
	
		int total_rating = 0;
		// loop through all reivew and sum total rating
		for (int i = 0; i < reviews.size(); i++) {
			Review rv = (Review) reviews.get(i);
			total_rating += rv.getUserRating();
		}
		// total rating devided by no is overall rating
		return total_rating / reviews.size();
	}

	/**
	 * Print Movie Detail
	 */
	public void showMovieDetail() {
		String rating = "NA";
		System.out.println("Moive ID    : " + this.movieId);
		System.out.println("Moive Title : " + this.title);
		System.out.println("Synopisis   : " + Utilities.wrap(this.synopsis));
		if (this.cast != null) {
			System.out.print("Actors 	    : ");
			for (String cast : this.cast) {
				System.out.print(cast + ", ");
			}
		}
		System.out.println("Director    : " + this.director);
		System.out.println("Language    : " + this.language);
		System.out.println("Type        : " + this.movieType);
		System.out.println("Rating      : " + this.rating);
		System.out.println("RunTime     : " + this.runningTime);
		float overallUserRating = this.getOverallUserRating();
		if (this.getOverallUserRating() > 0) {
			rating = String.valueOf(overallUserRating);
		}
		System.out.println("Rating      : " + rating);
		System.out.println("Status      : " + this.status);

	}
	
	public void showMovieDetailWithReview(){
		System.out.printf("%30s %10s%n", "Movie Name", "Movie Type");
		System.out.printf("%30 %10s%n", this.title, this.movieType);
		System.out.println("------------Reviews-------------");
		

		List<Review> reviewList = this.reviews;
		for (Review review : reviewList) {
			System.out.printf("Posted by: %50s Rate: %10d%n",
					review.getUserName(), review.getUserRating());
			System.out.printf("%150s%n", review.getContent());
			System.out.println();
		}
	}
	/**
	 * @method add review to movie
	 */
	public boolean addReview(String name, String email, float rating,
			String review) {
		for (Review rv : reviews) {
			if (rv.getUserEmail().equals(email)) {
				return false;
			}
		}
		int reviewId = reviews.size() + 1;
		reviews.add(new Review(reviewId, rating, review, name, email));
		return true;
	}
}
