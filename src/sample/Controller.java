package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.image.ImageView;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.awt.*;

import javafx.scene.image.Image;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

public class Controller {
    public ImageView imageView;
    public Pane drawingPanel;
    public ScrollPane labelPane;
    public ColorPicker colorPicker;
    public ListView listLabel;
    public Pane mainPanel;
    private Point startingPoint = new Point();
    private Point endingPoint = new Point();
    private Rectangle selectionRectangle = new Rectangle();
    private Stage stage = new Stage();
    private ArrayList<TextField> labels = new ArrayList<>();
    private boolean newAnnotation;
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
        if(!isEmpty(imageView)) {
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
        if(!isEmpty(imageView)) {
            if(whereToSave == null) {
                saveAs(actionEvent);
            } else {
            }
        } else {
            alerting("Nothing has been loaded");
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

    public void setNewAnnotation(){
        newAnnotation = true;
    }

    public void mouseClicked(MouseEvent mouseEvent){
        if(newAnnotation) {
            startingPoint = new Point((int) mouseEvent.getX(), (int) mouseEvent.getY());
            selectionRectangle = new Rectangle();
            selectionRectangle.setX(startingPoint.x);
            selectionRectangle.setY(startingPoint.y);
            selectionRectangle.setStroke(colorPicker.getValue());
            selectionRectangle.setFill(null);
            drawingPanel.getChildren().add(selectionRectangle);
        }
    }

    public void mouseDragged(MouseEvent mouseEvent){
        if(newAnnotation) {
            endingPoint = new Point((int) mouseEvent.getX(), (int) mouseEvent.getY());

            selectionRectangle.setWidth(Math.abs(endingPoint.x>=imageView.getFitWidth() ? imageView.getFitWidth()-startingPoint.x : mouseEvent.getX()-startingPoint.x));
            selectionRectangle.setHeight(Math.abs(endingPoint.y>=imageView.getFitHeight() ? imageView.getFitHeight()-startingPoint.y : mouseEvent.getY()-startingPoint.y));

            selectionRectangle.setX(Math.min(startingPoint.x, endingPoint.x >= 0 ? mouseEvent.getX() : 0));
            selectionRectangle.setY(Math.min(startingPoint.y, endingPoint.y >= 0 ? mouseEvent.getY() : 0));
        }

    }

    public void mouseReleased(MouseEvent mouseEvent){
        if(newAnnotation) {
            startingPoint = null;
            endingPoint = null;
            newAnnotation = false;
            TextField label = new TextField();
            listLabel.getItems().add(label);
            label.requestFocus();
        }
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
