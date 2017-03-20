package aPresentation;

/**
 * Created by Olivi on 17-03-2017.
 */
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class addNewMovieController implements Initializable {

    @FXML
    private Button addMovieAMButton;

    @FXML
    private Button backToMenuAMButton;

    @FXML
    private ImageView moviePosterAMImageView;

    @FXML
    private TextArea movieDescriptionAMTextArea;

    @FXML
    private DatePicker movieStartDateAMDatePicker;

    @FXML
    private DatePicker movieEndDateAMDatePicker;

    @FXML
    private MenuButton ageRestrictionAMMenuButton;

    public void initialize(URL location, ResourceBundle resources) {

    }
}

