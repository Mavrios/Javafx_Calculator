/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML.java to edit this template
 */
package javafxapplication2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Kishk
 */
public class JavaFXApplication2 extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add("javafxapplication2/Button.css");
        scene.getStylesheets().add("javafxapplication2/Base.css");
        scene.getStylesheets().add("javafxapplication2/Text.css");
        stage.setResizable(false);
        stage.setMinWidth(340);
        stage.setMinHeight(530);

        stage.initStyle(StageStyle.DECORATED);
        stage.setScene(scene);
        stage.setTitle("Calculator v0.0");
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
