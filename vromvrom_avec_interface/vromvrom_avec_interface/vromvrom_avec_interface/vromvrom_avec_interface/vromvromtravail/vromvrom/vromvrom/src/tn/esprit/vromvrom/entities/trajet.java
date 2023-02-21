/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.vromvrom.entities;

import java.util.Objects;

/**
 *
 * @author user
 */
public class trajet {
            private String Ville_depart;
            private String Ville_darrive;
            private float Prix;
            private int Nbr_place;
            private int Id_user;
            private int Id_trajet;
            
            private int Duree_pose;
             private String  Mode_paiement;

    public trajet(String Ville_depart, String Ville_darrive, float Prix, int Nbr_place, int Duree_pose, String Mode_paiement) {
        this.Ville_depart = Ville_depart;
        this.Ville_darrive = Ville_darrive;
        this.Prix = Prix;
        this.Nbr_place = Nbr_place;
        this.Duree_pose = Duree_pose;
        this.Mode_paiement = Mode_paiement;
    }

    public trajet(String Ville_depart, String Ville_darrive, int Nbr_place, int Duree_pose, String Mode_paiement) {
        this.Ville_depart = Ville_depart;
        this.Ville_darrive = Ville_darrive;
        this.Nbr_place = Nbr_place;
        this.Duree_pose = Duree_pose;
        this.Mode_paiement = Mode_paiement;
    }
           

    public trajet() {
    }

    public trajet(String Ville_depart, String Ville_darrive, float Prix, int Nbr_place , int Id_user, int Id_trajet, int Duree_pose, String Mode_paiement) {
        this.Ville_depart = Ville_depart;
        this.Ville_darrive = Ville_darrive;
        this.Prix = Prix;
        this.Nbr_place = Nbr_place;
        this.Id_trajet = Id_user;
        this.Id_trajet = Id_trajet;
        this.Duree_pose = Duree_pose;
        this.Mode_paiement = Mode_paiement;
    }

    public trajet(String Ville_depart, String Ville_darrive, float Prix, int Nbr_place, int Id_trajet, int Duree_pose, String Mode_paiement) {
        this.Ville_depart = Ville_depart;
        this.Ville_darrive = Ville_darrive;
        this.Prix = Prix;
        this.Nbr_place = Nbr_place;
        this.Id_trajet = Id_trajet;
        this.Duree_pose = Duree_pose;
        this.Mode_paiement = Mode_paiement;
    }

  
    public String getVille_depart() {
        return Ville_depart;
    }

    public void setVille_depart(String Ville_depart) {
        this.Ville_depart = Ville_depart;
    }

    public String getVille_darrive() {
        return Ville_darrive;
    }

    public void setVille_darrive(String Ville_darrive) {
        this.Ville_darrive = Ville_darrive;
    }

    public float getPrix() {
        return Prix;
    }

    public void setPrix(int Prix) {
        this.Prix = Prix;
    }

    public int getNbr_place() {
        return Nbr_place;
    }

    public void setNbr_place(int Nbr_place) {
        this.Nbr_place = Nbr_place;
    }

    public int getId_user() {
        return Id_user;
    }

    public void setId_user(int Id_user) {
        this.Id_user = Id_user;
    }

    
    public int getId_trajet() {
        return Id_trajet;
    }

    public void setId_trajet(int Id_trajet) {
        this.Id_trajet = Id_trajet;
    }

    public int getDuree_pose() {
        return Duree_pose;
    }

    public void setDuree_pose(int Duree_pose) {
        this.Duree_pose = Duree_pose;
    }

    public String getMode_paiement() {
        return Mode_paiement;
    }

    public void setMode_paiement(String Mode_paiement) {
        this.Mode_paiement = Mode_paiement;
    }

    @Override
    public String toString() {
        return "trajet{" + "Ville_depart=" + Ville_depart + ", Ville_darrive=" + Ville_darrive + ", Prix=" + Prix + ", Nbr_place=" + Nbr_place + ", Id_user=" + Id_user + ", Id_trajet=" + Id_trajet + ", Duree_pose=" + Duree_pose + ", Mode_paiement=" + Mode_paiement + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final trajet other = (trajet) obj;
        if (!Objects.equals(this.Ville_depart, other.Ville_depart)) {
            return false;
        }
        if (!Objects.equals(this.Ville_darrive, other.Ville_darrive)) {
            return false;
        }
        if (Float.floatToIntBits(this.Prix) != Float.floatToIntBits(other.Prix)) {
            return false;
        }
        if (this.Nbr_place != other.Nbr_place) {
            return false;
        }
        if (this.Id_user != other.Id_user) {
            return false;
        }
        if (this.Id_trajet != other.Id_trajet) {
            return false;
        }
        if (this.Duree_pose != other.Duree_pose) {
            return false;
        }
        if (!Objects.equals(this.Mode_paiement, other.Mode_paiement)) {
            return false;
        }
        return true;
    }

   
    
            
            
  
     

    
   
  
}
