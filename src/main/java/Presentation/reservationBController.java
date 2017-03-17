package Presentation;

/**
 * Created by Olivi on 17-03-2017.
 */
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class reservationBController implements Initializable {

    @FXML
    private Slider ticketBSlider;

    @FXML
    private DatePicker movieDateBDatePicker;

    @FXML
    private TextField showChoosenMovieBTextField;

    @FXML
    private TextField nameBTextField;

    @FXML
    private TextField phoneNumberBTextField;

    @FXML
    private ComboBox<?> chooseSeatsBComboBox;

    @FXML
    private RadioButton reserveBRadioButton;

    @FXML
    private RadioButton reservePayBRadioButton;

    @FXML
    private Button finalizeBButton;

    @FXML
    private Button backToMenuBButton;

    public void initialize(URL location, ResourceBundle resources) {

    }

}
