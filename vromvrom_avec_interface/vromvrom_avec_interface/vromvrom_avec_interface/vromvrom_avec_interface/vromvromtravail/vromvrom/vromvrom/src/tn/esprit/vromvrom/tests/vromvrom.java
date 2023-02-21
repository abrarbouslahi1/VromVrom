//
///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package tn.esprit.vromvrom.tests;
//
///**
// *
// * @author USER
// */
//
//
// import tn.esprit.vromvrom.entities.trajet;
//import tn.esprit.vromvrom.services.ServiceTrajet;
//
//import tn.esprit.vromvrom.utils.MaConnexion;
//
//
// import tn.esprit.vromvrom.entities.Reservation;
//import tn.esprit.vromvrom.services.ServiceReservation;
//
//
//
//import java.sql.SQLException;
//import tn.esprit.vromvrom.services.ServiceReservation;
//
//public class vromvrom {
//
//    public static void main(String[] args) {
//        
//   //  MaConnexion cn1 = MaConnexion.getInstance();
////        MaConnexion cn2 = MaConnexion.getInstance();
////        MaConnexion cn3 = MaConnexion.getInstance();
////        MaConnexion cn4 = MaConnexion.getInstance();
////
////   //   System.out.println(cn1.hashCode());
////        System.out.println(cn2.hashCode());
////        System.out.println(cn3.hashCode());
////        System.out.println(cn4.hashCode());
//
////        trajet p = new trajet("EEEE", "EEE", 1.5f ,55, 14,1,5, "esp");
//     // trajet p3 = new trajet("hadiiiir", "ibtih", 5.9f ,2, 14,1, "esp");
////         trajet p1 = new trajet("kkkk", "oussama", 1.5f ,9999,1, "esp");
////         trajet p5 = new trajet("jaber", "naima", 1.5f ,14,14,1, "abrar");
//         // Reservation RC = new Reservation(3,14);
//        //pour supp constructure fyh id akahw//
//        //pour update constructur maficho cle etrangeur //
//        Reservation RD = new Reservation(2);
//     Reservation RU = new Reservation(3,2,14);
//         
//        //ServiceTrajet sp = new ServiceTrajet();
//        ServiceReservation spR = new ServiceReservation();
//        
//        try {
//            
//            //sp.createOne(p3);
//            //spR.createOne(RC);
//              //spR.createOne(R);
//             //sp.createOne(p5);
//             //spR.updateOne(RU);
//             
//             //spR.updateOne(R,13);
//             
//             //spR.deletOne(R3);
//            // sv.createOne(pt);
//            // sp.updateOne(p);
//           
//         //   System.out.println(sp.selectAll());
//            System.out.println(spR.selectAll());
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//
//
//    }
//
//    }

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.vromvrom.GUI;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import tn.esprit.vromvrom.utils.MaConnexion;


/**
 *
 * @author MediaCenter Zaghouan
 */
public class vromvrom extends Application {
    
//    @Override
    public void start(Stage primaryStage) {
      try {
            Parent root = FXMLLoader.load(getClass(). getResource("AddTrajet.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setTitle("Login");
            primaryStage.setScene(scene);
            primaryStage.show();         
            
        } catch (IOException ex) {
            Logger.getLogger(vromvrom.class.getName()).log(Level.SEVERE, null, ex);
        }    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        launch(args);

//ServiceUser s = new ServiceUser();
//ServiceRole r = new ServiceRole();
//
//
//User u = new User(r.SelectRole(1),"sdd","dds","dds","dds","dds");
//
////s.ajouter(u);
//r.readAll();
//  
//  
    }


}