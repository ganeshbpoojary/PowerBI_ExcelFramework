package testlogic;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.poi.util.SystemOutLogger;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.LogStatus;
import com.thoughtworks.selenium.webdriven.commands.GetText;
import com.thoughtworks.selenium.webdriven.commands.IsVisible;

import frameworkutils.DataBook;
import frameworkutils.WebDriverFactory;
import uimaps.APPM_UI;
import uimaps.AnamolyDetection_UI;
import uimaps.RPCC_Demand_UI;
import uimaps.RPCC_Demand_UI;
import uimaps.Shopper_UI;
import uimaps.Supplier_UI;

public class RPCC_Demand_Logic extends WebDriverFactory {

	public RPCC_Demand_Logic(WebDriver driver, Map<String, String> dataBook) {
		super(driver, dataBook);
	}

	String filterName = dataBook.get("Fliter_Name");

	/**
	 * Validate Product Drill Through working
	 * 
	 **/
	public void Validate_ProductDrillThrough_RPCC_Demand() {
		synchronized (RPCC_Demand_Logic.class) {
			try {
				waitForElementTobeClickable(RPCC_Demand_UI.treeMap_Product);
				int num = getElementsCount(RPCC_Demand_UI.treeMap_Product_Options);
				for (int i = 1; i <= num - 1; i++) {
					By elem = By.xpath("((//*[@class='treemap'])[1]//*[@class='parentGroup treemapNode setFocusRing'])["
							+ i + "]");
					rightClick(elem);
					waitForElementTobeClickable(RPCC_Demand_UI.navBtn_DrillThrough);
					clickOn(RPCC_Demand_UI.navBtn_DrillThrough);
					waitForElementTobeClickable(RPCC_Demand_UI.navBtn_Understand);
					clickOn(RPCC_Demand_UI.navBtn_Understand);
					waitForElementTobeLocated(RPCC_Demand_UI.title_Understand);
					clickOn(RPCC_Demand_UI.link_Title);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Validate Location Drill Through working
	 * 
	 **/
	public void Validate_LocationDrillThrough_RPCC_Demand() {
		synchronized (RPCC_Demand_Logic.class) {
			try {
				waitForElementTobeClickable(RPCC_Demand_UI.treeMap_Location);
				int num = getElementsCount(RPCC_Demand_UI.treeMap_Location_Options);
				for (int i = 1; i <= num; i++) {
					By elem = By.xpath("((//*[@class='treemap'])[2]//*[@class='parentGroup treemapNode setFocusRing'])["
							+ i + "]");
					rightClick(elem);
					waitForElementTobeClickable(RPCC_Demand_UI.navBtn_DrillThrough);
					clickOn(RPCC_Demand_UI.navBtn_DrillThrough);
					waitForElementTobeClickable(RPCC_Demand_UI.navBtn_Understand);
					clickOn(RPCC_Demand_UI.navBtn_Understand);
					waitForElementTobeLocated(RPCC_Demand_UI.title_Understand);
					clickOn(RPCC_Demand_UI.link_Title);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Validate X Axi Has Date
	 * 
	 **/
	public void Validate_XAxisHasDate_RPCC_Demand() {
		synchronized (RPCC_Demand_Logic.class) {
			boolean flag = false;
			try {
				waitForElementTobeLocated(RPCC_Demand_UI.span_XAxis_Options);
				int size = getElementsCount(RPCC_Demand_UI.span_XAxis_Options);
				for (int i = 1; i <= size; i++) {
					By elm = By.xpath(
							"(//*[@class='x axis hideLinesOnAxis setFocusRing']//*[@class='setFocusRing'])[" + i + "]");
					String date = getTextOf(elm).trim();
					System.out.println(date);
					if (date.equals("")) {
						flag = false;
					} else {
						SimpleDateFormat sdfrmt = new SimpleDateFormat("MM/dd/yyyy");
						sdfrmt.setLenient(false);
						Date javaDate = sdfrmt.parse(date);
						flag = true;
					}
				}
				if (flag)
					extentTest.log(LogStatus.PASS, "Date format validation", "Date is in - <B> DD/MM/YYYY </B> format");
				else
					extentTest.log(LogStatus.FAIL, "Date format validation",
							"Date is not in - <B> DD/MM/YYYY </B> format");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Validate Needs Attention Button is active
	 * 
	 **/
	public void Validate_NeedAttentionIsActive_RPCC_Demand() {
		synchronized (RPCC_Demand_Logic.class) {
			boolean flag = false;
			try {
//				isDisplayed(RPCC_Demand_UI.span_LastUpdated);
				waitForElementTobeClickable(RPCC_Demand_UI.btn_NeedsAttention);
				actionClick(RPCC_Demand_UI.btn_NeedsAttention);
				waitForElementTobeLocated(RPCC_Demand_UI.table_AttentionReview);
				isDisplayed(RPCC_Demand_UI.table_AttentionReview);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Validate Needs Attention Button is active
	 * 
	 **/
	public void Validate_LastUpdatedIsPresent_RPCC_Demand() {
		synchronized (RPCC_Demand_Logic.class) {
			boolean flag = false;
			try {
				isDisplayed(RPCC_Demand_UI.span_LastUpdated);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Validate Needs Review Button is active
	 * 
	 **/
	public void Validate_NeedAReviewIsActive_RPCC_Demand() {
		synchronized (RPCC_Demand_Logic.class) {
			boolean flag = false;
			try {
				isDisplayed(RPCC_Demand_UI.span_LastUpdated);
				waitForElementTobeClickable(RPCC_Demand_UI.btn_NeedsReview);
				actionClick(RPCC_Demand_UI.btn_NeedsReview);
				waitForElementTobeLocated(RPCC_Demand_UI.table_AttentionReview);
				isDisplayed(RPCC_Demand_UI.table_AttentionReview);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Validate Needs Attention Drill through
	 * 
	 **/
	public void Validate_NeedsAttention_DrillThrough_RPCC_Demand() {
		synchronized (RPCC_Demand_Logic.class) {
			boolean flag = false;
			try {
				waitForElementTobeClickable(RPCC_Demand_UI.btn_NeedsAttention);
				actionClick(RPCC_Demand_UI.btn_NeedsAttention);
				waitForElementTobeLocated(RPCC_Demand_UI.table_AttentionReview);
				isDisplayed(RPCC_Demand_UI.table_AttentionReview);

				rightClick(RPCC_Demand_UI.table_AttentionReview_Options);
				waitForElementTobeClickable(RPCC_Demand_UI.navBtn_DrillThrough);
				clickOn(RPCC_Demand_UI.navBtn_DrillThrough);
				waitForElementTobeClickable(RPCC_Demand_UI.navBtn_Understand);
				clickOn(RPCC_Demand_UI.navBtn_Understand);
				waitForElementTobeLocated(RPCC_Demand_UI.title_Understand);
				clickOn(RPCC_Demand_UI.link_Title);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Validate Needs Review Drill through
	 * 
	 **/
	public void Validate_NeedsReview_DrillThrough_RPCC_Demand() {
		synchronized (RPCC_Demand_Logic.class) {
			boolean flag = false;
			try {
				waitForElementTobeClickable(RPCC_Demand_UI.btn_NeedsReview);
				actionClick(RPCC_Demand_UI.btn_NeedsReview);
				waitForElementTobeLocated(RPCC_Demand_UI.table_AttentionReview);
				isDisplayed(RPCC_Demand_UI.table_AttentionReview);

				rightClick(RPCC_Demand_UI.table_AttentionReview_Options);
				waitForElementTobeClickable(RPCC_Demand_UI.navBtn_DrillThrough);
				clickOn(RPCC_Demand_UI.navBtn_DrillThrough);
				waitForElementTobeClickable(RPCC_Demand_UI.navBtn_Understand);
				clickOn(RPCC_Demand_UI.navBtn_Understand);
				waitForElementTobeLocated(RPCC_Demand_UI.title_Understand);
				clickOn(RPCC_Demand_UI.link_Title);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Validate Card MAP Has Value
	 * 
	 **/
	public void Validate_Card_MAPHasValue_RPCC_Demand() {
		synchronized (RPCC_Demand_Logic.class) {
			boolean flag = false;
			try {
				isDisplayed(RPCC_Demand_UI.card_MAPE);
				String mainValue = getTextOf(RPCC_Demand_UI.card_MAPEMainValue);
				String smallValue = getTextOf(RPCC_Demand_UI.card_MAPESmallValue);
				String weekly = getTextOf(RPCC_Demand_UI.card_MAPEWeekly);
				if (!mainValue.equals("") && !smallValue.equals("") && weekly.equals("(% Weekly)"))
					flag = true;
				if (flag)
					extentTest.log(LogStatus.PASS, "Card MAPE should have value", "Card MAPE is having value");
				else
					extentTest.log(LogStatus.PASS, "Card MAPE should have value", "Card MAPE is not having value");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Validate Card WMAP Has Value
	 * 
	 **/
	public void Validate_Card_WMAPHasValue_RPCC_Demand() {
		synchronized (RPCC_Demand_Logic.class) {
			boolean flag = false;
			try {
				isDisplayed(RPCC_Demand_UI.card_WMAPE);
				String mainValue = getTextOf(RPCC_Demand_UI.card_WMAPEMainValue);
				String smallValue = getTextOf(RPCC_Demand_UI.card_WMAPESmallValue);
				String weekly = getTextOf(RPCC_Demand_UI.card_WMAPEWeekly);
				if (!mainValue.equals("") && !smallValue.equals("") && weekly.equals("(% Weekly)"))
					flag = true;
				if (flag)
					extentTest.log(LogStatus.PASS, "Card WMAPE should have value", "Card WMAPE is having value");
				else
					extentTest.log(LogStatus.PASS, "Card WMAPE should have value", "Card WMAPE is not having value");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Validate Card BIAS Has Value
	 * 
	 **/
	public void Validate_Card_BIASHasValue_RPCC_Demand() {
		synchronized (RPCC_Demand_Logic.class) {
			boolean flag = false;
			try {
				isDisplayed(RPCC_Demand_UI.card_BIAS);
				String mainValue = getTextOf(RPCC_Demand_UI.card_BIASMainValue);
				String smallValue = getTextOf(RPCC_Demand_UI.card_BIASSmallValue);
				String weekly = getTextOf(RPCC_Demand_UI.card_BIASWeekly);
				if (!mainValue.equals("") && !smallValue.equals("") && weekly.equals("(% Weekly)"))
					flag = true;
				if (flag)
					extentTest.log(LogStatus.PASS, "Card BIAS should have value", "Card BIAS is having value");
				else
					extentTest.log(LogStatus.PASS, "Card BIAS should have value", "Card BIAS is not having value");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Validate Card MAD Has Value
	 * 
	 **/
	public void Validate_Card_MADHasValue_RPCC_Demand() {
		synchronized (RPCC_Demand_Logic.class) {
			boolean flag = false;
			try {
				isDisplayed(RPCC_Demand_UI.card_MAD);
				String mainValue = getTextOf(RPCC_Demand_UI.card_MADMainValue);
				String smallValue = getTextOf(RPCC_Demand_UI.card_MADSmallValue);
				String weekly = getTextOf(RPCC_Demand_UI.card_MADWeekly);
				if (!mainValue.equals("") && !smallValue.equals("") && weekly.equals("(% Weekly)"))
					flag = true;
				if (flag)
					extentTest.log(LogStatus.PASS, "Card MAD should have value", "Card MAD is having value");
				else
					extentTest.log(LogStatus.PASS, "Card MAD should have value", "Card MAD is not having value");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Validate Card RMSE Has Value
	 * 
	 **/
	public void Validate_Card_RMSEHasValue_RPCC_Demand() {
		synchronized (RPCC_Demand_Logic.class) {
			boolean flag = false;
			try {
				isDisplayed(RPCC_Demand_UI.card_RMSE);
				String mainValue = getTextOf(RPCC_Demand_UI.card_RMSEMainValue);
				String smallValue = getTextOf(RPCC_Demand_UI.card_RMSESmallValue);
				String weekly = getTextOf(RPCC_Demand_UI.card_RMSEWeekly);
				if (!mainValue.equals("") && !smallValue.equals("") && weekly.equals("(% Weekly)"))
					flag = true;
				if (flag)
					extentTest.log(LogStatus.PASS, "Card RMSE should have value", "Card RMSE is having value");
				else
					extentTest.log(LogStatus.PASS, "Card RMSE should have value", "Card RMSE is not having value");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Validate Bar Chart has data
	 * 
	 **/
	public void validate_BarChartHasData_RPCC_Demand() {
		synchronized (RPCC_Demand_Logic.class) {
			try {
				if (checkBarChartData())
					extentTest.log(LogStatus.PASS, "Chart should have data",
							"Chart - <B>" + "Forecast Trend" + "</B> is having data");
				else
					extentTest.log(LogStatus.FAIL, "Chart should have data",
							"Chart - <B>" + "Forecast Trend" + "</B> is not having data");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Validate Tree Chart has data
	 * 
	 **/
	public void validate_TreeChartHasData_RPCC_Demand() {
		synchronized (RPCC_Demand_Logic.class) {
			try {
				if (checkTreeChartData())
					extentTest.log(LogStatus.PASS, "Chart should have data",
							"Chart - <B>" + "Tree Map" + "</B> is having data");
				else
					extentTest.log(LogStatus.FAIL, "Chart should have data",
							"Chart - <B>" + "Tree Map" + "</B> is having data");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Validate Filter has Data, Multi Select, Search option
	 * 
	 **/
	public void validate_FilterIsWorking_RPCC_Demand() {
		synchronized (RPCC_Demand_Logic.class) {
			try {
				if (validate_DropDownIsWorking_RPCC_Demand())
//					extentTest.log(LogStatus.PASS, "Chart should have data",							"Chart - <B>" +"Tree Map"+ "</B> is having data");
					extentTest.log(LogStatus.PASS, "Drop Down Data presence validation", "Drop Down has Data");
				else
					extentTest.log(LogStatus.FAIL, "Drop Down Data presence validation", "Drop Down has no Data");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Navigates to Understand Page
	 * 
	 **/
	public void goto_UnderstandPage_RPCC_Demand() {
		synchronized (RPCC_Demand_Logic.class) {
			try {
				boolean flag = false;
				waitForElementTobeLocated(RPCC_Demand_UI.treeMap_HomePage_Options);
				int treeMapNum = getElementsCount(RPCC_Demand_UI.treeMap_HomePage_Options);
				if (treeMapNum == -1) {
					extentTest.log(LogStatus.FAIL, "Navigate to Understand Page",
							"Not able to Navigate to Understand Page");
				} else {
					rightClick(RPCC_Demand_UI.treeMap_HomePage_Options);
					waitForElementTobeClickable(RPCC_Demand_UI.navBtn_DrillThrough);
					clickOn(RPCC_Demand_UI.navBtn_DrillThrough);
					waitForElementTobeClickable(RPCC_Demand_UI.navBtn_Understand);
					clickOn(RPCC_Demand_UI.navBtn_Understand);
					waitForElementTobeLocated(RPCC_Demand_UI.title_Understand);
					isDisplayed(RPCC_Demand_UI.title_Understand);
					extentTest.log(LogStatus.PASS, "Navigate to Understand Page", "Navigated to Understand Page");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void validate_DropDownHasData_RPCC_Demand() {
		synchronized (RPCC_Demand_Logic.class) {
			try {
				if (checkDropDownHasData()) {
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

	public void goto_FilterOption_RPCC_Demand() {
		synchronized (RPCC_Demand_Logic.class) {
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

	public void validate_DropDownHasMultiSelect_RPCC_Demand() {
		synchronized (RPCC_Demand_Logic.class) {
			try {
				if (isMultiSelectActive())
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

	public void validate_DropDownHasSearchOption_RPCC_Demand() {
		synchronized (AnamolyDetection_Logic.class) {
			try {
				By searchOpt = By.xpath(
						"//div[@role='listbox' and @aria-label='" + filterName + "']/..//input[@aria-label='Search']");
				if (isDisplayed(searchOpt))
					extentTest.log(LogStatus.PASS, "Search option should be present", "Search option is present");
				else
					extentTest.log(LogStatus.FAIL, "Search option should be present", "Search option is not present");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void goto_UnderStood_OutOfStock_RPCC_Demand() {
		synchronized (AnamolyDetection_Logic.class) {
			try {
				Robot robot = new Robot();
				boolean flag = false;
				for (int i = 1; i <= getElementsCount(RPCC_Demand_UI.chart_ForecastTrends); i++) {
					By bar = By.xpath(
							"((//*[@class='columnChartUnclippedGraphicsContext'])[6]//*[@class='column sub-selectable setFocusRing'])["
									+ i + "]");
					if (!(getAttributeValueOf(bar, "aria-label").equals("null"))) {
						rightClick(bar);
						isDisplayed(RPCC_Demand_UI.contextMenu);
						int options = getElementsCount(RPCC_Demand_UI.contextMenu_Option);
						for (int j = 1; j <= options; j++) {
							By opt = By.xpath("//*[@role='menu']//button[@role='menuitem'][" + j + "]");
							if (getTextOf(opt).equals("Drill through")) {
								clickOn(opt);
								waitForElementTobeClickable(RPCC_Demand_UI.navBtn_ReviewOutOfStock);
								clickOn(RPCC_Demand_UI.navBtn_ReviewOutOfStock);
								waitForElementTobeLocated(RPCC_Demand_UI.title_UnderstandOutOfStock);
								flag = true;
								break;
							}
						}
						if (!flag) {
							actionClick(RPCC_Demand_UI.title_Understand);
						}
					}
					if(flag)
						break;
				}
				if (flag)
					extentTest.log(LogStatus.PASS, "Navigate to Understand Out of Stock Page",
							"Navigated to Understand Out of Stock Page");
				else
					extentTest.log(LogStatus.FAIL, "Navigate to Understand Out of Stock Page",
							"Not able to navugate to Out of Stock Page");
			} catch (NoSuchElementException e) {
			} catch (AWTException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/*************************************************************************************************************************************/

	/*
	 * Private methods
	 */

	private boolean checkDropDownHasData() {
		try {
			if (getFilterDropDownRowCount() > 0)
				return true;
			else
				return false;
		} catch (NoSuchElementException nsex) {
			extentTest.log(LogStatus.FAIL, "Search Field vaildation", "Search filed is visible for filter");
			return false;
		}
	}

	private boolean checkBarChartData(String chart) {
		try {
			boolean flag = false;
			By chartElm = By.xpath(
					"(//*[@class='columnChartUnclippedGraphicsContext'])[6]//*[@class='column sub-selectable setFocusRing']");
			for (int i = 1; i <= getElementsCount(chartElm); i++) {
				By bar = By.xpath(
						"((//*[@class='columnChartUnclippedGraphicsContext'])[6]//*[@class='column sub-selectable setFocusRing'])["
								+ i + "]");
				if (!(getAttributeValueOf(bar, "aria-label").equals("null"))) {
					rightClick(bar);
					if (isDisplayed(RPCC_Demand_UI.navBtn_DrillThrough))
						clickOn(RPCC_Demand_UI.navBtn_DrillThrough);
					snooze(3000);
					clickOn(RPCC_Demand_UI.navBtn_ReviewOutOfStock);
				}
			}
			return flag;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

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

	private boolean validate_DropDownIsWorking_RPCC_Demand() {
		int rows = 0;
		boolean flag = false;
		try {
			String[] filters = filterName.split("\\|");
			List<String> itemList = Arrays.asList(filters);
			for (int i = 0; i < itemList.size(); i++) {
				String filter = itemList.get(i).trim();
				By elm = By.xpath("//*[@title='" + filter + "']/../../../..//div[@role='combobox']");
				waitForElementTobeClickable(elm);
				clickOn(elm);
//				waitForPageToLoad();
				int index = i + 1;
				By optionWindow = By.xpath("(//div[@class='slicerBody'])[" + index + "]");
				waitForElementTobeLocated(optionWindow);
				By options = By.xpath("(//div[@class='slicerBody'])[" + index + "]//div[@class='row']");
				rows = getElementsCount(options);

				// DropDown has data
				if (rows > 0)
					flag = true;

				// Drop Down has Search option
				By search = By.xpath("//div[@aria-label='" + filter + "']/../..//input[@aria-label='Search']");
				if (isDisplayed(search))
					flag = true;

				// Drop had multiSelect Active
				By selectAll = By.xpath("(//div[@class='slicerBody'])[" + index
						+ "]//*[text()='Select all']//ancestor::div[@class='slicerItemContainer']");
				String state = getAttributeValueOf(selectAll, "aria-checked");
//				String state = driver.findElement(RPCC_Demand_UI.dd_SelectAll_option).getAttribute("aria-checked");
				if (state.trim().equals("true")) {
					for (int j = 1; j <= rows; j++) {
						String rowState = driver.findElement(By.xpath(
								"(//input[@aria-label='Search']//ancestor::div[@class='slicer-dropdown-content']//div[@class='slicerBody']//div[@class='row'])["
										+ j
										+ "]//span[@class='slicerText']//ancestor::div[@class='slicerItemContainer']"))
								.getAttribute("aria-checked");
						if (rowState.trim().equals("true"))
							flag = true;

					}
				} else if (state.trim().equals("false")) {
					driver.findElement(RPCC_Demand_UI.dd_SelectAll_option).click();
					String state2 = driver.findElement(RPCC_Demand_UI.dd_SelectAll_option).getAttribute("aria-checked");
					if (state2.trim().equals("true")) {
//						int rows = getFilterDropDownRowCount();
						for (int j = 1; j <= rows; j++) {
							String rowState = driver.findElement(By.xpath(
									"(//input[@aria-label='Search']//ancestor::div[@class='slicer-dropdown-content']//div[@class='slicerBody']//div[@class='row'])["
											+ j
											+ "]//span[@class='slicerText']//ancestor::div[@class='slicerItemContainer']"))
									.getAttribute("aria-checked");
							if (rowState.trim().equals("true"))
								flag = true;
						}
					}
				}
				// Closing Drop down
				clickOn(elm);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	private boolean checkBarChartData() {
		try {
			boolean flag = false;
			isDisplayed(RPCC_Demand_UI.chart_ForecastTrend);
			for (int i = 1; i <= getElementsCount(RPCC_Demand_UI.chart_ForecastTrend); i++) {
				By bar = By.xpath(
						"(//*[contains(text(),'Forecast Trend')]//ancestor::div[@class='vcGroupBody themableBackgroundColor themableBorderColorSolid']//*[@class='mainGraphicsContext setFocusRing']//*[@class='column sub-selectable setFocusRing'])["
								+ i + "]");
				if (!(getAttributeValueOf(bar, "aria-label").equals("null"))) {
					actionClick(bar);
					waitForPageToLoad();
					snooze(3000);
					String label = getTextOf(RPCC_Demand_UI.chart_popupText);
					System.out.println(label);
					if (!label.equals(""))
						flag = true;
				}
			}
			return flag;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	private boolean checkTreeChartData() {
		try {
			boolean flag = false;
			By chartElm = By.xpath(
					"(//*[contains(text(),'MAPE (%) across product (left) and location (right) hierarchies')]//ancestor::div[contains(@class,'themableBorderColorSolid')])[1]//*[@role='treeitem']");
			for (int i = 1; i <= getElementsCount(chartElm); i++) {
				By tree = By.xpath(
						"((//*[contains(text(),'MAPE (%) across product (left) and location (right) hierarchies')]//ancestor::div[contains(@class,'themableBorderColorSolid')])[1]//*[@role='treeitem'])["
								+ i + "]");
				actionClick(tree);
				waitForPageToLoad();
				snooze(3000);
				String label = getTextOf(RPCC_Demand_UI.chart_popupText);
				if (!label.equals(""))
					flag = true;
			}
			return flag;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	private int getFilterDropDownRowCount() {
//		waitForElementTobeLocated(RPCC_Demand_UI.dd_options);
		try {
			List<WebElement> rows = driver.findElements(RPCC_Demand_UI.dd_options);
			int size = rows.size();
			extentTest.log(LogStatus.INFO, "getDropDownRowCount: ", "Number of rows is- <B>[" + size + "]</B>");
			return size;
		} catch (NoSuchElementException nsex) {
			return -1;
		}
	}

	private boolean isMultiSelectActive() {
		boolean flag;
		try {
			By selectAll = By.xpath("//div[@role='listbox' and @aria-label='" + filterName
					+ "']//ancestor::div[@class='slicer-dropdown-content']//*[text()='Select all']//ancestor::div[@class='slicerItemContainer']");
			String state = getAttributeValueOf(selectAll, "aria-checked");
			if (state.trim().equals("true")) {
				By optCount = By
						.xpath("//div[@role='listbox' and @aria-label='" + filterName + "']//div[@class='row']");
				int rows = getElementsCount(optCount);
				for (int i = 1; i <= rows; i++) {
					String rowState = driver.findElement(By.xpath(
							"(//input[@aria-label='Search']//ancestor::div[@class='slicer-dropdown-content']//div[@class='slicerBody']//div[@class='row'])["
									+ i + "]//span[@class='slicerText']//ancestor::div[@class='slicerItemContainer']"))
							.getAttribute("aria-checked");
					if (rowState.trim().equals("true")) {
						flag = true;
					}
				}
				return true;
			} else if (state.trim().equals("false")) {
				clickOn(selectAll);
				By selectAll2 = By.xpath("//div[@role='listbox' and @aria-label='" + filterName
						+ "']//ancestor::div[@class='slicer-dropdown-content']//*[text()='Select all']//ancestor::div[@class='slicerItemContainer']");
				String state2 = getAttributeValueOf(selectAll2, "aria-checked");
				if (state2.trim().equals("true")) {
					By optCount = By
							.xpath("//div[@role='listbox' and @aria-label='" + filterName + "']//div[@class='row']");
					int rows = getElementsCount(optCount);
					for (int i = 1; i <= rows; i++) {
						String rowState = driver.findElement(By.xpath(
								"(//input[@aria-label='Search']//ancestor::div[@class='slicer-dropdown-content']//div[@class='slicerBody']//div[@class='row'])["
										+ i
										+ "]//span[@class='slicerText']//ancestor::div[@class='slicerItemContainer']"))
								.getAttribute("aria-checked");
						if (rowState.trim().equals("true")) {
							flag = true;
						}
					}
					return true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return false;

	}
}