package com.pages;

import com.driverManager.DriverFactory;
import helper.assertion.AssertionHelper;
import helper.assertion.VerificationHelper;
import helper.axe.actiondriver.Action;
import helper.javaScript.JavaScriptHelper;
import helper.logger.LoggerHelper;
import helper.wait.WaitHelper;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

public class BasePage {

    public WebDriver driver;
    public WebDriverWait wait;
    public Action action;
    public AssertionHelper assertionHelper;
    public VerificationHelper verificationHelper;
    public JavaScriptHelper javaScriptHelper;
    public static WaitHelper waitHelper;
    public static Logger log = LoggerHelper.getLogger(BasePage.class);
    private String url;
    private Properties prop;
    public static String screenShotDestinationPath;

    public BasePage() throws IOException {
        this.assertionHelper = new AssertionHelper();
        this.action = new Action();
        this.javaScriptHelper = new JavaScriptHelper(getDriver());
        this.verificationHelper = new VerificationHelper(getDriver());
        this.waitHelper= new WaitHelper(getDriver());
        this.wait = new WebDriverWait(getDriver(), 15);
        PageFactory.initElements(getDriver(), this);
    }




    public static WebDriver getDriver() {
        return DriverFactory.getDriver();
    }

    public void navigateToIndexPage(String url) {
        log.info("navigate To IndexPage....: " +url);
        getDriver().get(url);
    }

    public static String takeSnapShot(String name) throws IOException {
        File srcFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);

        String destFile = System.getProperty("user.dir") + "\\target\\screenshots\\" + timestamp() + ".png";
        screenShotDestinationPath = destFile;

        try {
            FileUtils.copyFile(srcFile, new File(destFile));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return name;

    }

    public static String timestamp() {
        return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
    }

    public static String getScreenshotDestinationPath() {
        return screenShotDestinationPath;
    }

    public static void waitForElementInvisible(WebElement element, int timer) throws IOException {
        WebDriverWait wait = new WebDriverWait(getDriver(), timer);
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public String generateRandomNumber(int length) {
        return RandomStringUtils.randomNumeric(length);
    }

    public String generateRandomString(int length) {
        return RandomStringUtils.randomAlphabetic(length);
    }

    public void sendKeysToWebElement(WebElement element, String textToSend) throws Exception {
        try {
            this.WaitUntilWebElementIsVisible(element);
            element.clear();
            element.sendKeys(textToSend);
            System.out.println("Successfully Sent the following keys: '" + textToSend + "' to element: " + "<"+ element.toString() + ">");
            log.info("Successfully Sent the following keys: '" + textToSend + "' to element: " + "<"+ element.toString() + ">");
        } catch (Exception e) {
            System.out.println("Unable to locate WebElement: " + "<" + element.toString() + "> and send the following keys: " + textToSend);
            log.info("Unable to locate WebElement: " + "<" + element.toString() + "> and send the following keys: " + textToSend);
            Assert.fail("Unable to send keys to WebElement, Exception: " + e.getMessage());
        }
    }
    public void sendKeys(WebElement element, String textToType) {
        log.info("Entered keys : " + "<" + textToType + ">");
        element.sendKeys(textToType);
    }

    public void waitFor(WebElement element) {
        log.info("waiting for WebElement: " + "<" + element.getText() + ">");
        WebDriverWait wait = new WebDriverWait(getDriver(), 30);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForWebElementAndClick(WebElement element) {
        log.info("WebElement is clicked: " + "<" + element.getText() + ">");
        element.click();
    }

    public void waitForAlert_And_ValidateText(String text) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 30);
        wait.until(ExpectedConditions.alertIsPresent());
        String alert_Message_Text = getDriver().switchTo().alert().getText();
        Assert.assertEquals(alert_Message_Text, text);
    }

    public static boolean findElement(WebDriver driver, WebElement ele) {
        boolean flag = false;
        try {
            ele.isDisplayed();

            flag = true;
        } catch (Exception e) {

            flag = false;
        } finally {
            if (flag) {
                log.info("Successfully Found element as :" + ele.getText());
                System.out.println("Successfully Found element as :" + ele.getText());
            } else {
                System.out.println("Unable to locate element at");
            }
        }
        return flag;
    }
    public static boolean isDisplayed(WebDriver driver, WebElement ele) {
        boolean flag = false;
        flag = findElement(driver, ele);
        if (flag) {
            flag = ele.isDisplayed();
            if (flag) {

                System.out.println("The element is Displayed as:  " + "<" + ele.getText() + ">");
                log.info("The element is Displayed as: " + "<" + ele.getText() + ">");
            } else {
                System.out.println("The element is not Displayed");
                log.error("The element is not Displayed: " + "<" + ele.getText() + ">");
            }
        } else {
            System.out.println("element Not displayed... ");
            log.error("element Not displayed...");
            System.out.println("element Not displayed...");
        }
        return flag;
    }

