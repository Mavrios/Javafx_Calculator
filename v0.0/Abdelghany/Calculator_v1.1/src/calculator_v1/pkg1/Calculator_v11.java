
package calculator_v1.pkg1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import jssc.SerialPort;
import jssc.SerialPortException;



public class Calculator_v11 extends Application {
    
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
        stage.setTitle("Calculator V1.1");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
        String str;

        //In the constructor pass the name of the port with which we work
        SerialPort serialPort = new SerialPort("COM3");

        try {
            //Open port
            serialPort.openPort();

            //We expose the settings. You can also use this line - serialPort.setParams(9600, 8, 1, 0);
            serialPort.setParams(SerialPort.BAUDRATE_9600,
                    SerialPort.DATABITS_8,
                    SerialPort.STOPBITS_1,
                    SerialPort.PARITY_NONE);



            Thread.sleep(1000);//Very important !!!



            //Read data from port
            for (int i = 0; i < 10; i++) {
                str = serialPort.readString();

                if (str != null) {
                    System.out.println(str);
                }

                Thread.sleep(500);
            }

            //Closing the port
            serialPort.closePort();

        } catch (SerialPortException ex) {
            System.out.println(ex);
        } catch (InterruptedException ex) {
            System.out.println(ex);
        }
    }
    
}
