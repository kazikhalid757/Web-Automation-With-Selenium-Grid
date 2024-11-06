package StepDef;

import HomePage.DARAZ_Locator;
import HomePage.GOOGLE_Locator;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import HomePage.DARAZ_Locator;
import utilis.TestContextSetup;

public class google_step {
    private final TestContextSetup testContextSetup_2;
    private TestContextSetup TestContextSetup_2;
    private WebDriver driver;
    private GOOGLE_Locator google_locator;
    private int wait = 3000;

    public google_step(TestContextSetup TestContextSetup_1) {
        this.testContextSetup_2 = TestContextSetup_1;
        this.driver = testContextSetup_2.driver;
        this.google_locator = testContextSetup_2.pageObjectManager.getGoogle_locator();
    }
    //////////// TC_1 //////////////////////////

    @Given("Check the textarea button")
    public void checkTheLoginButtonGo() throws InterruptedException {
        Assert.assertTrue(google_locator.textbox().isDisplayed());
        Thread.sleep(wait);
    }

    @Then("Click on textarea")
    public void clickOnTextarea() throws InterruptedException {
        google_locator.textbox().click();
        Thread.sleep(wait);
    }

    @When("I Input search key")
    public void iInputSearchKey() throws InterruptedException {
        google_locator.textbox().sendKeys("dhaka");
        Thread.sleep(wait);
    }

    @Then("check That The Value is displayed")
    public void checkThatTheValueIsDisplayed() throws InterruptedException {
        Assert.assertTrue(google_locator.searcvalue().isDisplayed());
        Thread.sleep(wait);
    }

    @Given("User Click on Bikroy logo 1")
    public void userClickOnBikroyLogo() throws InterruptedException {
        Thread.sleep(2000);
        Assert.assertTrue(google_locator.getSearchIcon().isDisplayed());
        google_locator.getSearchIcon().click();
    }
}
