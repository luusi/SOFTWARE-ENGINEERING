/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.clientjuly;

/**
 *
 * @author studente
 */
import com.mycompany.july.Director;
import com.mycompany.july.WSInterface;
import com.mycompany.july.WSImplService;
import com.mycompany.july.Movie;
import java.util.LinkedList;
import java.util.List;


public class Client {
    public static void main(String[] args) {
        List<Integer> movies = new LinkedList<>();
        try {
            WSImplService service = new WSImplService();
            WSInterface port = service.getWSImplPort();
            
            movies = port.getMovies();
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        Director director;
        Movie movie;
        for(int i = 0; i < movies.size(); i++) {
            try {
                WSImplService service = new WSImplService();
                WSInterface port = service.getWSImplPort();
                
                movie = port.getMovie(movies.get(i));
                director = port.getDirector(movie.getDirectorID());

                System.out.println("Movie " + movie.getID() + ": "
                                   + movie.getTitle() + " (" + movie.getYear() + ")\n"
                                   + "Director " + director.getID() + ": "
                                   + director.getName() + " (" + director.getYearOfBirth() + ")\n");

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
    
