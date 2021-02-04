
package com.actiTimeProject.generic;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverCommonLib {

	public void waitForElementVisibility(WebDriver driver, WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(element));
		}
	public void waitForElementTextTobePresent(WebDriver driver, WebElement element,String text) {
		WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.textToBePresentInElement(element, text));
		}
	public void waitForElementInGUI(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	public void cutomWait(WebElement element)
	{
		int i=0;
		while(i<100) {
			try {
				element.isDisplayed();
				break;
			}
			catch(NoSuchElementException e)		{
				i++;
			}
		}
	}
	public void SelectOption(WebElement element, int i) {
		Select s=new Select(element);
		s.selectByIndex(i);
	}
	public void SelectOption(WebElement element,String text) {
		Select s=new Select(element);
		s.deselectByVisibleText(text);
	}
}
