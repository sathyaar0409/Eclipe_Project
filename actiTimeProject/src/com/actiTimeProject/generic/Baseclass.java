package com.actiTimeProject.generic;


	import java.io.IOException;
import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.testng.Reporter;
	import org.testng.annotations.AfterClass;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.BeforeMethod;

import com.actiTimeProject.objectrepository.EnterTimeTrackPage;
import com.actiTimeProject.objectrepository.LoginPage;

	public class Baseclass  {
		static {
			System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		}
		public WebDriver driver;
		@BeforeClass
		public void openBrowser() {
			Reporter.log("open the browser", true);
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			}
		@AfterClass
		public void closeBrowser() {
			driver.close();
		}
		@BeforeMethod
		public void login() throws IOException {
			Reporter.log("login to the application",true);
			FileLib f=new FileLib();
			String un = f.getPropertyValue("username");
			String pw = f.getPropertyValue("password");
			driver.get(f.getPropertyValue("url"));
			LoginPage l=new LoginPage(driver);
			l.setLogin(un, pw);
			
		}
		@AfterMethod
		public void logout() {
			EnterTimeTrackPage e=new EnterTimeTrackPage(driver);
			e.setLogoutLink();
		}
	}
		

