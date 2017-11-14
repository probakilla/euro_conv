package org.converter.controller;

import java.awt.Button;

import org.converter.model.Model;
import org.converter.view.View;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class Controller implements EventHandler<ActionEvent>
{		
	private static Controller _instance;
	private Model _model;
	private View _view;
	
	private Controller ()
	{
		_view = View.getInstance();
		_model = Model.getInstance();
	}
	
	public static Controller getInstance ()
	{
		if (_instance != null)
			return _instance;
		return _instance = new Controller ();
	}
	
	public void start (Stage primaryStage)
	{
		_view.start(primaryStage);
		_view.setOnAction (this);
	}

	@Override
	public void handle(ActionEvent event)
	{
		if (event.getSource().getClass() == Button.class)
		{
			_view.getSourceValue();
		}
	}
}
