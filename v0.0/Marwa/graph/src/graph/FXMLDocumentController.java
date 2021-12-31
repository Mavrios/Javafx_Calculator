/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package graph;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 *
 * @author lenovo2
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private LineChart<String, Number> lineChart;
    @FXML
    private Button PlotBtn;
    @FXML
    private TextArea plotEqn;
    @FXML
    private TextField startTF;
    @FXML
    private TextField endTF;
    String Yaxis = "";
    String Xaxis = "";
    String endPt = "50";
    int range = 50;
    String eqn = "";
    String eqnTmp = "";
    Double y = 0.0;

    @FXML
    private void Plot(ActionEvent event) throws ScriptException {
        eqn = plotEqn.getText();
        eqnTmp = plotEqn.getText();
        System.out.println(eqn);
        XYChart.Series<String, Number> series = new XYChart.Series<String, Number>();
        int i;
        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("JavaScript");
        if (!startTF.getText().isEmpty()) {
            Xaxis = startTF.getText();
        } else {
            Xaxis = "0";
        }
        if (!endTF.getText().isEmpty()) {
            endPt = endTF.getText();
            range = Math.abs(Integer.parseInt(Xaxis) - Integer.parseInt(endPt));
        }

        for (i = 1; i <= range; i++) {
            Xaxis = Xaxis + "+1"; // + "(" + String.format("%d", rand.nextInt(5)) + ")";
            Xaxis = String.format("%.2f", Double.parseDouble(engine.eval(Xaxis).toString()));
            eqn = eqn.replace("x", Xaxis);
            try {
                if (!plotEqn.getText().isEmpty()) {
                    y = Double.parseDouble(engine.eval(eqn).toString());
                }
            } catch (ScriptException e) {
                plotEqn.setText("Undefined!!");
                lineChart.getData().clear();
            }
            System.out.println(Xaxis + " " + y);
            series.getData().add(new XYChart.Data<String, Number>(Xaxis, y));
            eqn = eqnTmp;
        }

        Xaxis = "0";
        y = 0.0;

        lineChart.getData().add(series);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
