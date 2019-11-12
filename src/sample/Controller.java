package sample;

import javafx.event.ActionEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class Controller {
    private Stage stage;
    private File currentFile = null;
    public void exit(ActionEvent actionEvent) {
        System.exit(0);
    }

    public void importFile(ActionEvent actionEvent) {
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Import image");
        currentFile = chooser.showOpenDialog(stage);
        if(currentFile != null) {
            // TODO : OPEN THE FILE IN THE EDITING ZONE
        } else {

        }
    }

    public void exportFile(ActionEvent actionEvent) {
        FileChooser chooser = new FileChooser();
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
