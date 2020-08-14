package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class ControlsController {

    ToggleGroup toggleGroup;
    @FXML
    ToggleButton tbBlau;
    @FXML
    ToggleButton tbRoig;
    @FXML
    ToggleButton tbVerd;


    @FXML
    Rectangle rectangle;

    @FXML
    private void handleButtonBlue(ActionEvent event){
        if (tbBlau.isSelected()){
            rectangle.setFill(Color.BLUE);
        }

    }

    public void handleButtonRed(ActionEvent actionEvent) {
        if (tbRoig.isSelected()){
            rectangle.setFill(Color.RED);
        }
    }

    public void handleButtonGreen(ActionEvent actionEvent) {
        if (tbVerd.isSelected()){
            rectangle.setFill(Color.GREEN);
        }
    }
}

