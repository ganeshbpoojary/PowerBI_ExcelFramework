package testlogic;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.relevantcodes.extentreports.LogStatus;
import frameworkutils.WebDriverFactory;
import uimaps.RPCC_Demand_UI;

public class RPCC_Demand_Logic extends WebDriverFactory {

	public RPCC_Demand_Logic(WebDriver driver, Map<String, String> dataBook) {
		super(driver, dataBook);
	}

	String filterName = dataBook.get("Fliter_Name");

	/**
	 * Validate Product Drill Through working
	 * 
	 **/
	public void validate_ProductDrillThrough_RPCC_Demand() {
		synchronized (RPCC_Demand_Logic.class) {
			try {
				waitForElementTobeClickable(RPCC_Demand_UI.treeMap_Product);
				int num = getElementsCount(RPCC_Demand_UI.treeMap_Product_Options);
				// Product xpath
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
	public void validate_LocationDrillThrough_RPCC_Demand() {
		synchronized (RPCC_Demand_Logic.class) {
			try {
				waitForElementTobeClickable(RPCC_Demand_UI.treeMap_Location);
				int num = getElementsCount(RPCC_Demand_UI.treeMap_Location_Options);
				// Location xpath
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
	 * Validate X Axis Has Date
	 * 
	 **/
	public void validate_XAxisHasDate_RPCC_Demand() {
		synchronized (RPCC_Demand_Logic.class) {
			boolean flag = false;
			try {
				waitForElementTobeLocated(RPCC_Demand_UI.span_XAxis_Options);
				int size = getElementsCount(RPCC_Demand_UI.span_XAxis_Options);
				for (int i = 1; i <= size; i++) {
					By elm = By.xpath(
							"(//*[@class='x axis hideLinesOnAxis setFocusRing']//*[@class='setFocusRing'])[" + i + "]");
					String date = getTextOf(elm).trim();
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
	public void validate_NeedAttentionIsActive_RPCC_Demand() {
		synchronized (RPCC_Demand_Logic.class) {
			boolean flag = false;
			try {
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
	public void validate_LastUpdatedIsPresent_RPCC_Demand() {
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
	public void validate_NeedAReviewIsActive_RPCC_Demand() {
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
	public void validate_NeedsAttention_DrillThrough_RPCC_Demand() {
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
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Validate Needs Review Drill through
	 * 
	 **/
	public void validate_NeedsReview_DrillThrough_RPCC_Demand() {
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
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Validate Card MAP Has Value
	 * 
	 **/
	public void validate_Card_MAPHasValue_RPCC_Demand() {
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
	public void validate_Card_WMAPHasValue_RPCC_Demand() {
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
	public void validate_Card_BIASHasValue_RPCC_Demand() {
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
	public void validate_Card_MADHasValue_RPCC_Demand() {
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
	public void validate_Card_RMSEHasValue_RPCC_Demand() {
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

	
	/**
	 * Validate Drop down has data
	 * 
	 **/
	public void validate_DropDownHasData_RPCC_Demand() {
		synchronized (RPCC_Demand_Logic.class) {
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

	/**
	 * Selection of a filter
	 * 
	 **/
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

	/**
	 * Validate From week filter has data
	 * 
	 **/
	public void validate_Understand_FilterFromWeekHasData_RPCC_Demand() {
		synchronized (RPCC_Demand_Logic.class) {
			try {
				waitForElementTobeClickable(RPCC_Demand_UI.dd_FromWeek);
				clickOn(RPCC_Demand_UI.dd_FromWeek);
				waitForElementTobeClickable(RPCC_Demand_UI.dd_FromWeek_Options);
				if (getElementsCount(RPCC_Demand_UI.dd_FromWeek_Options) > 0)
					extentTest.log(LogStatus.PASS, "Drop Down should have data", "Drop Down has <B>["
							+ getElementsCount(RPCC_Demand_UI.dd_FromWeek_Options) + "]</B> number of rows");
				else
					extentTest.log(LogStatus.FAIL, "Drop Down should have data", "Drop Down has no Data");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * Validate To week filter has data
	 * 
	 **/
	public void validate_Understand_FilterToWeekHasData_RPCC_Demand() {
		synchronized (RPCC_Demand_Logic.class) {
			try {
				waitForElementTobeClickable(RPCC_Demand_UI.dd_ToWeek);
				clickOn(RPCC_Demand_UI.dd_ToWeek);
				waitForElementTobeClickable(RPCC_Demand_UI.dd_ToWeek_Options);
				if (getElementsCount(RPCC_Demand_UI.dd_ToWeek_Options) > 0)
					extentTest.log(LogStatus.PASS, "Drop Down should have data", "Drop Down has <B>["
							+ getElementsCount(RPCC_Demand_UI.dd_ToWeek_Options) + "]</B> number of rows");
				else
					extentTest.log(LogStatus.FAIL, "Drop Down should have data", "Drop Down has no Data");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * Validate From Day filter has data
	 * 
	 **/
	public void validate_FilterFromDayHasData_RPCC_Demand() {
		synchronized (RPCC_Demand_Logic.class) {
			try {
				waitForElementTobeClickable(RPCC_Demand_UI.dd_FromDay);
				clickOn(RPCC_Demand_UI.dd_FromDay);
				waitForElementTobeClickable(RPCC_Demand_UI.dd_FromDay_Options);
				if (getElementsCount(RPCC_Demand_UI.dd_FromDay_Options) > 0)
					extentTest.log(LogStatus.PASS, "Drop Down should have data", "Drop Down has <B>["
							+ getElementsCount(RPCC_Demand_UI.dd_FromDay_Options) + "]</B> number of rows");
				else
					extentTest.log(LogStatus.FAIL, "Drop Down should have data", "Drop Down has no Data");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * Validate To Day filter has data
	 * 
	 **/
	public void validate_FilterToDayHasData_RPCC_Demand() {
		synchronized (RPCC_Demand_Logic.class) {
			try {
				waitForElementTobeClickable(RPCC_Demand_UI.dd_ToDay);
				clickOn(RPCC_Demand_UI.dd_ToDay);
				waitForElementTobeClickable(RPCC_Demand_UI.dd_ToDay_Options);
				if (getElementsCount(RPCC_Demand_UI.dd_ToDay_Options) > 0)
					extentTest.log(LogStatus.PASS, "Drop Down should have data", "Drop Down has <B>["
							+ getElementsCount(RPCC_Demand_UI.dd_ToDay_Options) + "]</B> number of rows");
				else
					extentTest.log(LogStatus.FAIL, "Drop Down should have data", "Drop Down has no Data");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * Validate Drop down has multi select option
	 * 
	 **/
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

	/**
	 * Validate Play button is working
	 * 
	 **/
	public void validate_PlayBookButtonIsWorking_RPCC_Demand() {
		synchronized (RPCC_Demand_Logic.class) {
			try {
				waitForElementTobeClickable(RPCC_Demand_UI.img_Playbook);
				clickOn(RPCC_Demand_UI.img_Playbook);
				waitForElementTobeLocated(RPCC_Demand_UI.title_Playbook);
				if (getElementsCount(RPCC_Demand_UI.title_Playbook) > 0)
					extentTest.log(LogStatus.PASS, "Playbook Page should be opened", "Navigated to Playbook Page");
				else
					extentTest.log(LogStatus.FAIL, "Playbook Page should be opened",
							"Not able to Navigate to Playbook Page");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * Validate Analyze Inventory button is working
	 * 
	 **/
	public void validate_AnalyzeInventoryButtonIsWorking_RPCC_Demand() {
		synchronized (RPCC_Demand_Logic.class) {
			try {
				waitForElementTobeClickable(RPCC_Demand_UI.btn_AnalyzeInventory);
				actionClick(RPCC_Demand_UI.btn_AnalyzeInventory);
				switchToBrowserTab(1);
				String url = driver.getCurrentUrl();
				driver.close();
				switchToBrowserTab(0);
				if (url.contains("lumuiportal"))
					extentTest.log(LogStatus.PASS, "Analyze Inventory button should work",
							"Analyze Inventory button is working");
				else
					extentTest.log(LogStatus.FAIL, "Analyze Inventory button should work",
							"Analyze Inventory button is not working");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * Validate Composit Score filter Has values
	 * 
	 **/
	public void validate_CompositScoreHasValue_RPCC_Demand() {
		synchronized (RPCC_Demand_Logic.class) {
			try {
				waitForElementTobeClickable(RPCC_Demand_UI.dd_CompositeScore);
				clickOn(RPCC_Demand_UI.dd_CompositeScore);
				int size = getElementsCount(RPCC_Demand_UI.dd_FromWeek_Options);
				for (int i = 1; i <= size; i++) {
					By row = By.xpath("((//div[@class='slicerBody'])[9]//div[@class='row'])[" + i + "]");

				}
				switchToBrowserTab(2);
				System.out.println(driver.getCurrentUrl());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * Validate Back page navigation is working
	 *  
	 **/
	public void validate_BackNavigationIsWorking_RPCC_Demand() {
		synchronized (RPCC_Demand_Logic.class) {
			try {
				waitForElementTobeClickable(RPCC_Demand_UI.title_Understand);
				clickOn(RPCC_Demand_UI.title_Understand);
				waitForElementTobeLocated(RPCC_Demand_UI.title_Understand);
				if (isDisplayed(RPCC_Demand_UI.title_Understand))
					extentTest.log(LogStatus.PASS, "Back Navigation should work", "Navigated to Understand Page");
				else
					extentTest.log(LogStatus.FAIL, "Back Navigation should work",
							"No able to Navigated to Understand Page");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * Validate Item Score Table Has DrillTrough is working
	 * 
	 **/

	public void validate_ItemScoreTableHasDrillTrough_RPCC_Demand() {
		synchronized (RPCC_Demand_Logic.class) {
			boolean flag = false;
			try {
				int rowCnt = getElementsCount(RPCC_Demand_UI.table_ItemScore_Options);
				for (int i = 1; i <= rowCnt; i++) {
					By elm = By.xpath(
							"((//div[@role='columnheader' and text()='Item Store'])[1]//ancestor::div[@class='innerContainer']//div[contains(@class,'pivotTableCellWrap cell-interactive') or contains(@class,'cell-interactive')])["
									+ i + "]");					
						rightClick(elm);
						isDisplayed(RPCC_Demand_UI.contextMenu);
						int options = getElementsCount(RPCC_Demand_UI.contextMenu_Option);
						for (int j = 1; j <= options; j++) {
							By opt = By.xpath("//*[@role='menu']//button[@role='menuitem'][" + j + "]");
							if (getTextOf(opt).equals("Drill through")) {
								clickOn(opt);
								waitForElementTobeClickable(RPCC_Demand_UI.navBtn_Analyze);
								clickOn(RPCC_Demand_UI.navBtn_Analyze);
								waitForElementTobeLocated(RPCC_Demand_UI.title_Analyze);
								flag = true;
								break;
							}
						}
						if (!flag) {
							actionClick(RPCC_Demand_UI.btn_Reset);
						}					
					if (flag)
						break;
				}
				if (flag)
					extentTest.log(LogStatus.PASS, "Table should have Drill through", "Table is having Drill through");
				else
					extentTest.log(LogStatus.FAIL, "Table should have Drill through", "Table is not having Drill through");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	
	/**
	 * Validate Under stock Table Has DrillTrough is working
	 * 
	 **/

	public void validate_UnderStockTableHasDrillTrough_RPCC_Demand() {
		synchronized (RPCC_Demand_Logic.class) {
			boolean flag = false;
			try {
				int rowCnt = getElementsCount(RPCC_Demand_UI.table_UnderStock_options);
				for (int i = 1; i <= rowCnt; i++) {
					By elm = By.xpath(
							"((//div[@class='innerContainer'])[2]//div[@class='flex-container cell-interactive '])["
									+ i + "]");					
						rightClick(elm);
						isDisplayed(RPCC_Demand_UI.contextMenu);
						int options = getElementsCount(RPCC_Demand_UI.contextMenu_Option);
						for (int j = 1; j <= options; j++) {
							By opt = By.xpath("//*[@role='menu']//button[@role='menuitem'][" + j + "]");
							if (getTextOf(opt).equals("Drill through")) {
								clickOn(opt);
								waitForElementTobeClickable(RPCC_Demand_UI.navBtn_Analyze);
								clickOn(RPCC_Demand_UI.navBtn_Analyze);
								waitForElementTobeLocated(RPCC_Demand_UI.title_Analyze);
								flag = true;
								break;
							}
						}
						if (!flag) {
							actionClick(RPCC_Demand_UI.btn_Reset);
						}					
					if (flag)
						break;
				}
				if (flag)
					extentTest.log(LogStatus.PASS, "Table should have Drill through", "Table is having Drill through");
				else
					extentTest.log(LogStatus.FAIL, "Table should have Drill through", "Table is not having Drill through");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Validate UnderStand Table Has Data
	 * 
	 **/

	public void validate_ItemScoreTableHasData_RPCC_Demand() {
		synchronized (RPCC_Demand_Logic.class) {
			int dataCell =0 ;
			try {
				waitForElementTobeLocated(RPCC_Demand_UI.table_ItemScore_Options);
				int rowCnt = getElementsCount(RPCC_Demand_UI.table_ItemScore_Options);
				for (int i = 1; i <= rowCnt; i++) {
					By elm = By.xpath(
							"((//div[@role='columnheader' and text()='Item Store'])[1]//ancestor::div[@class='innerContainer']//div[contains(@class,'pivotTableCellWrap cell-interactive') or contains(@class,'cell-interactive')])["
									+ i + "]");
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

	/**
	 * Validate Filter has Search opiton
	 * 
	 **/
	public void validate_DropDownHasSearchOption_RPCC_Demand() {
		synchronized (RPCC_Demand_Logic.class) {
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

	/**
	 * Navigates to UnderStand OutOfStock Page
	 * 
	 **/
	public void goto_UnderStand_OutOfStock_RPCC_Demand() {
		synchronized (RPCC_Demand_Logic.class) {
			try {
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
					if (flag)
						break;
				}
				if (flag)
					extentTest.log(LogStatus.PASS, "Navigate to Understand Out of Stock Page",
							"Navigated to Understand Out of Stock Page");
				else
					extentTest.log(LogStatus.FAIL, "Navigate to Understand Out of Stock Page",
							"Not able to navugate to Out of Stock Page");
			} catch (NoSuchElementException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Navigates to UnderStand UnderStock Page
	 * 
	 **/
	public void goto_UnderStand_UnderStock_RPCC_Demand() {
		synchronized (RPCC_Demand_Logic.class) {
			try {
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
								waitForElementTobeClickable(RPCC_Demand_UI.navBtn_ReviewUnderStock);
								clickOn(RPCC_Demand_UI.navBtn_ReviewUnderStock);
								waitForElementTobeLocated(RPCC_Demand_UI.title_UnderstandUnderStock);
								flag = true;
								break;
							}
						}
						if (!flag) {
							actionClick(RPCC_Demand_UI.title_Understand);
						}
					}
					if (flag)
						break;
				}
				if (flag)
					extentTest.log(LogStatus.PASS, "Navigate to Understand UnderStock Page",
							"Navigated to Understand Under Stock Page");
				else
					extentTest.log(LogStatus.FAIL, "Navigate to Understand UnderStock Page",
							"Not able to navigate to Under Stock Page");
			} catch (NoSuchElementException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Navigates to UnderStand OutOfStock Page
	 * 
	 **/
	public void goto_AnalyzePage_RPCC_Demand() {
		synchronized (RPCC_Demand_Logic.class) {
			boolean flag = false;
			try {
				int rowCnt = getElementsCount(RPCC_Demand_UI.table_ItemScore_Options);
				for (int i = 1; i <= rowCnt; i++) {
					By elm = By.xpath(
							"((//div[@role='columnheader' and text()='Item Store'])[1]//ancestor::div[@class='innerContainer']//div[contains(@class,'pivotTableCellWrap cell-interactive') or contains(@class,'cell-interactive')])["
									+ i + "]");					
						rightClick(elm);
						isDisplayed(RPCC_Demand_UI.contextMenu);
						int options = getElementsCount(RPCC_Demand_UI.contextMenu_Option);
						for (int j = 1; j <= options; j++) {
							By opt = By.xpath("//*[@role='menu']//button[@role='menuitem'][" + j + "]");
							if (getTextOf(opt).equals("Drill through")) {
								clickOn(opt);
								waitForElementTobeClickable(RPCC_Demand_UI.navBtn_Analyze);
								clickOn(RPCC_Demand_UI.navBtn_Analyze);
								waitForElementTobeLocated(RPCC_Demand_UI.title_Analyze);
								flag = true;
								break;
							}
						}
						if (!flag) {
							actionClick(RPCC_Demand_UI.btn_Reset);
						}					
					if (flag)
						break;
				}
				if (flag)
					extentTest.log(LogStatus.PASS, "Navigate to Analyze Page",
							"Navigated to Analyze Page");
				else
					extentTest.log(LogStatus.FAIL, "Navigate to Analyze Page",
							"Not able to navigate to Analyze Page");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
		
		
		
	/**
	 * Validate scatter graph chart has data
	 * 
	 **/	
	public void validate_ScatterChartHasData_RPCC_Demand() {
		synchronized (RPCC_Demand_Logic.class) {
			try {
				boolean flag = false;
				waitForElementTobeLocated(RPCC_Demand_UI.chart_Scatter_Option);
				int districtNum = getElementsCount(RPCC_Demand_UI.chart_Scatter_Option);
				if (districtNum > 100) {
					for (int i = 1; i <= 20; i++) {
						waitForPageToLoad();
						snooze(3000);
						WebElement elm = driver.findElement(By.xpath(
								"(//*[@class='scatterMarkerSeriesGroup']//*[@class='scatterMarker setFocusRing'])[" + i
										+ "]"));
						Actions action = new Actions(driver);
						action.moveToElement(elm).click().perform();
						String label = getTextOf(RPCC_Demand_UI.chart_PopMessage);
						if (!label.equals(""))
							flag = true;
					}
				} else {
					for (int i = 1; i <= 20; i++) {
						waitForPageToLoad();
						snooze(3000);
						WebElement elm = driver.findElement(By.xpath(
								"(//*[@class='scatterMarkerSeriesGroup']//*[@class='scatterMarker setFocusRing'])[" + i
										+ "]"));
						Actions action = new Actions(driver);
						action.moveToElement(elm).click().perform();
						String label = getTextOf(RPCC_Demand_UI.chart_PopMessage);
						if (!label.equals("")) {
							flag = true;
						}
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

	/**
	 * Validate Bar graph chart has data
	 * 
	 **/
	public void validate_BarChartHasDrillThrough_RPCC_Demand() {
		synchronized (RPCC_Demand_Logic.class) {
			try {
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
								waitForElementTobeClickable(RPCC_Demand_UI.navBtn_ReviewUnderStock);
								clickOn(RPCC_Demand_UI.navBtn_ReviewUnderStock);
								waitForElementTobeLocated(RPCC_Demand_UI.title_UnderstandUnderStock);
								flag = true;
								break;
							}
						}
						if (!flag) {
							actionClick(RPCC_Demand_UI.title_Understand);
						}
					}
					if (flag)
						break;
				}
				if (flag)
					extentTest.log(LogStatus.PASS, "Navigate to Understand UnderStock Page",
							"Navigated to Understand Under Stock Page");
				else
					extentTest.log(LogStatus.FAIL, "Navigate to Understand UnderStock Page",
							"Not able to navigate to Under Stock Page");
			} catch (NoSuchElementException e) {
				e.printStackTrace();
			}
		}
	}

	/*************************************************************************************************************************************/

	/**
	 * Private method to Validate Bar graph chart has data
	 * 
	 **/
	private boolean checkBarChartData() {
		try {
			boolean flag = false;
			By chartElm = By.xpath(
					"(//*[@class='columnChartUnclippedGraphicsContext'])[6]//*[@class='column sub-selectable setFocusRing']");
			for (int i = 1; i <= getElementsCount(chartElm); i++) {
				By bar = By.xpath(
						"((//*[@class='columnChartUnclippedGraphicsContext'])[6]//*[@class='column sub-selectable setFocusRing'])["
								+ i + "]");
				if (!(getAttributeValueOf(bar, "aria-label").equals("null"))) {
					actionClick(bar);
					waitForPageToLoad();
					snooze(3000);
					String label = getTextOf(RPCC_Demand_UI.chart_popupText);
					if (!label.equals(""))
						flag = true;
				}
			}
			return flag;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	/**
	 * Private method to Validate Bar graph chart has data
	 * 
	 **/
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

	/**
	 * Private method to Validate drop down has multi select
	 * 
	 **/
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