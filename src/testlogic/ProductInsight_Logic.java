package testlogic;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.relevantcodes.extentreports.LogStatus;
import frameworkutils.WebDriverFactory;
import uimaps.ProductInsight_UI;

public class ProductInsight_Logic extends WebDriverFactory {

	public ProductInsight_Logic(WebDriver driver, Map<String, String> dataBook) {
		super(driver, dataBook);
		// TODO Auto-generated constructor stub
	}
	String filterName = dataBook.get("Fliter_Name");
	String filterOption = dataBook.get("Filter_Option");
	
	//click on the filter validation 
	public boolean clickonFilterandValidatethedata_ProductInsight(String Filtername)
	{
		waitForPageToLoad();
	  driver.findElement(By.xpath("//*[@aria-label='"+Filtername+"']//ancestor::div[contains(@class,'slicer-container')]//div[@class='slicer-dropdown-menu']")).click();
	  	    List<WebElement> checkboxes = driver.findElements(By.xpath("//*[@class='slicerCheckbox']"));
	    if (checkboxes.size()>0) {
//	        driver.findElement(By.xpath("//*[@aria-label='"+Filtername+"']//ancestor::div[contains(@class,'slicer-container')]//div[@class='slicer-dropdown-menu']")).click();
	    	return true ;
	    }
		return false;

	}
	private boolean checkDropDownForOption_ProductInsight(String opt) {
		waitForPageToLoad();
		
		int rows = getFilterDropDownRowCount_ProductInsight();
		for (int i = 1; i <= rows; i++) {
			String value = driver.findElement(By.xpath(
					"(//input[@aria-label='Search']//ancestor::div[@class='slicer-dropdown-content']//div[@class='slicerBody']//div[@class='row'])["
							+ i + "]//span[@class='slicerText']"))
					.getText();
			if (value.contains(opt)) {
								return true;
			} else {
				return false;
			}
		}
		return false;
	}
	
	//not working for radio button
	private boolean clickGivenDropDownForOption_ProductInsight(String Filter_Option) {
		waitForPageToLoad();
				 {
					 synchronized (ProductInsight_Logic.class) {
			 driver.findElement(By.xpath(
					"(//input[@aria-label='Search']//ancestor::div[@class='slicer-dropdown-content']//div[@class='slicerBody']//div[@class='row'])//span[@title='"+Filter_Option+"']")).click();
				return true;
			}}
	
}
	//not working
	private void clickDrodpdownRadioButton_ProductInsight() {
		synchronized (ProductInsight_Logic.class) {
		try{
			/*if(!driver.findElement(By.xpath(
		
					"(//input[@aria-label='Search']//ancestor::div[@class='slicer-dropdown-content']//div[@class='slicerBody']//div[@class='row'])//span[@title='"+Filter_Option+"]")).isSelected());
		driver.findElement(By.xpath(
				"(//input[@aria-label='Search']//ancestor::div[@class='slicer-dropdown-content']//div[@class='slicerBody']//div[@class='row'])//span[@title='"+Filter_Option+"]")).click();
		driver.findElement(By.xpath(
				"(//input[@aria-label='Search']//ancestor::div[@class='slicer-dropdown-content']//div[@class='slicerBody']//div[@class='row'])//span[@title='"+Filter_Option+"]")).click();
		extentTest.log(LogStatus.PASS,"Dropdown is clicking","Dropdown is clicking");						
			*/
			
			if(doubleClick(ProductInsight_UI.MetriSales))
							extentTest.log(LogStatus.PASS,"Dropdown is clicking","Dropdown is clicking");
			else
				 extentTest.log(LogStatus.FAIL,"Dropdown is not clicking","Dropdown is not clicking");
			}
		catch(Exception e)
		{
				
				return;	
		}	}	
}

	
	private int getFilterDropDownRowCount_ProductInsight() {
		synchronized (ProductInsight_Logic.class) {
		waitForPageToLoad();
		WebDriverWait wait = new WebDriverWait(driver, 1200);
		wait.until(ExpectedConditions.visibilityOfElementLocated(ProductInsight_UI.opt_dropDownRowsData));
		try {
			List<WebElement> rows = driver.findElements(ProductInsight_UI.opt_dropDownRowsData);
			int size = rows.size();
			extentTest.log(LogStatus.INFO, "getDropDownRowCount: ", "Number of rows is- <B>[" + size + "]</B>");
			return size;
		} catch (NoSuchElementException nsex) {
			return -1;
		}}
	}
	

