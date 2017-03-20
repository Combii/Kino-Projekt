package aPresentation.EditMovie;

import BusinessLogic.Movie.Movie;
import BusinessLogic.Movie.MovieList;
import aPresentation.ConvertPictureToThumbnail.Thumbnail;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
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

    @FXML
    public TextField movieName;
    public TextField genre;
    public TextField ageRestriction;
    public TextField price;
    public Text warningText;

    private String imageName = "";

    private MovieList movieList = new MovieList();

    @SuppressWarnings("unchecked")
    public void initialize() {
        movieList.getMovieListInDatabase();

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

    public void dragDrop(DragEvent dragEvent) {
        Dragboard db = dragEvent.getDragboard();
        File image = new File("");
        try {
                for (File i : db.getFiles()) {
                    if(i.isFile()){
                        image = i;
                        break;
                    }

            }
            Thumbnail.convertToThumbnail(image.getName(), image.getAbsolutePath());
            imageName = image.getName();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void dragDropText(DragEvent dragEvent) {
        dragDrop(dragEvent);
    }

    public void addMovieButton() {
        warningText.setText("");

        if(!movieName.getText().isEmpty()
                && !genre.getText().isEmpty()
                && !ageRestriction.getText().isEmpty()
                && !price.getText().isEmpty()
                && !imageName.isEmpty()){
            if(!price.getText().matches("[0-9]+"))
                warningText.setText("Price has to be Integer or Double");

            MovieList newMovieList = new MovieList();
            newMovieList.addMovieToList(movieName.getText(), genre.getText(), ageRestriction.getText(), Double.parseDouble(price.getText()), imageName);
            newMovieList.uploadMovieListToDatebase();

            movieList.getMovieListInDatabase();
            setUpTableColumn("");
        }
        else
            warningText.setText("Every column not filled or Image not given for new Movie");
    }

    public void goBack() throws IOException {
        Stage stage = (Stage) movieName.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/BrowseMenu.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }
}