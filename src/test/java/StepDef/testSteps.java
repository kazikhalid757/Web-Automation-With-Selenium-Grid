
package StepDef;

import HomePage.BIKROI_Locator;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import Reports.PageObjectManage;
import utilis.TestContextSetup;



public class testSteps {
    TestContextSetup testContextSetup;
    BIKROI_Locator bikroi_locator;
    PageObjectManage pageObjectManage;
    public testSteps(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
        this.bikroi_locator = testContextSetup.pageObjectManager.getBIKROI_Locator();
    }


    @Given("User Click on Bikroy logo")
    public void UserClickOnBikroyLogo() throws InterruptedException {
        Thread.sleep(2000);

        Assert.assertTrue(bikroi_locator.getSearchIcon().isDisplayed());
        bikroi_locator.getSearchIcon().click();
    }

    @Given("Check Mobiles button is available in Category item section")
    public void checkMobilesButtonIsAvailableInCategoryItemSection() throws InterruptedException {

        bikroi_locator.getMobile().isDisplayed();
        Thread.sleep(1000);
    }

    @When("Click on Mobiles button")
    public void clickOnMobilesButton() throws InterruptedException {
        bikroi_locator.getMobile().click();
        Thread.sleep(1000);
        
    }

    @Then("Check Mobile page is Displayed")
    public void checkMobilePageIsDisplayed() throws InterruptedException {

        bikroi_locator.selectLocation().isDisplayed();
        Thread.sleep(1000);

    }

    @And("Check Select Location button is available")
    public void checkSelectLocationButtonIsAvailable() {
        bikroi_locator.selectLocation().isDisplayed();
    }

    @When("Click Select Location button")
    public void clickSelectLocationButton() throws InterruptedException {
        bikroi_locator.selectLocation().click();
        Thread.sleep(1000);
    }

    @Then("Check a Popup window displayed")
    public void checkAPopupWindowDisplayed() throws InterruptedException {
        bikroi_locator.Dhaka().isDisplayed();
        Thread.sleep(1000);

    }

    @And("Check Dhaka is available in Cities category")
    public void checkDhakaIsAvailableInCitiesCategory() {
        bikroi_locator.Dhaka().isDisplayed();
    }

    @When("Click on Dhaka city")
    public void clickOnDhakaCity() throws InterruptedException {
        bikroi_locator.Dhaka().click();
        Thread.sleep(1000);
    }

    @Then("Check Popular areas in Dhaka city are available")
    public void checkPopularAreasInDhakaCityAreAvailable() throws InterruptedException {
        bikroi_locator.Mirpur().isDisplayed();
        Thread.sleep(1000);
    }

    @When("Click Mirpur area")
    public void clickMirpurArea() {
        bikroi_locator.Mirpur().click();
    }

    @Then("Check that all mobiles in Mirpur area are displayed")
    public void checkThatAllMobilesInMirpurAreaAreDisplayed() throws InterruptedException {
        bikroi_locator.topProduct().isDisplayed();
        Thread.sleep(1000);
    }

    @When("Click on a mobile top in the list")
    public void clickOnAMobileTopInTheList() {
        bikroi_locator.topProduct().click();
    }

    @Then("Check mobile Details page is displayed")
    public void checkMobileDetailsPageIsDisplayed() throws InterruptedException {
        bikroi_locator.ProductDetails().isDisplayed();
        Thread.sleep(1000);

    }

    @Given("Check the Searchbar is available")
    public void checkTheSearchboxIsAvailable() {
        bikroi_locator.Search().isDisplayed();

    }

    @When("Click on Search box")
    public void clickOnSearchBox() {
        bikroi_locator.Search().click();
    }

    @And("Input {string} in The Search box")
    public void inputValueInTheSearchBox(String text) {
        bikroi_locator.Search().sendKeys(text);
    }

    @Then("Check a page displayed")
    public void checkAPageDisplayed() {
        bikroi_locator.MobilesSearch().isDisplayed();
    }

    @And("Check next button is available")
    public void checkNextButtonIsAvailable() {
        bikroi_locator.Next().isDisplayed();
    }

    @When("Chick on Next button")
    public void chickOnNextButton() {
        bikroi_locator.Next().click();
    }

    @Then("check the Previous button is active")
    public void checkThePreviousButtonIsActive() {
        bikroi_locator.Previous().isDisplayed();
    }

    @When("Click on Previous button")
    public void clickOnPreviousButton() {
        bikroi_locator.Previous().click();
    }

    @Then("Check the main page displayed")
    public void checkTheMainPageDisplayed() {
        bikroi_locator.Search().isDisplayed();
    }

    @Given("Check that All Ads Option show Properly")
    public void checkThatAllAdsOptionShowProperly() {
        bikroi_locator.all_ads().isDisplayed();
    }

    @When("Click that All Ads Option")
    public void clickThatAllAdsOption() throws InterruptedException {
        Thread.sleep(2000);
        bikroi_locator.all_ads().click();
    }

    @Given("Check that chat button show Properly")
    public void checkThatChatButtonShowProperly() {
        bikroi_locator.chat().isDisplayed();
    }

    @When("Click that chat button")
    public void clickThatChatButton() {
        bikroi_locator.chat().click();
    }

    @Given("Check that login button show Properly")
    public void checkThatLoginButtonShowProperly() throws InterruptedException {
        Thread.sleep(2000);
        bikroi_locator.login().isDisplayed();
    }

    @When("Click that login button")
    public void clickThatLoginButton() {
        bikroi_locator.login().click();
    }

    @Given("Check that Post your ad button show Properly")
    public void checkThatPostYourAdButtonShowProperly() throws InterruptedException {
        Thread.sleep(2000);
        bikroi_locator.post_ad().isDisplayed();
    }

    @When("Click that Post your ad button")
    public void clickThatPostYourAdButton() {
        bikroi_locator.post_ad().click();
    }

    @Given("Check that search bar show Properly")
    public void checkThatSearchBarShowProperly() throws InterruptedException {
        Thread.sleep(2000);
        bikroi_locator.search().isDisplayed();
    }

    @When("Click that search bar")
    public void clickThatSearchBar() {
        bikroi_locator.search().click();
    }

    @And("Enter a search keyword")
    public void enterASearchKeyword() throws InterruptedException {
        Thread.sleep(1000);
        bikroi_locator.search().sendKeys("iphone");
    }

    @And("Click search icon")
    public void clickSearchIcon() throws InterruptedException {
        Thread.sleep(1000);
        bikroi_locator.search_icon().click();
    }

    @Given("Check that language button show Properly")
    public void checkThatLanguageButtonShowProperly() throws InterruptedException {
        Thread.sleep(2000);
        bikroi_locator.language().isDisplayed();
    }

    @When("Click that language button")
    public void clickThatLanguageButton() {
        bikroi_locator.language().click();
    }

    @Given("Check that location button show Properly")
    public void checkThatLocationButtonShowProperly() throws InterruptedException {
        Thread.sleep(2000);
        bikroi_locator.location().isDisplayed();
    }

    @When("Click that location button")
    public void clickThatLocationButton() {
        bikroi_locator.location().click();
    }

}