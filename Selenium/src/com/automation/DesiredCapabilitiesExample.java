package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DesiredCapabilitiesExample {
public static void main(String[] args) {
	String projectPath = System.getProperty("user.dir");  //to get current project's directory
	
	//If you try running without below two lines it gives you error 
	//because protected mode is on by default in IE.
	DesiredCapabilities cap = new DesiredCapabilities();
	cap.setCapability("ignoreProtectedModeSettings", true);
	
	//See https://github.com/SeleniumHQ/selenium/wiki/DesiredCapabilities
	//for other kinds of capabilities you can have.
	
	System.setProperty("webdriver.chrome.driver",projectpath +"D:\\selenium\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
	driver.get("https://google.com");
	driver.findElement(By.name("q")).sendKeys("APCD");
	driver.findElement(By.name("btnk")).sendKeys(Keys.RETURN); //Why didn't we click?
	//because Search button might be overlapped by results.
	
	
	
}
}
