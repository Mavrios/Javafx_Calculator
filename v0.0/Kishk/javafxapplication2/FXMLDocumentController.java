/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package javafxapplication2;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;


/**
 *
 * @author Kishk
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    @FXML
    public Button button1;
    @FXML
    private Button button2;
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
    private Button button3;
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
    private TextArea TA;
    @FXML
    private Button buttonEq;
    
    boolean flag = true;
    
    String Temp = "";
    
    
    
    @FXML
    private void handleButtonAction1(ActionEvent event) {
        flag = true;
        TA.appendText("1");
        Temp = Temp + "1";
    }
    
    @FXML
    private void handleButtonAction2(ActionEvent event) {
        flag = true;
        TA.appendText("2");
    }
    
    @FXML
    private void handleButtonAction3(ActionEvent event) {
        flag = true;
        TA.appendText("3");
    }

    @FXML
    private void handleButtonAction4(ActionEvent event) {
        flag = true;
        TA.appendText("4");
    }    
    
    
    @FXML
    private void handleButtonAction5(ActionEvent event) {
        flag = true;
        TA.appendText("5");
    }

    @FXML
    private void handleButtonAction6(ActionEvent event) {
        flag = true;
        TA.appendText("6");
    }

    @FXML
    private void handleButtonAction7(ActionEvent event) {
        flag = true;
        TA.appendText("7");
    }    

    @FXML
    private void handleButtonAction8(ActionEvent event) {
        flag = true;
        TA.appendText("8");
    }
    
    @FXML
    private void handleButtonAction9(ActionEvent event) {
        flag = true;
        TA.appendText("9");
    }

    @FXML
    private void handleButtonAction0(ActionEvent event) {
        flag = true;
        TA.appendText("0");
    }


    @FXML
    private void handleButtonActionP(ActionEvent event) {
        if(flag == false){
        TA.deleteText(TA.getLength()-1, TA.getLength());
        }
        flag = false;
        TA.appendText("+");
    }


    @FXML
    private void handleButtonActionN(ActionEvent event) {
    if(flag == false){
        TA.deleteText(TA.getLength()-1, TA.getLength());
        }
        flag = false;
        TA.appendText("-");
    }    
    
    @FXML
    private void handleButtonActionM(ActionEvent event) {
        if(flag == false){
        TA.deleteText(TA.getLength()-1, TA.getLength());
        }
        flag = false;
        TA.appendText("*");
    }
    @FXML
    private void handleButtonActionD(ActionEvent event) {
    if(flag == false){
        TA.deleteText(TA.getLength()-1, TA.getLength());
    }
        flag = false;
        TA.appendText("/");
    }
    @FXML
    private void handleButtonActionDot(ActionEvent event) {
        TA.appendText(".");
        flag = true;
    }    
    
    @FXML
    private void handleButtonActionC(ActionEvent event) {
        TA.clear();
    }    
        
    
    @FXML
    private void handleButtonActionEqu(ActionEvent event) {
        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("JavaScript");
        try{
            TA.setText(engine.eval(TA.getText()).toString());
        }catch(ScriptException e){
            TA.setText("Undefined!!");
        }
        
    }    
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

}
