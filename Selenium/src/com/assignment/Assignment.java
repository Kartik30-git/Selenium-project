package com.assignment;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Assignment {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","D:\\selenium\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
		driver.get("file:///C:/Users/kartik/Documents/My%20Received%20Files/login_page.html");
		driver.findElement(By.xpath("//input[@name=\"email\"]")).sendKeys("user@example.com");
		driver.findElement(By.xpath("//input[@name=\"pwd\"]")).sendKeys("eW5PEXgz");
		driver.findElement(By.xpath("//input[@value=\"Continue\"]")).click();
		List<WebElement> boxes = driver.findElements(By.xpath("//input[contains(@name,\"sp\")]"));
		int enabled_boxes[] = new int[4];
		int i = 0, j = 0;
		System.out.println(boxes.size());
		while (i < 10) {
			if (boxes.get(i).isEnabled()) {
				enabled_boxes[j++] = i;
				System.out.println("Element Enabled: " + i);
			}
			i++;
		}

		System.out.println("********");
		String secPass = "JcdmAB677B";
		i = 0;
		while (i < 4) {
			boxes.get(enabled_boxes[i]).sendKeys((secPass.valueOf(secPass.charAt(enabled_boxes[i]))));
			System.out.println(secPass.valueOf(secPass.charAt(enabled_boxes[i])));
			i++;
		}
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[contains(@onclick,\"Login2\")]")).click();
		Thread.sleep(5000);
		driver.close();

	}
}
