package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * Auto-suggestive Dropdowns: Search boxes which Auto-populate results which
 * contain the search keywords. Scenario: Enter some value "bal" in a search
 * box then select the result Bali, Cameroon from the list of auto-suggested results.
 * 
 * Approach: First identify the search-box and enter "bal" Then use Kyes.DOWN
 * to jump down the results. Use Javascript Executor to identify the hidden text
 * of each result and match that text with Bali, Cameroon Continue to find till
 * matches->Stop at the matched result and click on it.
 * 
 * Why do we need to match, why not just enter "Bali, Cameroon" and select the first result using one Key.DOWN?
 * Because maybe what you've searched is no more in the search results so it will not be found and you'd select a wrong value.
 */
public class AutosuggestiveDropdowns {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("Program for handling autosuggestive dropdowns:-");
		System.setProperty("webdriver.chrome.driver","D:\\selenium\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
		driver.get("https://www.makemytrip.com");
		driver.findElement(By.xpath("//input[@id=\"hp-widget__sfrom\"]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id=\"hp-widget__sfrom\"]")).sendKeys("Bal");
		Thread.sleep(2000);
		boolean flag = true;
		int i = 0;
		String script = "return document.getElementById(\"hp-widget__sfrom\").value", result;
		while (flag) {
			driver.findElement(By.xpath("//input[@id=\"hp-widget__sfrom\"]")).sendKeys(Keys.DOWN);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			result = (String) js.executeScript(script);
			if (result.equalsIgnoreCase("Bali, Cameroon"))
				flag = false;
			if (i > 20)
				break;
			i++;
			Thread.sleep(1000);
		}
		driver.findElement(By.xpath("//input[@id=\"hp-widget__sfrom\"]")).sendKeys(Keys.TAB);

	}
}
