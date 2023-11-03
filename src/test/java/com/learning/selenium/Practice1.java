package com.learning.selenium;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practice1 {
	static WebDriver driver = null;
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		WebElement Radiobutton = driver.findElement(By.xpath("//input[@value='radio2']"));
		Radiobutton.click();
		
		WebElement Dropdown = driver.findElement(By.xpath("//option[@value='option2']"));
		Dropdown.click();
		
		WebElement Checkbox = driver.findElement(By.xpath("//input[@value='option2']"));
		Checkbox.click();
		
		Thread.sleep(3000);
		
		
		
		
		
		
		

	}

}
