
package calculator;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import com.fazecast.jSerialComm.*;
import javafx.scene.control.TextField;

/**
 *
 * @author Marwa
 */
/*
you need to add these lines to create an instance of serialport and check if it is connected before adding it to your main code and calling the funcion
    SerialPort port;
    port = SerialPort.getCommPort("COM5"); //change with your com name
        if (port.openPort()) {
            System.out.println("Port opened successfully.");
        } else {
            System.out.println("Unable to open the port.");
            return;
        }
*/
public class KeypadHandler {
    String keys;
    public void getKeys( SerialPort port, TextField txtField) {
        Scanner data = new Scanner(port.getInputStream());
        Runnable task = new Runnable() {
            @Override
            public void run() {
                while (data.hasNextLine()) {
                    Platform.runLater(new Runnable() {

                        @Override
                        public void run() {
                            try {
                                keys = data.nextLine();
                                if (!keys.equals("")) {
                                    txtField.appendText(keys);
                                }
                            } catch (Exception e) {
                                System.out.println(e);
                            }
                        }
                    });
                    try {
                        Thread.sleep(16);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(CalcApp.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        };
        Thread backgroundThread = new Thread(task);
        backgroundThread.setDaemon(true);
        backgroundThread.start();
    }
}
