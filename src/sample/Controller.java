package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.image.ImageView;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.awt.*;

import javafx.scene.image.Image;
import java.io.File;
import java.io.FileInputStream;

public class Controller {
    public ImageView imageView;
    public Pane drawingPanel;
    private Point startingPoint = new Point();
    private Point endingPoint = new Point();
    private Rectangle selectionRectangle;
    private Stage stage = new Stage();
    private File imageFile = null;
    private File whereToSave = null;

    public void exit(ActionEvent actionEvent) {
        System.exit(0);
    }

    public void importFile(ActionEvent actionEvent) {
        FileChooser chooser = new FileChooser();
        FileInputStream fileInStream;
        Image image;
        chooser.setTitle("Import image");
        imageFile = chooser.showOpenDialog(stage);
        if(imageFile != null) {
            try {
                fileInStream = new FileInputStream(imageFile);
                image = new Image(fileInStream);
                imageView.setImage(image);
                whereToSave = null;
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            alerting("Unable to perform import !");
        }
    }

    public void exportFile(ActionEvent actionEvent) {
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Export image");
        if(imageFile != null) {
            whereToSave = chooser.showSaveDialog(stage);
            if (whereToSave != null) {

            } else {
                alerting("Problem exporting file !");
            }
        } else {
            alerting("Nothing to export !");
        }
    }

    public void save(ActionEvent actionEvent) {
        if(whereToSave == null) {
            if(!isEmpty(imageView)) {
                saveAs(actionEvent);
            } else {

            }
        } else {
            // TODO : SAVE
        }
    }

    public void saveAs(ActionEvent actionEvent) {
        if(!isEmpty(imageView)) {
            FileChooser chooser = new FileChooser();
            chooser.setTitle("Save Image");
            whereToSave = chooser.showSaveDialog(stage);
            if (whereToSave != null) {
                // TODO : SAVE
            }
        } else {
            alerting("Nothing has been loaded");
        }
    }

    public void mouseClicked(MouseEvent mouseEvent){
        startingPoint = new Point((int)mouseEvent.getX(), (int)mouseEvent.getY());
        selectionRectangle.setStroke(Color.color(255, 0 ,0));
        drawingPanel.getChildren().add(selectionRectangle);
    }

    public void mouseDragged(MouseEvent mouseEvent){
        endingPoint = endingPoint.getLocation();
        selectionRectangle = new Rectangle(startingPoint.x, startingPoint.y, endingPoint.x - startingPoint.x, endingPoint.y - startingPoint.y);
    }

    private void alerting(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Error");
        alert.setHeaderText(message);
        alert.showAndWait();
    }

    public static boolean isEmpty(ImageView imageView) {
        Image image = imageView.getImage();
        return image == null || image.isError();
    }
}
