package com.actiTimeProject.testscripts;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.actiTimeProject.generic.Baseclass;
import com.actiTimeProject.generic.FileLib;
import com.actiTimeProject.objectrepository.EnterTimeTrackPage;
import com.actiTimeProject.objectrepository.TaskListPage;

@Listeners(com.actiTimeProject.generic.ListenerImplementation.class)

public class CustomerModule extends Baseclass{
@Test
public void testCreateCustomer() throws InterruptedException, IOException {
	FileLib f=new FileLib();
	String CustomerName = f.getExcelvalue("CreateCustomer", 1, 1);
	String CustomerDescription = f.getExcelvalue("CreateCustomer", 1, 2);
EnterTimeTrackPage e=new EnterTimeTrackPage(driver);
//click on task tab
e.getTasktab().click();

TaskListPage t=new TaskListPage(driver);
//click on add new button
t.getAddNewBtn().click();
//click on Add new Customer option
t.getNewCustomerOption().click();

t.getEnterCustomertbx().sendKeys(CustomerName);
t.getEnterCustomerDescriptiontbx().sendKeys(CustomerDescription);
t.getSelectCustomerDropDown().click();
t.getOurCompanyOption().click();
t.getCreateCustomerBtn().click();
WebDriverWait wait=new WebDriverWait(driver, 10);
wait.until(ExpectedConditions.textToBePresentInElement(t.getActualCustomerCreated(), CustomerName));
String ActualCustomer = t.getActualCustomerCreated().getText();
Assert.assertEquals(ActualCustomer,CustomerName);
}
}
	


