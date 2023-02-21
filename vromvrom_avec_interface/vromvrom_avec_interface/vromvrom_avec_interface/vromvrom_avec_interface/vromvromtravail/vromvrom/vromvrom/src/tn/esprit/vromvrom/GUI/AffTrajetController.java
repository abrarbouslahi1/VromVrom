/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.vromvrom.GUI;

import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.management.relation.Role;
import javax.swing.JOptionPane;
import tn.esprit.vromvrom.entities.trajet;
import tn.esprit.vromvrom.utils.MaConnexion;

/**
 * FXML Controller class
 *
 * @author user
 */
public class AffTrajetController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
      @FXML
    private TableView<trajet> tab;

    @FXML
    private TableColumn<trajet, String> VD;

    @FXML
    private TableColumn<trajet, String> VA;

    @FXML
    private TableColumn<trajet, Float> prix;

    @FXML
    private TableColumn<trajet, Integer> place;

    @FXML
    private TableColumn<trajet, Integer> pose;

    @FXML
    private TableColumn<trajet, String> paiement;
    
     @FXML
    private Button retour;
     
          @FXML
    private Button supp;

    @FXML
    private TextField id;
    
    @FXML
    private Button ref;

       @FXML
    private TextField idM;
    
    
    public void table(){
         
        VD.setCellValueFactory( new PropertyValueFactory<>("Ville_depart"));
        VA.setCellValueFactory(new PropertyValueFactory <>("Ville_darrive"));
                prix.setCellValueFactory(new PropertyValueFactory <>("prix"));

                        place.setCellValueFactory(new PropertyValueFactory <>("Nbr_place"));
        pose.setCellValueFactory(new PropertyValueFactory <>("Duree_pose"));
        paiement.setCellValueFactory(new PropertyValueFactory <>("Mode_paiement"));

       
        tab.setItems(RecupBase()); 



}
    
    
    
    @FXML
    public void Supprimer(ActionEvent event){
    
    String n = id.getText();
    int nn=Integer.valueOf(n);
    
    supp(nn);
    id.clear();
    
    
    
    
    }
    
     @FXML
    public void Refresh(ActionEvent event){
    
   table();
    
    
    
    
    }
    
    
    public void supp(int id){
    
      java.sql.Connection cnx;
     cnx = MaConnexion.getInstance().getCnx();
             
        
           try {
            String sql = "DELETE FROM trajet WHERE `id_trajet` = '" +id+ "' " ;
            
        PreparedStatement st = (PreparedStatement) cnx.prepareStatement(sql);
 


         
        
            st.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error");
        }
    
    
    
    
    
    }
    
    @FXML 
    private void Retour(ActionEvent event) throws IOException{
    
    Node node = (Node) event.getSource();
                    Stage stage = (Stage) node.getScene().getWindow(); 
                    stage.close();
                    Scene scene = new Scene(FXMLLoader.load(getClass().getResource("AddTrajet.fxml")));       
                    stage.setScene(scene);
                    stage.setTitle("Login");
                    
                    stage.show();
    
    
    
    
    }
    
  //affichter  
    public static ObservableList<trajet> RecupBase(){
             
    ObservableList<trajet> list = FXCollections.observableArrayList();
    
       java.sql.Connection cnx;
     cnx = MaConnexion.getInstance().getCnx();
          String sql = "select *from trajet";
    try {
       
        PreparedStatement st = (PreparedStatement) cnx.prepareStatement(sql);

    ResultSet R = st.executeQuery();
    while (R.next()){
      trajet r =new trajet();
     r.setVille_depart((R.getString(1)));
     r.setVille_darrive(R.getString(2));
     r.setPrix((int) R.getFloat(3));
     r.setNbr_place(R.getInt(4));
     r.setDuree_pose(R.getInt(7));
     r.setMode_paiement(R.getString(8));
     
    
     
      list.add(r);
    }
    }catch (SQLException ex){
    ex.getMessage(); 
    } 
    return list;
    }
    
    @FXML
      void Modifier(ActionEvent event) {
        String id=idM.getText();
     
                int i=Integer.valueOf(id);

       
       
        String sql =" UPDATE trajet SET ville_depart=?,ville_darrive=?,prix=?,nbr_place=?,duree_pos=?,mode_paiement=? WHERE id_trajet=" + i+"";
        try {
         PreparedStatement st = (PreparedStatement) cnx.prepareStatement(sql);
         st.executeUpdate();
            
          JOptionPane.showMessageDialog(null,"Le fichier a été modifier");
    }catch(SQLException ex){
        ex.getMessage();
    }
        

    }
    
    
    
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        table();
        // lhjett ily nhbhom yadhhroo au debut de runn d'applicat  TODO
    }    
    
}
