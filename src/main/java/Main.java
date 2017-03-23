import BusinessLogic.Movie.Movie;
import Dao.SQLMovie;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.SQLException;

/**
 * Created by David Stovlbaek
 * 13 March 2017.
 */
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/BrowseMenu.fxml"));
        primaryStage.setTitle("Kino XP");
        primaryStage.setResizable(true);
        primaryStage.setScene(new Scene(root));
        primaryStage.centerOnScreen();
        primaryStage.show();
    }
    
    public static void main(String[] args) throws SQLException {

        Movie movie = new Movie("1", "2", "3", 100, "/Users/jakob/Documents/Pix/c8fafd2d923c81cdf6aef413f24e77f0");

        SQLMovie sqlmovie = new SQLMovie();
        sqlmovie.addMovie(movie);
        //Movie movieee = sqlmovie.getMovie("Shrek");
        System.out.println(movie.toString());

    }

}

