package com.compass.utils;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;


public class WaitHelper {

	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 20;
	
	protected static final Logger logger = LogManager.getLogger(WaitHelper.class);
	
	//private WebDriver driver;
	private ThreadLocal<WebDriver> driver;
    private ThreadLocal<WebDriverWait> wait;
	
	public WaitHelper(ThreadLocal<WebDriver> driver){
		this.driver = driver;
	}
	
	public void WaitForElement(WebElement element,Duration timeOutInSeconds){
		logger.info("waiting for element visibilityOf..");
		WebDriverWait wait = new WebDriverWait(driver.get(), timeOutInSeconds);
		wait.until(ExpectedConditions.visibilityOf(element));
		logger.info("element is visible..");
	}
	
	// Added for other waits but need to verify on the usage of BY. So commented it for now
	/*public WebElement fluentWaitForElement(By locator) {
        FluentWait<WebDriver> fluentWait = new FluentWait<>(driver.get())
            .withTimeout(Duration.ofSeconds(30))
            .pollingEvery(Duration.ofMillis(500))
        	.ignoring(NoSuchElementException.class);

        return fluentWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
	
	// Wait until the page is fully loaded
    public void waitForPageLoad() {
        wait.get().until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }

    // General wait for element to be visible
    public WebElement waitForVisibility(By locator) {
        return wait.get().until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // General wait for element to be clickable
    public WebElement waitForClickable(By locator) {
        return wait.get().until(ExpectedConditions.elementToBeClickable(locator));
    }*/
	
}
