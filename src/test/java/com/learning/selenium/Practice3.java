package com.learning.selenium;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practice3 {

	static WebDriver driver = null;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.findElement(By.id("name")).sendKeys("Guvi");
		driver.findElement(By.id("alertbtn")).click();

		Alert alert =driver.switchTo().alert();
		
		String aText =alert.getText();
		System.out.println(aText);
		
		 if (aText.contains("Hello Guvi")) {
	            System.out.println("Alert contains the expected text");
	        } else {
	            System.out.println("Alert does not contain the expected text");
	        }
		alert.accept();
		
		//WebElement element = driver.findElement(By.xpath("//*[contains(text(),'Hello Guvi')]"));
		
		


	}

}
