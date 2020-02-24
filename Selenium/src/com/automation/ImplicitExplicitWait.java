package com.automation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ImplicitExplicitWait {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","D:\\selenium\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in");
		
		// 1. Implicit Wait
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		String rechargeOption = "//img[@alt=\"Recharges & bill payments\"]";
		WebElement element = driver.findElement(By.xpath(rechargeOption));
		
		//2. Explicit Wait
		WebDriverWait w = new WebDriverWait(driver, 30);
		w.until(ExpectedConditions.elementToBeClickable(element));
		
		driver.findElement(By.xpath(rechargeOption)).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);

	}
}
