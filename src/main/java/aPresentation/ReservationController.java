package aPresentation;

import BusinessLogic.Movie.Movie;
import BusinessLogic.Schedule.Schedule;
import BusinessLogic.Schedule.ScheduleList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Olivi on 20-03-2017.
 */
public class ReservationController implements Initializable {

    public Button finalizeButton;
    public Text movieNameText;
    public TableColumn listDate;
    public static Movie movie;
    public MenuButton tickets;

    private static int numberOfTickets;

    public TableView dateList;

    private ObservableList<MenuItem> list = FXCollections.observableArrayList();
    private ScheduleList scheduleList = new ScheduleList();

    private TableColumn columnMovieDates;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        movieNameText.setText(movie.getMovieName());

        setupTicketMenu(10);
        tickets.getItems().addAll(FXCollections.observableArrayList(list));

        setUpTableColumn(movieNameText.getText());
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


    public void ticketsChosen(ActionEvent actionEvent) {
    }

    private void setupTicketMenu(int numberOfTickets){
        for(int i = 1; i <= numberOfTickets; i++){
            MenuItem menuItem = new MenuItem(String.valueOf(i));
            menuItem.setOnAction(event -> ReservationController.numberOfTickets = Integer.parseInt(menuItem.getText()));
            list.add(menuItem);
        }

    }

    @SuppressWarnings("unchecked")
    private void setUpTableColumn(String movieName){
        columnMovieDates = new TableColumn("Date(s)");
        columnMovieDates.setMinWidth(dateList.getPrefWidth());
        columnMovieDates.setCellValueFactory(new PropertyValueFactory<Schedule, String>("date"));

        dateList.setItems(getMoviesDates(movieName));
        dateList.getColumns().addAll(columnMovieDates);
    }

    private ObservableList<Schedule> getMoviesDates(String movieName) {
        ObservableList<Schedule> moviesDates = FXCollections.observableArrayList();
        scheduleList.getSchedulesForMovie(movieName);
        moviesDates.addAll(scheduleList.getScheduleList());
        return moviesDates;
    }
}


