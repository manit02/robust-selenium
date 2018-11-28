package com.robust.selenium.common;

import java.time.Duration;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import com.robust.selenium.configs.Browser;

public class SeleniumHelper {

	public static WebElement waitForElementToBeDisplayed(WebDriver driver, WebElement element) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(5))
				.pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class);

		wait.until(ExpectedConditions.visibilityOf(element));
		return element;
	}

	public static WebElement waitForElementToBeDisplayed(WebElement element) {
		return waitForElementToBeDisplayed(Browser.driver(), element);
	}

	public static WebElement waitForElementToBeClickable(WebDriver driver, WebElement element) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(5))
				.pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class);

		wait.until(ExpectedConditions.elementToBeClickable(element));
		return element;
	}

	public static WebElement waitForElementToBeClickable(WebElement element) {
		return waitForElementToBeClickable(Browser.driver(), element);
	}

	public static void selectFromDropdownByVisibleText(WebElement element, String text) {
		WebElement elem = waitForElementToBeClickable(element);
		Select select = new Select(elem);
		select.selectByVisibleText(text);
	}

	public static void moveToElement(WebDriver driver, WebElement element) {
		WebElement elem = waitForElementToBeClickable(element);
		Actions act = new Actions(driver);
		act.moveToElement(elem).build().perform();
	}

	public static void moveToElement(WebElement element) {
		moveToElement(Browser.driver(), element);
	}
}
