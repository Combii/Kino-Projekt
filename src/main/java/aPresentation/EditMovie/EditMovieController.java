package aPresentation.EditMovie;

import BusinessLogic.Movie.Movie;
import BusinessLogic.Movie.MovieList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;

import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * Created by David Stovlbaek
 * 18 March 2017.
 */
public class EditMovieController{
    public TextField searchMovie;

    @FXML
    public TableView table;
    protected TableColumn columnMovieNames;

    private MovieList movieList = new MovieList();

    @SuppressWarnings("unchecked")
    public void initialize() {
        movieList.getMovieListInDatabase();
        System.out.println(movieList);
        table.setEditable(false);

        setUpTableColumn("");
    }

    public void movieNameEntered() {
        String movieName = searchMovie.getText().toLowerCase();
        setUpTableColumn(movieName);
    }

    @SuppressWarnings("unchecked")
    private void setUpTableColumn(String movieName){
        columnMovieNames = new TableColumn("Movie Names");
        columnMovieNames.setMinWidth(table.getPrefWidth());
        columnMovieNames.setCellValueFactory(new PropertyValueFactory<Movie, String>("movieName"));

        table.setItems(getMovies(movieName));
        table.getColumns().addAll(columnMovieNames);
    }

    private ObservableList<Movie> getMovies(String movieName) {
        ObservableList<Movie> movies = FXCollections.observableArrayList();
        movies.addAll(movieList.getListAfterMovieName(movieName));
        return movies;
    }

}