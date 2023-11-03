package com.learning.selenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class FindElemAs {
	static WebDriver driver = null;
	
	public static void main(String[] args) throws InterruptedException {

	
		
		
			// TODO Auto-generated method stub
			
			driver = new ChromeDriver();
			driver.get("https://www.google.com");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			driver.manage().window().maximize();
			
			
			driver.findElement(By.name("q")).sendKeys("Selenium Learning");
			driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
			
			Thread.sleep(2000);
			
			List<WebElement> Link = driver.findElements(By.xpath("//a"));
			
			for(WebElement LinkPrint :Link) {
				System.out.println(LinkPrint.getAttribute("href"));
			}
			System.out.println("Completed");
			driver.quit();
		}

	}


