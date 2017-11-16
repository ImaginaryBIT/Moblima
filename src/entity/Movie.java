package entity;

import java.io.Serializable;
import java.util.List;

import utilities.Utilities;

/**
 * Represents a movie. Contains Review and ShowTime lists. Used to query a
 * movie's show time and review
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
	/** type of Movies */
	public static final String BLOCKBUSTER = "Blockbuster";
	public static final String THREED = "3D";
	public static final String DIGITAL = "Digital";
	/** Movie Id */
	private int movieId;
	/** Movie Title */
	private String title;
	/** List of casts in this movie */
	private List<String> cast;
	/** Director of the Movie */
	private String director;
	/** Language of this movie */
	private String language;
	/** Brief Summary of the Movie */
	private String synopsis;
	/** Movie Running Time (minute) */
	private int runningTime;
	/** List of reviews for this movie */
	private List<Review> reviews;
	/** Movie Type ( ) */
	private String movieType;
	/** Movie Restrict Level */
	private String rating;
	/** Show Times */
	private List<ShowTime> showTimes;
	/** Showing status of this movie */
	private String status;

	/* ******************** Constructors ******************** */

	/**
	 * This constructs a movie object with following details
	 * @param movieId The ID of this movie
	 * @param title The movie's title
	 * @param cast The list of casts
	 * @param director The director 
	 * @param language The language this movie is in
	 * @param synopsis The brief summary of this movie
	 * @param runningTime The running time in minute 
	 * @param overallUserRate The overall user rating
	 * @param reviews The list of reviews for this movie
	 * @param movie Type The movie type
	 * @param rating The restrict level
	 * @param showTimes The list of show time
	 * @param status The showing status of this movie
	 */
	public Movie(int movieId, String title, List<String> cast, String director, String language, String synopsis,
			int runningTime, List<Review> reviews, String movieType, String rating, List<ShowTime> showTimes,
			String status) {

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
	 * Gets the ID of this movie
	 * @return movieId The ID of this movie
	 */
	public int getMovieId() {
		return movieId;
	}

	/**
	 * Gets the title of this movie
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Gets the list of casts in this movie
	 * @return the cast
	 */
	public List<String> getCast() {
		return cast;
	}

	/**
	 * Gets the director
	 * @return the director
	 */
	public String getDirector() {
		return director;
	}

	/**
	 * Gets the language this movie is in
	 * @return the language
	 */
	public String getLanguage() {
		return language;
	}

	/**
	 * Gets the brief summary of this movie
	 * @return the synopsis
	 */
	public String getSynopsis() {
		return synopsis;
	}

	/**
	 * Gets the running time in minute
	 * @return the runningTime
	 */
	public int getRunningTime() {
		return runningTime;
	}

	/**
	 * Gets a list of all reviews
	 * @return the reviews
	 */
	public List<Review> getReviews() {
		return reviews;
	}

	/**
	 * Gets the type of this movie
	 * @return the movieType
	 */
	public String getMovieType() {
		return movieType;
	}

	/**
	 * Gets the movie's restrict level
	 * @return the rating
	 */
	public String getRating() {
		return rating;
	}

	/**
	 * Gets the date and time this movie is shown
	 * @return the showTimes
	 */
	public List<ShowTime> getShowTimes() {
		return showTimes;
	}

	/**
	 * Gets the showing status of this movie
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Changes the ID of this movie
	 * @param movieId the movieId to set
	 */
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	/**
	 * Changes the title
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Changes the list of casts
	 * @param cast the cast to set
	 */
	public void setCast(List<String> cast) {
		this.cast = cast;
	}

	/**
	 * Changes the director's name
	 * @param director the director to set
	 */
	public void setDirector(String director) {
		this.director = director;
	}

	/**
	 * Changes the language this movie is in
	 * @param language the language to set
	 */
	public void setLanguage(String language) {
		this.language = language;
	}

	/**
	 * Changes the summary of the movie
	 * @param synopsis the synopsis to set
	 */
	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	/**
	 * Changes the running time in minute
	 * @param runningTime the runningTime to set
	 */
	public void setRunningTime(int runningTime) {
		this.runningTime = runningTime;
	}

	/**
	 * Changes the list of all reviews for this movie
	 * @param reviews the reviews to set
	 */
	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	/**
	 * Changes the movie's type
	 * @param movieType the movieType to set
	 */
	public void setMovieType(String movieType) {
		this.movieType = movieType;
	}

	/**
	 * Changes the restrict level
	 * @param rating the rating to set
	 */
	public void setRating(String rating) {
		this.rating = rating;
	}

	/**
	 * Changes the list of show time
	 * @param showTimes the showTimes to set
	 */
	public void setShowTimes(List<ShowTime> showTimes) {
		this.showTimes = showTimes;
	}

	/**
	 * Changes the showing status of this movie
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/* ******************* Other Methods ********************** */
	/**
	 * Get the number of ticket sold	
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
     * This calculate the overall user rate 
     * based on the rate that user submitted for this movie
     * which is stored in the review list
	 * @return the overallUserRate
	 */
	public float getOverallUserRating() {

		float totalRating = 0;
		if(reviews.isEmpty()) {
			return 0;
		}
		for (Review review : reviews){
			totalRating += review.getUserRating();
		}
		return totalRating / reviews.size();
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
	
	/**
    * This shows a movie with its details along with reviews
	 */
	public void showMovieDetailWithReview(){
		//System.out.printf("%s %30s%n", "Movie Name", "Movie Type");
		//System.out.printf("%s %20s%n", this.title, this.movieType);
                showMovieDetail();
		System.out.println("------------Reviews-------------");
		

		List<Review> reviewList = this.reviews;
		for (Review review : reviewList) {
			System.out.println("Posted by: "+review.getUserName());
                        System.out.println("Rating: "+review.getUserRating());
			System.out.println("Review:\n"+ review.getComment());
			System.out.println();
		}
	}

	/**
	 * @method This add new review to this movie
	 * @param name Name of the reviewer
	 * @param email Email of the reviewer
	 * @param review The content of this new review
	 */
	public boolean addReview(String name, String email, float rating, String review) {
		
		int reviewId = reviews.size() + 1;
		reviews.add(new Review(reviewId, rating, review, name, email));
		return true;
	}
}
