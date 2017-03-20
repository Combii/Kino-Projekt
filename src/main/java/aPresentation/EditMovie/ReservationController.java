package aPresentation.EditMovie;

import BusinessLogic.Movie.Movie;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.text.Text;

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
}
