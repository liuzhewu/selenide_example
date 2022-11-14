package com.liu.test;

import org.testng.annotations.Test;

import com.liu.parents.ParentTest;
import com.liu.utils.LogUtils;

public class AfterTest extends ParentTest
{
	@Test
	public void end() 
	{
		LogUtils.info("---end to test---");
		
	}

}
