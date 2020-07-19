/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.july;

/**
 *
 * @author studente
 */
import java.util.List;
import javax.jws.WebService;

@WebService
public interface WSInterface {

    public Director getDirector(int ID);

    public Movie getMovie(int ID);

    public List<Integer> getMovies();

}
