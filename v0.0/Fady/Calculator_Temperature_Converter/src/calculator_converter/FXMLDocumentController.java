/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator_converter;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 *
 * @author Fady
 */
public class FXMLDocumentController implements Initializable {

    ObservableList list = FXCollections.observableArrayList();
    
    @FXML
    public TextField TA1;
    @FXML
    private TextField TA2;
    @FXML
    private ComboBox<String> box1;
    @FXML
    private ComboBox<String> box2;
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
        Converter2();
    }
    
    /*------------------*/
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loaddata2();
    }    
    
    public void loaddata2()
    {
        list.removeAll(list);
        String celsius = "Celsius";
        String fahr = "Fahrenheit";
        String kel = "Kelvin";
        
        list.addAll(celsius,fahr,kel);
        box1.getItems().addAll(list);
        box1.getSelectionModel().selectFirst();
        box2.getItems().addAll(list);
        box2.getSelectionModel().selectFirst();
    }


    @FXML
    private void Change2(KeyEvent event) {
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
    
        Converter2();
    }
    
    
    
    @FXML
    public void Converter2()
    {
        double res;
        double data;
        /*---------Celsius--------*/
        if(box1.getValue()=="Celsius")
        {
            if(box2.getValue()=="Celsius")  //Celsius
            {
                TA2.setText(TA1.getText());
            }
            else if(box2.getValue()=="Fahrenheit") //Fahrenheit
            {
                if(!TA1.getText().isEmpty())
                {
                    data = Double.parseDouble(TA1.getText());
                    res = (data*9/5)+32;
                    TA2.setText(Double.toString(res));
                }
                else
                {
                    res = (0*9/5)+32;
                    TA2.setText(Double.toString(res));
                }
            }
            else if(box2.getValue()=="Kelvin") //Kelvin
            {
                if(!TA1.getText().isEmpty())
                {
                    data = Double.parseDouble(TA1.getText());
                    res = data+273.15;
                    TA2.setText(Double.toString(res));
                }
                else
                {
                    res = 0+273.15;
                    TA2.setText(Double.toString(res));
                }
            }
            
        }   
        
        /*--------Fahrenheit---------*/
        if(box1.getValue()=="Fahrenheit")
        {
            if(box2.getValue()=="Celsius")  //Celsius
            {
                if(!TA1.getText().isEmpty())
                {
                    data = Double.parseDouble(TA1.getText());
                    res = (data-32)*5.0/9;
                    TA2.setText(Double.toString(res));
                }
                else
                {
                    res = (0-32)*5.0/9;
                    TA2.setText(Double.toString(res));
                }
            }
            else if(box2.getValue()=="Fahrenheit") //Fahrenheit
            {
                TA2.setText(TA1.getText());
            }
            else if(box2.getValue()=="Kelvin") //Kelvin
            {
                if(!TA1.getText().isEmpty())
                {
                    data = Double.parseDouble(TA1.getText());
                    res = (data-32)*5.0/9 + 273.15;
                    TA2.setText(Double.toString(res));
                }
                else
                {
                    res = (0-32)*5/9 + 273.15;
                    TA2.setText(Double.toString(res));
                }
            }
            
        }
        
        /*--------Kelvin---------*/
        if(box1.getValue()=="Kelvin")
        {
            if(box2.getValue()=="Celsius")  //Celsius
            {
                if(!TA1.getText().isEmpty())
                {
                    data = Double.parseDouble(TA1.getText());
                    res = data-273.15;
                    TA2.setText(Double.toString(res));
                }
                else
                {
                    res = 0-273.15;
                    TA2.setText(Double.toString(res));
                }
            }
            else if(box2.getValue()=="Fahrenheit") //Fahrenheit
            {
                if(!TA1.getText().isEmpty())
                {
                    data = Double.parseDouble(TA1.getText());
                    res = (data-273.15)*9/5 + 32;
                    TA2.setText(Double.toString(res));
                }
                else
                {
                    res = (0-273.15)*9/5 + 32;
                    TA2.setText(Double.toString(res));
                }
            }
            else if(box2.getValue()=="Kelvin") //Kelvin
            {
                TA2.setText(TA1.getText());
            }   
        }
    }
}
