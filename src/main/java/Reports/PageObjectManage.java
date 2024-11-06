package Reports;

import HomePage.BIKROI_Locator;
import HomePage.DARAZ_Locator;

import HomePage.GOOGLE_Locator;
import org.openqa.selenium.WebDriver;




public class PageObjectManage {
    public static WebDriver driver;

    public BIKROI_Locator bikroi_locator;
    public DARAZ_Locator daraz_locator;
    public GOOGLE_Locator google_locator;

    public PageObjectManage(WebDriver driver) {
        this.driver = driver;
    }

    public BIKROI_Locator getBIKROI_Locator() {
        bikroi_locator = new BIKROI_Locator(driver);
        return bikroi_locator;
    }

    public DARAZ_Locator getDaraz_locator() {
        daraz_locator = new DARAZ_Locator(driver);
        return daraz_locator;
    }
    public GOOGLE_Locator getGoogle_locator() {
        google_locator = new GOOGLE_Locator(driver);
        return google_locator;
    }

}
