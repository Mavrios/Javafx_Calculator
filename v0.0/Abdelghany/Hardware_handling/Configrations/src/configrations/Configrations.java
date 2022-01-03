
package configrations;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class Configrations extends Application {
    
    @Override
   public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        scene.getStylesheets().add("style/Button.css");
        scene.getStylesheets().add("style/Base.css");
        scene.getStylesheets().add("style/Text.css");
        stage.setResizable(false);
        stage.setMinWidth(340);
        stage.setMinHeight(530);

        stage.initStyle(StageStyle.DECORATED);
        stage.setScene(scene);
        stage.getIcons().add(new Image("configrations/icon.png"));
        stage.setTitle("Calculator V1.1");
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
    
}
