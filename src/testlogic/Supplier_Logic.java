package testlogic;

import java.util.ArrayList;
import java.util.Arrays;
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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.LogStatus;
import com.thoughtworks.selenium.webdriven.commands.IsVisible;

import frameworkutils.DataBook;
import frameworkutils.WebDriverFactory;
import uimaps.APPM_UI;
import uimaps.Supplier_UI;

public class Supplier_Logic extends WebDriverFactory {

	public Supplier_Logic(WebDriver driver, Map<String, String> dataBook) {
		super(driver, dataBook);
	}

	String url = dataBook.get("Url");
	String email = dataBook.get("Email");
	String pwd = dataBook.get("Password");
	String filterName = dataBook.get("Fliter_Name");
	String filterOption = dataBook.get("Filter_Option");
	String chartName = dataBook.get("Chart_Name");
	String summaryHeader = dataBook.get("Column_Header");
	String detailHeader = dataBook.get("DetailedViewColumn_Header");

	public static ArrayList<String> months() {
		ArrayList<String> monthList = new ArrayList<String>();
		monthList.add("January");
		monthList.add("February");
		monthList.add("March");
		monthList.add("April");
		monthList.add("May");
		monthList.add("June");
		monthList.add("July");
		monthList.add("August");
		monthList.add("September");
		monthList.add("October");
		monthList.add("November");
		monthList.add("December");
		return monthList;
	}

	public static ArrayList<String> short_months(ArrayList<String> monthList) {
		ArrayList<String> shortMonthList = new ArrayList<String>();
		for (int i = 0; i < monthList.size(); i++) {
			System.out.println(monthList.get(i).substring(0, 3));
			shortMonthList.add(monthList.get(i).substring(0, 3));
		}
		return shortMonthList;
	}

