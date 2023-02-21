/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.vromvrom.GUI;

import java.io.IOException;
import javafx.event.ActionEvent;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import tn.esprit.vromvrom.entities.trajet;
import tn.esprit.vromvrom.services.ServiceTrajet;
import tn.esprit.vromvrom.utils.MaConnexion;

/**
 * FXML Controller class
 *
 * @author user
 */
public class AddTrajetController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    private Connection cnx;

    public AddTrajetController(){
        cnx = MaConnexion.getInstance().getCnx();
    }
    
      @FXML
    private TextField villeD;

    @FXML
    private TextField villeA;

    @FXML
    private TextField prix;

    @FXML
    private TextField nbrP;

    @FXML
    private TextField id_user;

    @FXML
    private TextField DPose;
    
    @FXML
    private TextField mP;

   

    @FXML
    private Button butAjouter;
    
    

    
    
    
    //cliiiccckkkk
       @FXML
        private void AddTrajet(ActionEvent event){
           
           EnrejistreBase();
           villeD.clear();
           villeA.clear();
           prix.clear();
           nbrP.clear();
           id_user.clear();
           DPose.clear();
           mP.clear();
           
       
       
       
       }
    
    
        @FXML 
    private void Retour(ActionEvent event) throws IOException{
    
    Node node = (Node) event.getSource();
                    Stage stage = (Stage) node.getScene().getWindow(); 
                    stage.close();
                    Scene scene = new Scene(FXMLLoader.load(getClass().getResource("affTrajet.fxml")));       
                    stage.setScene(scene);
                    stage.setTitle("Login");
                    
                    stage.show();
    
    
    
    
    }
    
    
    
    
  
    private void EnrejistreBase(){
    
        java.sql.Connection cnx;
     cnx = MaConnexion.getInstance().getCnx();
              String[] gouvernorats = {"Tunis", "Ariana", "Manouba", "Ben Arous", "Nabeul", "Zaghouan", "Bizerte", "Béja", "Jendouba", "Le Kef", "Siliana", "Kairouan",
            "Kasserine", "Sidi Bouzid", "Sousse", "Monastir", "Mahdia", "Sfax", "Kairouan", "Gabès", "Medenine", "Tataouine", "Tozeur", "Kebili"};     
     if (villeD.getText().isEmpty() 
    || villeA.getText().isEmpty()
    || prix.getText().isEmpty()
    || nbrP.getText().isEmpty()
    || id_user.getText().isEmpty()
    || DPose.getText().isEmpty()
    || mP.getText().isEmpty())
{
    Alert al = new Alert(Alert.AlertType.INFORMATION);
    al.setTitle("Contrôle de saisie");
    al.setHeaderText("Erreur de saisie !");
    al.setContentText("Les données sont vides !");
    al.showAndWait();
}
     else if (!mP.getText().equalsIgnoreCase("enligne") && !mP.getText().equalsIgnoreCase("espece")) {
    Alert al = new Alert(Alert.AlertType.INFORMATION);
    al.setTitle("Contrôle de saisie");
    al.setHeaderText("Erreur de saisie !");
    al.setContentText("Le mode de paiement doit être 'enligne' ou 'espece'.");
    al.showAndWait();
}
     else if (!Arrays.asList(gouvernorats).contains(villeD.getText())) {
    // La ville de départ n'est pas valide, afficher un message d'erreur
    Alert al = new Alert(Alert.AlertType.ERROR);
    al.setTitle("Erreur de saisie");
    al.setHeaderText("La ville de départ n'est pas valide");
    al.setContentText("Veuillez sélectionner une ville de départ parmi la liste des 24 gouvernorats tunisiens.");
    al.showAndWait();
}
     else{
           try {
            String sql = "INSERT INTO trajet (`ville_depart`, `ville_darrive`, `prix`, `nbr_place`,`id_user`,`duree_pos`, `mode_paiement`) VALUES (?,?,?,?,?,?,?)";
            
        PreparedStatement st = (PreparedStatement) cnx.prepareStatement(sql);
            st.setString(1, villeD.getText());
                        st.setString(2, villeA.getText());

                                    st.setString(3, prix.getText());

                                                st.setString(4, nbrP.getText());
            st.setString(5, id_user.getText());
            st.setString(6, DPose.getText());
                        st.setString(7, mP.getText());


         
        
            st.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error");
        }
     }
    
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
