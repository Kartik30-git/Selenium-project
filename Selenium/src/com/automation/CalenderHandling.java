package com.automation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalenderHandling {
	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver","D:\\selenium\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.path2usa.com/travel-companions");
		driver.findElement(By.id("travel_date")).click();

		// date to select: 27 January
		String dateToSelect = "27";
		String month = "January 2019";

		// Navigating to the given month: Run loop till the text of datepicker is not January
		// 2019.
		while (!driver.findElement(By.xpath("//div[@class='datepicker-days']/table/thead/tr[1]/th[2]")).getText()
				.contains(month)) {
			Thread.sleep(2000);
			driver.findElement(By.xpath("//div[@class='datepicker-days']/table/thead/tr[1]/th[3]")).click();
		}
		
		//Selecting the date in that month: a. Get all dates of that month in a List.
		List<WebElement> dates = driver.findElements(By.xpath("//td[@class=\"day\"]"));
		int size = dates.size();

		//b. Iterate through the list till text of the date is not equal to dateToSelect
		for (int i = 0; i < size; i++) {
			String date = dates.get(i).getText();
			if (date.equalsIgnoreCase(dateToSelect)) {
				//c. When found select that date and break out of the loop
				driver.findElements(By.xpath("//td[@class=\"day\"]")).get(i).click();
				break;
			}

		}

	}
}
