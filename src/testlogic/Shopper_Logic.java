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
import uimaps.APPM_UI;
import uimaps.Shopper_UI;
import uimaps.Supplier_UI;

public class Shopper_Logic extends WebDriverFactory {

	public Shopper_Logic(WebDriver driver, Map<String, String> dataBook) {
		super(driver, dataBook);
	}

	String filterName = dataBook.get("Filter_Name");

	public void goto_MarketBasketAnalysis_Shooper() {
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

	public void goto_MissionTripAnalysis_Shooper() {
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

	public void goto_FilterOption_Shooper() {
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

	public void validateDropDownHasData_Shooper() {
		synchronized (Supplier_Logic.class) {
			try {
				if (checkDropDownHasData_Shooper()) {
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

	public void validateDropDownHasSearchOption_Shooper() {
		synchronized (Supplier_Logic.class) {
			try {
				if (checkDropDownHasSearchOption_Shooper())
					extentTest.log(LogStatus.PASS, "Search Field vaildation", "Search filed is visible for filter");
				else
					extentTest.log(LogStatus.FAIL, "Search Field vaildation", "Search filed is not visible for filter");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void validateChartTopDistributionHasData_Shooper() {
		synchronized (Supplier_Logic.class) {
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

	private boolean checkDropDownHasData_Shooper() {
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

	private boolean checkDropDownHasSearchOption_Shooper() {
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
		waitForElementTobeLocated(Shopper_UI.dd_options_supplier);
		try {
			List<WebElement> rows = driver.findElements(Shopper_UI.dd_options_supplier);
			int size = rows.size();
			extentTest.log(LogStatus.INFO, "getDropDownRowCount: ", "Number of rows is- <B>[" + size + "]</B>");
			return size;
		} catch (NoSuchElementException nsex) {
			return -1;
		}
	}

}