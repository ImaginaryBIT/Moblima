package application;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import database.SerializeDB;
import entity.Movie;
import entity.ShowTime;

public class MovieController {

	private List<Movie> list;
	private String name, cast, director, plot, rating, status, cinema;
	private float price;
	// private float userRate;
	Scanner sc = new Scanner(System.in);

	// private long movieRevenue
	public Movie findMovie(String movieName, String movieType) {
		Movie movie = new Movie(movieName, movieType);
		return movie;
	}

	public ArrayList<Movie> showAllMovie() {
		return null;
	}

	public void addMovie() {
	}

	public void updateMovie() {
	}
	
	public ArrayList<ShowTime> getShowTime(int movieId)
	{
		return null;
	}
	
	public ArrayList<Movie> getTopFive(String rankBy)
	{
		return null;
	}
}
