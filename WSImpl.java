/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.july;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;

/**
 *
 * @author studente
 */
@WebService(endpointInterface = "com.mycompany.july.WSInterface")
public class WSImpl implements WSInterface {
    private Connection connection = null;

    public WSImpl() {
        try {
            Class.forName("org.sqlite.JDBC");

            connection = DriverManager.getConnection("jdbc:sqlite:/home/studente/database.db");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public Director getDirector(int ID) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM DIRECTORS WHERE ID = ?;");
            statement.setInt(1, ID);
            statement.setQueryTimeout(30);

            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return new Director(rs.getInt("ID"),
                        rs.getString("name"),
                        rs.getString("yearOfBirth"));
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return null;
    }

    public Movie getMovie(int ID) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM MOVIES WHERE ID = ?;");
            statement.setInt(1, ID);
            statement.setQueryTimeout(30);

            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return new Movie(rs.getInt("ID"),
                        rs.getString("title"),
                        rs.getString("year"),
                        rs.getInt("directorID"));
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return null;
    }

    @Override
    public List<Integer> getMovies() {
        ArrayList<Integer> movies = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);
            ResultSet rs = statement.executeQuery("SELECT ID FROM MOVIES;");
            while (rs.next()) {
                movies.add(rs.getInt("ID"));
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return movies;
    }

    public void close() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
    
}
