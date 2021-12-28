/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main_pkg;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
/**
 *
 * @author Fady
 */
public class Calculator extends Application {
    Button num_0;
    Button num_1;
    Button num_2;
    Button num_3;
    Button num_4;
    Button num_5;
    Button num_6;
    Button num_7;
    Button num_8;
    Button num_9;
    Button plus;
    Button minus;
    Button equal;
    Button div;
    Button pow;
    Button dott;
    
    /*----------------Menu----------------*/
    MenuBar bar;
    Menu file;
    MenuItem convert;
    /*------------------------------------*/
    
    HBox hbox1;
    HBox hbox2;
    HBox hbox3;
    HBox hbox4;
    VBox vbox;
    
    TextField TA;
    
    FlowPane flow;
    FlowPane flow2;
    BorderPane root2;
    BorderPane root;
    
    String equ;
    String res;
    ScriptEngineManager mgr ;
    ScriptEngine engine;
    
    Scene scene;
    Scene scene2;
        
    
    @Override
    public void init() throws Exception {
        num_0 = new Button("0");
        num_1 = new Button("1");
        num_2 = new Button("2");
        num_3 = new Button("3");
        num_4 = new Button("4");
        num_5 = new Button("5");
        num_6 = new Button("6");
        num_7 = new Button("7");
        num_8 = new Button("8");
        num_9 = new Button("9");
        plus = new Button("+");
        minus = new Button("-");
        equal = new Button("=");
        dott = new Button(".");
        pow = new Button("x");
        div = new Button("/");
        
        hbox1 = new HBox(10);
        hbox1.getChildren().addAll(num_1,num_2,num_3,plus);
        hbox1.fillHeightProperty();
        int size = hbox1.getChildren().size();
        num_1.prefWidthProperty().bind(hbox1.widthProperty().divide(size));
        num_2.prefWidthProperty().bind(hbox1.widthProperty().divide(size));
        num_3.prefWidthProperty().bind(hbox1.widthProperty().divide(size));
        plus.prefWidthProperty().bind(hbox1.widthProperty().divide(size));
        
        hbox2 = new HBox(10);
        hbox2.getChildren().addAll(num_4,num_5,num_6,minus);
        hbox2.fillHeightProperty();
        size = hbox2.getChildren().size();
        num_4.prefWidthProperty().bind(hbox2.widthProperty().divide(size));
        num_5.prefWidthProperty().bind(hbox2.widthProperty().divide(size));
        num_6.prefWidthProperty().bind(hbox2.widthProperty().divide(size));
        minus.prefWidthProperty().bind(hbox2.widthProperty().divide(size));
        
        hbox3 = new HBox(10);
        hbox3.getChildren().addAll(num_7,num_8,num_9,pow);
        hbox3.fillHeightProperty();
        size = hbox3.getChildren().size();
        num_7.prefWidthProperty().bind(hbox3.widthProperty().divide(size));
        num_8.prefWidthProperty().bind(hbox3.widthProperty().divide(size));
        num_9.prefWidthProperty().bind(hbox3.widthProperty().divide(size));
        pow.prefWidthProperty().bind(hbox3.widthProperty().divide(size));
        
        hbox4 = new HBox(10);
        hbox4.getChildren().addAll(dott,num_0,equal,div);
        hbox4.fillHeightProperty();
        size = hbox4.getChildren().size();
        dott.prefWidthProperty().bind(hbox4.widthProperty().divide(size));
        num_0.prefWidthProperty().bind(hbox4.widthProperty().divide(size));
        equal.prefWidthProperty().bind(hbox4.widthProperty().divide(size));
        div.prefWidthProperty().bind(hbox4.widthProperty().divide(size));
        
        vbox = new VBox(10);
        vbox.getChildren().addAll(hbox1,hbox2,hbox3,hbox4);
        vbox.fillWidthProperty();
        vbox.setPrefHeight(300);
        vbox.setPrefWidth(300);
        size = vbox.getChildren().size();
        num_0.prefHeightProperty().bind(vbox.heightProperty().divide(size));
        num_1.prefHeightProperty().bind(vbox.heightProperty().divide(size));
        num_2.prefHeightProperty().bind(vbox.heightProperty().divide(size));
        num_3.prefHeightProperty().bind(vbox.heightProperty().divide(size));
        num_4.prefHeightProperty().bind(vbox.heightProperty().divide(size));
        num_5.prefHeightProperty().bind(vbox.heightProperty().divide(size));
        num_6.prefHeightProperty().bind(vbox.heightProperty().divide(size));
        num_7.prefHeightProperty().bind(vbox.heightProperty().divide(size));
        num_8.prefHeightProperty().bind(vbox.heightProperty().divide(size));
        num_9.prefHeightProperty().bind(vbox.heightProperty().divide(size));
        dott.prefHeightProperty().bind(vbox.heightProperty().divide(size));
        div.prefHeightProperty().bind(vbox.heightProperty().divide(size));
        pow.prefHeightProperty().bind(vbox.heightProperty().divide(size));
        equal.prefHeightProperty().bind(vbox.heightProperty().divide(size));
        plus.prefHeightProperty().bind(vbox.heightProperty().divide(size));
        minus.prefHeightProperty().bind(vbox.heightProperty().divide(size));
        
        
        TA = new TextField();
        TA.setStyle("-fx-font-size: 24");
        TA.setPrefHeight(80);
        
        TA.textProperty().addListener(new ChangeListener<String> () {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                //if(!newValue.matches("\\d*"))
                if(!newValue.matches("[0-9*/+-.]+$"))
                {
                    //TA.setText(newValue.replaceAll("[^\\d]", ""));
                    TA.setText(newValue.replaceAll("[^0-9*/+-]+$", ""));
                }
            }
        } );
        
