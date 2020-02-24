package com.automation;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleWindowsExample {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","D:\\selenium\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
		driver.get(
				"https://accounts.google.com/signup/v2/webcreateaccount?hl=en&flowName=GlifWebSignIn&flowEntry=SignUp");
		driver.findElement(By.xpath("//a[text()='Privacy']")).click();
		;
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parent = it.next();
		String child = it.next();
		driver.switchTo().window(child);
		System.out.println(driver.getTitle());
		driver.switchTo().window(parent);
		System.out.println(driver.getTitle());

	}
}
