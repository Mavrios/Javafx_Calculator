/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package final_programmer;
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
    @FXML
    private Button btn_F;
    @FXML
    private Button btn_E;
    @FXML
    private Button btn_D;
    @FXML
    private Button btn_C;
    @FXML
    private Button btn_B;
    @FXML
    private Button btn_A;
    @FXML
    private Button btn_equal;
    
    boolean BIN_FLAG = false;
    boolean OCT_FLAG = false;
    boolean HEX_FLAG = false;
    boolean DEC_FLAG = true;
    
    boolean AND_FLAG = false;
    boolean OR_FLAG  = false;
    boolean XOR_FLAG = false;
    
    //(3) Flag for checking about which text Atrea(text_Area , text_Area2) will choose to append
    boolean TEXT_2 = false;
    
    int EQ_FLAG = 0;
    
    int ans =0; //to store in it the old values 
    @FXML
    private Button btn_NOT;
    @FXML
    private Button btn_XOR;
    @FXML
    private Button btn_AND;
    @FXML
    private Button btn_OR;
    @FXML
    private TextArea text_Area2;
    @FXML
    private Label operation;
    @FXML
    private Button btn_equal1;
    @FXML
    private Label operation1;
    @FXML
    private Label label_History;
    @FXML
    private TextArea text_History;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Button_0(ActionEvent event)
    {
        if (TEXT_2 == true )
        { 
            text_Area2.appendText("0");
        }
        else
        {
            text_Area.appendText("0");
        }
    }

    @FXML
    private void Button_1(ActionEvent event)
    {
        if (TEXT_2 == true )
        { 
            text_Area2.appendText("1");
        }
        else
        text_Area.appendText("1");
    
    }

    @FXML
    private void Button_2(ActionEvent event) 
    { 
        if (TEXT_2 == true )
        { 
            text_Area2.appendText("2");
        }
        else
        text_Area.appendText("2");
    }

    @FXML
    private void Button_3(ActionEvent event) 
    {
        if (TEXT_2 == true )    
        { 
            text_Area2.appendText("3");
        }
        else
        text_Area.appendText("3");
    }

    @FXML
    private void Button_4(ActionEvent event)
    {
        if (TEXT_2 == true )
        { 
            text_Area2.appendText("4");
        }
        else
        text_Area.appendText("4");
    }

    @FXML
    private void Button_5(ActionEvent event) 
    {
        if (TEXT_2 == true )
        { 
            text_Area2.appendText("5");
        }
        else
        text_Area.appendText("5");

    }

    @FXML
    private void Button_6(ActionEvent event) 
    {
        if (TEXT_2 == true )
        { 
            text_Area2.appendText("6");
        }
        else
         text_Area.appendText("6");
    }

    @FXML
    private void Button_7(ActionEvent event)
    {
        if (TEXT_2 == true )
        { 
            text_Area2.appendText("7");
        }
        else
         text_Area.appendText("7");
    
    }

    @FXML
    private void Button_8(ActionEvent event)
    {
        if (TEXT_2 == true )
        { 
            text_Area2.appendText("8");
        }
        else
        text_Area.appendText("8");
    }

    @FXML
    private void Button_9(ActionEvent event) 
    {
        if (TEXT_2 == true )
        { 
            text_Area2.appendText("9");
        }
        else
         text_Area.appendText("9");
    }

   @FXML
    private void Button_F(ActionEvent event) {
        if (TEXT_2 == true )
        { 
            text_Area2.appendText("F");
        }
        else
        text_Area.appendText("F");
    }

    @FXML
    private void Button_E(ActionEvent event) {
        if (TEXT_2 == true )
        { 
            text_Area2.appendText("E");
        }
        else
        text_Area.appendText("E");
    }

    @FXML
    private void Button_D(ActionEvent event) {
        if (TEXT_2 == true )
        { 
            text_Area2.appendText("D");
        }
        else
        text_Area.appendText("D");
    }

    @FXML
    private void Button_C(ActionEvent event) {
        
        if (TEXT_2 == true )
        { 
            text_Area2.appendText("C");
        }
        else
        text_Area.appendText("C");
    }

    @FXML
    private void Button_B(ActionEvent event) {
       if (TEXT_2 == true )
        { 
            text_Area2.appendText("B");
        }
        else
        text_Area.appendText("B");
    }

    @FXML
    private void Button_A(ActionEvent event) {
        if (TEXT_2 == true )
        { 
            text_Area2.appendText("A");
        }
        else
        text_Area.appendText("A");
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
        //Flag of binary numbers
       BIN_FLAG = true;
       
       DEC_FLAG = false;
       OCT_FLAG = false;
       HEX_FLAG = false;
        //Enable Zeros and Ones Button only
      
    }
    @FXML
    private void Button_OCT(ActionEvent event) 
    {
        //(1) Flag of Octal
        OCT_FLAG = true;   
        
        DEC_FLAG = false;
        BIN_FLAG = false;
        HEX_FLAG = false;
    }

    @FXML
    private void Button_HEX(ActionEvent event) 
    {
        //(1) Flag of Hexadecimal numbers
        HEX_FLAG = true;
        
        DEC_FLAG = false;
        OCT_FLAG = false;
        BIN_FLAG = false;
    }

    @FXML
    private void Buuton_DEC(ActionEvent event) 
    {
        DEC_FLAG = true;
        
        HEX_FLAG = false;
        OCT_FLAG = false;
        BIN_FLAG = false;
    }

    @FXML
    private void Button_Equal(ActionEvent event) //Show Values
    {
    
     if (text_Area.getText().contains(" = " ))
    {
      label_OCT.setText("wrong Number"); 
      
      label_HEX.setText("wrong Number"); 
      
      label_BIN.setText("wrong Number");
 
      label_DEC.setText("wrong Number");
        
    }   
     else if (text_Area.getText().length() != 0 )
    {
      if (BIN_FLAG == true )
      {
       String text = text_Area.getText();
     //  String binaryString="1010";  
       int decimal=Integer.parseInt(text,2);
       String oct = Integer.toOctalString(decimal);//Converting to octal
      label_OCT.setText(oct); 
      String hex = Integer.toHexString(decimal);  //Convertig to hex
      label_HEX.setText(hex); 
      String bin = Integer.toBinaryString(decimal);//Converting to binary
      label_BIN.setText(bin);
      String dec = Integer.toString(decimal);
      label_DEC.setText(dec);
       
      }
      
      else if (HEX_FLAG == true)
      {
       String text = text_Area.getText();
     //  String binaryString="1010";  
       int decimal=Integer.parseInt(text,16);
       String oct = Integer.toOctalString(decimal);//Converting to octal
      label_OCT.setText(oct); 
      String hex = Integer.toHexString(decimal);  //Convertig to hex
      label_HEX.setText(hex); 
      String bin = Integer.toBinaryString(decimal);//Converting to binary
      label_BIN.setText(bin);
      String dec = Integer.toString(decimal);
      label_DEC.setText(dec);
      }
      else if (OCT_FLAG == true)
      {
       String text = text_Area.getText();
       int decimal=Integer.parseInt(text,8);
       String oct = Integer.toOctalString(decimal);//Converting to octal
      label_OCT.setText(oct); 
      String hex = Integer.toHexString(decimal);  //Convertig to hex
      label_HEX.setText(hex); 
      String bin = Integer.toBinaryString(decimal);//Converting to binary
      label_BIN.setText(bin);
      String dec = Integer.toString(decimal);
      label_DEC.setText(dec);
      }
      
      else 
      {    
      String text = text_Area.getText();
       
      Integer num1 = new Integer(text);
     
      String oct = Integer.toOctalString(num1);//Converting to octal
      label_OCT.setText(oct); 
      String hex = Integer.toHexString(num1);  //Convertig to hex
      label_HEX.setText(hex); 
      String bin = Integer.toBinaryString(num1);//Converting to binary
      label_BIN.setText(bin);
  //  String dec = Integer.toString(decimal);
      label_DEC.setText(text);
      }
    }
    
    else
    {
      label_OCT.setText("0"); 
      
      label_HEX.setText("0"); 
      
      label_BIN.setText("0");
 
      label_DEC.setText("0"); 
    }
    }
    

    @FXML
    private void Button_Clear(ActionEvent event)
    {
        text_Area.clear();
        
        text_Area2.clear();
        
        TEXT_2 = false;
    }

    @FXML
    private void Button_NOT(ActionEvent event) 
    {
        String text = text_Area.getText();
        Integer num = new Integer(text);
        
        int result = ~num;
        String s=String.valueOf(result);  //Converting result to string 
        text_Area.clear();
        text_Area.setText("NOT ( "+text+" ) = " + s);
        if (text_History.getText().length() != 0)
        {    
        text_History.appendText("\n");
        }
        text_History.appendText("NOT ( "+text+" ) = " + s);
       
    }
    

    @FXML
    private void Button_XOR(ActionEvent event)
    {
        XOR_FLAG = true;
        AND_FLAG = false;
        OR_FLAG  = false;
        
        EQ_FLAG = 0;
        TEXT_2 = true;
        operation.setText("XOR");
        
        
    }

    @FXML
    private void Button_AND(ActionEvent event) 
    {
        XOR_FLAG = false;
        AND_FLAG = true;
        OR_FLAG  = false;
        
        EQ_FLAG = 0;
        
        TEXT_2 = true;
        
        operation.setText("AND");
        
    }

    @FXML
    private void Button_OR(ActionEvent event) 
    {
        XOR_FLAG = false;
        AND_FLAG = false;
        OR_FLAG  = true;
        
        EQ_FLAG = 0;
        
        TEXT_2 = true;
        
        operation.setText("OR");
        
    }

    @FXML
    private void Button_Equal1(ActionEvent event) //For Equality of (OR / XOR / AND Operations)
    {
         TEXT_2 = false;
         
        if (EQ_FLAG  == 0)
        {
        if (XOR_FLAG == true)
        {
            String text = text_Area.getText();
            Integer num1 = new Integer(text);
        
            String text2 = text_Area2.getText();
            Integer num2 = new Integer(text2);
        
            int result = num1 ^ num2;
            ans = result;

            String s=String.valueOf(result); 
            operation.setText("   ");
            if (text_History.getText().length() != 0)
            { text_History.appendText("\n");}
            text_History.appendText(text + " XOR ( " + text2 + " ) = "+s);
            //text_Area.setText(text + " XOR ( " + text2 + " ) = ");
            text_Area.setText(s);
            text_Area2.clear();
            
            EQ_FLAG = 1 ;
        }
        else if (OR_FLAG == true)
        {
            
          //  if(text_Area2.getText().length() == 0)
           // {
            String text = text_Area.getText();
            Integer num1 = new Integer(text);
        
            String text2 = text_Area2.getText();
            Integer num2 = new Integer(text2);
        
            int result = num1 | num2;
            ans = result;
            String s=String.valueOf(result); 
            operation.setText("  ");
            if (text_History.getText().length() != 0)
            {   
            text_History.appendText("\n");}
            text_History.appendText(text + " OR ( " + text2 + " ) = "+s);
           
            text_Area.setText(s);
            text_Area2.clear();
        //    }
            EQ_FLAG =1;
        }
         else if (AND_FLAG == true)
        {
            String text = text_Area.getText();
            Integer num1 = new Integer(text);
        
            String text2 = text_Area2.getText();
            Integer num2 = new Integer(text2);
        
            int result = num1 & num2;
            ans = result;
            
            String s=String.valueOf(result); 
            operation.setText("   ");
            if (text_History.getText().length() != 0)
            {text_History.appendText("\n");}
            text_History.appendText(text + " AND ( " + text2 + " ) = "+s);
            text_Area.setText(s);
            text_Area2.clear();
            EQ_FLAG = 1;
        }
    }
        else 
        {
            String s_ans = String.valueOf(ans);
            text_Area.setText(s_ans);
        }    
    }    
    
    
}
