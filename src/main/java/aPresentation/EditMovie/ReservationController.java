package aPresentation.EditMovie;

import BusinessLogic.Movie.Movie;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Olivi on 20-03-2017.
 */
public class ReservationController implements Initializable {


    public Text movieNameText;
    public ComboBox ticketsComboBox;
    public TableColumn listDate;

    public static Movie movie;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        movieNameText.setText(movie.getMovieName());
    }


    public void makeReservation(ActionEvent actionEvent) {

    }

    private void changeWindow(String changeWindow) {
        try {
            Stage stage = (Stage) movieNameText.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource(changeWindow));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void backToBrowseMovies(ActionEvent actionEvent) {
        changeWindow("/BrowseMenu.fxml");
    }
}
