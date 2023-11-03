package com.learning.selenium;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practice2 {
	static WebDriver driver = null;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		
		String ParentWindow = driver.getWindowHandle();
	
		WebElement OpenWindow = driver.findElement(By.id("openwindow"));
		OpenWindow.click();
		
		Set<String> allwindows = driver.getWindowHandles();
		
		
		for(String eachwindow:allwindows) {
			Thread.sleep(3000);
			driver.switchTo().window(eachwindow);
		}
		System.out.println("windows switched");
		Thread.sleep(3000);
		WebElement childwindow = driver.findElement(By.xpath("//span[text()='info@qaclickacademy.com']"));
		String textc =childwindow.getText();
		System.out.println("Child widow text is --- " + textc);
		driver.switchTo().window(ParentWindow);
		
		System.out.println("Completed");
		
		
		

	}

}
