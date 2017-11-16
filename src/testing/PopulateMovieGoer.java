/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testing;

import database.SerializeDB;
import entity.MovieGoer;
import java.util.ArrayList;

/**
 *
 * @author nyinyithwin
 */
public class PopulateMovieGoer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        /////////////////////////////// STAFF //////////////////////////////////////////
        // Create new data
        ArrayList moveGoerList = new ArrayList();
        MovieGoer MovieGoer = new MovieGoer("thiwn","thwin",123);
        // add to list
        moveGoerList.add(MovieGoer);

        SerializeDB.writeSerializedObject("MovieGoer.ser", moveGoerList);
    }
    
}
