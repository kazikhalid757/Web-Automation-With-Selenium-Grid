package com.compass.stepdefinitions;

import java.io.IOException;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import com.compass.pages.LoginPage;
import com.compass.testbase.TestBase;
import com.compass.testbase.TestContextSetup;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps{
	TestContextSetup testContext;
	private LoginPage loginPge;
	private TestBase testBase;

	private static final Logger logger = LogManager.getLogger(LoginSteps.class);


	public LoginSteps(TestContextSetup testContextSetup, TestBase testBase) throws IOException {
		this.testContext = testContextSetup;
		this.loginPge = testContext.getLoginPage();
		this.testBase = testBase;
		
	}

	@Then("I should see the login logo")
	public void i_should_see_the_compass_logo() throws InterruptedException {

		Assert.assertTrue(loginPge.login_logo().isDisplayed(),"Company Logo not displayed");
		Thread.sleep(3000);
		logger.info("Company Logo displayed");
	}


	@Then("I should click on login logo")
	public void iShouldClickOnLoginLogo() throws InterruptedException {
		loginPge.login_logo().click();
		Thread.sleep(3000);
	}

	@And("I should see the email login options")
	public void iShouldSeeTheEmailLoginOptions() throws InterruptedException {
		Assert.assertTrue(loginPge.email_login().isDisplayed(),"Email Login not displayed");
		Thread.sleep(3000);
		logger.info("email login displayed");
	}

	@Then("I should click on Email login options")
	public void iShouldClickOnEmailLoginOptions() throws InterruptedException {
		loginPge.email_login().click();
		Thread.sleep(3000);
	}

	@And("I should see Username field on this page")
	public void iShouldSeeUsernameFieldOnThisPage() throws InterruptedException {
		Assert.assertTrue(loginPge.email_input_field().isDisplayed(),"Username field not displayed");
		Thread.sleep(3000);
		logger.info("username field displayed");
	}

	@When("I should Input my Username")
	public void iShouldInputMyUsername() throws InterruptedException {
		loginPge.email_input_field().click();
		Thread.sleep(1000);
		loginPge.email_input_field().sendKeys("example@gmail.com");

	}

	@And("I should Input my My Password")
	public void iShouldInputMyMyPassword() throws InterruptedException {
		loginPge.Password_input_field().click();
		Thread.sleep(1000);
		loginPge.Password_input_field().sendKeys("example@gmail.com");
		Thread.sleep(2000);

	}

	@Then("I should Click on Login Button")
	public void iShouldClickOnLoginButton() throws InterruptedException {
		loginPge.Login_Button().click();
		Thread.sleep(5000);
	}

	@Given("I should see the Mobile category")
	public void iShouldSeeTheMobileCategory() throws InterruptedException {
		Assert.assertTrue(loginPge.Mobile_category().isDisplayed(),"Mobile Category not displayed");
		Thread.sleep(3000);
		logger.info("Mobile Category displayed");
	}

	@Then("I should Click on Mobile Category")
	public void iShouldClickOnMobileCategory() throws InterruptedException {
		loginPge.Mobile_category().click();
		Thread.sleep(3000);
	}

	@And("I should See Mobile product")
	public void iShouldSeeMobileProduct() throws InterruptedException {
		Assert.assertTrue(loginPge.verify_mobile().isDisplayed(),"Mobile product not displayed");
		Thread.sleep(3000);
		logger.info("Mobile product displayed");
	}

	@Given("I should see the Electronics category")
	public void iShouldSeeTheElectronicsCategory() throws InterruptedException {
		Assert.assertTrue(loginPge.Electronics_category().isDisplayed(),"Electronics category not displayed");
		Thread.sleep(3000);
		logger.info("Electronics Category displayed");
	}

	@Then("I should Click on Electronics Category")
	public void iShouldClickOnElectronicsCategory() throws InterruptedException {
		loginPge.Electronics_category().click();
		Thread.sleep(3000);
	}

	@And("I should See Electronics product")
	public void iShouldSeeElectronicsProduct() throws InterruptedException {
		Thread.sleep(5000);
		Assert.assertTrue(loginPge.verify_Electronics().isDisplayed(),"Electronics product not displayed");
		logger.info("Electronics product displayed");
	}

	@Given("I should see the Vehicles category")
	public void iShouldSeeTheVehiclesCategory() throws InterruptedException {
		Assert.assertTrue(loginPge.Vehicles_category().isDisplayed(),"Vehicles category not displayed");
		logger.info("Vehicles Category displayed");
	}

	@Then("I should Click on Vehicles Category")
	public void iShouldClickOnVehiclesCategory() throws InterruptedException {
		loginPge.Vehicles_category().click();
		Thread.sleep(3000);
	}

	@And("I should See Vehicles product")
	public void iShouldSeeVehiclesProduct() throws InterruptedException {
		Assert.assertTrue(loginPge.Verify_Vehicles().isDisplayed(),"Vehicles product not displayed");
		Thread.sleep(3000);
		logger.info("Vehicles product displayed");
	}

	@Given("I should see the Property category")
	public void iShouldSeeThePropertyCategory() {
		Assert.assertTrue(loginPge.Property_category().isDisplayed(),"Property category not displayed");
		logger.info("Property Category displayed");
	}

	@Then("I should Click on Property Category")
	public void iShouldClickOnPropertyCategory() throws InterruptedException {
		loginPge.Property_category().click();
		Thread.sleep(3000);
	}

	@And("I should See Property product")
	public void iShouldSeePropertyProduct() throws InterruptedException {
		Assert.assertTrue(loginPge.verify_Property().isDisplayed(),"Property product not displayed");
		Thread.sleep(3000);
		logger.info("Property product displayed");
	}
}
