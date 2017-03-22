package aPresentation.BrowseMovies;

import BusinessLogic.Movie.Movie;
import BusinessLogic.Movie.MovieList;
import aPresentation.ReservationController;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by David Stovlbaek
 * 26 November 2016.
 */
public class BrowseMovieController implements Initializable{
    public AnchorPane splitPane;
    public GridPane gridPane;
    public TextField searchMovie;

    MovieList movieList;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        movieList = new MovieList();
        movieList.getMovieListInDatabase();
        setGridPane(movieList.getMovieList());
    }

    private void setGridPane(List<Movie> movieList) {
        gridPane.getChildren().clear();

        try {
            int rowCounter = 0, columnCounter = 0;


            for (final Movie movie : movieList) {

                Button button = new Button();

                //Handle when picture of Movie is clicked on
                button.setOnAction(event -> {
                    changeMovie(movie);
                    changeWindow("/Reservation/Reservation.fxml");
                });
                //------------------------------------------

                File file = new File(movie.getPicturePath());
                String localUrl = file.toURI().toURL().toString();

                Image thumbnail = new Image(localUrl, false);
                ImageView view = new ImageView(thumbnail);
                view.setFitHeight(150);
                view.setFitWidth(120);
                button.setGraphic(view);
                gridPane.add(button, columnCounter, rowCounter);

                columnCounter++;
                if (columnCounter > 3) {
                    columnCounter = 0;
                    rowCounter++;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void searchMovieCheck() {
        String movieName = searchMovie.getText().toLowerCase();

        setGridPane(movieList.getListAfterMovieName(movieName));
    }

    public void addMovieButton() {
        changeWindow("/EditMovies.fxml");
    }

    private void changeWindow(String changeWindow) {
        try {
        Stage stage = (Stage) gridPane.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource(changeWindow));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void changeMovie(Movie movie) {
        ReservationController.movie = movie;
    }
}
