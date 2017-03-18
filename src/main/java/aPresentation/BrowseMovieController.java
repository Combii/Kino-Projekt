package aPresentation;

import BusinessLogic.Movie.MovieList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.*;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.util.Callback;

import javax.xml.soap.Text;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by David Stovlbaek
 * 26 November 2016.
 */
public class BrowseMovieController {
    public AnchorPane splitPane;
    public GridPane gridPane;
    public ContextMenu contextMenu;

/*
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //setGridPane("pics");
    }
    
    private void setGridPane() {
        gridPane.getChildren().clear();

        try {
            MovieList movieList = new MovieList();
            movieList.getMovieListInDatabase();

            int rowCounter = 0, columnCounter = 0;


            for (final FilePath i : list.getList()) {

                Button button = new Button();

                //Handle when picture of Movie is clicked on
                button.setOnAction(event -> {

                });

                File file = new File(i.getLocalPathThumbnail());
                String localUrl = file.toURI().toURL().toString();

                Image thumbnail = new Image(localUrl, false);
                ImageView view = new ImageView(thumbnail);
                view.setFitHeight(100);
                view.setFitWidth(150);
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
    }*/
}
