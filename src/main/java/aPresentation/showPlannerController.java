package aPresentation;

/**
 * Created by Olivi on 17-03-2017.
 */
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class showPlannerController implements Initializable {

    @FXML
    private DatePicker movieDateSPDatePicker;

    @FXML
    private Button addToScheduleSPButton;

    @FXML
    private Button backToMenuSPButton;

    @FXML
    private ComboBox<?> movieSPComboBox;

    @FXML
    private TextField movieTimeSPTextField;

    @FXML
    private MenuButton theatersSPMenuButton;

    @FXML
    private MenuItem bigTheaterSPMenuItem;

    @FXML
    private MenuItem smallTheaterSPMenuItem;

    @FXML
    private Button newMovieSPButton;

    public void initialize(URL location, ResourceBundle resources) {

    }

}