        /*--------------------Menu-----------------------*/
        bar = new MenuBar();
        file = new Menu("Converter");
        convert = new MenuItem("Volume");
        file.getItems().add(convert);
        bar.getMenus().add(file);
        flow = new FlowPane();
        flow.getChildren().add(bar);
        flow.getChildren().add(TA);
        
        /*flow2 = new FlowPane();
        flow2.getChildren().add(bar);
        flow2.getChildren().add(TA);*/
        root2 = new BorderPane();
        //root2.setTop(flow2);
        /*-----------------------------------------------*/
        
        root = new BorderPane(vbox);
        root.setTop(flow);
        
        
        /* ------------------Button Handling------------------*/
        /* ------------------Equal Button---------------------*/
        mgr = new ScriptEngineManager();
        engine = mgr.getEngineByName("JavaScript");
        equal.setDefaultButton(true);
        equal.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                equ = TA.getText();
                try {
                    TA.setText(engine.eval(equ).toString());

                } catch (ScriptException ex) {
                    TA.setText("Undefined!!");
                }
               
            }
        } );
        
        /* -------------------------num_0--------------------------*/
        num_0.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                TA.appendText("0");
            }
        } );
        
        /* -------------------------num_1--------------------------*/
        num_1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                TA.appendText("1");
            }
        } );
        
        /* -------------------------num_2--------------------------*/
        num_2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                TA.appendText("2");
            }
        } );
        
        /* -------------------------num_3--------------------------*/
        num_3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                TA.appendText("3");
            }
        } );
        
        /* -------------------------num_4--------------------------*/
        num_4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                TA.appendText("4");
            }
        } );
        
        /* -------------------------num_5--------------------------*/
        num_5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                TA.appendText("5");
            }
        } );
        
        /* -------------------------num_6--------------------------*/
        num_6.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                TA.appendText("6");
            }
        } );
        
        /* -------------------------num_7--------------------------*/
        num_7.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                TA.appendText("7");
            }
        } );
        
        /* -------------------------num_8--------------------------*/
        num_8.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                TA.appendText("8");
            }
        } );
        
        /* -------------------------num_9--------------------------*/
        num_9.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                TA.appendText("9");
            }
        } );
        
        /* -------------------------dott--------------------------*/
        dott.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                TA.appendText(".");
            }
        } );
        
        /* -------------------------plus--------------------------*/
        plus.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                TA.appendText("+");
            }
        } );
        
        /* -------------------------minus--------------------------*/
        minus.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                TA.appendText("-");
            }
        } );
        
        /* -------------------------multiply--------------------------*/
        pow.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                TA.appendText("*");
            }
        } );
        
        /* -------------------------divide--------------------------*/
        div.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                TA.appendText("/");
            }
        } );
    }
    
    @Override
    public void start(Stage primaryStage) {
        /*-------------------------------------------*/
        int flag = 1;
        scene2 = new Scene(root2,300,300);
        /*-------------------------------------------*/
        
        
        scene = new Scene(root,300,300);
         //-----------------testing keyboard input----------------//
         /*-----------------BackSpace-----------------------------*/
         scene.setOnKeyPressed(new EventHandler<KeyEvent> () {
             @Override
             public void handle(KeyEvent event) {
                 if(event.getCode()==KeyCode.BACK_SPACE)
                 {
                     TA.deletePreviousChar();
                 }
                 else
                    TA.appendText(event.getText());   
             }
         });
         
         primaryStage.setTitle("Calculator");
         if(flag==0)
             primaryStage.setScene(scene2);
         else
         {
            primaryStage.setScene(scene);
            primaryStage.setMinHeight(vbox.getPrefHeight());
            primaryStage.setMinWidth(vbox.getPrefWidth());
         }
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
