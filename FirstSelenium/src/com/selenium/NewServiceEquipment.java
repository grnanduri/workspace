package com.selenium;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NewServiceEquipment {

	public static void main(String[] args) throws Exception{
		
		WebDriver driver = new FirefoxDriver();
		
		driver.get("http://www.verizonwireless.com");
		driver.manage().window().maximize();
		driver.findElement(By.xpath(".//*[@id='pageWrapper']/div[2]/div/nav/ul/li[1]/div/a")).click();
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./Screenshots/vzw1.jpg"));
		
	}
}
