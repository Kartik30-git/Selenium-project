package com.automation;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertHandler {
public static void main(String[] args) {
	System.setProperty("webdriver.chrome.driver","D:\\selenium\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
	driver.get("http://www.tizag.com/javascriptT/javascriptalert.php");
	driver.findElement(By.xpath("//input[@value=\"Confirmation Alert\"]")).click();
	Alert alert=driver.switchTo().alert();
	System.out.println(alert.getText());
	alert.accept();
}
}
