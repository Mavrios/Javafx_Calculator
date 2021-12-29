/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package calculatorv1.pkg0;


import java.awt.event.KeyEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;

/**
 *
 * @author Kishk
 */
public class FXMLDocumentController implements Initializable {

    public Button button1;
    ObservableList list = FXCollections.observableArrayList();
    @FXML
    private TextArea TA;
    Integer factorial;
    boolean scnd_flag = false;
    boolean flag = true;
    boolean I_flag = true;
    boolean R_flag = false;
    boolean toggleSign = false;
    boolean powFlag = false;
    boolean sqrFlag = false;
    boolean FactFlag = false;
    boolean Function_Flag = false;
    String xpow2Val = "";
    String factVal = "";
    @FXML
    private VBox Vbox;
    boolean Vbox_Flag = false;
    boolean Menu_Flag = false;
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
    private ComboBox<?> box2;
    @FXML
    private ComboBox<?> box1;
    @FXML
    private VBox MenuBox1;
    @FXML
    private AnchorPane LengthPane;
    
    @FXML
    private void btnRightBrace(ActionEvent event) {
        if (R_flag == true) {
            TA.clear();
        }

        flag = true;
        R_flag = false;
        TA.appendText("(");
        powFlag = true;
    }

    @FXML
    private void btnLeftBrace(ActionEvent event) {
        if (R_flag == true) {
            TA.clear();
        }
        MenuVisibility();
        flag = true;
        R_flag = false;
        TA.appendText(")");
        sqrFlag = false;
        powFlag = false;
    }

    @FXML
    private void handleButtonAction1(ActionEvent event) {
        if (R_flag == true) {
            TA.clear();
        }
        MenuVisibility();
        flag = true;
        R_flag = false;
        TA.appendText("1");
        if (sqrFlag) {
            xpow2Val = xpow2Val + '1';

        }

        if (powFlag == true) {
            TA.appendText(", ");
            powFlag = false;
        }
    }

    @FXML
    private void handleButtonAction2(ActionEvent event) {
        if (R_flag == true) {
            TA.clear();
        }
        MenuVisibility();
        flag = true;
        R_flag = false;
        TA.appendText("2");
        if (sqrFlag) {
            xpow2Val = xpow2Val + '2';

        }
        if (powFlag == true) {
            TA.appendText(", ");
            powFlag = false;
        }
    }

    @FXML
    private void handleButtonAction3(ActionEvent event) {
        if (R_flag == true) {
            TA.clear();
        }
        MenuVisibility();
        flag = true;
        R_flag = false;
        if (sqrFlag) {
            xpow2Val = xpow2Val + '3';

        }
        TA.appendText("3");
        if (powFlag == true) {
            TA.appendText(", ");
            powFlag = false;
        }
    }

    @FXML
    private void handleButtonAction4(ActionEvent event) {
        if (R_flag == true) {
            TA.clear();
        }
        if (sqrFlag) {
            xpow2Val = xpow2Val + '4';

        }
        MenuVisibility();
        flag = true;
        R_flag = false;
        TA.appendText("4");
        if (powFlag == true) {
            TA.appendText(", ");
            powFlag = false;
        }
    }

    @FXML
    private void handleButtonAction5(ActionEvent event) {
        if (R_flag == true) {
            TA.clear();
        }
        if (sqrFlag) {
            xpow2Val = xpow2Val + '5';

        }
        MenuVisibility();
        flag = true;
        R_flag = false;
        TA.appendText("5");
        if (powFlag == true) {
            TA.appendText(", ");
            powFlag = false;
        }
    }

    @FXML
    private void handleButtonAction6(ActionEvent event) {
        if (R_flag == true) {
            TA.clear();
        }
        if (sqrFlag) {
            xpow2Val = xpow2Val + '6';

        }
        MenuVisibility();
        flag = true;
        R_flag = false;
        TA.appendText("6");
        if (powFlag == true) {
            TA.appendText(", ");
            powFlag = false;
        }
    }

