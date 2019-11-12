package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
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
    private File currentFile = null;
    private ArrayList<TextField> labels = new ArrayList<>();
    private boolean newAnnotation;

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
                imageView.setImage(image);
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

            selectionRectangle.setWidth(Math.abs(endingPoint.x >= imageView.getFitWidth() ? imageView.getFitWidth() - startingPoint.x : mouseEvent.getX() - startingPoint.x));
            selectionRectangle.setHeight(Math.abs(endingPoint.y >= imageView.getFitHeight() ? imageView.getFitHeight() - startingPoint.y : mouseEvent.getY() - startingPoint.y));

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
}
