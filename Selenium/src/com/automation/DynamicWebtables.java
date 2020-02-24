package com.automation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicWebtables {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","D:\\selenium\\chromedriver_win32\\chromedriver.exe");
                WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://toolsqa.com/automation-practice-table");
		int sRow = 1;
		int sCol = 1;

		// Code to PRINT THE TABLE
		System.out.println("Printing the table:-");
		for (sRow = 1; sRow <= 4; sRow++) {
			for (sCol = 1; sCol <= 5; sCol++) {
				String sCellValue = driver
						.findElement(By.xpath(".//*[@id='content']/table/tbody/tr[" + sRow + "]/td[" + sCol + "]"))
						.getText();
				System.out.print(sCellValue + " | ");
			}
			System.out.println();
		}

		//Code to print the row having "Clock Tower Hotel"
		String sRowValue = "Clock Tower Hotel";
		System.out.println("-----------------------");
		// Outer loop will find the "Clock Tower Hotel" in the first column
		for (int i = 1; i <= 4; i++) {
			String sValue = null;
			sValue = driver.findElement(By.xpath(".//*[@id='content']/table/tbody/tr[" + i + "]/th")).getText();
			if (sValue.equalsIgnoreCase(sRowValue)) {
				// If the sValue match with the description, it will initiate one more inner
				// loop for all the columns of 'i' row
				for (int j = 1; j <= 5; j++) {
					String sColumnValue = driver
							.findElement(By.xpath(".//*[@id='content']/table/tbody/tr[" + i + "]/td[" + j + "]"))
							.getText();
					System.out.println(sColumnValue);
				}
				break;
			}
		}
		driver.close();
	}
}