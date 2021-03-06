/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package calculatorv1.pkg0;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.URL;
import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;
import jssc.SerialPort;
import static jssc.SerialPort.MASK_RXCHAR;
import jssc.SerialPortEvent;
import jssc.SerialPortException;
import jssc.SerialPortList;

/**
 *
 * @author Kishk
 */
public class FXMLDocumentController implements Initializable {

    /**
     * * (2) - '2' Defining Some Global Variables which are used in handling
     * the algorithm we want*****
     */
    boolean FLAGS;
    boolean BIN_FLAG = false;
    boolean OCT_FLAG = false;
    boolean HEX_FLAG = false;
    boolean DEC_FLAG = true;

    boolean AND_FLAG = false;
    boolean OR_FLAG = false;
    boolean XOR_FLAG = false;
    boolean trigoInv = false;
    //boolean NOT_FLAG
    boolean TEXT_2 = false; // Flag for checking about which text Atrea(text_Area , text_Area2) will choose to append

    int EQ_FLAG = 0;

    long ans = 0; //to store in it the old values 

    SerialPort arduinoPort = null;
    ObservableList<String> portList, port_listener;
    boolean detectPort_Flag = false;
    String new_Value;
    SerialPort serialPort;

    int d1, d2, m1, m2, y1, y2;
    long daysCounter, monthsCounter, yearsCounter;
    LocalDate startDate, endDate;
    String Yaxis = "";
    String Xaxis = "";
    String endPt = "50";
    int range = 50;
    String eqn = "";
    String eqnTmp = "";
    Double Graphing_Y = 0.0;

    String ArduinoRecieved;

    public Button button1;
    ObservableList list = FXCollections.observableArrayList();
    @FXML
    private TextField TA;
    Integer factorial;
    String Y = "";
    String X = "";
    int x = 0, y = 0;
    boolean scnd_flag = false;
    boolean Sci_scnd_flag = false;
    boolean flag = true;
    boolean I_flag = true;
    boolean R_flag = false;
    boolean toggleSign = false;
    boolean powFlag = false;
    boolean sqrFlag = false;
    boolean FactFlag = false;
    boolean Function_Flag = false;
    boolean logbase = false;
    boolean trioFlag = false;
    boolean hypFlag = false;
    boolean twoInputFlag = false;
    boolean History_Flag = false;
    boolean Length_Flag = false;
    boolean Scientific_Flag = true;
    boolean DateCalc_Flag = false;
    boolean Temperature_Flag = false;
    boolean Programmer_Flag = false;
    boolean Graph_Flag = false;
    boolean GraphTF_Flag = false;
    boolean startTF_Flag = false;
    boolean endTF_Flag = false;
    String TA_Value = "";
    String factVal = "";
    String progEqn = "";
    @FXML
    private VBox Vbox;
    boolean Vbox_Flag = false;
    boolean Menu_Flag = false;
    boolean serverFound = false;
    ScriptEngineManager EqnManager;
    ScriptEngine engine;
    Socket mySocket;
    DataInputStream dis;
    PrintStream ps;
    BufferedReader br;
    File file;

    Robot r;
    @FXML
    private AnchorPane ScientificPane;
    @FXML
    private Button button7;
    @FXML
    private Button button8;
    @FXML
    private Button button9;
    @FXML
    private Button buttonDiv;
    @FXML
    private Button button4;
    @FXML
    private Button button5;
    @FXML
    private Button button6;
    @FXML
    private Button buttonMulti;
    @FXML
    private Button button2;

    @FXML
    private Button buttonMin;
    @FXML
    private Button buttonC;
    @FXML
    private Button button0;
    @FXML
    private Button buttonPlus;
    @FXML
    private Button buttonDot;
    @FXML
    private Button equals;
    @FXML
    private Button button3;
    @FXML
    private Button buttonMod;
    @FXML
    private Button buttonBks;
    @FXML
    private Button buttonExp;
    @FXML
    private Button buttonFact;
    @FXML
    private Button buttonEuler;
    @FXML
    private Button buttonAbs;
    @FXML
    private Button buttonCBraces;
    @FXML
    private Button buttonPI;
    @FXML
    private Button buttonDivX;
    @FXML
    private Button buttonOBraces;
    @FXML
    private Button buttonPM;
    @FXML
    private Button button2nd;
    @FXML
    private Button buttonPower2;
    @FXML
    private Button buttonSqrt;
    @FXML
    private Button buttonXpY;
    @FXML
    private Button button10PowerX;
    @FXML
    private Button buttonLog;
    @FXML
    private Button buttonSin;
    @FXML
    private Button buttonCos;
    @FXML
    private Button buttonTan;
    @FXML
    private Button buttonSec;
    @FXML
    private Button buttonCsc;
    @FXML
    private Button buttonCot;
    @FXML
    private Button buttonTrio2nd;
    @FXML
    private Button buttonHyp;
    @FXML
    private Button buttonLn;
    @FXML
    private ToggleButton TogButton;
    @FXML
    private VBox MenuBox;
    @FXML
    private VBox FunctionsMenu;
    @FXML
    private ToggleButton TogButton1;
    @FXML
    private Button zero;
    @FXML
    private Button one;
    @FXML
    private Button two;
    @FXML
    private Button three;
    @FXML
    private Button four;
    @FXML
    private Button five;
    @FXML
    private Button six;
    @FXML
    private Button seven;
    @FXML
    private Button eight;
    @FXML
    private Button nine;
    @FXML
    private Button dot;
    @FXML
    private Button clear;
    @FXML
    private TextField TA1;
    @FXML
    private TextField TA2;
    @FXML
    private ComboBox<String> box2;
    @FXML
    private ComboBox<String> box1;
    @FXML
    private VBox MenuBox1;
    @FXML
    private AnchorPane LengthPane;
    @FXML
    private ComboBox<Integer> StartDay;
    @FXML
    private ComboBox<String> StartMonth;
    @FXML
    private ComboBox<Integer> StartYear;
    @FXML
    private ComboBox<Integer> EndDay;
    @FXML
    private ComboBox<String> EndMonth;
    @FXML
    private ComboBox<Integer> EndYear;
    @FXML
    private CheckBox EndDateCheckBox;
    @FXML
    private Button calculateButton;
    @FXML
    private Label StartDataLabel;
    @FXML
    private Label resultLabel;
    @FXML
    private VBox MenuBox2;
    @FXML
    private AnchorPane DateCalcPane;
    @FXML
    private AnchorPane GarphingPane;
    @FXML
    private Label label;
    @FXML
    private LineChart<String, Number> lineChart;
    @FXML
    private NumberAxis Axis;
    @FXML
    private CategoryAxis x_Axis;
    @FXML
    private Button PlotBtn;
    @FXML
    private TextArea plotEqn;
    @FXML
    private TextField startTF;
    @FXML
    private TextField endTF;
    @FXML
    private VBox GraphingMenuBox;
    @FXML
    private Button AbsButton;
    @FXML
    private Button FloorButton;
    @FXML
    private Button CeilButton;
    @FXML
    private Button RandButton;
    @FXML
    private AnchorPane ConfigurationPane;
    @FXML
    private TextField TextField;
    @FXML
    private ComboBox<String> Port;
    @FXML
    private Button Disconnect;
    @FXML
    private Button Connect;
    @FXML
    private Circle Led;
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
    @FXML
    private VBox ConfigurationMenu;
    @FXML
    private AnchorPane HistoryPane;
    @FXML
    private TextArea History_TA;
    @FXML
    private Button ScientificMenuButton;
    @FXML
    private Button GraphingMenuButton;
    @FXML
    private Button ProgrammerMenuButton;
    @FXML
    private Button DateCalcMenuButton;
    @FXML
    private Button LengthMenuButton;
    @FXML
    private Button TempMenuButton;
    @FXML
    private Button ConfigurationsMenuButton;
    @FXML
    private AnchorPane TemperaturePane;
    @FXML
    private Button zero1;
    @FXML
    private Button one1;
    @FXML
    private Button two1;
    @FXML
    private Button three1;
    @FXML
    private Button four1;
    @FXML
    private Button five1;
    @FXML
    private Button six1;
    @FXML
    private Button seven1;
    @FXML
    private Button eight1;
    @FXML
    private Button nine1;
    @FXML
    private Button dot1;
    @FXML
    private Button clear1;
    @FXML
    private TextField TA11;
    @FXML
    private TextField TA21;
    @FXML
    private ComboBox<String> box21;
    @FXML
    private ComboBox<String> box11;
    @FXML
    private VBox TempMenu;
    @FXML
    private Button ScientificMenuButton1;
    @FXML
    private Button GraphingMenuButton1;
    @FXML
    private Button ProgrammerMenuButton1;
    @FXML
    private Button DateCalcMenuButton1;
    @FXML
    private Button LengthMenuButton1;
    @FXML
    private Button TempMenuButton1;
    @FXML
    private Button ConfigurationsMenuButton1;
    @FXML
    private Button TempMenuButton2;
    @FXML
    private Button TempMenuButton21;
    @FXML
    private AnchorPane ProgrammerPane;
    @FXML
    private Button btn_0;
    @FXML
    private Button btn_1;
    @FXML
    private Button btn_2;
    @FXML
    private Button btn_3;
    @FXML
    private Button btn_4;
    @FXML
    private Button btn_5;
    @FXML
    private Button btn_6;
    @FXML
    private Button btn_7;
    @FXML
    private Button btn_8;
    @FXML
    private Button btn_9;
    @FXML
    private TextField label_OCT;
    @FXML
    private TextField label_DEC;
    @FXML
    private TextField label_HEX;
    @FXML
    private TextField label_BIN;
    @FXML
    private Button btn_BIN;
    @FXML
    private Button btn_OCT;
    @FXML
    private Button btn_HEX;
    @FXML
    private Button btn_DEC;
    @FXML
    private TextArea text_Area;
    @FXML
    private Button btn_C;
    @FXML
    private Button btn_NOT;
    @FXML
    private Button btn_XOR;
    @FXML
    private Button btn_AND;
    @FXML
    private Button btn_OR;
    @FXML
    private Button btn_F;
    @FXML
    private Button btn_E;
    @FXML
    private Button btn_D;
    @FXML
    private Button btn_B;
    @FXML
    private Button btn_A;
    @FXML
    private Button btn_equal;
    @FXML
    private TextArea text_Area2;
    @FXML
    private Label operation;
    @FXML
    private Button btn_equal1;
    @FXML
    private VBox ProgrammerMenu;
    @FXML
    private Button ScientificMenuButton2;
    @FXML
    private Button GraphingMenuButton2;
    @FXML
    private Button ProgrammerMenuButton2;
    @FXML
    private Button DateCalcMenuButton2;
    @FXML
    private Button LengthMenuButton2;
    @FXML
    private Button ConfigurationsMenuButton2;
    @FXML
    private Button ScientificMenuButton3;
    @FXML
    private Button GraphingMenuButton3;
    @FXML
    private Button ProgrammerMenuButton3;
    @FXML
    private Button DateCalcMenuButton3;
    @FXML
    private Button LengthMenuButton3;
    @FXML
    private Button ConfigurationsMenuButton3;
    @FXML
    private Button GraphNow;
    @FXML
    private Button ScientificMenuButton4;
    @FXML
    private Button GraphingMenuButton4;
    @FXML
    private Button ProgrammerMenuButton4;
    @FXML
    private Button DateCalcMenuButton4;
    @FXML
    private Button LengthMenuButton4;
    @FXML
    private Button TempMenuButton4;
    @FXML
    private Button ConfigurationsMenuButton4;
    @FXML
    private AnchorPane HistoryPane1;
    @FXML
    private TextArea History_TA1;
    @FXML
    private Button btn_Clear;
    @FXML
    private Button ScientificMenuButton5;
    @FXML
    private Button GraphingMenuButton5;
    @FXML
    private Button ProgrammerMenuButton5;
    @FXML
    private Button DateCalcMenuButton5;
    @FXML
    private Button LengthMenuButton5;
    @FXML
    private Button TempMenuButton5;
    @FXML
    private Button ConfigurationsMenuButton5;
    @FXML
    private Button ScientificMenuButton6;
    @FXML
    private Button GraphingMenuButton6;
    @FXML
    private Button ProgrammerMenuButton6;
    @FXML
    private Button DateCalcMenuButton6;
    @FXML
    private Button LengthMenuButton6;
    @FXML
    private Button TempMenuButton6;
    @FXML
    private Button ConfigurationsMenuButton6;

    @FXML
    private void btnRightBrace() {
        if (R_flag == true) {
            TA.clear();
        }

        flag = true;
        R_flag = false;
        TA.appendText("(");
    }

    @FXML
    private void btnLeftBrace() {
        if (R_flag == true) {
            TA.clear();
        }
        MenuVisibility();
        flag = true;
        R_flag = false;
        TA.appendText(")");
        sqrFlag = false;

    }

    @FXML
    private void handleButtonAction1() {
        if (R_flag == true) {
            TA.clear();
        }
        MenuVisibility();
        flag = true;
        R_flag = false;
        TA.appendText("1");
        if (sqrFlag || trioFlag || FactFlag) {
            TA_Value = TA_Value + '1';
        }

        if (twoInputFlag) {
            Y = Y + "1";

        } else {
            X = X + "1";
        }
    }

    @FXML
    private void handleButtonAction2() {
        if (R_flag == true) {
            TA.clear();
        }
        MenuVisibility();
        flag = true;
        R_flag = false;
        TA.appendText("2");

        if (sqrFlag || trioFlag || FactFlag) {
            TA_Value = TA_Value + '2';

        }

        if (twoInputFlag) {
            Y = Y + "2";

        } else {
            X = X + "2";
        }
    }

    @FXML
    private void handleButtonAction3() {
        if (R_flag == true) {
            TA.clear();
        }
        MenuVisibility();
        flag = true;
        R_flag = false;
        if (sqrFlag || trioFlag || FactFlag) {
            TA_Value = TA_Value + '3';

        }

        TA.appendText("3");

        if (twoInputFlag) {
            Y = Y + "3";

        } else {
            X = X + "3";
        }
    }

    @FXML
    private void handleButtonAction4() {
        if (R_flag == true) {
            TA.clear();
        }
        if (sqrFlag || trioFlag || FactFlag) {
            TA_Value = TA_Value + '4';

        }

        MenuVisibility();
        flag = true;
        R_flag = false;
        TA.appendText("4");

        if (twoInputFlag) {
            Y = Y + "4";

        } else {
            X = X + "4";
        }
    }

    @FXML
    private void handleButtonAction5() {
        if (R_flag == true) {
            TA.clear();
        }
        if (sqrFlag || trioFlag || FactFlag) {
            TA_Value = TA_Value + '5';

        }

        MenuVisibility();
        flag = true;
        R_flag = false;
        TA.appendText("5");

        if (twoInputFlag) {
            Y = Y + "5";

        } else {
            X = X + "5";
        }
    }

    @FXML
    private void handleButtonAction6() {
        if (R_flag == true) {
            TA.clear();
        }
        if (sqrFlag || trioFlag || FactFlag) {
            TA_Value = TA_Value + '6';
        }

        MenuVisibility();
        flag = true;
        R_flag = false;
        TA.appendText("6");

        if (twoInputFlag) {
            Y = Y + "6";

        } else {
            X = X + "6";
        }
    }

    @FXML
    private void handleButtonAction7() {
        if (R_flag == true) {
            TA.clear();
        }
        if (sqrFlag || trioFlag || FactFlag) {
            TA_Value = TA_Value + '7';

        }

        MenuVisibility();
        flag = true;
        R_flag = false;
        TA.appendText("7");

        if (twoInputFlag) {
            Y = Y + "7";

        } else {
            X = X + "7";
        }
    }

    @FXML
    private void handleButtonAction8() {
        if (R_flag == true) {
            TA.clear();
        }
        if (sqrFlag || trioFlag || FactFlag) {
            TA_Value = TA_Value + '8';

        }

        MenuVisibility();
        flag = true;
        R_flag = false;
        TA.appendText("8");

        if (twoInputFlag) {
            Y = Y + "8";

        } else {
            X = X + "8";
        }
    }

    @FXML
    private void handleButtonAction9() {
        if (R_flag == true) {
            TA.clear();
        }
        if (sqrFlag || trioFlag || FactFlag) {
            TA_Value = TA_Value + '9';

        }

        MenuVisibility();
        flag = true;
        R_flag = false;
        TA.appendText("9");

        if (twoInputFlag) {
            Y = Y + "9";

        } else {
            X = X + "9";
        }
    }

    @FXML
    private void handleButtonAction0() {
        if (R_flag == true) {
            TA.clear();
        }
        if (sqrFlag || trioFlag || FactFlag) {
            TA_Value = TA_Value + '0';

        }

        MenuVisibility();
        flag = true;
        R_flag = false;
        TA.appendText("0");

        if (twoInputFlag) {
            Y = Y + "0";

        } else {
            X = X + "0";
        }
    }
//----------------------------------------

    @FXML
    private void btnMod() {
        if (R_flag == true) {
            TA.clear();
        }
        MenuVisibility();
        flag = true;
        R_flag = false;
        TA.appendText("%");

    }

    @FXML
    private void btnPI() {
        if (R_flag == true) {
            TA.clear();
        }
        MenuVisibility();
        flag = true;
        R_flag = false;
        TA.appendText("??");
    }

    @FXML
    private void btnE() {
        if (R_flag == true) {
            TA.clear();
        }
        MenuVisibility();
        flag = true;
        R_flag = false;
        TA.appendText("??");
    }

    @FXML
    private void btnExp() {
        if (R_flag == true) {
            TA.clear();
        }
        MenuVisibility();
        flag = true;
        R_flag = false;
        TA.appendText(".e+0");
    }

