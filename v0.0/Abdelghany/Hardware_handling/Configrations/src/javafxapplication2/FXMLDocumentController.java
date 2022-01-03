package javafxapplication2;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import jssc.SerialPort;
import static jssc.SerialPort.MASK_RXCHAR;
import jssc.SerialPortEvent;
import jssc.SerialPortException;
import jssc.SerialPortList;

public class FXMLDocumentController implements Initializable {

    SerialPort arduinoPort = null;
    ObservableList<String> portList, port_listener;
    boolean detectPort_Flag = false;
    String new_Value;
    SerialPort serialPort;

    @FXML
    private ComboBox<String> Port;
    @FXML
    private TextField TextField;
    @FXML
    private Button Disconnect;
    @FXML
    private Circle Led;
    @FXML
    private Button Connect;
    @FXML
    private Button Detect;
    @FXML
    private Label About;
    @FXML
    private Label Conan;
    @FXML
    private Label Kishk;
    @FXML
    private Label Marwa;
    @FXML
    private Label Salma;
    @FXML
    private Label Fady;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        About.setFont(Font.font(20));
        Conan.setFont(Font.font(16));
        Kishk.setFont(Font.font(16));
        Marwa.setFont(Font.font(16));
        Salma.setFont(Font.font(16));
        Fady.setFont(Font.font(16));
        Led.setVisible(false);
        Connect.setDisable(true);
        Disconnect.setDisable(true);
        detectPort();
        Port.setItems(FXCollections.observableArrayList(portList));
        Port.valueProperty()
                .addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
                    System.out.println(newValue);
                    Connect.setDisable(false);
                    Disconnect.setDisable(false);
                    new_Value = newValue;
                });
    }

    private void detectPort() {

        if (portList != null) {
            portList.clear();
        }
        portList = FXCollections.observableArrayList();
        String[] serialPortNames = SerialPortList.getPortNames();

        for (String name : serialPortNames) {
            System.out.println(name);
            portList.add(name);
        }
    }

    public boolean connectArduino(String port) {

        System.out.println("Arduino connected");
        TextField.clear();
        boolean success = false;
        serialPort = new SerialPort(port);
        if (!serialPort.isOpened()) {
            try {
                Led.setVisible(true);
                TextField.appendText("Connected");
                serialPort.openPort();
                serialPort.setParams(
                        SerialPort.BAUDRATE_9600,
                        SerialPort.DATABITS_8,
                        SerialPort.STOPBITS_1,
                        SerialPort.PARITY_NONE);
                if (SerialPortList.getPortNames() != null) {
                    serialPort.setEventsMask(MASK_RXCHAR);
                }
                serialPort.addEventListener((SerialPortEvent serialPortEvent) -> {
                    if (serialPortEvent.isRXCHAR()) {
                        try {
                            String st = serialPort.readString(serialPortEvent
                                    .getEventValue());
                            System.out.println(st);

                            Platform.runLater(() -> {
                                TextField.appendText(st);
                            });
                        } catch (SerialPortException ex) {
                            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                });

                success = true;

                return success;
            } catch (SerialPortException ex) {
                Led.setVisible(false);
                TextField.clear();
                TextField.appendText("Redetect Port");
                portList.clear();
                Port.setItems(FXCollections.observableArrayList(portList));
                System.out.println("Serial -_-");
            }
        }
        return success;
    }

    public void disconnectArduino() throws SerialPortException {
        TextField.clear();
        portList = FXCollections.observableArrayList();
        System.out.println("Arduino disconnected");
        Led.setVisible(false);
        if (serialPort != null) {
            try {
                serialPort.removeEventListener();
                if (serialPort.isOpened()) {
                    serialPort.closePort();
                }
                TextField.appendText("Disconnected");
            } catch (SerialPortException ex) {
                System.out.println("Serial -_-");
                TextField.appendText("Redetect Port");
                portList.clear();
                Port.setItems(FXCollections.observableArrayList(portList));
            }

        }
    }

    @FXML
    private void Connect(MouseEvent event) {
        connectArduino(new_Value);
        Connect.setDisable(true);
        Disconnect.setDisable(false);

    }

    @FXML
    private void Disconnect(MouseEvent event) throws SerialPortException {
        disconnectArduino();
        Disconnect.setDisable(true);
        Connect.setDisable(false);
    }

    public void onstop() throws Exception {
        disconnectArduino();
        System.exit(10);
    }

    @FXML
    private void handleButton(KeyEvent event) {
    }

    @FXML
    private void Detect(MouseEvent event) {
        detectPort();
        Port.setItems(FXCollections.observableArrayList(portList));
        Port.valueProperty()
                .addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
                    System.out.println(newValue);
                    Connect.setDisable(false);
                    Disconnect.setDisable(true);
                    new_Value = newValue;
                });
    }

}
