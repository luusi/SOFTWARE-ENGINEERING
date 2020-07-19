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
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Movie")
public class Movie {
    private int ID;
    private String title;
    private String year;
    private int directorID;

    public Movie(int ID, String title, String year, int directorID) {
        this.ID = ID;
        this.title = title;
        this.year = year;
        this.directorID = directorID;
        
    }

    public Movie() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public int getDirectorID() {
        return directorID;
    }

    public void setDirectorID(int directorID) {
        this.directorID = directorID;
    }
     @Override
    public String toString() {
        return "Movie{" + "ID=" + ID + ", title=" + title + ", year=" + year + ", directorID=" + directorID + '}';
    }
    
}