    @FXML
    private void handleButtonAction7(ActionEvent event) {
        if (R_flag == true) {
            TA.clear();
        }
        if (sqrFlag) {
            xpow2Val = xpow2Val + '7';

        }
        MenuVisibility();
        flag = true;
        R_flag = false;
        TA.appendText("7");
        if (powFlag == true) {
            TA.appendText(", ");
            powFlag = false;
        }
    }

    @FXML
    private void handleButtonAction8(ActionEvent event) {
        if (R_flag == true) {
            TA.clear();
        }
        if (sqrFlag) {
            xpow2Val = xpow2Val + '8';

        }
        MenuVisibility();
        flag = true;
        R_flag = false;
        TA.appendText("8");
        if (powFlag == true) {
            TA.appendText(", ");
            powFlag = false;
        }
    }

    @FXML
    private void handleButtonAction9(ActionEvent event) {
        if (R_flag == true) {
            TA.clear();
        }
        if (sqrFlag) {
            xpow2Val = xpow2Val + '9';

        }
        MenuVisibility();
        flag = true;
        R_flag = false;
        TA.appendText("9");
        if (powFlag == true) {
            TA.appendText(", ");
            powFlag = false;
        }
    }

    @FXML
    private void handleButtonAction0(ActionEvent event) {
        if (R_flag == true) {
            TA.clear();
        }
        if (sqrFlag) {
            xpow2Val = xpow2Val + '0';

        }
        MenuVisibility();
        flag = true;
        R_flag = false;
        TA.appendText("0");
        if (powFlag == true) {
            TA.appendText(", ");
            powFlag = false;
        }
    }
//----------------------------------------

    @FXML
    private void btnMod(ActionEvent event) {
        if (R_flag == true) {
            TA.clear();
        }
        MenuVisibility();
        flag = true;
        R_flag = false;
        TA.appendText("%");

    }

    @FXML
    private void btnPI(ActionEvent event) {
        if (R_flag == true) {
            TA.clear();
        }
        MenuVisibility();
        flag = true;
        R_flag = false;
        TA.appendText("π");
    }

    @FXML
    private void btnE(ActionEvent event) {
        if (R_flag == true) {
            TA.clear();
        }
        MenuVisibility();
        flag = true;
        R_flag = false;
        TA.appendText("e");
    }

    @FXML
    private void btnExp(ActionEvent event) {
        if (R_flag == true) {
            TA.clear();
        }
        MenuVisibility();
        flag = true;
        R_flag = false;
        TA.appendText("exp(");
    }

    @FXML
    private void btnInv(ActionEvent event) {
        if (R_flag == true) {
            TA.clear();
        }
        MenuVisibility();
        flag = true;
        R_flag = false;
        TA.appendText("1/(");
    }

    @FXML
    private void btnToggleSign(ActionEvent event) {
        if (!TA.getText().equals('0')) {
            toggleSign = true;
        }
        MenuVisibility();
    }

    @FXML
    private void btnXpowY(ActionEvent event) {
        if (R_flag == true) {
            TA.clear();
        }
        MenuVisibility();
        flag = true;
        R_flag = false;
        TA.appendText("pow(");
        powFlag = true;
    }

    @FXML
    private void btnTenpowX(ActionEvent event) {
        if (R_flag == true) {
            TA.clear();
        }
        MenuVisibility();
        flag = true;
        R_flag = false;
        TA.appendText("10^(");
    }

    @FXML
    private void btnLog(ActionEvent event) {
        if (R_flag == true) {
            TA.clear();
        }
        MenuVisibility();
        flag = true;
        R_flag = false;
        TA.appendText("log(");
    }

    @FXML
    private void btnLn(ActionEvent event) {
        if (R_flag == true) {
            TA.clear();
        }
        MenuVisibility();
        flag = true;
        R_flag = false;
        TA.appendText("ln(");
    }

