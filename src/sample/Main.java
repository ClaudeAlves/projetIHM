/**
 * @autor : Vetter Guillaume, Alves Claude-André
*/
package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setResizable(false);
        primaryStage.setTitle("IMAGE EDITOR 4500");
        primaryStage.setScene(new Scene(root, 1600, 900));
        primaryStage.show();
    }




    public static void main(String[] args) {
        launch(args);
    }
}
