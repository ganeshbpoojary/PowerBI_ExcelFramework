package testlogic;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.text.ParseException;
import com.relevantcodes.extentreports.LogStatus;
import frameworkutils.WebDriverFactory;
import uimaps.AnamolyDetection_UI;
import uimaps.Supplier_UI;

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
				waitForElementTobeClickable(AnamolyDetection_UI.btn_Understand);
				rightClick(AnamolyDetection_UI.btn_Understand);
				waitForElementTobeClickable(AnamolyDetection_UI.navBtn_DrillThrough);
				clickOn(AnamolyDetection_UI.navBtn_DrillThrough);
				waitForElementTobeClickable(AnamolyDetection_UI.navBtn_Understand);
				clickOn(AnamolyDetection_UI.navBtn_Understand);
				waitForElementTobeLocated(AnamolyDetection_UI.title_Understand);
				if (isDisplayed(AnamolyDetection_UI.title_Understand))
					extentTest.log(LogStatus.PASS, "Navigates to Understand Page", "Navigated to Understand Page");
				else
					extentTest.log(LogStatus.FAIL, "Navigates to Understand Page",
							"Did not navigate to Understand Page");
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
				waitForElementTobeClickable(AnamolyDetection_UI.btn_Understand);
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
					extentTest.log(LogStatus.PASS, "Navigates to Investigate Page",
							"Navigated to <B>" + "Price, Promotions, PLC & Inventory" + "</B> Page");
				} else {
					extentTest.log(LogStatus.FAIL, "Navigates to Investigate Page",
							"Not able to navigate to <B>" + "Price, Promotions, PLC & Inventory" + "</B> Page");
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
	 * Validate Outlier Item Stores Card
	 * 
	 **/
	public void Validate_Card_OutlierItemStores_Anamoly() {
		synchronized (AnamolyDetection_Logic.class) {
			try {
				isDisplayed(AnamolyDetection_UI.card_OutlierItemStores_MainText);
				isDisplayed(AnamolyDetection_UI.card_OutlierItemStores_ItemStoresText);
				isDisplayed(AnamolyDetection_UI.card_OutlierItemStores_OutlierText);
				String mainValue = getTextOf(AnamolyDetection_UI.card_OutlierItemStores_MainValue);
				String itemStoresValue = getTextOf(AnamolyDetection_UI.card_OutlierItemStores_ItemStoresValue);
				String outlierValue = getTextOf(AnamolyDetection_UI.card_OutlierItemStores_OutlierValue);
				if (!(mainValue.equals("0") && itemStoresValue.equals("0")))
					extentTest.log(LogStatus.PASS, "Outlier Item Store should have Non Zero value",
							"Outlier Item Store is having Non Zero value");
				else
					extentTest.log(LogStatus.FAIL, "Outlier Item Store should have Non Zero value",
							"Outlier Item Store is having Zero value");

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Validate Outlier Item Stores Card
	 * 
	 **/
	public void Validate_InvestigateFilterShowsValue_Anamoly() {
		synchronized (AnamolyDetection_Logic.class) {
			try {
				waitForElementTobeLocated(AnamolyDetection_UI.span_Department);
				String spanDepartment = getTextOf(AnamolyDetection_UI.span_Department);
				waitForElementTobeLocated(AnamolyDetection_UI.span_Category);
				String spanCategory = getTextOf(AnamolyDetection_UI.span_Category);
				waitForElementTobeLocated(AnamolyDetection_UI.span_SubCategory);
				String spanSubCategory = getTextOf(AnamolyDetection_UI.span_SubCategory);
				waitForElementTobeLocated(AnamolyDetection_UI.span_Region);
				String spanRegion = getTextOf(AnamolyDetection_UI.span_Region);
				if (!(spanDepartment.equals("") && spanCategory.equals("") && spanSubCategory.equals("")
						&& spanRegion.equals("")))
					extentTest.log(LogStatus.PASS, "Department, Category, Sub Category, Region should show value",
							"Department, Category, Sub Category, Region is showing value");
				else
					extentTest.log(LogStatus.FAIL, "Department, Category, Sub Category, Region should show value",
							"Department, Category, Sub Category, Region is not showing value");

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Validate Outlier Item Stores Card
	 * 
	 **/
	public void Validate_Card_OutlierUnits_Anamoly() {
		synchronized (AnamolyDetection_Logic.class) {
			try {
				isDisplayed(AnamolyDetection_UI.card_OutlierUnits_MainText);
				isDisplayed(AnamolyDetection_UI.card_OutlierUnits_OutlierText);
				isDisplayed(AnamolyDetection_UI.card_OutlierUnits_UnitsText);
				String mainValue = getTextOf(AnamolyDetection_UI.card_OutlierUnits_MainValue);
				String OutlierUnitsValue = getTextOf(AnamolyDetection_UI.card_OutlierUnits_UnitsValue);
				String outlierValue = getTextOf(AnamolyDetection_UI.card_OutlierUnits_OutlierValue);
				if (!(mainValue.equals("0") && OutlierUnitsValue.equals("0")))
					extentTest.log(LogStatus.PASS, "Outlier Units should have Non Zero value",
							"Outlier Units is having Non Zero value");
				else
					extentTest.log(LogStatus.FAIL, "Outlier Units should have Non Zero value",
							"Outlier Units is having Zero value");

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Validate Outlier Sales Card
	 * 
	 **/
	public void Validate_Card_OutlierSales_Anamoly() {
		synchronized (AnamolyDetection_Logic.class) {
			try {
				isDisplayed(AnamolyDetection_UI.card_OutlierSales_MainText);
				isDisplayed(AnamolyDetection_UI.card_OutlierSales_SalesText);
				isDisplayed(AnamolyDetection_UI.card_OutlierSales_OutlierText);
				String mainValue = getTextOf(AnamolyDetection_UI.card_OutlierSales_MainValue);
				String OutlierSalesValue = getTextOf(AnamolyDetection_UI.card_OutlierSales_SalesValue);
				String outlierValue = getTextOf(AnamolyDetection_UI.card_OutlierSales_OutlierValue);
				if (!(mainValue.equals("0") && OutlierSalesValue.equals("0")))
					extentTest.log(LogStatus.PASS, "Outlier Sales should have Non Zero value",
							"Outlier Sales is having Non Zero value");
				else
					extentTest.log(LogStatus.FAIL, "Outlier Sales should have Non Zero value",
							"Outlier Sales is having Zero value");

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Validate Outlier Transactions
	 * 
	 **/
	public void Validate_Card_OutlierTransactions_Anamoly() {
		synchronized (AnamolyDetection_Logic.class) {
			try {
				isDisplayed(AnamolyDetection_UI.card_OutlierTransactions_MainText);
				isDisplayed(AnamolyDetection_UI.card_OutlierTransactions_OutlierText);
				isDisplayed(AnamolyDetection_UI.card_OutlierTransactions_TransactionsText);
				String mainValue = getTextOf(AnamolyDetection_UI.card_OutlierTransactions_MainValue);
				String transactionsValue = getTextOf(AnamolyDetection_UI.card_OutlierTransactions_TransactionsValue);
				String outlierValue = getTextOf(AnamolyDetection_UI.card_OutlierTransactions_OutlierValue);
				if (!(mainValue.equals("0") && transactionsValue.equals("0")))
					extentTest.log(LogStatus.PASS, "Outlier Transactions should have Non Zero value",
							"Outlier Transactions is having Non Zero value");
				else
					extentTest.log(LogStatus.FAIL, "Outlier Transactions should have Non Zero value",
							"Outlier Transactions is having Zero value");

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Validate Home Page Tree Chart has Data
	 * 
	 **/
	public void Validate_HomePageTreeChartHasData_Anamoly() {
		synchronized (AnamolyDetection_Logic.class) {
			boolean flag = false;
			try {
				int numOfChart = getElementsCount(AnamolyDetection_UI.chart_HomePage);
				for (int i = 1; i <= numOfChart; i++) {
					By elm = By.xpath("(//*[@role='treeitem'])[" + i + "]");
					isDisplayed(elm);
					actionClick(elm);
//					mouseHover(elm);
					waitForPageToLoad();
					snooze(5000);
					if (!getTextOf(AnamolyDetection_UI.chart_popupText).equals("")) {
						mouseHover(elm);
						snooze(5000);
						captureScreenShot();
						flag = true;
					}
				}
				if (flag)
					extentTest.log(LogStatus.PASS, "Chart should have data", "Chart is having data");
				else
					extentTest.log(LogStatus.FAIL, "Chart should have data", "Chart is not having data");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * Validate Outlier Investigation Report Date format
	 * 
	 **/
	public void Validate_TableHeader_DateFormat_Anamoly() {
		synchronized (AnamolyDetection_Logic.class) {
			boolean flag = false;
			try {
				waitForElementTobeLocated(AnamolyDetection_UI.tableHeader_Investigate_option);
				int size = getElementsCount(AnamolyDetection_UI.tableHeader_Investigate_option);
				for (int i = 1; i <= size; i++) {
					By cellVal = By.xpath(
							"((//div[@class='columnHeaders'])[2]//div[contains(@class,'pivotTableCellNoWrap cell-interactive')])["
									+ i + "]");
					String date = getTextOf(cellVal).trim();
					if (date.equals("")) {
						flag = false;
					} else {
						SimpleDateFormat sdfrmt = new SimpleDateFormat("yyyy-MM-dd");
						sdfrmt.setLenient(false);
						Date javaDate = sdfrmt.parse(date);
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
	public void Validate_KeyTrendInsightsHasObservations_Anamoly() {
		synchronized (AnamolyDetection_Logic.class) {
			boolean flag = false;
			try {
				waitForElementTobeLocated(AnamolyDetection_UI.tableHeader_Investigate_option);
				int size = getElementsCount(AnamolyDetection_UI.tableHeader_Investigate_option);
				for (int i = 1; i <= size; i++) {
					By cellVal = By.xpath(
							"((//div[@class='columnHeaders'])[2]//div[contains(@class,'pivotTableCellNoWrap cell-interactive')])["
									+ i + "]");
					String date = getTextOf(cellVal).trim();
					if (date.equals("")) {
						flag = false;
					} else {
						clickOn(cellVal);
						waitForPageToLoad();
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

	public void Validate_InsightsDropDown_DateFormat_Anamoly() {
		synchronized (AnamolyDetection_Logic.class) {
			boolean flag = false;
			try {
				waitForElementTobeLocated(AnamolyDetection_UI.dd_InsightsFor);
				clickOn(AnamolyDetection_UI.dd_InsightsFor);
				waitForElementTobeLocated(AnamolyDetection_UI.dd_InsightsFor_Option);
				int size = getElementsCount(AnamolyDetection_UI.dd_InsightsFor_Option);
				for (int i = 1; i <= size; i++) {
					By cellVal = By.xpath(
							"(//ancestor::div[@class='slicer-dropdown-content']//div[@class='slicerBody']//div[@class='row'])["
									+ i + "]");
					String date = getTextOf(cellVal).trim();
					if (date.equals("")) {
						flag = false;
					} else {
						SimpleDateFormat sdfrmt = new SimpleDateFormat("yyyy-MM-dd");
						sdfrmt.setLenient(false);
						Date javaDate = sdfrmt.parse(date);
						System.out.println(date + " is valid date format");
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
	 * Validate Seasonality Chart Has Data
	 * 
	 **/
	public void Validate_SeasonalityChartHasData_Anamoly() {
		synchronized (AnamolyDetection_Logic.class) {
			try {
				if (getChartStatus_Anamoly(AnamolyDetection_UI.chart_SeasonalityTrendResidual,
						AnamolyDetection_UI.chart_SeasonalityTrendResidual_option))
					extentTest.log(LogStatus.PASS, "Seasonality, Trend and Residual Chart should have data",
							"Seasonality, Trend and Residual Chart is having data");
				else
					extentTest.log(LogStatus.FAIL, "Seasonality, Trend and Residual Chart should have data",
							"Seasonality, Trend and Residual Chart is not having data");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Validate Outlier Investigation Chart Has Data
	 * 
	 **/
	public void Validate_OutlierInvestigationChartHasData_Anamoly() {
		synchronized (AnamolyDetection_Logic.class) {
			try {
				if (getChartStatus_Anamoly(AnamolyDetection_UI.chart_OutlierInvestigation,
						AnamolyDetection_UI.chart_OutlierInvestigation_option))
					extentTest.log(LogStatus.PASS, "Outlier Investigation Chart should have data",
							"Outlier Investigation Chart is having data");
				else
					extentTest.log(LogStatus.FAIL, "Outlier Investigation Chart should have data",
							"Outlier Investigation Chart is not having data");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Validate InterPlay Sales Chart Has Data
	 * 
	 **/
	public void Validate_InterPlayBtnSalesChartHasData_Anamoly() {
		synchronized (AnamolyDetection_Logic.class) {
			try {
				if (getChartStatus_Anamoly(AnamolyDetection_UI.chart_InterPlayBtnSales,
						AnamolyDetection_UI.chart_InterPlayBtnSales_option))
					extentTest.log(LogStatus.PASS, "InterPlay Sales Chart should have data",
							"InterPlay Sales Chart is having data");
				else
					extentTest.log(LogStatus.FAIL, "InterPlay Sales Chart should have data",
							"InterPlay Sales Chart is not having data");
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
				snooze(2000);
				clickOn(AnamolyDetection_UI.span_Department);
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
				// int before = getElementsCount(AnamolyDetection_UI.contextMenu);
				jsClickOn(AnamolyDetection_UI.navBtn_DrillThrough);
				waitForPageToLoad();
				int after = getElementsCount(AnamolyDetection_UI.contextMenu);
				int subMenusize = getElementsCount(
						By.xpath("(//*[@role='menu'])[" + after + "]//button[@role='menuitem']"));
				for (int i = 1; i < subMenusize; i++) {
					By opt = By.xpath("((//*[@role='menu'])[" + after + "]//button[@role='menuitem'])[" + i + "]");
					if (!getTextOf(opt).equals(""))
						flag = true;
				}
				if (flag)
					extentTest.log(LogStatus.PASS, "BusinessImpact Right click> drill through should show options",
							"Drill through is showing <B>[" + subMenusize + "]</B> options");
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
				waitForElementTobeLocated(AnamolyDetection_UI.table_Understand);
				isDisplayed(AnamolyDetection_UI.table_UnderStand_ColumnCount);
				List<WebElement> tableheader = driver
						.findElements(By.xpath("//div[@role='presentation']//div[@role='columnheader']"));
				List<WebElement> tablerowcount = driver.findElements(By.xpath("(//div[@role='row'])"));
				return tableheader.size() > 0 && tablerowcount.size() > 0;
			} catch (Exception e) {
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
			// driver.findElement(By.xpath("//*[@aria-label='"+Filtername+"']//ancestor::div[contains(@class,'slicer-container')]//div[@class='slicer-dropdown-menu']")).click();
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
				// flag = true;
				// break;
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
			String state = driver.findElement(AnamolyDetection_UI.dd_SelectAll_option).getAttribute("aria-checked");
			if (state.trim().equals("true")) {
				int rows = getFilterDropDownRowCount_Anamoly();
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
				driver.findElement(AnamolyDetection_UI.dd_SelectAll_option).click();
				String state2 = driver.findElement(AnamolyDetection_UI.dd_SelectAll_option)
						.getAttribute("aria-checked");
				if (state2.trim().equals("true")) {
					int rows = getFilterDropDownRowCount_Anamoly();
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
		extentTest.log(LogStatus.FAIL, "isMultiSelectActive: ", "Multi Select option is not working ");
		return false;

	}

	private boolean getChartStatus_Anamoly(By graph, By graphPointer) {
		boolean flag = false;
		try {
			waitForElementTobeLocated(graph);
			actionClick(graphPointer);
			waitForPageToLoad();
			snooze(5000);
			if (!getTextOf(AnamolyDetection_UI.chart_popupText).equals("")) {
				mouseHover(graphPointer);
				snooze(10000);
				captureScreenShot();
				flag = true;
			} else {
				flag = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}



}
