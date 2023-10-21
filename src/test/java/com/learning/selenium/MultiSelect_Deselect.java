package com.learning.selenium;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MultiSelect_Deselect {
	static WebDriver driver = null;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
			driver = new ChromeDriver();
			driver.get("https://demoqa.com/select-menu");
			driver.manage().window().maximize();
		Select sel = new Select(driver.findElement(By.id("cars")));
		sel.selectByIndex(1);
		Thread.sleep(2000);
		sel.selectByValue("volvo");
		Thread.sleep(5000);
		sel.selectByVisibleText("Audi");
		sel.deselectAll();
		Thread.sleep(5000);	
		
		List<WebElement> options = sel.getOptions();
		
		for(WebElement eachOption:options) {
			System.out.println("The options are-----> "+eachOption.getText());
		}
		
		
	}
	catch(Exception ex)
	{
		ex.printStackTrace();
	}


	}

}
