package com.automation;
//This PROGRAM IS VERY IMPORTANT
/*
 * Note: you need to switch to defaultControl every time even if you have only visited or switched(not only 
 * when you clicked something) to a frame and you want to switch to a frame outside of this frame or you want to
 * do something on the default HTLM window. If the frame you want to work on is inside the currently visited 
 * frame then you don't need to switch to defaultControl*/


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleFramesExample {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","D:\\selenium\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
		driver.get("https://spinbot.com/Login");
		int number = framenumber(driver, By.xpath("//div[@class='recaptcha-checkbox-checkmark']"));
		// passing the Xpath for RadioButton to framenumber(). framenumber() returns the frame number of frame in which the
		// element with that xpath is present.
		driver.switchTo().frame(number);
		driver.findElement(By.xpath("//div[@class='recaptcha-checkbox-checkmark']")).click();
		driver.switchTo().defaultContent();
		int framewithverify = framenumber(driver, By.xpath("//button[text()=\"Verify\"]"));
		driver.switchTo().frame(framewithverify);
		driver.findElement(By.xpath("//button[text()=\"Verify\"]")).click();

	}

	public static int framenumber(WebDriver driver, By by) {
		int i;
		int count = driver.findElements(By.tagName("iframe")).size(); // calculating the total number of frames in HTML
		for (i = 0; i < count; i++) { // switching to each and every frame and clicking on the element if present in
										// that frame
			driver.switchTo().frame(i);
			int num1 = driver.findElements(by).size();
			// To check if the element 'by' is present in the Frame's HTML or not. We cannot use
			// isDisplayed here, as we are only checking whether object is present inside a
			// frame which might not even be open/visible.
			// .size() returns 0 if the element in not present in the frame's HTML.
			if (num1 > 0) // i.e. if the element is present in the HTML of this frame
			{

				break; // and as soon as clicked exit the loop
			} else {
				System.out.println("Continue looping"); 
			}
			driver.switchTo().defaultContent();
		}
		driver.switchTo().defaultContent(); // return the control to default driver as you clicked on the frame on Line
											// 30.
		return i;
	}
}
