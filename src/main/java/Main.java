import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.awt.*;
import java.awt.event.ActionEvent;



public class Main extends Application{

    public void start(Stage primaryStage) throws Exception{
        // --- Reservation page ---
        StackPane rootReservation = new StackPane();

        // Button
        Button menuReservation = new Button();
        menuReservation.setText("Go back to menu");

        rootReservation.getChildren().add(menuReservation);

        // Make scene
        Scene sceneReservation = new Scene(rootReservation, 980, 680);


        // --- Front page ---
        // Buttons to access different pages
        Button reservations = new Button();
        reservations.setText("Reservations");

        // Set actions for buttons
     //   reservations.setOnAction(e ->{
     //       primaryStage.setScene(sceneReservation);
     //   });

    /*    reservations.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                primaryStage.setScene(sceneReservation);
            }
        }); */



        StackPane root = new StackPane();
        root.getChildren().add(reservations);
        primaryStage.setTitle("Program");
        primaryStage.setScene(new Scene(root, 980, 680));
        primaryStage.show();


    }


    public static void main(String[] args){
        launch(args);
    }
}

