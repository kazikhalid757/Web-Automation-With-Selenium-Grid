package utilis;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Properties;

public class TestBase {

    private WebDriver driver;

    public WebDriver webDriverManager() throws IOException, InterruptedException {
        if (driver == null) {
            FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/global.properties");
            Properties prop = new Properties();
            prop.load(fis);
            String url = prop.getProperty("QAUrl");
            String browser = prop.getProperty("browser");
            String geckoDriverPath = prop.getProperty("geckoDriverPath");

            // Set the geckodriver path
            System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");

            DesiredCapabilities capabilities = new DesiredCapabilities();
            if (browser.equalsIgnoreCase("firefox")) {
                FirefoxOptions options = new FirefoxOptions();
                options.setHeadless(true);
                capabilities.merge(options);
            } else if (browser.equalsIgnoreCase("chrome")) {
                capabilities.setBrowserName("chrome");
                capabilities.setCapability("goog:chromeOptions", new HashMap<String, Object>() {{
                    put("args", Arrays.asList("--headless"));
                }});
            }

            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);

            assert driver != null;
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            driver.manage().window().maximize();
            driver.get(url);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
            wait.until(ExpectedConditions.urlToBe(url));
        }
        return driver;
    }

    public WebDriver webDriverManager_1() throws IOException, InterruptedException {
        if (driver == null) {
            FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/global.properties");
            Properties prop = new Properties();
            prop.load(fis);
            String url = prop.getProperty("url_1");
            String browser = prop.getProperty("browser");
            String geckoDriverPath = prop.getProperty("geckoDriverPath");

            // Set the geckodriver path
            System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");

            DesiredCapabilities capabilities = new DesiredCapabilities();
            if (browser.equalsIgnoreCase("firefox")) {
                FirefoxOptions options = new FirefoxOptions();
                options.setHeadless(true);
                capabilities.merge(options);
            } else if (browser.equalsIgnoreCase("chrome")) {
                capabilities.setBrowserName("chrome");
                capabilities.setCapability("goog:chromeOptions", new HashMap<String, Object>() {{
                    put("args", Arrays.asList("--headless"));
                }});
            }

            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);

            assert driver != null;
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            driver.manage().window().maximize();
            driver.get(url);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
            wait.until(ExpectedConditions.urlToBe(url));
        }
        return driver;
    }

    public WebDriver webDriverManager_2() throws IOException, InterruptedException {
        if (driver == null) {
            FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/global.properties");
            Properties prop = new Properties();
            prop.load(fis);
            String url = prop.getProperty("url_2");
            String browser = prop.getProperty("browser");
            String geckoDriverPath = prop.getProperty("geckoDriverPath");

            // Set the geckodriver path
            System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");

            DesiredCapabilities capabilities = new DesiredCapabilities();
            if (browser.equalsIgnoreCase("firefox")) {
                FirefoxOptions options = new FirefoxOptions();
                options.setHeadless(true);
                capabilities.merge(options);
            } else if (browser.equalsIgnoreCase("chrome")) {
                capabilities.setBrowserName("chrome");
                capabilities.setCapability("goog:chromeOptions", new HashMap<String, Object>() {{
                    put("args", Arrays.asList("--headless"));
                }});
            }

            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);

            assert driver != null;
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            driver.manage().window().maximize();
            driver.get(url);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
            wait.until(ExpectedConditions.urlToBe(url));
        }
        return driver;
    }


    public void closeWebDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
