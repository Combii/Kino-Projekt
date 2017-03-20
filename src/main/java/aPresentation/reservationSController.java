package aPresentation;

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

public class reservationSController implements Initializable {

    @FXML
    private Slider ticketSSlider;

    @FXML
    private DatePicker movieDateSDatePicker;

    @FXML
    private TextField showChoosenMovieSTextField;

    @FXML
    private TextField nameSTextField;

    @FXML
    private TextField phoneNumberSTextField;

    @FXML
    private ComboBox<?> chooseSeatsSComboBox;

    @FXML
    private RadioButton reserveSRadioButton;

    @FXML
    private RadioButton reservePaySRadioButton;

    @FXML
    private Button finalizeSButton;

    @FXML
    private Button backToMenuSButton;

    public void initialize(URL location, ResourceBundle resources) {

    }
}