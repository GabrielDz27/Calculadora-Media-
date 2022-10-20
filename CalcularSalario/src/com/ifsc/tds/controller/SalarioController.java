package com.ifsc.tds.controller;

import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class SalarioController {

    @FXML
    private Label lblResultado;

    @FXML
    private TextField txtHoras;

    @FXML
    private TextField txtSalario;

    @FXML
    private Button bntCalcular;

    @FXML
    private Button bntLimpar;

    @FXML
    void onClickCalcular(ActionEvent event) {
    	try {
        	double horas = Double.parseDouble(txtHoras.getText());
        	double salario = Double.parseDouble(txtSalario.getText());
        	double resultado = Double.parseDouble(lblResultado.getText());
        	double horasextras;
        	horasextras = horas - 160;
        	resultado += horas * salario;
        	resultado += horasextras *(salario*1.5);
        	
        	lblResultado.setText(""+resultado);

        	
    	} catch (Exception e) {
    		
    	}

    }

    @FXML
    void onClickLimpar(ActionEvent event) {
    	txtHoras.setText("");
    	txtSalario.setText("");
    	lblResultado.setText("0");
    	
 
    }

	public boolean onCloseQuery() {
		Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
    	alert.setTitle("Pergunta");
    	ButtonType btnNo = ButtonType.NO;
    	ButtonType btnYes = ButtonType.YES;
    	
    	alert.getButtonTypes().setAll(btnYes, btnNo);
    	Optional<ButtonType> optionSelected = alert.showAndWait();
    	
    	return optionSelected.get() == btnYes ? true : false;
		
	}

}
