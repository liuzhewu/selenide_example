package com.liu.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

/**
 * 读取配置文件，读取的文件：config.properties、test_data.xlsx
 * 
 * @author Administrator
 *
 */
public class ConfigManger
{
	//系统可变的配置，对应config.properties
	private static Properties config = null;
	static
	{
		config = new Properties();
		try
		{
			config.load(new FileInputStream(Constants.CONFIG_DIR + File.separator + Constants.CONFIG_PROPERTIES_FILE));
		}
		catch (Exception e)
		{
			LogUtils.error(e.getMessage());
		}

	}

	public static Properties getConfig()
	{
		return config;
	}

	public static void main(String[] args)
	{
		System.out.println("URL:"+getConfig().getProperty(Constants.URL));
	}

}
