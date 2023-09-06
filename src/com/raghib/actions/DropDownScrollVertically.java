package com.raghib.actions;

/**
 * Reference:-
 * https://www.youtube.com/watch?v=quP6pyao_V4
 */

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.base.BaseClass;

public class DropDownScrollVertically extends BaseClass {

	public static WebDriver driver;
	public static String browserName = "chrome";
	public static String browserVersion = "116";
	public static String url = "https://accounts.google.com/v3/signin/identifier?continue=https%3A%2F%2Fwww.google.com%3Fhl%3Den-US&ec=GAlA8wE&hl=en&flowName=GlifWebSignIn&flowEntry=AddSession&dsh=S50498882%3A1693254498761247";

	public static void main(String[] args) throws InterruptedException {
		// Chrome Browser
		driver = BaseClass.getDriver(browserName, browserVersion);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get(url);

		
		driver.findElement(By.xpath("//div[@aria-haspopup=\"listbox\"]")).click();
		Thread.sleep(5000);
		WebElement language = driver.findElement(By.xpath("//ul[@role=\"listbox\"]//li[@data-value=\"hi\"]"));
		
		// Selenium-4.2
		Actions action = new Actions(driver);
		action.scrollToElement(language).perform();

		// BaseClass.quitDriver();
	}
}
