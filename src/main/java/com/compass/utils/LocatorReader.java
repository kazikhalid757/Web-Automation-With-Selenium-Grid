package com.compass.utils;

import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LocatorReader {
    private JSONObject locators;

    // Constructor to load and parse JSON file
    public LocatorReader(String filePath) {
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader(filePath));
            locators = (JSONObject) obj;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public By getLocator(String pageName, String elementName) {
        try {
            JSONObject page = (JSONObject) locators.get(pageName);
            JSONObject element = (JSONObject) page.get(elementName);
            String locatorType = (String) element.get("type");
            String locatorValue = (String) element.get("value");

            switch (locatorType.toLowerCase()) {
                case "id":
                    return By.id(locatorValue);
                case "xpath":
                    return By.xpath(locatorValue);
                case "cssselector":
                    return By.cssSelector(locatorValue);
                case "name":
                    return By.name(locatorValue);
                case "classname":
                    return By.className(locatorValue);
                case "linktext":
                    return By.linkText(locatorValue);
                case "partiallinktext":
                    return By.partialLinkText(locatorValue);
                case "tagname":
                    return By.tagName(locatorValue);
                
                default:
                    throw new Exception("Locator type not supported: " + locatorType);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public WebElement getElement(WebDriver driver, String pageName, String elementName) {
        By locator = getLocator(pageName, elementName);
        return driver.findElement(locator);
    }
}


