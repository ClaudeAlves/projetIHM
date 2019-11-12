package sample;

import javafx.event.ActionEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.File;
import java.io.FileInputStream;

public class Controller {
    private Stage stage = new Stage();
    private File currentFile = null;
    private ImageView imageView;
    public void exit(ActionEvent actionEvent) {
        System.exit(0);
    }

    public void importFile(ActionEvent actionEvent) {
        FileChooser chooser = new FileChooser();
        FileInputStream fileInStream;
        Image image;
        chooser.setTitle("Import image");
        currentFile = chooser.showOpenDialog(stage);
        if(currentFile != null) {
            try {
                fileInStream = new FileInputStream(currentFile);
                image = new Image(fileInStream);
                imageView = new ImageView(image);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {

        }
    }

    public void exportFile(ActionEvent actionEvent) {
        FileChooser chooser = new FileChooser();
        FileChooser.ExtensionFilter jpegFilter = new FileChooser.ExtensionFilter("JPEG","jpg");
        FileChooser.ExtensionFilter pdfFilter = new FileChooser.ExtensionFilter("BMP","bmp");
        FileChooser.ExtensionFilter gifFilter = new FileChooser.ExtensionFilter("GIF","gif");
        FileChooser.ExtensionFilter pngFilter = new FileChooser.ExtensionFilter("PNG","pnj");
        chooser.getExtensionFilters().addAll(jpegFilter, pdfFilter, gifFilter, pngFilter);
        chooser.setTitle("Export image");
        currentFile = chooser.showSaveDialog(stage);
        if(currentFile != null) {
            // TODO : SAVE THE IMAGE IN THE GOOD FORMAT
        } else {

        }
    }

    public void save(ActionEvent actionEvent) {
        if(currentFile == null) {
            saveAs(actionEvent);
        } else {
            // TODO : SAVE THE IMAGE IN THE FILE
        }
    }

    public void saveAs(ActionEvent actionEvent) {
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Save Image");
        currentFile = chooser.showSaveDialog(stage);
        if(currentFile != null) {
            // TODO : SAVE THE IMAGE IN THE FILE
        }
    }

}
