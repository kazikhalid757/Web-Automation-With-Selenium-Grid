//package com.compass.testbase;
//
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.net.URL;
//import java.util.Properties;
//import java.util.Random;
//import java.util.concurrent.TimeUnit;
//
//import com.compass.utils.EncryptionUtil;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.firefox.FirefoxOptions;
///*import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;*/
//import org.openqa.selenium.remote.RemoteWebDriver;
//
//import com.compass.utils.WaitHelper;
//
//import io.github.bonigarcia.wdm.WebDriverManager;
//
//public class TestBase {
//	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
//	// public WebDriver driver;
//	protected static final Logger logger = LogManager.getLogger(TestBase.class);
//	public static Properties prop;
//	public String selectIP;
//
//
//	public WebDriver getDriver() {
//		return driver.get();
//	}
//
//	public void RemoteDriver(String IP) {
//		this.selectIP = IP;
//		System.out.println("selected ip is : " + selectIP);
//	}
//
//	public WebDriver initializeDriver(String browserName) throws IOException {
//		if (driver.get() == null) {
//			prop = new Properties();
//			try {
//				FileInputStream ip = new FileInputStream("src/main/resources/config/global.properties");
//				prop.load(ip);
////				String browserName = System.getProperty("browser", prop.getProperty("browser"));
//				String env = System.getProperty("env", "staging");
//				String executionMode = prop.getProperty("execution.mode");
//
//				if (browserName.equalsIgnoreCase("chrome")) {
//					ChromeOptions options = new ChromeOptions();
//					options.addArguments("--remote-allow-origins=*");
//					if (executionMode.equalsIgnoreCase("grid")) {
//						driver.set(new RemoteWebDriver(new URL("http://" + selectIP + ":4444/wd/hub"), options));
//						System.out.println("Running in with Grid");
//					} else {
//						WebDriverManager.chromedriver().setup();
//						driver.set(new ChromeDriver(options));
//						System.out.println("Running in without Grid");
//					}
//				} else if (browserName.equalsIgnoreCase("firefox")) {
//					if (executionMode.equalsIgnoreCase("grid")) {
//						// Use RemoteWebDriver for grid execution
//						FirefoxOptions options = new FirefoxOptions();
//						driver.set(new RemoteWebDriver(new URL("http://" + selectIP + ":4444/wd/hub"), options));
//						System.out.println("Running in with Grid ");
//					} else {
//						WebDriverManager.firefoxdriver().setup();
//						driver.set(new FirefoxDriver());
//						System.out.println("Running in without Grid ");
//					}
//				}
//			} catch (IOException e) {
//				logger.error("Failed to load prop file", e);
//			}
//		}
//		return getDriver();
//	}
//
//
//	public void navigateToUrl() {
//		String env = System.getProperty("env", "staging");
//		String url = prop.getProperty(env + "_url");
//		if (url != null && !url.isEmpty()) {
//			getDriver().get(url);
//			//logger.info("User is able to open the : " + url);
//		} else {
//			logger.error("URL is not provided in the properties file.");
//		}
//		getDriver().manage().window().maximize();
//		getDriver().manage().deleteAllCookies();
//		getDriver().manage().timeouts().pageLoadTimeout(WaitHelper.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//		getDriver().manage().timeouts().implicitlyWait(WaitHelper.IMPLICIT_WAIT, TimeUnit.SECONDS);
//	}
//
//	public ThreadLocal<WebDriver> getThreadLocalDriver() {
//		return driver;
//	}
//
//	public String getUserName() throws Exception {
//		return EncryptionUtil.decrypt(prop.getProperty("username"));
//	}
//
//	public String getPassword() throws Exception {
//		return EncryptionUtil.decrypt(prop.getProperty("password"));
//	}
//
//	public void CloseDriver() {
//		// WebDriver webDriver = driver.get();
//		if (driver.get() != null) {
//			driver.get().quit();
//			driver.remove();
//		} else {
//			logger.warn("Attempted to close a WebDriver that was not initialized.");
//		}
//	}
//}
package com.compass.testbase;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import com.compass.utils.EncryptionUtil;
import com.compass.utils.WaitHelper;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestBase {

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	protected static final Logger logger = LogManager.getLogger(TestBase.class);
	public static Properties prop;
	public String selectIP;

	public WebDriver getDriver() {
		return driver.get();
	}

	public void RemoteDriver(String IP) {
		this.selectIP = IP;
		System.out.println("Selected IP is : " + selectIP);
	}

	// Initialize the driver based on browser name (Chrome or Firefox)
	public WebDriver initializeDriver(String browserName) throws IOException {
		if (driver.get() == null) {
			prop = new Properties();
			try {
				FileInputStream ip = new FileInputStream("src/main/resources/config/global.properties");
				prop.load(ip);

				String env = System.getProperty("env", "staging");
				String executionMode = prop.getProperty("execution.mode");

				if (browserName.equalsIgnoreCase("chrome")) {
					ChromeOptions options = new ChromeOptions();
					options.addArguments("--remote-allow-origins=*");
					if (executionMode.equalsIgnoreCase("grid")) {
						driver.set(new RemoteWebDriver(new URL("http://" + selectIP + ":4444/wd/hub"), options));
						System.out.println("Running with Grid");
					} else {
						WebDriverManager.chromedriver().setup();
						driver.set(new ChromeDriver(options));
						System.out.println("Running without Grid");
					}
				} else if (browserName.equalsIgnoreCase("firefox")) {
					if (executionMode.equalsIgnoreCase("grid")) {
						FirefoxOptions options = new FirefoxOptions();
						driver.set(new RemoteWebDriver(new URL("http://" + selectIP + ":4444/wd/hub"), options));
						System.out.println("Running with Grid");
					} else {
						WebDriverManager.firefoxdriver().setup();
						driver.set(new FirefoxDriver());
						System.out.println("Running without Grid");
					}
				}
			} catch (IOException e) {
				logger.error("Failed to load properties file", e);
			}
		}
		return getDriver();
	}

	// Method to navigate to the URL based on environment
	public void navigateToUrl() {
		String prodUrl = prop.getProperty("prod_url");
		getDriver().get(prodUrl);
		getDriver().manage().window().maximize();
		//getDriver().manage().deleteAllCookies();
	}

	// Wait for the page to fully load
	public void waitForPageLoad(WebDriver driver, int timeoutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
		try {
			// Wait until the document readyState is 'complete'
			wait.until(d -> ((JavascriptExecutor) d).executeScript("return document.readyState").equals("complete"));
		} catch (TimeoutException e) {
			logger.error("Page load timed out after " + timeoutInSeconds + " seconds.");
			throw e; // Rethrow exception if desired, or handle it accordingly
		}
	}

	// Get the current driver (ThreadLocal)
	public ThreadLocal<WebDriver> getThreadLocalDriver() {
		return driver;
	}

	// Get username (decrypted)
	public String getUserName() throws Exception {
		return EncryptionUtil.decrypt(prop.getProperty("username"));
	}

	// Get password (decrypted)
	public String getPassword() throws Exception {
		return EncryptionUtil.decrypt(prop.getProperty("password"));
	}

	// Close the driver
	public void CloseDriver() {
		if (driver.get() != null) {
			driver.get().quit();
			driver.remove();
		} else {
			logger.warn("Attempted to close a WebDriver that was not initialized.");
		}
	}
}
