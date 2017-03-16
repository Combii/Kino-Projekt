import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * Created by Olivi on 16-03-2017.
 */
public class reservationController implements Initializable{

    public Button makeReservationButton;

    public void makeReservation() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/reservation.fxml"));
        Stage stage = (Stage) this.makeReservationButton.getScene().getWindow();
        stage.setScene(new Scene(root, 600, 400));
        stage.show();
    }

}
