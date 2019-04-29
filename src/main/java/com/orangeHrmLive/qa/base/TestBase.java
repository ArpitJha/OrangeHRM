package com.orangeHrmLive.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class TestBase {

	public static Properties prop;
	public static WebDriver driver;
	protected static Actions action;

	public TestBase(){
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "/src/main/resources"
					+ "/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public static void initialization(){
		String browserName = prop.getProperty("browser");

		if(browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
			driver = new ChromeDriver();
		}
		else if(browserName.equals("FF")){
			System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver");
			driver = new FirefoxDriver();
		}
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
		action = new Actions(driver);
	}

//	public static Actions getActions() {
//		return action;
//	}
}
