package aPresentation.ConvertPictureToThumbnail;

import net.coobird.thumbnailator.Thumbnails;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by David Stovlbaek
 * 18 March 2017.
 */
public class Thumbnail {

    public static void convertToThumbnail(String localPathToSave, String originalImagePath) throws IOException {
        //https://github.com/coobird/thumbnailator/wiki/Examples

        localPathToSave = new File("src/main/Resources/MoviePictures").getAbsolutePath() + "/" + localPathToSave;

        File file = new File(localPathToSave);
        file.getParentFile().mkdirs();

        OutputStream os = new FileOutputStream(file);
        Thumbnails.of(originalImagePath)
                .size(200, 250)
                .outputFormat("png")
                .toOutputStream(os);
    }

    /*
    public static void main(String[] args) {
        try {
            convertToThumbnail("/Users/Combii/Dropbox/Datamatiker/3. Semester/Agil Aflevering/Kino Aflevering/src/main/Resources/MoviePictures/Shrek2.jpg","/Users/Combii/Dropbox/Datamatiker/3. Semester/Agil Aflevering/Kino Aflevering/src/main/Resources/MoviePictures/Shrek.jpg");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    */
}
