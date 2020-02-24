package com.automation;
//We are performing radioButton automation
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class EchoEchoAutom {
public static void main(String[] args) {
	System.setProperty("webdriver.chrome.driver","D:\\selenium\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
	driver.get("http://www.echoecho.com/");
	driver.findElement(By.xpath("//a[@href=\"html.htm\"]")).click();
	driver.findElement(By.xpath("//a[@href=\"htmlforms10.htm\"]")).click();
	System.out.println(driver.findElements(By.xpath("//input[@name=\"group1\"]")).size());
	
}
}