    @FXML
    private void btnSqr(ActionEvent event) {
        if (R_flag == true) {
            TA.clear();
        }
        MenuVisibility();
        flag = true;
        R_flag = false;

        TA.appendText("sqr(");
        sqrFlag = true;
    }

    @FXML
    private void btnSqrt(ActionEvent event) {
        if (R_flag == true) {
            TA.clear();
        }
        MenuVisibility();
        flag = true;
        R_flag = false;
        TA.appendText("sqrt(");
    }

    @FXML
    private void btnAbs(ActionEvent event) {
        if (R_flag == true) {
            TA.clear();
        }
        MenuVisibility();
        flag = true;
        R_flag = false;
        TA.appendText("abs(");
    }

    @FXML
    private void btnFact(ActionEvent event) {
        if (R_flag == true) {
            TA.clear();
        }
        MenuVisibility();
        FactFlag = true;
        flag = true;
        R_flag = false;
        TA.appendText("fact(");

    }
//-----------------------------------------

    @FXML
    private void handleButtonActionP(ActionEvent event) {
        if (flag == false) {
            TA.deleteText(TA.getLength() - 1, TA.getLength());
        }
        MenuVisibility();
        R_flag = false;
        flag = false;
        TA.appendText("+");
    }

    @FXML
    private void handleButtonActionN(ActionEvent event) {
        if (flag == false) {
            TA.deleteText(TA.getLength() - 1, TA.getLength());
        }
        MenuVisibility();
        R_flag = false;
        flag = false;
        TA.appendText("-");
    }

    @FXML
    private void handleButtonActionM(ActionEvent event) {
        if (flag == false) {
            TA.deleteText(TA.getLength() - 1, TA.getLength());
        }
        MenuVisibility();
        R_flag = false;
        flag = false;
        TA.appendText("*");
    }

    @FXML
    private void handleButtonActionD(ActionEvent event) {
        if (flag == false) {
            TA.deleteText(TA.getLength() - 1, TA.getLength());
        }
        MenuVisibility();
        R_flag = false;
        flag = false;
        TA.appendText("/");
    }

    @FXML
    private void handleButtonActionDot(ActionEvent event) {
        TA.appendText(".");
        MenuVisibility();
        R_flag = false;
        flag = true;
    }

    @FXML
    private void handleButtonActionC(ActionEvent event) {
        flag = true;
        R_flag = false;
        MenuVisibility();
        TA.clear();
    }

    @FXML
    private void handleButtonActionEqu(ActionEvent event) {
        flag = true;
        MenuVisibility();
        R_flag = true;
        powFlag = false;
        String tmp;
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
        tmp = TA.getText();

        tmp = tmp.replace("sin", "Math.sin").
                replace("cos", "Math.cos").
                replace("tan", "Math.tan").
                replace("sqrt", "Math.sqrt").
                replace("pow", "Math.pow").
                replace("log", "Math.log10").
                replace("ln", "Math.log").
                replace("π", "Math.PI").
                replace("e", "Math.E").
                replace("Math.Exp", "Math.exp").
                replace("abs", "Math.abs").
                replace("10^(", "Math.pow(10,").
                replace("sqr(", ('(' + xpow2Val + '*'));
        xpow2Val = "";
        System.out.println(tmp);

        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("JavaScript");
        try {
            if (!TA.getText().isEmpty()) {
                TA.setText(engine.eval(tmp).toString());
            }
        } catch (ScriptException e) {
            TA.setText("Undefined!!");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        MenuVisibility();
        loaddata();
        this.ScientificPane.setVisible(true);
        this.LengthPane.setVisible(false);

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
        }
    }


