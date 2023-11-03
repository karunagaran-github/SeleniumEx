package com.learning.selenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;




public class GreekKartAssignment2 {
	static WebDriver driver = null;
	

	public static void main(String[] args) throws InterruptedException {
		
		
		driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		
		
		driver.findElement(By.className("search-keyword")).sendKeys("Ber");
		driver.findElement(By.className("search-button")).click();
		Thread.sleep(2000);
		List<WebElement> allcartButtons = driver.findElements(By.xpath("//button[text()='ADD TO CART']"));
		for(WebElement eachcart: allcartButtons) {
			Thread.sleep(2000);
			eachcart.click();
		}
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@class='cart-icon']")).click();			
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		driver.findElement(By.className("promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.className("promoBtn")).click();
		Thread.sleep(3000);
	
		String a =driver.findElement(By.className("totAmt")).getText();
		System.out.println(a);
		int b = Integer.parseInt(a);
		if(a.equals("388")) {
			System.out.println("Same");
		}
		else {System.out.println("Not same");
		}
		
		List<WebElement> allveg =driver.findElements(By.xpath("//tbody/tr/td[4]"));
		int total = 0;
		for(WebElement price:allveg) {
			String Finalprice= price.getText();
			int t = Integer.parseInt(Finalprice);
			total=total+t;
			
		}
		System.out.println(total);
		if( b==total) {
			System.out.println("Same");
		}
		else {System.out.println("Not same");
		}
		System.out.println("Done");
		//driver.quit();


}
}
