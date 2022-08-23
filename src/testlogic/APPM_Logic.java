package testlogic;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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

	public void login() {
		synchronized (APPM_Logic.class) {
			try {
				refreshDataBook();
				launchAPP(url);
				waitForPageToLoad();
				Thread.sleep(1000);
				typeIn(APPM_UI.txt_email, email);
				clickOn(APPM_UI.btn_submitPowerBI);
				waitForPageToLoad();
				typeIn(APPM_UI.txt_password, pwd);
				clickOn(APPM_UI.btn_signinBY);
				clickOn(APPM_UI.btn_yesBY);
				waitForPageToLoad();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void validateDropDownHasData() {
		synchronized (APPM_Logic.class) {
			try {
				selectDropDown(filterName);
				if (getDropDownRowCount() > 0) {
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

	public void validateValueInDropDown() {
		synchronized (APPM_Logic.class) {
			try {
				selectDropDown(filterName);
				checkDropDownForOption(filterOption);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void selectSupplierAndDestination() {
		synchronized (APPM_Logic.class) {
			try {
				clickOn(APPM_UI.row_SummaryChart_option1);
				clickOn(APPM_UI.row_SummaryChart_option2);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void validateSummaryChartDeepDiveButtonIsActive() {
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

	public void validateSummaryChartName() {
		synchronized (APPM_Logic.class) {
			try {
				checkSummaryChartName(chartName);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void validateDeepDiveDrillTrough() {
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
					if (checkChartColumnHeader(detailHeader)) {
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
					if (checkChartColumnHeader(detailHeader)) {
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

	public void validateChartColumnHeader() {
		synchronized (APPM_Logic.class) {
			try {
				checkChartColumnHeader(summaryHeader);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void gotoLeadTimeAnalysis() {
		synchronized (APPM_Logic.class) {
			try {
				clickOn(APPM_UI.tab_leadTimeAnalysis);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void gotoYield() {
		synchronized (APPM_Logic.class) {
			try {
				clickOn(APPM_UI.tab_Yield);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void gotoCapacity() {
		synchronized (APPM_Logic.class) {
			try {
				clickOn(APPM_UI.tab_Capacity);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void gotoSupplierLeadTime() {
		synchronized (APPM_Logic.class) {
			try {
				clickOn(APPM_UI.btn_SupplierLeadTime);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void gotoProductionYield() {
		synchronized (APPM_Logic.class) {
			try {
				clickOn(APPM_UI.btn_ProductionYield);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void gotoProductionRate() {
		synchronized (APPM_Logic.class) {
			try {
				clickOn(APPM_UI.btn_ProductionRate);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void gotoDistributionLeadTime() {
		synchronized (APPM_Logic.class) {
			try {
				clickOn(APPM_UI.btn_DistributionLeadTime);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void gotoSummaryChart() {
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

	public void gotoDetailedViewChart() {
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

	public void validateDataDistributionChart() {
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
}