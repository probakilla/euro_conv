package org.converter.view;


import org.converter.controller.Controller;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class View
{
	private static View _instance;
	private ComboBox<String> _currencies, _currenciesBis;
	private TextField _toField, _fromField;
	private Button _btn;
	private HBox _hbBtn;
		
	private View () 
	{
		_currencies = new ComboBox<String> ();
		_currencies.getItems().addAll("Euros", "Dollars");
		_currencies.getSelectionModel().selectFirst();
		
		_currenciesBis = new ComboBox<String> ();
		_currenciesBis.getItems().addAll("Euros", "Dollars");
		_currenciesBis.getSelectionModel().selectLast();
		
		_toField = new TextField ();
		_fromField = new TextField ();
		
		_btn = new Button ("Convert !");
		_hbBtn = new HBox (10);
		_hbBtn.setAlignment (Pos.BOTTOM_RIGHT);
		_hbBtn.getChildren().add(_btn); 
	}
	
	public static View getInstance ()
	{
		if (_instance != null)
			return _instance;
		return _instance = new View ();
	}
	
	public void setOnAction (Controller controller)
	{
		_btn.setOnAction(controller);
	}
	
	public String [] getSourceValue ()
	{
		String str [] = new String [3];
		str [0] = _currencies.getPromptText(); 
		str [1] = _currenciesBis.getPromptText();
		str [2] = _fromField.getText();
		return str;
	}
	
	public void start (Stage primaryStage)
	{
		primaryStage.setTitle("Bonjour");
				
		GridPane grid = new GridPane ();
		grid.setAlignment (Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		
		
		// Text
		Label fromText = new Label ("From :");
		grid.add(fromText, 0, 0);
		Label toText = new Label ("To :");
		grid.add(toText, 0, 1);
		
		// Menus
		grid.add(_currencies, 1, 1);
		grid.add(_currenciesBis, 1, 0);
		
		// Text fields

		grid.add(_toField, 2, 1);
		grid.add(_fromField, 2, 0);
		
		// Button
		
		grid.add(_hbBtn, 2, 3);
		
		//
		Text actiontarget = new Text ();
		grid.add(actiontarget, 3, 3);
					
		Scene s = new Scene (grid, 400, 200);
				
		primaryStage.setScene(s);
		primaryStage.show();
	}
}