    @FXML
    private void btnInv() {
        if (R_flag == true) {
            TA.clear();
        }
        MenuVisibility();
        flag = true;
        R_flag = false;
        TA.appendText("1/(");
    }

    @FXML
    private void btnToggleSign() {
        if (!TA.getText().equals('0')) {
            toggleSign = true;
        }
        MenuVisibility();
    }

    @FXML
    private void btnXpowY() {
        twoInputFlag = true;
        equals.setText(",");
        if (R_flag == true) {
            TA.clear();
        }
        MenuVisibility();

        flag = true;
        R_flag = false;
        if (!Sci_scnd_flag) {
            TA.appendText("pow(");
        } else {
            TA.appendText("pow(");
            powFlag = true;
        }

    }

    @FXML
    private void btnTenpowX() {
        if (R_flag == true) {
            TA.clear();
        }
        MenuVisibility();
        flag = true;
        R_flag = false;
        if (!Sci_scnd_flag) {
            TA.appendText("10^(");
        } else {
            TA.appendText("pow(2,");
        }
    }

    @FXML
    private void btnLog() {
        if (R_flag == true) {
            TA.clear();
        }
        MenuVisibility();
        flag = true;
        Y = "";
        X = "";
        R_flag = false;
        if (Sci_scnd_flag) {
            TA.appendText("logyX(");
            equals.setText(",");
            twoInputFlag = true;
            logbase = true;
        } else {
            TA.appendText("log(");
        }

    }

    @FXML
    private void btnLn() {
        if (R_flag == true) {
            TA.clear();
        }
        MenuVisibility();
        flag = true;
        R_flag = false;
        if (!Sci_scnd_flag) {
            TA.appendText("ln(");
        } else {
            TA.appendText("exp(");
        }
    }

    @FXML
    private void btnSqr() {
        if (R_flag == true) {
            TA.clear();
        }
        MenuVisibility();
        flag = true;
        R_flag = false;
        TA_Value = "";
        if (!Sci_scnd_flag) {
            TA.appendText("sqr(");
        } else {
            TA.appendText("cube(");
        }
        sqrFlag = true;
    }

    @FXML
    private void btnSqrt() {

        if (R_flag == true) {
            TA.clear();
        }
        MenuVisibility();
        flag = true;
        R_flag = false;
        if (!Sci_scnd_flag) {
            TA.appendText("sqrt(");
        } else {
            TA.appendText("cbrt(");
        }
    }

    @FXML
    private void btnAbs() {
        if (R_flag == true) {
            TA.clear();
        }
        MenuVisibility();
        flag = true;
        R_flag = false;
        TA.appendText("abs(");
    }

    @FXML
    private void btnFact() {
        if (R_flag == true) {
            TA.clear();
        }
        MenuVisibility();
        FactFlag = true;
        flag = true;
        R_flag = false;
        TA.appendText("fact(");

    }

    @FXML
    private void btnSin() {
        if (R_flag == true) {
            TA.clear();
        }
        MenuVisibility();

        flag = true;
        R_flag = false;
        if (!scnd_flag && !hypFlag) {
            TA.appendText("sin(");
        } else if (scnd_flag && !hypFlag) {
            TA.appendText("sin-1(");
        } else if (!scnd_flag && hypFlag) {
            TA.appendText("sinh(");
            trioFlag = true;
        } else {
            TA.appendText("sinh-1(");
            trioFlag = true;
        }

    }

    @FXML
    private void btnCos() {
        if (R_flag == true) {
            TA.clear();
        }
        MenuVisibility();

        flag = true;
        R_flag = false;
        if (!scnd_flag && !hypFlag) {
            TA.appendText("cos(");
        } else if (scnd_flag && !hypFlag) {
            TA.appendText("cos-1(");
        } else if (!scnd_flag && hypFlag) {
            TA.appendText("cosh(");
            trioFlag = true;
        } else {
            TA.appendText("cosh-1(");
            trioFlag = true;
        }

    }

    @FXML
    private void btnTan() {
        if (R_flag == true) {
            TA.clear();
        }
        MenuVisibility();

        flag = true;
        R_flag = false;
        if (!scnd_flag && !hypFlag) {
            TA.appendText("tan(");
        } else if (scnd_flag && !hypFlag) {
            TA.appendText("tan-1(");
        } else if (!scnd_flag && hypFlag) {
            TA.appendText("tanh(");
            trioFlag = true;
        } else {
            TA.appendText("tanh-1(");
            trioFlag = true;
        }

    }

    @FXML
    private void btnSec() {
        if (R_flag == true) {
            TA.clear();
        }
        MenuVisibility();

        flag = true;
        R_flag = false;
        if (!scnd_flag && !hypFlag) {
            TA.appendText("sec(");
        } else if (scnd_flag && !hypFlag) {
            trioFlag = true;
            TA.appendText("sec-1(");
            trioFlag = true;
            trigoInv = true;
        } else if (!scnd_flag && hypFlag) {
            TA.appendText("sech(");
            trioFlag = true;
        } else {
            TA.appendText("sech-1(");
            trioFlag = true;
        }

    }

    @FXML
    private void btnCsc() {
        if (R_flag == true) {
            TA.clear();
        }
        MenuVisibility();

        flag = true;
        R_flag = false;
        if (!scnd_flag && !hypFlag) {
            TA.appendText("csc(");
        } else if (scnd_flag && !hypFlag) {
            TA.appendText("csc-1(");
            trioFlag = true;
            trigoInv = true;
        } else if (!scnd_flag && hypFlag) {
            TA.appendText("csch(");
            trioFlag = true;
        } else {
            TA.appendText("csch-1(");
            trioFlag = true;
        }

    }

    @FXML
    private void btnCot() {
        if (R_flag == true) {
            TA.clear();
        }
        MenuVisibility();

        flag = true;
        R_flag = false;
        if (!scnd_flag && !hypFlag) {
            TA.appendText("cot(");
        } else if (scnd_flag && !hypFlag) {
            TA.appendText("cot-1(");
            trioFlag = true;
            trigoInv = true;
        } else if (!scnd_flag && hypFlag) {
            TA.appendText("coth(");
            trioFlag = true;
        } else {
            TA.appendText("coth-1(");
            trioFlag = true;
        }

    }

    @FXML
    private void btnFloor() {
        if (R_flag == true) {
            TA.clear();
        }
        MenuVisibility();

        flag = true;
        R_flag = false;
        TA.appendText("floor(");

    }

    @FXML
    private void btnCeil() {
        if (R_flag == true) {
            TA.clear();
        }
        MenuVisibility();

        flag = true;
        R_flag = false;
        TA.appendText("ceil(");

    }

    @FXML
    private void btnRand() {
        if (R_flag == true) {
            TA.clear();
        }
        MenuVisibility();

        flag = true;
        R_flag = false;
        TA.appendText("rand");

    }
//-----------------------------------------

    @FXML
    private void handleButtonActionP() {
        if (flag == false) {
            TA.deleteText(TA.getLength() - 1, TA.getLength());
        }
        MenuVisibility();
        R_flag = false;
        flag = false;
        TA.appendText("+");
    }

    @FXML
    private void handleButtonActionN() {
        if (flag == false) {
            TA.deleteText(TA.getLength() - 1, TA.getLength());
        }
        MenuVisibility();
        R_flag = false;
        flag = false;
        TA.appendText("-");
    }

    @FXML
    private void handleButtonActionM() {
        if (flag == false) {
            TA.deleteText(TA.getLength() - 1, TA.getLength());
        }
        MenuVisibility();
        R_flag = false;
        flag = false;
        TA.appendText("*");
    }

    @FXML
    private void handleButtonActionD() {
        if (flag == false) {
            TA.deleteText(TA.getLength() - 1, TA.getLength());
        }
        MenuVisibility();
        R_flag = false;
        flag = false;
        TA.appendText("/");
    }

    @FXML
    private void handleButtonActionDot() {
        TA.appendText(".");
        if (sqrFlag || trioFlag) {
            TA_Value = TA_Value + '.';

        }
        MenuVisibility();
        R_flag = false;
        flag = true;
    }

    @FXML
    private void handleButtonActionC() {
        flag = true;
        R_flag = false;
        MenuVisibility();
        TA_Value = "";
        Y = "";
        X = "";

        TA.clear();
    }

    public String Calculate_Eqn(String tmp) {

        if (tmp.equals("sec(90)")) {
            tmp = "1/0";
        }
        if (logbase) {
            tmp = tmp.replace("(" + Y + "," + X + ")", "");
            logbase = false;
        }
        if (trigoInv) {
            tmp = tmp.replace("sec-1(", "(180/Math.PI)*Math.acos(1/" + TA_Value + ")" + "*-1*((" + TA_Value + "-1)-")
                    .replace("csc-1(", "(180/Math.PI)*Math.asin(1/" + TA_Value + ")" + "*-1*((" + TA_Value + "-1)-")
                    .replace("cot-1(", "(180/Math.PI)*Math.atan(1/" + TA_Value + ")" + "*-1*((" + TA_Value + "-1)-");

        } else {
            tmp = tmp.
                    replace("??", "Math.E").
                    replace("sqrt", "Math.sqrt").
                    replace("cbrt", "java.lang.Math.cbrt").
                    replace("pow", "Math.pow").
                    replace("log", "java.lang.Math.log10").
                    replace("java.lang.Math.log10yX", "java.lang.Math.log10(" + Y + ")/java.lang.Math.log10(" + X + ")").
                    replace("ln", "Math.log").
                    replace("??", "Math.PI").
                    replace("cube(", ('(' + TA_Value + '*' + TA_Value + '*')).
                    replace("Math.Exp", "Math.exp").
                    replace("abs", "Math.abs").
                    replace("10^(", "Math.pow(10,").
                    replace(".Math.E", ".e").
                    replace("floor", "Math.floor").
                    replace("ceil", "Math.ceil").
                    replace("rand", "Math.random()").
                    replace("sech-1(", " Math.log((1/" + TA_Value + ") + Math.sqrt((1/(" + TA_Value + "*" + TA_Value + ")) - 1.0))*-1*((" + TA_Value + "-1)-").
                    replace("csch-1(", "Math.log((1/(" + TA_Value + ")) + Math.sqrt((1/(" + TA_Value + "*" + TA_Value + ")) + 1.0))*-1*((" + TA_Value + "-1)-").
                    replace("coth-1(", "0.5*(Math.log((1/(" + TA_Value + " ))+ 1.0) - Math.log(" + "1-(1/(" + TA_Value + " ))))*-1*((" + TA_Value + "-1)-").
                    replace("sinh-1(", "Math.log(" + TA_Value + " + Math.sqrt(" + TA_Value + "*" + TA_Value + " + 1.0))*-1*((" + TA_Value + "-1)-").
                    replace("cosh-1(", " Math.log(" + TA_Value + " + Math.sqrt(" + TA_Value + "*" + TA_Value + " - 1.0))*-1*((" + TA_Value + "-1)-").
                    replace("tanh-1(", "0.5*(Math.log(" + TA_Value + " + 1.0) - Math.log(" + "1-" + TA_Value + " ))*-1*((" + TA_Value + "-1)-").
                    replace("sech(", "1/cosh( ").
                    replace("csch(", "1/sinh( ").
                    replace("coth(", "1 / (tanh( ").
                    replace("tanh(", "sinh(" + TA_Value + ")" + "/" + "cosh(" + TA_Value + ")*-1*((" + TA_Value + "-1)-").
                    replace("sinh(", "((Math.exp(" + TA_Value + ")" + "-Math.exp(-" + TA_Value + "))/2)*-1*((" + TA_Value + "-1)-").
                    replace("cosh(", "((Math.exp(" + TA_Value + ")" + "+Math.exp(-" + TA_Value + "))/2)*-1*((" + TA_Value + "-1)-").
                    replace("sec", "1/cos").
                    replace("csc", "1/sin").
                    replace("cot", "1/tan").
                    replace("sin(", "Math.sin( (Math.PI/180)*").
                    replace("cos(", "Math.cos( (Math.PI/180)*").
                    replace("tan(", "Math.tan( (Math.PI/180)*").
                    replace("sin-1(", "(180/Math.PI)*Math.asin(").
                    replace("cos-1(", "(180/Math.PI)*Math.acos(").
                    replace("tan-1(", "(180/Math.PI)*Math.atan(").
                    replace("*-1*((" + TA_Value + "-1)-" + TA_Value + ")*-1*((" + TA_Value + "-1)- " + TA_Value + ")", "*-1*((" + TA_Value + "-1)-" + TA_Value + ")*-1*((" + TA_Value + "-1)- " + TA_Value + "))").
                    replace("sqr(", ('(' + TA_Value + '*'));
        }
        trigoInv = false;
        return tmp;
    }

