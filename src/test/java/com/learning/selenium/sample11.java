package com.learning.selenium;

import java.net.HttpURLConnection;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class sample11 {
	
	static WebDriver driver =null;

    public static void main(String[] args) {
       
         driver = new ChromeDriver();

        // Replace the URL with the one you want to check
        String urlToCheck = "https://www.bestbuy.com/";

        validateLink(urlToCheck, driver);

        driver.quit();
    }

    public static void validateLink(String linkUrl, WebDriver driver) {
        try {
            URL url = new URL(linkUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            int responseCode = connection.getResponseCode();
            if (responseCode >= 400) {
                System.out.println("Broken Link: " + linkUrl + " - Response Code: " + responseCode);
            } else {
                System.out.println("Valid Link: " + linkUrl + " - Response Code: " + responseCode);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