	public void validateChartXAxisForMonthsYears_Supplier_Suppplier() {
		synchronized (Supplier_Logic.class) {
			try {
				if (checkChartXAxisForMonthsYears_Supplier(short_months(months()), short_Years(years())))
					extentTest.log(LogStatus.PASS, "Chart X axis should have Months and Years",
							"Chart X axis is having Months and Years");
				else
					extentTest.log(LogStatus.FAIL, "Chart X axis should have Months and Years",
							"Chart X axis is not having Months and Years");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static ArrayList<String> years() {
		ArrayList<String> yearList = new ArrayList<String>();
		for (int i = 2000; i <= 2030; i++) {
			yearList.add(Integer.toString(i));
		}
		return yearList;
	}

	public static ArrayList<String> short_Years(ArrayList<String> yearList) {
		ArrayList<String> shortYearList = new ArrayList<String>();
		for (int i = 0; i < yearList.size(); i++) {
			System.out.println(yearList.get(i).substring(2));
			shortYearList.add(yearList.get(i).substring(2));
		}
		return shortYearList;
	}

	public void testingMonthsYears_Suppplier() {
		synchronized (Supplier_Logic.class) {
			try {
				if (checkDropDownForMonthsYears_Supplier(months(), years()))
					extentTest.log(LogStatus.PASS, "Drop Down should have Months and Years",
							"Drop Down is having Months and Years");
				else
					extentTest.log(LogStatus.FAIL, "Drop Down should have Months and Years",
							"Drop Down is not having Months and Years");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private boolean checkChartXAxisForMonthsYears_Supplier(ArrayList<String> shortMonthList,
			ArrayList<String> shortYearList) {
		try {
			boolean flag = false;
			WebDriverWait wait = new WebDriverWait(driver, 1200);
			int rows = getXAxisDataCount_Supplier();
			for (int i = 1; i <= rows; i++) {
				String str = driver.findElement(By.xpath(
						"(//*[@class='axisGraphicsContext scatterChart playChart']//*[@data-automation-type='axis-tick-text'])["
								+ i + "]"))
						.getText();
				String[] monthYear = str.split("'");
				String month = monthYear[0].trim();
				String year = monthYear[1].trim();
				if (shortMonthList.contains(month) && shortYearList.contains(year)) {
					flag = true;
				} else {
					flag = false;
				}
			}
			if (flag)
				return true;
			else if (!flag)
				return false;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}

	private int getXAxisDataCount_Supplier() {
		WebDriverWait wait = new WebDriverWait(driver, 1200);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//*[@class='axisGraphicsContext scatterChart playChart']//*[@data-automation-type='axis-tick-text']")));
		try {
			List<WebElement> rows = driver.findElements(By.xpath(
					"//*[@class='axisGraphicsContext scatterChart playChart']//*[@data-automation-type='axis-tick-text']"));
			int size = rows.size();
			extentTest.log(LogStatus.INFO, "getXAxisDataCount_Supplier: ",
					"Number of months in Xaxis - <B>[" + size + "]</B>");
			return size;
		} catch (NoSuchElementException nsex) {
			return -1;
		}
	}

//	public void login() {
//		synchronized (APPM_Logic.class) {
//			try {
//				refreshDataBook();
//				launchAPP(url);
//				waitForPageToLoad();
//				Thread.sleep(1000);
//				typeIn(APPM_UI.txt_email, email);
//				clickOn(APPM_UI.btn_submitPowerBI);
//				waitForPageToLoad();
//				typeIn(APPM_UI.txt_password, pwd);
//				clickOn(APPM_UI.btn_signinBY);
//				clickOn(APPM_UI.btn_yesBY);
//				waitForPageToLoad();
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();

//		}
//	}

	public void gotoExecutiveSummary_Suppplier() {
		synchronized (Supplier_Logic.class) {
			try {
				clickOn(Supplier_UI.tab_ExecutiveSummary);
				waitForPageToLoad();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void gotoSupplierReview_Suppplier() {
		synchronized (Supplier_Logic.class) {
			try {
				clickOn(Supplier_UI.tab_SupplierReview);
				waitForPageToLoad();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void gotoSupplierScore_Supplier() {
		synchronized (Supplier_Logic.class) {
			try {
				clickOn(Supplier_UI.tab_SupplierScore);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void validateDropDownHasData_Suppplier() {
		synchronized (Supplier_Logic.class) {
			try {
				if (getFilterDropDownRowCount_Supplier() > 0) {
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

	public void validateDropDownHasMultiSelect_Suppplier() {
		synchronized (Supplier_Logic.class) {
			try {
//				selectDropDownOption_Supplier(filterOption);
				if (isMultiSelectActive_Supplier())
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

	public void validateDropDownHasMonthsYears_Suppplier() {
		synchronized (Supplier_Logic.class) {
			try {
				if (checkDropDownForMonthsYears_Supplier(months(), years()))
					extentTest.log(LogStatus.PASS, "Drop Down should have Months and Years",
							"Drop Down is having Months and Years");
				else
					extentTest.log(LogStatus.FAIL, "Drop Down should have Months and Years",
							"Drop Down is not having Months and Years");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void validateDropDownHasAscendingMonths_Suppplier() {
		synchronized (Supplier_Logic.class) {
			try {
				if (checkDDMonthsInAscendingOrder_Supplier(months()))
					extentTest.log(LogStatus.PASS, "Calender Months are to be in ascending order",
							"Calender Months are in ascending order");
				else
					extentTest.log(LogStatus.FAIL, "Calender Months are to be in ascending order",
							"Calender Months are not in ascending order");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void validateChartHasAscendingMonths_Suppplier() {
		synchronized (Supplier_Logic.class) {
			try {
				if (checkChartMonthsInAscendingOrder_Supplier(short_months(months()), short_Years(years())))
					extentTest.log(LogStatus.PASS, "Calender Months are to be in ascending order",
							"Calender Months are in ascending order");
				else
					extentTest.log(LogStatus.FAIL, "Calender Months are to be in ascending order",
							"Calender Months are not in ascending order");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void validateFilterToValueIsSameAsSelected_Supplier() {
		synchronized (Supplier_Logic.class) {
			try {
				String value = getTextOf(Supplier_UI.dd_to);
				getDropDownRadioProp_Supplier(value);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void validateFilterFromValueIsSameAsSelected_Supplier() {
		synchronized (Supplier_Logic.class) {
			try {
				String value = getTextOf(Supplier_UI.dd_from);
				getDropDownRadioProp_Supplier(value);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void gotoFilterProductHierarchy_Supplier() {
		synchronized (Supplier_Logic.class) {
			try {
				clickOn(Supplier_UI.dd_productHierarchy);
				waitForPageToLoad();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void gotoFilterFrom_Supplier() {
		synchronized (Supplier_Logic.class) {
			try {
				clickOn(Supplier_UI.dd_from);
				waitForPageToLoad();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void gotoFilterSupplier_Supplier() {
		synchronized (Supplier_Logic.class) {
			try {
				clickOn(Supplier_UI.dd_supplier);
				waitForPageToLoad();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void gotoFilterTo_Supplier() {
		synchronized (Supplier_Logic.class) {
			try {
				clickOn(Supplier_UI.dd_to);
				waitForPageToLoad();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void validateValueShowsForExecutiveSummaryUnits_Suppplier() {
		synchronized (Supplier_Logic.class) {
			try {
				String val = getTextOf(Supplier_UI.span_ExecutiveSummary_Units_value);
				if (!val.equals(""))
					extentTest.log(LogStatus.PASS, "Value should appear", "Value <B> " + val + " </B>is appearing");
				else
					extentTest.log(LogStatus.FAIL, "Value should appear", "Value <B> " + val + " </B>is not appearing");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void validateValueShowsForSupplierReviewUnits_Suppplier() {
		synchronized (Supplier_Logic.class) {
			try {
				String val = getTextOf(Supplier_UI.span_SupplierReview_Units_value);
				if (!val.equals(""))
					extentTest.log(LogStatus.PASS, "Value should appear", "Value <B> " + val + " </B>is appearing");
				else
					extentTest.log(LogStatus.FAIL, "Value should appear", "Value <B> " + val + " </B>is not appearing");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void validateValueShowsForSpend_Suppplier() {
		synchronized (Supplier_Logic.class) {
			try {
				String val = getTextOf(Supplier_UI.span_Spend_value);
				if (!val.equals(""))
					extentTest.log(LogStatus.PASS, "Value should appear", "Value <B> " + val + " </B>is appearing");
				else
					extentTest.log(LogStatus.FAIL, "Value should appear", "Value <B> " + val + " </B>is not appearing");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void validateValueShowsForCurrentScore_Suppplier() {
		synchronized (Supplier_Logic.class) {
			try {
				String val = getTextOf(Supplier_UI.span_CurrrentScore_value);
				if (!val.equals(""))
					extentTest.log(LogStatus.PASS, "Value should appear", "Value <B> " + val + " </B>is appearing");
				else
					extentTest.log(LogStatus.FAIL, "Value should appear", "Value <B> " + val + " </B>is not appearing");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void validateValueShowsForBestScore_Suppplier() {
		synchronized (Supplier_Logic.class) {
			try {
				String val = getTextOf(Supplier_UI.span_BestScore_value);
				if (!val.equals(""))
					extentTest.log(LogStatus.PASS, "Value should appear", "Value <B> " + val + " </B>is appearing");
				else
					extentTest.log(LogStatus.FAIL, "Value should appear", "Value <B> " + val + " </B>is not appearing");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void validateValueShowsForLeastScore_Suppplier() {
		synchronized (Supplier_Logic.class) {
			try {
				String val = getTextOf(Supplier_UI.span_LeastScore_value);
				if (!val.equals(""))
					extentTest.log(LogStatus.PASS, "Value should appear", "Value <B> " + val + " </B>is appearing");
				else
					extentTest.log(LogStatus.FAIL, "Value should appear", "Value <B> " + val + " </B>is not appearing");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void validateValueShowsForRecommendedTier_Suppplier() {
		synchronized (Supplier_Logic.class) {
			try {
				String val = getTextOf(Supplier_UI.span_RecommendedTier_value);
				if (!val.equals(""))
					extentTest.log(LogStatus.PASS, "Value should appear", "Value <B> " + val + " </B>is appearing");
				else
					extentTest.log(LogStatus.FAIL, "Value should appear", "Value <B> " + val + " </B>is not appearing");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void validateRecommendedTierIconIsEnabled_Suppplier() {
		synchronized (Supplier_Logic.class) {
			try {
				clickOn(Supplier_UI.icon_RecommendedTier);
				waitForPageToLoad();
				int count = getElementsCount(Supplier_UI.icon_RecommendedTier);
				if (count == 0)
					extentTest.log(LogStatus.PASS, "Icon Recommended Tier should enabled",
							"Icon Recommended Tier is enabled");
				else
					extentTest.log(LogStatus.FAIL, "Icon Recommended Tier should enabled",
							"Icon Recommended Tier is not enabled");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void validateValueShowsForExecutiveSummaryContractCoverage_Suppplier() {
		synchronized (Supplier_Logic.class) {
			try {
				String val = getTextOf(Supplier_UI.span_ExecutiveSummary_ContractCoverage_value);
				if (!val.equals(""))
					extentTest.log(LogStatus.PASS, "Value should appear", "Value <B> " + val + " </B>is appearing");
				else
					extentTest.log(LogStatus.FAIL, "Value should appear", "Value <B> " + val + " </B>is not appearing");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void validateValueShowsForSupplierReviewContractCoverage_Suppplier() {
		synchronized (Supplier_Logic.class) {
			try {
				String val = getTextOf(Supplier_UI.span_SupplierReview_ContractCoverage_value);
				if (!val.equals(""))
					extentTest.log(LogStatus.PASS, "Value should appear", "Value is appearing");
				else
					extentTest.log(LogStatus.FAIL, "Value should appear", "Value is not appearing");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void validateArrowColorDirection_Spend_Suppplier() {
		synchronized (Supplier_Logic.class) {
			try {
				checkArrowColor(Supplier_UI.span_Spend_percentage, Supplier_UI.span_Spend_arrow,
						Supplier_UI.span_Spend_arrowColor);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void validateArrowColorDirection_ExecutiveSummaryUnits_Suppplier() {
		synchronized (Supplier_Logic.class) {
			try {
				checkArrowColor(Supplier_UI.span_ExecutiveSummary_Units_percentage,
						Supplier_UI.span_ExecutiveSummary_Units_arrow,
						Supplier_UI.span_ExecutiveSummary_Units_arrowColor);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void validateArrowColorDirection_ExecutiveSummaryContractCoverage_Suppplier() {
		synchronized (Supplier_Logic.class) {
			try {
				checkArrowColor(Supplier_UI.span_ExecutiveSummary_ContractCoverage_percentage,
						Supplier_UI.span_ExecutiveSummary_ContractCoverage_arrow,
						Supplier_UI.span_ExecutiveSummary_ContractCoverage_arrowColor);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void validateArrowColorDirection_SupplierReviewUnits_Suppplier() {
		synchronized (Supplier_Logic.class) {
			try {
				checkArrowColor(Supplier_UI.span_SupplierReview_Units_percentage,
						Supplier_UI.span_SupplierReview_Units_arrow, Supplier_UI.span_SupplierReview_Units_arrowColor);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void validateArrowColorDirection_Spends_Suppplier() {
		synchronized (Supplier_Logic.class) {
			try {
				checkArrowColor(Supplier_UI.span_Spend_percentage, Supplier_UI.span_Spend_arrow,
						Supplier_UI.span_Spend_arrowColor);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void validateArrowColorDirection_SupplierReviewContractCoverage_Suppplier() {
		synchronized (Supplier_Logic.class) {
			try {
				checkArrowColor(Supplier_UI.span_SupplierReview_ContractCoverage_percentage,
						Supplier_UI.span_SupplierReview_ContractCoverage_arrow,
						Supplier_UI.span_SupplierReview_ContractCoverage_arrowColor);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void validateChartShowsBarGraph_Suppplier() {
		synchronized (Supplier_Logic.class) {
			try {
				if (getElementsCount(Supplier_UI.chart_BarGraph) > 0)
					extentTest.log(LogStatus.PASS, "Bar Chart should appear", "Bar Chart is appearing");
				else
					extentTest.log(LogStatus.FAIL, "Bar Chart should appear", "Bar Chart is not appearing");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void validateScoreNotExceeds100_Suppplier() {
		synchronized (Supplier_Logic.class) {
			try {
				if (checkChartScore_Supplier()) {
					extentTest.log(LogStatus.PASS, "Chart Score should not exceed 100",
							"Score is not exceeding 100 Weightage");
				} else {
					extentTest.log(LogStatus.FAIL, "Chart Score should not exceed 100",
							"Score is exceeding 100 Weightage");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void validateBarChartColor_Suppplier() {
		synchronized (Supplier_Logic.class) {
			try {
				if (checkBarChartColor_Supplier()) {
					extentTest.log(LogStatus.PASS,
							"Chart Score should have different color for Positive and Negitive values",
							"Chart Score is having different color for Positive and Negitive values");
				} else {
					extentTest.log(LogStatus.FAIL,
							"Chart Score should have different color for Positive and Negitive values",
							"Chart Score is not having different color for Positive and Negitive values");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private boolean checkChartScore_Supplier() {
		try {
			waitForPageToLoad();
			int barCount = getElementsCount(Supplier_UI.chart_BarGraph);
			for (int i = 1; i <= barCount; i++) {
				String scoreStr = driver
						.findElement(By.xpath("(//*[@data-automation-type='column-chart-rect'])[" + i + "]"))
						.getAttribute("aria-label");
				float score = Float.parseFloat(scoreStr);
				if (!(score <= 100.00))
					return false;
			}
			return true;
		} catch (NoSuchElementException nsex) {
			return false;
		}
	}

	private boolean checkBarChartColor_Supplier() {
		try {
			boolean flag;
			waitForPageToLoad();
			int barCount = getElementsCount(Supplier_UI.chart_BarGraph);
			for (int i = 1; i <= barCount; i++) {
				String scoreStr = driver
						.findElement(By.xpath("(//*[@data-automation-type='column-chart-rect'])[" + i + "]"))
						.getAttribute("aria-label");
				String color = driver
						.findElement(By.xpath("(//*[@data-automation-type='column-chart-rect'])[" + i + "]"))
						.getAttribute("style");
				if (scoreStr.contains("-") && color.contains("(247, 199, 106)")) {
					flag = true;
				} else if (!scoreStr.contains("-") && color.contains("(48, 118, 137)")) {
					flag = true;
				} else {
					return false;
				}
			}
			return true;
		} catch (NoSuchElementException nsex) {
			return false;
		}
	}

	private boolean checkArrowColor(By percen, By arrow, By arrowClr) {
		synchronized (Supplier_Logic.class) {
			try {
				String percentage = getTextOf(percen);
				String arrowDirection = getTextOf(arrow);
				String arrowColor = getAttributeValueOf(arrowClr, "style");
				if (!percentage.trim().contains("-") && arrowColor.trim().contains("171")
						&& arrowDirection.trim().contains("▲")) {
					extentTest.log(LogStatus.PASS, "Positive percentage value should have GREEN Upward arrow",
							"Positive percentage value is having GREEN Upward arrow");
					return true;
				} else if (percentage.trim().contains("-") && arrowColor.trim().contains("0")
						&& arrowDirection.trim().contains("▲")) {
					extentTest.log(LogStatus.PASS, "Negitive percentage value should have RED Downward arrow",
							"Negitive percentage value is having RED Downward arrow");
					return true;
				} else {
					extentTest.log(LogStatus.FAIL, "Failed to Identify Percentage Arrow with color");
					return false;
				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}

	private boolean checkChartName_Supplier(String chartName) {
		try {
			waitForPageToLoad();
			List<WebElement> elm = driver.findElements(By.xpath("//div[contains(text(),'" + chartName + "')]"));
			if (!(elm.size() == 1))
				return false;
			extentTest.log(LogStatus.INFO, "checkSummaryChartName: ", "Chart <B> " + chartName + " </B> is Visible");
			return true;
		} catch (NoSuchElementException nsex) {
			extentTest.log(LogStatus.FAIL, "checkSummaryChartName: ",
					"Chart <B> " + chartName + " </B> is not Visible");
			return false;
		}
	}

//				return true;
//			} else if(status.equalsIgnoreCase("false")) {
//				option.click();
//				extentTest.log(LogStatus.INFO, "selectDropDownOption_Supplier: ","Option is selected- <B>[" + opt + "]</B>");
//				return true;
//			}
//		}
//		extentTest.log(LogStatus.FAIL, "selectDropDownOption_Supplier: ","Option is not present in DropDown - <B>[" + opt + "]</B>");

//	}

	private boolean getDropDownRadioProp_Supplier(String opt) {
//		WebDriverWait wait = new WebDriverWait(driver, 1200);
		waitForPageToLoad();
		int rows = getFilterDropDownRowCount_Supplier();
		for (int i = 1; i <= rows; i++) {
			String textValue = driver.findElement(By.xpath(
					"(//input[@aria-label='Search']//ancestor::div[@class='slicer-dropdown-content']//div[@class='slicerBody']//div[@class='row'])["
							+ i + "]//span[@class='slicerText']"))
					.getText();
			String prop = driver.findElement(By.xpath(
					"(//input[@aria-label='Search']//ancestor::div[@class='slicer-dropdown-content']//div[@class='slicerBody']//div[@class='row'])["
							+ i + "]//span[@class='slicerText']//ancestor::div[@class='slicerItemContainer']"))
					.getAttribute("aria-selected");
			if (textValue.equalsIgnoreCase(opt) && prop.equalsIgnoreCase("true")) {
				extentTest.log(LogStatus.PASS, "getDropDownRadioProp_Supplier: ",
						"Option - <B>[" + opt + "]</B> is apearing as Auto Selected");
				return true;
			}
		}
		extentTest.log(LogStatus.FAIL, "getDropDownRadioProp_Supplier: ",
				"Option - <B>[" + opt + "]</B> is not apearing as Auto Selected");
		return false;
	}

	/* old methods */

	public void validateFROM_Suppplier() {
		synchronized (Supplier_Logic.class) {
			try {
				clickOn(Supplier_UI.dd_from);
				waitForPageToLoad();

				JavascriptExecutor js = (JavascriptExecutor) driver;

				WebElement elm = driver.findElement(By.xpath(
						"(//input[@aria-label='Search']//ancestor::div[@class='slicer-dropdown-content']//div[@class='slicerBody']//div[@class='row'])[11]"));

				String scrollBar = driver.findElement(By.xpath(
						"(//input[@aria-label='Search']//ancestor::div[@class='slicer-dropdown-content']//div[@class='slicerBody']//div[@class='row']//ancestor::div[@class='scroll-wrapper scrollbar-inner']//div[@class='scroll-bar'])[2]"))
						.getAttribute("style");
				System.out.print(scrollBar);

				while (!scrollBar.contains("141")) {
					js.executeScript("arguments[0].scrollIntoView();", elm);
				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void goto_HowIsTheSupplierScoreTrendingAcrossMonths_Supplier() {
		synchronized (Supplier_Logic.class) {
			try {
				doubleClick(Supplier_UI.btn_HowIsTheSupplierScoreTrendingAcrossMonths);
				waitForPageToLoad();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void goto_HowIsTheItemSupplierScoreTrendingAcrossMonths_Supplier() {
		synchronized (Supplier_Logic.class) {
			try {
				doubleClick(Supplier_UI.btn_HowIsTheItemSupplierScoreTrendingAcrossMonths);
				waitForPageToLoad();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

//	public void validateChartName_Supplier() {
//		synchronized (Supplier_Logic.class) {
//			try {
//				checkChartName_Supplier(chartName);
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//	}

//	public void validateDeepDiveDrillTrough() {
//		synchronized (Supplier_Logic.class) {
//			try {
//				if (!(getElementsCount(APPM_UI.header_SummaryChart) == 1)) {
//					checkElementIsEnabled(APPM_UI.btn_DeepDiveProperty);
//					clickOn(APPM_UI.row_SummaryChart_option1);
//					clickOn(APPM_UI.row_SummaryChart_option2);
//					Thread.sleep(2000);
//					waitForPageToLoad();
//					checkElementIsEnabled(APPM_UI.btn_DeepDiveProperty);
//					clickOn(APPM_UI.btn_DeepDive);
//					waitForPageToLoad();
//					if (checkChartColumnHeader_Supplier(detailHeader)) {
//						extentTest.log(LogStatus.PASS, "validateSupplierLeadTimeDeepDiveDrillTrough: ",
//								"<B> Drill Through martrix chart </B> is visible through Deep Dive button ");
//					}
//				} else if (getElementsCount(APPM_UI.header_SummaryChart) == 0) {
//					checkElementIsEnabled(APPM_UI.btn_DeepDiveProperty);
//					clickOn(APPM_UI.row_SummaryChart_option1);
//					Thread.sleep(2000);
//					waitForPageToLoad();
//					checkElementIsEnabled(APPM_UI.btn_DeepDiveProperty);
//					waitForPageToLoad();
//					clickOn(APPM_UI.btn_DeepDive);
//					waitForPageToLoad();
//					if (checkChartColumnHeader_Supplier(detailHeader)) {
//						extentTest.log(LogStatus.PASS, "validateSupplierLeadTimeDeepDiveDrillTrough: ",
//								"<B> Drill Through martrix chart </B> is visible through Deep Dive button ");
//					}
//				}
//
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}

	public void gotoSupplierScore_Suppplier() {
		synchronized (Supplier_Logic.class) {
			try {
				clickOn(Supplier_UI.tab_SupplierScore);
				waitForPageToLoad();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private boolean isMultiSelectActive_Supplier() {

		try {
			boolean flag = false;
			String state = driver.findElement(Supplier_UI.dd_SelectAll_option).getAttribute("aria-checked");
			if (state.trim().equals("true")) {
				int rows = getFilterDropDownRowCount_Supplier();
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
				driver.findElement(Supplier_UI.dd_SelectAll_option).click();
				if (state.trim().equals("true")) {
					int rows = getFilterDropDownRowCount_Supplier();
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

	private int getFilterDropDownRowCount_Supplier() {
		WebDriverWait wait = new WebDriverWait(driver, 1200);
		wait.until(ExpectedConditions.visibilityOfElementLocated(Supplier_UI.dd_options_supplier));
		try {
			List<WebElement> rows = driver.findElements(Supplier_UI.dd_options_supplier);
			int size = rows.size();
			extentTest.log(LogStatus.INFO, "getDropDownRowCount: ", "Number of rows is- <B>[" + size + "]</B>");
			return size;
		} catch (NoSuchElementException nsex) {
			return -1;
		}
	}

	private boolean checkDDMonthsInAscendingOrder_Supplier(ArrayList<String> monthList) {
		try {
			boolean flag = false;
			int position;
			int temp = 0;
			WebDriverWait wait = new WebDriverWait(driver, 1200);
			int rows = getFilterDropDownRowCount_Supplier();
			for (int i = 1; i <= rows; i++) {
				String str = driver.findElement(By.xpath(
						"(//input[@aria-label='Search']//ancestor::div[@class='slicer-dropdown-content']//div[@class='slicerBody']//div[@class='row'])["
								+ i + "]//span[@class='slicerText']"))
						.getText();
				String[] monthYear = str.split(" ");
				if (monthList.contains(monthYear[0].trim())) {
					position = monthList.indexOf(monthYear[0]);
					if (monthYear[0].trim().contains("January"))
						temp = 0; // Resetting temp
//				System.out.println(position);
					if (temp <= position) {
						temp = position;
						flag = true;
					} else {
						flag = false;
					}
				}else {
					return false;
				}
			}
			if (flag)
				return true;
			else if (!flag)
				return false;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}

	private boolean checkChartMonthsInAscendingOrder_Supplier(ArrayList<String> shortMonthList,
			ArrayList<String> shortYearList) {
		try {
			boolean flag = false;
			int position;
			int monTemp = 0;
			int rows = getXAxisDataCount_Supplier();
			for (int i = 1; i <= rows; i++) {
				String str = driver.findElement(By.xpath(
						"(//*[@class='axisGraphicsContext scatterChart playChart']//*[@data-automation-type='axis-tick-text'])["
								+ i + "]"))
						.getText();
				String[] monthYear = str.split("'");
				if (shortMonthList.contains(monthYear[0].trim())) {
					String year = monthYear[1].trim();
					int yrUI = Integer.parseInt(year); // UI year
					position = shortMonthList.indexOf(monthYear[0]);
					// Resetting counter on reaching month JAN
					if (monthYear[0].trim().contains("Jan")) {
						monTemp = 0;
					}
					// checking months order is in Ascending
					if (monTemp <= position) {
						monTemp = position;
						flag = true;
					} else {
						flag = false;
					}
				} else {
					return false;
				}
			}
			if (flag)
				return true;
			else if (!flag)
				return false;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}

	private boolean checkDropDownForMonthsYears_Supplier(ArrayList<String> monthList, ArrayList<String> yearList) {

		try {
			boolean flag = false;
			WebDriverWait wait = new WebDriverWait(driver, 1200);
			int rows = getFilterDropDownRowCount_Supplier();
			for (int i = 1; i <= rows; i++) {
				String str = driver.findElement(By.xpath(
						"(//input[@aria-label='Search']//ancestor::div[@class='slicer-dropdown-content']//div[@class='slicerBody']//div[@class='row'])["
								+ i + "]//span[@class='slicerText']"))
						.getText();
				String[] monthYear = str.split(" ");
				String month = monthYear[0].trim();
				String year = monthYear[1].trim();
				if (monthList.contains(month) && yearList.contains(year)) {
					flag = true;
				} else {
					flag = false;
				}
			}
			if (flag)
				return true;
			else if (!flag)
				return false;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}

	private boolean checkChartColumnHeader_Supplier(String str) {
		try {
			String[] items = str.split("\\|");
			List<String> itemList = Arrays.asList(items);
//			System.out.println(itemList.toString());

			for (int i = 0; i < itemList.size(); i++) {
				String head = itemList.get(i).trim();
				List<WebElement> elm = driver
						.findElements(By.xpath("//div[@class='innerContainer']//div[text()='" + head + "']"));
//				System.out.println(elm.size());
				if (!(elm.size() == 1))
					return false;
			}
			extentTest.log(LogStatus.PASS, "checkChartColumnHeader: ",
					"Column Header <B> " + str.toString() + " </B> is Present");
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			extentTest.log(LogStatus.FAIL, "checkChartColumnHeader: ",
					"Column Header <B> " + str.toString() + " </B> is not Present");
			return false;
		}

	}

	private boolean checkDropDownForOption_Supplier(String opt) {
//		System.out.print(opt);
//		WebDriverWait wait = new WebDriverWait(driver, 1200);
		waitForPageToLoad();
		int rows = getFilterDropDownRowCount_Supplier();
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
}