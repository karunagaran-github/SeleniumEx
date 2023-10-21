package com.learning.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Checkbok_RadiobuttonsEx {
static WebDriver driver = null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			driver = new ChromeDriver();
			driver.get("https://demo.guru99.com/test/radio.html");
			driver.manage().window().maximize();
			driver.findElement(By.xpath("//input[@id='vfb-7-2']")).click();
			Thread.sleep(5000);
			WebElement Checkbox =driver.findElement(By.xpath("//input[@id='vfb-6-1']"));
			Checkbox.click();
			Thread.sleep(5000);
			if(Checkbox.isSelected()) {
				System.out.println("Checkbox is selected");
			}
			else
			{System.out.println("Checkbox not selected");
			
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}

	}

}
