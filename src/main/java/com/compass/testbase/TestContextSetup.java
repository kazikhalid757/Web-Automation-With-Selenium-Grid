package com.compass.testbase;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.compass.pages.LoginPage;
import com.compass.utils.LocatorReader;
import com.compass.utils.WaitHelper;
//import com.compass.utils.PageObjectManage;

public class TestContextSetup {

	private TestBase testBase;
	private LocatorReader locatorReader;
	private String scenarioName;
	private WaitHelper waitHelper;
	
	private static ThreadLocal<LoginPage> loginPage = new ThreadLocal<>();

	
	public String getScenarioName() {
		return scenarioName;
	}
	
	public void setScenarioName(String scenarioName)
	{
		this.scenarioName =scenarioName;
	}
	
	public TestContextSetup() throws IOException, InterruptedException {
		testBase = new TestBase();
//		testBase.initializeDriver();
//		locatorReader = new LocatorReader("src/test/resources/locators/locators.json");
		waitHelper =  new WaitHelper(testBase.getThreadLocalDriver());
	}
	
	public WaitHelper getWaitHelper()
	{
		return waitHelper;
	}

	
	public WebDriver getDriver() {
		return testBase.getDriver();
	}
	
	public TestBase getTestBase() {
		return testBase;
	}
	

	public LoginPage getLoginPage() throws IOException {
		if (loginPage.get() == null) {
			loginPage.set(new LoginPage(getDriver(), locatorReader));
		}
		return loginPage.get();
	}
	

	
	public void closeDriver()
	{
		loginPage.remove();
		testBase.CloseDriver();
	}

	public void initializeDriver(String browserName) throws IOException {
		testBase.initializeDriver(browserName);
		locatorReader = new LocatorReader("src/test/resources/locators/locators.json");
	}
}
