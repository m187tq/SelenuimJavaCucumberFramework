package com.utils;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class GenericUtils {
	public WebDriver driver;
	protected WebDriverWait wait;

	public GenericUtils(WebDriver driver)
	{
		this.driver = driver;
		wait = new WebDriverWait(driver, 15);
	}

	public void SwitchWindowToChild()
	{
		Set<String> s1=driver.getWindowHandles();
		Iterator<String> i1 =s1.iterator();
		String parentWindow = i1.next();
		String childWindow = i1.next();
		driver.switchTo().window(childWindow);
	}

	public void navigateToApplicationUrl(String url) {
		driver.get(url);
		System.out.println("navigating to >> : +url");
	}

	public void getApplicationUrl(String url) {
		driver.get(url);
		System.out.println("navigating to ..." + url);
	}

	public void navigateToUrl(String url) {
		System.out.println("navigates to the url: " + url);
		driver.get(url);
	}

	public String generateRandomNumber(int length) {
		System.out.println("Entered generated Random loginName.... ");
		return RandomStringUtils.randomNumeric(length);
	}

	public String generateRandomString(int length) {
		return RandomStringUtils.randomAlphabetic(length);
	}

	public void sendKeys(By by, String textToType) {
		System.out.println("Entered text :" + textToType);
		this.wait.until(ExpectedConditions.elementToBeClickable(by)).sendKeys(textToType);
	}

	public void sendKeys(WebElement element, String textToType) {
		element.clear();
		System.out.println("Entered text :" + textToType);
		this.wait.until(ExpectedConditions.elementToBeClickable(element)).sendKeys(textToType);
	}

	public void waitForWebElementAndClick(By by) {

		System.out.println("Waited and clicked on the element: ");
		wait.until(ExpectedConditions.elementToBeClickable(by)).click();
	}

	public void waitForWebElementAndClick(WebElement element) {
		System.out.println("Waited and clicked on the element: " + element.getText());
		wait.until(ExpectedConditions.elementToBeClickable(element)).click();
	}


	public int getCountWebElements(WebElement element) {
		System.out.println("Count element: " + element.getText());
		return driver.findElements((By) element).size();
	}

	public List<String> getAccountsSectionsList(WebElement element) {
		List<String> accountsList = new ArrayList<>();
		List<WebElement> accountsHeaderList = driver.findElements((By) element);
		for (WebElement e : accountsHeaderList) {
			String text = e.getText();
			System.out.println(text);
			accountsList.add(text);
		}
		return accountsList;
	}
	
}