    @FXML
    private void handleButtonActionEqu() {
        String factTA = "";
        if (twoInputFlag) {
            TA.appendText(",");
            if (powFlag) {
                TA.appendText("1/");
            }
            twoInputFlag = false;
            equals.setText("=");
        } else {

            flag = true;
            MenuVisibility();
            R_flag = true;
            powFlag = false;

            if (FactFlag) {

                String factTemp = TA.getText();
                factTA = factTemp;
                factorial = Integer.parseInt(TA_Value);
                TA.clear();
                int i;
                Integer sum = 1;
                for (i = 1; i <= factorial; i++) {
                    sum = sum * i;
                }

                factTemp = factTemp.replace("fact(" + TA_Value + ")", sum.toString());
                TA.setText(factTemp);

            }

            if (toggleSign) { //needs adjustments
                TA.appendText("*-1");
                toggleSign = false;
            }
            System.out.println(TA.getText());

            String tmp = Calculate_Eqn(TA.getText());
            TA_Value = "";
            trioFlag = false;
            System.out.println(tmp);

            try {
                if (!TA.getText().isEmpty()) {
                    Double trial = Double.parseDouble(engine.eval(tmp).toString());
                    if (FactFlag) {
                        TA.replaceText(0, TA.getLength(), factTA);
                    }
                    if (serverFound) {
                        ps.println(TA.getText() + " = " + String.format("%.8f", trial));
                    } else {
                        History_TA.appendText(TA.getText() + " = " + String.format("%.8f", trial) + "\n");
                    }
                    TA.setText(String.format("%.8f", trial));
                }
            } catch (ScriptException e) {
                TA.setText("Undefined!!");
            }
            FactFlag = false;
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            mySocket = new Socket("127.0.0.1", 5005);
            ps = new PrintStream(mySocket.getOutputStream());
            dis = new DataInputStream(mySocket.getInputStream());
            file = new File(dis.readLine());
            serverFound = true;
        } catch (IOException ex) {
            serverFound = false;
            System.out.println("No Server Found.");
        }
        try {
            r = new Robot();
        } catch (AWTException ex) {
            //    Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        MenuVisibility();
        loaddata();
        loaddata2();
        this.ScientificPane.setVisible(true);
        this.LengthPane.setVisible(false);
        this.DateCalcPane.setVisible(false);
        this.GarphingPane.setVisible(false);
        this.ConfigurationPane.setVisible(false);
        this.TemperaturePane.setVisible(false);
        this.ProgrammerPane.setVisible(false);
        EqnManager = new ScriptEngineManager();
        engine = EqnManager.getEngineByName("JavaScript");

        String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", //array of months
            "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

        Integer[] days = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, //array of days
            11, 12, 13, 14, 15, 16, 17, 18, 19, 20,
            21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31};

        int currentYear = LocalDate.now().getYear();
        Integer[] years = new Integer[currentYear];

        for (int i = 0; i < currentYear; i++) {
            years[currentYear - i - 1] = i + 1;
        }

        StartDay.setItems(FXCollections.observableArrayList(days));
        StartDay.getSelectionModel().select(0);
        StartMonth.setItems(FXCollections.observableArrayList(months));
        StartMonth.getSelectionModel().select(0);
        StartYear.setItems(FXCollections.observableArrayList(years));
        StartYear.getSelectionModel().select(0);
        EndDay.setItems(FXCollections.observableArrayList(days));
        EndDay.getSelectionModel().select(0);
        EndMonth.setItems(FXCollections.observableArrayList(months));
        EndMonth.getSelectionModel().select(0);
        EndYear.setItems(FXCollections.observableArrayList(years));
        EndYear.getSelectionModel().select(0);
        ToggleEndDate();

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

    @FXML
    private void handleButton(javafx.scene.input.KeyEvent event) throws AWTException {
        if (!event.getText().isEmpty()) {
            if ((event.getText().charAt(0) >= '0' && event.getText().charAt(0) <= '9')) {
                if (R_flag == true) {
                    TA.clear();
                }
                flag = true;
                R_flag = false;
                TA.appendText(event.getText());
            } else if (event.getText().charAt(0) == '-' || event.getText().charAt(0) == '+' || event.getText().charAt(0) == '/' || event.getText().charAt(0) == '*') {
                if (flag == false) {
                    TA.deleteText(TA.getLength() - 1, TA.getLength());
                }

                R_flag = false;
                flag = false;

                TA.appendText(event.getText());

            } else if (event.getText().charAt(0) == 'a') {
                r.keyPress(KeyEvent.VK_DOWN);
            }

        } else {
            if (event.getCode() == KeyCode.BACK_SPACE) {
                if (!TA.getText().isEmpty()) {
                    TA.deleteText(TA.getLength() - 1, TA.getLength());
                }
            }
            if (event.getCode() == KeyCode.UP) {
                y++;
                if (Menu_Flag) {
                    if (y > 7) {
                        y = 7;
                    }
                } else if (Length_Flag || Temperature_Flag) {
                    if (y > 5) {
                        y = 5;
                    }
                } else if (DateCalc_Flag) {
                    if (!EndDateCheckBox.isSelected() && y > 2) {
                        y = 2;
                    } else if (y > 3) {
                        y = 3;
                    }
                } else if (Graph_Flag) {
                    if (y > 2) {
                        y = 2;
                    }
                } else if (Programmer_Flag) {
                    if (x == 0) {
                        if (y > 10) {
                            y = 10;
                        }
                    } else if (x == 3) {
                        if (y > 5) {
                            y = 5;
                        }
                    } else {
                        if (y > 4) {
                            y = 4;
                        }
                    }
                } else {
                    if (y > 8) {
                        y = 8;
                    }
                }

                ResetButtonIDs();
                ArrowIndexHandle();
                System.out.println(y);
            }
            if (event.getCode() == KeyCode.DOWN) {
                y--;
                if (y < 0) {
                    y = 0;
                }
                ResetButtonIDs();
                ArrowIndexHandle();
                System.out.println(y);
            }
            if (event.getCode() == KeyCode.LEFT) {
                x--;
                if (Programmer_Flag) {
                    if (x == 0 && y == 4) {
                        y = 6;
                    }
                    if (x == 2 && y == 5) {
                        y = 4;
                    }
                }
                if (x < 0) {
                    x = 0;
                }
                if (y == 7) {
                    x = 1;
                }
                ResetButtonIDs();
                ArrowIndexHandle();
                System.out.println(x);
            }
            if (event.getCode() == KeyCode.RIGHT) {
                x++;
                if (Menu_Flag) {
                    x = 0;
                } else if (Length_Flag || DateCalc_Flag || Temperature_Flag) {
                    if (x > 2) {
                        x = 2;
                    }
                } else if (Graph_Flag) {
                    if (x > 1) {
                        x = 1;
                    }
                } else if (Programmer_Flag) {
                    if (x > 3) {
                        x = 3;
                    }
                    if (x == 1 && y == 5) {
                        y = 3;
                    } else if (y > 5) {
                        y = 4;
                    }
                } else {
                    if (x > 4) {
                        x = 4;
                    }
                    if (y == 7) {
                        x = 3;
                    }
                }
                ResetButtonIDs();
                ArrowIndexHandle();
                System.out.println(x);
            }
        }
        if (event.getCode() == KeyCode.ENTER) {
            EnterIndexHandle();
        }

    }

    private void EnterIndexHandle() {
        switch (x) {
            case 0:
                switch (y) {
                    case 0:
                        if (Menu_Flag) {
                            ConfigurationButton();

                        } else if (Scientific_Flag) {
                            btnLn();
                        } else if (Length_Flag) {
                            TA1.appendText(".");
                            Converter();
                        } else if (DateCalc_Flag) {
                            calculateButton();
                        } else if (Temperature_Flag) {
                            TA11.appendText(".");
                            Converter2();
                        } else if (Graph_Flag) {
                            Plot();
                        } else if (Programmer_Flag) {
                            if (!btn_F.isDisable()) {
                                Button_F();
                            }
                        }
                        break;

                    case 1:
                        if (Menu_Flag) {
                            TemperatureButton();
                        } else if (Scientific_Flag) {
                            btnLog();
                        } else if (Length_Flag) {
                            TA1.appendText("7");
                            Converter();
                        } else if (DateCalc_Flag) {
                            if (EndDateCheckBox.isSelected()) {
                                EndDay.show();
                            } else {
                                y = 2;
                                EndDateCheckBox.setSelected(!EndDateCheckBox.isSelected());
                                EndDateCheckBox();
                            }
                        } else if (Temperature_Flag) {
                            TA11.appendText("7");
                            Converter2();
                        } else if (Graph_Flag) {
                            GraphTF_Flag = true;
                        } else if (Programmer_Flag) {
                            if (!btn_E.isDisable()) {
                                Button_E();
                            }
                        }
                        break;

                    case 2:
                        if (Menu_Flag) {
                            LengthButton();
                        } else if (Scientific_Flag) {
                            btnTenpowX();
                        } else if (Length_Flag) {
                            TA1.appendText("4");
                            Converter();
                        } else if (DateCalc_Flag) {
                            if (EndDateCheckBox.isSelected()) {
                                y = 1;
                                EndDateCheckBox.setSelected(!EndDateCheckBox.isSelected());
                                EndDateCheckBox();
                            } else {
                                StartDay.show();
                            }
                        } else if (Temperature_Flag) {
                            TA11.appendText("4");
                            Converter2();
                        } else if (Graph_Flag) {
                            startTF_Flag = true;
                        } else if (Programmer_Flag) {
                            if (!btn_D.isDisable()) {
                                Button_D();
                            }
                        }
                        break;

                    case 3:
                        if (Menu_Flag) {
                            DateCalulationBtn();
                        } else if (Scientific_Flag) {
                            btnXpowY();
                        } else if (Length_Flag) {
                            TA1.appendText("1");
                            Converter();
                        } else if (DateCalc_Flag) {
                            StartDay.show();
                        } else if (Temperature_Flag) {
                            TA11.appendText("1");
                            Converter2();
                        } else if (Programmer_Flag) {
                            if (!btn_C.isDisable()) {
                                Button_C();
                            }
                        }
                        break;

                    case 4:
                        if (Menu_Flag) {
                            ProgrammerButton();
                        } else if (Scientific_Flag) {
                            btnSqrt();
                        } else if (Length_Flag) {
                            box2.show();
                        } else if (Temperature_Flag) {
                            box21.show();
                        } else if (Programmer_Flag) {
                            if (!btn_E.isDisable()) {
                                Button_B();
                            }
                        }
                        break;

                    case 5:
                        if (Menu_Flag) {
                            GraphingButton();
                        } else if (Scientific_Flag) {
                            if (Vbox_Flag) {
                                btnHyp();
                            } else {
                                btnSqr();
                            }
                        } else if (Length_Flag) {
                            box1.show();
                        } else if (Temperature_Flag) {
                            box11.show();
                        } else if (Programmer_Flag) {
                            if (!btn_A.isDisable()) {
                                Button_A();
                            }
                        }
                        break;

                    case 6:
                        if (Menu_Flag) {
                            ScientificButton();

                        } else if (Scientific_Flag) {
                            if (Vbox_Flag) {
                                btnTrioScnd();
                            } else {
                                scndbtn();
                            }
                        } else if (Programmer_Flag) {
                            Button_AND();
                        }
                        break;

                    case 7:
                        if (Scientific_Flag) {
                            Trigonometry();
                        } else if (Programmer_Flag) {
                            Button_OCT();
                        }
                        break;
                    case 8:
                        if (Scientific_Flag) {
                            GraphingNowBtn();
                        } else if (Programmer_Flag) {
                            Buuton_DEC();
                        }
                        break;

                    case 9:
                        if (Programmer_Flag) {
                            Button_HEX();
                        }
                        break;

                    case 10:
                        if (Programmer_Flag) {
                            Button_BIN();
                        }
                        break;
                }
                break;

            case 1:
                switch (y) {
                    case 0:
                        if (Scientific_Flag) {
                            btnToggleSign();
                        } else if (Length_Flag) {
                            TA1.appendText("0");
                            Converter();
                        } else if (DateCalc_Flag) {
                            calculateButton();
                        } else if (Temperature_Flag) {
                            TA11.appendText("0");
                            Converter2();
                        } else if (Graph_Flag) {
                            Plot();
                        } else if (Programmer_Flag) {
                            Button_Equal1();
                        }

                        break;

                    case 1:
                        if (Scientific_Flag) {
                            handleButtonAction1();
                        } else if (Length_Flag) {
                            TA1.appendText("8");
                            Converter();
                        } else if (DateCalc_Flag) {
                            if (EndDateCheckBox.isSelected()) {
                                EndMonth.show();
                            } else {
                                y = 2;
                                EndDateCheckBox.setSelected(!EndDateCheckBox.isSelected());
                                EndDateCheckBox();
                            }
                        } else if (Temperature_Flag) {
                            TA11.appendText("8");
                            Converter2();
                        } else if (Graph_Flag) {
                            GraphTF_Flag = true;
                        } else if (Programmer_Flag) {
                            if (!btn_1.isDisable()) {
                                Button_1();
                            }
                        }
                        break;

                    case 2:
                        if (Scientific_Flag) {
                            handleButtonAction4();
                        } else if (Length_Flag) {
                            TA1.appendText("5");
                            Converter();
                        } else if (DateCalc_Flag) {
                            if (EndDateCheckBox.isSelected()) {
                                y = 1;
                                EndDateCheckBox.setSelected(!EndDateCheckBox.isSelected());
                                EndDateCheckBox();
                            } else {
                                StartMonth.show();
                            }
                        } else if (Temperature_Flag) {
                            TA11.appendText("5");
                            Converter2();
                        } else if (Graph_Flag) {
                            endTF_Flag = true;
                        } else if (Programmer_Flag) {
                            if (!btn_4.isDisable()) {
                                Button_4();
                            }
                        }
                        break;

                    case 3:
                        if (Scientific_Flag) {
                            handleButtonAction7();
                        } else if (Length_Flag) {
                            TA1.appendText("2");
                            Converter();
                        } else if (DateCalc_Flag) {
                            StartMonth.show();
                        } else if (Temperature_Flag) {
                            TA11.appendText("2");
                            Converter2();
                        } else if (Programmer_Flag) {
                            if (!btn_7.isDisable()) {
                                Button_7();
                            }
                        }
                        break;

                    case 4:
                        if (Scientific_Flag) {
                            btnRightBrace();
                        } else if (Length_Flag) {
                            box2.show();
                        } else if (Temperature_Flag) {
                            box21.show();
                        } else if (Programmer_Flag) {
                            Button_OR();
                        }
                        break;

                    case 5:
                        if (Scientific_Flag) {
                            if (Vbox_Flag) {
                                btnSec();
                            } else {
                                btnInv();
                            }
                        } else if (Length_Flag) {
                            box1.show();
                        } else if (Temperature_Flag) {
                            box11.show();
                        }

                        break;

                    case 6:
                        if (Scientific_Flag) {
                            if (Vbox_Flag) {
                                btnSin();
                            } else if (Function_Flag) {
                                btnAbs();
                            } else {
                                btnPI();
                            }
                        }
                        break;

                    case 7:
                        if (Scientific_Flag) {
                            Trigonometry();
                        }
                        break;

                    case 8:
                        GraphingNowBtn();
                        break;
                }
                break;

            case 2:
                switch (y) {
                    case 0:
                        if (Scientific_Flag) {
                            handleButtonAction0();
                        } else if (Length_Flag) {
                            TA1.clear();
                            Converter();
                        } else if (DateCalc_Flag) {
                            calculateButton();
                        } else if (Temperature_Flag) {
                            TA11.clear();
                            Converter2();
                        } else if (Programmer_Flag) {
                            if (!btn_0.isDisable()) {
                                Button_0();
                            }
                        }

                        break;

                    case 1:
                        if (Scientific_Flag) {
                            handleButtonAction2();
                        } else if (Length_Flag) {
                            TA1.appendText("9");
                            Converter();

                        } else if (DateCalc_Flag) {
                            if (EndDateCheckBox.isSelected()) {
                                EndYear.show();
                            } else {
                                y = 2;
                                EndDateCheckBox.setSelected(!EndDateCheckBox.isSelected());
                                EndDateCheckBox();
                            }
                        } else if (Temperature_Flag) {
                            TA11.appendText("9");
                            Converter2();
                        } else if (Programmer_Flag) {
                            if (!btn_2.isDisable()) {
                                Button_2();
                            }
                        }
                        break;

                    case 2:
                        if (Scientific_Flag) {
                            handleButtonAction5();
                        } else if (Length_Flag) {
                            TA1.appendText("6");
                            Converter();
                        } else if (DateCalc_Flag) {
                            if (EndDateCheckBox.isSelected()) {
                                y = 1;
                                EndDateCheckBox.setSelected(!EndDateCheckBox.isSelected());
                                EndDateCheckBox();
                            } else {
                                StartYear.show();
                            }
                        } else if (Temperature_Flag) {
                            TA11.appendText("6");
                            Converter2();
                        } else if (Programmer_Flag) {
                            if (!btn_5.isDisable()) {
                                Button_5();
                            }
                        }
                        break;

                    case 3:
                        if (Scientific_Flag) {
                            handleButtonAction8();
                        } else if (Length_Flag) {
                            TA1.appendText("3");
                            Converter();
                        } else if (DateCalc_Flag) {
                            StartYear.show();
                        } else if (Temperature_Flag) {
                            TA11.appendText("3");
                            Converter2();
                        } else if (Programmer_Flag) {
                            if (!btn_8.isDisable()) {
                                Button_8();
                            }
                        }

                        break;

                    case 4:
                        if (Scientific_Flag) {
                            btnLeftBrace();
                        } else if (Length_Flag) {
                            box2.show();
                        } else if (Temperature_Flag) {
                            box21.show();
                        } else if (Programmer_Flag) {
                            Button_NOT();
                        }
                        break;

                    case 5:
                        if (Scientific_Flag) {
                            if (Vbox_Flag) {
                                btnCsc();
                            } else {
                                btnAbs();
                            }
                        } else if (Length_Flag) {
                            box1.show();
                        } else if (Temperature_Flag) {
                            box11.show();
                        }
                        break;

                    case 6:
                        if (Scientific_Flag) {
                            if (Vbox_Flag) {
                                btnCos();
                            } else if (Function_Flag) {
                                btnFloor();
                            } else {
                                btnE();
                            }
                        }

                        break;

                    case 7:
                        if (Scientific_Flag) {
                            Trigonometry();
                        }
                        break;

                    case 8:
                        GraphingNowBtn();
                        break;
                }

                break;

            case 3:
                switch (y) {
                    case 0:
                        if (Scientific_Flag) {
                            handleButtonActionDot();
                        } else if (Programmer_Flag) {
                            Button_Clear();
                        }
                        break;

                    case 1:
                        if (Scientific_Flag) {
                            handleButtonAction3();
                        } else if (Programmer_Flag) {
                            if (!btn_3.isDisable()) {
                                Button_3();
                            }
                        }
                        break;

                    case 2:
                        if (Scientific_Flag) {
                            handleButtonAction6();
                        } else if (Programmer_Flag) {
                            if (!btn_6.isDisable()) {
                                Button_6();
                            }
                        }
                        break;

                    case 3:
                        if (Scientific_Flag) {
                            handleButtonAction9();
                        } else if (Programmer_Flag) {
                            if (!btn_9.isDisable()) {
                                Button_9();
                            }
                        }
                        break;

                    case 4:
                        if (Scientific_Flag) {
                            btnFact();
                        } else if (Programmer_Flag) {
                            Button_XOR();
                        }
                        break;

                    case 5:
                        if (Scientific_Flag) {
                            if (Vbox_Flag) {
                                btnCot();
                            } else {
                                btnExp();
                            }
                        } else if (Programmer_Flag) {
                            Button_Equal();
                        }
                        break;

                    case 6:
                        if (Scientific_Flag) {
                            if (Vbox_Flag) {
                                btnTan();
                            } else if (Function_Flag) {
                                btnCeil();
                            } else {
                                handleButtonActionC();
                            }
                        }
                        break;

                    case 7:
                        if (Scientific_Flag) {
                            FunctionBtn();
                        }
                        break;

                    case 8:
                        GraphingNowBtn();
                        break;
                }
                break;

            case 4:
                switch (y) {
                    case 0:
                        if (Scientific_Flag) {
                            handleButtonActionEqu();
                        }
                        break;

                    case 1:
                        if (Scientific_Flag) {
                            handleButtonActionP();
                        }
                        break;

                    case 2:
                        if (Scientific_Flag) {
                            handleButtonActionN();
                        }
                        break;

                    case 3:
                        if (Scientific_Flag) {
                            handleButtonActionM();
                        }
                        break;

                    case 4:
                        if (Scientific_Flag) {
                            handleButtonActionD();
                        }
                        break;

                    case 5:
                        if (Scientific_Flag) {
                            btnMod();
                        }
                        break;

                    case 6:
                        if (Scientific_Flag) {
                            if (Function_Flag) {
                                btnRand();
                            } else {
                                btnBksp();
                            }
                        }
                        break;

                    case 7:
                        if (Scientific_Flag) {
                            FunctionBtn();
                        }
                        break;

                    case 8:
                        GraphingNowBtn();
                        break;
                }
                break;
        }
    }

    private void ArrowIndexHandle() {
        switch (x) {
            case 0:
                switch (y) {
                    case 0:
                        if (Menu_Flag) {
                            ConfigurationsMenuButton.setId("selected-button");
                            ConfigurationsMenuButton1.setId("selected-button");
                            ConfigurationsMenuButton2.setId("selected-button");
                            ConfigurationsMenuButton3.setId("selected-button");
                            ConfigurationsMenuButton4.setId("selected-button");
                            ConfigurationsMenuButton5.setId("selected-button");
                            ConfigurationsMenuButton6.setId("selected-button");
                        } else if (Scientific_Flag) {
                            buttonLn.setId("selected-button");
                        } else if (Length_Flag) {
                            dot.setId("selected-button");
                        } else if (DateCalc_Flag) {
                            calculateButton.setId("selected-button");
                        } else if (Temperature_Flag) {
                            dot1.setId("selected-button");
                        } else if (Graph_Flag) {
                            PlotBtn.setId("selected-button");
                        } else if (Programmer_Flag) {
                            btn_F.setId("selected-button");
                        }

                        break;

                    case 1:
                        if (Menu_Flag) {
                            TempMenuButton.setId("selected-button");
                            TempMenuButton1.setId("selected-button");
                            TempMenuButton2.setId("selected-button");
                            TempMenuButton21.setId("selected-button");
                            TempMenuButton4.setId("selected-button");
                            TempMenuButton5.setId("selected-button");
                            TempMenuButton6.setId("selected-button");
                        } else if (Scientific_Flag) {
                            buttonLog.setId("selected-button");
                        } else if (Length_Flag) {
                            seven.setId("selected-button");
                        } else if (DateCalc_Flag) {
                            if (EndDateCheckBox.isSelected()) {
                                EndDay.setId("selected-button");
                            } else {
                                EndDateCheckBox.setId("selected-button");
                            }
                        } else if (Temperature_Flag) {
                            seven1.setId("selected-button");
                        } else if (Graph_Flag) {
                            plotEqn.setId("selected-button");
                        } else if (Programmer_Flag) {
                            btn_E.setId("selected-button");
                        }

                        break;

                    case 2:
                        if (Menu_Flag) {
                            LengthMenuButton.setId("selected-button");
                            LengthMenuButton1.setId("selected-button");
                            LengthMenuButton2.setId("selected-button");
                            LengthMenuButton3.setId("selected-button");
                            LengthMenuButton4.setId("selected-button");
                            LengthMenuButton5.setId("selected-button");
                            LengthMenuButton6.setId("selected-button");
                        } else if (Scientific_Flag) {
                            button10PowerX.setId("selected-button");
                        } else if (Length_Flag) {
                            four.setId("selected-button");
                        } else if (DateCalc_Flag) {
                            if (EndDateCheckBox.isSelected()) {
                                EndDateCheckBox.setId("selected-button");
                            } else {
                                StartDay.setId("selected-button");
                            }
                        } else if (Temperature_Flag) {
                            four1.setId("selected-button");
                        } else if (Graph_Flag) {
                            startTF.setId("selected-button");
                        } else if (Programmer_Flag) {
                            btn_D.setId("selected-button");
                        }
                        break;

                    case 3:
                        if (Menu_Flag) {
                            DateCalcMenuButton.setId("selected-button");
                            DateCalcMenuButton1.setId("selected-button");
                            DateCalcMenuButton2.setId("selected-button");
                            DateCalcMenuButton3.setId("selected-button");
                            DateCalcMenuButton4.setId("selected-button");
                            DateCalcMenuButton5.setId("selected-button");
                            DateCalcMenuButton6.setId("selected-button");
                        } else if (Scientific_Flag) {
                            buttonXpY.setId("selected-button");
                        } else if (Length_Flag) {
                            one.setId("selected-button");
                        } else if (DateCalc_Flag) {
                            StartDay.setId("selected-button");
                        } else if (Temperature_Flag) {
                            one1.setId("selected-button");
                        } else if (Programmer_Flag) {
                            btn_C.setId("selected-button");
                        }
                        break;

                    case 4:
                        if (Menu_Flag) {
                            ProgrammerMenuButton.setId("selected-button");
                            ProgrammerMenuButton1.setId("selected-button");
                            ProgrammerMenuButton2.setId("selected-button");
                            ProgrammerMenuButton3.setId("selected-button");
                            ProgrammerMenuButton4.setId("selected-button");
                            ProgrammerMenuButton5.setId("selected-button");
                            ProgrammerMenuButton6.setId("selected-button");
                        } else if (Scientific_Flag) {
                            buttonSqrt.setId("selected-button");
                        } else if (Length_Flag) {
                            box2.setId("selected-button");
                        } else if (Temperature_Flag) {
                            box21.setId("selected-button");
                        } else if (Programmer_Flag) {
                            btn_B.setId("selected-button");
                        }
                        break;

                    case 5:
                        if (Menu_Flag) {
                            GraphingMenuButton.setId("selected-button");
                            GraphingMenuButton1.setId("selected-button");
                            GraphingMenuButton2.setId("selected-button");
                            GraphingMenuButton3.setId("selected-button");
                            GraphingMenuButton3.setId("selected-button");
                            GraphingMenuButton4.setId("selected-button");
                            GraphingMenuButton5.setId("selected-button");
                            GraphingMenuButton6.setId("selected-button");

                        } else if (Scientific_Flag) {
                            if (Vbox_Flag) {
                                buttonHyp.setId("selected-button");
                            } else {
                                buttonPower2.setId("selected-button");
                            }
                        } else if (Length_Flag) {
                            box1.setId("selected-button");
                        } else if (Temperature_Flag) {
                            box11.setId("selected-button");
                        } else if (Programmer_Flag) {
                            btn_A.setId("selected-button");
                        }
                        break;

                    case 6:
                        if (Menu_Flag) {
                            ScientificMenuButton.setId("selected-button");
                            ScientificMenuButton1.setId("selected-button");
                            ScientificMenuButton2.setId("selected-button");
                            ScientificMenuButton3.setId("selected-button");
                            ScientificMenuButton4.setId("selected-button");
                            ScientificMenuButton5.setId("selected-button");
                            ScientificMenuButton6.setId("selected-button");

                        } else if (Scientific_Flag) {
                            if (Vbox_Flag) {
                                buttonTrio2nd.setId("selected-button");
                            } else if (Function_Flag) {
                                x = 1;
                                AbsButton.setId("selected-button");
                            } else {
                                button2nd.setId("selected-button");
                            }
                        } else if (Programmer_Flag) {
                            btn_AND.setId("selected-button");
                        }
                        break;

                    case 7:
                        if (Menu_Flag) {
                            y = 6;
                            ScientificMenuButton.setId("selected-button");
                            ScientificMenuButton1.setId("selected-button");
                            ScientificMenuButton2.setId("selected-button");
                            ScientificMenuButton3.setId("selected-button");
                            ScientificMenuButton4.setId("selected-button");
                            ScientificMenuButton5.setId("selected-button");
                            ScientificMenuButton6.setId("selected-button");
                        } else if (Scientific_Flag) {
                            TogButton.setId("selected-button");
                        } else if (Programmer_Flag) {
                            btn_OCT.setId("selected-button");
                        }
                        break;

                    case 8:
                        if (Scientific_Flag) {
                            GraphNow.setId("selected-button");
                        } else if (Programmer_Flag) {
                            btn_DEC.setId("selected-button");
                        }
                        break;

                    case 9:
                        if (Programmer_Flag) {
                            btn_HEX.setId("selected-button");
                        }
                        break;

                    case 10:
                        if (Programmer_Flag) {
                            btn_BIN.setId("selected-button");
                        }
                        break;
                }
                break;

            case 1:
                switch (y) {
                    case 0:
                        if (Scientific_Flag) {
                            buttonPM.setId("selected-button");
                        } else if (Length_Flag) {
                            zero.setId("selected-button");
                        } else if (DateCalc_Flag) {
                            calculateButton.setId("selected-button");
                        } else if (Temperature_Flag) {
                            zero1.setId("selected-button");
                        } else if (Graph_Flag) {
                            PlotBtn.setId("selected-button");
                        } else if (Programmer_Flag) {
                            btn_equal1.setId("selected-button");
                        }
                        break;

                    case 1:
                        if (Scientific_Flag) {
                            button1.setId("selected-button");
                        } else if (Length_Flag) {
                            eight.setId("selected-button");
                        } else if (DateCalc_Flag) {
                            if (EndDateCheckBox.isSelected()) {
                                EndMonth.setId("selected-button");
                            } else {
                                EndDateCheckBox.setId("selected-button");
                            }
                        } else if (Temperature_Flag) {
                            eight1.setId("selected-button");
                        } else if (Graph_Flag) {
                            plotEqn.setId("selected-button");
                        } else if (Programmer_Flag) {
                            btn_1.setId("selected-button");
                        }
                        break;

                    case 2:
                        if (Scientific_Flag) {
                            button4.setId("selected-button");
                        } else if (Length_Flag) {
                            five.setId("selected-button");
                        } else if (DateCalc_Flag) {
                            if (EndDateCheckBox.isSelected()) {
                                EndDateCheckBox.setId("selected-button");
                            } else {
                                StartMonth.setId("selected-button");
                            }
                        } else if (Temperature_Flag) {
                            five1.setId("selected-button");
                        } else if (Graph_Flag) {
                            endTF.setId("selected-button");
                        } else if (Programmer_Flag) {
                            btn_4.setId("selected-button");
                        }
                        break;

                    case 3:
                        if (Scientific_Flag) {
                            button7.setId("selected-button");
                        } else if (Length_Flag) {
                            two.setId("selected-button");
                        } else if (DateCalc_Flag) {
                            StartMonth.setId("selected-button");
                        } else if (Temperature_Flag) {
                            two1.setId("selected-button");
                        } else if (Programmer_Flag) {
                            btn_7.setId("selected-button");
                        }
                        break;

                    case 4:
                        if (Scientific_Flag) {
                            buttonOBraces.setId("selected-button");
                        } else if (Length_Flag) {
                            box2.setId("selected-button");
                        } else if (Temperature_Flag) {
                            box21.setId("selected-button");
                        } else if (Programmer_Flag) {
                            btn_OR.setId("selected-button");
                        }
                        break;

                    case 5:
                        if (Scientific_Flag) {
                            if (Vbox_Flag) {
                                buttonSec.setId("selected-button");
                            } else {
                                buttonDivX.setId("selected-button");
                            }
                        } else if (Length_Flag) {
                            box1.setId("selected-button");
                        } else if (Temperature_Flag) {
                            box11.setId("selected-button");
                        }
                        break;

                    case 6:
                        if (Scientific_Flag) {
                            if (Vbox_Flag) {
                                buttonSin.setId("selected-button");
                            } else if (Function_Flag) {
                                AbsButton.setId("selected-button");
                            } else {
                                buttonPI.setId("selected-button");
                            }
                        }
                        break;

                    case 7:
                        if (Scientific_Flag) {
                            TogButton.setId("selected-button");
                        }
                        break;

                    case 8:
                        GraphNow.setId("selected-button");
                        break;
                }
                break;

            case 2:
                switch (y) {
                    case 0:
                        if (Scientific_Flag) {
                            button0.setId("selected-button");
                        } else if (Length_Flag) {
                            clear.setId("selected-button");
                        } else if (DateCalc_Flag) {
                            calculateButton.setId("selected-button");
                        } else if (Temperature_Flag) {
                            clear1.setId("selected-button");
                        } else if (Programmer_Flag) {
                            btn_0.setId("selected-button");
                        }
                        break;

                    case 1:
                        if (Scientific_Flag) {
                            button2.setId("selected-button");
                        } else if (Length_Flag) {
                            nine.setId("selected-button");
                        } else if (DateCalc_Flag) {
                            if (EndDateCheckBox.isSelected()) {
                                EndYear.setId("selected-button");
                            } else {
                                EndDateCheckBox.setId("selected-button");
                            }
                        } else if (Temperature_Flag) {
                            nine1.setId("selected-button");
                        } else if (Programmer_Flag) {
                            btn_2.setId("selected-button");
                        }
                        break;

                    case 2:
                        if (Scientific_Flag) {
                            button5.setId("selected-button");
                        } else if (Length_Flag) {
                            six.setId("selected-button");
                        } else if (DateCalc_Flag) {
                            if (EndDateCheckBox.isSelected()) {
                                EndDateCheckBox.setId("selected-button");
                            } else {
                                StartYear.setId("selected-button");
                            }
                        } else if (Temperature_Flag) {
                            six1.setId("selected-button");
                        } else if (Programmer_Flag) {
                            btn_5.setId("selected-button");
                        }
                        break;

                    case 3:
                        if (Scientific_Flag) {
                            button8.setId("selected-button");
                        } else if (Length_Flag) {
                            three.setId("selected-button");
                        } else if (DateCalc_Flag) {
                            StartYear.setId("selected-button");
                        } else if (Temperature_Flag) {
                            three1.setId("selected-button");
                        } else if (Programmer_Flag) {
                            btn_8.setId("selected-button");
                        }
                        break;

                    case 4:
                        if (Scientific_Flag) {
                            buttonCBraces.setId("selected-button");
                        } else if (Length_Flag) {
                            box2.setId("selected-button");
                        } else if (Temperature_Flag) {
                            box21.setId("selected-button");
                        } else if (Programmer_Flag) {
                            btn_NOT.setId("selected-button");
                        }
                        break;

                    case 5:
                        if (Scientific_Flag) {
                            if (Vbox_Flag) {
                                buttonCsc.setId("selected-button");
                            } else {
                                buttonAbs.setId("selected-button");
                            }
                        } else if (Length_Flag) {
                            box1.setId("selected-button");
                        } else if (Temperature_Flag) {
                            box11.setId("selected-button");
                        }
                        break;

                    case 6:
                        if (Scientific_Flag) {
                            if (Vbox_Flag) {
                                buttonCos.setId("selected-button");
                            } else if (Function_Flag) {
                                FloorButton.setId("selected-button");
                            } else {
                                buttonEuler.setId("selected-button");
                            }
                        }
                        break;

                    case 7:
                        if (Scientific_Flag) {
                            TogButton.setId("selected-button");
                        }
                        break;

                    case 8:
                        GraphNow.setId("selected-button");
                        break;
                }

                break;

            case 3:
                switch (y) {
                    case 0:
                        if (Scientific_Flag) {
                            buttonDot.setId("selected-button");
                        } else if (Programmer_Flag) {
                            btn_Clear.setId("selected-button");
                        }
                        break;

                    case 1:
                        if (Scientific_Flag) {
                            button3.setId("selected-button");
                        } else if (Programmer_Flag) {
                            btn_3.setId("selected-button");
                        }
                        break;

                    case 2:
                        if (Scientific_Flag) {
                            button6.setId("selected-button");
                        } else if (Programmer_Flag) {
                            btn_6.setId("selected-button");
                        }
                        break;

                    case 3:
                        if (Scientific_Flag) {
                            button9.setId("selected-button");
                        } else if (Programmer_Flag) {
                            btn_9.setId("selected-button");
                        }
                        break;

                    case 4:
                        if (Scientific_Flag) {
                            buttonFact.setId("selected-button");
                        } else if (Programmer_Flag) {
                            btn_XOR.setId("selected-button");
                        }
                        break;

                    case 5:
                        if (Scientific_Flag) {
                            if (Vbox_Flag) {
                                buttonCot.setId("selected-button");
                            } else {
                                buttonExp.setId("selected-button");
                            }
                        } else if (Programmer_Flag) {
                            btn_equal.setId("selected-button");
                        }
                        break;

                    case 6:
                        if (Scientific_Flag) {
                            if (Vbox_Flag) {
                                buttonTan.setId("selected-button");
                            } else if (Function_Flag) {
                                CeilButton.setId("selected-button");
                            } else {
                                buttonC.setId("selected-button");
                            }
                        }
                        break;

                    case 7:
                        if (Scientific_Flag) {
                            TogButton1.setId("selected-button");
                        }
                        break;

                    case 8:
                        GraphNow.setId("selected-button");
                        break;
                }
                break;

            case 4:
                switch (y) {
                    case 0:
                        if (Scientific_Flag) {
                            equals.setId("selected-button");
                        }
                        break;

                    case 1:
                        if (Scientific_Flag) {
                            buttonPlus.setId("selected-button");
                        }
                        break;

                    case 2:
                        if (Scientific_Flag) {
                            buttonMin.setId("selected-button");
                        }
                        break;

                    case 3:
                        if (Scientific_Flag) {
                            buttonMulti.setId("selected-button");
                        }
                        break;

                    case 4:
                        if (Scientific_Flag) {
                            buttonDiv.setId("selected-button");
                        }
                        break;

                    case 5:
                        if (Scientific_Flag) {
                            buttonMod.setId("selected-button");
                        }
                        break;

                    case 6:
                        if (Scientific_Flag) {
                            if (Function_Flag) {
                                RandButton.setId("selected-button");
                            } else {
                                buttonBks.setId("selected-button");

                            }
                        }
                        break;

                    case 7:
                        if (Scientific_Flag) {
                            TogButton1.setId("selected-button");
                        }
                        break;

                    case 8:
                        GraphNow.setId("selected-button");
                        break;
                }
                break;
        }
    }

    private void ResetButtonIDs() {
        buttonLn.setId("");
        buttonPM.setId("");
        button0.setId("");
        buttonDot.setId("");
        equals.setId("");
        buttonLog.setId("");
        button1.setId("");
        button2.setId("");
        button3.setId("");
        buttonPlus.setId("");
        button10PowerX.setId("");
        button4.setId("");
        button5.setId("");
        button6.setId("");
        buttonMin.setId("");
        buttonXpY.setId("");
        button7.setId("");
        button8.setId("");
        button9.setId("");
        buttonMulti.setId("");
        buttonSqrt.setId("");
        buttonOBraces.setId("");
        buttonCBraces.setId("");
        buttonFact.setId("");
        buttonDiv.setId("");
        buttonPower2.setId("");
        buttonDivX.setId("");
        buttonAbs.setId("");
        buttonExp.setId("");
        buttonMod.setId("");
        buttonPI.setId("");
        buttonEuler.setId("");
        buttonC.setId("");
        buttonBks.setId("");
        TogButton.setId("");
        TogButton1.setId("");
        buttonSin.setId("");
        buttonCos.setId("");
        buttonCsc.setId("");
        buttonTan.setId("");
        buttonCot.setId("");
        buttonSec.setId("");
        AbsButton.setId("");
        FloorButton.setId("");
        CeilButton.setId("");
        RandButton.setId("");
        ScientificMenuButton.setId("");
        GraphingMenuButton.setId("");
        ProgrammerMenuButton.setId("");
        DateCalcMenuButton.setId("");
        LengthMenuButton.setId("");
        TempMenuButton.setId("");
        ConfigurationsMenuButton.setId("");
        ScientificMenuButton1.setId("");
        GraphingMenuButton1.setId("");
        ProgrammerMenuButton1.setId("");
        DateCalcMenuButton1.setId("");
        LengthMenuButton1.setId("");
        TempMenuButton1.setId("");
        ConfigurationsMenuButton1.setId("");
        ScientificMenuButton2.setId("");
        GraphingMenuButton2.setId("");
        ProgrammerMenuButton2.setId("");
        DateCalcMenuButton2.setId("");
        LengthMenuButton2.setId("");
        TempMenuButton21.setId("");
        ConfigurationsMenuButton2.setId("");
        ScientificMenuButton3.setId("");
        GraphingMenuButton3.setId("");
        ProgrammerMenuButton3.setId("");
        DateCalcMenuButton3.setId("");
        LengthMenuButton3.setId("");
        TempMenuButton2.setId("");
        ConfigurationsMenuButton3.setId("");
        ScientificMenuButton4.setId("");
        GraphingMenuButton4.setId("");
        ProgrammerMenuButton4.setId("");
        DateCalcMenuButton4.setId("");
        LengthMenuButton4.setId("");
        TempMenuButton4.setId("");
        ConfigurationsMenuButton4.setId("");
        ScientificMenuButton5.setId("");
        GraphingMenuButton5.setId("");
        ProgrammerMenuButton5.setId("");
        DateCalcMenuButton5.setId("");
        LengthMenuButton5.setId("");
        TempMenuButton5.setId("");
        ConfigurationsMenuButton5.setId("");
        ScientificMenuButton6.setId("");
        GraphingMenuButton6.setId("");
        ProgrammerMenuButton6.setId("");
        DateCalcMenuButton6.setId("");
        LengthMenuButton6.setId("");
        TempMenuButton6.setId("");
        ConfigurationsMenuButton6.setId("");
        one.setId("");
        two.setId("");
        three.setId("");
        four.setId("");
        five.setId("");
        six.setId("");
        seven.setId("");
        eight.setId("");
        nine.setId("");
        dot.setId("");
        zero.setId("");
        clear.setId("");
        box1.setId("");
        box2.setId("");
        one1.setId("");
        two1.setId("");
        three1.setId("");
        four1.setId("");
        five1.setId("");
        six1.setId("");
        seven1.setId("");
        eight1.setId("");
        nine1.setId("");
        dot1.setId("");
        zero1.setId("");
        clear1.setId("");
        box11.setId("");
        box21.setId("");
        StartDay.setId("");
        calculateButton.setId("");
        StartMonth.setId("");
        StartYear.setId("");
        EndDateCheckBox.setId("");
        EndDay.setId("");
        EndMonth.setId("");
        EndYear.setId("");
        GraphNow.setId("");
        PlotBtn.setId("");
        plotEqn.setId("");
        startTF.setId("");
        endTF.setId("");
        GraphTF_Flag = false;
        startTF_Flag = false;
        endTF_Flag = false;
        btn_F.setId("");
        btn_E.setId("");
        btn_D.setId("");
        btn_C.setId("");
        btn_B.setId("");
        btn_A.setId("");
        btn_AND.setId("");
        btn_OCT.setId("");
        btn_DEC.setId("");
        btn_HEX.setId("");
        btn_BIN.setId("");
        btn_equal1.setId("");
        btn_1.setId("");
        btn_4.setId("");
        btn_7.setId("");
        btn_OR.setId("");
        btn_0.setId("");
        btn_2.setId("");
        btn_5.setId("");
        btn_8.setId("");
        btn_NOT.setId("");
        btn_Clear.setId("");
        btn_3.setId("");
        btn_6.setId("");
        btn_9.setId("");
        btn_XOR.setId("");
        btn_equal.setId("");

        if (Sci_scnd_flag == false) {
            button2nd.setId("");
        }
        if (scnd_flag == false) {
            buttonTrio2nd.setId("");
        }
        if (hypFlag == false) {
            buttonHyp.setId("");

        }

    }

    @FXML
    private void Trigonometry() {
        Vbox.setVisible(false);
        MenuBox.setVisible(false);
        FunctionsMenu.setVisible(false);
        Menu_Flag = false;
        Function_Flag = false;
        Vbox_Flag = !Vbox_Flag;
        Vbox.setVisible(Vbox_Flag);

    }

    @FXML
    private void ScientificPaneClicked(MouseEvent event) {
        MenuVisibility();
    }

    @FXML
    private void MenuHandling() {
        Vbox.setVisible(false);
        MenuBox.setVisible(false);
        MenuBox2.setVisible(false);
        FunctionsMenu.setVisible(false);
        HistoryPane.setVisible(false);
        HistoryPane1.setVisible(false);
        y = 7;
        x = 0;
        Vbox_Flag = false;
        History_Flag = false;
        Function_Flag = false;
        Menu_Flag = !Menu_Flag;
        MenuBox.setVisible(Menu_Flag);
        MenuBox1.setVisible(Menu_Flag);
        MenuBox2.setVisible(Menu_Flag);
        GraphingMenuBox.setVisible(Menu_Flag);
        ConfigurationMenu.setVisible(Menu_Flag);
        TempMenu.setVisible(Menu_Flag);
        ProgrammerMenu.setVisible(Menu_Flag);
        ResetButtonIDs();
        ArrowIndexHandle();

    }

    @FXML
    private void FunctionBtn() {
        Vbox.setVisible(false);
        MenuBox.setVisible(false);
        FunctionsMenu.setVisible(false);
        Menu_Flag = false;
        Vbox_Flag = false;
        Function_Flag = !Function_Flag;
        FunctionsMenu.setVisible(Function_Flag);
    }

    private void MenuVisibility() {
        Vbox.setVisible(false);
        MenuBox.setVisible(false);
        MenuBox1.setVisible(false);
        MenuBox2.setVisible(false);
        FunctionsMenu.setVisible(false);
        GraphingMenuBox.setVisible(false);
        ConfigurationMenu.setVisible(false);
        ProgrammerMenu.setVisible(false);
        TempMenu.setVisible(false);
        HistoryPane.setVisible(false);
        HistoryPane1.setVisible(false);
        History_Flag = false;
        Menu_Flag = false;
        Vbox_Flag = false;
        Function_Flag = false;
        ResetButtonIDs();
        ArrowIndexHandle();
    }

    @FXML
    private void btnBksp() {
        if (!TA.getText().isEmpty()) {
            TA.deleteText(TA.getLength() - 1, TA.getLength());
        }
        if (!TA_Value.isEmpty()) {
            TA_Value = TA_Value.substring(0, (TA_Value.length() - 1));
        }
        if (twoInputFlag && !Y.isEmpty()) {
            Y = Y.substring(0, (Y.length() - 1));

        } else if (!X.isEmpty()) {
            X = X.substring(0, (X.length() - 1));
        }
    }

    @FXML
    private void btnHyp() {
        hypFlag = !hypFlag;
        if (hypFlag == true && scnd_flag == false) {
            buttonHyp.setId("selected-button-hyp");
            buttonSin.setText("sinh");
            buttonCos.setText("cosh");
            buttonTan.setText("tanh");
            buttonSec.setText("sech");
            buttonCsc.setText("csch");
            buttonCot.setText("coth");

        } else if (scnd_flag == true && hypFlag == false) {

            buttonHyp.setId("");
            buttonSin.setText("sin-1");
            buttonCos.setText("cos-1");
            buttonTan.setText("tan-1");
            buttonSec.setText("sec-1");
            buttonCsc.setText("csc-1");
            buttonCot.setText("cot-1");
        } else if (scnd_flag == false && hypFlag == false) {
            buttonHyp.setId("");
            buttonSin.setText("sin");
            buttonCos.setText("cos");
            buttonTan.setText("tan");
            buttonSec.setText("sec");
            buttonCsc.setText("csc");
            buttonCot.setText("cot");

        } else if (scnd_flag == true && hypFlag == true) {

            buttonHyp.setId("selected-button-hyp");
            buttonSin.setText("sinh-1");
            buttonCos.setText("cosh-1");
            buttonTan.setText("tanh-1");
            buttonSec.setText("sech-1");
            buttonCsc.setText("csch-1");
            buttonCot.setText("coth-1");
        }

    }

    @FXML
    private void scndbtn() {
        Sci_scnd_flag = !Sci_scnd_flag;
        if (Sci_scnd_flag == true) {
            button2nd.setId("selected-button");
            buttonPower2.setText("x??");
            buttonSqrt.setText("?????x");
            buttonXpY.setText("?????x");
            button10PowerX.setText("2??");
            buttonLog.setText("log??? x");
            buttonLn.setText("e??");
        } else {
            button2nd.setId("");
            buttonPower2.setText("x??");
            buttonSqrt.setText("?????x");
            buttonXpY.setText("x??");
            button10PowerX.setText("10??");
            buttonLog.setText("log");
            buttonLn.setText("ln");

        }
    }

    @FXML
    private void btnTrioScnd() {
        scnd_flag = !scnd_flag;
        if (scnd_flag == true && hypFlag == false) {

            buttonTrio2nd.setId("selected-button-new");
            buttonSin.setText("sin-1");
            buttonCos.setText("cos-1");
            buttonTan.setText("tan-1");
            buttonSec.setText("sec-1");
            buttonCsc.setText("csc-1");
            buttonCot.setText("cot-1");
        } else if (scnd_flag == false && hypFlag == false) {
            buttonTrio2nd.setId("");
            buttonSin.setText("sin");
            buttonCos.setText("cos");
            buttonTan.setText("tan");
            buttonSec.setText("sec");
            buttonCsc.setText("csc");
            buttonCot.setText("cot");

        } else if (scnd_flag == true && hypFlag == true) {
            buttonTrio2nd.setId("selected-button-new");
            buttonSin.setText("sinh-1");
            buttonCos.setText("cosh-1");
            buttonTan.setText("tanh-1");
            buttonSec.setText("sech-1");
            buttonCsc.setText("csch-1");
            buttonCot.setText("coth-1");
        } else if (hypFlag == true && scnd_flag == false) {
            buttonTrio2nd.setId("");
            buttonSin.setText("sinh");
            buttonCos.setText("cosh");
            buttonTan.setText("tanh");
            buttonSec.setText("sech");
            buttonCsc.setText("csch");
            buttonCot.setText("coth");

        }

    }

    @FXML
    private void ScientificButton() {
        Scientific_Flag = true;
        Length_Flag = false;
        DateCalc_Flag = false;
        Graph_Flag = false;
        Temperature_Flag = false;
        Programmer_Flag = false;
        TA1.clear();
        TA2.clear();
        TA11.clear();
        TA21.clear();
        text_Area.clear();
        text_Area2.clear();
        plotEqn.clear();
        startTF.clear();
        endTF.clear();
        lineChart.getData().clear();
        resultLabel.setText("");
        EndDateCheckBox.setSelected(false);
        this.DateCalcPane.setVisible(false);
        this.TemperaturePane.setVisible(false);
        this.ScientificPane.setVisible(true);
        this.LengthPane.setVisible(false);
        this.GarphingPane.setVisible(false);
        this.ConfigurationPane.setVisible(false);
        this.ProgrammerPane.setVisible(false);
        MenuVisibility();

        StartDay.getSelectionModel().select(0);
        StartMonth.getSelectionModel().select(0);
        StartYear.getSelectionModel().select(0);
        EndDay.getSelectionModel().select(0);
        EndMonth.getSelectionModel().select(0);
        EndYear.getSelectionModel().select(0);
        ToggleEndDate();

    }

    @FXML
    private void LengthButton() {
        x = 0;
        y = 0;
        Scientific_Flag = false;
        Temperature_Flag = false;
        Programmer_Flag = false;
        DateCalc_Flag = false;
        Graph_Flag = false;
        Length_Flag = true;
        TA.clear();
        TA11.clear();
        TA21.clear();
        text_Area.clear();
        text_Area2.clear();
        resultLabel.setText("");
        lineChart.getData().clear();
        plotEqn.clear();
        startTF.clear();
        endTF.clear();
        EndDateCheckBox.setSelected(false);
        this.GarphingPane.setVisible(false);
        this.TemperaturePane.setVisible(false);
        this.DateCalcPane.setVisible(false);
        this.ScientificPane.setVisible(false);
        this.LengthPane.setVisible(true);
        this.ConfigurationPane.setVisible(false);
        this.ProgrammerPane.setVisible(false);
        MenuVisibility();
        StartDay.getSelectionModel().select(0);
        StartMonth.getSelectionModel().select(0);
        StartYear.getSelectionModel().select(0);
        EndDay.getSelectionModel().select(0);
        EndMonth.getSelectionModel().select(0);
        EndYear.getSelectionModel().select(0);
        ToggleEndDate();
    }

    /**
     * **********************************************FADY
     * PART***************************************************
     */
    /*Fady Part*/
    @FXML
    private void handleButtonAction(ActionEvent event) {
        if (event.getSource() == one || event.getSource() == one1) {
            TA1.appendText("1");
            TA11.appendText("1");
        } else if (event.getSource() == two || event.getSource() == two1) {
            TA1.appendText("2");
            TA11.appendText("2");
        } else if (event.getSource() == three || event.getSource() == three1) {
            TA1.appendText("3");
            TA11.appendText("3");
        } else if (event.getSource() == four || event.getSource() == four1) {
            TA1.appendText("4");
            TA11.appendText("4");
        } else if (event.getSource() == five || event.getSource() == five1) {
            TA1.appendText("5");
            TA11.appendText("5");
        } else if (event.getSource() == six || event.getSource() == six1) {
            TA1.appendText("6");
            TA11.appendText("6");
        } else if (event.getSource() == seven || event.getSource() == seven1) {
            TA1.appendText("7");
            TA11.appendText("7");
        } else if (event.getSource() == eight || event.getSource() == eight1) {
            TA1.appendText("8");
            TA11.appendText("8");
        } else if (event.getSource() == nine || event.getSource() == nine1) {
            TA1.appendText("9");
            TA11.appendText("9");
        } else if (event.getSource() == zero || event.getSource() == zero1) {
            TA1.appendText("0");
            TA11.appendText("0");
        } else if (event.getSource() == clear || event.getSource() == clear1) {
            TA1.clear();
            TA11.clear();
        } else if (event.getSource() == dot || event.getSource() == dot1) {
            TA1.appendText(".");
            TA11.appendText(".");
        }
        Converter();
        Converter2();
    }

    /*Fady Part*/
    @FXML
    private void Converter() {
        double res;
        double data;
        /*---------MilliMeters--------*/
        if (box1.getValue() == "Millimeters") {
            if (box2.getValue() == "Millimeters") //MilliMeters
            {
                TA2.setText(TA1.getText());
            } else if (box2.getValue() == "CentiMeters") //Centimeter
            {
                if (!TA1.getText().isEmpty()) {
                    data = Double.parseDouble(TA1.getText());
                    res = data / 10.0;
                    TA2.setText(Double.toString(res));
                } else {
                    TA2.clear();
                }
            } else if (box2.getValue() == "Meters") //Meter
            {
                if (!TA1.getText().isEmpty()) {
                    data = Double.parseDouble(TA1.getText());
                    res = data / 1000.0;
                    TA2.setText(Double.toString(res));
                } else {
                    TA2.clear();
                }
            } else if (box2.getValue() == "KiloMeters") //KiloMeters
            {
                if (!TA1.getText().isEmpty()) {
                    data = Double.parseDouble(TA1.getText());
                    res = data / 1000000;
                    TA2.setText(Double.toString(res));
                } else {
                    TA2.clear();
                }
            } else if (box2.getValue() == "Inches") //Inches
            {
                if (!TA1.getText().isEmpty()) {
                    data = Double.parseDouble(TA1.getText());
                    res = data / 25.4;
                    TA2.setText(String.format("%.4f", res));
                } else {
                    TA2.clear();
                }
            } else if (box2.getValue() == "Feets") //feets
            {
                if (!TA1.getText().isEmpty()) {
                    data = Double.parseDouble(TA1.getText());
                    res = data / 304.8;
                    TA2.setText(String.format("%.4f", res));
                } else {
                    TA2.clear();
                }
            } else if (box2.getValue() == "Miles") //Miles
            {
                if (!TA1.getText().isEmpty()) {
                    data = Double.parseDouble(TA1.getText());
                    res = data / 1000000;
                    res = res / 1.609;
                    TA2.setText(String.format("%.4f", res));
                } else {
                    TA2.clear();
                }
            }
        } /*-------------Centimeters------------*/ else if (box1.getValue() == "CentiMeters") {
            if (box2.getValue() == "Millimeters") //MilliMeters
            {
                if (!TA1.getText().isEmpty()) {
                    data = Double.parseDouble(TA1.getText());
                    res = data * 10;
                    TA2.setText(Double.toString(res));
                } else {
                    TA2.clear();
                }
            } else if (box2.getValue() == "CentiMeters") //Centimeter
            {
                TA2.setText(TA1.getText());
            } else if (box2.getValue() == "Meters") //Meter
            {
                if (!TA1.getText().isEmpty()) {
                    data = Double.parseDouble(TA1.getText());
                    res = data / 100;
                    TA2.setText(Double.toString(res));
                } else {
                    TA2.clear();
                }
            } else if (box2.getValue() == "KiloMeters") //KiloMeters
            {
                if (!TA1.getText().isEmpty()) {
                    data = Double.parseDouble(TA1.getText());
                    res = data / 100000;
                    TA2.setText(Double.toString(res));
                } else {
                    TA2.clear();
                }
            } else if (box2.getValue() == "Inches") //Inches
            {
                if (!TA1.getText().isEmpty()) {
                    data = Double.parseDouble(TA1.getText());
                    res = data / 2.54;
                    TA2.setText(String.format("%.4f", res));
                } else {
                    TA2.clear();
                }
            } else if (box2.getValue() == "Feets") //feets
            {
                if (!TA1.getText().isEmpty()) {
                    data = Double.parseDouble(TA1.getText());
                    res = data / 30.48;
                    TA2.setText(String.format("%.4f", res));
                } else {
                    TA2.clear();
                }
            } else if (box2.getValue() == "Miles") //Miles
            {
                if (!TA1.getText().isEmpty()) {
                    data = Double.parseDouble(TA1.getText());
                    res = data / 100000;
                    res = res / 1.609;
                    TA2.setText(String.format("%.4f", res));
                } else {
                    TA2.clear();
                }
            }
        } /*--------------------Meters----------------------*/ else if (box1.getValue() == "Meters") {
            if (box2.getValue() == "Millimeters") //MilliMeters
            {
                if (!TA1.getText().isEmpty()) {
                    data = Double.parseDouble(TA1.getText());
                    res = data * 1000;
                    TA2.setText(Double.toString(res));
                } else {
                    TA2.clear();
                }
            } else if (box2.getValue() == "CentiMeters") //Centimeter
            {
                if (!TA1.getText().isEmpty()) {
                    data = Double.parseDouble(TA1.getText());
                    res = data * 100;
                    TA2.setText(Double.toString(res));
                } else {
                    TA2.clear();
                }
            } else if (box2.getValue() == "Meters") //Meter
            {
                if (!TA1.getText().isEmpty()) {
                    data = Double.parseDouble(TA1.getText());
                    res = data;
                    TA2.setText(Double.toString(res));
                } else {
                    TA2.clear();
                }
            } else if (box2.getValue() == "KiloMeters") //KiloMeters
            {
                if (!TA1.getText().isEmpty()) {
                    data = Double.parseDouble(TA1.getText());
                    res = data / 1000;
                    TA2.setText(Double.toString(res));
                } else {
                    TA2.clear();
                }
            } else if (box2.getValue() == "Inches") //Inches
            {
                if (!TA1.getText().isEmpty()) {
                    data = Double.parseDouble(TA1.getText());
                    res = data * 39.37;
                    TA2.setText(String.format("%.4f", res));
                } else {
                    TA2.clear();
                }
            } else if (box2.getValue() == "Feets") //feets
            {
                if (!TA1.getText().isEmpty()) {
                    data = Double.parseDouble(TA1.getText());
                    res = data * 3.281;
                    TA2.setText(String.format("%.4f", res));
                } else {
                    TA2.clear();
                }
            } else if (box2.getValue() == "Miles") //Miles
            {
                if (!TA1.getText().isEmpty()) {
                    data = Double.parseDouble(TA1.getText());
                    res = data / 1609;
                    TA2.setText(String.format("%.4f", res));
                } else {
                    TA2.clear();
                }
            }
        } /*----------------KiloMeters-----------------*/ else if (box1.getValue() == "KiloMeters") {
            if (box2.getValue() == "Millimeters") //MilliMeters
            {
                if (!TA1.getText().isEmpty()) {
                    data = Double.parseDouble(TA1.getText());
                    res = data * 1000000;
                    TA2.setText(Double.toString(res));
                } else {
                    TA2.clear();
                }
            } else if (box2.getValue() == "CentiMeters") //Centimeter
            {
                if (!TA1.getText().isEmpty()) {
                    data = Double.parseDouble(TA1.getText());
                    res = data * 100000;
                    TA2.setText(Double.toString(res));
                } else {
                    TA2.clear();
                }
            } else if (box2.getValue() == "Meters") //Meter
            {
                if (!TA1.getText().isEmpty()) {
                    data = Double.parseDouble(TA1.getText());
                    res = data * 1000;
                    TA2.setText(Double.toString(res));
                } else {
                    TA2.clear();
                }
            } else if (box2.getValue() == "KiloMeters") //KiloMeters
            {
                if (!TA1.getText().isEmpty()) {
                    data = Double.parseDouble(TA1.getText());
                    res = data;
                    TA2.setText(Double.toString(res));
                } else {
                    TA2.clear();
                }
            } else if (box2.getValue() == "Inches") //Inches
            {
                if (!TA1.getText().isEmpty()) {
                    data = Double.parseDouble(TA1.getText());
                    res = data * 39370;
                    TA2.setText(String.format("%.4f", res));
                } else {
                    TA2.clear();
                }
            } else if (box2.getValue() == "Feets") //feets
            {
                if (!TA1.getText().isEmpty()) {
                    data = Double.parseDouble(TA1.getText());
                    res = data * 3281;
                    TA2.setText(String.format("%.4f", res));
                } else {
                    TA2.clear();
                }
            } else if (box2.getValue() == "Miles") //Miles
            {
                if (!TA1.getText().isEmpty()) {
                    data = Double.parseDouble(TA1.getText());
                    res = data / 1.609;
                    TA2.setText(String.format("%.4f", res));
                } else {
                    TA2.clear();
                }
            }
        } /*----------------Inches----------------*/ else if (box1.getValue() == "Inches") {
            if (box2.getValue() == "Millimeters") //MilliMeters
            {
                if (!TA1.getText().isEmpty()) {
                    data = Double.parseDouble(TA1.getText());
                    res = data * 25.4;
                    TA2.setText(Double.toString(res));
                } else {
                    TA2.clear();
                }
            } else if (box2.getValue() == "CentiMeters") //Centimeter
            {
                if (!TA1.getText().isEmpty()) {
                    data = Double.parseDouble(TA1.getText());
                    res = data * 2.54;
                    TA2.setText(Double.toString(res));
                } else {
                    TA2.clear();
                }
            } else if (box2.getValue() == "Meters") //Meter
            {
                if (!TA1.getText().isEmpty()) {
                    data = Double.parseDouble(TA1.getText());
                    res = data / 39.37;
                    TA2.setText(String.format("%.3f", res));
                } else {
                    TA2.clear();
                }
            } else if (box2.getValue() == "KiloMeters") //KiloMeters
            {
                if (!TA1.getText().isEmpty()) {
                    data = Double.parseDouble(TA1.getText());
                    res = data / 39370;
                    TA2.setText(String.format("%.3f", res));
                } else {
                    TA2.clear();
                }
            } else if (box2.getValue() == "Inches") //Inches
            {
                if (!TA1.getText().isEmpty()) {
                    data = Double.parseDouble(TA1.getText());
                    res = data;
                    TA2.setText(String.format("%.3f", res));
                } else {
                    TA2.clear();
                }
            } else if (box2.getValue() == "Feets") //feets
            {
                if (!TA1.getText().isEmpty()) {
                    data = Double.parseDouble(TA1.getText());
                    res = data / 12;
                    TA2.setText(String.format("%.3f", res));
                } else {
                    TA2.clear();
                }
            } else if (box2.getValue() == "Miles") //Miles
            {
                if (!TA1.getText().isEmpty()) {
                    data = Double.parseDouble(TA1.getText());
                    res = data / 63360;
                    TA2.setText(String.format("%.3f", res));
                } else {
                    TA2.clear();
                }
            }
        } /*----------------Feets---------------*/ else if (box1.getValue() == "Feets") {
            if (box2.getValue() == "Millimeters") //MilliMeters
            {
                if (!TA1.getText().isEmpty()) {
                    data = Double.parseDouble(TA1.getText());
                    res = data * 304.8;
                    TA2.setText(Double.toString(res));
                } else {
                    TA2.clear();
                }
            } else if (box2.getValue() == "CentiMeters") //Centimeter
            {
                if (!TA1.getText().isEmpty()) {
                    data = Double.parseDouble(TA1.getText());
                    res = data * 30.48;
                    TA2.setText(Double.toString(res));
                } else {
                    TA2.clear();
                }
            } else if (box2.getValue() == "Meters") //Meter
            {
                if (!TA1.getText().isEmpty()) {
                    data = Double.parseDouble(TA1.getText());
                    res = data / 3.281;
                    TA2.setText(String.format("%.3f", res));
                } else {
                    TA2.clear();
                }
            } else if (box2.getValue() == "KiloMeters") //KiloMeters
            {
                if (!TA1.getText().isEmpty()) {
                    data = Double.parseDouble(TA1.getText());
                    res = data / 3281;
                    TA2.setText(String.format("%.3f", res));
                } else {
                    TA2.clear();
                }
            } else if (box2.getValue() == "Inches") //Inches
            {
                if (!TA1.getText().isEmpty()) {
                    data = Double.parseDouble(TA1.getText());
                    res = data * 12;
                    TA2.setText(String.format("%.3f", res));
                } else {
                    TA2.clear();
                }
            } else if (box2.getValue() == "Feets") //feets
            {
                if (!TA1.getText().isEmpty()) {
                    data = Double.parseDouble(TA1.getText());
                    res = data;
                    TA2.setText(String.format("%.3f", res));
                } else {
                    TA2.clear();
                }
            } else if (box2.getValue() == "Miles") //Miles
            {
                if (!TA1.getText().isEmpty()) {
                    data = Double.parseDouble(TA1.getText());
                    res = data / 5280;
                    TA2.setText(String.format("%.3f", res));
                } else {
                    TA2.clear();
                }
            }
        } /*----------------Miles--------------------*/ else if (box1.getValue() == "Miles") {
            if (box2.getValue() == "Millimeters") //MilliMeters
            {
                if (!TA1.getText().isEmpty()) {
                    data = Double.parseDouble(TA1.getText());
                    res = data * 1000000;
                    res = res * 1.609;
                    TA2.setText(Double.toString(res));
                } else {
                    TA2.clear();
                }
            } else if (box2.getValue() == "CentiMeters") //Centimeter
            {
                if (!TA1.getText().isEmpty()) {
                    data = Double.parseDouble(TA1.getText());
                    res = data * 160934;
                    TA2.setText(Double.toString(res));
                } else {
                    TA2.clear();
                }
            } else if (box2.getValue() == "Meters") //Meter
            {
                if (!TA1.getText().isEmpty()) {
                    data = Double.parseDouble(TA1.getText());
                    res = data * 1609;
                    TA2.setText(Double.toString(res));
                } else {
                    TA2.clear();
                }
            } else if (box2.getValue() == "KiloMeters") //KiloMeters
            {
                if (!TA1.getText().isEmpty()) {
                    data = Double.parseDouble(TA1.getText());
                    res = data * 1.609;
                    TA2.setText(String.format("%.3f", res));
                } else {
                    TA2.clear();
                }
            } else if (box2.getValue() == "Inches") //Inches
            {
                if (!TA1.getText().isEmpty()) {
                    data = Double.parseDouble(TA1.getText());
                    res = data * 63360;
                    TA2.setText(String.format("%.3f", res));
                } else {
                    TA2.clear();
                }
            } else if (box2.getValue() == "Feets") //feets
            {
                if (!TA1.getText().isEmpty()) {
                    data = Double.parseDouble(TA1.getText());
                    res = data * 5280;
                    TA2.setText(String.format("%.3f", res));
                } else {
                    TA2.clear();
                }
            } else if (box2.getValue() == "Miles") //Miles
            {
                if (!TA1.getText().isEmpty()) {
                    data = Double.parseDouble(TA1.getText());
                    res = data;
                    TA2.setText(String.format("%.3f", res));
                } else {
                    TA2.clear();
                }
            }
        }
    }

    /*Fady Part*/
    @FXML
    private void Change(javafx.scene.input.KeyEvent event) {
        if (!event.getText().isEmpty()) {
            if (event.getText().matches("[0-9.]")) {
                TA1.appendText(event.getText());
            }
        } else if (event.getCode() == KeyCode.BACK_SPACE) {
            if (!TA1.getText().isEmpty()) {
                TA1.deleteText(TA1.getLength() - 1, TA1.getLength());
            }
        }

        Converter();
    }

    /*Fady Part*/
    public void loaddata() {
        list.removeAll(list);
        String milli = "Millimeters";
        String centi = "CentiMeters";
        String meter = "Meters";
        String kilo = "KiloMeters";
        String inches = "Inches";
        String feet = "Feets";
        String miles = "Miles";
        list.addAll(milli, centi, meter, kilo, inches, feet, miles);
        box1.getItems().addAll(list);
        box1.getSelectionModel().selectFirst();
        box2.getItems().addAll(list);
        box2.getSelectionModel().selectFirst();
    }

    @FXML
    private void DateCalulationBtn() {
        x = 0;
        y = 2;
        DateCalc_Flag = true;
        Scientific_Flag = false;
        Length_Flag = false;
        Graph_Flag = false;
        Temperature_Flag = false;
        Programmer_Flag = false;
        TA.clear();
        TA1.clear();
        TA11.clear();
        TA21.clear();
        TA2.clear();
        text_Area.clear();
        text_Area2.clear();
        lineChart.getData().clear();
        resultLabel.setText("");
        this.ScientificPane.setVisible(false);
        this.LengthPane.setVisible(false);
        this.GarphingPane.setVisible(false);
        this.ConfigurationPane.setVisible(false);
        this.DateCalcPane.setVisible(true);
        this.TemperaturePane.setVisible(false);
        this.ProgrammerPane.setVisible(false);
        MenuVisibility();
    }

    @FXML
    private void EndDateCheckBox() {
        ToggleEndDate();
    }

    @FXML
    private void calculateButton() {
        Display();
    }

    /**
     * ***********************************Abdelghany
     * Part**************************************************************
     */
    public void ToggleEndDate() {                           //switch between two ways of gettin the end date

        if (EndDateCheckBox.isSelected()) {
            EndDay.setDisable(false);
            EndMonth.setDisable(false);
            EndYear.setDisable(false);
        } else {
            EndDay.setDisable(true);
            EndMonth.setDisable(true);
            EndYear.setDisable(true);
        }

    }

    /*-----------------------------------------------------------------------------------------------------------*/
    public void Display() {

        String text = "";

        y1 = Integer.parseInt(StartYear.getSelectionModel().getSelectedItem().toString());                  //get start values 
        m1 = StartMonth.getSelectionModel().getSelectedIndex() + 1;
        d1 = Integer.parseInt(StartDay.getSelectionModel().getSelectedItem().toString());

        if (EndDateCheckBox.isSelected()) {                                                                 //get end values 
            y2 = Integer.parseInt(EndYear.getSelectionModel().getSelectedItem().toString());
            m2 = EndMonth.getSelectionModel().getSelectedIndex() + 1;
            d2 = Integer.parseInt(EndDay.getSelectionModel().getSelectedItem().toString());
        } else {
            y2 = LocalDate.now().getYear();
            m2 = LocalDate.now().getMonthValue();
            d2 = LocalDate.now().getDayOfMonth();
        }
        /*-----------------------------------------------------------------------------------------------------------*/
        startDate = LocalDate.of(y1, m1, d1);
        endDate = LocalDate.of(y2, m2, d2);

        yearsCounter = Period.between(startDate, endDate).getYears();
        monthsCounter = Period.between(startDate, endDate).getMonths();
        daysCounter = Period.between(startDate, endDate).getDays();

        if (yearsCounter == 0 && monthsCounter == 0 && daysCounter == 0) {               //same date
            resultLabel.setTextFill(Color.RED);
            resultLabel.setText("Cannot compare same date!");
        } else if (!Period.between(startDate, endDate).isNegative()) {                  //years handling
            if (yearsCounter == 1) {
                text += yearsCounter + " year ";
            } else if (yearsCounter > 1) {
                text += yearsCounter + " years ";
            }
            if (monthsCounter == 1) {                                                   //one month handling
                if (yearsCounter > 0 && daysCounter > 0) {
                    text += ", " + monthsCounter + " month ";
                } else if (yearsCounter > 0 && daysCounter == 0) {
                    text += "and " + monthsCounter + " month ";
                } else {
                    text += monthsCounter + " month ";
                }
            }
            if (monthsCounter > 1) {                                                    //more than one month handling
                if (yearsCounter > 0 && daysCounter > 0) {
                    text += ", " + monthsCounter + " months ";
                } else if (yearsCounter > 0 && daysCounter == 0) {
                    text += "and " + monthsCounter + " months ";
                } else {
                    text += monthsCounter + " months ";
                }
            }
            if (daysCounter == 1) {                                                     //one day handling
                if (yearsCounter == 0 && monthsCounter == 0) {
                    text += daysCounter + " day";
                } else {
                    text += "and " + daysCounter + " day";
                }
            }
            if (daysCounter > 1) {                                                       //more than one day handling
                if (yearsCounter == 0 && monthsCounter == 0) {
                    text += daysCounter + " days";
                } else {
                    text += "and " + daysCounter + " days";
                }
            }                                                                           //Display result
            resultLabel.setAlignment(Pos.CENTER);
            resultLabel.setTextFill(Color.WHITE);
            resultLabel.setText(text);
        } else {
            resultLabel.setAlignment(Pos.CENTER);
            resultLabel.setTextFill(Color.RED);                                         //Display Wrong result
            resultLabel.setText("Logic order of Dates is wrong!");
        }
    }

    /**
     * * Plotting Function to handle X,Y data provided for te eqn to plot it **
     */
    @FXML
    private void Plot() {
        eqn = plotEqn.getText();
        eqnTmp = plotEqn.getText();
        lineChart.getData().clear();

        System.out.println(eqn);
        XYChart.Series<String, Number> series = new XYChart.Series<String, Number>();
        int i;
        if (!startTF.getText().isEmpty()) {
            Xaxis = startTF.getText();
        } else {
            Xaxis = "0";
        }
        if (!endTF.getText().isEmpty()) {
            endPt = endTF.getText();
            range = Math.abs(Integer.parseInt(Xaxis) - Integer.parseInt(endPt));
        }
        for (i = 1; i <= range; i++) {
            Xaxis = Xaxis + "+1";
            try {
                Xaxis = String.format("%.2f", Double.parseDouble(engine.eval(Xaxis).toString()));
                eqn = eqn.replace("x", Xaxis);
                if (!plotEqn.getText().isEmpty()) {
                    Graphing_Y = Double.parseDouble(engine.eval(Calculate_Eqn(eqn)).toString());
                }
            } catch (ScriptException e) {
                plotEqn.setText("Undefined!!");

                lineChart.getData().clear();
            }
            if (Graphing_Y.isNaN()) {
                lineChart.getData().clear();
                plotEqn.setText("ERROR! Check Your Formula or Range");

            } else {

                series.getData().add(new XYChart.Data<String, Number>(Xaxis, Graphing_Y));
                eqn = eqnTmp;
            }

        }

        Xaxis = "0";
        Graphing_Y = 0.0;
        lineChart.getData().add(series);

    }

    @FXML
    private void GraphingButton() {
        x = 0;
        y = 0;
        Scientific_Flag = false;
        Length_Flag = false;
        DateCalc_Flag = false;
        Graph_Flag = true;
        Temperature_Flag = false;
        Programmer_Flag = false;
        TA.clear();
        TA1.clear();
        TA2.clear();
        TA11.clear();
        TA21.clear();
        text_Area.clear();
        text_Area2.clear();
        resultLabel.setText("");
        this.ScientificPane.setVisible(false);
        this.LengthPane.setVisible(false);
        this.GarphingPane.setVisible(true);
        this.DateCalcPane.setVisible(false);
        this.TemperaturePane.setVisible(false);
        this.ConfigurationPane.setVisible(false);
        this.ProgrammerPane.setVisible(false);
        MenuVisibility();
    }

    @FXML
    private void ConfigurationButton() {
        Scientific_Flag = false;
        Length_Flag = false;
        DateCalc_Flag = false;
        Graph_Flag = false;
        Temperature_Flag = false;
        Programmer_Flag = false;
        TA.clear();
        TA1.clear();
        TA2.clear();
        TA11.clear();
        TA21.clear();
        text_Area.clear();
        text_Area2.clear();
        resultLabel.setText("");
        lineChart.getData().clear();
        plotEqn.clear();
        startTF.clear();
        endTF.clear();
        EndDateCheckBox.setSelected(false);
        this.GarphingPane.setVisible(false);
        this.DateCalcPane.setVisible(false);
        this.ScientificPane.setVisible(false);
        this.LengthPane.setVisible(false);
        this.TemperaturePane.setVisible(false);
        this.ConfigurationPane.setVisible(true);
        this.ProgrammerPane.setVisible(false);
        MenuVisibility();
        StartDay.getSelectionModel().select(0);
        StartMonth.getSelectionModel().select(0);
        StartYear.getSelectionModel().select(0);
        EndDay.getSelectionModel().select(0);
        EndMonth.getSelectionModel().select(0);
        EndYear.getSelectionModel().select(0);
        ToggleEndDate();
    }

    @FXML
    private void Disconnect(MouseEvent event) {
        try {
            disconnectArduino();
        } catch (SerialPortException ex) {
            //Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Disconnect.setDisable(true);
        Connect.setDisable(false);
    }

    @FXML
    private void Connect(MouseEvent event) {
        connectArduino(new_Value);
        Connect.setDisable(true);
        Disconnect.setDisable(false);
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

    public void onstop() throws Exception {
        disconnectArduino();
        System.exit(10);
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
                                ArduinoRecieved = st;
                                if (st.equalsIgnoreCase("UP")) {
                                    r.keyPress(KeyEvent.VK_UP);
                                } else if (st.equalsIgnoreCase("DOWN")) {
                                    r.keyPress(KeyEvent.VK_DOWN);
                                } else if (st.equalsIgnoreCase("LEFT")) {
                                    r.keyPress(KeyEvent.VK_LEFT);
                                } else if (st.equalsIgnoreCase("RIGHT")) {
                                    r.keyPress(KeyEvent.VK_RIGHT);
                                } else if (st.equalsIgnoreCase("Menu")) {
                                    MenuHandling();
                                } else if (st.equalsIgnoreCase("History")) {
                                    try {
                                        HistoryBtn();
                                    } catch (IOException ex) {
                                        //Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                } else if (st.equalsIgnoreCase("Exit")) {
                                    System.exit(0);
                                } else if (st.equalsIgnoreCase("Enter")) {
                                    r.keyPress(KeyEvent.VK_ENTER);
                                } else {
                                    if (Scientific_Flag) {
                                        switch (st) {
                                            case "0":
                                                handleButtonAction0();
                                                break;
                                            case "1":
                                                handleButtonAction1();
                                                break;
                                            case "2":
                                                handleButtonAction2();
                                                break;
                                            case "3":
                                                handleButtonAction3();
                                                break;
                                            case "4":
                                                handleButtonAction4();
                                                break;
                                            case "5":
                                                handleButtonAction5();
                                                break;
                                            case "6":
                                                handleButtonAction6();
                                                break;
                                            case "7":
                                                handleButtonAction7();
                                                break;
                                            case "8":
                                                handleButtonAction8();
                                                break;
                                            case "9":
                                                handleButtonAction9();
                                                break;
                                            case ".":
                                                handleButtonActionDot();
                                                break;
                                            case "=":
                                                handleButtonActionEqu();
                                                break;
                                            case "+":
                                                handleButtonActionP();
                                                break;
                                            case "-":
                                                handleButtonActionN();
                                                break;
                                            case "*":
                                                handleButtonActionM();
                                                break;
                                            case "/":
                                                handleButtonActionD();
                                                break;
                                        }
                                    } else if (Graph_Flag) {
                                        if (startTF_Flag) {
                                            startTF.appendText(st);
                                        } else if (endTF_Flag) {
                                            endTF.appendText(st);
                                        } else if (GraphTF_Flag) {
                                            plotEqn.appendText(st);
                                        }
                                    } else if (Programmer_Flag) {
                                        switch (st) {
                                            case "0":
                                                Button_0();
                                                break;
                                            case "1":
                                                Button_1();
                                                break;
                                            case "2":
                                                Button_2();
                                                break;
                                            case "3":
                                                Button_3();
                                                break;
                                            case "4":
                                                Button_4();
                                                break;
                                            case "5":
                                                Button_5();
                                                break;
                                            case "6":
                                                Button_6();
                                                break;
                                            case "7":
                                                Button_7();
                                                break;
                                            case "8":
                                                Button_8();
                                                break;
                                            case "9":
                                                Button_9();
                                                break;
                                            case ".":
                                                Button_Equal();
                                                break;
                                            case "=":
                                                Button_Equal1();
                                                break;
                                        }
                                    } else if (Length_Flag) {
                                        switch (st) {
                                            case "0":
                                                TA1.appendText("0");
                                                break;
                                            case "1":
                                                TA1.appendText("1");
                                                break;
                                            case "2":
                                                TA1.appendText("2");
                                                break;
                                            case "3":
                                                TA1.appendText("3");
                                                break;
                                            case "4":
                                                TA1.appendText("4");
                                                break;
                                            case "5":
                                                TA1.appendText("5");
                                                break;
                                            case "6":
                                                TA1.appendText("6");
                                                break;
                                            case "7":
                                                TA1.appendText("7");
                                                break;
                                            case "8":
                                                TA1.appendText("8");
                                                break;
                                            case "9":
                                                TA1.appendText("9");
                                                break;
                                            case ".":
                                                TA1.appendText(".");
                                                break;
                                        }
                                        Converter();
                                    } else if (Temperature_Flag) {
                                        switch (st) {
                                            case "0":
                                                TA11.appendText("0");
                                                break;
                                            case "1":
                                                TA11.appendText("1");
                                                break;
                                            case "2":
                                                TA11.appendText("2");
                                                break;
                                            case "3":
                                                TA11.appendText("3");
                                                break;
                                            case "4":
                                                TA11.appendText("4");
                                                break;
                                            case "5":
                                                TA11.appendText("5");
                                                break;
                                            case "6":
                                                TA11.appendText("6");
                                                break;
                                            case "7":
                                                TA11.appendText("7");
                                                break;
                                            case "8":
                                                TA11.appendText("8");
                                                break;
                                            case "9":
                                                TA11.appendText("9");
                                                break;
                                            case ".":
                                                TA11.appendText(".");
                                                break;
                                        }
                                        Converter2();
                                    }

                                }
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
    private void HistoryBtn() throws FileNotFoundException, IOException {
        Vbox.setVisible(false);
        MenuBox.setVisible(false);
        MenuBox2.setVisible(false);
        FunctionsMenu.setVisible(false);
        HistoryPane.setVisible(false);
        HistoryPane1.setVisible(false);
        y = 7;
        x = 0;
        Vbox_Flag = false;
        Function_Flag = false;
        Menu_Flag = false;
        History_Flag = !History_Flag;
        HistoryPane.setVisible(History_Flag);
        HistoryPane1.setVisible(History_Flag);
        if (serverFound) {
            /* You need here to change to the path of your files*/
            br = new BufferedReader(new FileReader("D:\\" + file));
            String st;
            History_TA.clear();
            History_TA1.clear();
            while ((st = br.readLine()) != null) {
                History_TA.appendText(st + "\n");
                History_TA1.appendText(st + "\n");
                System.out.println(st);
            }

        }
    }

    @FXML
    private void Converter2() {
        double res;
        double data;
        /*---------Celsius--------*/
        if (box11.getValue() == "Celsius") {
            if (box21.getValue() == "Celsius") //Celsius
            {
                TA21.setText(TA11.getText());
            } else if (box21.getValue() == "Fahrenheit") //Fahrenheit
            {
                if (!TA11.getText().isEmpty()) {
                    data = Double.parseDouble(TA11.getText());
                    res = (data * 9 / 5) + 32;
                    TA21.setText(Double.toString(res));
                } else {
                    res = (0 * 9 / 5) + 32;
                    TA21.setText(Double.toString(res));
                }
            } else if (box21.getValue() == "Kelvin") //Kelvin
            {
                if (!TA11.getText().isEmpty()) {
                    data = Double.parseDouble(TA11.getText());
                    res = data + 273.15;
                    TA21.setText(Double.toString(res));
                } else {
                    res = 0 + 273.15;
                    TA21.setText(Double.toString(res));
                }
            }

        }

        /*--------Fahrenheit---------*/
        if (box11.getValue() == "Fahrenheit") {
            if (box21.getValue() == "Celsius") //Celsius
            {
                if (!TA11.getText().isEmpty()) {
                    data = Double.parseDouble(TA11.getText());
                    res = (data - 32) * 5.0 / 9;
                    TA21.setText(Double.toString(res));
                } else {
                    res = (0 - 32) * 5.0 / 9;
                    TA21.setText(Double.toString(res));
                }
            } else if (box21.getValue() == "Fahrenheit") //Fahrenheit
            {
                TA21.setText(TA11.getText());
            } else if (box21.getValue() == "Kelvin") //Kelvin
            {
                if (!TA11.getText().isEmpty()) {
                    data = Double.parseDouble(TA11.getText());
                    res = (data - 32) * 5.0 / 9 + 273.15;
                    TA21.setText(Double.toString(res));
                } else {
                    res = (0 - 32) * 5 / 9 + 273.15;
                    TA21.setText(Double.toString(res));
                }
            }

        }

        /*--------Kelvin---------*/
        if (box11.getValue() == "Kelvin") {
            if (box21.getValue() == "Celsius") //Celsius
            {
                if (!TA11.getText().isEmpty()) {
                    data = Double.parseDouble(TA1.getText());
                    res = data - 273.15;
                    TA21.setText(Double.toString(res));
                } else {
                    res = 0 - 273.15;
                    TA21.setText(Double.toString(res));
                }
            } else if (box21.getValue() == "Fahrenheit") //Fahrenheit
            {
                if (!TA11.getText().isEmpty()) {
                    data = Double.parseDouble(TA11.getText());
                    res = (data - 273.15) * 9 / 5 + 32;
                    TA21.setText(Double.toString(res));
                } else {
                    res = (0 - 273.15) * 9 / 5 + 32;
                    TA21.setText(Double.toString(res));
                }
            } else if (box21.getValue() == "Kelvin") //Kelvin
            {
                TA21.setText(TA11.getText());
            }
        }
    }

    private void Change2(javafx.scene.input.KeyEvent event) {
        if (!event.getText().isEmpty()) {
            if (event.getText().matches("[0-9.]")) {
                TA11.appendText(event.getText());
            }
        } else if (event.getCode() == KeyCode.BACK_SPACE) {
            if (!TA11.getText().isEmpty()) {
                TA11.deleteText(TA1.getLength() - 1, TA11.getLength());
            }
        }

        Converter2();

    }

    @FXML
    private void TemperatureButton() {
        x = 0;
        y = 0;
        Length_Flag = false;
        Graph_Flag = false;
        Scientific_Flag = false;
        DateCalc_Flag = false;
        Temperature_Flag = true;
        Programmer_Flag = false;
        TA.clear();
        TA1.clear();
        TA2.clear();
        text_Area.clear();
        text_Area2.clear();
        resultLabel.setText("");
        this.ScientificPane.setVisible(false);
        this.LengthPane.setVisible(false);
        this.GarphingPane.setVisible(false);
        this.DateCalcPane.setVisible(false);
        this.TemperaturePane.setVisible(true);
        this.ConfigurationPane.setVisible(false);
        this.ProgrammerPane.setVisible(false);
        MenuVisibility();
        StartDay.getSelectionModel().select(0);
        StartMonth.getSelectionModel().select(0);
        StartYear.getSelectionModel().select(0);
        EndDay.getSelectionModel().select(0);
        EndMonth.getSelectionModel().select(0);
        EndYear.getSelectionModel().select(0);
        ToggleEndDate();
    }

    public void loaddata2() {
        list.removeAll(list);
        String celsius = "Celsius";
        String fahr = "Fahrenheit";
        String kel = "Kelvin";

        list.addAll(celsius, fahr, kel);
        box11.getItems().addAll(list);
        box11.getSelectionModel().selectFirst();
        box21.getItems().addAll(list);
        box21.getSelectionModel().selectFirst();
    }

    @FXML
    private void Button_0() {
        if (EQ_FLAG == 1) {
            text_Area.clear();
        }
        if (TEXT_2 == true) {
            text_Area2.appendText("0");
        } else {
            text_Area.appendText("0");
        }
        EQ_FLAG = 0;
    }

    @FXML
    private void Button_1() {
        if (EQ_FLAG >= 1) {
            text_Area.clear();
        }
        if (TEXT_2 == true) {
            text_Area2.appendText("1");
        } else {
            text_Area.appendText("1");
        }

        EQ_FLAG = 0;

    }

    @FXML
    private void Button_2() {
        if (EQ_FLAG >= 1) {
            text_Area.clear();
        }
        if (TEXT_2 == true) {
            text_Area2.appendText("2");
        } else {
            text_Area.appendText("2");
        }
        EQ_FLAG = 0;

    }

    @FXML
    private void Button_3() {
        if (EQ_FLAG >= 1) {
            text_Area.clear();
        }
        if (TEXT_2 == true) {
            text_Area2.appendText("3");
        } else {
            text_Area.appendText("3");
        }

        EQ_FLAG = 0;

    }

    @FXML
    private void Button_4() {

        if (EQ_FLAG >= 1) {
            text_Area.clear();
        }
        if (TEXT_2 == true) {
            text_Area2.appendText("4");
        } else {
            text_Area.appendText("4");
        }
        EQ_FLAG = 0;
    }

    @FXML
    private void Button_5() {
        if (EQ_FLAG >= 1) {
            text_Area.clear();
        }
        if (TEXT_2 == true) {
            text_Area2.appendText("5");
        } else {
            text_Area.appendText("5");
        }
        EQ_FLAG = 0;

    }

    @FXML
    private void Button_6() {
        if (EQ_FLAG >= 1) {
            text_Area.clear();
        }
        if (TEXT_2 == true) {
            text_Area2.appendText("6");
        } else {
            text_Area.appendText("6");
        }
        EQ_FLAG = 0;

    }

    @FXML
    private void Button_7() {
        if (EQ_FLAG >= 1) {
            text_Area.clear();
        }
        if (TEXT_2 == true) {
            text_Area2.appendText("7");
        } else {
            text_Area.appendText("7");
        }
        EQ_FLAG = 0;

    }

    @FXML
    private void Button_8() {
        if (EQ_FLAG >= 1) {
            text_Area.clear();
        }
        if (TEXT_2 == true) {
            text_Area2.appendText("8");
        } else {
            text_Area.appendText("8");
        }
        EQ_FLAG = 0;

    }

    @FXML
    private void Button_9() {
        if (EQ_FLAG >= 1) {
            text_Area.clear();
        }
        if (TEXT_2 == true) {
            text_Area2.appendText("9");
        } else {
            text_Area.appendText("9");
        }
        EQ_FLAG = 0;

    }

    private void Label_OCT() {
        if (EQ_FLAG >= 1) {
            text_Area.clear();
        }
        if (TEXT_2 == true) {
            text_Area2.appendText("F");
        } else {
            text_Area.appendText("F");
        }
        EQ_FLAG = 0;

    }

    @FXML
    private void Button_BIN() {
        //Flag of binary numbers
        BIN_FLAG = true;

        DEC_FLAG = false;
        OCT_FLAG = false;
        HEX_FLAG = false;
        //Enable Zeros and Ones Button only

        btn_2.setDisable(true);
        btn_3.setDisable(true);
        btn_4.setDisable(true);
        btn_5.setDisable(true);
        btn_6.setDisable(true);
        btn_7.setDisable(true);
        btn_8.setDisable(true);
        btn_9.setDisable(true);
        btn_A.setDisable(true);
        btn_B.setDisable(true);
        btn_C.setDisable(true);
        btn_D.setDisable(true);
        btn_E.setDisable(true);
        btn_F.setDisable(true);
    }

    @FXML
    private void Button_OCT() {
        //(1) Flag of Octal
        OCT_FLAG = true;

        DEC_FLAG = false;
        BIN_FLAG = false;
        HEX_FLAG = false;

        btn_2.setDisable(false);
        btn_3.setDisable(false);
        btn_4.setDisable(false);
        btn_5.setDisable(false);
        btn_6.setDisable(false);
        btn_7.setDisable(false);
        btn_8.setDisable(true);
        btn_9.setDisable(true);
        btn_A.setDisable(true);
        btn_B.setDisable(true);
        btn_C.setDisable(true);
        btn_D.setDisable(true);
        btn_E.setDisable(true);
        btn_F.setDisable(true);

    }

    @FXML
    private void Button_HEX() {
        //(1) Flag of Hexadecimal numbers
        HEX_FLAG = true;

        DEC_FLAG = false;
        OCT_FLAG = false;
        BIN_FLAG = false;

        btn_2.setDisable(false);
        btn_3.setDisable(false);
        btn_4.setDisable(false);
        btn_5.setDisable(false);
        btn_6.setDisable(false);
        btn_7.setDisable(false);
        btn_8.setDisable(false);
        btn_9.setDisable(false);
        btn_A.setDisable(false);
        btn_B.setDisable(false);
        btn_C.setDisable(false);
        btn_D.setDisable(false);
        btn_E.setDisable(false);
        btn_F.setDisable(false);

    }

    @FXML
    private void Buuton_DEC() {
        DEC_FLAG = true;

        HEX_FLAG = false;
        OCT_FLAG = false;
        BIN_FLAG = false;

        btn_2.setDisable(false);
        btn_3.setDisable(false);
        btn_4.setDisable(false);
        btn_5.setDisable(false);
        btn_6.setDisable(false);
        btn_7.setDisable(false);
        btn_8.setDisable(false);
        btn_9.setDisable(false);
        btn_A.setDisable(true);
        btn_B.setDisable(true);
        btn_C.setDisable(true);
        btn_D.setDisable(true);
        btn_E.setDisable(true);
        btn_F.setDisable(true);
    }

    @FXML
    private void Concurrent(MouseEvent event) {
    }

    @FXML
    private void Button_Clear() {
        text_Area.clear();
        text_Area2.clear();

        label_OCT.clear();
        label_HEX.clear();
        label_BIN.clear();
        label_DEC.clear();

        operation.setText("");

        TEXT_2 = false;
    }

    @FXML
    private void Button_NOT() {
        String text = text_Area.getText();
        try {
            long num;

            if (BIN_FLAG == true) {
                num = Long.parseLong(text, 2); // to return Decimal number
            } else if (HEX_FLAG == true) {
                num = Long.parseLong(text, 16);
            } else if (OCT_FLAG == true) {
                num = Long.parseLong(text, 8);
            } else {
                num = Long.parseLong(text);
            }

            long result = ~num; // result is a Decimal Number and we will convert it to suitable number 
            ans = result;
            String s = "0";
            if (BIN_FLAG == true) {
                s = Long.toBinaryString(result);//Converting to binary

            } else if (HEX_FLAG == true) {
                s = Long.toHexString(result);  //Convertig to hex
            } else if (OCT_FLAG == true) {
                s = Long.toOctalString(result);//Converting to octal
            } else {
                s = String.valueOf(result);
            }
            //Converting result to string 
            text_Area.setText(s);
            progEqn = "NOT ( " + text + " ) = " + s;
            if (serverFound) {
                ps.println(progEqn);
            }
        } catch (NumberFormatException e) {
            text_Area.appendText("  Very Long Number");
            System.out.println("Number of Exception occured because it is very long number !");
        }
        EQ_FLAG = 1;

    }

    @FXML
    private void Button_XOR() {
        XOR_FLAG = true;
        AND_FLAG = false;
        OR_FLAG = false;
        EQ_FLAG = 0;
        TEXT_2 = true;
        operation.setText("XOR");

    }

    @FXML
    private void Button_AND() {
        XOR_FLAG = false;
        AND_FLAG = true;
        OR_FLAG = false;

        EQ_FLAG = 0;

        TEXT_2 = true;
        operation.setText("AND");
    }

    @FXML
    private void Button_OR() {
        XOR_FLAG = false;
        AND_FLAG = false;
        OR_FLAG = true;

        EQ_FLAG = 0;

        TEXT_2 = true;

        operation.setText("OR");
    }

    @FXML
    private void Button_F() {
        if (EQ_FLAG >= 1) {
            text_Area.clear();
        }
        if (TEXT_2 == true) {
            text_Area2.appendText("F");
        } else {
            text_Area.appendText("F");
        }
        EQ_FLAG = 0;

    }

    @FXML
    private void Button_E() {
        if (EQ_FLAG >= 1) {
            text_Area.clear();
        }
        if (TEXT_2 == true) {
            text_Area2.appendText("E");
        } else {
            text_Area.appendText("E");
        }
        EQ_FLAG = 0;

    }

    @FXML
    private void Button_D() {
        if (EQ_FLAG >= 1) {
            text_Area.clear();
        }
        if (TEXT_2 == true) {
            text_Area2.appendText("D");
        } else {
            text_Area.appendText("D");
        }
        EQ_FLAG = 0;

    }

    @FXML
    private void Button_C() {
        if (EQ_FLAG >= 1) {
            text_Area.clear();
        }
        if (TEXT_2 == true) {
            text_Area2.appendText("C");
        } else {
            text_Area.appendText("C");
        }
        EQ_FLAG = 0;

    }

    @FXML
    private void Button_B() {
        if (EQ_FLAG >= 1) {
            text_Area.clear();
        }
        if (TEXT_2 == true) {
            text_Area2.appendText("B");
        } else {
            text_Area.appendText("B");
        }
        EQ_FLAG = 0;

    }

    @FXML
    private void Button_A() {
        if (EQ_FLAG >= 1) {
            text_Area.clear();
        }
        if (TEXT_2 == true) {
            text_Area2.appendText("A");
        } else {
            text_Area.appendText("A");
        }
        EQ_FLAG = 0;
    }

    @FXML
    private void Button_Equal() {

        if (text_Area.getText().contains(" = ")) {

            String s = String.valueOf(ans);
            long decimal = Long.parseLong(s);
            String oct = Long.toOctalString(decimal);//Converting to octal
            label_OCT.setText(oct);
            String hex = Long.toHexString(decimal);  //Convertig to hex
            label_HEX.setText(hex);
            String bin = Long.toBinaryString(decimal);//Converting to binary
            label_BIN.setText(bin);
            String dec = Long.toString(decimal);
            label_DEC.setText(dec);

        } else if (text_Area.getText().length() != 0) {
            try {
                if (BIN_FLAG == true) {
                    String text = text_Area.getText();
                    //  String binaryString="1010";  
                    long decimal = Long.parseLong(text, 2);
                    String oct = Long.toOctalString(decimal);//Converting to octal
                    label_OCT.setText(oct);
                    String hex = Long.toHexString(decimal);  //Convertig to hex
                    label_HEX.setText(hex);
                    String bin = Long.toBinaryString(decimal);//Converting to binary
                    label_BIN.setText(bin);
                    String dec = Long.toString(decimal);
                    label_DEC.setText(dec);

                } else if (HEX_FLAG == true) {
                    String text = text_Area.getText();
                    long decimal = Long.parseLong(text, 16);
                    String oct = Long.toOctalString(decimal);//Converting to octal
                    label_OCT.setText(oct);
                    String hex = Long.toHexString(decimal);  //Convertig to hex
                    label_HEX.setText(hex);
                    String bin = Long.toBinaryString(decimal);//Converting to binary
                    label_BIN.setText(bin);
                    String dec = Long.toString(decimal);
                    label_DEC.setText(dec);
                } else if (OCT_FLAG == true) {
                    String text = text_Area.getText();
                    long decimal = Long.parseLong(text, 8);
                    String oct = Long.toOctalString(decimal);//Converting to octal
                    label_OCT.setText(oct);
                    String hex = Long.toHexString(decimal);  //Convertig to hex
                    label_HEX.setText(hex);
                    String bin = Long.toBinaryString(decimal);//Converting to binary
                    label_BIN.setText(bin);
                    String dec = Long.toString(decimal);
                    label_DEC.setText(dec);
                } else {
                    String text = text_Area.getText();

                    Long num1 = new Long(text);

                    String oct = Long.toOctalString(num1);//Converting to octal
                    label_OCT.setText(oct);
                    String hex = Long.toHexString(num1);  //Convertig to hex
                    label_HEX.setText(hex);
                    String bin = Long.toBinaryString(num1);//Converting to binary
                    label_BIN.setText(bin);
                    label_DEC.setText(text);
                }
            } catch (NumberFormatException e) {
                text_Area.appendText("  Very Long Number (Exceeds 15 ) ");
                System.out.println("Number of Exception occured because it is very long number at textArea1!");
                label_OCT.clear();
                label_HEX.clear();
                label_BIN.clear();
                label_DEC.clear();
            }

        } else {
            label_OCT.setText("0");

            label_HEX.setText("0");

            label_BIN.setText("0");

            label_DEC.setText("0");
        }

    }

    @FXML
    private void Button_Equal1() {
        TEXT_2 = false;

        if (EQ_FLAG == 0) {

            if (XOR_FLAG == true) /**
             * *************** XOR Operation **********************
             */
            {
                String text = text_Area.getText();
                try {
                    long num1;
                    if (BIN_FLAG == true) {
                        num1 = Long.parseLong(text, 2);
                    } else if (HEX_FLAG == true) {
                        num1 = Long.parseLong(text, 16);
                    } else if (OCT_FLAG == true) {
                        num1 = Long.parseLong(text, 8);
                    } else {
                        num1 = Long.parseLong(text);
                    }

                    String text2 = text_Area2.getText();
                    try {
                        long num2 = 0;
                        if (BIN_FLAG == true) {
                            num2 = Long.parseLong(text2, 2);
                        } else if (HEX_FLAG == true) {
                            num2 = Long.parseLong(text2, 16);
                        } else if (OCT_FLAG == true) {
                            num2 = Long.parseLong(text2, 8);
                        } else {
                            num2 = Long.parseLong(text2);
                        }

                        //(2) Result
                        long result = num1 ^ num2;
                        ans = result;

                        String s = "0";

                        if (BIN_FLAG == true) {
                            s = Long.toBinaryString(result);//Converting to binary

                        } else if (HEX_FLAG == true) {
                            s = Long.toHexString(result);  //Convertig to hex
                        } else if (OCT_FLAG == true) {
                            s = Long.toOctalString(result);//Converting to octal
                        } else {
                            s = String.valueOf(result);
                        }
                        operation.setText("   ");

                        progEqn = text + " XOR ( " + text2 + " ) = " + s;
                        if (serverFound) {
                            ps.println(progEqn);
                        }
                        text_Area.setText(s);
                        text_Area2.clear();
                    } catch (NumberFormatException e) {
                        text_Area2.appendText("  Very Long Number ");
                        System.out.println("Number of Exception occured because it is very long number at textArea2!");
                    }

                } catch (NumberFormatException e) {
                    text_Area.appendText("  Very Long Number ");
                    System.out.println("Number of Exception occured because it is very long number  at textArea !");
                }
                EQ_FLAG = 1;
            } else if (OR_FLAG == true) {
                String text = text_Area.getText();
                try {
                    long num1 = 0;
                    if (BIN_FLAG == true) {
                        num1 = Long.parseLong(text, 2);
                    } else if (HEX_FLAG == true) {
                        num1 = Long.parseLong(text, 16);
                    } else if (OCT_FLAG == true) {
                        num1 = Long.parseLong(text, 8);
                    } else {
                        num1 = Long.parseLong(text);
                    }

                    String text2 = text_Area2.getText();
                    try {
                        long num2 = 0;
                        if (BIN_FLAG == true) {
                            num2 = Long.parseLong(text2, 2);
                        } else if (HEX_FLAG == true) {
                            num2 = Long.parseLong(text2, 16);
                        } else if (OCT_FLAG == true) {
                            num2 = Long.parseLong(text2, 8);
                        } else {
                            num2 = Long.parseLong(text2);
                        }

                        long result = num1 | num2;
                        ans = result;

                        String s = "0";
                        if (BIN_FLAG == true) {
                            s = Long.toBinaryString(result);//Converting to binary

                        } else if (HEX_FLAG == true) {
                            s = Long.toHexString(result);  //Convertig to hex
                        } else if (OCT_FLAG == true) {
                            s = Long.toOctalString(result);//Converting to octal
                        } else {
                            s = String.valueOf(result);
                        }
                        operation.setText("  ");

                        progEqn = text + " OR ( " + text2 + " ) = " + s;

                        if (serverFound) {
                            ps.println(progEqn);
                        }
                        text_Area.setText(s);
                        text_Area2.clear();
                    } catch (NumberFormatException e) {
                        text_Area2.appendText("  Very Long Number ");
                        System.out.println("Number of Exception occured because it is very long number at textArea2!");
                    }

                } catch (NumberFormatException e) {
                    text_Area.appendText("  Very Long Number ");
                    System.out.println("Number of Exception occured because it is very long number  at textArea !");
                }
                EQ_FLAG = 1;
            } else if (AND_FLAG == true) {
                String text = text_Area.getText();

                try {
                    long num1 = 0;
                    if (BIN_FLAG == true) {
                        num1 = Long.parseLong(text, 2);
                    } else if (HEX_FLAG == true) {
                        num1 = Long.parseLong(text, 16);
                    } else if (OCT_FLAG == true) {
                        num1 = Long.parseLong(text, 8);
                    } else {
                        num1 = Long.parseLong(text);
                    }

                    String text2 = text_Area2.getText();
                    try {
                        long num2 = 0;
                        if (BIN_FLAG == true) {
                            num2 = Long.parseLong(text2, 2);
                        } else if (HEX_FLAG == true) {
                            num2 = Long.parseLong(text2, 16);
                        } else if (OCT_FLAG == true) {
                            num2 = Long.parseLong(text2, 8);
                        } else {
                            num2 = Long.parseLong(text2);
                        }

                        long result = num1 & num2;
                        ans = result;

                        String s = "0";
                        if (BIN_FLAG == true) {
                            s = Long.toBinaryString(result);//Converting to binary

                        } else if (HEX_FLAG == true) {
                            s = Long.toHexString(result);  //Convertig to hex
                        } else if (OCT_FLAG == true) {
                            s = Long.toOctalString(result);//Converting to octal
                        } else {
                            s = String.valueOf(result);
                        }
                        operation.setText("   ");

                        progEqn = text + " AND ( " + text2 + " ) = " + s;
                        if (serverFound) {
                            ps.println(progEqn);
                        }
                        text_Area.setText(s);
                        text_Area2.clear();
                    } catch (NumberFormatException e) {
                        text_Area2.appendText("  Very Long Number ");
                        System.out.println("Number of Exception occured because it is very long number at textArea2!");
                    }

                } catch (NumberFormatException e) {
                    text_Area.appendText("  Very Long Number ");
                    System.out.println("Number of Exception occured because it is very long number  at textArea !");
                }

                EQ_FLAG = 1;
            }
        } else {
            String s_ans;
            operation.setText("");
            text_Area2.clear();
            if (BIN_FLAG == true) {
                s_ans = Long.toBinaryString(ans);//Converting to binary

            } else if (HEX_FLAG == true) {
                s_ans = Long.toHexString(ans);  //Convertig to hex
            } else if (OCT_FLAG == true) {
                s_ans = Long.toOctalString(ans);//Converting to octal
            } else {
                s_ans = String.valueOf(ans);
            }
            text_Area.setText(s_ans);
        }
        History_TA1.appendText(progEqn + "\n");
    }

    @FXML
    private void ProgrammerButton() {
        x = 0;
        y = 0;
        Scientific_Flag = false;
        Length_Flag = false;
        Graph_Flag = false;
        DateCalc_Flag = false;
        Temperature_Flag = false;
        Programmer_Flag = true;
        TA.clear();
        TA1.clear();
        TA2.clear();
        TA11.clear();
        TA21.clear();
        plotEqn.clear();
        startTF.clear();
        endTF.clear();
        lineChart.getData().clear();
        resultLabel.setText("");
        EndDateCheckBox.setSelected(false);
        this.DateCalcPane.setVisible(false);
        this.TemperaturePane.setVisible(false);
        this.ScientificPane.setVisible(false);
        this.LengthPane.setVisible(false);
        this.GarphingPane.setVisible(false);
        this.ConfigurationPane.setVisible(false);
        this.ProgrammerPane.setVisible(true);
        MenuVisibility();

        StartDay.getSelectionModel().select(0);
        StartMonth.getSelectionModel().select(0);
        StartYear.getSelectionModel().select(0);
        EndDay.getSelectionModel().select(0);
        EndMonth.getSelectionModel().select(0);
        EndYear.getSelectionModel().select(0);
        ToggleEndDate();

    }

    @FXML
    private void GraphingNowBtn() {
        String tmp = TA.getText();
        GraphingButton();
        if (FactFlag) {
            factorial = Integer.parseInt(TA_Value);
            TA.clear();
            int i;
            Integer sum = 1;
            for (i = 1; i <= factorial; i++) {
                sum = sum * i;
            }

            tmp = tmp.replace("fact(" + TA_Value + ")", sum.toString());
        }
        FactFlag = false;
        plotEqn.setText(tmp);

    }

}
