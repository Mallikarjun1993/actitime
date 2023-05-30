package com.actitime.generic;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.runners.Parameterized.Parameter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.actitime.pom.HomePage;
import com.actitime.pom.LoginPage;

public class Basecls {
	static{
		System.setProperty("webdriver.chrome.driver","./driver/ChromeDriver.exe");
		System.setProperty("webdriver.gechko.driver","./driver/gechkoDriver.exe");
	}
public WebDriver driver;
@Parameters ("browser")
@BeforeTest
public void openBrowser(String browser) {
	Reporter.log("OpenBrowser",true);
	if(browser.equals("chrome")) {
	driver=new ChromeDriver();
	}
	else if(browser.equals("firefox")) {
		driver= new FirefoxDriver();
	}
	
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

}
@AfterTest
public void closeBrowser() {
	driver.close();
}
@BeforeMethod
public void login() throws IOException {
	Reporter.log("login",true);
	FileLIb f=new FileLIb();
	String url = f.getpropertyData("url");
	String un = f.getpropertyData("username");
	String pw = f.getpropertyData("password");
	driver.get(url);
	LoginPage l=new LoginPage(driver);
	l.setLogin(un, pw);
}
@AfterMethod
public void logOut() {
	Reporter.log("logOut",true);
	HomePage h=new HomePage(driver);
	h.setLogout();
}
}
