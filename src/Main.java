import org.converter.controller.Controller;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application
{
	static Controller _controller;
	
	public static void main (String [] args)
	{
		_controller = Controller.getInstance();
		launch (args);
	}
	
	@Override
	public void start (Stage primaryStage) throws Exception
	{
		_controller.start(primaryStage);
	}
}
