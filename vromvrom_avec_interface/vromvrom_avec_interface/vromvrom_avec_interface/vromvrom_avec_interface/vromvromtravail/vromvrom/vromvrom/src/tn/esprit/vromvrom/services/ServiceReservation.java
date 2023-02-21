/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.vromvrom.services;

import tn.esprit.vromvrom.entities.Reservation;
import tn.esprit.vromvrom.utils.MaConnexion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class ServiceReservation implements IService<Reservation>{
  private final Connection cnx;
    private Object spR;

    public ServiceReservation(){
        cnx = MaConnexion.getInstance().getCnx();
    }
    @Override
    public void createOne(Reservation r) throws SQLException {
         String req =   "INSERT INTO `reservation`(`id_reservation`, `id_trajet`, `id_user`)" + "VALUES ('"+r.getId_reservation()+"','"+r.getId_trajet()+"','"+r.getId_user()+"')";
        
        
       
        Statement st = cnx.createStatement();
        st.executeUpdate(req);
        System.out.println("reservation ajouté !"); 
    }

    @Override
  @SuppressWarnings("empty-statement")
    public void updateOne(Reservation R) throws SQLException {
        String req =  " UPDATE reservation SET Id_reservation=?,id_trajet=?,id_user=? WHERE id_reservation=" + R.getId_reservation();
     
            PreparedStatement stR = cnx.prepareStatement(req);

          ;
                stR.setInt(1, R.getId_reservation());
                   stR.setInt(2, R.getId_trajet());
                      stR.setInt(3, R.getId_user());
                
              
            stR.executeUpdate();

// String req =  " UPDATE trajet SET id_reservation=?, id_trajet=?,,id_user=? WHERE id_reservation=" + R.getId_reservation();
//     
//            PreparedStatement st = cnx.prepareStatement(req);
//                  st.setInt(1, R.getId_reservation());
//                 st.setInt(2, R.getId_trajet());
//                 st.setInt(3, R.getId_user());
//                
//             // pst.setString(4, planning.getIdEv());
//           
//           // pst.setInt(5, planning.getIdP());
//            st.executeUpdate();
////            
    }

    @Override
    public void deletOne(Reservation reservation) throws SQLException {
        try {
            String req = "DELETE FROM reservation WHERE reservation.`id_reservation` = ?";
            PreparedStatement stR = cnx.prepareStatement(req);
            stR.setInt(1, reservation.getId_reservation());
               stR.executeUpdate();
            System.out.println("reservation supprimé");

        } catch (SQLException ex) {
            Logger.getLogger(ServiceTrajet.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    /**
     *
     * @return
     * @throws SQLException
     */
    @Override
    public List<Reservation> selectAll() throws SQLException {
        List<Reservation> temp = new ArrayList<>();

        String req = "SELECT * FROM `reservation`";
        PreparedStatement ps = cnx.prepareStatement(req);

        ResultSet rs = ps.executeQuery();

        while (rs.next()){

            Reservation re = new Reservation();

          
         
            re.setId_reservation(rs.getInt("id_reservation"));
             re.setId_trajet(rs.getInt("id_trajet"));
              re.setId_user(rs.getInt("id_user"));
           
           

            temp.add(re);

            }
     return temp;
    }}
    
    

    

    
      

