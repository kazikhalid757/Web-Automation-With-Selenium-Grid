package utilis;

import java.io.IOException;
import Reports.PageObjectManage;
import org.openqa.selenium.WebDriver;

public class TestContextSetup {

    public WebDriver driver;
    public String landingPageProductName;
    public PageObjectManage pageObjectManager;
    public TestBase testBase;

    public TestContextSetup() throws IOException, InterruptedException {
        testBase = new TestBase();
        pageObjectManager = new PageObjectManage(testBase.webDriverManager());  // Correct method name here
        driver = testBase.webDriverManager();  // Correct method name here
    }
    public void TestContextSetup_1() throws IOException, InterruptedException {
        testBase = new TestBase();
        pageObjectManager = new PageObjectManage(testBase.webDriverManager_1());  // Correct method name here
        driver = testBase.webDriverManager_1();  // Correct method name here
    }
    public void TestContextSetup_2() throws IOException, InterruptedException {
        testBase = new TestBase();
        pageObjectManager = new PageObjectManage(testBase.webDriverManager_2());  // Correct method name here
        driver = testBase.webDriverManager_2();  // Correct method name here
    }
}

