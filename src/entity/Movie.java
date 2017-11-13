package entity;

import java.io.*;
import java.util.ArrayList;

public class Movie implements Serializable {

	private int movieId;
	private String title;
	private String[] cast;
	private String director;
	private String[] language;
	private String synopsis;
	private int runningTime;
	private float overallUserRating;
	private ArrayList<Review> reviews;
	private String movieType;
	private String retrictLevel;
	private ArrayList<ShowTime> showTime;
	private String status;
	private int numOfMovies;

	public Movie(String title, String movieType) {
		setMovieTitle(title);
		setMovieType(movieType);
	}

	// All the gets methods
	public int getMovieID() {
		return movieId;
	}

	public String getMovieTitle() {
		return title;
	}

	public String[] getCast()// String[] getCast()
	{
		return cast;
	}

	public String getMovieDirector() {
		return director;
	}

	public String[] getLanguage() {
		return language;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public int getRunningTime() {
		return runningTime;
	}

	public float getOverallUserRating() {
		return overallUserRating;
	}

	public ArrayList<Review> getReviews() {		
		return reviews;
	}

	public String getMovieType() {
		return movieType;
	}

	public String restrictLevel() {
		return retrictLevel;
	}

	public ArrayList<ShowTime> getShowTime() {
		return showTime;
	}

	public String getStatus() {
		return status;
	}

	// All the set methods
	public void setMovieID(int movieId) {
		this.movieId = movieId;
	}

	public void setMovieTitle(String title) {
		this.title = title;
	}

	public void setCast(String[] cast) {
		this.cast = cast;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public void setLanguage(String[] languages) {
		this.language = languages;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	public void setRunningTime(int runningTime) {
		this.runningTime = runningTime;
	}

	public void setOverallUserRating(float overallUserRating) {
		this.overallUserRating = overallUserRating;
	}

	public void setReview(String reviewContent, int userRating, MovieGoer movieGoer) {
		Review reviewObj = new Review(reviewContent, userRating, movieGoer);
		reviews.add(reviewObj);
	}

	public void setMovieType(String movieType) {
		this.movieType = movieType;
	}

	public void setRestrictLevel(String restrictLevel) {
		this.retrictLevel = restrictLevel;
	}

	public void setShowTime(ArrayList<ShowTime> showTime) {//temp
		this.showTime = showTime;
	}

	public void setStatus(String movieStatus) {
		this.status = movieStatus;
	}
	
	public String getMovieDetails()
	{
		return "Review";
	}
	
	public void getNumMovies()
	{
		
	}

	/*public boolean equals(Object o) {
		if (o instanceof Movie) {
			Movie p = (Movie) o;
			return (getMovieName().equals(p.getMovieName()));
		}
		return false;
	}*/
}