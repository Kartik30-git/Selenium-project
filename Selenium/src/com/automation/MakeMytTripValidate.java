package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MakeMytTripValidate {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","D:\\selenium\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
		driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		driver.findElement(By.id("fromCity")).sendKeys("Chandigarh");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[text()=\"IXC\"]")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("toCity")).sendKeys("Dehradun");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[text()=\"DED\"]")).click();
	}
}
