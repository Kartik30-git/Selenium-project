package com.automation;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class JavascriptExecutorExample {

	@Test()
	public static void test() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","D:\\selenium\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.get("https://www.google.com");
		System.out.println(driver.manage().logs().toString());
		driver.findElement(By.xpath("//input[@type=\"text\"]")).sendKeys("github");
		driver.findElement(By.xpath("//input[@type=\"text\"]")).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//a[contains(text(),'Sign up')]")).click();
		try {
			assertEquals(driver.getCurrentUrl(), "https://github.com/join", "Incorrect URL! We");
		} catch (AssertionError e) {
			System.out.println(e.getMessage());
			js.executeScript("alert('"+e.getMessage()+"')");
			Thread.sleep(2000);
		}
		WebElement body = driver.findElement(By.cssSelector(".setup-info-module"));
		String textThroughMethod = body.getText();
		System.out.println(textThroughMethod);
		System.out.println("---------------------------------------------------------------------");
		String sideText = js.executeScript("return arguments[0].innerText", body).toString();
		System.out.println(sideText);
	}
	
	public static void dateSelection() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\nikbisht\\Downloads\\Automation Software\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String fromDate = "Jul 21, 2019";
		String toDate= "Jul 30, 2019";
		driver.get("https://www.marriott.com/default.mi");
		WebElement from = driver.findElement(By.xpath("//input[@name=\"fromToDate_submit\"]"));
		WebElement to = driver.findElement(By.xpath("//input[@name=\"toDate\"]"));
		driver.findElement(By.xpath("//input[@aria-label=\"City, airport, attraction or address\"]")).sendKeys("New York"+Keys.TAB);
		driver.findElement(By.xpath("//input[contains(@id,'fromDate')]")).sendKeys(fromDate+Keys.TAB);
		driver.findElement(By.xpath("//input[contains(@id,'toDate')]")).sendKeys(toDate);
		driver.findElement(By.xpath("//div[@class=\"l-xs-col-4 l-xl-col-4 l-xl-last-col l-hsearch-find l-find-top js-hform-fields\"]/button")).click();
	}
	
	

}
