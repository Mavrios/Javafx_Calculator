/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package javafxapplication2;

import java.awt.event.KeyEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
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
    @FXML
    private TextArea TA;
    boolean flag = true;
    boolean I_flag = true;
    boolean R_flag = false;
    boolean toggleSign = false;
    boolean powFlag = false;
    boolean sqrFlag = false;
    String xpow2Val = "";
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

        flag = true;
        R_flag = false;
        TA.appendText("%");

    }

    @FXML
    private void btnPI(ActionEvent event) {
        if (R_flag == true) {
            TA.clear();
        }

        flag = true;
        R_flag = false;
        TA.appendText("π");
    }

    @FXML
    private void btnE(ActionEvent event) {
        if (R_flag == true) {
            TA.clear();
        }

        flag = true;
        R_flag = false;
        TA.appendText("e");
    }

    @FXML
    private void btnExp(ActionEvent event) {
        if (R_flag == true) {
            TA.clear();
        }

        flag = true;
        R_flag = false;
        TA.appendText("exp(");
    }

    @FXML
    private void btnInv(ActionEvent event) {
        if (R_flag == true) {
            TA.clear();
        }

        flag = true;
        R_flag = false;
        TA.appendText("1/(");
    }

    @FXML
    private void btnToggleSign(ActionEvent event) {
        if (!TA.getText().equals('0')) {
            toggleSign = true;
        }
    }

    @FXML
    private void btnXpowY(ActionEvent event) {
        if (R_flag == true) {
            TA.clear();
        }

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

        flag = true;
        R_flag = false;
        TA.appendText("10^(");
    }

    @FXML
    private void btnLog(ActionEvent event) {
        if (R_flag == true) {
            TA.clear();
        }

        flag = true;
        R_flag = false;
        TA.appendText("log(");
    }

    @FXML
    private void btnLn(ActionEvent event) {
        if (R_flag == true) {
            TA.clear();
        }

        flag = true;
        R_flag = false;
        TA.appendText("ln(");
    }

    @FXML
    private void btnSqr(ActionEvent event) {
        if (R_flag == true) {
            TA.clear();
        }

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

        flag = true;
        R_flag = false;
        TA.appendText("sqrt(");
    }

    @FXML
    private void btnAbs(ActionEvent event) {
        if (R_flag == true) {
            TA.clear();
        }

        flag = true;
        R_flag = false;
        TA.appendText("abs(");
    }
 
@FXML
    private void btnFact(ActionEvent event) {
        if (R_flag == true) {
            TA.clear();
        }

        flag = true;
        R_flag = false;
        TA.appendText("fact(");
//        int i ;
//        for(i=1;i<=number;i++){    
//              fact=fact*i;    
//          }   
    }
//-----------------------------------------

    @FXML
    private void handleButtonActionP(ActionEvent event) {
        if (flag == false) {
            TA.deleteText(TA.getLength() - 1, TA.getLength());
        }
        R_flag = false;
        flag = false;
        TA.appendText("+");
    }

    @FXML
    private void handleButtonActionN(ActionEvent event) {
        if (flag == false) {
            TA.deleteText(TA.getLength() - 1, TA.getLength());
        }
        R_flag = false;
        flag = false;
        TA.appendText("-");
    }

    @FXML
    private void handleButtonActionM(ActionEvent event) {
        if (flag == false) {
            TA.deleteText(TA.getLength() - 1, TA.getLength());
        }
        R_flag = false;
        flag = false;
        TA.appendText("*");
    }

    @FXML
    private void handleButtonActionD(ActionEvent event) {
        if (flag == false) {
            TA.deleteText(TA.getLength() - 1, TA.getLength());
        }
        R_flag = false;
        flag = false;
        TA.appendText("/");
    }

    @FXML
    private void handleButtonActionDot(ActionEvent event) {
        TA.appendText(".");
        R_flag = false;
        flag = true;
    }

    @FXML
    private void handleButtonActionC(ActionEvent event) {
        flag = true;
        R_flag = false;
        TA.clear();
    }

    @FXML
    private void handleButtonActionEqu(ActionEvent event) {
        flag = true;
        R_flag = true;
        powFlag = false;
        String tmp;
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
        Vbox.setVisible(false);
        MenuBox.setVisible(false);

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
        Vbox_Flag = !Vbox_Flag;
        Vbox.setVisible(Vbox_Flag);

    }

    @FXML
    private void ScientificPaneClicked(MouseEvent event) {
        Vbox.setVisible(false);
        MenuBox.setVisible(false);
        Menu_Flag = false;
        Vbox_Flag = false;

    }

    @FXML
    private void MenuHandling(ActionEvent event) {
        Menu_Flag = !Menu_Flag;
        MenuBox.setVisible(Menu_Flag);
    }

    @FXML
    private void btnBksp(ActionEvent event) {
        if (!TA.getText().isEmpty()) {
            TA.deleteText(TA.getLength() - 1, TA.getLength());
        }

    }

}
