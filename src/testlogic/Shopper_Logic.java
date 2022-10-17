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
import uimaps.Supplier_UI;

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
	

	public void goto_Tab_MarketBasketAnalysis_Shopper() {
		synchronized (Shopper_Logic.class) {
			try {
				waitForElementTobeClickable(Shopper_UI.tab_MarketBasketAnalysis);
				clickOn(Shopper_UI.tab_MarketBasketAnalysis);
			} catch (Exception e) {
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

	public void validate_DropDownHasData_Shopper() {
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void validate_DropDownHasSearchOption_Shopper() {
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

	public void validate_ChartTopDistributionHasData_Shopper() {
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
					System.out.println(label);
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

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

	public void validate_BarChartHasData_Shopper() {
		synchronized (Shopper_Logic.class) {
			try {
				if (checkBarChartData(chartName))
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

	public void validate_ChartMeausingUnitsAppear_Shopper() {
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

	public void validate_KPICardHasValue_Shopper() {
		synchronized (Shopper_Logic.class) {
			try {
				boolean flag = false;
				By cardElm = By.xpath("((//span[contains(text(),'" + cardName
						+ "')]//ancestor::div[contains(@class,'themableBorderColorSolid')])[3]//*[@class='value'])[1]");
				System.out.println(getTextOf(cardElm));
				if (!(getTextOf(cardElm).equals("")))
					flag = true;
				else
					flag = false;

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

	public void validate_KPIChartYaxis_Shopper() {
		synchronized (Shopper_Logic.class) {
			try {
				if (getYaxisValue(chartName))
					extentTest.log(LogStatus.PASS, "Chart should have proper Y axis", "Chart is having proper Y axis");
				else
					extentTest.log(LogStatus.FAIL, "Chart should have proper Y axis", "Chart is having proper Y axis");

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/*
	 * KPI Card
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
	 * Private methods section
	 */

	private boolean checkChartShowsUnit(String chart, String measureUnit) {
		try {
			boolean flag = false;
			chart = chart.trim();
			String[] units = chartUnit.split("\\|");
			List<String> unitsList = Arrays.asList(units);
			for (int i = 0; i < unitsList.size(); i++) {
				String unit = unitsList.get(i).trim();
				By elm = By.xpath("(//*[contains(text(),'" + chart
						+ "')]//ancestor::div[contains(@class,'themableBorderColorSolid')])[2]//*[@title='" + unit
						+ "']");
				if (isDisplayed(elm))
					flag = true;
				else
					flag = false;
			}
			return flag;
		} catch (NoSuchElementException nsex) {
			return false;
		}
	}

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
			else
				flag = false;
		}
		return flag;
	}

	private boolean getYaxisValue(String chart) {
		boolean flag = false;
		By elm = By.xpath("(//*[contains(text(),'" + chart
				+ "')]//ancestor::div[@class='vcGroupBody themableBackgroundColor themableBorderColorSolid'])[2]//*[@class='yAxisLabel sub-selectable']");
		if (getTextOf(elm).equals(yAxis))
			flag = true;
		else
			flag = false;
		return flag;
	}

	private boolean checkCardValueColor(String card) {
		boolean flag = false;
		By percentVal = By.xpath("((//span[contains(text(),'" + card
				+ "')]//ancestor::div[contains(@class,'themableBorderColorSolid')])[3]//*[@class='value'])[2]//*");
		String value = getTextOf(percentVal);
		By percent = By.xpath("((//span[contains(text(),'" + card
				+ "')]//ancestor::div[contains(@class,'themableBorderColorSolid')])[3]//*[@class='value'])[2]");
		String color = getAttributeValueOf(percent, "style");
		if (!value.contains("-") && value.contains("%") && color.contains("(0, 171, 83)"))
			flag = true;
		else if (value.contains("-") && value.contains("%") && color.contains("(242, 67, 67)"))
			flag = true;
		else
			flag = false;
		return flag;

	}

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
					if (!label.equals(""))
						flag = true;
					else
						flag = false;
				} else {
					actionClick(By.xpath("(//*[@cursor='crosshair'])[1]"));
				}
			}
			return flag;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	private boolean checkLineChartData(String chart) {
		try {
			boolean flag = false;
			By chartElm = By.xpath("(//*[contains(text(),'" + chart
					+ "')]//ancestor::div[contains(@class,'themableBorderColorSolid')])[2]//*[@role='listbox']");
			if ((isDisplayed(chartElm)))
				flag = true;
			else
				flag = false;
			return flag;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	private boolean getTableTimeOfDay() {
		boolean flag = false;
		int emptCell = 0;
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
					flag = true;
				}else {
					emptCell = emptCell + 1;
					flag = true;
				}
			}
			extentTest.log(LogStatus.INFO, "Number of empty cells",
					"Number of empty cells in table - <B>[" + emptCell + "]</B>");
		} catch (NoSuchElementException e) {
			return false;
		}
		
		return flag;
	}

	private boolean getTableDayOfWeek() {
		boolean flag = false;
		int emptCell = 0;
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
					flag = true;
				}else {
					emptCell = emptCell + 1;
					flag = true;
				}
			}
			extentTest.log(LogStatus.INFO, "Number of empty cells",
					"Number of empty cells in table - <B>[" + emptCell + "]</B>");
		} catch (NoSuchElementException e) {
			return false;
		}
		
		return flag;
	}

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
				else
					flag = false;
			}
			return flag;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	private boolean checkDropDownHasData_Shopper() {
		try {
			if (getFilterDropDownRowCount_Shopper() > 0)
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
	
	private boolean checkTableHasHeader_Shopper(ArrayList<String> weekArrayList) {
		boolean flag = false;
		try {			
			System.out.println(weekArrayList);
			int rows = getElementsCount(Shopper_UI.span_TimeOfDayColumn);
			for (int i = 1; i <= rows; i++) {
				By header = By.xpath("((//div[@class='innerContainer'])[1]//div[@class='columnHeaders']//div[contains(@class,'pivotTableCellWrap')])[" + i + "]");
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

}