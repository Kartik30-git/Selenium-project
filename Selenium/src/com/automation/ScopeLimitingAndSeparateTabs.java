package com.automation;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScopeLimitingAndSeparateTabs {
public static void main(String[] args) {
	System.setProperty("webdriver.chrome.driver","D:\\selenium\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
	driver.get("http://www.qaclickacademy.com/practice.php");
	//1. Get the number of links in the page
	System.out.println(driver.findElements(By.tagName("a")).size());
	
	//2. Get the number of links in the footer section
	//This uses the concept of Scope Limiting
	
	WebElement footerDriver=driver.findElement(By.xpath("//div[@id=\"gf-BIG\"]"));  //got the footer using div tag of footer
	System.out.println(footerDriver.findElements(By.tagName("a")).size());
	
	//3. Get the number of links in the first column of footer
	WebElement columnDriver=footerDriver.findElement(By.xpath("table/tbody/tr/td[1]/ul"));  //got the footer using div tag of footer
	int column_size=columnDriver.findElements(By.tagName("a")).size();
	System.out.println(column_size);
	
	//4. Open the column links in separate windows.
	for(int i=1;i<column_size;i++) {
		String keySum=Keys.chord(Keys.CONTROL,Keys.ENTER);
		columnDriver.findElements(By.tagName("a")).get(i).sendKeys(keySum);
	}
	//validating the windows titles
	Set<String> windows=driver.getWindowHandles();
	Iterator<String> i=windows.iterator();
	while(i.hasNext())
	{
		driver.switchTo().window(i.next());
		System.out.println(driver.getTitle());
	}
	
}
}