    @FXML
    private void Trigonometry(ActionEvent event) {
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
    private void MenuHandling(ActionEvent event) {
        Vbox.setVisible(false);
        MenuBox.setVisible(false);
        FunctionsMenu.setVisible(false);
        Vbox_Flag = false;
        Function_Flag = false;
        Menu_Flag = !Menu_Flag;
        MenuBox.setVisible(Menu_Flag);
        MenuBox1.setVisible(Menu_Flag);
    }

    @FXML
    private void FunctionBtn(ActionEvent event) {
        Vbox.setVisible(false);
        MenuBox.setVisible(false);
        FunctionsMenu.setVisible(false);
        Menu_Flag = false;
        Vbox_Flag = false;
        Function_Flag = !Function_Flag;
        FunctionsMenu.setVisible(Function_Flag);
    }

    private void MenuVisibility(){
        Vbox.setVisible(false);
        MenuBox.setVisible(false);
        MenuBox1.setVisible(false);
        FunctionsMenu.setVisible(false);
        Menu_Flag = false;
        Vbox_Flag = false;
        Function_Flag = false;
    }

    @FXML
    private void btnBksp(ActionEvent event) {
        if (!TA.getText().isEmpty()) {
            TA.deleteText(TA.getLength() - 1, TA.getLength());
        }

    }

    @FXML
    private void scndbtn(ActionEvent event) {
        scnd_flag = !scnd_flag;
        if(scnd_flag == true){
            button2nd.setId("selected-button");
            buttonPower2.setText("x³");
            buttonSqrt.setText("³√x");
            buttonXpY.setText("ʸ√x");
            button10PowerX.setText("2ˣ");
            buttonLog.setText("logᵧ x");
            buttonLn.setText("eˣ");
        }
        else{
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
    private void ScientificButton(ActionEvent event) {
        TA.clear();
        TA1.clear();
        TA2.clear();
        this.ScientificPane.setVisible(true);
        this.LengthPane.setVisible(false);
        MenuVisibility();

    }

    @FXML
    private void LengthButton(ActionEvent event) {
        TA.clear();
        TA1.clear();
        TA2.clear();
        this.ScientificPane.setVisible(false);
        this.LengthPane.setVisible(true);
        MenuVisibility();
    }
    
    
    
    
    
    /************************************************FADY PART****************************************************/
    
    
    /*Fady Part*/
    @FXML
    private void handleButtonAction(ActionEvent event) {
        if(event.getSource()== one)
        {
            TA1.appendText("1");
        }
        else if(event.getSource()== two)
        {
            TA1.appendText("2");
        }
        else if(event.getSource()== three)
        {
            TA1.appendText("3");
        }
        else if(event.getSource()== four)
        {
            TA1.appendText("4");
        }
        else if(event.getSource()== five)
        {
            TA1.appendText("5");
        }
        else if(event.getSource()== six)
        {
            TA1.appendText("6");
        }
        else if(event.getSource()== seven)
        {
            TA1.appendText("7");
        }
        else if(event.getSource()== eight)
        {
            TA1.appendText("8");
        }
        else if(event.getSource()== nine)
        {
            TA1.appendText("9");
        }
        else if(event.getSource()== zero)
        {
            TA1.appendText("0");
        }
        else if(event.getSource()== clear)
        {
            TA1.clear();
        }
        else if(event.getSource()== dot)
        {
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
        if(box1.getValue()=="Millimeters")
        {
            if(box2.getValue()=="Millimeters")  //MilliMeters
            {
                TA2.setText(TA1.getText());
            }
            else if(box2.getValue()=="CentiMeters") //Centimeter
            {
                if(!TA1.getText().isEmpty())
                {
                    data = Double.parseDouble(TA1.getText());
                    res = data/10.0;
                    TA2.setText(Double.toString(res));
                }
                else
                {
                    TA2.clear();
                }
            }
            else if(box2.getValue()=="Meters") //Meter
            {
                if(!TA1.getText().isEmpty())
                {
                    data = Double.parseDouble(TA1.getText());
                    res = data/1000.0;
                    TA2.setText(Double.toString(res));
                }
                else
                {
                    TA2.clear();
                }
            }
            
            else if(box2.getValue()=="KiloMeters") //KiloMeters
            {
                if(!TA1.getText().isEmpty())
                {
                    data = Double.parseDouble(TA1.getText());
                    res = data/1000000;
                    TA2.setText(Double.toString(res));
                }
                else
                {
                    TA2.clear();
                }
            }
            
            else if(box2.getValue()=="Inches") //Inches
            {
                if(!TA1.getText().isEmpty())
                {
                    data = Double.parseDouble(TA1.getText());
                    res = data/25.4;
                    TA2.setText(String.format("%.4f", res));
                }
                else
                {
                    TA2.clear();
                }
            }
            
            else if(box2.getValue()=="Feets") //feets
            {
                if(!TA1.getText().isEmpty())
                {
                    data = Double.parseDouble(TA1.getText());
                    res = data/304.8;
                    TA2.setText(String.format("%.4f", res));
                }
                else
                {
                    TA2.clear();
                }
            }
            
            else if(box2.getValue()=="Miles") //Miles
            {
                if(!TA1.getText().isEmpty())
                {
                    data = Double.parseDouble(TA1.getText());
                    res = data/1000000;
                    res = res/1.609;
                    TA2.setText(String.format("%.4f", res));
                }
                else
                {
                    TA2.clear();
                }
            }
        }
        
        /*-------------Centimeters------------*/
        else if(box1.getValue()=="CentiMeters")
        {
            if(box2.getValue()=="Millimeters")  //MilliMeters
            {
                if(!TA1.getText().isEmpty())
                {
                    data = Double.parseDouble(TA1.getText());
                    res = data*10;
                    TA2.setText(Double.toString(res));
                }
                else
                {
                    TA2.clear();
                }
            }
            else if(box2.getValue()=="CentiMeters") //Centimeter
            {
                TA2.setText(TA1.getText());
            }
            else if(box2.getValue()=="Meters") //Meter
            {
                if(!TA1.getText().isEmpty())
                {
                    data = Double.parseDouble(TA1.getText());
                    res = data/100;
                    TA2.setText(Double.toString(res));
                }
                else
                {
                    TA2.clear();
                }
            }
            
            else if(box2.getValue()=="KiloMeters") //KiloMeters
            {
                if(!TA1.getText().isEmpty())
                {
                    data = Double.parseDouble(TA1.getText());
                    res = data/100000;
                    TA2.setText(Double.toString(res));
                }
                else
                {
                    TA2.clear();
                }
            }
            
            else if(box2.getValue()=="Inches") //Inches
            {
                if(!TA1.getText().isEmpty())
                {
                    data = Double.parseDouble(TA1.getText());
                    res = data/2.54;
                    TA2.setText(String.format("%.4f", res));
                }
                else
                {
                    TA2.clear();
                }
            }
            
            else if(box2.getValue()=="Feets") //feets
            {
                if(!TA1.getText().isEmpty())
                {
                    data = Double.parseDouble(TA1.getText());
                    res = data/30.48;
                    TA2.setText(String.format("%.4f", res));
                }
                else
                {
                    TA2.clear();
                }
            }
            
            else if(box2.getValue()=="Miles") //Miles
            {
                if(!TA1.getText().isEmpty())
                {
                    data = Double.parseDouble(TA1.getText());
                    res = data/100000;
                    res = res/1.609;
                    TA2.setText(String.format("%.4f", res));
                }
                else
                {
                    TA2.clear();
                }
            }
        }
        
        /*--------------------Meters----------------------*/
        else if(box1.getValue()=="Meters")
        {
            if(box2.getValue()=="Millimeters")  //MilliMeters
            {
                if(!TA1.getText().isEmpty())
                {
                    data = Double.parseDouble(TA1.getText());
                    res = data*1000;
                    TA2.setText(Double.toString(res));
                }
                else
                {
                    TA2.clear();
                }
            }
            else if(box2.getValue()=="CentiMeters") //Centimeter
            {
                if(!TA1.getText().isEmpty())
                {
                    data = Double.parseDouble(TA1.getText());
                    res = data*100;
                    TA2.setText(Double.toString(res));
                }
                else
                {
                    TA2.clear();
                }
            }
            else if(box2.getValue()=="Meters") //Meter
            {
                if(!TA1.getText().isEmpty())
                {
                    data = Double.parseDouble(TA1.getText());
                    res = data;
                    TA2.setText(Double.toString(res));
                }
                else
                {
                    TA2.clear();
                }
            }
            
            else if(box2.getValue()=="KiloMeters") //KiloMeters
            {
                if(!TA1.getText().isEmpty())
                {
                    data = Double.parseDouble(TA1.getText());
                    res = data/1000;
                    TA2.setText(Double.toString(res));
                }
                else
                {
                    TA2.clear();
                }
            }
            
            else if(box2.getValue()=="Inches") //Inches
            {
                if(!TA1.getText().isEmpty())
                {
                    data = Double.parseDouble(TA1.getText());
                    res = data*39.37;
                    TA2.setText(String.format("%.4f", res));
                }
                else
                {
                    TA2.clear();
                }
            }
            
            else if(box2.getValue()=="Feets") //feets
            {
                if(!TA1.getText().isEmpty())
                {
                    data = Double.parseDouble(TA1.getText());
                    res = data*3.281;
                    TA2.setText(String.format("%.4f", res));
                }
                else
                {
                    TA2.clear();
                }
            }
            
            else if(box2.getValue()=="Miles") //Miles
            {
                if(!TA1.getText().isEmpty())
                {
                    data = Double.parseDouble(TA1.getText());
                    res = data/1609;
                    TA2.setText(String.format("%.4f", res));
                }
                else
                {
                    TA2.clear();
                }
            }
        }
        
        /*----------------KiloMeters-----------------*/
        else if(box1.getValue()=="KiloMeters")
        {
            if(box2.getValue()=="Millimeters")  //MilliMeters
            {
                if(!TA1.getText().isEmpty())
                {
                    data = Double.parseDouble(TA1.getText());
                    res = data*1000000;
                    TA2.setText(Double.toString(res));
                }
                else
                {
                    TA2.clear();
                }
            }
            else if(box2.getValue()=="CentiMeters") //Centimeter
            {
                if(!TA1.getText().isEmpty())
                {
                    data = Double.parseDouble(TA1.getText());
                    res = data*100000;
                    TA2.setText(Double.toString(res));
                }
                else
                {
                    TA2.clear();
                }
            }
            else if(box2.getValue()=="Meters") //Meter
            {
                if(!TA1.getText().isEmpty())
                {
                    data = Double.parseDouble(TA1.getText());
                    res = data*1000;
                    TA2.setText(Double.toString(res));
                }
                else
                {
                    TA2.clear();
                }
            }
            
            else if(box2.getValue()=="KiloMeters") //KiloMeters
            {
                if(!TA1.getText().isEmpty())
                {
                    data = Double.parseDouble(TA1.getText());
                    res = data;
                    TA2.setText(Double.toString(res));
                }
                else
                {
                    TA2.clear();
                }
            }
            
            else if(box2.getValue()=="Inches") //Inches
            {
                if(!TA1.getText().isEmpty())
                {
                    data = Double.parseDouble(TA1.getText());
                    res = data*39370;
                    TA2.setText(String.format("%.4f", res));
                }
                else
                {
                    TA2.clear();
                }
            }
            
            else if(box2.getValue()=="Feets") //feets
            {
                if(!TA1.getText().isEmpty())
                {
                    data = Double.parseDouble(TA1.getText());
                    res = data*3281;
                    TA2.setText(String.format("%.4f", res));
                }
                else
                {
                    TA2.clear();
                }
            }
            
            else if(box2.getValue()=="Miles") //Miles
            {
                if(!TA1.getText().isEmpty())
                {
                    data = Double.parseDouble(TA1.getText());
                    res = data/1.609;
                    TA2.setText(String.format("%.4f", res));
                }
                else
                {
                    TA2.clear();
                }
            }
        }
        
        /*----------------Inches----------------*/
        else if(box1.getValue()=="Inches")
        {
            if(box2.getValue()=="Millimeters")  //MilliMeters
            {
                if(!TA1.getText().isEmpty())
                {
                    data = Double.parseDouble(TA1.getText());
                    res = data*25.4;
                    TA2.setText(Double.toString(res));
                }
                else
                {
                    TA2.clear();
                }
            }
            else if(box2.getValue()=="CentiMeters") //Centimeter
            {
                if(!TA1.getText().isEmpty())
                {
                    data = Double.parseDouble(TA1.getText());
                    res = data*2.54;
                    TA2.setText(Double.toString(res));
                }
                else
                {
                    TA2.clear();
                }
            }
            else if(box2.getValue()=="Meters") //Meter
            {
                if(!TA1.getText().isEmpty())
                {
                    data = Double.parseDouble(TA1.getText());
                    res = data/39.37;
                    TA2.setText(String.format("%.3f", res));
                }
                else
                {
                    TA2.clear();
                }
            }
            
            else if(box2.getValue()=="KiloMeters") //KiloMeters
            {
                if(!TA1.getText().isEmpty())
                {
                    data = Double.parseDouble(TA1.getText());
                    res = data/39370;
                    TA2.setText(String.format("%.3f", res));
                }
                else
                {
                    TA2.clear();
                }
            }
            
            else if(box2.getValue()=="Inches") //Inches
            {
                if(!TA1.getText().isEmpty())
                {
                    data = Double.parseDouble(TA1.getText());
                    res = data;
                    TA2.setText(String.format("%.3f", res));
                }
                else
                {
                    TA2.clear();
                }
            }
            
            else if(box2.getValue()=="Feets") //feets
            {
                if(!TA1.getText().isEmpty())
                {
                    data = Double.parseDouble(TA1.getText());
                    res = data/12;
                    TA2.setText(String.format("%.3f", res));
                }
                else
                {
                    TA2.clear();
                }
            }
            
            else if(box2.getValue()=="Miles") //Miles
            {
                if(!TA1.getText().isEmpty())
                {
                    data = Double.parseDouble(TA1.getText());
                    res = data/63360;
                    TA2.setText(String.format("%.3f", res));
                }
                else
                {
                    TA2.clear();
                }
            }
        }
        
        /*----------------Feets---------------*/
        else if(box1.getValue()=="Feets")
        {
            if(box2.getValue()=="Millimeters")  //MilliMeters
            {
                if(!TA1.getText().isEmpty())
                {
                    data = Double.parseDouble(TA1.getText());
                    res = data*304.8;
                    TA2.setText(Double.toString(res));
                }
                else
                {
                    TA2.clear();
                }
            }
            else if(box2.getValue()=="CentiMeters") //Centimeter
            {
                if(!TA1.getText().isEmpty())
                {
                    data = Double.parseDouble(TA1.getText());
                    res = data*30.48;
                    TA2.setText(Double.toString(res));
                }
                else
                {
                    TA2.clear();
                }
            }
            else if(box2.getValue()=="Meters") //Meter
            {
                if(!TA1.getText().isEmpty())
                {
                    data = Double.parseDouble(TA1.getText());
                    res = data/3.281;
                    TA2.setText(String.format("%.3f", res));
                }
                else
                {
                    TA2.clear();
                }
            }
            
            else if(box2.getValue()=="KiloMeters") //KiloMeters
            {
                if(!TA1.getText().isEmpty())
                {
                    data = Double.parseDouble(TA1.getText());
                    res = data/3281;
                    TA2.setText(String.format("%.3f", res));
                }
                else
                {
                    TA2.clear();
                }
            }
            
            else if(box2.getValue()=="Inches") //Inches
            {
                if(!TA1.getText().isEmpty())
                {
                    data = Double.parseDouble(TA1.getText());
                    res = data*12;
                    TA2.setText(String.format("%.3f", res));
                }
                else
                {
                    TA2.clear();
                }
            }
            
            else if(box2.getValue()=="Feets") //feets
            {
                if(!TA1.getText().isEmpty())
                {
                    data = Double.parseDouble(TA1.getText());
                    res = data;
                    TA2.setText(String.format("%.3f", res));
                }
                else
                {
                    TA2.clear();
                }
            }
            
            else if(box2.getValue()=="Miles") //Miles
            {
                if(!TA1.getText().isEmpty())
                {
                    data = Double.parseDouble(TA1.getText());
                    res = data/5280;
                    TA2.setText(String.format("%.3f", res));
                }
                else
                {
                    TA2.clear();
                }
            }
        }
        
        /*----------------Miles--------------------*/
        else if(box1.getValue()=="Miles")
        {
            if(box2.getValue()=="Millimeters")  //MilliMeters
            {
                if(!TA1.getText().isEmpty())
                {
                    data = Double.parseDouble(TA1.getText());
                    res = data*1000000;
                    res = res*1.609;
                    TA2.setText(Double.toString(res));
                }
                else
                {
                    TA2.clear();
                }
            }
            else if(box2.getValue()=="CentiMeters") //Centimeter
            {
                if(!TA1.getText().isEmpty())
                {
                    data = Double.parseDouble(TA1.getText());
                    res = data*160934;
                    TA2.setText(Double.toString(res));
                }
                else
                {
                    TA2.clear();
                }
            }
            else if(box2.getValue()=="Meters") //Meter
            {
                if(!TA1.getText().isEmpty())
                {
                    data = Double.parseDouble(TA1.getText());
                    res = data*1609;
                    TA2.setText(Double.toString(res));
                }
                else
                {
                    TA2.clear();
                }
            }
            
            else if(box2.getValue()=="KiloMeters") //KiloMeters
            {
                if(!TA1.getText().isEmpty())
                {
                    data = Double.parseDouble(TA1.getText());
                    res = data*1.609;
                    TA2.setText(String.format("%.3f", res));
                }
                else
                {
                    TA2.clear();
                }
            }
            
            else if(box2.getValue()=="Inches") //Inches
            {
                if(!TA1.getText().isEmpty())
                {
                    data = Double.parseDouble(TA1.getText());
                    res = data*63360;
                    TA2.setText(String.format("%.3f", res));
                }
                else
                {
                    TA2.clear();
                }
            }
            
            else if(box2.getValue()=="Feets") //feets
            {
                if(!TA1.getText().isEmpty())
                {
                    data = Double.parseDouble(TA1.getText());
                    res = data*5280;
                    TA2.setText(String.format("%.3f", res));
                }
                else
                {
                    TA2.clear();
                }
            }
            
            else if(box2.getValue()=="Miles") //Miles
            {
                if(!TA1.getText().isEmpty())
                {
                    data = Double.parseDouble(TA1.getText());
                    res = data;
                    TA2.setText(String.format("%.3f", res));
                }
                else
                {
                    TA2.clear();
                }
            }
        }
    }

    /*Fady Part*/ 
    @FXML
    private void Change(javafx.scene.input.KeyEvent event) {
            if(!event.getText().isEmpty()){
            if(event.getText().matches("[0-9.]"))
            {
                TA1.appendText(event.getText());
            }
        }
        else if(event.getCode()==KeyCode.BACK_SPACE)
        {
            if(!TA1.getText().isEmpty())
                TA1.deleteText(TA1.getLength() -1 , TA1.getLength());
        }
    
        Converter();
    }
    
    /*Fady Part*/ 
    public void loaddata()
    {
        list.removeAll(list);
        String milli = "Millimeters";
        String centi = "CentiMeters";
        String meter = "Meters";
        String kilo = "KiloMeters";
        String inches = "Inches";
        String feet = "Feets";
        String miles = "Miles";
        list.addAll(milli,centi,meter,kilo,inches,feet,miles);
        box1.getItems().addAll(list);
        box1.getSelectionModel().selectFirst();
        box2.getItems().addAll(list);
        box2.getSelectionModel().selectFirst();
    }

}
