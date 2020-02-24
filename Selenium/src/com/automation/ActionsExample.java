package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsExample {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","D:\\selenium\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
		driver.get("https://www.google.com/search?q=Harvard%2BUniversity%20google%20reviews&rlz=1C1CHBF_enIN857IN857&oq=Harvard%2BUniversity+google+reviews&aqs=chrome..69i57j0l2j69i60l3.8367j0j7&sourceid=chrome&ie=UTF-8&npsic=0&rflfq=1&rlha=0&rllag=42377047,-71116370,234&tbm=lcl&rldimm=6428825095529310192&lqi=CiFIYXJ2YXJkK1VuaXZlcnNpdHkgZ29vZ2xlIHJldmlld3MiBTgBiAEBWgIKAA&ved=2ahUKEwiort-68ebkAhUVqZ4KHZOtAHIQvS4wAHoECAoQEg&rldoc=1&tbs=lrf:!2m1!1e2!3sIAE,lf:1,lf_ui:2#lrd=0x89e377427d7f0199:0x5937c65cee2427f0,1,,,&rlfi=hd:;si:6428825095529310192,l,CiFIYXJ2YXJkK1VuaXZlcnNpdHkgZ29vZ2xlIHJldmlld3MiBTgBiAEBWgIKAA;mv:[[42.383634,-71.11242949999999],[42.3706946,-71.12703309999999]];tbs:lrf:!2m1!1e2!3sIAE,lf:1,lf_ui:2");
		driver.manage().window().maximize();
		for (int second = 0;; second++) {
		    if(second >=60){
		        break;
		    }
		    ((JavascriptExecutor) driver).executeScript("", ""); 
		    Thread.sleep(3000);
		}
		Thread.sleep(500);
	}
}
