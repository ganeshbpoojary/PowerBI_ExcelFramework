package testlogic;

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
import uimaps.Shopper_UI;
import uimaps.Supplier_UI;

public class RPCC_Demand_Logic extends WebDriverFactory {

	public RPCC_Demand_Logic(WebDriver driver, Map<String, String> dataBook) {
		super(driver, dataBook);
	}

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
	 * Validate Needs Attention and Needs Review Button Validate Last Updated
	 * message
	 * 
	 **/
	public void Validate_NeedAttention_Review_RPCC_Demand() {
		synchronized (RPCC_Demand_Logic.class) {
			boolean flag = false;
			try {

				isDisplayed(RPCC_Demand_UI.span_LastUpdated);
				waitForElementTobeClickable(RPCC_Demand_UI.btn_NeedsAttention);
				waitForElementTobeClickable(RPCC_Demand_UI.btn_NeedsReview);

				actionClick(RPCC_Demand_UI.btn_NeedsAttention);
				waitForElementTobeLocated(RPCC_Demand_UI.table_AttentionReview);
				isDisplayed(RPCC_Demand_UI.table_AttentionReview);

				actionClick(RPCC_Demand_UI.btn_NeedsReview);
				waitForElementTobeLocated(RPCC_Demand_UI.table_AttentionReview);
				isDisplayed(RPCC_Demand_UI.table_AttentionReview);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Validate Needs Attention & Needs Review Drill through
	 * 
	 **/
	public void Validate_DrillThrough_RPCC_Demand() {
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
		synchronized (Shopper_Logic.class) {
			try {
				if (checkBarChartData())
					extentTest.log(LogStatus.PASS, "Chart should have data","Chart - <B>"+"Forecast Trend"+"</B> is having data");
				else
					extentTest.log(LogStatus.FAIL, "Chart should have data",
							"Chart - <B>"+"Forecast Trend"+"</B> is not having data");
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
		synchronized (Shopper_Logic.class) {
			try {
				if (checkTreeChartData())
					extentTest.log(LogStatus.PASS, "Chart should have data",
							"Chart - <B>" +"Tree Map"+ "</B> is having data");
				else
					extentTest.log(LogStatus.FAIL, "Chart should have data",
							"Chart - <B>" + "Tree Map" + "</B> is having data");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/*
	 * Private methods
	 */
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
			By chartElm = By.xpath("(//*[contains(text(),'MAPE (%) across product (left) and location (right) hierarchies')]//ancestor::div[contains(@class,'themableBorderColorSolid')])[1]//*[@role='treeitem']");
			for (int i = 1; i <= getElementsCount(chartElm); i++) {
				By tree = By.xpath("((//*[contains(text(),'MAPE (%) across product (left) and location (right) hierarchies')]//ancestor::div[contains(@class,'themableBorderColorSolid')])[1]//*[@role='treeitem'])["
						+ i + "]");
				actionClick(tree);
				waitForPageToLoad();
				snooze(3000);
				String label = getTextOf(Shopper_UI.chart_popupText);
				if (!label.equals(""))
					flag = true;
				else
					flag = false;
			}
			return flag;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
}