package calculatorv1.pkg0;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class SplashController implements Initializable {

    @FXML
    private AnchorPane splashAnchore;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        splash();
    }

    private void splash() {
        new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
                Platform.runLater(() -> {
                    try {
                        Stage stage = new Stage();
                        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
                        Scene scene = new Scene(root);
                        scene.getStylesheets().add("style/Button.css");
                        scene.getStylesheets().add("style/Base.css");
                        scene.getStylesheets().add("style/Text.css");
                        scene.getStylesheets().add("style/chart_style.css");
                        stage.setResizable(false);
                        stage.setMinWidth(340);
                        stage.setMinHeight(530);
                        stage.setMaxWidth(358);
                        stage.setMaxHeight(582);
                        stage.getIcons().add(new Image("calculatorv1/pkg0/icon.png"));
                        stage.initStyle(StageStyle.DECORATED);
                        stage.setScene(scene);
                        stage.setTitle("Calculator v1.0");
                        stage.show();
                        splashAnchore.getScene().getWindow().hide();
                    } catch (IOException ex) {
                        System.out.println(ex);
                    }
                });
            }

            }.start();
        }
    
    }
