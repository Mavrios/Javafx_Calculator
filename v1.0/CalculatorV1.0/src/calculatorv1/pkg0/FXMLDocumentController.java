/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package calculatorv1.pkg0;

import java.awt.event.KeyEvent;
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

    public Button button1;
    ObservableList list = FXCollections.observableArrayList();
    @FXML
    private TextArea TA;
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
    String TA_Value = "";
    String factVal = "";
    @FXML
    private VBox Vbox;
    boolean Vbox_Flag = false;
    boolean Menu_Flag = false;
    ScriptEngineManager EqnManager;
    ScriptEngine engine;
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
    private Button GraphingBtn;
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
        if (sqrFlag || trioFlag) {
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

        if (sqrFlag || trioFlag) {
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
        if (sqrFlag || trioFlag) {
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
        if (sqrFlag || trioFlag) {
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
        if (sqrFlag || trioFlag) {
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
        if (sqrFlag || trioFlag) {
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
        if (sqrFlag || trioFlag) {
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
        if (sqrFlag || trioFlag) {
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
        if (sqrFlag || trioFlag) {
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
        if (sqrFlag || trioFlag) {
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
        TA.appendText("π");
    }

    @FXML
    private void btnE() {
        if (R_flag == true) {
            TA.clear();
        }
        MenuVisibility();
        flag = true;
        R_flag = false;
        TA.appendText("ë");
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
            TA.appendText("sec-1(");
        } else if (!scnd_flag && hypFlag) {
            TA.appendText("sech(");
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
        } else if (!scnd_flag && hypFlag) {
            TA.appendText("csch(");
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
        } else if (!scnd_flag && hypFlag) {
            TA.appendText("coth(");
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
        tmp = tmp.
                replace("ë", "Math.E").
                replace("sqrt", "Math.sqrt").
                replace("cbrt", "java.lang.Math.cbrt").
                replace("pow", "Math.pow").
                replace("log", "java.lang.Math.log10").
                replace("java.lang.Math.log10yX", "java.lang.Math.log10(" + Y + ")/java.lang.Math.log10(" + X + ")").
                replace("ln", "Math.log").
                replace("π", "Math.PI").
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
                replace("sech(", "1/Math.sinh( (Math.PI/180)*").
                replace("csch(", "1/Math.cosh( (Math.PI/180)*").
                replace("coth(", "1/Math.tanh( (Math.PI/180)*").
                replace("sinh(", "Math.sinh( (Math.PI/180)*").
                replace("cosh(", "Math.cosh( (Math.PI/180)*").
                replace("tanh(", "Math.tanh( (Math.PI/180)*").
                replace("sin-1(", "(180/Math.PI)*Math.asin(").
                replace("cos-1(", "(180/Math.PI)*Math.acos(").
                replace("tan-1(", "(180/Math.PI)*Math.atan(").
                replace("sec", "1/cos").
                replace("csc", "1/sin").
                replace("cot", "1/tan").
                replace("sin(", "Math.sin( (Math.PI/180)*").
                replace("cos(", "Math.cos( (Math.PI/180)*").
                replace("tan(", "Math.tan( (Math.PI/180)*").
                replace("cot", "1/tan").
                replace("sqr(", ('(' + TA_Value + '*'));
        return tmp;
    }

    @FXML
    private void handleButtonActionEqu() {

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

                factorial = Integer.parseInt(TA.getText(TA.getLength() - 2, TA.getLength() - 1));
                TA.clear();
                int i;
                Integer sum = 1;
                for (i = 1; i <= factorial; i++) {
                    sum = sum * i;
                }
                TA.appendText(sum.toString());
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
                    TA.setText(String.format("%.8f", trial));
                }
            } catch (ScriptException e) {
                TA.setText("Undefined!!");
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        MenuVisibility();
        loaddata();
        this.ScientificPane.setVisible(true);
        this.LengthPane.setVisible(false);
        this.DateCalcPane.setVisible(false);
        this.GarphingPane.setVisible(false);
        this.ConfigurationPane.setVisible(false);
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
    private void handleButton(javafx.scene.input.KeyEvent event) {
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

            }

        } else {
            if (event.getCode() == KeyCode.BACK_SPACE) {
                if (!TA.getText().isEmpty()) {
                    TA.deleteText(TA.getLength() - 1, TA.getLength());
                }
            }
            if (event.getCode() == KeyCode.UP) {
                y++;
                if (y > 7) {
                    y = 7;
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
                if (x > 4) {
                    x = 4;
                }
                if (y == 7) {
                    x = 3;
                }
                ResetButtonIDs();
                ArrowIndexHandle();
                System.out.println(x);
            }
        }
        if (event.getCode() == KeyCode.ENTER) {
            System.out.println("SA");
            EnterIndexHandle();
        }

    }

    private void EnterIndexHandle() {
        switch (x) {
            case 0:
                switch (y) {
                    case 0:
                        btnLn();
                        break;

                    case 1:
                        btnLog();
                        break;

                    case 2:
                        btnTenpowX();
                        break;

                    case 3:
                        btnXpowY();
                        break;

                    case 4:
                        btnSqrt();
                        break;

                    case 5:
                        if (Vbox_Flag) {
                            btnHyp();
                        } else {
                            btnSqr();
                        }
                        break;

                    case 6:
                        if (Vbox_Flag) {
                            btnTrioScnd();
                        } else {
                            scndbtn();
                        }
                        break;

                    case 7:
                        Trigonometry();
                        break;

                }
                break;

            case 1:
                switch (y) {
                    case 0:
                        btnToggleSign();
                        break;

                    case 1:
                        handleButtonAction1();
                        break;

                    case 2:
                        handleButtonAction4();
                        break;

                    case 3:
                        handleButtonAction7();
                        break;

                    case 4:
                        btnRightBrace();
                        break;

                    case 5:
                        if (Vbox_Flag) {
                            btnSec();
                        } else {
                            btnInv();
                        }

                        break;

                    case 6:
                        if (Vbox_Flag) {
                            btnSin();
                        } else if (Function_Flag) {
                            btnAbs();
                        } else {
                            btnPI();
                        }
                        break;

                    case 7:
                        Trigonometry();
                        break;
                }
                break;

            case 2:
                switch (y) {
                    case 0:
                        handleButtonAction0();
                        break;

                    case 1:
                        handleButtonAction2();
                        break;

                    case 2:
                        handleButtonAction5();
                        break;

                    case 3:
                        handleButtonAction8();
                        break;

                    case 4:
                        btnLeftBrace();
                        break;

                    case 5:
                        if (Vbox_Flag) {
                            btnCsc();
                        } else {
                            btnAbs();
                        }
                        break;

                    case 6:
                        if (Vbox_Flag) {
                            btnCos();
                        } else if (Function_Flag) {
                            btnFloor();
                        } else {
                            btnE();
                        }

                        break;

                    case 7:
                        Trigonometry();
                        break;
                }

                break;

            case 3:
                switch (y) {
                    case 0:
                        handleButtonActionDot();
                        break;

                    case 1:
                        handleButtonAction3();
                        break;

                    case 2:
                        handleButtonAction6();
                        break;

                    case 3:
                        handleButtonAction9();
                        break;

                    case 4:
                        btnFact();
                        break;

                    case 5:
                        if (Vbox_Flag) {
                            btnCot();
                        } else {
                            btnExp();
                        }
                        break;

                    case 6:
                        if (Vbox_Flag) {
                            btnTan();
                        } else if (Function_Flag) {
                            btnCeil();
                        } else {
                            handleButtonActionC();
                        }
                        break;

                    case 7:
                        FunctionBtn();
                        break;
                }
                break;

            case 4:
                switch (y) {
                    case 0:
                        handleButtonActionEqu();
                        break;

                    case 1:
                        handleButtonActionP();
                        break;

                    case 2:
                        handleButtonActionN();
                        break;

                    case 3:
                        handleButtonActionM();
                        break;

                    case 4:
                        handleButtonActionD();
                        break;

                    case 5:
                        btnMod();
                        break;

                    case 6:
                        if (Function_Flag) {
                            btnRand();
                        } else {
                            btnBksp();
                        }
                        break;

                    case 7:
                        FunctionBtn();
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
                        buttonLn.setId("selected-button");
                        break;

                    case 1:
                        buttonLog.setId("selected-button");
                        break;

                    case 2:
                        button10PowerX.setId("selected-button");
                        break;

                    case 3:
                        buttonXpY.setId("selected-button");
                        break;

                    case 4:
                        buttonSqrt.setId("selected-button");
                        break;

                    case 5:
                        if (Vbox_Flag) {
                            buttonHyp.setId("selected-button");
                        } else {
                            buttonPower2.setId("selected-button");
                        }
                        break;

                    case 6:
                        if (Vbox_Flag) {
                            buttonTrio2nd.setId("selected-button");
                        } else if (Function_Flag) {
                            x = 1;
                            AbsButton.setId("selected-button");
                        } else {
                            button2nd.setId("selected-button");
                        }
                        break;

                    case 7:
                        TogButton.setId("selected-button");
                        break;

                }
                break;

            case 1:
                switch (y) {
                    case 0:
                        buttonPM.setId("selected-button");
                        break;

                    case 1:
                        button1.setId("selected-button");
                        break;

                    case 2:
                        button4.setId("selected-button");
                        break;

                    case 3:
                        button7.setId("selected-button");
                        break;

                    case 4:
                        buttonOBraces.setId("selected-button");
                        break;

                    case 5:
                        if (Vbox_Flag) {
                            buttonSec.setId("selected-button");
                        } else {
                            buttonDivX.setId("selected-button");
                        }
                        break;

                    case 6:
                        if (Vbox_Flag) {
                            buttonSin.setId("selected-button");
                        } else if (Function_Flag) {
                            AbsButton.setId("selected-button");
                        } else {
                            buttonPI.setId("selected-button");
                        }
                        break;

                    case 7:
                        TogButton.setId("selected-button");
                        break;
                }
                break;

            case 2:
                switch (y) {
                    case 0:
                        button0.setId("selected-button");
                        break;

                    case 1:
                        button2.setId("selected-button");
                        break;

                    case 2:
                        button5.setId("selected-button");
                        break;

                    case 3:
                        button8.setId("selected-button");
                        break;

                    case 4:
                        buttonCBraces.setId("selected-button");
                        break;

                    case 5:
                        if (Vbox_Flag) {
                            buttonCsc.setId("selected-button");
                        } else {
                            buttonAbs.setId("selected-button");
                        }
                        break;

                    case 6:
                        if (Vbox_Flag) {
                            buttonCos.setId("selected-button");
                        } else if (Function_Flag) {
                            FloorButton.setId("selected-button");
                        } else {
                            buttonEuler.setId("selected-button");
                        }
                        break;

                    case 7:
                        TogButton.setId("selected-button");
                        break;
                }

                break;

            case 3:
                switch (y) {
                    case 0:
                        buttonDot.setId("selected-button");
                        break;

                    case 1:
                        button3.setId("selected-button");
                        break;

                    case 2:
                        button6.setId("selected-button");
                        break;

                    case 3:
                        button9.setId("selected-button");
                        break;

                    case 4:
                        buttonFact.setId("selected-button");
                        break;

                    case 5:
                        if (Vbox_Flag) {
                            buttonCot.setId("selected-button");
                        } else {
                            buttonExp.setId("selected-button");
                        }
                        break;

                    case 6:
                        if (Vbox_Flag) {
                            buttonTan.setId("selected-button");
                        } else if (Function_Flag) {
                            CeilButton.setId("selected-button");
                        } else {
                            buttonC.setId("selected-button");
                        }
                        break;

                    case 7:
                        TogButton1.setId("selected-button");
                        break;
                }
                break;

            case 4:
                switch (y) {
                    case 0:
                        equals.setId("selected-button");
                        break;

                    case 1:
                        buttonPlus.setId("selected-button");
                        break;

                    case 2:
                        buttonMin.setId("selected-button");
                        break;

                    case 3:
                        buttonMulti.setId("selected-button");
                        break;

                    case 4:
                        buttonDiv.setId("selected-button");
                        break;

                    case 5:
                        buttonMod.setId("selected-button");
                        break;

                    case 6:
                        if (Function_Flag) {
                            RandButton.setId("selected-button");
                        } else {
                            buttonBks.setId("selected-button");

                        }
                        break;

                    case 7:
                        TogButton1.setId("selected-button");
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
        Vbox_Flag = false;
        Function_Flag = false;
        Menu_Flag = !Menu_Flag;
        MenuBox.setVisible(Menu_Flag);
        MenuBox1.setVisible(Menu_Flag);
        MenuBox2.setVisible(Menu_Flag);
        GraphingMenuBox.setVisible(Menu_Flag);
        ConfigurationMenu.setVisible(Menu_Flag);
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
        Menu_Flag = false;
        Vbox_Flag = false;
        Function_Flag = false;
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
            buttonPower2.setText("x³");
            buttonSqrt.setText("³√x");
            buttonXpY.setText("ʸ√x");
            button10PowerX.setText("2ˣ");
            buttonLog.setText("logᵧ x");
            buttonLn.setText("eˣ");
        } else {
            button2nd.setId("");
            buttonPower2.setText("x²");
            buttonSqrt.setText("²√x");
            buttonXpY.setText("xʸ");
            button10PowerX.setText("10ˣ");
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
        TA1.clear();
        TA2.clear();
        plotEqn.clear();
        startTF.clear();
        endTF.clear();
        lineChart.getData().clear();
        resultLabel.setText("");
        EndDateCheckBox.setSelected(false);
        this.DateCalcPane.setVisible(false);
        this.ScientificPane.setVisible(true);
        this.LengthPane.setVisible(false);
        this.GarphingPane.setVisible(false);
        this.ConfigurationPane.setVisible(false);
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
        TA.clear();
        resultLabel.setText("");
        lineChart.getData().clear();
        plotEqn.clear();
        startTF.clear();
        endTF.clear();
        EndDateCheckBox.setSelected(false);
        this.GarphingPane.setVisible(false);
        this.DateCalcPane.setVisible(false);
        this.ScientificPane.setVisible(false);
        this.LengthPane.setVisible(true);
        this.ConfigurationPane.setVisible(false);
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
        if (event.getSource() == one) {
            TA1.appendText("1");
        } else if (event.getSource() == two) {
            TA1.appendText("2");
        } else if (event.getSource() == three) {
            TA1.appendText("3");
        } else if (event.getSource() == four) {
            TA1.appendText("4");
        } else if (event.getSource() == five) {
            TA1.appendText("5");
        } else if (event.getSource() == six) {
            TA1.appendText("6");
        } else if (event.getSource() == seven) {
            TA1.appendText("7");
        } else if (event.getSource() == eight) {
            TA1.appendText("8");
        } else if (event.getSource() == nine) {
            TA1.appendText("9");
        } else if (event.getSource() == zero) {
            TA1.appendText("0");
        } else if (event.getSource() == clear) {
            TA1.clear();
        } else if (event.getSource() == dot) {
            TA1.appendText(".");
        }
        Converter();
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
    private void DateCalulationBtn(ActionEvent event) {
        TA.clear();
        TA1.clear();
        TA2.clear();
        lineChart.getData().clear();
        resultLabel.setText("");
        this.ScientificPane.setVisible(false);
        this.LengthPane.setVisible(false);
        this.GarphingPane.setVisible(false);
        this.ConfigurationPane.setVisible(false);
        this.DateCalcPane.setVisible(true);
        MenuVisibility();
    }

    @FXML
    private void EndDateCheckBox(MouseEvent event) {
        ToggleEndDate();
    }

    @FXML
    private void calculateButton(MouseEvent event) {
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
    private void Plot(ActionEvent event) {
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

            System.out.println(Xaxis + " " + Graphing_Y);
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
    private void GraphingButton(ActionEvent event) {
        TA.clear();
        TA1.clear();
        TA2.clear();
        resultLabel.setText("");
        this.ScientificPane.setVisible(false);
        this.LengthPane.setVisible(false);
        this.GarphingPane.setVisible(true);
        this.DateCalcPane.setVisible(false);
        this.ConfigurationPane.setVisible(false);
        MenuVisibility();
    }

    @FXML
    private void ConfigurationButton(ActionEvent event) {
        TA.clear();
        TA1.clear();
        TA2.clear();
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
        this.ConfigurationPane.setVisible(true);
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
                                //TextField.appendText(st);                                     //TODO LATER
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

}
