package aPresentation;

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

    private void setGridPane(String dropboxFolderPath) {
        currentFolderOpen = dropboxFolderPath;
        gridPane.getChildren().clear();

        try {
            FileStorage list = new FileStorage();
            list.downloadFilesToList(dropboxFolderPath);

            int rowCounter = 0, columnCounter = 0;


            for (final FilePath i : list.getList()) {

                Button button = new Button();

                //Handle when button is clicked on
                button.setOnAction(event -> {
                    try {
                        //https://stackoverflow.com/questions/5824916/how-do-i-open-an-image-in-the-default-image-viewer-using-java-on-windows
                        File file = new File(i.getLocalPath());
                        Desktop.getDesktop().open(file);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
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
