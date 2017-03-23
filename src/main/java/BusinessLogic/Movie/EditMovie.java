package BusinessLogic.Movie;
import Dao.SQLMovie;
import java.sql.SQLException;

/**
 * Created by julieglasdam on 21/03/2017.
 */
public class EditMovie {
    private SQLMovie sqlMovie;

    public EditMovie() throws SQLException {
        this.sqlMovie = new SQLMovie();
    }

    // Husk i præsentationslaget skal den tjekke om der bliver sendt noget (setOnAction). Hvis der ikke
    // er noget i felterne skal den bare lade være med at kalde metoden her

    // Parametres: Movie, and inputs from users in presentation layer
    public void editMovie(Movie movie, String ageRestictionInput, double priceInput, String genreInput) throws SQLException {
        // Save values as variables before editing
        String name = movie.getMovieName();
        String ageRestriction = movie.getAgeRestriction();
        double price = movie.getPrice();
        String genre = movie.getGenre();

        // Check if user input is not null, and if it isn't, the input overwrites the variables declared above
        if (!ageRestictionInput.equals("")) {
            ageRestriction = ageRestictionInput;
        }
        if (priceInput != 0) { // Måske skal der stå noget andet end 0. Det kommer an på hvad feltet sender fra GUI'en
            price = priceInput;
        }
        if (!genreInput.equals("")) {
            genre = genreInput;
        }

        // After saving values, update with new inputs
        sqlMovie.editMovie(name, ageRestriction, price, genre);

    }

    // Jeg ved ikke om de her metoder skal være i logic laget
    // Parametre skal måske ændres
    public void deleteMovie(Movie movie) throws SQLException {
        sqlMovie.deleteMovie(movie.getMovieName());
    }

    public void addMovie(Movie movie) {
        sqlMovie.addMovie(movie);
    }

}