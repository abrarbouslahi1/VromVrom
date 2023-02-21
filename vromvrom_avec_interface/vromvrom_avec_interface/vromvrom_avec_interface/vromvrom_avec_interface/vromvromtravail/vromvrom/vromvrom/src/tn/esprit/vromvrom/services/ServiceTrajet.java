/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.vromvrom.services;

import tn.esprit.vromvrom.entities.trajet;
import tn.esprit.vromvrom.utils.MaConnexion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author USER
 */

public class ServiceTrajet implements IService<trajet> {
    private Connection cnx;
    private Object sp;

    public ServiceTrajet(){
        cnx = MaConnexion.getInstance().getCnx();
    }

    @Override
    public void createOne(trajet t) throws SQLException {
      String req =   "INSERT INTO `trajet`(`ville_depart`, `ville_darrive`, `prix`, `nbr_place`, `id_trajet`,`id_user`,`duree_pos`, `mode_paiement`)" + "VALUES ('"+t.getVille_depart()+"','"+t.getVille_darrive()+"','"+t.getPrix()+"','"+t.getNbr_place()+"','"+t.getId_user()+"','"+t.getId_trajet()+"','"+t.getDuree_pose()+"','"+t.getMode_paiement()+"')";
        
        
        
        Statement st = cnx.createStatement();
        st.executeUpdate(req);
        System.out.println("Person ajouté !"); 
    }

  

   @Override
   public void updateOne(trajet t) throws SQLException {
      

  
        String req =  " UPDATE trajet SET ville_depart=?,ville_darrive=?,prix=?,nbr_place=?,id_user=?,id_trajet=?,duree_pos=?,mode_paiement=? WHERE id_trajet=" + t.getId_trajet();
     
            PreparedStatement st = cnx.prepareStatement(req);

            st.setString(1, t.getVille_depart());
            st.setString(2, t.getVille_darrive());
                st.setFloat(3, t.getPrix());
                 st.setFloat(4, t.getNbr_place());
                  st.setInt(5, t.getId_user());
                  st.setInt(6, t.getId_trajet());
                st.setInt(7, t.getDuree_pose());
                st.setString(8, t.getMode_paiement());
                
             // pst.setString(4, planning.getIdEv());
           
           // pst.setInt(5, planning.getIdP());
            st.executeUpdate();
//            System.out.println("participants number of event " + planning.getNomActivite() + " is updated successfully");
    }

    @Override
    public void deletOne(trajet trajet) throws SQLException {
    
   



try {
            String req = "DELETE FROM trajet WHERE trajet.`id_trajet` = ?";
            PreparedStatement ste = cnx.prepareStatement(req);
            ste.setInt(1, trajet.getId_trajet());
            ste.executeUpdate();
            System.out.println("trajet supprimé");

        } catch (SQLException ex) {
            Logger.getLogger(ServiceTrajet.class.getName()).log(Level.SEVERE, null, ex);
        }    }


    
     
  

    @Override
    public List<trajet> selectAll() throws SQLException {
        List<trajet> temp = new ArrayList<>();

        String req = "SELECT * FROM `trajet`";
        PreparedStatement ps = cnx.prepareStatement(req);

        ResultSet rs = ps.executeQuery();

        while (rs.next()){

            trajet tr = new trajet();

          
           tr.setVille_depart(rs.getString("ville_depart"));
           tr.setVille_darrive(rs.getString("ville_darrive"));
            tr.setPrix(rs.getInt("prix"));
           tr.setNbr_place(rs.getInt("nbr_place"));
            tr.setNbr_place(rs.getInt("id_user"));
             tr.setNbr_place(rs.getInt("id_trajet"));
            tr.setDuree_pose(rs.getInt("duree_pos"));
             tr. setMode_paiement(rs.getString("mode_paiement"));
           

            temp.add(tr);

        }


        return temp;
    }

   
}
    
        
        

    
    
        
        
        
        
    


    

