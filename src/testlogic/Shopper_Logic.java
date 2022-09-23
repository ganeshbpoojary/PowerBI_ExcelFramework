package testlogic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.LogStatus;
import com.thoughtworks.selenium.webdriven.commands.IsVisible;

import frameworkutils.DataBook;
import frameworkutils.WebDriverFactory;
import uimaps.Shopper_UI;


public class Shopper_Logic extends WebDriverFactory {

	public Shopper_Logic(WebDriver driver, Map<String, String> dataBook) {
		super(driver, dataBook);
	}

	String filterName = dataBook.get("Filter_Name");

	public void goto_Tab_MarketBasketAnalysis_Shopper() {
		synchronized (Shopper_Logic.class) {
			try {
				waitForElementTobeClickable(Shopper_UI.tab_MarketBasketAnalysis);
				clickOn(Shopper_UI.tab_MarketBasketAnalysis);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void goto_Tab_MissionTripAnalysis_Shopper() {
		synchronized (Shopper_Logic.class) {
			try {
				waitForElementTobeClickable(Shopper_UI.tab_MissionTripAnalysis);
				clickOn(Shopper_UI.tab_MissionTripAnalysis);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	public void goto_Btn_HowHaveMyBasketMetricsPerformed_Shopper() {
		synchronized (Shopper_Logic.class) {
			try {
				doubleClick(Shopper_UI.btn_HowHaveMyBasketMetricsPerformed);
				waitForPageToLoad();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void goto_FilterOption_Shopper() {
		synchronized (Shopper_Logic.class) {
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

	public void validateDropDownHasData_Shopper() {
		synchronized (Shopper_Logic.class) {
			try {
				if (checkDropDownHasData_Shopper()) {
					extentTest.log(LogStatus.PASS, "Drop Down Data presence validation", "Drop Down has Data");
				} else {
					extentTest.log(LogStatus.FAIL, "Drop Down Data presence validation", "Drop Down has no Data");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}	
	
	
	public void validateDropDownHasMultiSelect_Shopper() {
		synchronized (Shopper_Logic.class) {
			try {
				if (isMultiSelectActive_Shopper())
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
	
	
	

	public void validateDropDownHasSearchOption_Shopper() {
		synchronized (Shopper_Logic.class) {
			try {
				if (checkDropDownHasSearchOption_Shopper())
					extentTest.log(LogStatus.PASS, "Search Field vaildation", "Search filed is visible for filter");
				else
					extentTest.log(LogStatus.FAIL, "Search Field vaildation", "Search filed is not visible for filter");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void validateChartTopDistributionHasData_Shopper() {
		synchronized (Shopper_Logic.class) {
			try {
				boolean flag = false;
				waitForElementTobeLocated(Shopper_UI.chart_TopDistrictContribution_Option);
				int districtNum = getElementsCount(Shopper_UI.chart_TopDistrictContribution_Option);
				for (int i = 1; i <= districtNum; i++) {
					waitForPageToLoad();
					snooze(3000);
					WebElement elm = driver.findElement(
							By.xpath("(//*[@class='scatterMarkerSeriesGroup']//*[@class='scatterMarker setFocusRing'])["
									+ i + "]"));
					Actions action = new Actions(driver);
					action.moveToElement(elm).click().perform();
					String label = getTextOf(Shopper_UI.chart_TopDistrictContribution_PopMessage);
					if (!label.equals("") && label.contains("District")) {
						extentTest.log(LogStatus.INFO, "Validation - Chart Values have lables", "<B> " + label + " </B> label is present in Chart");	
						flag = true;
					}
				}
				if (flag)
					extentTest.log(LogStatus.PASS, "Validation - Chart Values have lables",
							"Chart Values is having lables");
				else
					extentTest.log(LogStatus.FAIL, "Validation - Chart values have lables",
							"Chart Values is not having lables");

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private boolean checkDropDownHasData_Shopper() {
		try {
			if (getFilterDropDownRowCount_Shooper() > 0)
				return true;
			else
				return false;
		} catch (NoSuchElementException nsex) {
			extentTest.log(LogStatus.FAIL, "Search Field vaildation", "Search filed is visible for filter");
			return false;
		}
	}

	private boolean checkDropDownHasSearchOption_Shopper() {
		try {
			By search = By.xpath("//div[@aria-label='" + filterName + "']/../..//input[@aria-label='Search']");
			if (isDisplayed(search))
				return true;
			else
				return false;
		} catch (NoSuchElementException nsex) {
			extentTest.log(LogStatus.FAIL, "Search Field vaildation", "Search filed is not visible for filter");
			return false;
		}
	}

	/*
	 * Private methods section
	 */

	private int getFilterDropDownRowCount_Shooper() {
		waitForElementTobeLocated(Shopper_UI.dd_options);
		try {
			List<WebElement> rows = driver.findElements(Shopper_UI.dd_options);
			int size = rows.size();
			extentTest.log(LogStatus.INFO, "getDropDownRowCount: ", "Number of rows is- <B>[" + size + "]</B>");
			return size;
		} catch (NoSuchElementException nsex) {
			return -1;
		}
	}
	
	private boolean isMultiSelectActive_Shopper() {

		try {
			boolean flag = false;
			String state = driver.findElement(Shopper_UI.dd_SelectAll_option).getAttribute("aria-checked");
			if (state.trim().equals("true")) {
				int rows = getFilterDropDownRowCount_Shopper();
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
				driver.findElement(Shopper_UI.dd_SelectAll_option).click();
				String state2 = driver.findElement(Shopper_UI.dd_SelectAll_option).getAttribute("aria-checked");
				if (state2.trim().equals("true")) {
					int rows = getFilterDropDownRowCount_Shopper();
					for (int i = 1; i <= rows; i++) {
						String rowState = driver.findElement(By.xpath(
								"(//input[@aria-label='Search']//ancestor::div[@class='slicer-dropdown-content']//div[@class='slicerBody']//div[@class='row'])[4]//span[@class='slicerText']//ancestor::div[@class='slicerItemContainer']"))
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
	
	private int getFilterDropDownRowCount_Shopper() {
		waitForElementTobeLocated(Shopper_UI.dd_options);
		try {
			List<WebElement> rows = driver.findElements(Shopper_UI.dd_options);
			int size = rows.size();
			extentTest.log(LogStatus.INFO, "getDropDownRowCount: ", "Number of rows is- <B>[" + size + "]</B>");
			return size;
		} catch (NoSuchElementException nsex) {
			return -1;
		}
	}

}