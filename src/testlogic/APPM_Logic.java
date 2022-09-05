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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.LogStatus;
import com.thoughtworks.selenium.webdriven.commands.IsVisible;

import frameworkutils.DataBook;
import frameworkutils.WebDriverFactory;
import uimaps.APPM_UI;

public class APPM_Logic extends WebDriverFactory {

	public APPM_Logic(WebDriver driver, Map<String, String> dataBook) {
		super(driver, dataBook);
	}

	String url = dataBook.get("Url");
	String email = dataBook.get("Email");
	String pwd = dataBook.get("Password");
	String filterName = dataBook.get("Fliter_Name");
	String filterOption = dataBook.get("Filter_Option");
	String chartName = dataBook.get("Chart_Name");
	String summaryHeader = dataBook.get("SummaryColumn_Header");
	String detailHeader = dataBook.get("DetailedViewColumn_Header");

	
	/**
	 * Checks filter has data	 
	 * 
	 * @param - Filter name
	 * 
	 **/
	public void validateDropDownHasData_APPM() {
		synchronized (APPM_Logic.class) {
			try {
				selectDropDown_APPM(filterName);
				if (getFilterDropDownRowCount_APPM() > 0) {
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

	/**
	 * Checks a particular value in a filter	 
	 * 
	 * @param - Filter name, Filter option
	 * 
	 **/
	public void validateValueInDropDown_APPM() {
		synchronized (APPM_Logic.class) {
			try {
				selectDropDown_APPM(filterName);
				checkDropDownForOption_APPM(filterOption);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * Selects a Summary chart row option 1 & 2 	 
	 * 
	 * @param - By instance of a WebElement
	 * 
	 **/
//	public void selectSupplierAndDestination_APPM() {
//		synchronized (APPM_Logic.class) {
//			try {
//				clickOn(APPM_UI.row_SummaryChart_option1);
//				clickOn(APPM_UI.row_SummaryChart_option2);
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//	}

	/**
	 * Checks Deep Dive button is active after selecting Summary chart row option 1 & 2
	 * 
	 * @param - By instance of a WebElement
	 * 
	 **/
	public void validateSummaryChartDeepDiveButtonIsActive_APPM() {
		synchronized (APPM_Logic.class) {
			try {
				if (!(getElementsCount(APPM_UI.header_SummaryChart) == 1)) {
					checkElementIsEnabled(APPM_UI.btn_DeepDiveProperty);
					clickOn(APPM_UI.row_SummaryChart_option1);
					clickOn(APPM_UI.row_SummaryChart_option2);
					Thread.sleep(2000);
					waitForPageToLoad();
					checkElementIsEnabled(APPM_UI.btn_DeepDiveProperty);
					waitForPageToLoad();
				} else if (getElementsCount(APPM_UI.header_SummaryChart) == 0) {
					checkElementIsEnabled(APPM_UI.btn_DeepDiveProperty);
					clickOn(APPM_UI.row_SummaryChart_option1);					
					Thread.sleep(2000);
					waitForPageToLoad();
					checkElementIsEnabled(APPM_UI.btn_DeepDiveProperty);
					waitForPageToLoad();
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * Checks the Summary chart name
	 * 
	 * @param - Chart Name
	 * 
	 **/
	public void validateSummaryChartName_APPM() {
		synchronized (APPM_Logic.class) {
			try {
				checkSummaryChartName_APPM(chartName);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * Checks the Deep Dive drill through is working
	 * 
	 * @param - By instance of a WebElement
	 * 
	 **/
	public void validateDeepDiveDrillTrough_APPM() {
		synchronized (APPM_Logic.class) {
			try {
				if (!(getElementsCount(APPM_UI.header_SummaryChart) == 1)) {
					checkElementIsEnabled(APPM_UI.btn_DeepDiveProperty);
					clickOn(APPM_UI.row_SummaryChart_option1);
					clickOn(APPM_UI.row_SummaryChart_option2);
					Thread.sleep(2000);
					waitForPageToLoad();
					checkElementIsEnabled(APPM_UI.btn_DeepDiveProperty);
					clickOn(APPM_UI.btn_DeepDive);
					waitForPageToLoad();
					if (checkChartColumnHeader_APPM(detailHeader)) {
						extentTest.log(LogStatus.PASS, "validateSupplierLeadTimeDeepDiveDrillTrough: ",
								"<B> Drill Through martrix chart </B> is visible through Deep Dive button ");
					}
				} else if (getElementsCount(APPM_UI.header_SummaryChart) == 0) {
					checkElementIsEnabled(APPM_UI.btn_DeepDiveProperty);
					clickOn(APPM_UI.row_SummaryChart_option1);
					Thread.sleep(2000);
					waitForPageToLoad();
					checkElementIsEnabled(APPM_UI.btn_DeepDiveProperty);
					waitForPageToLoad();
					clickOn(APPM_UI.btn_DeepDive);
					waitForPageToLoad();
					if (checkChartColumnHeader_APPM(detailHeader)) {
						extentTest.log(LogStatus.PASS, "validateSupplierLeadTimeDeepDiveDrillTrough: ",
								"<B> Drill Through martrix chart </B> is visible through Deep Dive button ");
					}
				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * Checks the Chart Column header name
	 * 
	 * @param - By Header name
	 * 
	 **/
	public void validateChartColumnHeader_APPM() {
		synchronized (APPM_Logic.class) {
			try {
				checkChartColumnHeader_APPM(summaryHeader);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * Clicks on Lead Time Analysis tab
	 * 
	 * @param - By instance of a WebElement
	 * 
	 **/
	public void gotoLeadTimeAnalysis_APPM() {
		synchronized (APPM_Logic.class) {
			try {
				clickOn(APPM_UI.tab_leadTimeAnalysis);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * Clicks on Yield tab
	 * 
	 * @param - By instance of a WebElement
	 * 
	 **/
	public void gotoYield_APPM() {
		synchronized (APPM_Logic.class) {
			try {
				clickOn(APPM_UI.tab_Yield);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * Clicks on Capacity tab
	 * 
	 * @param - By instance of a WebElement
	 * 
	 **/
	public void gotoCapacity_APPM() {
		synchronized (APPM_Logic.class) {
			try {
				clickOn(APPM_UI.tab_Capacity);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * Clicks on Supplier Lead Time button
	 * 
	 * @param - By instance of a WebElement
	 * 
	 **/
	public void gotoSupplierLeadTime_APPM() {
		synchronized (APPM_Logic.class) {
			try {
				clickOn(APPM_UI.btn_SupplierLeadTime);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * Clicks on Production Yield button
	 * 
	 * @param - By instance of a WebElement
	 * 
	 **/
	public void gotoProductionYield_APPM() {
		synchronized (APPM_Logic.class) {
			try {
				clickOn(APPM_UI.btn_ProductionYield);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * Clicks on Production Rate button
	 * 
	 * @param - By instance of a WebElement
	 * 
	 **/
	public void gotoProductionRate_APPM() {
		synchronized (APPM_Logic.class) {
			try {
				clickOn(APPM_UI.btn_ProductionRate);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * Clicks on Distribution Lead Time button
	 * 
	 * @param - By instance of a WebElement
	 * 
	 **/
	public void gotoDistributionLeadTime_APPM() {
		synchronized (APPM_Logic.class) {
			try {
				clickOn(APPM_UI.btn_DistributionLeadTime);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * Clicks on Lead Time - Summary button
	 * 
	 * @param - By instance of a WebElement
	 * 
	 **/
	public void gotoSummaryChart_APPM() {
		synchronized (APPM_Logic.class) {
			try {
				clickOn(APPM_UI.btn_SummaryViewChart);
				waitForPageToLoad();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Clicks on Lead Time - Detailed view button
	 * 
	 * @param - By instance of a WebElement
	 * 
	 **/
	public void gotoDetailedViewChart_APPM() {
		synchronized (APPM_Logic.class) {
			try {
				clickOn(APPM_UI.btn_DetailedViewChart);
				waitForPageToLoad();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * Checks for Data Distribution Chart
	 * 
	 * @param - By instance of a WebElement
	 * 
	 **/
	public void validateDataDistributionChart_APPM() {
		synchronized (APPM_Logic.class) {
			try {
				selectFrame(APPM_UI.frame_DataDistribution);
				if (isEnabled(APPM_UI.chart_DataDistribution)) {
					extentTest.log(LogStatus.PASS, "validateDataDistributionChart: ",
							"<B> Data Distribution Chart </B> is Present");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Clicks on filter
	 * 
	 * @param - By Filter name
	 * 
	 **/
	private boolean selectDropDown_APPM(String dd) {
		// return false if WebElement is not found
//		WebDriverWait wait = new WebDriverWait(driver, 1200);
		try {
			waitForPageToLoad();
			Thread.sleep(2000);
			WebElement elm = driver.findElement(By.xpath("//*[@title='" + dd
					+ "']//ancestor::div[contains(@class,'slicer-container')]//div[@class='slicer-dropdown-menu']"));
			if (!elm.isDisplayed())
				return false;
			elm.click();
			extentTest.log(LogStatus.INFO, "selectDropDown: ", "Drop Down <B> " + dd + " </B> is clicked");
			waitForPageToLoad();
			return true;
		} catch (UnhandledAlertException uaex) {
			extentTest.log(LogStatus.FAIL, "Drop Down <B>[" + dd + "]</B>", "is not clicked - <B>");
			return false;
		} catch (InterruptedException e) {
			extentTest.log(LogStatus.FAIL, "Drop Down <B>[" + dd + "]</B>", "is not clicked - <B>");
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * Checks filer for an option
	 * 
	 * @param - By filter option
	 * 
	 **/
	private boolean checkDropDownForOption_APPM(String opt) {
//		System.out.print(opt);
//		WebDriverWait wait = new WebDriverWait(driver, 1200);
		waitForPageToLoad();
		int rows = getFilterDropDownRowCount_APPM();
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
	
	/**
	 * Checks Column header of a chart
	 * 
	 * @param - By Chart/Matrix name
	 * 
	 **/
	private boolean checkChartColumnHeader_APPM(String str) {
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
	
	/**
	 * Returns number of rows present in a filter
	 * 
	 * @param - By instance of a WebElement
	 * 
	 * @return count of rows present in filter
	 * 
	 **/
	private int getFilterDropDownRowCount_APPM() {
		WebDriverWait wait = new WebDriverWait(driver, 1200);
		wait.until(ExpectedConditions.visibilityOfElementLocated(APPM_UI.opt_dropDownRowsData));
		try {
			List<WebElement> rows = driver.findElements(APPM_UI.opt_dropDownRowsData);
			int size = rows.size();
			extentTest.log(LogStatus.INFO, "getDropDownRowCount: ", "Number of rows is- <B>[" + size + "]</B>");
			return size;
		} catch (NoSuchElementException nsex) {
			return -1;
		}
	}


private boolean checkSummaryChartName_APPM(String chartName) {
	try {
//		System.out.print(chartName);
//		WebDriverWait wait = new WebDriverWait(driver, 1200);
		waitForPageToLoad();
		List<WebElement> elm = driver.findElements(By.xpath("//div[@title='" + chartName + "']"));
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
}