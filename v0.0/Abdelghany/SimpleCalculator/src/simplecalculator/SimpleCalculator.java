package simplecalculator;

import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import static javafx.scene.input.KeyCode.*;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class SimpleCalculator extends Application {

    TextField textField;
    Button b0, b1, b2, b3, b4;
    Button b5, b6, b7, b8, b9;
    Button equal, clear, dot;
    Button minus, plus;
    Button multiple, divide;
    private boolean flag = false;
    Integer x = new Integer(5);
    
    
    @Override
    public void start(Stage primaryStage) {

        /**
         * ************************* Buttons *************************
         */
        b0 = new Button(" 0 ");
        b0.setFont(Font.font(18));
        b0.setPrefSize(115, 50);
        /*------------------------------------------------------------*/
        b1 = new Button(" 1 ");
        b1.setPrefSize(50, 50);
        b1.setFont(Font.font(18));
        /*------------------------------------------------------------*/
        b2 = new Button(" 2 ");
        b2.setPrefSize(50, 50);
        b2.setFont(Font.font(18));
        /*------------------------------------------------------------*/
        b3 = new Button(" 3 ");
        b3.setPrefSize(50, 50);
        b3.setFont(Font.font(18));
        /*------------------------------------------------------------*/
        b4 = new Button(" 4 ");
        b4.setPrefSize(50, 50);
        b4.setFont(Font.font(18));
        /*------------------------------------------------------------*/
        b5 = new Button(" 5 ");
        b5.setPrefSize(50, 50);
        b5.setFont(Font.font(18));
        /*------------------------------------------------------------*/
        b6 = new Button(" 6 ");
        b6.setPrefSize(50, 50);
        b6.setFont(Font.font(18));
        /*------------------------------------------------------------*/
        b7 = new Button(" 7 ");
        b7.setPrefSize(50, 50);
        b7.setFont(Font.font(18));
        /*------------------------------------------------------------*/
        b8 = new Button(" 8 ");
        b8.setPrefSize(50, 50);
        b8.setFont(Font.font(18));
        /*------------------------------------------------------------*/
        b9 = new Button(" 9 ");
        b9.setPrefSize(50, 50);
        b9.setFont(Font.font(18));
        /*------------------------------------------------------------*/
        equal = new Button(" = ");
        equal.setPrefSize(175, 50);
        equal.setFont(Font.font(18));
        /*------------------------------------------------------------*/
        clear = new Button(" C ");
        clear.setPrefSize(50, 50);
        clear.setFont(Font.font(18));
        /*------------------------------------------------------------*/
        multiple = new Button(" x ");
        multiple.setPrefSize(50, 50);
        multiple.setFont(Font.font(18));
        /*------------------------------------------------------------*/
        minus = new Button(" - ");
        minus.setPrefSize(50, 50);
        minus.setFont(Font.font(18));
        /*------------------------------------------------------------*/
        plus = new Button(" + ");
        plus.setPrefSize(50, 50);
        plus.setFont(Font.font(18));
        /*------------------------------------------------------------*/
        divide = new Button(" / ");
        divide.setPrefSize(50, 50);
        divide.setFont(Font.font(18));
        /*------------------------------------------------------------*/
        dot = new Button(" . ");
        dot.setPrefSize(50, 50);
        dot.setFont(Font.font(18));

        /**
         * *********************** Text field ************************
         */
        textField = new TextField(" ");
        textField.setFont(Font.font(18));
        textField.setPrefHeight(80);
        textField.setAlignment(Pos.CENTER_RIGHT);
        textField.setEditable(false);

        /**
         * ************************** Actions *************************
         */
        b0.addEventHandler(ActionEvent.ACTION, (ActionEvent e) -> {
            if (flag == true) {
                textField.clear();
                flag = false;
            }
            textField.appendText("0");
        }
        );
        /*------------------------------------------------------------*/
        b1.addEventHandler(ActionEvent.ACTION, (ActionEvent e) -> {
            if (flag == true) {
                textField.clear();
                flag = false;
            }
            textField.appendText("1");
        });
        /*------------------------------------------------------------*/
        b2.addEventHandler(ActionEvent.ACTION, (ActionEvent e) -> {
            if (flag == true) {
                textField.clear();
                flag = false;
            }
            textField.appendText("2");
        });
        /*------------------------------------------------------------*/
        b3.addEventHandler(ActionEvent.ACTION, (ActionEvent e) -> {
            if (flag == true) {
                textField.clear();
                flag = false;
            }
            textField.appendText("3");
        });
        /*------------------------------------------------------------*/
        b4.addEventHandler(ActionEvent.ACTION, (ActionEvent e) -> {
            if (flag == true) {
                textField.clear();
                flag = false;
            }
            textField.appendText("4");
        });
        /*------------------------------------------------------------*/
        b5.addEventHandler(ActionEvent.ACTION, (ActionEvent e) -> {
            if (flag == true) {
                textField.clear();
                flag = false;
            }
            textField.appendText("5");
        });
        /*------------------------------------------------------------*/
        b6.addEventHandler(ActionEvent.ACTION, (ActionEvent e) -> {
            if (flag == true) {
                textField.clear();
                flag = false;
            }
            textField.appendText("6");
        });
        /*------------------------------------------------------------*/
        b7.addEventHandler(ActionEvent.ACTION, (ActionEvent e) -> {
            if (flag == true) {
                textField.clear();
                flag = false;
            }
            textField.appendText("7");
        });
        /*------------------------------------------------------------*/
        b8.addEventHandler(ActionEvent.ACTION, (ActionEvent e) -> {
            if (flag == true) {
                textField.clear();
                flag = false;
            }
            textField.appendText("8");
        });
        /*------------------------------------------------------------*/
        b9.addEventHandler(ActionEvent.ACTION, (ActionEvent e) -> {
            if (flag == true) {
                textField.clear();
                flag = false;
            }
            textField.appendText("9");
        });
        /*------------------------------------------------------------*/
        clear.addEventHandler(ActionEvent.ACTION, (ActionEvent e) -> {
            textField.clear();
        });
        /*------------------------------------------------------------*/
        minus.addEventHandler(ActionEvent.ACTION, (ActionEvent e) -> {
            textField.appendText("-");
        });
        /*------------------------------------------------------------*/
        plus.addEventHandler(ActionEvent.ACTION, (ActionEvent e) -> {
            textField.appendText("+");
        });
        /*------------------------------------------------------------*/
        multiple.addEventHandler(ActionEvent.ACTION, (ActionEvent e) -> {
            textField.appendText("*");
        });
        /*------------------------------------------------------------*/
        divide.addEventHandler(ActionEvent.ACTION, (ActionEvent e) -> {
            textField.appendText("/");
        });
        /*------------------------------------------------------------*/
        dot.addEventHandler(ActionEvent.ACTION, (ActionEvent e) -> {
            if (flag == true) {
                textField.clear();
                flag = false;
            }
            textField.appendText(".");
        });
        /*------------------------------------------------------------*/
        equal.addEventHandler(ActionEvent.ACTION, (ActionEvent e) -> {
            flag = true;
            ScriptEngineManager mgr = new ScriptEngineManager();
            ScriptEngine engine = mgr.getEngineByName("JavaScript");
            try {
                textField.setText(engine.eval(textField.getText()).toString());
            } catch (ScriptException ex) {
                textField.setText("ERROR!!");
            }
        });

        /**
         * ************************* Display *************************
         */
        textField.clear();
        HBox row1 = new HBox(12, b7, b8, b9, plus);
        HBox row2 = new HBox(12, b4, b5, b6, minus);
        HBox row3 = new HBox(12, b1, b2, b3, multiple);
        HBox row4 = new HBox(12, b0, dot, divide);
        HBox row5 = new HBox(12, equal, clear);
        VBox vbox = new VBox(12, textField, row1, row2, row3, row4, row5);
        Scene scene = new Scene(vbox, 236, 320);
        scene.addEventFilter(KeyEvent.KEY_PRESSED, e  -> {

            if (null != e.getCode()) {
                switch (e.getCode()) {
                    case NUMPAD0:
                        if (flag == true) {
                            textField.clear();
                            flag = false;
                        }
                        textField.appendText("0");
                        break;

                    case NUMPAD1:
                        if (flag == true) {
                            textField.clear();
                            flag = false;
                        }
                        textField.appendText("1");
                        break;

                    case NUMPAD2:
                        if (flag == true) {
                            textField.clear();
                            flag = false;
                        }
                        textField.appendText("2");
                        break;

                    case NUMPAD3:
                        if (flag == true) {
                            textField.clear();
                            flag = false;
                        }
                        textField.appendText("3");
                        break;

                    case NUMPAD4:
                        if (flag == true) {
                            textField.clear();
                            flag = false;
                        }
                        textField.appendText("4");
                        break;

                    case NUMPAD5:
                        if (flag == true) {
                            textField.clear();
                            flag = false;
                        }
                        textField.appendText("5");
                        break;

                    case NUMPAD6:
                        if (flag == true) {
                            textField.clear();
                            flag = false;
                        }
                        textField.appendText("6");
                        break;

                    case NUMPAD7:
                        if (flag == true) {
                            textField.clear();
                            flag = false;
                        }
                        textField.appendText("7");
                        break;

                    case NUMPAD8:
                        if (flag == true) {
                            textField.clear();
                            flag = false;
                        }
                        textField.appendText("8");
                        break;

                    case NUMPAD9:
                        if (flag == true) {
                            textField.clear();
                            flag = false;
                        }
                        textField.appendText("9");
                        break;
                    case ENTER:
                        flag = true;
                        ScriptEngineManager mgr = new ScriptEngineManager();
                        ScriptEngine engine = mgr.getEngineByName("JavaScript");
                        try {
                            textField.setText(engine.eval(textField.getText()).toString());
                        } catch (ScriptException ex) {
                            textField.setText("ERROR!!");
                        }

                        break;

                    case DELETE:
                        textField.clear();
                        break;
                    
                    default :
                        textField.appendText(e.getText()); 
                        break;
                }
            }
        });

        primaryStage.setTitle("Calculator 👽");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
