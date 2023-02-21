/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.vromvrom.entities;

/**
 *
 * @author user
 */
public class Reservation {
    private int id_reservation;
    private int id_trajet;
    private int id_user;

    public Reservation() {
    }

    public Reservation(int id_reservation) {
        this.id_reservation = id_reservation;
    }

    public Reservation(int id_reservation, int id_trajet, int id_user) {
        this.id_reservation = id_reservation;
        this.id_trajet = id_trajet;
        this.id_user = id_user;
    }

    public Reservation(int id_trajet, int id_user) {
        this.id_trajet = id_trajet;
        this.id_user = id_user;
    }

    public int getId_reservation() {
        return id_reservation;
    }

    public int getId_trajet() {
        return id_trajet;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_reservation(int id_reservation) {
        this.id_reservation = id_reservation;
    }

    public void setId_trajet(int id_trajet) {
        this.id_trajet = id_trajet;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    @Override
    public String toString() {
        return "Reservation{" + "id_reservation=" + id_reservation + ", id_trajet=" + id_trajet + ", id_user=" + id_user + '}';
    }
    
    
    
}
