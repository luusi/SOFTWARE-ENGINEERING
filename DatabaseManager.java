/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dbmsjuly;

/**
 *
 * @author studente
 */
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseManager {
    public static String url = "jdbc:sqlite:/home/studente/database4.db";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        createDB();
        createTables();
        initTables();
    }

    public static void createDB() {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection(DatabaseManager.url);

            System.out.println("A new database has been created.");

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void createTables() {
        String sql = "CREATE TABLE IF NOT EXISTS DIRECTORS("
                + "ID numeric PRIMARY KEY, "
                + "name varchar(300),"
                + "yearOfBirth varchar(300));";

        try {
            Connection conn = DriverManager.getConnection(DatabaseManager.url);
            Statement stat = conn.createStatement();
            stat.execute(sql);

        } catch (SQLException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        sql = "CREATE TABLE IF NOT EXISTS MOVIES("
                + "ID numeric PRIMARY KEY, "
                + "title varchar(300),"
                + "directorID varchar(300),"
                + "year varchar(300),"
               
                + "FOREIGN KEY(directorID)  REFERENCES DIRECTORS(id));";
        try {
            Connection conn = DriverManager.getConnection(DatabaseManager.url);
            Statement stat = conn.createStatement();
            stat.execute(sql);

        } catch (SQLException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void initTables() {
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(DatabaseManager.url);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        for (int i = 1; i < 16; i++) {
            try {
                PreparedStatement prepStat = conn.prepareStatement("INSERT INTO DIRECTORS(ID,name,yearOfBirth) values (?, ?, ?);");
                prepStat.setInt(1, i);
                prepStat.setString(2, "name_" + i);
                prepStat.setString(3, "yearOfBirth_" + i);
                prepStat.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        for (int i = 1; i < 16; i++) {
            try {
                PreparedStatement prepStat = conn.prepareStatement("INSERT INTO MOVIES(ID,title,managerID,year) values (?, ?, ?, ?);");
                prepStat.setInt(1, i);
                prepStat.setString(2, "title_" + i);
                prepStat.setString(3, "directorID_ " + i);
                prepStat.setString(4, "year_ " +i );
                prepStat.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
}
