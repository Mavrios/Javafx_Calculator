package javafxapplication2;

import java.net.URL;
import java.time.LocalDate;
import java.time.Period;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class FXMLDocumentController implements Initializable {

    int d1, d2, m1, m2, y1, y2;
    long daysCounter, monthsCounter, yearsCounter;
    LocalDate startDate, endDate;
    /*-----------------------------------------------------------------------------------------------------------*/
    @FXML
    private ComboBox<Integer> StartDay;
    @FXML
    private ComboBox<String> StartMonth;
    @FXML
    private ComboBox<Integer> StartYear;
    @FXML
    private ComboBox<Integer> EndDay;
    @FXML
    private ComboBox<String> EndMonth;
    @FXML
    private ComboBox<Integer> EndYear;
    @FXML
    private CheckBox EndDateCheckBox;
    @FXML
    private Button calculateButton;
    @FXML
    private Label StartDataLabel;
    @FXML
    private Label resultLabel;

    public void ToggleEndDate() {                           //switch between two ways of gettin the end date

        if (EndDateCheckBox.isSelected()) {
            EndDay.setDisable(false);
            EndMonth.setDisable(false);
            EndYear.setDisable(false);
        } else {
            EndDay.setDisable(true);
            EndMonth.setDisable(true);
            EndYear.setDisable(true);
        }

    }

    /*-----------------------------------------------------------------------------------------------------------*/

    public void Display() {

        String text = "";

        y1 = Integer.parseInt(StartYear.getSelectionModel().getSelectedItem().toString());                  //get start values 
        m1 = StartMonth.getSelectionModel().getSelectedIndex() + 1;
        d1 = Integer.parseInt(StartDay.getSelectionModel().getSelectedItem().toString());

        if (EndDateCheckBox.isSelected()) {                                                                 //get end values 
            y2 = Integer.parseInt(EndYear.getSelectionModel().getSelectedItem().toString());
            m2 = EndMonth.getSelectionModel().getSelectedIndex() + 1;
            d2 = Integer.parseInt(EndDay.getSelectionModel().getSelectedItem().toString());
        } else {
            y2 = LocalDate.now().getYear();
            m2 = LocalDate.now().getMonthValue();
            d2 = LocalDate.now().getDayOfMonth();
        }
        /*-----------------------------------------------------------------------------------------------------------*/
        startDate = LocalDate.of(y1, m1, d1);
        endDate = LocalDate.of(y2, m2, d2);

        yearsCounter = Period.between(startDate, endDate).getYears();
        monthsCounter = Period.between(startDate, endDate).getMonths();
        daysCounter = Period.between(startDate, endDate).getDays();

        if (yearsCounter == 0 && monthsCounter == 0 && daysCounter == 0) {               //same date
            resultLabel.setTextFill(Color.RED);
            resultLabel.setText("Cannot compare same date!");
        } else if (!Period.between(startDate, endDate).isNegative()) {                  //years handling
            if (yearsCounter == 1) {
                text += yearsCounter + " year ";
            } else if (yearsCounter > 1) {
                text += yearsCounter + " years ";
            }
            if (monthsCounter == 1) {                                                   //one month handling
                if (yearsCounter > 0 && daysCounter > 0) {
                    text += ", " + monthsCounter + " month ";
                } else if (yearsCounter > 0 && daysCounter == 0) {
                    text += "and " + monthsCounter + " month ";
                } else {
                    text += monthsCounter + " month ";
                }
            }
            if (monthsCounter > 1) {                                                    //more than one month handling
                if (yearsCounter > 0 && daysCounter > 0) {
                    text += ", " + monthsCounter + " months ";
                } else if (yearsCounter > 0 && daysCounter == 0) {
                    text += "and " + monthsCounter + " months ";
                } else {
                    text += monthsCounter + " months ";
                }
            }
            if (daysCounter == 1) {                                                     //one day handling
                if (yearsCounter == 0 && monthsCounter == 0) {
                    text += daysCounter + " day";
                } else {
                    text += "and " + daysCounter + " day";
                }
            }
            if (daysCounter > 1) {                                                       //more than one day handling
                if (yearsCounter == 0 && monthsCounter == 0) {
                    text += daysCounter + " days";
                } else {
                    text += "and " + daysCounter + " days";
                }
            }                                                                           //Display result
            resultLabel.setAlignment(Pos.CENTER);
            resultLabel.setTextFill(Color.WHITE);
            resultLabel.setText(text);
        } else {
            resultLabel.setAlignment(Pos.CENTER);
            resultLabel.setTextFill(Color.RED);                                         //Display Wrong result
            resultLabel.setText("Logic order of Dates is wrong!");
        }
    }

    /*-----------------------------------------------------------------------------------------------------------*/
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun",                    //array of months
            "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

        Integer[] days = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, //array of days
            11, 12, 13, 14, 15, 16, 17, 18, 19, 20,
            21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31};

        int currentYear = LocalDate.now().getYear();
        Integer[] years = new Integer[currentYear];

        for (int i = 0; i < currentYear; i++) {
            years[currentYear - i - 1] = i + 1;
        }

        StartDay.setItems(FXCollections.observableArrayList(days));
        StartDay.getSelectionModel().select(0);
        StartMonth.setItems(FXCollections.observableArrayList(months));
        StartMonth.getSelectionModel().select(0);
        StartYear.setItems(FXCollections.observableArrayList(years));
        StartYear.getSelectionModel().select(0);
        EndDay.setItems(FXCollections.observableArrayList(days));
        EndDay.getSelectionModel().select(0);
        EndMonth.setItems(FXCollections.observableArrayList(months));
        EndMonth.getSelectionModel().select(0);
        EndYear.setItems(FXCollections.observableArrayList(years));
        EndYear.getSelectionModel().select(0);
        ToggleEndDate();
    }

    /*-----------------------------------------------------------------------------------------------------------*/
    @FXML
    private void EndDateCheckBox(MouseEvent event) {
        ToggleEndDate();
    }

    @FXML
    private void calculateButton(MouseEvent event) {
        Display();
    }

    @FXML
    private void handleButton(KeyEvent event) {
    }

}
