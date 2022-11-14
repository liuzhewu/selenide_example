package com.liu.test;

import static com.codeborne.selenide.Selenide.open;
import static com.liu.utils.Constants.URL;

import org.testng.annotations.Test;

import com.codeborne.selenide.WebDriverRunner;
import com.liu.parents.ParentTest;
import com.liu.utils.LogUtils;

public class BeforeTest extends ParentTest
{
	@Test
	public void openQidian() 
	{
		LogUtils.info("---begin to test---");
		setBrowserParams();
		open(props.get(URL).toString());
	}

	/**
	 * 初始化浏览器参数
	 */
	private void setBrowserParams()
	{
		System.setProperty("selenide.browser",WebDriverRunner.CHROME);
		System.setProperty("webdriver.chrome.driver",".\\\\driver\\\\chromedriver.exe");
		
	}

}
