package jp.gihyo.jenkinsbook.webdriver;

import static org.junit.Assert.*;

import java.io.IOException;
import java.net.URL;
import java.util.Calendar;
import java.util.Properties;

import jp.gihyo.jenkinsbook.page.ResultPage;
import jp.gihyo.jenkinsbook.page.TopPage;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.WebDriver;

@Ignore
public class SampleTestCase {

	private static Properties prop = new Properties();
	private static WebDriver driver;
	
	@BeforeClass
	public static void setUpClass() throws IOException {
		prop.load(SampleTestCase.class.getResourceAsStream("/selenium.properties"));
		// driver = new FirefoxDriver();
        DesiredCapabilities capability = DesiredCapabilities.firefox();
        // capability.setVersion("26.0");
        driver = new RemoteWebDriver(new URL(prop.getProperty("seleniumGridUrl")), capability);
	}
	
	@AfterClass
	public static void tearDownClass() throws IOException {
		driver.quit();
	}
	@Test
	public void testNormal01() {
		driver.get(prop.getProperty("baseUrl"));
		
		TopPage topPage = new TopPage(driver);
		assertEquals("名字", topPage.getLastNameLabel());
		assertEquals("名前", topPage.getFirstNameLabel());

		assertTrue(topPage.hasLastNameInput());
		assertTrue(topPage.hasFirstNameInput());
		assertTrue(topPage.hasSubmit());
	}
	
	@Test
	public void testNormal02() {
		driver.get(prop.getProperty("baseUrl"));
		
		TopPage topPage = new TopPage(driver);
		topPage.setLastName("Hoge");
		topPage.setFirstName("Foo");
		topPage.submit();
		
		String greeting = "";
		Calendar calendar = Calendar.getInstance();
		int hour = calendar.get(Calendar.HOUR_OF_DAY);
		if (hour < 12) {
			greeting = "Good morning";
		} else {
			greeting = "Good afternoon";
        }
		ResultPage resultPage = new ResultPage(driver);
		assertEquals(greeting + ", Hoge Foo!!", resultPage.getText());
	}
	
	@Test
	public void testError01() {
		driver.get(prop.getProperty("baseUrl"));
		
		TopPage page = new TopPage(driver);
		page.setFirstName("Hoge");
		page.submit();
		
		ResultPage resultPage = new ResultPage(driver);
		assertEquals("エラー", resultPage.getText());
	}

	@Test
	public void testError02() {
		driver.get(prop.getProperty("baseUrl"));
		
		TopPage page = new TopPage(driver);
		page.setLastName("Hoge");
		page.submit();
		
		ResultPage resultPage = new ResultPage(driver);
		assertEquals("エラー", resultPage.getText());
	}
}
