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
import com.thoughtworks.selenium.webdriven.commands.WaitForPageToLoad;

import frameworkutils.WebDriverFactory;
import uimaps.AnamolyDetection_UI;
import uimaps.Shopper_UI;


public class AnamolyDetection_Logic extends WebDriverFactory {

	public AnamolyDetection_Logic(WebDriver driver, Map<String, String> dataBook) {
		super(driver, dataBook);
		// TODO Auto-generated constructor stub
	}

	String filterName = dataBook.get("Fliter_Name");
	String filterOption = dataBook.get("Filter_Option");
	String chartName = dataBook.get("Chart_Name");
	String summaryHeader = dataBook.get("SummaryColumn_Header");
	String detailHeader = dataBook.get("DetailedViewColumn_Header");
	

	/**
	 * Navigates to Understand Page
	 * 
	 **/
	public void goto_UnderstandPage_Anamoly() {
		synchronized (AnamolyDetection_Logic.class) {
			try {
				rightClick(AnamolyDetection_UI.btn_Understand);
				waitForElementTobeClickable(AnamolyDetection_UI.navBtn_DrillThrough);
				clickOn(AnamolyDetection_UI.navBtn_DrillThrough);
				waitForElementTobeClickable(AnamolyDetection_UI.navBtn_Understand);
				clickOn(AnamolyDetection_UI.navBtn_Understand);
				waitForElementTobeLocated(AnamolyDetection_UI.title_Understand);
			}
			 catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public boolean verify_UnderstandPage_Anamoly() {
		synchronized (AnamolyDetection_Logic.class) {
			try {
				waitForElementTobeLocated(AnamolyDetection_UI.understandTable);
				isDisplayed(AnamolyDetection_UI.table_UnderStand_ColumnCount);
				List<WebElement> tableheader = driver.findElements(By.xpath("//div[@role='presentation']//div[@role='columnheader']"));
				List<WebElement> tablerowcount = driver.findElements(By.xpath("(//div[@role='row'])"));
				 return tableheader.size()>0&&tablerowcount.size()>0;
				
				
				
			}
			 catch (Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	
	
	/**
	 * Navigates to Investigate page
	 * 
	 **/
	public void goto_Investigatepage_Anamoly() {
		synchronized (AnamolyDetection_Logic.class) {
			try {
				rightClick(AnamolyDetection_UI.btn_Understand);
				waitForElementTobeClickable(AnamolyDetection_UI.navBtn_DrillThrough);
				clickOn(AnamolyDetection_UI.navBtn_DrillThrough);
				waitForElementTobeClickable(AnamolyDetection_UI.navBtn_Understand);
				clickOn(AnamolyDetection_UI.navBtn_Understand);
				waitForElementTobeLocated(AnamolyDetection_UI.title_Understand);
			}
			 catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	

	
	public void validateDropDownHasData_Anamoly() {
		synchronized (AnamolyDetection_Logic.class) {
			try {
				waitForPageToLoad();
				clickonFilterandValidatethedata_Anamoly();
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
	public void validateValueInDropDown_Anamoly() {
		synchronized (AnamolyDetection_Logic.class) {
			try {
				waitForPageToLoad();
				checkDropDownForOption_Anamoly(filterOption);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	//validate the Stores, units, sales, transactions labels
	public void validateLabels_Anamoly() {
		synchronized (AnamolyDetection_Logic.class) {
			try {
				waitForPageToLoad();
		isDisplayed(AnamolyDetection_UI.outlierItemStore);
		isDisplayed(AnamolyDetection_UI.outlierUnits);
		isDisplayed(AnamolyDetection_UI.outlierSales);
		isDisplayed(AnamolyDetection_UI.outlierTransactions);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	

	public void clickonFilterandchecktheSearchButton_Anamoly()	{
		synchronized (AnamolyDetection_Logic.class) {
			try {
				 waitForPageToLoad();
				 isDisplayed(AnamolyDetection_UI.anamolySearch);
				 extentTest.log(LogStatus.PASS, "Anamoly Search is enabled", "Anamoly Search  has Data");
			
			}
			catch (Exception e) {
				// TODO Auto-generated catch block
				 extentTest.log(LogStatus.FAIL, "Anamoly Search  disabled", "Anamoly Search  has no Data");
				e.printStackTrace();
			}
		}
	    
	   
	    }
	//check dropdown option in the dropdown list 
	private boolean checkDropDownForOption_Anamoly(String opt) {
		waitForPageToLoad();
		int rows = getFilterDropDownRowCount_Anamoly();
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
	
	private int getFilterDropDownRowCount_Anamoly() {
		WebDriverWait wait = new WebDriverWait(driver, 1200);
		wait.until(ExpectedConditions.visibilityOfElementLocated(AnamolyDetection_UI.opt_dropDownRowsData));
		try {
			List<WebElement> rows = driver.findElements(AnamolyDetection_UI.opt_dropDownRowsData);
			int size = rows.size();
			extentTest.log(LogStatus.INFO, "getDropDownRowCount: ", "Number of rows is- <B>[" + size + "]</B>");
			return size;
		} catch (NoSuchElementException nsex) {
			return -1;
		}
		//source tree
	}

public void goto_FilterOption_Anamoly() {
	synchronized (AnamolyDetection_Logic.class) {
		try {
			By filter = By.xpath("//*[@title='"+filterName+"']/../../../..//div[@role='combobox']");
			waitForElementTobeClickable(filter);
			clickOn(filter);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}


public void verifyUnderstand_Anamoly() {
	synchronized (AnamolyDetection_Logic.class) {
		try {
			waitForPageToLoad();
//			actionRightClick(AnamolyDetection_UI.ADUnderstandButton);
			waitForPageToLoad();
			waitForElementTobeClickable(AnamolyDetection_UI.drillThrough);
			waitForPageToLoad();
			waitForVisibleElement(AnamolyDetection_UI.drillThrough);
			actionClick(AnamolyDetection_UI.drillThrough);
			waitForPageToLoad();
//			clickOn(AnamolyDetection_UI.ADDrillThroughUnderstand);
			doubleClick(AnamolyDetection_UI.drillThroughUnderstand);
			waitForVisibleElement(AnamolyDetection_UI.understandTable);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}


public void validate_DropDownHasMultiSelect_Anamoly() {
	synchronized (AnamolyDetection_Logic.class) {
		try {
			if (isMultiSelectActive_Anamoly())
				extentTest.log(LogStatus.PASS, "Drop down should have Multi Select",
						"Multi Select option is working");
			else
				extentTest.log(LogStatus.FAIL, "Drop down should have Multi Select",
						"Multi Select option is not working");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
private boolean isMultiSelectActive_Anamoly() {

	try {
		boolean flag = false;
		String state = driver.findElement(AnamolyDetection_UI.selectAll_option).getAttribute("aria-checked");
		if (state.trim().equals("true")) {
			int rows = getFilterDropDownRowCount_Anamoly();
			for (int i = 1; i <= rows; i++) {
				String rowState = driver.findElement(By.xpath(
						"(//input[@aria-label='Search']//ancestor::div[@class='slicer-dropdown-content']//div[@class='slicerBody']//div[@class='row'])[4]//span[@class='slicerText']//ancestor::div[@class='slicerItemContainer']"))
						.getAttribute("aria-checked");
				if (rowState.trim().equals("true")) {
					flag = true;
				}
			}
			return true;
		} else if (state.trim().equals("false")) {
			driver.findElement(AnamolyDetection_UI.selectAll_option).click();
			String state2 = driver.findElement(AnamolyDetection_UI.selectAll_option).getAttribute("aria-checked");
			if (state2.trim().equals("true")) {
				int rows = getFilterDropDownRowCount_Anamoly();
				for (int i = 1; i <= rows; i++) {
					String rowState = driver.findElement(By.xpath(
							"(//input[@aria-label='Search']//ancestor::div[@class='slicer-dropdown-content']//div[@class='slicerBody']//div[@class='row'])["+i+"]//span[@class='slicerText']//ancestor::div[@class='slicerItemContainer']"))
							.getAttribute("aria-checked");
					if (rowState.trim().equals("true")) {
						flag = true;
					}
				}
				return true;
			}
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return false;
	}
	extentTest.log(LogStatus.FAIL, "isMultiSelectActive: ", "Multi Select option is not working ");
	return false;

}



	private void clickonFilterandValidatethedata_Anamoly() {
		// TODO Auto-generated method stub
		waitForPageToLoad();
	    List<WebElement> checkboxes = driver.findElements(By.xpath("//*[@class='slicerCheckbox']"));
	    if (checkboxes.size()>0) {
//	        driver.findElement(By.xpath("//*[@aria-label='"+Filtername+"']//ancestor::div[contains(@class,'slicer-container')]//div[@class='slicer-dropdown-menu']")).click();
	    	return ;
	    }
	}
	
	
	private void getTableContent_Anamoly() {
		boolean flag;
		int columnCnt = getElementsCount(AnamolyDetection_UI.table_UnderStand_ColumnCount);
		int rowCnt = getElementsCount(AnamolyDetection_UI.table_UnderStand_RowCount);
		for(int col=3; col<=columnCnt; col++) {
			for(int row =1; row<=rowCnt ;row++) {
				By cellValue = By.xpath("(//div[@role='row'])["+rowCnt+"]//div[@aria-colindex='"+columnCnt+"']");
				if(!getTextOf(cellValue).equals(""))					
				if(getTextOf(cellValue).contains("%"))
					rightClick(cellValue);
			}			
		}
	}

}
