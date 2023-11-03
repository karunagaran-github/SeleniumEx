package com.learning.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class Newdemo {
	static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {
        

    	driver = new ChromeDriver();
		driver.get("https://jqueryui.com/droppable/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
	

        // Switch to the frame that contains the draggable and droppable elements.
        driver.switchTo().frame(driver.findElement(By.className("demo-frame")));

        // Locate the source (draggable) and target (droppable) elements.
        WebElement sourceElement = driver.findElement(By.id("draggable"));
        WebElement targetElement = driver.findElement(By.id("droppable"));

        // Create an instance of the Actions class.
        Actions actions = new Actions(driver);

        // Perform the drag-and-drop action.
        actions.dragAndDrop(sourceElement, targetElement).build().perform();

        // Wait for a moment to see the result (add explicit wait if needed).

        // Close the browser.
        //driver.quit();
       WebElement dr= driver.findElement(By.xpath("//div[@id='droppable']"));
       String a =dr.getText();
       System.out.println(a);
       if(a.equals("Dropped!")) {
    	   System.out.println("Success");}
     else 
    	   {
    		   System.out.println("Fail");}
    	   
    	   
    	   
    	   
    	   
       }
    }


