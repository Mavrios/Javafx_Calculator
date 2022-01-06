/****************************** Author  : Salma Salah            ******************************************************************************/
/****************************** Project : Calculator (Programmer)******************************************************************************/
/****************************** Date    : 3/1/2022               ******************************************************************************/
/****************************** Version : 2                      ******************************************************************************/
/**********************************************************************************************************************************************/

package final_programmer;

/***(1) Importing All Libraries which we will need ***/
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.MouseEvent;

/***(2) Creating Class which implements Initializable  ***/

public class FXMLDocumentController implements Initializable {
    
    /**** (2) - 1 Creating classes which Shown in the Scene and we will use it to deal with the user *****/
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
    
    /*** (2) - '2' Defining Some Global Variables which are used in handling the algorithm we want******/
    boolean FLAGS;
    boolean BIN_FLAG = false;
    boolean OCT_FLAG = false;
    boolean HEX_FLAG = false;
    boolean DEC_FLAG = true;
    
    boolean AND_FLAG = false;
    boolean OR_FLAG  = false;
    boolean XOR_FLAG = false;
    //boolean NOT_FLAG
    boolean TEXT_2 = false; // Flag for checking about which text Atrea(text_Area , text_Area2) will choose to append

    int EQ_FLAG = 0;
    
    long ans = 0; //to store in it the old values 
    @FXML
    private Label label_Equation;
    
    
    /*** (3) - '1'
     * @param url
     * @param rb *******/
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    /*** (4) Writing the code which will be done by pressing the buttons *******/
    @FXML
    private void Button_0(ActionEvent event)
    {
        if (EQ_FLAG == 1 )
        {
            text_Area.clear();
        }
        if (TEXT_2 == true )
        { 
            text_Area2.appendText("0");
        }
        else
        {
            text_Area.appendText("0");
        }
        EQ_FLAG = 0;
    }

    @FXML
    private void Button_1(ActionEvent event)
    {
        if (EQ_FLAG >= 1 )
        {
            text_Area.clear();
        }
        if (TEXT_2 == true )
        { 
            text_Area2.appendText("1");
        }
        else
        text_Area.appendText("1");
        
        EQ_FLAG = 0;

    }

    @FXML
    private void Button_2(ActionEvent event) 
    { 
        if (EQ_FLAG >= 1 )
        {
            text_Area.clear();
        }
        if (TEXT_2 == true )
        { 
            text_Area2.appendText("2");
        }
        else
        {text_Area.appendText("2");
        }
        EQ_FLAG = 0;

    }

    @FXML
    private void Button_3(ActionEvent event) 
    {
        if (EQ_FLAG >= 1 )
        {
            text_Area.clear();
        }
        if (TEXT_2 == true )    
        { 
            text_Area2.appendText("3");
        }
        else
        text_Area.appendText("3");
        
                EQ_FLAG = 0;

    }

    @FXML
    private void Button_4(ActionEvent event)
    {
         if (EQ_FLAG >= 1 )
        {
            text_Area.clear();
        }
        if (TEXT_2 == true )
        { 
            text_Area2.appendText("4");
        }
        else
        text_Area.appendText("4");
        EQ_FLAG = 0;

    }

    @FXML
    private void Button_5(ActionEvent event) 
    {
         if (EQ_FLAG >= 1 )
        {
            text_Area.clear();
        }
        if (TEXT_2 == true )
        { 
            text_Area2.appendText("5");
        }
        else
        text_Area.appendText("5");
        EQ_FLAG = 0;

    }

    @FXML
    private void Button_6(ActionEvent event) 
    {
         if (EQ_FLAG >= 1 )
        {
            text_Area.clear();
        }
        if (TEXT_2 == true )
        { 
            text_Area2.appendText("6");
        }
        else
        { text_Area.appendText("6");
        }
        EQ_FLAG = 0;

    }

    @FXML
    private void Button_7(ActionEvent event)
    {
         if (EQ_FLAG >= 1 )
        {
            text_Area.clear();
        }
        if (TEXT_2 == true )
        { 
            text_Area2.appendText("7");
        }
        else
        {text_Area.appendText("7");
        }
        EQ_FLAG = 0;

    }

    @FXML
    private void Button_8(ActionEvent event)
    {
         if (EQ_FLAG >= 1 )
        {
            text_Area.clear();
        }
        if (TEXT_2 == true )
        { 
            text_Area2.appendText("8");
        }
        else
        {text_Area.appendText("8");
        }
                EQ_FLAG = 0;

    }

    @FXML
    private void Button_9(ActionEvent event) 
    {
         if (EQ_FLAG >= 1 )
        {
            text_Area.clear();
        }
        if (TEXT_2 == true )
        { 
            text_Area2.appendText("9");
        }
        else
        { text_Area.appendText("9");}
                EQ_FLAG = 0;

    }

