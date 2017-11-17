/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testing;

import java.util.ArrayList;
import java.util.List;

import database.SerializeDB;
import entity.MovieGoer;
import entity.Ticket;
import entity.Transaction;
import java.util.Date;

/**
 *
 * @author nyinyithwin
 */
public class PopulateMovieGoer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /////////////////////////////// MovieGoer //////////////////////////////////////////
        // Create new data
        List<MovieGoer> moveGoerList = new ArrayList<>();
        MovieGoer MovieGoer = new MovieGoer("thiwn","thwin",123);
        // add to list
        moveGoerList.add(MovieGoer);

        SerializeDB.writeSerializedObject("MovieGoer.ser", moveGoerList);
        List<MovieGoer> mgList = (ArrayList<MovieGoer>) SerializeDB
                .readSerializedObject("MovieGoer.ser");
        List<Ticket> tickets = new ArrayList<>();
        
        mgList.add(MovieGoer);
        SerializeDB.writeSerializedObject("MovieGoer.ser", mgList);
    }
    
}
