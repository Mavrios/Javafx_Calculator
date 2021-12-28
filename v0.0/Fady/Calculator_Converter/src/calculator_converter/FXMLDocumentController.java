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
    private ComboBox<?> box1;
    @FXML
    private ComboBox<?> box2;
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
        Converter();
    }
    
    /*------------------*/
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loaddata();
    }    
    
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


    @FXML
    private void Change(KeyEvent event) {
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
    
    
    
    @FXML
    public void Converter()
    {
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
    
}