   @FXML
    private void Button_F(ActionEvent event) {
         if (EQ_FLAG >= 1 )
        {
            text_Area.clear();
        }
        if (TEXT_2 == true )
        { 
            text_Area2.appendText("F");
        }
        else
        {text_Area.appendText("F");}
                EQ_FLAG = 0;

    }

    @FXML
    private void Button_E(ActionEvent event) {
         if (EQ_FLAG >= 1 )
        {
            text_Area.clear();
        }
        if (TEXT_2 == true )
        { 
            text_Area2.appendText("E");
        }
        else
        {text_Area.appendText("E");}
                EQ_FLAG = 0;

    }

    @FXML
    private void Button_D(ActionEvent event) {
         if (EQ_FLAG >= 1 )
        {
            text_Area.clear();
        }
        if (TEXT_2 == true )
        { 
            text_Area2.appendText("D");
        }
        else
        { text_Area.appendText("D");}
                EQ_FLAG = 0;

    }

    @FXML
    private void Button_C(ActionEvent event) {
        if (EQ_FLAG >= 1 )
        {
            text_Area.clear();
        } 
        if (TEXT_2 == true )
        { 
            text_Area2.appendText("C");
        }
        else
        {text_Area.appendText("C");}
                EQ_FLAG = 0;

    }

    @FXML
    private void Button_B(ActionEvent event) {
        if (EQ_FLAG >= 1 )
        {
            text_Area.clear();
        }
        if (TEXT_2 == true )
        { 
            text_Area2.appendText("B");
        }
        else
        {text_Area.appendText("B");}
                EQ_FLAG = 0;

    }

