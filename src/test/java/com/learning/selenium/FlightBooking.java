package com.learning.selenium;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FlightBooking {
	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		
		driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		String Parentwindow =driver.getWindowHandle();
		driver.findElement(By.linkText("Flight Booking")).click();
		Set<String> AllWindows =driver.getWindowHandles();
		
		for(String ChildWindow:AllWindows) {
			
			driver.switchTo().window(ChildWindow);
			Thread.sleep(2000);
			
		}
		
		WebElement Country = driver.findElement(By.id("autosuggest"));
		Country.sendKeys("india");
		Thread.sleep(2000);
		driver.findElement(By.linkText("India")).click();
		//Thread.sleep(2000);
		WebElement From= driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT"));
		From.click();
		driver.findElement(By.xpath("//a[@value='GOI']")).click();
		WebElement To = driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT"));
		To.click();
		Thread.sleep(1000);
		driver.findElement(By.partialLinkText("Kochi")).click();
		WebElement Date1 = driver.findElement(By.id("ctl00_mainContent_view_date1"));
		Date1.click();
		System.out.println("done");
		Thread.sleep(2000);
		 List<WebElement> selectableDates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//a"));

	        // Locate and click the date "5" in the month of November.
	        for (WebElement date : selectableDates) {
	            if (date.getText().equals("5") /*&& monthYearElement.getText().equals("November")*/) {
	                date.click();
	                break;
	            }
	        }
			WebElement Date2 = driver.findElement(By.id("ctl00_mainContent_view_date2"));
			Date2.click();


	        List<WebElement> selectableDates2 = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//a"));

	        // Locate and click the date "5" in the month of November.
	        for (WebElement date2 : selectableDates2) {
	            if (date2.getText().equals("8") /*&& monthYearElement.getText().equals("November")*/) {
	                date2.click();
	                break;
	            }
	        }
	        
	        WebElement Passenger = driver.findElement(By.id("divpaxinfo"));
	        Passenger.click();
	        driver.findElement(By.xpath("//span[@id='hrefIncAdt']")).click();
	        driver.findElement(By.xpath("//span[@id='hrefIncChd']")).click();
	        driver.findElement(By.id("btnclosepaxoption")).click();
	        driver.findElement(By.name("ctl00$mainContent$btn_FindFlights")).click();
	        
	        System.out.println("All is well");

		
		
		
		
		
		
		
	}

}
