package testlogic;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import uimaps.Shopper_UI;

public class Shopper_Logic extends WebDriverFactory {

	public Shopper_Logic(WebDriver driver, Map<String, String> dataBook) {
		super(driver, dataBook);
	}

	String filterName = dataBook.get("Filter_Name");
	String chartName = dataBook.get("Chart_Name");
	String chartUnit = dataBook.get("Chart_Unit");
	String yAxis = dataBook.get("Y_Axis");
	String xAxis = dataBook.get("X_Axis");
	String cardName = dataBook.get("Card_Name");

	public static ArrayList<String> weeks() {
		ArrayList<String> WeekList = new ArrayList<String>();
		WeekList.add("Mon");
		WeekList.add("Tue");
		WeekList.add("Wed");
		WeekList.add("Thu");
		WeekList.add("Fri");
		WeekList.add("Sat");
		WeekList.add("Sun");
		return WeekList;
	}

	public static ArrayList<String> months() {
		ArrayList<String> monthList = new ArrayList<String>();
		monthList.add("Jan");
		monthList.add("Feb");
		monthList.add("Mar");
		monthList.add("Apr");
		monthList.add("May");
		monthList.add("Jun");
		monthList.add("Jul");
		monthList.add("Aug");
		monthList.add("Sep");
		monthList.add("Oct");
		monthList.add("Nov");
		monthList.add("Dec");
		return monthList;
	}

	/*
	 * Creating list of short month names
	 */
	public static ArrayList<String> short_months(ArrayList<String> monthList) {
		ArrayList<String> shortMonthList = new ArrayList<String>();
		for (int i = 0; i < monthList.size(); i++) {
			shortMonthList.add(monthList.get(i).substring(0, 3));
		}
		return shortMonthList;
	}