	public void validateValueInDropDown_ProductInsight() {
		synchronized (ProductInsight_Logic.class) {
			try {
				waitForPageToLoad();
				clickonFilterandValidatethedata_ProductInsight(filterName);
				if(checkDropDownForOption_ProductInsight(filterOption))
					extentTest.log(LogStatus.PASS,"Dropdown is clicking","Dropdown is clicking");	
				
				else
				
					extentTest.log(LogStatus.FAIL,"Dropdown is not  clicking","Dropdown not  clicking");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void validateValueInDropDownAndSelect_ProductInsight() {
		synchronized (ProductInsight_Logic.class) {
			try {
				waitForPageToLoad();
				clickonFilterandValidatethedata_ProductInsight(filterName);
				if(clickGivenDropDownForOption_ProductInsight(filterOption))
					extentTest.log(LogStatus.PASS, "Dropdown is verified ", "Dropdown is verified");
				else
					extentTest.log(LogStatus.PASS, "Dropdown is not verified ", "Dropdown is not verified");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void onlyClickOnTheDrodpdown()
	{
		synchronized (ProductInsight_Logic.class) {
			try {
				waitForPageToLoad();
				if(clickonFilterandValidatethedata_ProductInsight(filterName)) 
				
					extentTest.log(LogStatus.PASS,"Dropdown is clicking","Dropdown is clicking");	
				
				else
				
					extentTest.log(LogStatus.FAIL,"Dropdown is not  clicking","Dropdown not  clicking");
								
				} catch (Exception e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}}	
		
	}
	
		
	public void Validate_MixAnalysesDashboard_ProductInsight() {
		synchronized (ProductInsight_Logic.class) {
			try {
				waitForPageToLoad();
				waitForElementTobeLocated(ProductInsight_UI.titleMixAlanyses);
				doubleClick(ProductInsight_UI.titleMixAlanyses);
				if (isDisplayed(ProductInsight_UI.questionProductMixSubGroup))
					 extentTest.log(LogStatus.PASS, "MixAnalysesDashboard is enabled", "MixAnalysesDashboard is enabled");
				else
					 extentTest.log(LogStatus.PASS, "MixAnalysesDashboard is  not enabled", "MixAnalysesDashboard is not enabled");

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
	//Validate the Mix analyses page
	public void validate_MixAnalysesPage_ProductInsight() {

		synchronized (ProductInsight_Logic.class) {
			try {
				waitForPageToLoad();
				waitForElementTobeLocated(ProductInsight_UI.titleMixAlanyses);
				doubleClick(ProductInsight_UI.titleMixAlanyses);
				if (isDisplayed(ProductInsight_UI.questionProductMixSubGroup)
						&&isDisplayed(ProductInsight_UI.questionSubGroupitemcountbymonth)
						&&isDisplayed(ProductInsight_UI.questionWhatAreMyKeyValueItem)
						&&isDisplayed(ProductInsight_UI.itemdistrubutionchart)
					    &&isDisplayed(ProductInsight_UI.itemchart)
					    &&isDisplayed(ProductInsight_UI.metricchart)
					    &&isDisplayed(ProductInsight_UI.label_Lastupdated))
					extentTest.log(LogStatus.PASS, "WhatAnalyses page is enabled", "WhatAnalyses page is enabled");
				else
					extentTest.log(LogStatus.PASS, "WhatAnalyses page is not enabled", "WhatAnalyses page is not enabled");	
								}
			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
	}
	}
	public void ClickonWhatAreMyKeyValue_ProductInsight()
	{
	synchronized (ProductInsight_Logic.class) {
		try {
			waitForPageToLoad();
			waitForElementTobeLocated(ProductInsight_UI.questionWhatAreMyKeyValueItem);
			doubleClick(ProductInsight_UI.questionWhatAreMyKeyValueItem);
	        waitForPageToLoad();
	        isDisplayed(ProductInsight_UI.keyValueItem);
	       extentTest.log(LogStatus.PASS, "WhatAreMyKeyValue is enabled", "WhatAreMyKeyValue is enabled");
		}				
		 catch (Exception e) {
			// TODO Auto-generated catch block
			 extentTest.log(LogStatus.FAIL, "WhatAreMyKeyValue is not enabled", "WhatAreMyKeyValue is not enabled");
			e.printStackTrace();
		}
	}
	}
	
	public void VerifyWhatAreMyKeyValueDetails_ProductInsight()
	{
	synchronized (ProductInsight_Logic.class) {
		try {
			waitForPageToLoad();
			if(isDisplayed(ProductInsight_UI.keyValueItem)
					&& isDisplayed(ProductInsight_UI.KVIchart)
					&& isDisplayed(ProductInsight_UI.questionHowAreMyKVI) 
					&& isDisplayed(ProductInsight_UI.detailsKVIAndNonKVIitemshareAndCount)
					&& isDisplayed(ProductInsight_UI.questiondetailsKVIAndNonKVIitemshareAndCount)
					&& isDisplayed(ProductInsight_UI.KVIPerformingChart)
					&& isDisplayed(ProductInsight_UI.yaxiesMetricValue))
	       extentTest.log(LogStatus.PASS, "WhatAreMyKeyValue page has data", "WhatAreMyKeyValue page has  data");
	       
	       else
	    	   extentTest.log(LogStatus.FAIL, "WhatAreMyKeyValue page has no data", "WhatAreMyKeyValue is no data");
		}				
		 catch (Exception e) {
			// TODO Auto-generated catch block
			 e.printStackTrace();
		}
	}
	}
	


public void VerifyWhatAreMyKeyTableDetails_ProductInsight()
{
synchronized (ProductInsight_Logic.class) {
	try {
		waitForPageToLoad();
		if(isDisplayed(ProductInsight_UI.keyValueItem)
				&& isDisplayed(ProductInsight_UI.tabletitleItem)
				&& isDisplayed(ProductInsight_UI.tabletitleProductName) 
				&& isDisplayed(ProductInsight_UI.tabletitleRevenue)
				&& isDisplayed(ProductInsight_UI.tabletitleSales_Units_Share)
				&& isDisplayed(ProductInsight_UI.tabletitleGrossProfitShare)
				&& isDisplayed(ProductInsight_UI.tabletitleMargin)
			    && isDisplayed(ProductInsight_UI.tabletitleAverageUnitRetail)
			    && isDisplayed(ProductInsight_UI.tabletitlePurchaseFrequency))
			    
       extentTest.log(LogStatus.PASS, "WhatAreMyKeyValue Table page has data", "WhatAreMyKeyValue Table page has  data");
       
       else
    	   extentTest.log(LogStatus.FAIL, "WhatAreMyKeyValue Table page has no data", "WhatAreMyKeyValue Table page is no data");
	}				
	 catch (Exception e) {
		// TODO Auto-generated catch block
		 e.printStackTrace();
	}
}
}

public void validate_KVIPerformingTableHasData_ProductInsight() {
	synchronized (ProductInsight_Logic.class) {
		int dataCell =0 ;
		try {
			waitForElementTobeLocated(ProductInsight_UI.tablevalueintable);
			int rowCnt = getElementsCount(ProductInsight_UI.tablevalueintable);
			for (int i = 1; i <= rowCnt; i++) {
				By elm = By.xpath(
						"(//*[@class='pivotTableCellWrap cell-interactive tablixAlignRight '])['"+i+"']");
				if (!getTextOf(elm).equals(""))
					dataCell = dataCell +1;
			}
			if (dataCell > 0)
				extentTest.log(LogStatus.PASS, "Table should have data", "Table is having data cells - <B>[" + dataCell + "]</B>");
			else
				extentTest.log(LogStatus.FAIL, "Table should have data", "Table is not having data");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}


}

