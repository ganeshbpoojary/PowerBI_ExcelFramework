package testlogic;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.LogStatus;
import com.thoughtworks.selenium.webdriven.commands.WaitForPageToLoad;

import frameworkutils.WebDriverFactory;
import uimaps.APPM_UI;
import uimaps.AssortInsight_UI;
import uimaps.SPlanning_UI;

public class AssortInsight_Logic extends WebDriverFactory{

	public AssortInsight_Logic(WebDriver driver, Map<String, String> dataBook) {
		super(driver, dataBook);
		// TODO Auto-generated constructor stub
	}


String url = dataBook.get("Url");
String email = dataBook.get("Email");
String pwd = dataBook.get("Password");
String filterName = dataBook.get("Fliter_Name");
String filterOption = dataBook.get("Filter_Option");
String chartName = dataBook.get("Chart_Name");
String summaryHeader = dataBook.get("SummaryColumn_Header");
String detailHeader = dataBook.get("DetailedViewColumn_Header");

//Validate the dropdown has data 
public void validateDropDownHasData_Assort() {

	synchronized (AssortInsight_Logic.class) {
		try {
			waitForPageToLoad();
			clickonFilterandValidatethedata_Asoort(filterName);
			extentTest.log(LogStatus.PASS, "Drop Down Data presence validation", "Drop Down has Data");
		}				
		 catch (Exception e) {
			// TODO Auto-generated catch block
			 extentTest.log(LogStatus.FAIL, "Drop Down Data presence validation", "Drop Down has no Data");
			e.printStackTrace();
		}
	}
}



//Validate value in the dropdown
public void validateValueInDropDown_Assort() {
	synchronized (AssortInsight_Logic.class) {
		try {
			waitForPageToLoad();
			clickonFilterandValidatethedata_Asoort(filterName);
			checkDropDownForOption_Assort(filterOption);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

//Validate the AssortPerformdataAssort
public void validateAssortPerformTabledata_Assort() {

	synchronized (AssortInsight_Logic.class) {
		try {
			waitForPageToLoad();
//			jsClickOn(AssortInsight_UI.title_AssortmentPerformance);
			isDisplayed(AssortInsight_UI.AssortPerformTableChart);
			extentTest.log(LogStatus.PASS, "AssortPerformTabledata validation", "AssortPerformTabledata has Data");
		}				
		 catch (Exception e) {
			// TODO Auto-generated catch block
			 extentTest.log(LogStatus.FAIL, "AssortPerformTabledata validation", "AssortPerformTabledata has no Data");
			e.printStackTrace();
		}
	}
}

//Validate Last updated data 
public void validateLastUpdateData_Assort()
{
synchronized (AssortInsight_UI.class) {
	try {
		waitForElementTobeLocated(AssortInsight_UI.label_Lastupdated);
        waitForPageToLoad();
        isDisplayed(AssortInsight_UI.label_Lastupdated);
		extentTest.log(LogStatus.PASS, "date LastUpdated  is enabled", "date LastUpdated has Data");
	}				
	 catch (Exception e) {
		// TODO Auto-generated catch block
		 extentTest.log(LogStatus.FAIL, "date LastUpdated disabled", "date LastUpdated has no Data");
		e.printStackTrace();
	}
}
}

//verify that scrolling the page is working 
	 public void verifyscrolling_Assort()
	    {
		 synchronized (SPlanning_Logic.class) {
			 try {
				 waitForPageToLoad();
//				 clickOn(AssortInsight_UI.title_AssortmentPerformance);
//					waitForPageToLoad();
					    JavascriptExecutor js = (JavascriptExecutor) driver;
				        js.executeScript("window.scrollBy(0,500)", "");
				        js.executeScript("window.scrollBy(0,-500)");
					extentTest.log(LogStatus.PASS, "Scrolling is working fine ", "Scrolling is working fine");
				}				
				 catch (Exception e) {
					// TODO Auto-generated catch block
					 extentTest.log(LogStatus.FAIL, "Scrolling is not  working fine", "Scrolling is not working fine");
					e.printStackTrace();
				}
		 }
	    }
	 
//Validate Assort actualvsbudget_salesAssort
public void validate_AssortPerfor_actualvsbudget_salesAssort()
{
synchronized (AssortInsight_UI.class) {
	try {
		waitForElementTobeLocated(AssortInsight_UI.title_AssortmentPerformance);
//		clickOn(AssortInsight_UI.title_AssortmentPerformance);
        waitForPageToLoad();
        isDisplayed(AssortInsight_UI.AssortActualvsBudgetSalesChart);
		extentTest.log(LogStatus.PASS, "AssortPerfor_actualvsbudget sales is enabled", "AssortPerfor_actualvsbudget has Data");
	}				
	 catch (Exception e) {
		// TODO Auto-generated catch block
		 extentTest.log(LogStatus.FAIL, "AssortPerfor_actualvsbudget sales disabled", "AssortPerfor_actualvsbudget has no Data");
		e.printStackTrace();
	}
}
}

//Validate actualvsbudget_MarginAssort
public void validate_AssortPerfor_actualvsbudget_MarginAssort()
{
synchronized (AssortInsight_UI.class) {
	try {
		waitForElementTobeLocated(AssortInsight_UI.title_AssortmentPerformance);
		waitForPageToLoad();
//		jsClickOn(AssortInsight_UI.title_AssortmentPerformance);
        waitForPageToLoad();
        doubleClick(AssortInsight_UI.AssortMarginButton);
        waitForPageToLoad();
        isDisplayed(AssortInsight_UI.AssortActualvsBudgetMarginChart);
		extentTest.log(LogStatus.PASS, "AssortPerfor_actualvsbudget Margin is enabled", "AssortPerfor_actualvsbudget Margin has Data");
	}				
	 catch (Exception e) {
		// TODO Auto-generated catch block
		 extentTest.log(LogStatus.FAIL, "AssortPerfor_actualvsbudget Margin disabled", "AssortPerfor_actualvsbudget Margin has no Data");
		e.printStackTrace();
	}
}
}

//Validate AssortPerformButton
public void validate_AssortPerformSalesButton_Assort()
{
synchronized (AssortInsight_UI.class) {
	try {
		waitForElementTobeLocated(AssortInsight_UI.title_AssortmentPerformance);
//		clickOn(AssortInsight_UI.title_AssortmentPerformance);
		jsClickOn(AssortInsight_UI.title_AssortmentPerformance);
        waitForPageToLoad();
       isDisplayed(AssortInsight_UI.AssortSalesButton);
       waitForPageToLoad();
       isDisplayed(AssortInsight_UI.AssortActualvsBudgetSalesChart);
       extentTest.log(LogStatus.PASS, "AssortPerfom_Sales button is enabled", "Sales button enable ");
	}				
	 catch (Exception e) {
		// TODO Auto-generated catch block
		 extentTest.log(LogStatus.FAIL, "AssortPerform Sales button disabled", "Sales button disabled");
		e.printStackTrace();
	}
}
}

//Validate AssortPerformingMargin
public void validate_AssortPerformMarginAssort()
{
synchronized (AssortInsight_UI.class) {
	try {
		waitForElementTobeLocated(AssortInsight_UI.title_AssortmentPerformance);
//		jsClickOn(AssortInsight_UI.title_AssortmentPerformance);
		waitForPageToLoad();
//		is(AssortInsight_UI.AssortMarginButton);
//		jsClickOn(AssortInsight_UI.AssortMarginButton);
		doubleClick(AssortInsight_UI.AssortMarginButton);
	       waitForPageToLoad();
	       isDisplayed(AssortInsight_UI.AssortActualvsBudgetMarginChart);
		extentTest.log(LogStatus.PASS, "AssortActualvsBudgetMarginChart button is enabled", "Margin chart  enable ");
	}				
	 catch (Exception e) {
		// TODO Auto-generated catch block
		 extentTest.log(LogStatus.FAIL, "AssortPerform Margin button disabled", "Margin chart disabled");
		e.printStackTrace();
	}
}
}

//Validate AssortProductPerformChart
public void validate_AssortProductPrform_chart()
{
synchronized (AssortInsight_UI.class) {
	try {
		waitForElementTobeLocated(AssortInsight_UI.title_ProductPerformance);
		clickOn(AssortInsight_UI.title_ProductPerformance);
        waitForPageToLoad();
        isDisplayed(AssortInsight_UI.ProductPerformanceTableChart);
        isDisplayed(AssortInsight_UI.ProductPerformanceOverallPerf);
        isDisplayed(AssortInsight_UI.ProductPerfProductInsight);
		extentTest.log(LogStatus.PASS, "AssortProductPrform_chart is enabled", "AssortProductPrform_chart has Data");
	}				
	 catch (Exception e) {
		// TODO Auto-generated catch block
		 extentTest.log(LogStatus.FAIL, "AssortProductPrform_chart disabled", "AssortProductPrform_chart has no Data");
		e.printStackTrace();
	}
}
}

//Validate AssortPeretochart
public void validate_AssortPereto_chart()
{
synchronized (AssortInsight_UI.class) {
	try {
		waitForElementTobeLocated(AssortInsight_UI.title_ProductPerformance);
		clickOn(AssortInsight_UI.title_ProductPerformance);
        waitForPageToLoad();
        isDisplayed(AssortInsight_UI.ProductPatrioSalesButton);
        isDisplayed(AssortInsight_UI.ProductPatrioUnitsButton);
        isDisplayed(AssortInsight_UI.ProductParetoMarginButton);
		extentTest.log(LogStatus.PASS, "AssortPeretois enabled", "AssortPereto has Data");
	}				
	 catch (Exception e) {
		// TODO Auto-generated catch block
		 extentTest.log(LogStatus.FAIL, "AssortPereto disabled", "AssortPereto has no Data");
		e.printStackTrace();
	}
}
}
//Validate Assort pereto_CumilativeSales
public void validate_AssortPereto_CumilativeSales()
{
synchronized (AssortInsight_UI.class) {
	try {
		waitForElementTobeLocated(AssortInsight_UI.title_ProductPerformance);
		clickOn(AssortInsight_UI.title_ProductPerformance);
        waitForPageToLoad();
        isDisplayed(AssortInsight_UI.ProductParetocumulative);
        isDisplayed(AssortInsight_UI.ProductParetoChart);
       extentTest.log(LogStatus.PASS, "AssortPereto cumilative sales is enabled", "AssortPereto cumilative sales has Data");
	}				
	 catch (Exception e) {
		// TODO Auto-generated catch block
		 extentTest.log(LogStatus.FAIL, "AssortPereto cumilative salesdisabled", "AssortPereto cumilative sales has no Data");
		e.printStackTrace();
	}
}
}

//Validate the assortstoreperformance 
public void validate_AssortStorePerformance()
{
synchronized (AssortInsight_UI.class) {
	try {
		waitForElementTobeLocated(AssortInsight_UI.title_StorePerformance);
		clickOn(AssortInsight_UI.title_StorePerformance);
        waitForPageToLoad();
        isDisplayed(AssortInsight_UI.StorePerformanceTableChart);
        isDisplayed(AssortInsight_UI.StorePerfProductInsight);
       extentTest.log(LogStatus.PASS, "AssortPereto StorePerformance is enabled", "AssortPereto StorePerformance has Data");
	}				
	 catch (Exception e) {
		// TODO Auto-generated catch block
		 extentTest.log(LogStatus.FAIL, "AssortPereto StorePerformance disabled", "AssortPereto StorePerformance has no Data");
		e.printStackTrace();
	}
}
}
//validate the assort storeID
public void validate_AssortStoreStoreID()
{
synchronized (AssortInsight_UI.class) {
	try {
		waitForElementTobeLocated(AssortInsight_UI.title_StorePerformance);
		clickOn(AssortInsight_UI.title_StorePerformance);
        waitForPageToLoad();
        isDisplayed(AssortInsight_UI.StorePerfCPIBYStoreID);
        extentTest.log(LogStatus.PASS, "AssortPereto StorePerformance is enabled", "AssortPereto StorePerformance has Data");
	}				
	 catch (Exception e) {
		// TODO Auto-generated catch block
		 extentTest.log(LogStatus.FAIL, "AssortPereto StorePerformance disabled", "AssortPereto StorePerformance has no Data");
		e.printStackTrace();
	}
}
}
//check for the seach option in the dropdown list
public void clickonFilterandchecktheSearchButton_Assort()
{
	synchronized (AssortInsight_UI.class) {
		try {
			 waitForPageToLoad();
			 isDisplayed(AssortInsight_UI.AssortSearch);
			 extentTest.log(LogStatus.PASS, "AssortPereto Search is enabled", "AssortPereto Search  has Data");
		
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			 extentTest.log(LogStatus.FAIL, "AssortPereto Search  disabled", "AssortPereto Search  has no Data");
			e.printStackTrace();
		}
	}
    
   
    }

//check dropdown option in the dropdown list 
private boolean checkDropDownForOption_Assort(String opt) {
	waitForPageToLoad();
	int rows = getFilterDropDownRowCount_Assort();
	for (int i = 1; i <= rows; i++) {
		String value = driver.findElement(By.xpath(
				"(//input[@aria-label='Search']//ancestor::div[@class='slicer-dropdown-content']//div[@class='slicerBody']//div[@class='row'])["
						+ i + "]//span[@class='slicerText']"))
				.getText();
		if (value.equals(opt)) {
			extentTest.log(LogStatus.INFO, "checkDropDownForOption: ", "Option is present- <B>[" + opt + "]</B>");
			return true;
		} else {
			extentTest.log(LogStatus.FAIL, "checkDropDownForOption: ",
					"Option is not present- <B>[" + opt + "]</B>");
		}
	}
	return false;
}
//get the filter dropdown 	
private int getFilterDropDownRowCount_Assort() {
	WebDriverWait wait = new WebDriverWait(driver, 1200);
	wait.until(ExpectedConditions.visibilityOfElementLocated(AssortInsight_UI.opt_dropDownRowsData));
	try {
		List<WebElement> rows = driver.findElements(AssortInsight_UI.opt_dropDownRowsData);
		int size = rows.size();
		extentTest.log(LogStatus.INFO, "getDropDownRowCount: ", "Number of rows is- <B>[" + size + "]</B>");
		return size;
	} catch (NoSuchElementException nsex) {
		return -1;
	}

}

//click on the filter validation 
public void clickonFilterandValidatethedata_Asoort(String Filtername)
{
	waitForPageToLoad();
    driver.findElement(By.xpath("//*[@aria-label='"+Filtername+"']//ancestor::div[contains(@class,'slicer-container')]//div[@class='slicer-dropdown-menu']")).click();
    List<WebElement> checkboxes = driver.findElements(By.xpath("//*[@class='slicerCheckbox']"));
    if (checkboxes.size()>0) {
//        driver.findElement(By.xpath("//*[@aria-label='"+Filtername+"']//ancestor::div[contains(@class,'slicer-container')]//div[@class='slicer-dropdown-menu']")).click();
    	return ;
    }

}


}