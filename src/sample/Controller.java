package sample;

import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.scene.SnapshotParameters;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

public class Controller {
    public ImageView imageView;
    private Point startingPoint = new Point();
    private Point endingPoint = new Point();

    public void exit(ActionEvent actionEvent) {
        System.exit(0);
    }

    public void importFile(ActionEvent actionEvent) {
        JOptionPane.showMessageDialog(null,"You selected: Import.");
    }

    public void exportFile(ActionEvent actionEvent) {
        JOptionPane.showMessageDialog(null,"You selected: Export File.");
    }

    public void save(ActionEvent actionEvent) {
        JOptionPane.showMessageDialog(null,"You selected: Save.");
    }

    public void saveAs(ActionEvent actionEvent) {
        JOptionPane.showMessageDialog(null,"You selected: Save As ....");
    }

    public void mouseClicked(MouseEvent mouseEvent){
        startingPoint = mouseEvent.getLocationOnScreen();
    }

    public void mouseDragged(MouseEvent mouseEvent){
        endingPoint = endingPoint.getLocation();
        Rectangle selectionRectangle = new Rectangle(startingPoint.x, startingPoint.y, endingPoint.x - startingPoint.x, endingPoint.y - startingPoint.y);
    }
}
