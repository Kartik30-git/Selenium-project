package com.automation;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.google.common.base.Function;

/**
 * @author kartik
 *
 */

public class FluentWaitExample {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","D:\\selenium\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
		driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-use-explicit-wait-in-selenium.html");
		driver.findElement(By.xpath("//button[text()='Click me to start timer']")).click();
		// driver.findElement(By.xpath("//p[text()='WebDriver']"));
		// Waiting 30 seconds for an element to be present on the page, checking
		// for its presence once every 500 milli-seconds.
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofMillis(500)).ignoring(NoSuchElementException.class);

		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.xpath("//p[text()='WebDriver']"));
			}
		});
		

		// Explanation: This whole expression is using the concept of Generics and Anonymous classes.
		System.out.println("Is the element displayed? " + element.isDisplayed());
		Thread.sleep(5000L);
		driver.close();
	}

}

/*
 * Eclipse Important Shortcuts:- Ctrl Shift F : Indentation Ctrl Shift O :
 * Organize Imports Ctrl Space : Suggestions Ctrl Shift T : To find a class,
 * even from Jars attached Alt Shift R : Refractor renaming Ctrl D : Delete line
 * Ctrl Alt Down : Copy line Alt Shift X,J : Run as Java App
 * Ctrl / comment
 * Ctrl \ uncomment
 */
