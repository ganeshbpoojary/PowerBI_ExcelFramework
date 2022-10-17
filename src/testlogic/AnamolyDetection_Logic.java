package testlogic;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.Arrays;
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
	 * validate Outlier Investigation Report
	 * 
	 **/
	public void validate_OutlierInvestigationReport_Anamoly() {
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
	 * validate Outlier Investigation Report
	 * 
	 **/
	public void validate_InterPlaySalesPricePromo_Anamoly() {
		synchronized (AnamolyDetection_Logic.class) {
			try {
				waitForElementTobeLocated(AnamolyDetection_UI.span_InterPlaySalesPricePromo);
				boolean spanSalesPrice = isDisplayed(AnamolyDetection_UI.span_InterPlaySalesPricePromo);
				boolean spanAndStore = isDisplayed(AnamolyDetection_UI.span_AndStore);
				String item = getTextOf(AnamolyDetection_UI.span_ItemFromIndex);
				String location = getTextOf(AnamolyDetection_UI.span_LocationFromIndex);
				if (!(item.equals("") && location.equals("")))
					extentTest.log(LogStatus.PASS, "Report should appear", "Inter Play Sales Report For Item <B>" + item
							+ "</B> and Store <B>" + location + "</B> is appearing");
				else
					extentTest.log(LogStatus.FAIL, "Report should appear", "Inter Play Sales is not  appear");

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * validate Outlier Item Stores Main Value
	 * 
	 **/
	public void validate_Card_OutlierItemStoresMainValue_Anamoly() {
		synchronized (AnamolyDetection_Logic.class) {
			try {
				isDisplayed(AnamolyDetection_UI.card_OutlierItemStores_MainText);
				String mainValue = getTextOf(AnamolyDetection_UI.card_OutlierItemStores_MainValue);
				if (!(mainValue.equals("0")))
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
	 * validate Outlier Item Stores Value
	 * 
	 **/
	public void validate_Card_OutlierItemStoresValue_Anamoly() {
		synchronized (AnamolyDetection_Logic.class) {
			try {
				isDisplayed(AnamolyDetection_UI.card_OutlierItemStores_ItemStoresText);
				String itemStoresValue = getTextOf(AnamolyDetection_UI.card_OutlierItemStores_ItemStoresValue);
				if (!(itemStoresValue.equals("0")))
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
	 * validate Outlier Value OutlierValue
	 * 
	 **/
	public void validate_Card_OutlierItemStoresOutlierValue_Anamoly() {
		synchronized (AnamolyDetection_Logic.class) {
			try {
				isDisplayed(AnamolyDetection_UI.card_OutlierItemStores_OutlierText);
				String outlierValue = getTextOf(AnamolyDetection_UI.card_OutlierItemStores_OutlierValue);
				if (!(outlierValue.equals("")))
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
	 * validate Department has default value
	 * 
	 **/
	public void validate_DepartmentHasAutoPopulate_Anamoly() {
		synchronized (AnamolyDetection_Logic.class) {
			try {
				waitForElementTobeLocated(AnamolyDetection_UI.span_Department);
				String spanDepartment = getTextOf(AnamolyDetection_UI.span_Department);
				if (!spanDepartment.equals(""))
					extentTest.log(LogStatus.PASS, "Department should show value", "Department is showing value");
				else
					extentTest.log(LogStatus.FAIL, "Department, should show value", "Department is not showing value");

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * validate Category has default value
	 * 
	 **/
	public void validate_CategoryHasAutoPopulate_Anamoly() {
		synchronized (AnamolyDetection_Logic.class) {
			try {
				waitForElementTobeLocated(AnamolyDetection_UI.span_Category);
				String spanCategory = getTextOf(AnamolyDetection_UI.span_Category);
				waitForElementTobeLocated(AnamolyDetection_UI.span_SubCategory);
				if (!spanCategory.equals(""))
					extentTest.log(LogStatus.PASS, "Category should show value", "Category is showing value");
				else
					extentTest.log(LogStatus.FAIL, "Category should show value", "Category is not showing value");

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * validate Sub Category has default value
	 * 
	 **/
	public void validate_SubCategoryHasAutoPopulate_Anamoly() {
		synchronized (AnamolyDetection_Logic.class) {
			try {
				waitForElementTobeLocated(AnamolyDetection_UI.span_SubCategory);
				String spanSubCategory = getTextOf(AnamolyDetection_UI.span_SubCategory);
				if (!spanSubCategory.equals(""))
					extentTest.log(LogStatus.PASS, "Sub Category should show value", "Sub Category is showing value");
				else
					extentTest.log(LogStatus.FAIL, "Sub Category should show value",
							"Sub Category is not showing value");

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * validate Region has default value
	 * 
	 **/
	public void validate_RegionHasAutoPopulate_Anamoly() {
		synchronized (AnamolyDetection_Logic.class) {
			try {
				waitForElementTobeLocated(AnamolyDetection_UI.span_Region);
				String spanRegion = getTextOf(AnamolyDetection_UI.span_Region);
				if (!spanRegion.equals(""))
					extentTest.log(LogStatus.PASS, "Region should show value", "Region is showing value");
				else
					extentTest.log(LogStatus.FAIL, "Region should show value", "Region is not showing value");

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * validate Outlier Units Main Value
	 * 
	 **/
	public void validate_Card_OutlierUnitsMainValue_Anamoly() {
		synchronized (AnamolyDetection_Logic.class) {
			try {
				isDisplayed(AnamolyDetection_UI.card_OutlierUnits_MainText);
				String mainValue = getTextOf(AnamolyDetection_UI.card_OutlierUnits_MainValue);
				if (!(mainValue.equals("0")))
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
	 * validate Outlier units value
	 * 
	 **/
	public void validate_Card_OutlierUnitsValue_Anamoly() {
		synchronized (AnamolyDetection_Logic.class) {
			try {
				isDisplayed(AnamolyDetection_UI.card_OutlierUnits_UnitsText);
				String OutlierUnitsValue = getTextOf(AnamolyDetection_UI.card_OutlierUnits_UnitsValue);
				if (!(OutlierUnitsValue.equals("0")))
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
	 * validate Outlier Outlier Value
	 * 
	 **/
	public void validate_Card_OutlierUnits_Anamoly() {
		synchronized (AnamolyDetection_Logic.class) {
			try {
				isDisplayed(AnamolyDetection_UI.card_OutlierUnits_OutlierText);
				String outlierValue = getTextOf(AnamolyDetection_UI.card_OutlierUnits_OutlierValue);
				if (!(outlierValue.equals("")))
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
	 * validate Outlier Sales Card
	 * 
	 **/
	public void validate_Card_OutlierSalesMainValue_Anamoly() {
		synchronized (AnamolyDetection_Logic.class) {
			try {
				isDisplayed(AnamolyDetection_UI.card_OutlierSales_MainText);
				String mainValue = getTextOf(AnamolyDetection_UI.card_OutlierSales_MainValue);
				if (!(mainValue.equals("0")))
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
	 * validate Outlier Sales value
	 * 
	 **/
	public void validate_Card_OutlierSalesValue_Anamoly() {
		synchronized (AnamolyDetection_Logic.class) {
			try {
				isDisplayed(AnamolyDetection_UI.card_OutlierSales_SalesText);
				String OutlierSalesValue = getTextOf(AnamolyDetection_UI.card_OutlierSales_SalesValue);
				if (!(OutlierSalesValue.equals("0")))
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
	 * validate Outlier Sales outlier value
	 * 
	 **/
	public void validate_Card_OutlierSales_Anamoly() {
		synchronized (AnamolyDetection_Logic.class) {
			try {
				isDisplayed(AnamolyDetection_UI.card_OutlierSales_OutlierText);
				String outlierValue = getTextOf(AnamolyDetection_UI.card_OutlierSales_OutlierValue);
				if (!(outlierValue.equals("")))
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
	 * validate Outlier Transactions Main Value
	 * 
	 **/
	public void validate_Card_OutlierTransactionsMainValue_Anamoly() {
		synchronized (AnamolyDetection_Logic.class) {
			try {
				isDisplayed(AnamolyDetection_UI.card_OutlierTransactions_MainText);
				String mainValue = getTextOf(AnamolyDetection_UI.card_OutlierTransactions_MainValue);
				if (!(mainValue.equals("0")))
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
	 * validate Outlier Transactions Value
	 * 
	 **/
	public void validate_Card_OutlierTransactionsValue_Anamoly() {
		synchronized (AnamolyDetection_Logic.class) {
			try {
				isDisplayed(AnamolyDetection_UI.card_OutlierTransactions_TransactionsText);
				String transactionsValue = getTextOf(AnamolyDetection_UI.card_OutlierTransactions_TransactionsValue);
				if (!(transactionsValue.equals("0")))
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
	 * validate Outlier Transactions Outlier Value
	 * 
	 **/
	public void validate_Card_OutlierTransactionsOutlierValue_Anamoly() {
		synchronized (AnamolyDetection_Logic.class) {
			try {
				isDisplayed(AnamolyDetection_UI.card_OutlierTransactions_OutlierText);
				String outlierValue = getTextOf(AnamolyDetection_UI.card_OutlierTransactions_OutlierValue);
				if (!(outlierValue.equals("")))
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

	// Verify understand homepage of outlierItemStores

	public void validate_Understand_OutlierItemStores_Anamoly() {
		synchronized (AnamolyDetection_Logic.class) {
			try {
				isDisplayed(AnamolyDetection_UI.understand_OutlierItemStores_MainText);
				isDisplayed(AnamolyDetection_UI.understand_OutlierItemStores_ItemStoresText);
				isDisplayed(AnamolyDetection_UI.understand_OutlierItemStores_OutlierText);
				String mainValue = getTextOf(AnamolyDetection_UI.understand_OutlierItemStores_MainValue);
				String itemStoresValue = getTextOf(AnamolyDetection_UI.understand_OutlierItemStores_ItemStoresValue);
				if (!(mainValue.equals("0") && itemStoresValue.equals("0")))
					extentTest.log(LogStatus.PASS, " understand Outlier Item Store should have Non Zero value",
							"Outlier Item Store is having Non Zero value");
				else
					extentTest.log(LogStatus.PASS, " understand Outlier Item Store should have Non Zero value",
							"Outlier Item Store is having Zero value");

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	// Verify understand homepage of outlierUnits
	public void validate_Undesrstand_OutlierUnits_Anamoly() {
		synchronized (AnamolyDetection_Logic.class) {
			try {
				isDisplayed(AnamolyDetection_UI.understand_outlier_MainText);
				isDisplayed(AnamolyDetection_UI.understand_outlier_unitsText);
				isDisplayed(AnamolyDetection_UI.understand_outlier_OutlierText);
				String mainValue = getTextOf(AnamolyDetection_UI.understand_outlier_MainValue);
				String OutlierUnitsValue = getTextOf(AnamolyDetection_UI.understand_outlier_unitsValue);
				if (!(mainValue.equals("0") && OutlierUnitsValue.equals("0")))
					extentTest.log(LogStatus.PASS, "understand Outlier Units should have Non Zero value",
							"Outlier Units is having Non Zero value");
				else
					extentTest.log(LogStatus.PASS, " understand Outlier Units should have Non Zero value",
							"Outlier Units is having Zero value");

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	// Verify understand homepage of OutlierSales
	public void validate_Understand_OutlierSales_Anamoly() {
		synchronized (AnamolyDetection_Logic.class) {
			try {
				isDisplayed(AnamolyDetection_UI.understand_outlier_sales_MainText);
				isDisplayed(AnamolyDetection_UI.understand_outlier_sales_salesText);
				isDisplayed(AnamolyDetection_UI.understand_outlier_sales_salesValue);
				String mainValue = getTextOf(AnamolyDetection_UI.understand_outlier_sales_MainValue);
				String OutlierSalesValue = getTextOf(AnamolyDetection_UI.understand_outlier_sales_salesValue);
				if (!(mainValue.equals("0") && OutlierSalesValue.equals("0")))
					extentTest.log(LogStatus.PASS, " understand Outlier Sales should have Non Zero value",
							"Outlier Sales is having Non Zero value");
				else
					extentTest.log(LogStatus.PASS, " understand Outlier Sales should have Non Zero value",
							"Outlier Sales is having Zero value");

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	// Verify understand homepage of OutlierTransactions
	public void validate_Understand_OutlierTransactions_Anamoly() {
		synchronized (AnamolyDetection_Logic.class) {
			try {

				isDisplayed(AnamolyDetection_UI.understand_outlier_transaction_MainText);
				isDisplayed(AnamolyDetection_UI.understand_outlier_transactionsOutlierText);
				isDisplayed(AnamolyDetection_UI.understand_outlier_transactionsValue);
				String mainValue = getTextOf(AnamolyDetection_UI.understand_outlier_transaction_MainValue);
				String transactionsValue = getTextOf(AnamolyDetection_UI.card_OutlierTransactions_TransactionsValue);
				if (!(mainValue.equals("0") && transactionsValue.equals("0")))
					extentTest.log(LogStatus.PASS, "Outlier Transactions should have Non Zero value",
							"Outlier Transactions is having Non Zero value");
				else
					extentTest.log(LogStatus.PASS, "Outlier Transactions should have Non Zero value",
							"Outlier Transactions is having Zero value");

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void validate_HomePageTreeChartHasData_Anamoly() {
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
	 * validate Outlier Investigation Report Date format
	 * 
	 **/
	public void validate_TableHeader_DateFormat_Anamoly() {
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
	 * validate Insights Has Observations Date format
	 * 
	 **/
	public void validate_KeyTrendInsightsHasObservations_Anamoly() {
		synchronized (AnamolyDetection_Logic.class) {
			boolean flag = false;
			try {
				waitForElementTobeLocated(AnamolyDetection_UI.tableHeader_Investigate_option);
				int size = getElementsCount(AnamolyDetection_UI.tableHeader_Investigate_option);
				for (int i = 1; i <= size - 1; i++) {
					By cellVal = By.xpath(
							"((//div[@class='columnHeaders'])[2]//div[contains(@class,'pivotTableCellNoWrap cell-interactive')])["
									+ i + "]");
					String YYYYMMDD = getTextOf(cellVal).trim();
					String[] dateMomYr = YYYYMMDD.split("-");
					String year = dateMomYr[0];
					String month = dateMomYr[1];
					String date = dateMomYr[2];
					if (month.substring(0, 1).equals("0")) {
						month = month.substring(1, 2);
					}
					if (date.substring(0, 1).equals("0")) {
						date = date.substring(1, 2);
					}
					String headerDate = month + "/" + date + "/" + year;
					clickOn(cellVal);
					waitForPageToLoad();
					snooze(5000);
					String str = getTextOf(AnamolyDetection_UI.span_ObervationsFor);
					String[] value = str.split(" ");
//					System.out.println(value[2]);
					if (headerDate.equals(value[2])) {
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

	public void validate_InsightsDropDownHasDates_Anamoly() {
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
//						System.out.println(date + " is valid date format");
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
	 * validate Seasonality Chart Has Data
	 * 
	 **/
	public void validate_SeasonalityChartHasData_Anamoly() {
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
	 * validate Outlier Investigation Chart Has Data
	 * 
	 **/
	public void validate_OutlierInvestigationChartHasData_Anamoly() {
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
	 * validate InterPlay Sales Chart Has Data
	 * 
	 **/
	public void validate_InterPlayBtnSalesChartHasData_Anamoly() {
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
	 * validate Outlier Investigation Report Date format
	 * 
	 **/
	public void validate_OutlierTableHasData_Anamoly() {
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
				if (dataCell > blankCell)
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
	 * validate InterPlaytable has data *
	 **/
	public void validate_InterPlaySalesTableHasData_Anamoly() {
		synchronized (AnamolyDetection_Logic.class) {
			try {
				int blankCell = 0;
				int dataCell = 0;
				waitForElementTobeLocated(AnamolyDetection_UI.table_InterPlaySales_option);
				int size = getElementsCount(AnamolyDetection_UI.table_InterPlaySales_option);
				for (int i = 1; i <= size; i++) {
					By cellVal = By.xpath(
							"((//div[@class='bodyCells'])[1]//div[contains(@class,'pivotTableCellWrap')])[" + i + "]");
					if (getTextOf(cellVal).equals(" "))
						blankCell = blankCell + 1;
					else
						dataCell = dataCell + 1;
				}
				if (dataCell > blankCell)
					extentTest.log(LogStatus.PASS, "InterPlay Sales Table Has Data validation",
							"InterPlay Sales Table has Data");
				else
					extentTest.log(LogStatus.FAIL, "InterPlay Sales Table Has Data validation",
							"InterPlay Sales Table does not have Data");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * validate Business impact right click shows options
	 * 
	 **/
	public void validate_BusinessImpactShowsOptions_Anamoly() {
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
	 * validate Priority Score right click shows options
	 * 
	 **/
	public void validate_PriorityScoreShowsOptions_Anamoly() {
		synchronized (AnamolyDetection_Logic.class) {
			try {
				boolean flag = false;
				int columnCnt = getElementsCount(AnamolyDetection_UI.table_UnderStand_ColumnCount);
				int rowCnt = getElementsCount(AnamolyDetection_UI.table_UnderStand_RowCount);
				for (int col = 3; col <= columnCnt; col++) {
					for (int row = 1; row <= rowCnt; row++) {
						By cellValue = By.xpath("(//div[@role='row'])[" + row + "]//div[@aria-colindex='" + col + "']");
//						System.out.println(getTextOf(cellValue));
						if (getTextOf(cellValue).contains("%")) {
							rightClick(cellValue);
							break;
						}
					}
				}
				snooze(2000);
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
					extentTest.log(LogStatus.PASS, "Priority Score Right click should show options",
							"BusinessImpact Right click is showing <B>[" + options + "]</B> options");
				else
					extentTest.log(LogStatus.FAIL, "Priority Score Right click should show options",
							"BusinessImpact Right click is not showing any options");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * validate Business impact Drill through shows options
	 * 
	 **/
	public void validate_BusinessImpactDrillThroughShowsOtions_Anamoly() {
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

//	public void validateDropDownHasData_Anamoly() {
//		synchronized (AnamolyDetection_Logic.class) {
//			try {
//				waitForPageToLoad();
//				clickonFilterandvalidatethedata_Anamoly();
//				extentTest.log(LogStatus.PASS, "Drop Down Data presence validation", "Drop Down has Data");
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				extentTest.log(LogStatus.FAIL, "Drop Down Data presence validation", "Drop Down has no Data");
//				e.printStackTrace();
//			}
//		}
//	}

	// validate value in the dropdown
	public void validateValueInDropDown_Anamoly() {
		synchronized (AnamolyDetection_Logic.class) {
			try {
				checkDropDownForOption_Anamoly(filterOption);
			} catch (Exception e) {
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
	}

	public void goto_FilterOption_Anamoly() {
		synchronized (AnamolyDetection_Logic.class) {
			try {
				By filter = By.xpath("//*[@title='" + filterName + "']/../../../..//div[@role='combobox']");
				waitForElementTobeClickable(filter);
				clickOn(filter);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void clickonFilterandchecktheSearchButton_Anamoly() {
		synchronized (AnamolyDetection_Logic.class) {
			try {
				waitForPageToLoad();
				isDisplayed(AnamolyDetection_UI.anamolySearch);
				extentTest.log(LogStatus.PASS, "anamoly Search is enabled", "anamoly Search  has Data");

			} catch (Exception e) {
				extentTest.log(LogStatus.FAIL, "anamoly Search  disabled", "anamoly Search  has no Data");
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

	public void validate_DropDownHasData_AD() {
		synchronized (AnamolyDetection_Logic.class) {
			try {
				By optCount = By
						.xpath("//div[@role='listbox' and @aria-label='" + filterName + "']//div[@class='row']");
				int rowCount = getElementsCount(optCount);
				if (rowCount > 0)
					extentTest.log(LogStatus.PASS, "Drop Down should have data",
							"Drop Down has <B>[" + rowCount + "]</B> number of rows");
				else
					extentTest.log(LogStatus.FAIL, "Drop Down should have data", "Drop Down has no Data");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void validate_UnderstandTableHasData_AD() {
		synchronized (AnamolyDetection_Logic.class) {
//			boolean flag = false;
			int blankCell = 0;
			int dataCell = 0;
			try {
				int columnCnt = getElementsCount(AnamolyDetection_UI.table_UnderStand_ColumnCount);
				int rowCnt = getElementsCount(AnamolyDetection_UI.table_UnderStand_RowCount);
				for (int col = 3; col <= columnCnt; col++) {
					for (int row = 1; row <= rowCnt; row++) {
						By cellVal = By
								.xpath("(//div[@role='row'])[" + rowCnt + "]//div[@aria-colindex='" + columnCnt + "']");
						if (!(getTextOf(cellVal).equals(" ") && getTextOf(cellVal).equals("0")))
							dataCell = dataCell + 1;
						else
							blankCell = blankCell + 1;
					}
				}
				if (dataCell > blankCell)
					extentTest.log(LogStatus.PASS, "Table should have data", "Table is having data Cell - <B>["
							+ dataCell + "]</B> & blank Cell - <B>[" + blankCell + "]</B>");
				else
					extentTest.log(LogStatus.FAIL, "Table should have data", "Table is not having data");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void validate_DropDownHasSearchOption_AD() {
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

	/*************************************************
	 * Private methods
	 **************************************************************/

//	private void clickonFilterandvalidatethedata_Anamoly() {
//		// TODO Auto-generated method stub
//		waitForPageToLoad();
//		List<WebElement> checkboxes = driver.findElements(By.xpath("//*[@class='slicerItemContainer']"));
//		if (checkboxes.size() > 0) {
//			// driver.findElement(By.xpath("//*[@aria-label='"+Filtername+"']//ancestor::div[contains(@class,'slicer-container')]//div[@class='slicer-dropdown-menu']")).click();
//			return;
//		}
//	}

	private boolean get_UnderstandTableContent() {
		synchronized (AnamolyDetection_Logic.class) {
		boolean flag = false;
		int blankCell = 0;
		int dataCell = 0;
		try {
			int columnCnt = getElementsCount(AnamolyDetection_UI.table_UnderStand_ColumnCount);
			int rowCnt = getElementsCount(AnamolyDetection_UI.table_UnderStand_RowCount);
			for (int col = 3; col <= columnCnt; col++) {
				for (int row = 1; row <= rowCnt; row++) {
					By cellVal = By
							.xpath("(//div[@role='row'])[" + rowCnt + "]//div[@aria-colindex='" + columnCnt + "']");
					if (!(getTextOf(cellVal).equals(" ") && getTextOf(cellVal).equals("0")))
						dataCell = dataCell + 1;
					else
						blankCell = blankCell + 1;
				}
				if (dataCell > blankCell)
					flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	}

	public boolean verify_Importance_forecastability_Anamoly() {	
		try {
		isDisplayed(AnamolyDetection_UI.Importance_forecastability_coloumnheader);
		isDisplayed(AnamolyDetection_UI.exploraryOutlierBars);
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
		if (dataCell > blankCell)
			extentTest.log(LogStatus.PASS, "Importance_forecastability Table Has Data validation",
					"Outlier Table has Data");
		else
			extentTest.log(LogStatus.FAIL, "Importance_forecastability Table Has Data validation",
					"Outlier Table does not have Data");
	} catch (Exception e) {
		e.printStackTrace();
	}
		return false;
	}

	public boolean verify_exploratory_overview_outlierStores_Anamoly() {
		try {
			int number = getElementsCount(AnamolyDetection_UI.exploraryOutlierItemStores);
			if (number > 0 && isDisplayed(AnamolyDetection_UI.exploraryOutlierItemStoresText)) {
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	private boolean clickOnPriority_Anamoly() {
		boolean flag = false;
		try {
			int columnCnt = getElementsCount(AnamolyDetection_UI.table_UnderStand_ColumnCount);
			int rowCnt = getElementsCount(AnamolyDetection_UI.table_UnderStand_RowCount);
			for (int col = 3; col <= columnCnt; col++) {
				for (int row = 1; row <= rowCnt; row++) {
					By cellValue = By.xpath("(//div[@role='row'])[" + row + "]//div[@aria-colindex='" + col + "']");
//					System.out.println(getTextOf(cellValue));
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
