package ung.mccb.csci.csci330.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import ung.mccb.csci.csci330.model.Car;

public class Controller {
    @FXML
    TextField txtTag, txtModel, txtMake, txtYear, txtColor;
    public void submitRecord(ActionEvent actionEvent) {
        Car model = new Car();
        model.setTag(txtTag.getText());
        model.setModel(txtModel.getText());
        model.setMake(txtMake.getText());
        model.setYear(txtYear.getText());
        model.setColor(txtColor.getText());

        int result = model.saveRecord();


    }
}
