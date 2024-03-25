package com.practiceautomate.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader 
{
	public Properties properties;
	public Properties init_properties()
	{
		properties = new Properties();
		try {
				FileInputStream fileInputStream = new FileInputStream("./src/test/resources/config/config.properties");
				properties.load(fileInputStream);
		    } 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
		return properties;
	}
}
