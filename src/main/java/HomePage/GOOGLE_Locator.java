package HomePage;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GOOGLE_Locator {

    WebDriver driver;

    By textbox = By.xpath("//textarea[@id='APjFqb']");
    By searcvalue = By.xpath("(//*[@class='sbct sbre PZPZlf'])[1]");
    By logo = By.xpath("//a[@class='gtm-market-logo']");


    public GOOGLE_Locator(WebDriver driver) {
        this.driver = driver;
    }


    public WebElement textbox(){return driver.findElement(textbox);}
    public WebElement searcvalue(){return driver.findElement(searcvalue);}
    public WebElement getSearchIcon(){return driver.findElement(logo);
    }
}
