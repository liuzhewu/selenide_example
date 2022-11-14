package com.liu.parents;

import java.util.Properties;
import static com.liu.utils.Constants.*;


import com.liu.utils.ConfigManger;
import com.liu.utils.LogUtils;

public class ParentTest
{
	protected static Properties props=ConfigManger.getConfig();

	protected void sleep(int n)
	{
		try
		{
			Thread.sleep(n*THOUSAND);
		}
		catch (InterruptedException e)
		{
			LogUtils.error(e.getMessage());
		}
		
	}
	
}