	/*
	 * Navigate to Market Basket Analysis Tab
	 */
	public void goto_Tab_MarketBasketAnalysis_Shopper() {
		synchronized (Shopper_Logic.class) {
			try {
				waitForElementTobeClickable(Shopper_UI.tab_MarketBasketAnalysis);
				actionClick(Shopper_UI.tab_MarketBasketAnalysis);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/*
	 * Navigate to Mission Trip Analysis Tab
	 */
	public void goto_Tab_MissionTripAnalysis_Shopper() {
		synchronized (Shopper_Logic.class) {
			try {
				waitForElementTobeClickable(Shopper_UI.tab_MissionTripAnalysis);
				actionClick(Shopper_UI.tab_MissionTripAnalysis);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/*
	 * Navigate to Shopper Segment Tab
	 */
	public void goto_Tab_ShopperSegment_Shopper() {
		synchronized (Shopper_Logic.class) {
			try {
				waitForElementTobeClickable(Shopper_UI.tab_ShopperSegment);
				actionClick(Shopper_UI.tab_ShopperSegment);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/*
	 * Navigate to CDT Need State Analysis Tab
	 */
	public void goto_Tab_CDTNeedStateAnalysis_Shopper() {
		synchronized (Shopper_Logic.class) {
			try {
				waitForElementTobeClickable(Shopper_UI.tab_CDTNeedStateAnalysis);
				actionClick(Shopper_UI.tab_CDTNeedStateAnalysis);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/*
	 * Clicking on button How Have My Basket Metrics Performed
	 */
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

	/*
	 * Clicking on button What Is My Basket Value Size During Event Regular Periods
	 */
	public void goto_Btn_WhatIsMyBasketValueSizeDuringEventRegularPeriods_Shopper() {
		synchronized (Shopper_Logic.class) {
			try {
				doubleClick(Shopper_UI.btn_WhatIsMyBasketValueSizeDuringEventRegularPeriods);
				waitForPageToLoad();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/*
	 * Clicking on button What Is My Basket Value Size During Event Regular Periods
	 */
	public void goto_Btn_WhatInsightsCanIGetFromMyMarketBasketAnalysis_Shopper() {
		synchronized (Shopper_Logic.class) {
			try {
				doubleClick(Shopper_UI.btn_WhatInsightsCanIGetFromMyMarketBasketAnalysis);
				waitForPageToLoad();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/*
	 * Clicking on button How Are My Key Basket Metrics Trending
	 */
	public void goto_Btn_HowAreMyKeyBasketMetricsTrending_Shopper() {
		synchronized (Shopper_Logic.class) {
			try {
				doubleClick(Shopper_UI.btn_HowAreMyKeyBasketMetricsTrending);
				waitForPageToLoad();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/*
	 * Clicking on button How Are My Trip Missions trending
	 */
	public void goto_Btn_HowAreMyTripMissionstrending_Shopper() {
		synchronized (Shopper_Logic.class) {
			try {
				doubleClick(Shopper_UI.btn_HowAreMyTripMissionstrending);
				waitForPageToLoad();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/*
	 * Open required filter
	 */
	public void goto_FilterOption_Shopper() {
		synchronized (Shopper_Logic.class) {
			try {
				By filter = By.xpath("//*[@title='" + filterName + "']/../../../..//div[@role='combobox']");
				waitForElementTobeClickable(filter);
				jsClickOn(filter);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/*
	 * Validate filter has data
	 */
	public void validate_DropDownHasData_Shopper() {
		synchronized (Shopper_Logic.class) {
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

	/*
	 * Validate filter has Multi select option
	 */
	public void validate_DropDownHasMultiSelect_Shopper() {
		synchronized (Shopper_Logic.class) {
			try {
				if (isMultiSelectActive_Shopper())
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

	/*
	 * Validate filter has Search option
	 */
	public void validate_DropDownHasSearchOption_Shopper() {
		synchronized (Shopper_Logic.class) {
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

	/*
	 * Validate Scatter Chart has data
	 */
	public void validate_ScatterChartHasData_Shopper() {
		synchronized (Shopper_Logic.class) {
			try {
				boolean flag = false;
				waitForElementTobeLocated(Shopper_UI.chart_TopDistrictContribution_Option);
				int districtNum = getElementsCount(Shopper_UI.chart_TopDistrictContribution_Option);
				if (districtNum > 50) {
					districtNum = 10;
				}
				for (int i = 1; i <= districtNum; i++) {
					waitForPageToLoad();
					snooze(3000);
					WebElement elm = driver.findElement(
							By.xpath("(//*[@class='scatterMarkerSeriesGroup']//*[@class='scatterMarker setFocusRing'])["
									+ i + "]"));
					Actions action = new Actions(driver);
					action.moveToElement(elm).click().perform();
					String label = getTextOf(Shopper_UI.chart_TopDistrictContribution_PopMessage);
					if (!label.equals("")) {
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
				e.printStackTrace();
			}
		}
	}

	/*
	 * Validate Table has data
	 */
	public void validate_PopularSubCategoriesHasData_Shopper() {
		synchronized (Shopper_Logic.class) {
			try {
				boolean flag = false;
				selectFrame(Shopper_UI.frame_PopularSubCategories);
				waitForElementTobeLocated(Shopper_UI.chart_PopularSubCategories_Option);
				int districtNum = getElementsCount(Shopper_UI.chart_PopularSubCategories_Option);
				switchToDefaultContent();
				for (int i = 1; i <= districtNum; i++) {

					selectFrame(Shopper_UI.frame_PopularSubCategories);
					WebElement elm = driver
							.findElement(By.xpath("(//div[@id='sandbox-host']//*[@class='word'])[" + i + "]"));
					Actions action = new Actions(driver);
					action.moveToElement(elm).click().perform();
					waitForPageToLoad();
					snooze(3000);
					switchToDefaultContent();
					String label = getTextOf(Shopper_UI.chart_popupText);
					if (!label.equals("")) {
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
				e.printStackTrace();
			}
		}
	}

	/*
	 * Validate Chart has dual axis
	 */
	public void validate_ChartHasDualAxis() {
		synchronized (Shopper_Logic.class) {
			try {
				String x = getTextOf(Shopper_UI.xAxis_label);
				String y = getTextOf(Shopper_UI.yAxis_label);
				if (x.trim().equals(xAxis) && y.trim().equals(yAxis))
					extentTest.log(LogStatus.PASS, "Chart should have dual axis values",
							"Chart is having dual axis X - <B> " + x + " </B> & Y -<B> " + y + "</B> values");
				else
					extentTest.log(LogStatus.FAIL, "Chart should have dual axis values",
							"Chart is not having dual axis X -<B> " + x + " </B> & Y -<B> " + y + " </B> values");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/*
	 * Validate Table has row header
	 */
	public void validate_TableHasRowHeader() {
		synchronized (Shopper_Logic.class) {
			try {
				if (isDisplayed(Shopper_UI.span_AverageBasketValue) && isDisplayed(Shopper_UI.span_AverageBasketSize)
						&& isDisplayed(Shopper_UI.span_PercentofSales)
						&& isDisplayed(Shopper_UI.span_PercentTransactions)
						&& isDisplayed(Shopper_UI.span_FrequencyOfTransaction)
						&& isDisplayed(Shopper_UI.span_Discounts)) {
					extentTest.log(LogStatus.PASS, "Table should have Row header", "Table is having row header");
				} else {
					extentTest.log(LogStatus.FAIL, "Table should have Row header", "Table is not having row header");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/*
	 * Validate DoNut Charts exists
	 */
	public void validate_DoNutchartVisible() {
		synchronized (Shopper_Logic.class) {
			try {
				waitForElementTobeLocated(Shopper_UI.chart_DonutChart);
				int chartCount = getElementsCount(Shopper_UI.chart_DonutChart);
				if (chartCount > 0) {
					extentTest.log(LogStatus.PASS, "Donut Chart should be present", "Donut Chart is present");
				} else {
					extentTest.log(LogStatus.FAIL, "Donut Chart should be present", "Donut Chart is not present");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/*
	 * Validate View Demographic Profile
	 */
	public void validate_ViewDemogrpahicProfileIsActive() {
		synchronized (Shopper_Logic.class) {
			try {
//				waitForInvisibilityOfWebElement(Shopper_UI.span_WhatAreKeyDemographicMetricsEachShopperSegment);
				clickOn(Shopper_UI.btn_ViewDemographicProfile);
				waitForVisibleElement(Shopper_UI.span_WhatAreKeyDemographicMetricsEachShopperSegment);
				int chartCount = getElementsCount(Shopper_UI.span_WhatAreKeyDemographicMetricsEachShopperSegment);
				if (chartCount > 0) {
					extentTest.log(LogStatus.PASS,
							"Should be able to navigate to What Are Key Demographic Metrics Each Shopper Segment Chart",
							"Navigated to -  What Are Key Demographic Metrics Each Shopper Segment Chart");
				} else {
					extentTest.log(LogStatus.FAIL,
							"Should be able to navigate to What Are Key Demographic Metrics Each Shopper Segment Chart",
							"Not able to Navigate -  What Are Key Demographic Metrics Each Shopper Segment Chart");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/*
	 * Validate KPI Card Appears
	 */
	public void validate_KPICardAppears_Shopper() {
		synchronized (Shopper_Logic.class) {
			try {
				if (isDisplayed(Shopper_UI.card_AvgBasketSize) && isDisplayed(Shopper_UI.card_AvgBasketSize)
						&& isDisplayed(Shopper_UI.card_AvgBasketSize) && isDisplayed(Shopper_UI.card_AvgBasketSize))
					extentTest.log(LogStatus.PASS, "KPI Card should appear", "KPI Card is appearing");
				else
					extentTest.log(LogStatus.FAIL, "KPI Card should appear", "KPI Card is not appearing");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/*
	 * Validate Bar Chart Appears with data
	 */
	public void validate_BarChartHasData_Shopper() {
		synchronized (Shopper_Logic.class) {
			try {
				if (checkBarChartData(chartName))
					extentTest.log(LogStatus.PASS, "Chart should have data",
							"Chart - <B>" + chartName + "</B> is having data");
				else
					extentTest.log(LogStatus.FAIL, "Chart should have data",
							"Chart - <B>" + chartName + "</B> is not having data");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/*
	 * Validate Data Bar Appears with data
	 */
	public void validate_DataBarHasData_Shopper() {
		synchronized (Shopper_Logic.class) {
			try {
				if (checkDataBarData())
					extentTest.log(LogStatus.PASS, "Data Bar should have data", "Data Bar is having data");
				else
					extentTest.log(LogStatus.FAIL, "Data Bar should have data", "Data Bar is not having data");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/*
	 * Validate Line chart Appears with data
	 */
	public void validate_LineChartAppear_Shopper() {
		synchronized (Shopper_Logic.class) {
			try {
				if (checkLineChartData(chartName))
					extentTest.log(LogStatus.PASS, "Line Chart should appear",
							"Line Chart - <B>" + chartName + "</B> is appearing");
				else
					extentTest.log(LogStatus.FAIL, "Line Chart should appear",
							"Line Chart - <B>" + chartName + "</B> is not appearing");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/*
	 * Validate Tree chart Appears with data
	 */
	public void validate_TreeChartHasData_Shopper() {
		synchronized (Shopper_Logic.class) {
			try {
				if (checkTreeChartData(chartName))
					extentTest.log(LogStatus.PASS, "Chart should have data",
							"Chart - <B>" + chartName + "</B> is having data");
				else
					extentTest.log(LogStatus.FAIL, "Chart should have data",
							"Chart - <B>" + chartName + "</B> is having data");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/*
	 * Validate Chart measure units Appears
	 */
	public void validate_ChartMeasuringUnitsAppear_Shopper() {
		synchronized (Shopper_Logic.class) {
			try {
				if (checkChartShowsUnit(chartName, chartUnit))
					extentTest.log(LogStatus.PASS, "Chart should have unit data",
							"Chart - <B>" + chartName + "</B> is having <B>" + chartUnit + "</B> units");
				else
					extentTest.log(LogStatus.FAIL, "Chart should have unit data",
							"Chart - <B>" + chartName + "</B> is not having units");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/*
	 * Validate KPI Card Appears with Value
	 */
	public void validate_KPICardHasValue_Shopper() {
		synchronized (Shopper_Logic.class) {
			try {
				boolean flag = false;
				By cardElm = By.xpath("((//span[contains(text(),'" + cardName
						+ "')]//ancestor::div[contains(@class,'themableBorderColorSolid')])[3]//*[@class='value'])[1]");
//				System.out.println(getTextOf(cardElm));
				if (!(getTextOf(cardElm).equals("")))
					flag = true;
				if (flag)
					extentTest.log(LogStatus.PASS, "Chard should have Value",
							"Card - <B>" + cardName + "</B> is showing value <B>" + getTextOf(cardElm) + "</B>");
				else
					extentTest.log(LogStatus.FAIL, "Chard should have Value",
							"Card - <B>" + cardName + "</B> is not showing value");

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/*
	 * Validate KPI Card Appears with proper value color
	 */
	public void validate_KPICardPercentColor_Shopper() {
		synchronized (Shopper_Logic.class) {
			try {
				if (checkCardValueColor(cardName))
					extentTest.log(LogStatus.PASS, "Chard percentage should have proper color ",
							"Card - <B>" + cardName + "</B> is showing proper value color");
				else
					extentTest.log(LogStatus.FAIL, "Chard percentage should have proper color ",
							"Card - <B>" + cardName + "</B> is not showing proper value color");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/*
	 * Validate All KPI Chart Appears
	 */
	public void validate_KPIChartAppears_Shopper() {
		synchronized (Shopper_Logic.class) {
			try {
				if (checkKPIChartAppear(chartName))
					extentTest.log(LogStatus.PASS, "All KPI Chart should have Value", "KPI Chart is appearing");
				else
					extentTest.log(LogStatus.FAIL, "All KPI Chart should have Value", "KPI Chart is not appearing");

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/*
	 * Validate Time of Day Table Appears with data
	 */
	public void validate_TimeOfDayTableHasData_Shopper() {
		synchronized (Shopper_Logic.class) {
			try {
				if (getTableTimeOfDay())
					extentTest.log(LogStatus.PASS, "Table should have Value", "Table is having data");
				else
					extentTest.log(LogStatus.FAIL, "Table should have Value", "Table is not having data");

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/*
	 * Validate Table has data
	 */
	public void validate_TableHasData_Shopper() {
		synchronized (Shopper_Logic.class) {
			try {
				if (getTableContent())
					extentTest.log(LogStatus.PASS, "Table should have Value", "Table is having data");
				else
					extentTest.log(LogStatus.FAIL, "Table should have Value", "Table is not having data");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/*
	 * Validate Basket Analysis Insight Table Has Data
	 */
	public void validate_BasketAnalysisInsightTableHasData_Shopper() {
		synchronized (Shopper_Logic.class) {
			try {
				if (getBasketAnalysisTableContent())
					extentTest.log(LogStatus.PASS, "Table should have Value", "Table is having data");
				else
					extentTest.log(LogStatus.FAIL, "Table should have Value", "Table is not having data");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/*
	 * Validate Day Of Week Table Has Data
	 */
	public void validate_DayOfWeekTableHasData_Shopper() {
		synchronized (Shopper_Logic.class) {
			try {

				if (getTableDayOfWeek())
					extentTest.log(LogStatus.PASS, "Table should have Value", "Table is having data");
				else
					extentTest.log(LogStatus.FAIL, "Table should have Value", "Table is not having data");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/*
	 * Validate Time Of Day Table Has Header values
	 */
	public void validate_TimeOfDayTableHasHeader_Shopper() {
		synchronized (Shopper_Logic.class) {
			try {
				waitForElementTobeLocated(Shopper_UI.radio_TimeOfDay);
				actionClick(Shopper_UI.radio_TimeOfDay);
				waitForElementTobeLocated(Shopper_UI.table_SalesContribition);
				if (checkTableHasHeader_Shopper(weeks()))
					extentTest.log(LogStatus.PASS, "Table should have Value", "Table is having data");
				else
					extentTest.log(LogStatus.FAIL, "Table should have Value", "Table is not having data");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/*
	 * Validate Day Of Week Table Has Header values
	 */
	public void validate_DayOfWeekTableHasHeader_Shopper() {
		synchronized (Shopper_Logic.class) {
			try {
				waitForElementTobeLocated(Shopper_UI.radio_DayOfWeek);
				actionClick(Shopper_UI.radio_DayOfWeek);
				waitForElementTobeLocated(Shopper_UI.table_SalesContribition);
				if (checkTableHasHeader_Shopper(weeks()))
					extentTest.log(LogStatus.PASS, "Table should have Value", "Table is having data");
				else
					extentTest.log(LogStatus.FAIL, "Table should have Value", "Table is not having data");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/*
	 * Validate KPI Chart Y axis data
	 */
	public void validate_KPIChartYaxis_Shopper() {
		synchronized (Shopper_Logic.class) {
			try {
				if (getYaxisValue(chartName))
					extentTest.log(LogStatus.PASS, "Chart should have proper Y axis", "Chart is having proper Y axis");
				else
					extentTest.log(LogStatus.FAIL, "Chart should have proper Y axis",
							"Chart is not having proper Y axis");

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/*
	 * Navigate to Card Avg. Basket Value
	 */
	public void goto_Card_AvgBasketValue_Shopper() {
		synchronized (Shopper_Logic.class) {
			try {
				actionClick(Shopper_UI.card_AvgBasketValue);
				waitForPageToLoad();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/*
	 * Navigate to Card Avg. Basket Size
	 */
	public void goto_Card_AvgBasketSize_Shopper() {
		synchronized (Shopper_Logic.class) {
			try {
				actionClick(Shopper_UI.card_AvgBasketSize);
				waitForPageToLoad();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/*
	 * Navigate to Card Customer
	 * 
	 */
	public void goto_Card_Customer_Shopper() {
		synchronized (Shopper_Logic.class) {
			try {
				actionClick(Shopper_UI.card_Customers);
				waitForPageToLoad();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/*
	 * Validate KPI Card Discounts
	 */
	public void goto_Card_Discount_Shopper() {
		synchronized (Shopper_Logic.class) {
			try {
				actionClick(Shopper_UI.card_Discounts);
				waitForPageToLoad();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/*
	 * Validate Filter has months
	 */
	public void validate_FilterHasMonths_Shopper() {
		synchronized (Shopper_Logic.class) {
			try {
				if (checkFilterHasMonth_Shopper(months()))
					extentTest.log(LogStatus.PASS, "Filter should have Month & Date", "Filter is having Month & Date");
				else
					extentTest.log(LogStatus.FAIL, "Filter should have Month & Date",
							"Filter is not having Month & Date");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/*
	 * Validate Avg. Basket Value has proper Color
	 */
	public void validate_AvgBasketValueColor_Suppplier() {
		synchronized (Shopper_Logic.class) {
			try {
				checkPercentColor(Shopper_UI.card_AvgBasketValue_Percent, Shopper_UI.card_AvgBasketValue_Color);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/*
	 * Validate Avg. Basket Size has proper Color
	 */
	public void validate_AvgBasketSizeColor_Suppplier() {
		synchronized (Shopper_Logic.class) {
			try {
				checkPercentColor(Shopper_UI.card_AvgBasketSize_Percent, Shopper_UI.card_AvgBasketSize_Color);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/*
	 * Validate Customers Color has proper Color
	 */
	public void validate_CustomersColor_Suppplier() {
		synchronized (Shopper_Logic.class) {
			try {
				checkPercentColor(Shopper_UI.card_CustomersValue_Percent, Shopper_UI.card_CustomersValue_Color);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/*
	 * Validate Discount has proper Color
	 */
	public void validate_DiscountColor_Suppplier() {
		synchronized (Shopper_Logic.class) {
			try {
				checkPercentColor(Shopper_UI.card_DiscountsValue_Percent, Shopper_UI.card_DiscountsValue_Color);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/*
	 * Validate My Basket Bar Chart Has Data
	 */
	public void validate_MyBasketBarChartHasData_Shopper() {
		synchronized (Shopper_Logic.class) {
			try {
				boolean flag = false;
				By chartElm = By.xpath("//*[contains(text(),'" + chartName
						+ "')]//ancestor::div[@class='vcGroupBody themableBackgroundColor themableBorderColorSolid']//*[@class='series']//*");
				for (int i = 1; i <= getElementsCount(chartElm); i++) {
					By bar = By.xpath("(//*[contains(text(),'" + chartName
							+ "')]//ancestor::div[@class='vcGroupBody themableBackgroundColor themableBorderColorSolid']//*[@class='series']//*)["
							+ i + "]");
					if (!(getAttributeValueOf(bar, "aria-label").equals("null"))) {
						actionClick(bar);
						waitForPageToLoad();
						snooze(3000);
						String label = getTextOf(Shopper_UI.chart_popupText);
						if (!(label.equals("") || label.contains("Report Zoomed")))
							flag = true;
					} else {
						actionClick(By.xpath("(//*[contains(text(),'" + chartName
								+ "')]//ancestor::div[@class='vcGroupBody themableBackgroundColor themableBorderColorSolid'])[2]//*[@cursor='crosshair']"));
//						int move = 30;
//						while ((state)) {
//							By cursor = By.xpath("(//*[contains(text(),'" + chart
//									+ "')]//ancestor::div[@class='vcGroupBody themableBackgroundColor themableBorderColorSolid'])[2]//*[@class='selection']");
//							WebElement pointer = driver.findElement(cursor);
//							JavascriptExecutor js = (JavascriptExecutor) driver;
//							js.executeScript("arguments[0].setAttribute('x','" + move + "')", pointer);
//							move = move + 30;
//						}
//						actionClick(By.xpath("(//*[contains(text(),'" + chartName
//								+ "')]//ancestor::div[@class='vcGroupBody themableBackgroundColor themableBorderColorSolid'])[2]//*[@cursor='crosshair']"));

//						int move = 30;
//						do{			
//							WebElement pointer = driver.findElement(By.xpath("(//*[contains(text(),'" + chart+ "')]//ancestor::div[@class='vcGroupBody themableBackgroundColor themableBorderColorSolid'])[2]"));
//							
////							WebElement pointer = driver.findElement(By.xpath("(//*[contains(text(),'" + chart+ "')]//ancestor::div[@class='vcGroupBody themableBackgroundColor themableBorderColorSolid'])[2]//*[@class='selection']"));
//							
//							EventFiringWebDriver event = new EventFiringWebDriver(driver);
//							event.executeScript("document.querySelector('(//*[contains(text(),'" + chart+ "')]//ancestor::div[@class=\"vcGroupBody themableBackgroundColor themableBorderColorSolid\"])[2]//*[@class=\"selection\"]').scrolltop=200");
//							
//							
////							JavascriptExecutor js = (JavascriptExecutor) driver;
////							js.executeScript("arguments[0].setAttribute('x','"+move+"')", pointer);
////							move = move + 30;	
//						}while (state) ;
					}
				}
				if (flag)
					extentTest.log(LogStatus.PASS, "Chart should have data",
							"Chart - <B>" + chartName + "</B> is having data");
				else
					extentTest.log(LogStatus.FAIL, "Chart should have data",
							"Chart - <B>" + chartName + "</B> is not having data");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Validate X Axis Has Date
	 * 
	 **/
//	public void validate_XAxisHasDate_Shopper() {
//		synchronized (RPCC_Demand_Logic.class) {
//			boolean flag = false;
//			try {
//				By chart = By.xpath("//div[text()='" + chartName
//						+ "']//ancestor::div[@class='vcGroupBody themableBackgroundColor themableBorderColorSolid']//*[@class='x axis hideLinesOnAxis setFocusRing']//*[@class='setFocusRing']");
//				waitForElementTobeLocated(chart);
//				int size = getElementsCount(chart);
//				for (int i = 1; i <= size; i++) {
//					By elm = By.xpath("(//div[text()='" + chartName
//							+ "']//ancestor::div[@class='vcGroupBody themableBackgroundColor themableBorderColorSolid']//*[@class='x axis hideLinesOnAxis setFocusRing']//*[@class='setFocusRing'])["
//							+ i + "]");
//					String date = getTextOf(elm).trim();
//					if (date.equals("")) {
//						flag = false;
//					} else {
////						validateDate("dd,MM,yyyy",date);
//
//					}
//					// SimpleDateFormat sdfrmt = new SimpleDateFormat("dd/MM/yyyy");
////						sdfrmt.setLenient(false);
////						Date javaDate = sdfrmt.parse(date);
////						flag = true;
//
//				}
//				if (flag)
//					extentTest.log(LogStatus.PASS, "Date format validation", "Date is in - <B> DD/MM/YYYY </B> format");
//				else
//					extentTest.log(LogStatus.FAIL, "Date format validation",
//							"Date is not in - <B> DD/MM/YYYY </B> format");
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//	}

	/*
	 * Validate X Axis Has Date
	 */
	public void validate_XAxisHasDate_Shopper() {
		synchronized (RPCC_Demand_Logic.class) {
			boolean flag = false;
			try {
				By chart = By.xpath("//div[text()='" + chartName
						+ "']//ancestor::div[@class='vcGroupBody themableBackgroundColor themableBorderColorSolid']//*[@class='x axis hideLinesOnAxis setFocusRing']//*[@class='setFocusRing']");
				waitForElementTobeLocated(chart);
				int size = getElementsCount(chart);
				for (int i = 1; i <= size; i++) {
					By elm = By.xpath("(//div[text()='" + chartName
							+ "']//ancestor::div[@class='vcGroupBody themableBackgroundColor themableBorderColorSolid']//*[@class='x axis hideLinesOnAxis setFocusRing']//*[@class='setFocusRing'])["
							+ i + "]");
					String date = getTextOf(elm).trim();
					if (date.equals("")) {
						flag = false;
					} else {
//				validateDate("dd,MM,yyyy",date);
					}
					// SimpleDateFormat sdfrmt = new SimpleDateFormat("dd/MM/yyyy");
//				sdfrmt.setLenient(false);
//				Date javaDate = sdfrmt.parse(date);
//				flag = true;

				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/*************************************************
	 * Private methods section
	 *********************************************/

	/*
	 * Private method used in - validate_ChartMeasuringUnitsAppear_Shopper
	 */
	private boolean checkChartShowsUnit(String chart, String measureUnit) {
		try {
			boolean flag = false;
			chart = chart.trim();
			String[] units = measureUnit.split("\\|");
			List<String> unitsList = Arrays.asList(units);
			for (int i = 0; i < unitsList.size(); i++) {
				String unit = unitsList.get(i).trim();
				By elm = By.xpath("(//*[contains(text(),'" + chart
						+ "')]//ancestor::div[contains(@class,'themableBorderColorSolid')])[2]//*[@title='" + unit
						+ "']");
				if (isDisplayed(elm))
					flag = true;
			}
			return flag;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	/*
	 * Private method used in - validate_ChartMeasuringUnitsAppear_Shopper
	 */
	private boolean checkKPIChartAppear(String allChart) {
		boolean flag = false;
		String[] chart = allChart.split("\\|");
		List<String> unitsList = Arrays.asList(chart);
		for (int i = 0; i < unitsList.size(); i++) {
			String label = unitsList.get(i).trim();
			label = label.trim();
			if (label.equals(""))
				return false;
			By chartElm = By.xpath("//*[contains(text(),'" + label + "')]");
			if (isDisplayed(chartElm))
				flag = true;
		}
		return flag;
	}

	/*
	 * Private method used in - validate_ChartMeasuringUnitsAppear_Shopper
	 */
	private boolean getYaxisValue(String chart) {
		boolean flag = false;
		By elm = By.xpath("(//*[contains(text(),'" + chart
				+ "')]//ancestor::div[@class='vcGroupBody themableBackgroundColor themableBorderColorSolid'])[2]//*[@class='yAxisLabel sub-selectable']");
		if (getTextOf(elm).equals(yAxis))
			flag = true;
		return flag;
	}

	/*
	 * Private method used in - validate_ChartMeasuringUnitsAppear_Shopper
	 */
	private boolean checkCardValueColor(String card) {
		boolean flag = false;
		By percentVal = By.xpath("((//span[contains(text(),'" + card
				+ "')]//ancestor::div[contains(@class,'themableBorderColorSolid')])[3]//*[@class='value'])[2]//*");
		String value = getTextOf(percentVal);
		By percent = By.xpath("((//span[contains(text(),'" + card
				+ "')]//ancestor::div[contains(@class,'themableBorderColorSolid')])[3]//*[@class='value'])[2]");
		String color = getAttributeValueOf(percent, "style");
		if (value.contains("%") && color.contains("(0, 171, 83)"))
			flag = true;
		else if (value.contains("-") && value.contains("%") && color.contains("(242, 67, 67)"))
			flag = true;
		else
			flag = false;
		return flag;

	}

	/*
	 * Private method used in - validate_ChartMeasuringUnitsAppear_Shopper
	 */
	private boolean checkBarChartData(String chart) {
		try {
			boolean flag = false;
			By chartElm = By.xpath("(//*[contains(text(),'" + chart
					+ "')]//ancestor::div[@class='vcGroupBody themableBackgroundColor themableBorderColorSolid'])[2]//*[@class='series']//*");
			for (int i = 1; i <= getElementsCount(chartElm); i++) {
				By bar = By.xpath("((//*[contains(text(),'" + chart
						+ "')]//ancestor::div[@class='vcGroupBody themableBackgroundColor themableBorderColorSolid'])[2]//*[@class='series']//*)["
						+ i + "]");
				if (!(getAttributeValueOf(bar, "aria-label").equals("null"))) {
					actionClick(bar);
					waitForPageToLoad();
					snooze(3000);
					String label = getTextOf(Shopper_UI.chart_popupText);
					if (!(label.equals("") || label.contains("Report Zoomed")))
						flag = true;
				} else {
					actionClick(By.xpath("(//*[contains(text(),'" + chart
							+ "')]//ancestor::div[@class='vcGroupBody themableBackgroundColor themableBorderColorSolid'])[2]//*[@cursor='crosshair']"));
//					int move = 30;
//					while ((state)) {
//						By cursor = By.xpath("(//*[contains(text(),'" + chart
//								+ "')]//ancestor::div[@class='vcGroupBody themableBackgroundColor themableBorderColorSolid'])[2]//*[@class='selection']");
//						WebElement pointer = driver.findElement(cursor);
//						JavascriptExecutor js = (JavascriptExecutor) driver;
//						js.executeScript("arguments[0].setAttribute('x','" + move + "')", pointer);
//						move = move + 30;
//					}
//					actionClick(By.xpath("(//*[contains(text(),'" + chartName
//							+ "')]//ancestor::div[@class='vcGroupBody themableBackgroundColor themableBorderColorSolid'])[2]//*[@cursor='crosshair']"));

//					int move = 30;
//					do{			
//						WebElement pointer = driver.findElement(By.xpath("(//*[contains(text(),'" + chart+ "')]//ancestor::div[@class='vcGroupBody themableBackgroundColor themableBorderColorSolid'])[2]"));
//						
////						WebElement pointer = driver.findElement(By.xpath("(//*[contains(text(),'" + chart+ "')]//ancestor::div[@class='vcGroupBody themableBackgroundColor themableBorderColorSolid'])[2]//*[@class='selection']"));
//						
//						EventFiringWebDriver event = new EventFiringWebDriver(driver);
//						event.executeScript("document.querySelector('(//*[contains(text(),'" + chart+ "')]//ancestor::div[@class=\"vcGroupBody themableBackgroundColor themableBorderColorSolid\"])[2]//*[@class=\"selection\"]').scrolltop=200");
//						
//						
////						JavascriptExecutor js = (JavascriptExecutor) driver;
////						js.executeScript("arguments[0].setAttribute('x','"+move+"')", pointer);
////						move = move + 30;	
//					}while (state) ;
				}
			}
			return flag;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	/*
	 * Private method used in - validate_DataBarHasData_Shopper
	 */
	private boolean checkDataBarData() {
		try {
			boolean flag = false;
			int dataBarCount = getElementsCount(Shopper_UI.chart_DataBar);
			for (int i = 2; i <= dataBarCount; i++) {
				By bar = By.xpath("(//*[@class='dataBar'])[" + i + "]");
				actionClick(bar);
				String label = getTextOf(Shopper_UI.chart_popupText);
				if (!label.equals("") && !label.contains("Report Zoomed"))
					flag = true;
			}
			return flag;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	/*
	 * Private method used in - validate_LineChartAppear_Shopper
	 */
	private boolean checkLineChartData(String chart) {
		try {
			boolean flag = false;
			By chartElm = By.xpath("(//*[contains(text(),'" + chart
					+ "')]//ancestor::div[contains(@class,'themableBorderColorSolid')])[2]//*[@role='listbox']");
			if ((isDisplayed(chartElm)))
				flag = true;
			return flag;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	/*
	 * Private method used in - validate_ChartMeasuringUnitsAppear_Shopper
	 */
	private boolean getTableTimeOfDay() {
		boolean flag = false;
		int emptCell = 0;
		int dataCell = 0;
		try {
			isDisplayed(Shopper_UI.radio_TimeOfDay);
			actionClick(Shopper_UI.radio_TimeOfDay);
			waitForElementTobeLocated(Shopper_UI.table_SalesContribition);
			isDisplayed(Shopper_UI.table_SalesContribition);
			int rows = getElementsCount(Shopper_UI.table_SalesContribition);
			for (int i = 1; i <= rows; i++) {
				By cell = By
						.xpath("(//div[@class='bodyCells']//div[contains(@class,'pivotTableCellWrap')])[" + i + "]");
				if (getTextOf(cell).contains("%")) {
					dataCell = dataCell + 1;
					flag = true;
				} else {
					emptCell = emptCell + 1;
					flag = true;
				}
			}
			extentTest.log(LogStatus.INFO, "Table Has Total cells - <B>[" + rows + "]</B>", "Number of DATA cell - <B>["
					+ dataCell + "]</B>, Number of EMPTY cell - <B>[" + emptCell + "]</B>");
		} catch (NoSuchElementException e) {
			return false;
		}

		return flag;
	}

	/*
	 * Private method used in - validate_ChartMeasuringUnitsAppear_Shopper
	 */
	private boolean getTableContent() {
		boolean flag = false;
		int emptCell = 0;
		int dataCell = 0;
		try {
			waitForElementTobeLocated(Shopper_UI.table_SalesContribition);
			isDisplayed(Shopper_UI.table_SalesContribition);
			int rows = getElementsCount(Shopper_UI.table_SalesContribition);
			for (int i = 1; i <= rows; i++) {
				By cell = By
						.xpath("(//div[@class='bodyCells']//div[contains(@class,'pivotTableCellWrap')])[" + i + "]");
				if (!getTextOf(cell).equals(" ")) {
					dataCell = dataCell + 1;
					flag = true;
				} else {
					emptCell = emptCell + 1;
					flag = true;
				}
			}
			extentTest.log(LogStatus.INFO, "Table Has Total cells - <B>[" + rows + "]</B>", "Number of DATA cell - <B>["
					+ dataCell + "]</B>, Number of EMPTY cell - <B>[" + emptCell + "]</B>");
		} catch (NoSuchElementException e) {
			return false;
		}
		return flag;
	}

	/*
	 * Private method used in - validate_ChartMeasuringUnitsAppear_Shopper
	 */
	private boolean getBasketAnalysisTableContent() {
		boolean flag = false;
		int emptCell = 0;
		int dataCell = 0;
		try {
			waitForElementTobeLocated(Shopper_UI.table_BasketAnalysis);
			isDisplayed(Shopper_UI.table_BasketAnalysis);
			int rows = getElementsCount(Shopper_UI.table_BasketAnalysis);
			for (int i = 1; i <= rows; i++) {
				By cell = By.xpath(
						"(//div[contains(@class,'pivotTableCellWrap cell-interactive tablixAlignRight')])[" + i + "]");
				if (!getTextOf(cell).equals(" ")) {
					dataCell = dataCell + 1;
					flag = true;
				} else {
					emptCell = emptCell + 1;
					flag = true;
				}
			}
			extentTest.log(LogStatus.INFO, "Table Has Total cells - <B>[" + rows + "]</B>", "Number of DATA cell - <B>["
					+ dataCell + "]</B>, Number of EMPTY cell - <B>[" + emptCell + "]</B>");
		} catch (NoSuchElementException e) {
			return false;
		}
		return flag;
	}

	/*
	 * Private method used in - validate_ChartMeasuringUnitsAppear_Shopper
	 */
	private boolean getTableDayOfWeek() {
		boolean flag = false;
		int emptCell = 0;
		int dataCell = 0;
		try {
			isDisplayed(Shopper_UI.radio_DayOfWeek);
			actionClick(Shopper_UI.radio_DayOfWeek);
			waitForElementTobeLocated(Shopper_UI.table_SalesContribition);
			isDisplayed(Shopper_UI.table_SalesContribition);
			int rows = getElementsCount(Shopper_UI.table_SalesContribition);
			for (int i = 1; i <= rows; i++) {
				By cell = By
						.xpath("(//div[@class='bodyCells']//div[contains(@class,'pivotTableCellWrap')])[" + i + "]");
				if (getTextOf(cell).contains("%")) {
					dataCell = dataCell + 1;
					flag = true;
				} else {
					emptCell = emptCell + 1;
					flag = true;
				}
			}
			extentTest.log(LogStatus.INFO, "Table Has Total cells - <B>[" + rows + "]</B>", "Number of DATA cell - <B>["
					+ dataCell + "]</B>, Number of EMPTY cell - <B>[" + emptCell + "]</B>");
		} catch (NoSuchElementException e) {
			return false;
		}
		return flag;
	}

	/*
	 * Private method used in - validate_ChartMeasuringUnitsAppear_Shopper
	 */
	private boolean checkTreeChartData(String chart) {
		try {
			boolean flag = false;
			By chartElm = By.xpath("(//*[contains(text(),'" + chart
					+ "')]//ancestor::div[contains(@class,'themableBorderColorSolid')])[2]//*[@role='treeitem']");
			for (int i = 1; i <= getElementsCount(chartElm); i++) {
				By tree = By.xpath("((//*[contains(text(),'" + chart
						+ "')]//ancestor::div[contains(@class,'themableBorderColorSolid')])[2]//*[@role='treeitem'])["
						+ i + "]");
				actionClick(tree);
				waitForPageToLoad();
				snooze(3000);
				String label = getTextOf(Shopper_UI.chart_popupText);
				if (!label.equals(""))
					flag = true;
			}
			return flag;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	/*
	 * Private method used in - validate_ChartMeasuringUnitsAppear_Shopper
	 */
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
	 * Private method used in - validate_ChartMeasuringUnitsAppear_Shopper
	 */
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

	/*
	 * Private method used in - validate_ChartMeasuringUnitsAppear_Shopper
	 */
	private boolean isMultiSelectActive_Shopper() {
		boolean flag;
		waitForPageToLoad();
		try {
			By selectAll = By.xpath("//div[@role='listbox' and @aria-label='" + filterName
					+ "']//ancestor::div[@class='slicer-dropdown-content']//*[text()='Select all']//ancestor::div[contains(@class,'slicerItemContainer')]");
			String state = getAttributeValueOf(selectAll, "aria-checked");
			if (state.trim().equals("true")) {
				By optCount = By
						.xpath("//div[@role='listbox' and @aria-label='" + filterName + "']//div[@class='row']");
				int rows = getElementsCount(optCount);
				for (int i = 1; i <= rows; i++) {
					String rowState = driver.findElement(By.xpath(
							"(//input[@aria-label='Search']//ancestor::div[@class='slicer-dropdown-content']//div[@class='slicerBody']//div[@class='row'])["
									+ i
									+ "]//span[@class='slicerText']//ancestor::div[contains(@class,'slicerItemContainer')]"))
							.getAttribute("aria-checked");
					if (rowState.trim().equals("true")) {
						flag = true;
					}
				}
				return true;
			} else if (state.trim().equals("false")) {
				clickOn(selectAll);
				waitForPageToLoad();
				By selectAll2 = By.xpath("//div[@role='listbox' and @aria-label='" + filterName
						+ "']//ancestor::div[@class='slicer-dropdown-content']//*[text()='Select all']//ancestor::div[contains(@class,'slicerItemContainer')]");
				String state2 = getAttributeValueOf(selectAll2, "aria-checked");
				if (state2.trim().equals("true")) {
					By optCount = By
							.xpath("//div[@role='listbox' and @aria-label='" + filterName + "']//div[@class='row']");
					int rows = getElementsCount(optCount);
					for (int i = 1; i <= rows; i++) {
						String rowState = driver.findElement(By.xpath(
								"(//input[@aria-label='Search']//ancestor::div[@class='slicer-dropdown-content']//div[@class='slicerBody']//div[@class='row'])["
										+ i
										+ "]//span[@class='slicerText']//ancestor::div[contains(@class,'slicerItemContainer')]"))
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

	/*
	 * Private method used in - validate_ChartMeasuringUnitsAppear_Shopper
	 */
	private boolean checkTableHasHeader_Shopper(ArrayList<String> weekArrayList) {
		boolean flag = false;
		try {
			int rows = getElementsCount(Shopper_UI.span_TimeOfDayColumn);
			for (int i = 1; i <= rows; i++) {
				By header = By.xpath(
						"((//div[@class='innerContainer'])[1]//div[@class='columnHeaders']//div[contains(@class,'pivotTableCellWrap')])["
								+ i + "]");
				String head = getAttributeValueOf(header, "title");
				if (weekArrayList.contains(head)) {
					flag = true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	/*
	 * Private method used in - validate_ChartMeasuringUnitsAppear_Shopper
	 */
	private boolean checkFilterHasMonth_Shopper(ArrayList<String> monthList) {
		boolean flag = false;
		try {
			By optCount = By.xpath("//div[@role='listbox' and @aria-label='" + filterName + "']//div[@class='row']");
			int rowCount = getElementsCount(optCount);
			for (int i = 1; i <= rowCount; i++) {
				By row = By.xpath("(//div[@role='listbox' and @aria-label='" + filterName
						+ "']//span[@class='slicerText'])[" + i + "]");
				String monthYear = getAttributeValueOf(row, "title");
				String[] month = monthYear.split(" ");
				if (monthList.contains(month[1].substring(1, 4))) {
					flag = true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	/*
	 * Private method used in - validate_ChartMeasuringUnitsAppear_Shopper
	 */
	private boolean checkPercentColor(By percen, By color) {
		synchronized (Shopper_Logic.class) {
			try {
				String percentage = getTextOf(percen);
				String perColor = getAttributeValueOf(color, "style");
				if (!percentage.trim().contains("-") && perColor.trim().contains("171")) {
					extentTest.log(LogStatus.PASS, "Positive percentage value should be in GREEN",
							"Positive percentage value is in GREEN");
					return true;
				} else if (percentage.trim().contains("-") && perColor.trim().contains("242")) {
					extentTest.log(LogStatus.PASS, "Negitive percentage value should be in RED",
							"Negitive percentage value is in RED");
					return true;
				} else {
					extentTest.log(LogStatus.FAIL, "Failed to Identify Percentage with color");
					return false;
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	
	/*
	 * Private method used in - validate_ChartMeasuringUnitsAppear_Shopper
	 */
	private boolean validateDate(String format, String date) {
		/* Check if date is 'null' */
		if (date.trim().equals("")) {
			return true;
		}
		/* Date is not 'null' */
		else {
			/*
			 * Set preferred date format, For example MM-dd-yyyy, MM.dd.yyyy,dd.MM.yyyy etc.
			 */
			SimpleDateFormat sdfrmt = new SimpleDateFormat(format);
			sdfrmt.setLenient(false);
			/*
			 * Create Date object parse the string into date
			 */
			try {
				Date javaDate = sdfrmt.parse(date);
//				System.out.println(date + " is valid date format");
			}
			/* Date format is invalid */
			catch (ParseException e) {
//				System.out.println(date + " is Invalid Date format");
				return false;
			}
			/* Return true if date format is valid */
			return true;
		}
	}

}