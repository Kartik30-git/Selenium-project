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

public class FluentWaitExampleAmazon {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","D:\\selenium\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in");
		String rechargeOption = "//img[@alt=\"Recharges & bill payments\"]";
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofMillis(500)).ignoring(NoSuchElementException.class);

		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.xpath(rechargeOption));
			}
		});
		

		// Explanation: This whole expression is using the concept of Generics and Anonymous classes.
		System.out.println("Is the element displayed? " + element.isDisplayed());
		Thread.sleep(5000L);
		
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
