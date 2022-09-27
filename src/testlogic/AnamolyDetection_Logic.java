package testlogic;

import java.util.ArrayList;
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
import uimaps.AnamolyDetection_UI;

public class AnamolyDetection_Logic extends WebDriverFactory {

	public AnamolyDetection_Logic(WebDriver driver, Map<String, String> dataBook) {
		super(driver, dataBook);
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
				extentTest.log(LogStatus.PASS, "Navigates to Understand Page", "Navigated to Understand Page");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Navigates to Investigate page
	 * 
	 **/
	public void goto_InvestigatePage_Anamoly() {
		synchronized (AnamolyDetection_Logic.class) {
			try {
				if (clickOnPriority_Anamoly()) {
					waitForElementTobeClickable(AnamolyDetection_UI.navBtn_DrillThrough);
					clickOn(AnamolyDetection_UI.navBtn_DrillThrough);
					waitForElementTobeClickable(AnamolyDetection_UI.navBtn_Investigate);
					clickOn(AnamolyDetection_UI.navBtn_Investigate);
					waitForElementTobeLocated(AnamolyDetection_UI.title_Investigate);
					extentTest.log(LogStatus.PASS, "Navigates to Investigate Page", "Navigated to Investigate Page");
				} else {
					extentTest.log(LogStatus.FAIL, "Navigates to Investigate Page",
							"Not able to navigated to Investigate Page");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Navigates to Price Promotions PLC Inventory Page
	 * 
	 **/
	public void goto_PricePromotionsPLC_InventoryPage_Anamoly() {
		synchronized (AnamolyDetection_Logic.class) {
			try {
				rightClick(AnamolyDetection_UI.btn_Understand);
				waitForElementTobeClickable(AnamolyDetection_UI.navBtn_DrillThrough);
				clickOn(AnamolyDetection_UI.navBtn_DrillThrough);
				waitForElementTobeClickable(AnamolyDetection_UI.navBtn_Understand);
				clickOn(AnamolyDetection_UI.navBtn_Understand);
				waitForElementTobeLocated(AnamolyDetection_UI.title_Understand);				
				if (clickOnPriority_Anamoly()) {
					waitForElementTobeClickable(AnamolyDetection_UI.navBtn_DrillThrough);
					clickOn(AnamolyDetection_UI.navBtn_DrillThrough);
					waitForElementTobeClickable(AnamolyDetection_UI.navBtn_Investigate);
					clickOn(AnamolyDetection_UI.navBtn_Investigate);
					waitForElementTobeLocated(AnamolyDetection_UI.title_Investigate);
					waitForElementTobeLocated(AnamolyDetection_UI.btn_BusniessImpact);
					rightClick(AnamolyDetection_UI.btn_BusniessImpact);
					waitForElementTobeClickable(AnamolyDetection_UI.navBtn_DrillThrough);
					clickOn(AnamolyDetection_UI.navBtn_DrillThrough);
					waitForElementTobeClickable(AnamolyDetection_UI.navBtn_PricePromotionsPLC);
					clickOn(AnamolyDetection_UI.navBtn_PricePromotionsPLC);
					extentTest.log(LogStatus.PASS, "Navigates to Investigate Page", "Navigated to <B>"+"Price, Promotions, PLC & Inventory"+"</B> Page");
				} else {
					extentTest.log(LogStatus.FAIL, "Navigates to Investigate Page",
							"Not able to navigate to <B>"+"Price, Promotions, PLC & Inventory"+"</B> Page");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Validate Outlier Investigation Report
	 * 
	 **/
	public void Validate_OutlierInvestigationReport_Anamoly() {
		synchronized (AnamolyDetection_Logic.class) {
			try {
				waitForElementTobeLocated(AnamolyDetection_UI.span_OutlierInvestigationReportForItem);
				isDisplayed(AnamolyDetection_UI.span_OutlierInvestigationReportForItem);
				isDisplayed(AnamolyDetection_UI.span_AndStore);
				String item = getTextOf(AnamolyDetection_UI.span_FirstITEM);
				String location = getTextOf(AnamolyDetection_UI.span_FirstLOCATION);
				if (!(item.equals("") && location.equals("")))
					extentTest.log(LogStatus.PASS, "Report should appear", "Outlier Investigation Report For Item <B>"
							+ item + "</B> and Store <B>" + location + "</B> is appearing");
				else
					extentTest.log(LogStatus.FAIL, "Report should appear", "Report is not  appear");

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Validate Outlier Investigation Report Date format
	 * 
	 **/
	public void Validate_DateFormat_Anamoly() {
		synchronized (AnamolyDetection_Logic.class) {
			boolean flag = false;
			waitForElementTobeLocated(AnamolyDetection_UI.tableHeader_Investigate_option);
			try {
				int size = getElementsCount(AnamolyDetection_UI.tableHeader_Investigate_option);
				for (int i = 1; i <= size; i++) {
					By cellVal = By.xpath(
							"((//div[@class='columnHeaders'])[2]//div[contains(@class,'pivotTableCellNoWrap cell-interactive')])["
									+ i + "]");
					String date = getTextOf(cellVal);
					if (date.charAt(4) == '-' && date.charAt(7) == '-') {
						flag = true;
					}
				}
				if (flag)
					extentTest.log(LogStatus.PASS, "Date format validation", "Date is in - <B> YYYY-MM-DD </B> format");
				else
					extentTest.log(LogStatus.FAIL, "Date format validation",
							"Date is not in - <B> YYYY-MM-DD </B> format");

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Validate Outlier Investigation Report Date format
	 * 
	 **/
	public void Validate_OutlierTableHasData_Anamoly() {
		synchronized (AnamolyDetection_Logic.class) {
			try {
				int blankCell = 0;
				int dataCell = 0;
				waitForElementTobeLocated(AnamolyDetection_UI.table_OutlierInvestigation_option);
				int size = getElementsCount(AnamolyDetection_UI.table_OutlierInvestigation_option);
				for (int i = 1; i <= size; i++) {
					By cellVal = By.xpath(
							"((//div[@class='bodyCells'])[2]//div[contains(@class,'pivotTableCellWrap')])[" + i + "]");
					if (getTextOf(cellVal).equals(" "))
						blankCell = blankCell + 1;
					else
						dataCell = dataCell + 1;
				}
				if (!(blankCell == size))
					extentTest.log(LogStatus.PASS, "Outlier Investigation Table Has Data validation",
							"Outlier Table has Data");
				else
					extentTest.log(LogStatus.FAIL, "Outlier Investigation Table Has Data validation",
							"Outlier Table does not have Data");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Validate Business impact right click shows options
	 * 
	 **/
	public void Validate_BusinessImpactShowsOptions_Anamoly() {
		synchronized (AnamolyDetection_Logic.class) {
			boolean flag = false;
			try {
				waitForElementTobeLocated(AnamolyDetection_UI.btn_BusniessImpact);
				rightClick(AnamolyDetection_UI.btn_BusniessImpact);
				isDisplayed(AnamolyDetection_UI.contextMenu);
				int options = getElementsCount(AnamolyDetection_UI.contextMenu_Option);
				for (int i = 1; i < options; i++) {
					By opt = By.xpath("//*[@role='menu']//button[@role='menuitem'][" + i + "]");
					if (!getTextOf(opt).equals(""))
						flag = true;
				}
				if (flag)
					extentTest.log(LogStatus.PASS, "BusinessImpact Right click should show options",
							"BusinessImpact Right click is showing <B>[" + options + "]</B> options");
				else
					extentTest.log(LogStatus.FAIL, "BusinessImpact Right click should show options",
							"BusinessImpact Right click is not showing any options");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Validate Business impact Drill through shows options
	 * 
	 **/
	public void Validate_BusinessImpactDrillThroughShowsOtions_Anamoly() {
		synchronized (AnamolyDetection_Logic.class) {
			try {
				boolean flag = false;
				waitForElementTobeLocated(AnamolyDetection_UI.btn_BusniessImpact);
				rightClick(AnamolyDetection_UI.btn_BusniessImpact);
				isDisplayed(AnamolyDetection_UI.contextMenu);
//				int before = getElementsCount(AnamolyDetection_UI.contextMenu);
				clickOn(AnamolyDetection_UI.navBtn_DrillThrough);
				waitForPageToLoad();
				int after = getElementsCount(AnamolyDetection_UI.contextMenu);
				int subMenusize = getElementsCount(By.xpath("(//*[@role='menu'])[" + after + "]//button[@role='menuitem']"));
				for (int i = 1; i < subMenusize; i++) {
					By opt = By.xpath("((//*[@role='menu'])[" + after + "]//button[@role='menuitem'])[" + i + "]");
					if (!getTextOf(opt).equals(""))
						flag = true;
				}
				if (flag)
					extentTest.log(LogStatus.PASS, "BusinessImpact Right click> drill through should show options","Drill through is showing <B>[" + subMenusize + "]</B> options");
				else
					extentTest.log(LogStatus.FAIL, "BusinessImpact Right click> drill through should show options",
							"Drill through is not showing any options");
			} catch (Exception e) {
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
			} catch (Exception e) {
				// TODO Auto-generated catch block
				extentTest.log(LogStatus.FAIL, "Drop Down Data presence validation", "Drop Down has no Data");
				e.printStackTrace();
			}
		}
	}

	// Validate value in the dropdown
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

	

	// check dropdown option in the dropdown list
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
		// source tree
	}

	public void goto_FilterOption_Anamoly() {
		synchronized (AnamolyDetection_Logic.class) {
			try {
				By filter = By.xpath("//*[@title='" + filterName + "']/../../../..//div[@role='combobox']");
				waitForElementTobeClickable(filter);
				clickOn(filter);
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
	
	
	public boolean verify_UnderstandPage_Anamoly() {
		synchronized (AnamolyDetection_Logic.class) {
			try {
				waitForElementTobeLocated(AnamolyDetection_UI.ADunderstandTable);
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
	
	
	
	/*
	 * Private methods
	 */

	


	private void clickonFilterandValidatethedata_Anamoly() {
		// TODO Auto-generated method stub
		waitForPageToLoad();
		List<WebElement> checkboxes = driver.findElements(By.xpath("//*[@class='slicerCheckbox']"));
		if (checkboxes.size() > 0) {
//	        driver.findElement(By.xpath("//*[@aria-label='"+Filtername+"']//ancestor::div[contains(@class,'slicer-container')]//div[@class='slicer-dropdown-menu']")).click();
			return;
		}
	}

	private ArrayList<String> get_UnderstandTableContent_Anamoly() {
		boolean flag;
		try {
			ArrayList<String> tableContent = new ArrayList<String>();			
			int columnCnt = getElementsCount(AnamolyDetection_UI.table_UnderStand_ColumnCount);
			int rowCnt = getElementsCount(AnamolyDetection_UI.table_UnderStand_RowCount);
			for (int col = 3; col <= columnCnt; col++) {
				for (int row = 1; row <= rowCnt; row++) {
					By cellValue = By
							.xpath("(//div[@role='row'])[" + rowCnt + "]//div[@aria-colindex='" + columnCnt + "']");
					if (!getTextOf(cellValue).equals("")) {
						tableContent.add(getTextOf(cellValue));
						flag = true;
					} else {
						flag = false;
					}
				}
			}
			return tableContent;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	
	private boolean clickOnPriority_Anamoly() {
		boolean flag = false;
		try {
			int columnCnt = getElementsCount(AnamolyDetection_UI.table_UnderStand_ColumnCount);
			int rowCnt = getElementsCount(AnamolyDetection_UI.table_UnderStand_RowCount);
			for (int col = 3; col <= columnCnt; col++) {
				for (int row = 1; row <= rowCnt; row++) {
					By cellValue = By.xpath("(//div[@role='row'])[" + row + "]//div[@aria-colindex='" + col + "']");
					System.out.println(getTextOf(cellValue));
					if (getTextOf(cellValue).contains("%")) {
						rightClick(cellValue);
						flag = true;
						break;
					}
				}
//				flag = true;
//				break;
			}
			return flag;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
  
  private boolean isMultiSelectActive_Anamoly() {
		boolean flag;
		try {			
			String state = driver.findElement(AnamolyDetection_UI.AD_SelectAll_option).getAttribute("aria-checked");
			if (state.trim().equals("true")) {
				int rows = getFilterDropDownRowCount_Anamoly();
				for (int i = 1; i <= rows; i++) {
					String rowState = driver.findElement(By.xpath(
							"(//input[@aria-label='Search']//ancestor::div[@class='slicer-dropdown-content']//div[@class='slicerBody']//div[@class='row'])["+ i		+ "]//span[@class='slicerText']//ancestor::div[@class='slicerItemContainer']"))
							.getAttribute("aria-checked");
					if (rowState.trim().equals("true")) {
						flag = true;
					}
				}
				return true;
			} else if (state.trim().equals("false")) {
				driver.findElement(AnamolyDetection_UI.AD_SelectAll_option).click();
				String state2 = driver.findElement(AnamolyDetection_UI.AD_SelectAll_option)
						.getAttribute("aria-checked");
				if (state2.trim().equals("true")) {
					int rows = getFilterDropDownRowCount_Anamoly();
					for (int i = 1; i <= rows; i++) {
						String rowState = driver.findElement(By.xpath(
								"(//input[@aria-label='Search']//ancestor::div[@class='slicer-dropdown-content']//div[@class='slicerBody']//div[@class='row'])["+ i		+ "]//span[@class='slicerText']//ancestor::div[@class='slicerItemContainer']"))
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
}
