/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.vromvrom.utils;

/**
 *
 * @author USER
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MaConnexion {

    private final String url = "jdbc:mysql://localhost:3306/vromvrom";
    private final String login = "root";
    private final String pwd = "";

    private Connection cnx;

    private static MaConnexion instance;

    private MaConnexion(){
        try {
            cnx = DriverManager.getConnection(url, login, pwd);
            System.out.println("Connexion etablie !");
        } catch (SQLException e) {
            System.err.println("Erreur de connexion !");
            System.out.println(e.getMessage());
        }
    }

    public static MaConnexion getInstance(){
        if (instance == null) instance = new MaConnexion();
        return instance;
    }

    public Connection getCnx() {
        return cnx;
    }
}




