package sample;

import javafx.event.ActionEvent;
import javafx.scene.image.ImageView;

import java;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.awt.*;
import java.io.File;

public class Controller {
    public ImageView imageView;
    public Pane drawingPanel;
    private Point startingPoint = new Point();
    private Point endingPoint = new Point();
    private Rectangle selectionRectangle;
    private Stage stage = new Stage();
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
        FileChooser.ExtensionFilter jpegFilter = new FileChooser.ExtensionFilter("JPEG","jpg");
        FileChooser.ExtensionFilter pdfFilter = new FileChooser.ExtensionFilter("PDF","pdf");
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

    public void mouseClicked(MouseEvent mouseEvent){
        startingPoint = new Point((int)mouseEvent.getX(), (int)mouseEvent.getY());
        selectionRectangle.setStroke(Color.color());
        drawingPanel.getChildren().add(selectionRectangle);
    }

    public void mouseDragged(MouseEvent mouseEvent){
        endingPoint = endingPoint.getLocation();
        selectionRectangle = new Rectangle(startingPoint.x, startingPoint.y, endingPoint.x - startingPoint.x, endingPoint.y - startingPoint.y);
    }
}
