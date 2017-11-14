package org.converter.model;

public class Model
{
	private static Model _instance;
	
	private Model () {}
	
	public double convert (String values [])
	{
		double res = Double.parseDouble(values [2]);
		return res;
	}
	
	public double convert ()
	{
		return 0;
	}
	
	public static Model getInstance ()
	{
		if (_instance != null)
			return _instance;
		return _instance = new Model ();
	}
}
