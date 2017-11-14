package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Group5
 *
 */
public class Movie implements Serializable {
	/**
	 * Used during deserialization to verify that the sender and receiver of a serialized object have loaded 
	 * classes for that object that are compatible with respect to serialization 
	 */
	private static final long serialVersionUID = 1L;
	
	/** Movie Id */
	private int movieId;
	/** Movie Title */
	private String title;
	/** Movie Cast */
	private String[] cast;
	/** Director of the Movie */
	private String director;
	/** Movie Language */
	private String language;
	/** Brief Summary of the Movie */
	private String synopsis;
	/** Movie Running Time (minute) */
	private int runningTime;
	/** Overall User Rating  */
	private float overallUserRate;
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
	

	/* ******************** Constructors *********************/

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
	public Movie(int movieId, String title, String[] cast, String director,
			String language, String synopsis, int runningTime,
			float overallUserRate, ArrayList<Review> reviews, String movieType,
			String rating, ArrayList<ShowTime> showTimes, String status) {

		this.movieId = movieId;
		this.title = title;
		this.cast = cast;
		this.director = director;
		this.language = language;
		this.synopsis = synopsis;
		this.runningTime = runningTime;
		this.overallUserRate = overallUserRate;
		this.reviews = reviews;
		this.movieType = movieType;
		this.rating = rating;
		this.showTimes = showTimes;
		this.status = status;
	}


	/* ******************** Getter and Setter Methods *********/
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
	public String[] getCast() {
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
	 * @return the overallUserRate
	 */
	public float getOverallUserRate() {
		return overallUserRate;
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
	 * @param movieId the movieId to set
	 */
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}


	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}


	/**
	 * @param cast the cast to set
	 */
	public void setCast(String[] cast) {
		this.cast = cast;
	}


	/**
	 * @param director the director to set
	 */
	public void setDirector(String director) {
		this.director = director;
	}


	/**
	 * @param language the language to set
	 */
	public void setLanguage(String language) {
		this.language = language;
	}


	/**
	 * @param synopsis the synopsis to set
	 */
	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}


	/**
	 * @param runningTime the runningTime to set
	 */
	public void setRunningTime(int runningTime) {
		this.runningTime = runningTime;
	}


	/**
	 * @param overallUserRate the overallUserRate to set
	 */
	public void setOverallUserRate(float overallUserRate) {
		this.overallUserRate = overallUserRate;
	}


	/**
	 * @param reviews the reviews to set
	 */
	public void setReviews(ArrayList<Review> reviews) {
		this.reviews = reviews;
	}


	/**
	 * @param movieType the movieType to set
	 */
	public void setMovieType(String movieType) {
		this.movieType = movieType;
	}


	/**
	 * @param rating the rating to set
	 */
	public void setRating(String rating) {
		this.rating = rating;
	}


	/**
	 * @param showTimes the showTimes to set
	 */
	public void setShowTimes(ArrayList<ShowTime> showTimes) {
		this.showTimes = showTimes;
	}


	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
	/* *******************Methods ***********************/
	
	

}