    public static boolean isSelected(WebDriver driver, WebElement ele) {

        boolean flag = false;
        flag = findElement(driver, ele);
        if (flag) {
            flag = ele.isSelected();
            if (flag) {
                System.out.println("The element is Selected:  " + "<" + ele.getText() + ">");
                log.info("The element is Selected:  " + "<" + ele.getText() + ">");
            } else {
                System.out.println("The element is not Selected");
            }
        } else {
            System.out.println("Not selected ");
        }
        return flag;
    }

    public static boolean isEnabled(WebDriver driver, WebElement ele) {
        boolean flag = false;
        flag = findElement(driver, ele);
        if (flag) {
            flag = ele.isEnabled();
            if (flag) {
                System.out.println("The element is Enabled: " + "<" + ele.getText() + ">");
                log.info("The element is " + ele.getText() + " Enabled");
            } else {
                System.out.println("The element is not Enabled: " + "<" + ele.getText() + ">");
                log.info("The element is not Enabled");
            }
        } else {
            System.out.println("Not Enabled ");
        }
        return flag;
    }

    public static boolean selectByVisibleText(String visibletext, WebElement ele) {
        boolean flag = false;
        try {
            Select s = new Select(ele);
            s.selectByVisibleText(visibletext);
            flag = true;
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            if (flag) {
                System.out.println("Option selected by VisibleText: " + "<" + visibletext + ">");
                log.info("Option selected by VisibleText: " + "<" + visibletext + ">");
            } else {
                System.out.println("Option not selected by VisibleText");
                log.error("Option selected by VisibleText : " + "<" + visibletext + ">");
            }
        }
    }

    public static boolean moveToElement(WebDriver driver, WebElement ele) {
        boolean flag = false;
        try {
            // WebElement element = driver.findElement(locator);
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].scrollIntoView(true);", ele);
            Actions actions = new Actions(driver);
            // actions.moveToElement(driver.findElement(locator)).build().perform();
            actions.moveToElement(ele).build().perform();
            flag = true;
            System.out.println("MouseOver axe is not performed on");
            log.info("MouseOver axe is not performed on");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    public static boolean mouseover(WebDriver driver, WebElement ele) {
        boolean flag = false;
        try {
            new Actions(driver).moveToElement(ele).build().perform();
            flag = true;
            return true;

        } catch (Exception e) {
            return false;
        } finally {
            System.out.println("MouseOver axe performed on");
            log.info("MouseOver axe performed on");

            if (flag) {
                System.out.println("MouseOver axe performed on");
            } else {

            }

        }
    }
    public boolean WaitUntilWebElementIsVisible(WebElement element) {
        try {
            this.wait.until(ExpectedConditions.visibilityOf(element));
            log.info("WebElement is visible using locator: " + "<" + element.toString() + ">");
            System.out.println("WebElement is visible using locator: " + "<" + element.toString() + ">");
            return true;
        } catch (Exception e) {
            log.info("WebElement is NOT visible, using locator: " + "<" + element.toString() + ">");
            System.out.println("WebElement is NOT visible, using locator: " + "<" + element.toString() + ">");

            Assert.fail("WebElement is NOT visible, Exception: " + e.getMessage());
            return false;
        }
    }

    public String getCurrentPageUrl() {
        try {
            String url = getDriver().getCurrentUrl();
            System.out.println("Found(Got) the following URL: " + url);
            return url;
        } catch (Exception e) {
            System.out.println("Unable to locate (Get) the current URL, Exception: " + e.getMessage());
            return e.getMessage();
        }
    }
    public String getCurrentPageTitle() {
        try {
            String title =  getDriver().getTitle();
            System.out.println("Found(Got) the following Title: " + title);
            return title;
        } catch (Exception e) {
            System.out.println("Unable to locate (Get) the current Title, Exception: " + e.getMessage());
            return e.getMessage();
        }
    }
    public String captureScreen(String fileName, WebDriver driver) {
        if (driver == null) {
            log.info("driver is null..");
            return null;
        }
        if (fileName == "") {
            fileName = "blank";
        }
        Reporter.log("captureScreen method called");
        File destFile = null;
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
        File screFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            destFile = new File("screenShot" + "/" + fileName + "_" + formater.format(calendar.getTime()) + ".png");
            Files.copy(screFile.toPath(), destFile.toPath());
            Reporter.log("<a href='" + destFile.getAbsolutePath() + "'><img src='" + destFile.getAbsolutePath() + "'height='100' width='100'/></a>");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return destFile.toString();
    }

    public String getText(WebElement element) {
        if (null == element) {
            log.info("WebElement is null..");
            return null;
        }
        boolean status = element.isDisplayed();
        if (status) {
            log.info("element text is .." + element.getText());
            //TestBase.logExtentReport("element text is .." + element.getText());
            return element.getText();
        } else {
            return null;
        }
    }

}

