/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testing;

/**
 *
 * @author nyinyithwin
 */
public class PopulateData {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String[] arg = new String[1];
        CreateSystemSetting.main(arg);
        PopulateCinema.main(arg);
        PopulateMovie.main(arg);
        PopulateMovieGoer.main(arg);
        PopulateStaff.main(arg);
    }
    
}
