/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package calculator;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 *
 * @author lenovo2
 */
public class CalcApp extends Application{
    /*Refrences*/
    Scene scene;
    TextField eqn;
    TilePane buttons1;
    TilePane buttons2;
    TilePane buttons3;
    TilePane buttons4;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    Button button7;
    Button button8;
    Button button9;
    Button button0;
    Button buttonAdd;
    Button buttonSub;
    Button buttonMul;
    Button buttonDiv;
    Button buttonEq;
    Button buttonDel;
    Button buttonCos;
    Button buttonSin;
    Button buttonSqrt;
    Button buttonPow;
    ScriptEngineManager mgr;
    ScriptEngine engine;
    GridPane gridPane;
    /*              Function To set Buttons           */
    private void createButtons() {
         /*          Tile Panes          */
        buttons1 = new TilePane();
        buttons2 = new TilePane();
        buttons3 = new TilePane();
        buttons4 = new TilePane();
        /*         Width&Height         */
        buttons1.setPrefTileHeight(60);
        buttons1.setPrefTileWidth(60);
        buttons2.setPrefTileHeight(60);
        buttons2.setPrefTileWidth(60);
        buttons3.setPrefTileHeight(60);
        buttons3.setPrefTileWidth(60);
        buttons4.setPrefTileHeight(60);
        buttons4.setPrefTileWidth(60);
        /*             Buttons            */
        button1 = new Button("1");
        button2 = new Button("2");
        button3 = new Button("3");
        button4 = new Button("4");
        button5 = new Button("5");
        button6 = new Button("6");
        button7 = new Button("7");
        button8 = new Button("8");
        button9 = new Button("9");
        button0 = new Button("0");
        buttonAdd = new Button("+");
        buttonSub = new Button("-");
        buttonMul = new Button("*");
        buttonDiv = new Button("/");
        buttonEq = new Button("=");
        buttonDel = new Button("c");
        buttonCos = new Button("cos");
        buttonSin = new Button("Sin");
        buttonSqrt = new Button("√");
        buttonPow = new Button("x²");
        /*          Add Butons to Tile Panes          */
        buttons1.getChildren().addAll(button1, button2, button3, button4, buttonSin);
        buttons2.getChildren().addAll(button5, button6, button7, button8, buttonCos);
        buttons3.getChildren().addAll(button9, button0, buttonAdd, buttonSub, buttonSqrt);
        buttons4.getChildren().addAll(buttonMul, buttonDiv, buttonEq, buttonDel, buttonPow);

    }

    @Override
    public void init() {
        /*              Grid Settings                */
        gridPane = new GridPane();
        gridPane.setMinSize(400, 400);
        gridPane.setVgap(5);
        gridPane.setHgap(5);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setStyle("-fx-background-color: black; -fx-padding: 20; -fx-font-size: 20;");
        /*        Evaluatig Equations Engine         */
        mgr = new ScriptEngineManager();
        engine = mgr.getEngineByName("JavaScript");
        /*             Create Buttons               */
        createButtons();
        /*              Text Field                  */
        eqn = new TextField();
        eqn.setEditable(false);

    }

    @Override
    public void start(Stage primaryStage) throws ScriptException {
        /*                 Handle KeyEvents                     */
        gridPane.addEventFilter(KeyEvent.KEY_PRESSED, keyEvent -> {
            String activated = keyEvent.getText();
            eqn.appendText(activated); // Must filter characters
        });
        /*                     Nums                         */
        button0.setOnAction((ActionEvent event) -> {
            eqn.appendText("0");
        });
        button1.setOnAction((ActionEvent event) -> {
            eqn.appendText("1");
        });
        button2.setOnAction((ActionEvent event) -> {
            eqn.appendText("2");
        });
        button3.setOnAction((ActionEvent event) -> {
            eqn.appendText("3");
        });
        button4.setOnAction((ActionEvent event) -> {
            eqn.appendText("4");
        });
        button5.setOnAction((ActionEvent event) -> {
            eqn.appendText("5");
        });
        button6.setOnAction((ActionEvent event) -> {
            eqn.appendText("6");
        });
        button7.setOnAction((ActionEvent event) -> {
            eqn.appendText("7");
        });
        button8.setOnAction((ActionEvent event) -> {
            eqn.appendText("8");
        });
        button9.setOnAction((ActionEvent event) -> {
            eqn.appendText("9");
        });
        /*                     Operations                         */
        buttonAdd.setOnAction((ActionEvent event) -> {
            eqn.appendText("+");
        });
        buttonSub.setOnAction((ActionEvent event) -> {
            eqn.appendText("-");
        });
        buttonMul.setOnAction((ActionEvent event) -> {
            eqn.appendText("*");
        });
        buttonDiv.setOnAction((ActionEvent event) -> {
            eqn.appendText("/");
        });
//        buttonSin.setOnAction((ActionEvent event) -> {
//            eqn.appendText("sin");
//        });
//        buttonCos.setOnAction((ActionEvent event) -> {
//            eqn.appendText("cos");
//        });
//        buttonSqrt.setOnAction((ActionEvent event) -> {
//            eqn.appendText("sqrt");
//        });
//        buttonPow.setOnAction((ActionEvent event) -> {
//            eqn.appendText("pow");
//        });

        buttonEq.setOnAction((ActionEvent event) -> {
//            String tmp;
//            tmp = eqn.getText().replace("sin", "Math.sin").
//                    replace("cos", "Math.cos").
//                    replace("tan", "Math.tan").
//                    replace("sqrt", "Math.sqrt").
//                    replace("sqr", "Math.pow").
//                    replace("log", "Math.log") ;
            try {
                eqn.setText(engine.eval(eqn.getText()).toString());
                System.out.println(engine.eval("Math.sqrt(25)"));
            } catch (ScriptException ex) {
                Logger.getLogger(CalcApp.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        buttonDel.setOnAction((ActionEvent event) -> {
            eqn.clear();
        });
        /*       Set position of nodes on pane       */
        gridPane.add(buttons1, 0, 1);
        gridPane.add(buttons2, 0, 2);
        gridPane.add(buttons3, 0, 3);
        gridPane.add(buttons4, 0, 4);
        gridPane.add(eqn, 0, 0);
        /*       Send pane to scene       */
        scene = new Scene(gridPane, 400, 400);
        /*         Send Scene to Stage and Show stage         */
        primaryStage.setTitle("Area51-Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
