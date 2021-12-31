/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
//import javafx.scene.image.Image;
import javafx.scene.image.*;

/**
 *
 * @author NoteBook
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private ChoiceBox<String> Choice_Box;
    @FXML
    private Label Choice_Label;
    
    private String[] calc_Menue = {"Standard","Programmer","Scientific" ,"Currency"};
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // TODO
        Choice_Box.getItems().addAll(calc_Menue);
        Choice_Box.setOnAction(this::get_calc_Item);
    }    
    
    public void get_calc_Item(ActionEvent event)
    {
        String My_calc_Item =  Choice_Box.getValue();
        Choice_Label.setText(My_calc_Item);
    }
}
