/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programmer_calculator;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 *
 * @author NoteBook
 */
public class FXMLDocumentController implements Initializable {
    
    private Label label;
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
    
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Button_0(ActionEvent event)
    {
        text_Area.appendText("0");
    }

    @FXML
    private void Button_1(ActionEvent event)
    {
        text_Area.appendText("1");
    
    }

    @FXML
    private void Button_2(ActionEvent event) 
    {
        text_Area.appendText("2");
    }

    @FXML
    private void Button_3(ActionEvent event) 
    {
        text_Area.appendText("3");
    }

    @FXML
    private void Button_4(ActionEvent event)
    {
         text_Area.appendText("4");
    }

    @FXML
    private void Button_5(ActionEvent event) 
    {
         text_Area.appendText("5");

    }

    @FXML
    private void Button_6(ActionEvent event) 
    {
         text_Area.appendText("6");
    }

    @FXML
    private void Button_7(ActionEvent event)
    {
         text_Area.appendText("7");
    
    }

    @FXML
    private void Button_8(ActionEvent event)
    {
        text_Area.appendText("8");
    }

    @FXML
    private void Button_9(ActionEvent event) 
    {
         text_Area.appendText("9");
    }

    @FXML
    private void Label_OCT(ActionEvent event) {
    }

    @FXML
    private void Label_DEC(ActionEvent event) {
    }

    @FXML
    private void Label_HEX(ActionEvent event) {
    }

    @FXML
    private void Label_BIN(ActionEvent event) {
    }

    @FXML
    private void Button_BIN(ActionEvent event)
    {
      String text = text_Area.getText();
       
      Integer num1 = new Integer(text);
      // converting to binary and representing it in a string
      String bin = Integer.toBinaryString(num1);
      label_BIN.setText(bin);
    
       
    }

    @FXML
    private void Button_OCT(ActionEvent event) 
    {
      String text = text_Area.getText();
       
      Integer num1 = new Integer(text);
      // converting to binary and representing it in a string
      String oct = Integer.toOctalString(num1);
      label_OCT.setText(oct); 
    }

    @FXML
    private void Button_HEX(ActionEvent event) 
    {
      String text = text_Area.getText();
       
      Integer num1 = new Integer(text);
      // converting to binary and representing it in a string
      String hex = Integer.toHexString(num1);
        
      label_HEX.setText(hex); 
        
    }

    @FXML
    private void Buuton_DEC(ActionEvent event) 
    {
    
        String text = text_Area.getText();
        label_DEC.setText(text);
    }
    
}
