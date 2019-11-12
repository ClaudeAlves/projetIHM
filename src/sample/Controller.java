package sample;

import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.scene.SnapshotParameters;
import javafx.scene.image.WritableImage;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class Controller {
    public void exit(ActionEvent actionEvent) {
        System.exit(0);
    }

    public void importFile(ActionEvent actionEvent) {
        JOptionPane.showMessageDialog(null,"You selected: Save.");
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

}
