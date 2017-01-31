package com.qait.Trust.automation.getpageobjects;

import static com.qait.Trust.automation.getpageobjects.ObjectFileReader.getELementFromFile;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

public class GetPage extends BaseUi {

    String pageName;
    protected WebDriver driver;
    protected final int AJAX_WAIT = 30;

    public GetPage(WebDriver driver, String pageName) {
        super(driver, pageName);
        this.driver = driver;
        this.pageName = pageName;
    }

    // TODO: put this in right place, create dedicated class for frame and window handlers
    protected void switchToNestedFrames(String frameNames) {
        switchToDefaultContent();
        String[] frameIdentifiers = frameNames.split(":");
        for (String frameId : frameIdentifiers) {
            wait.waitForFrameToBeAvailableAndSwitchToIt(getLocator(frameId
                    .trim()));
        }
    }

    protected WebElement element(String elementToken) {
        return element(elementToken, "");
    }

    protected WebElement element(String elementToken, String replacement1, String replacement2) {
        WebElement elem = null;
        elem = wait.waitForElementToBeVisible(driver
                .findElement(getLocator(elementToken, replacement1, replacement2)));
        return elem;
    }

    protected WebElement element(String elementToken, String replacement) {
        WebElement elem = null;
        elem = wait.waitForElementToBeVisible(driver
                .findElement(getLocator(elementToken, replacement)));
        return elem;
    }

    protected List<WebElement> elements(String elementToken, String replacement) {
        return wait.waitForElementsToBeVisible(driver.findElements(getLocator(
                elementToken, replacement)));
    }

    protected List<WebElement> elementsWithoutWait(String elementToken, String replacement) {
        return driver.findElements(getLocator(elementToken, replacement));
    }

    protected List<WebElement> elements(String elementToken, String replacement1, String replacement2) {
        return driver.findElements(getLocator(elementToken, replacement1, replacement2));
    }

    protected List<WebElement> elements(String elementToken) {
        return elements(elementToken, "");
    }

    protected List<WebElement> elementsWithoutWait(String elementToken) {
        return elementsWithoutWait(elementToken, "");
    }

    protected void _waitForElementToDisappear(String elementToken, String replacement) {
        int i = 0;
        int initTimeout = wait.getTimeout();
        wait.resetImplicitTimeout(2);
        int count;
        while (i <= 20) {
            if (replacement.isEmpty()) {
                count = elements(elementToken).size();
            } else {
                count = elements(elementToken, replacement).size();
            }
            if (count == 0) {
                break;
            }
            i += 2;
        }
        wait.resetImplicitTimeout(initTimeout);
    }

    List<String> loaderList = Arrays
            .asList("launchpad:xpath://div[@class='load-message']",
                    "QBA:classname:loader-spinner");

    public void waitForLoaderSpinnerToDisappear() {
        int timeout = wait.getTimeout();
        wait.resetImplicitTimeout(1);

        List<WebElement> elems = driver.findElements(By.className("LoadingScreen__spinner"));
        int j = 0;
        while (j < timeout) {
            if (elems.size() == 0) {
                break;
            }
            j += 1;
            wait.hardWait(1);
        }
        if (j > timeout && elems.size() != 0) {
            System.out.println("Size of Loader elements: " + elems.size());
            logMessage("Loader Spinner does NOT disappear!!!");
        }
        wait.resetImplicitTimeout(timeout);
    }

    protected void waitForElementToDisappear(String elementToken) {
        _waitForElementToDisappear(elementToken, "");
    }

    protected void waitForElementToDisappear(String elementToken, String replacement) {
        _waitForElementToDisappear(elementToken, replacement);
    }

    protected void isStringMatching(String actual, String expected) {
        Assert.assertEquals(actual, expected);
        logMessage("ACTUAL STRING : " + actual);
        logMessage("EXPECTED STRING :" + expected);
        logMessage("String compare Assertion passed.");
    }

    protected boolean isElementDisplayed(String elementName,
            String elementTextReplace) {
        //wait.waitForElementToBeVisible(element(elementName, elementTextReplace));
        boolean result = element(elementName, elementTextReplace).isDisplayed();
        assertTrue(result, "TEST FAILED: element '" + elementName
                + "with text " + elementTextReplace + "' is not displayed.");
        logMessage("TEST PASSED: element " + elementName + " with text "
                + elementTextReplace + " is displayed.");
        return result;
    }

    protected void verifyElementText(String elementName, String expectedText) {
        wait.waitForElementToBeVisible(element(elementName));
        assertEquals(element(elementName).getText().trim(), expectedText,
                "TEST FAILED: element '" + elementName
                + "' Text is not as expected: ");
        logMessage("TEST PASSED: element " + elementName
                + " is visible and Text is " + expectedText);
    }

    protected void verifyElementTextContains(String elementName, String expectedText) {
        wait.waitForElementToBeVisible(element(elementName));
        assertTrue(
                element(elementName).getText().trim().contains(expectedText), "TEST FAILED: element '" + elementName + "' Text is not as expected: ");
        logMessage("TEST PASSED: element " + elementName
                + " is visible and Text is " + expectedText);
    }

    protected boolean isElementDisplayed(String elementName) {
        wait.waitForElementToBeVisible(element(elementName));
        boolean result = element(elementName).isDisplayed();
        assertTrue(result, "TEST FAILED: element '" + elementName
                + "' is not displayed.");
        logMessage("TEST PASSED: element " + elementName
                + " is displayed.");
        return result;
    }
     protected void waitTOSync() {
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    protected boolean isElementEnabled(String elementName, boolean expected) {
        wait.waitForElementToBeVisible(element(elementName));
        boolean result = expected && element(elementName).isEnabled();
        assertTrue(result, "TEST FAILED: element '" + elementName
                + "' is  ENABLED :- " + !expected);
        logMessage("TEST PASSED: element " + elementName
                + " is enabled :- " + expected);
        return result;
    }

    protected By getLocator(String elementToken) {
        return getLocator(elementToken, "");
    }

    protected By getLocator(String elementToken, String replacement) {
        String[] locator = getELementFromFile(this.pageName, elementToken);
        locator[2] = locator[2].replaceAll("\\$\\{.+\\}", replacement);
        return getBy(locator[1].trim(), locator[2].trim());
    }

    protected By getLocator(String elementToken, String replacement1, String replacement2) {
        String[] locator = getELementFromFile(this.pageName, elementToken);
        locator[2] = StringUtils.replace(locator[2], "$", replacement1);
        locator[2] = StringUtils.replace(locator[2], "%", replacement2);
        return getBy(locator[1].trim(), locator[2].trim());
    }

    protected void clickOnElementUsingActionBuilder(WebElement element) {
        Actions builder = new Actions(driver);
        Actions MenuItems = builder.moveToElement(element);
        MenuItems.click().build().perform();
    }

    private By getBy(String locatorType, String locatorValue) {
        switch (Locators.valueOf(locatorType)) {
            case id:
                return By.id(locatorValue);
            case xpath:
                return By.xpath(locatorValue);
            case css:
                return By.cssSelector(locatorValue);
            case name:
                return By.name(locatorValue);
            case classname:
                return By.className(locatorValue);
            case linktext:
                return By.linkText(locatorValue);
            default:
                return By.id(locatorValue);
        }
    }

}