    @FXML
    private void Button_A(ActionEvent event) {
         if (EQ_FLAG >= 1 )
        {
            text_Area.clear();
        }
        if (TEXT_2 == true )
        { 
            text_Area2.appendText("A");
        }
        else
        {text_Area.appendText("A");}
                EQ_FLAG = 0;

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
    private void Button_OCT(ActionEvent event) 
    {
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
    private void Button_HEX(ActionEvent event) 
    {
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
    private void Buuton_DEC(ActionEvent event) 
    {
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

    /**************************** Show values (Button_Equal) *************************************************************************/
    /************this method is running when user press Show Values Button************************************************************/
    /************it checks if the user wants to convert binary or decimal or octal or hex number in text_area 1 **********************/
    /************and if the number is not exceed 15 number it can be converted into the other numbers representation  ****************/

    @FXML
    private void Button_Equal(ActionEvent event) //Show Values
    {
    
        
     if (text_Area.getText().contains(" = "))
    {
      
       String s= String.valueOf(ans);
       long decimal = Long.parseLong(s);
       String oct = Long.toOctalString(decimal);//Converting to octal
      label_OCT.setText(oct); 
      String hex = Long.toHexString(decimal);  //Convertig to hex
      label_HEX.setText(hex); 
      String bin = Long.toBinaryString(decimal);//Converting to binary
      label_BIN.setText(bin);
      String dec = Long.toString(decimal);
      label_DEC.setText(dec);
       
    }   
     else if (text_Area.getText().length() != 0 )
    {
      try{ 
      if (BIN_FLAG == true )
      {
       String text = text_Area.getText();
     //  String binaryString="1010";  
       long decimal=Long.parseLong(text,2);
       String oct = Long.toOctalString(decimal);//Converting to octal
      label_OCT.setText(oct); 
      String hex = Long.toHexString(decimal);  //Convertig to hex
      label_HEX.setText(hex); 
      String bin = Long.toBinaryString(decimal);//Converting to binary
      label_BIN.setText(bin);
      String dec = Long.toString(decimal);
      label_DEC.setText(dec);
       
      }
      
      else if (HEX_FLAG == true)
      {
       String text = text_Area.getText();
       long decimal=Long.parseLong(text,16);
       String oct = Long.toOctalString(decimal);//Converting to octal
       label_OCT.setText(oct); 
       String hex = Long.toHexString(decimal);  //Convertig to hex
      label_HEX.setText(hex); 
      String bin = Long.toBinaryString(decimal);//Converting to binary
      label_BIN.setText(bin);
      String dec = Long.toString(decimal);
      label_DEC.setText(dec);
      }
      else if (OCT_FLAG == true)
      {
       String text = text_Area.getText();
       long decimal=Long.parseLong(text,8);
       String oct = Long.toOctalString(decimal);//Converting to octal
       label_OCT.setText(oct); 
      String hex = Long.toHexString(decimal);  //Convertig to hex
      label_HEX.setText(hex); 
      String bin = Long.toBinaryString(decimal);//Converting to binary
      label_BIN.setText(bin);
      String dec = Long.toString(decimal);
      label_DEC.setText(dec);
      }
      
      else 
      {    
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
      }
            catch(NumberFormatException e)
            {   
                text_Area.appendText("  Very Long Number (Exceeds 15 ) ");
                System.out.println("Number of Exception occured because it is very long number at textArea1!");
                label_OCT.clear(); 
                label_HEX.clear();
                label_BIN.clear();
                label_DEC.clear();
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
      
      label_OCT.clear(); 
      label_HEX.clear();
      label_BIN.clear();
      label_DEC.clear();
      
      operation.setText("");
      
      TEXT_2 = false;
    }

    @FXML
    private void Button_NOT(ActionEvent event) 
    {
        String text = text_Area.getText();
       try{
        long  num ;
       
        if (BIN_FLAG == true )
        {
            num = Long.parseLong(text,2); // to return Decimal number
        }
        else if (HEX_FLAG == true )
        {
            num =  Long.parseLong(text,16);
        }
        else if (OCT_FLAG == true )
        {
            num = Long.parseLong(text,8);
        }
        else 
            num =  Long.parseLong(text);
       
        long result = ~num; // result is a Decimal Number and we will convert it to suitable number 
        ans =  result;
       String s = "0";
        if (BIN_FLAG == true)
        {
             s = Long.toBinaryString(result);//Converting to binary
           
        }
        else if (HEX_FLAG == true)
        {
             s = Long.toHexString(result);  //Convertig to hex
        }
        else if (OCT_FLAG == true)
        {
             s = Long.toOctalString(result);//Converting to octal
        }    
        else
       
        s = String.valueOf(result); 
      //Converting result to string 
        text_Area.setText(s);
        label_Equation.setText("NOT ( "+text+" ) = " + s);
       }
       catch(NumberFormatException e)
       {   
           text_Area.appendText("  Very Long Number");
           System.out.println("Number of Exception occured because it is very long number !");
       }
        EQ_FLAG = 1 ;
        
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

    /**************************** (=) Button_Equal1 *************************************************************************************************/
    /************this method is running when user press = Button*************************************************************************************/
    /************it checks which operation(OR / AND /XOR) the user wants to do between the numbers at first and second areas ************************/
    /************and checks the Numbering system if binary or hex or octal or decimal and returns the value at this numbering system he choosed******/

    @FXML
    private void Button_Equal1(ActionEvent event) //For Equality of (OR / XOR / AND Operations)
    {
         TEXT_2 = false;
         
        if (EQ_FLAG  == 0)
        {
       
            
        if (XOR_FLAG == true) /***************** XOR Operation ***********************/
        {
            String text = text_Area.getText();
            try {
            long num1  ;   
            if (BIN_FLAG == true )
            {
            num1 = Long.parseLong(text,2);
            }
            else if (HEX_FLAG == true )
            {
            num1 = Long.parseLong(text,16);
            }
            else if (OCT_FLAG == true )
            {
            num1 = Long.parseLong(text,8);
            }
            else 
            num1 = Long.parseLong(text);    
            
          
            String text2 = text_Area2.getText();
            try{
            long num2 = 0 ;   
            if (BIN_FLAG == true )
            {
            num2 = Long.parseLong(text2,2);
            }
            else if (HEX_FLAG == true )
            {
            num2 = Long.parseLong(text2,16);
            }
            else if (OCT_FLAG == true )
            {
            num2 = Long.parseLong(text2,8);
            }
            else 
            num2 = Long.parseLong(text2);    
            
            
            //(2) Result
            long result = num1 ^ num2;
            ans = result;
           
            String s = "0";
            
            if (BIN_FLAG == true)
            {
             s = Long.toBinaryString(result);//Converting to binary
           
            }
            else if (HEX_FLAG == true)
            {
             s = Long.toHexString(result);  //Convertig to hex
            }
            else if (OCT_FLAG == true)
            {
             s = Long.toOctalString(result);//Converting to octal
            }    
            else
             s = String.valueOf(result); 
            operation.setText("   ");
      
            label_Equation.setText(text + " XOR ( " + text2 + " ) = "+s);
            text_Area.setText(s);
            text_Area2.clear();
            }
            catch(NumberFormatException e)
            {   
                text_Area2.appendText("  Very Long Number ");
                System.out.println("Number of Exception occured because it is very long number at textArea2!");
            }
            
            }
            catch(NumberFormatException e)
            {   
                text_Area.appendText("  Very Long Number ");
                System.out.println("Number of Exception occured because it is very long number  at textArea !");
            } 
            EQ_FLAG = 1 ;
        }
        else if (OR_FLAG == true)
        {
            String text = text_Area.getText();
           try{
            long num1 = 0 ;   
            if (BIN_FLAG == true )
            {
            num1 = Long.parseLong(text,2);
            }
            else if (HEX_FLAG == true )
            {
            num1 = Long.parseLong(text,16);
            }
            else if (OCT_FLAG == true )
            {
            num1 = Long.parseLong(text,8);
            }
            else 
            num1 = Long.parseLong(text);    
            
            String text2 = text_Area2.getText();
            try{
            long num2 = 0 ;   
            if (BIN_FLAG == true )
            {
            num2 = Long.parseLong(text2,2);
            }
            else if (HEX_FLAG == true )
            {
            num2 = Long.parseLong(text2,16);
            }
            else if (OCT_FLAG == true )
            {
            num2 = Long.parseLong(text2,8);
            }
            else 
            num2 = Long.parseLong(text2);    
            
        
            long result = num1 | num2;
            ans = result;
            
            String s = "0";
             if (BIN_FLAG == true)
            {
             s = Long.toBinaryString(result);//Converting to binary
           
            }
            else if (HEX_FLAG == true)
             {
                 s = Long.toHexString(result);  //Convertig to hex
            }
            else if (OCT_FLAG == true)
             {
             s = Long.toOctalString(result);//Converting to octal
             }    
            else
            s = String.valueOf(result); 
            operation.setText("  ");
            
            label_Equation.setText(text + " OR ( " + text2 + " ) = "+s);
           
            text_Area.setText(s);
            text_Area2.clear();
            }
            catch(NumberFormatException e)
            {   
                text_Area2.appendText("  Very Long Number ");
                System.out.println("Number of Exception occured because it is very long number at textArea2!");
            }
            
            }
            catch(NumberFormatException e)
            {   
                text_Area.appendText("  Very Long Number ");
                System.out.println("Number of Exception occured because it is very long number  at textArea !");
            } 
            EQ_FLAG =1;
        }
         else if (AND_FLAG == true)
        {
            String text = text_Area.getText();
            
            try{
            long num1 = 0 ;   
            if (BIN_FLAG == true )
            {
            num1 = Long.parseLong(text,2);
            }
            else if (HEX_FLAG == true )
            {
            num1 = Long.parseLong(text,16);
            }
            else if (OCT_FLAG == true )
            {
            num1 = Long.parseLong(text,8);
            }
            else 
            num1 = Long.parseLong(text);    
            
            String text2 = text_Area2.getText();
            try{
            long num2 = 0 ;   
            if (BIN_FLAG == true )
            {
            num2 = Long.parseLong(text2,2);
            }
            else if (HEX_FLAG == true )
            {
            num2 = Long.parseLong(text2,16);
            }
            else if (OCT_FLAG == true )
            {
            num2 = Long.parseLong(text2,8);
            }
            else 
            num2 = Long.parseLong(text2);    
           
            long result = num1 & num2;
            ans = result;
           
            String s = "0";
              if (BIN_FLAG == true)
            {
             s = Long.toBinaryString(result);//Converting to binary
           
            }
            else if (HEX_FLAG == true)
            {
             s = Long.toHexString(result);  //Convertig to hex
            }
            else if (OCT_FLAG == true)
            {
             s = Long.toOctalString(result);//Converting to octal
            }    
            else
            s = String.valueOf(result); 
            operation.setText("   ");
         
            label_Equation.setText(text + " AND ( " + text2 + " ) = "+s);
            text_Area.setText(s);
            text_Area2.clear();
            }
            catch(NumberFormatException e)
            {   
                text_Area2.appendText("  Very Long Number ");
                System.out.println("Number of Exception occured because it is very long number at textArea2!");
            }
            
            }
            catch(NumberFormatException e)
            {   
                text_Area.appendText("  Very Long Number ");
                System.out.println("Number of Exception occured because it is very long number  at textArea !");
            } 
            
            EQ_FLAG = 1;
        }
        }
        else 
        {
            String s_ans ;
            operation.setText("");
            text_Area2.clear();
             if (BIN_FLAG == true)
            {
             s_ans = Long.toBinaryString(ans);//Converting to binary
           
            }
            else if (HEX_FLAG == true)
            {
             s_ans = Long.toHexString(ans);  //Convertig to hex
            }
            else if (OCT_FLAG == true)
            {
             s_ans = Long.toOctalString(ans);//Converting to octal
            }    
            else
            s_ans = String.valueOf(ans);
            text_Area.setText(s_ans);
        }    
    }    

    @FXML
    private void Concurrent(MouseEvent event) {
    }

}
