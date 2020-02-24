package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

//Program to demonstrate how to do headless browser testing using HtlmUnitBrowser
/*
Headless Browser Testing using HTMLUnitDriver in Selenium:

Advantages of HtmlUnitDriver:

+Test execution using HtmlUnitDriver is very fast. Since it is the fastest implementation of Selenium WebDriver.
+Being headless and fast, it is an ideal choice for web scrapping.
+Its browser - htmlUnit is Java based. Hence, it is platform independent.
+It also supports JavaScript execution through in-built Rhino javascript engine.

========================================================

Limitations of HtmlUnitDriver:

-Doesn't not support Actions class
-Being non-GUI makes it difficult to create scripts and debug issues while scripting.
-The Rhino javascript engine of HtmlUnitDriver makes it unsuitable to emulate other popular browser's javascript behaviour.

Some of the examples of Headless Drivers include:

HtmlUnit
Ghost
PhantomJS
ZombieJS
Watir-webdriver

 * */

public class HeadlessBrowser {

	public static void main(String[] args) {
		// Creating a new instance of the HTML unit driver

		WebDriver driver = new HtmlUnitDriver();  //Need to import JAR for HtmlUnitDriver

		// Navigate to Google
		driver.get("http://www.google.com");

		// Locate the searchbox using its name
		WebElement element = driver.findElement(By.name("q"));

		// Enter a search query
		element.sendKeys("Guru99");

		// Submit the query. Webdriver searches for the form using the text input
		// element automatically
		// No need to locate/find the submit button
		element.submit();

		// This code will print the page title
		System.out.println("Page title is: " + driver.getTitle());

		driver.quit();
	}
}
