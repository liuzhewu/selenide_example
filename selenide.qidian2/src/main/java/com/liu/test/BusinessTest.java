package com.liu.test;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.actions;
import static com.codeborne.selenide.Selenide.switchTo;
import static com.liu.utils.Constants.BOOK;
import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

/**
 * 搜索《回到明朝当王爷》，加入书架，进入书架，找到《回到明朝当王爷》并删除
 * @author Administrator
 *
 */
public class BusinessTest
{
	@Test
	public void search() 
	{
		$(By.xpath("//*[@id=\"s-box\"]")).shouldBe(enabled).sendKeys(BOOK);
		$(By.xpath("//*[@id=\"search-btn\"]/em")).click();
	}
	
	@Test
	public void addToBookshelves() 
	{
		//切换窗口
		switchTo().window(1);
		
		//找到结果列表的第一本书名称,验证，加入书架
		String bookName= $(By.xpath("//*[@id=\"result-list\"]/div/ul/li[1]/div[2]/h4/a/cite")).shouldBe(visible).getText();
		assertThat(bookName).as("vertify 回到明朝当王爷 is in result").isEqualTo(BOOK);
		$(By.xpath("//*[@id=\"result-list\"]/div/ul/li[1]/div[3]/p/a[2]")).click();
	}
	
	@Test
	public void checkBookshelves() {
		//点击书架
		$(By.xpath("//*[@id=\"top-book-shelf\"]/a")).click();
		//切换窗口
		switchTo().window(2);
		//书架查询
		$(By.xpath("//*[@id=\"shelfSearchForm\"]/input[1]")).shouldBe(enabled).sendKeys(BOOK);
		$(By.xpath("//*[@id=\"shelfSearchForm\"]/label")).click();
		switchTo().window(3);
		//验证结果中是否有预期书籍，并删除
		String bookName= $(By.xpath("//*[@id=\"shelfTable\"]/tbody/tr/td[1]/span/b/a[2]")).shouldBe(visible).getText();
		assertThat(bookName).as("vertify 回到明朝当王爷 is in result").isEqualTo(BOOK);
		actions().moveToElement($(By.xpath("//*[@id=\"shelfTable\"]/tbody/tr/td[5]/a"))).perform();
		$(By.xpath("//*[@id=\"forList0\"]/div/a[4]")).shouldBe(visible).shouldBe(enabled).click();
	}
	
	
	
	
	
	
	
	
	
	
	

}
