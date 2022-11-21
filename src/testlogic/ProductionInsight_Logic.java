package testlogic;

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
import uimaps.ProductionInsight_UI;

public class ProductionInsight_Logic extends WebDriverFactory {

	public ProductionInsight_Logic(WebDriver driver, Map<String, String> dataBook) {
		super(driver, dataBook);
		// TODO Auto-generated constructor stub
	}

	String filterName = dataBook.get("Fliter_Name");
	String filterOption = dataBook.get("Filter_Option");

	public void Navigate_To_ProductionInsightHomepage() {
		synchronized (ProductionInsight_Logic.class) {
			try {
				waitForPageToLoad();
//				waitForElementTobeClickable(ProductionInsight_UI.ProductionInsightHomepage);
				waitForElementTobeLocated(ProductionInsight_UI.ProductionInsightHomepage);
				if (isDisplayed(ProductionInsight_UI.ProductionInsightHomepage))
					extentTest.log(LogStatus.PASS, "Navigated ProductionInsighthomepage",
							"Navigated ProductionInsighthomepage");
				else
					extentTest.log(LogStatus.FAIL, "Unable to navigate to the ProductionInsighthomepage",
							"Unable to navigate to ProductionInsighthomepage");

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void validate_DropDownHasData_ProductionInsight() {
		synchronized (ProductionInsight_Logic.class) {
			try {
				By optCount = By.xpath("//div[@role='combobox' and @aria-label='" + filterName
						+ "']//div[@class='slicer-restatement']/../..");
				if (clickOn(optCount))
					extentTest.log(LogStatus.PASS, "Drop Down should have data", "Drop Down has number of rows");
				else
					extentTest.log(LogStatus.FAIL, "Drop Down should have data", "Drop Down has no Data");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void validate_ToDropDownHasData_Productioninsight() {
		synchronized (ProductionInsight_Logic.class) {
			try {
				By optCount = By.xpath(
						"(//div[@role='combobox' and @aria-label='Month']//div[@class='slicer-restatement']/../..)[2]");
				if (clickOn(optCount))
					extentTest.log(LogStatus.PASS, "Drop Down should have data for to filter",
							"Drop Down has number of rows");
				else
					extentTest.log(LogStatus.FAIL, "Drop Down should have data for to filter",
							"Drop Down has no Data for to filter");
			} catch (Exception e) {
				e.printStackTrace();

			}
		}
	}

	public void validateValueInDropDown_ProductionInsight() {
		synchronized (ProductionInsight_Logic.class) {
			try {
				checkDropDownForOption_ProductionInsight(filterOption);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private boolean checkDropDownForOption_ProductionInsight(String opt) {
		synchronized (ProductionInsight_Logic.class) {
			waitForPageToLoad();

			int rows = getFilterDropDownRowCount_ProductionInsight();
			for (int i = 1; i <= rows; i++) {
				String value = driver.findElement(By.xpath(
						"(//input[@aria-label='Search']//ancestor::div[@class='slicer-dropdown-content']//div[@class='slicerBody']//div[@class='row'])["
								+ i + "]//span[@class='slicerText']"))
						.getText();
				if (!value.equals(" ")) {
					extentTest.log(LogStatus.INFO, "checkDropDownForOption has data ", "data is not present</B>");
					return true;
				} else {
					extentTest.log(LogStatus.FAIL, "checkDropDownForOption has not null ",
							"Option is not present- <B>[" + opt + "]</B>");
				}
			}
			return false;
		}
	}

	private int getFilterDropDownRowCount_ProductionInsight() {
		WebDriverWait wait = new WebDriverWait(driver, 1200);
		wait.until(ExpectedConditions.visibilityOfElementLocated(ProductionInsight_UI.opt_dropDownRowsData));
		try {
			List<WebElement> rows = driver.findElements(ProductionInsight_UI.opt_dropDownRowsData);
			int size = rows.size();
			extentTest.log(LogStatus.INFO, "getDropDownRowCount: ", "Number of rows is- <B>[" + size + "]</B>");
			return size;
		} catch (NoSuchElementException nsex) {
			return -1;
		}
	}

	public void validate_FileRateTrend() {
		synchronized (ProductionInsight_Logic.class) {
			try {
				waitForPageToLoad();
				isDisplayed(ProductionInsight_UI.tittle_FinalRateTrend);
				String tittletext = getTextOf(ProductionInsight_UI.tittle_FinalRateTrend);
				String monthParametertext = getTextOf(ProductionInsight_UI.monthparameterText);
				if (tittletext.trim().contains(monthParametertext.trim()))
					extentTest.log(LogStatus.PASS, "final rate trend equals to Month parameter",
							"final rate trend equals to Month parameter");
				else
					extentTest.log(LogStatus.FAIL, "final rate trend is not equals to Month parameter",
							"final rate trend is not equals to Month parameter");
			} catch (Exception e) {
				e.printStackTrace();

			}
		}
	}

	public void validate_PlantProductionText() {
		try {
			waitForPageToLoad();
			isDisplayed(ProductionInsight_UI.plantProductionText);
			String plantproductiontext = getTextOf(ProductionInsight_UI.plantProductionText);
			String monthParametervalue = getTextOf(ProductionInsight_UI.monthparameterText);
			if (plantproductiontext.trim().contains(monthParametervalue))
				extentTest.log(LogStatus.PASS, "Last 5Months Plant Production Adherence is present",
						"Last 5Months Plant Production Adherence is present ");
			else
				extentTest.log(LogStatus.FAIL, "Last 5Months Plant Production Adherence is not present",
						"Last 5Months Plant Production Adherence is not present");
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public void validate_YearTargetActual_ExecutiveSummery() {
		synchronized (ProductionInsight_Logic.class) {
			try {
				waitForPageToLoad();
				if (isDisplayed(ProductionInsight_UI.xaxies_Label_year)
						&& isDisplayed(ProductionInsight_UI.xaxies_Value_year)
						&& isDisplayed(ProductionInsight_UI.yaxies_label_year)
						&& isDisplayed(ProductionInsight_UI.graphvalues_year))

					extentTest.log(LogStatus.PASS, "yeah and month label and values are displaying",
							"yeah and month label and values are displaying");
				else
					extentTest.log(LogStatus.FAIL, "yeah and month label and values are not displaying",
							"yeah and month label and values are not displaying");
			} catch (Exception e) {
				e.printStackTrace();

			}
		}
	}

	public void validate_MonthTargetActual_ExecutiveSummery() {
		try {
			waitForPageToLoad();
			if (isDisplayed(ProductionInsight_UI.xaxies_Label_month)
					&& isDisplayed(ProductionInsight_UI.xaxies_Value_month)
					&& isDisplayed(ProductionInsight_UI.yaxies_label_month)
					&& isDisplayed(ProductionInsight_UI.graphvalues_month))

				extentTest.log(LogStatus.PASS, "yeah and month label and values are displaying",
						"yeah and month label and values are displaying");
			else
				extentTest.log(LogStatus.FAIL, "yeah and month label and values are not displaying",
						"yeah and month label and values are not displaying");
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public void validate_YearTargetActual_PlantInsight() {
		synchronized (ProductionInsight_Logic.class) {
			try {
				waitForPageToLoad();
				if (isDisplayed(ProductionInsight_UI.xaxies_Label_year)
						&& isDisplayed(ProductionInsight_UI.xaxies_Value_year)
						&& isDisplayed(ProductionInsight_UI.yaxies_label_year)
						&& isDisplayed(ProductionInsight_UI.graphvalues_year))

					extentTest.log(LogStatus.PASS, "yeah and month label and values are displaying",
							"yeah and month label and values are displaying");
				else
					extentTest.log(LogStatus.FAIL, "yeah and month label and values are not displaying",
							"yeah and month label and values are not displaying");
			} catch (Exception e) {
				e.printStackTrace();

			}
		}
	}

	public void validate_MonthTargetActual_PlantInsight() {
		synchronized (ProductionInsight_Logic.class) {
			try {
				waitForPageToLoad();
				if (isDisplayed(ProductionInsight_UI.xaxies_Label_Plantmonth)
						&& isDisplayed(ProductionInsight_UI.xaxies_Value_Plantmonth)
						&& isDisplayed(ProductionInsight_UI.yaxies_label_Plantmonth)
						&& isDisplayed(ProductionInsight_UI.graphvalues_Plantmonth))

					extentTest.log(LogStatus.PASS, "yeah and month label and values are displaying",
							"yeah and month label and values are displaying");
				else
					extentTest.log(LogStatus.FAIL, "yeah and month label and values are not displaying",
							"yeah and month label and values are not displaying");
			} catch (Exception e) {
				e.printStackTrace();

			}
		}
	}

	public void validate_MonthTargetActual_SubcontractorInsight() {
		synchronized (ProductionInsight_Logic.class) {
			try {
				waitForPageToLoad();
				if (isDisplayed(ProductionInsight_UI.xaxies_Label_Plantmonth)
						&& isDisplayed(ProductionInsight_UI.xaxies_Value_Plantmonth)
						&& isDisplayed(ProductionInsight_UI.yaxies_label_Plantmonth)
						&& isDisplayed(ProductionInsight_UI.graphvalues_Plantmonth))

					extentTest.log(LogStatus.PASS, " subcontractor month label and values are displaying",
							" subcontractor month label and values are displaying");
				else
					extentTest.log(LogStatus.FAIL, " subcontractor month label and values are not displaying",
							" subcontractor month label and values are not displaying");
			} catch (Exception e) {
				e.printStackTrace();

			}
		}
	}

	public void validate_PlantFillRateTrend_PlantInsight() {
		synchronized (ProductionInsight_Logic.class) {
			try {
				doubleClick(ProductionInsight_UI.PlantInsights_WhatisMyPlant);
				waitForPageToLoad();
				Thread.sleep(3000);
				if (isDisplayed(ProductionInsight_UI.xaxies_Label_Plantmonth)
						&& isDisplayed(ProductionInsight_UI.xaxies_Value_Plantmonth)
						&& isDisplayed(ProductionInsight_UI.yaxies_label_Plantmonth)
						&& isDisplayed(ProductionInsight_UI.graphvalues_Plantmonth))

					extentTest.log(LogStatus.PASS, "PlantFillRateTrend_PlantInsight is displaying",
							"PlantFillRateTrend_PlantInsight is displaying");
				else
					extentTest.log(LogStatus.FAIL, "PlantFillRateTrend_PlantInsight is not displaying",
							"PlantFillRateTrend_PlantInsight is not displaying");
			} catch (Exception e) {
				e.printStackTrace();

			}
		}
	}

	public void validate_WhatisMyContractUsage_Subcontractor() {
		synchronized (ProductionInsight_Logic.class) {
			try {
				doubleClick(ProductionInsight_UI.SubContractor_WhatisMycontractUsage);
				waitForPageToLoad();
				if (isDisplayed(ProductionInsight_UI.xaxies_Label_Plantmonth)
						&& isDisplayed(ProductionInsight_UI.xaxies_Value_Plantmonth)
						&& isDisplayed(ProductionInsight_UI.yaxies_label_Plantmonth)
						&& isDisplayed(ProductionInsight_UI.graphvalues_Plantmonth))

					extentTest.log(LogStatus.PASS, "PlantFillRateTrend_PlantInsight is displaying",
							"PlantFillRateTrend_PlantInsight is displaying");
				else
					extentTest.log(LogStatus.FAIL, "PlantFillRateTrend_PlantInsight is not displaying",
							"PlantFillRateTrend_PlantInsight is not displaying");
			} catch (Exception e) {
				e.printStackTrace();

			}
		}
	}

	public void validate_WhatisMyContractUsage_SubcontractorInsights() {
		synchronized (ProductionInsight_Logic.class) {
			try {
				doubleClick(ProductionInsight_UI.PlantInsights_WhatisMyPlant);
				waitForPageToLoad();
				Thread.sleep(3000);
				if (isDisplayed(ProductionInsight_UI.xaxies_Label_Plantmonth)
						&& isDisplayed(ProductionInsight_UI.xaxies_Value_Plantmonth)
						&& isDisplayed(ProductionInsight_UI.yaxies_label_Plantmonth)
						&& isDisplayed(ProductionInsight_UI.graphvalues_Plantmonth))

					extentTest.log(LogStatus.PASS, "PlantFillRateTrend_PlantInsight is displaying",
							"PlantFillRateTrend_PlantInsight is displaying");
				else
					extentTest.log(LogStatus.FAIL, "PlantFillRateTrend_PlantInsight is not displaying",
							"PlantFillRateTrend_PlantInsight is not displaying");
			} catch (Exception e) {
				e.printStackTrace();

			}
		}
	}

	public void validate_PlantQualityTrendPlantInsight() {
		synchronized (ProductionInsight_Logic.class) {
			try {
				doubleClick(ProductionInsight_UI.PlantInsights_Plantqualitytrend);
				waitForPageToLoad();
				if (isDisplayed(ProductionInsight_UI.xaxies_Value_Plantmonth)
						&& isDisplayed(ProductionInsight_UI.xaxies_Value_Plantmonth)
						&& isDisplayed(ProductionInsight_UI.yaxies_label_Plantmonth)
						&& isDisplayed(ProductionInsight_UI.graphvalues_Plantmonth))

					extentTest.log(LogStatus.PASS, "PlantQualityTrend is displaying",
							"PlantQualityTrend is displaying");
				else
					extentTest.log(LogStatus.FAIL, "PlantQualityTrend is not displaying",
							"PlantQualityTrend is not displaying");
			} catch (Exception e) {
				e.printStackTrace();

			}
		}
	}

	public void validate_CapacityUtilizationTrendPlantInsight() {
		synchronized (ProductionInsight_Logic.class) {
			try {
				doubleClick(ProductionInsight_UI.PlantInsights_Plantqualitytrend);
				waitForPageToLoad();
				if (isDisplayed(ProductionInsight_UI.xaxies_Value_capacityUtilization)
						&& isDisplayed(ProductionInsight_UI.xaxies_Value_capacityUtilization)
						&& isDisplayed(ProductionInsight_UI.yaxies_label_capacityUtilization)
						&& isDisplayed(ProductionInsight_UI.graphvalues_capacityUtilization)
						&& isDisplayed(ProductionInsight_UI.graphvalues_RejectionRateTittle)
						&& isDisplayed(ProductionInsight_UI.graphvalues_Actualtittle)
						&& isDisplayed(ProductionInsight_UI.graphvalues_Plantittle))

					extentTest.log(LogStatus.PASS, "CapacityUtilization is displaying",
							"CapacityUtilization is displaying");
				else
					extentTest.log(LogStatus.FAIL, "CapacityUtilization is not displaying",
							"CapacityUtilizationis not displaying");
			} catch (Exception e) {
				e.printStackTrace();

			}
		}
	}

	public void validate_SubcontractoQualityTrend() {
		synchronized (ProductionInsight_Logic.class) {
			try {
				doubleClick(ProductionInsight_UI.SubContractor_QualityTrend);
				waitForPageToLoad();
				if ( isDisplayed(ProductionInsight_UI.yaxies_label_SubcontractoQualityTrend)
						&& isDisplayed(ProductionInsight_UI.graphvalues_SubcontractoQualityTrend)
						&& isDisplayed(ProductionInsight_UI.graphvalues_SubcontractoQualityTrend)
						&& isDisplayed(ProductionInsight_UI.graphvalues_SubcontractoQualityTrend)
						&& isDisplayed(ProductionInsight_UI.graphvalues_SubcontractoQualityTrend))

					extentTest.log(LogStatus.PASS, "SubcontractoQualityTrend is displaying",
							"SubcontractoQualityTrend is displaying");
				else
					extentTest.log(LogStatus.FAIL, "SubcontractoQualityTrend is not displaying",
							"SubcontractoQualityTrend is not displaying");
			} catch (Exception e) {
				e.printStackTrace();

			}
		}
	}

	public void Navigate_To_PlantInsights() {
		synchronized (ProductionInsight_Logic.class) {
			try {
				waitForPageToLoad();
//	        isDisplayed(ProductionInsight_UI.PlantInsights_header);
				waitForElementTobeLocated(ProductionInsight_UI.PlantInsights_header);
				doubleClick(ProductionInsight_UI.PlantInsights_header);
				waitForPageToLoad();
				if (isDisplayed(ProductionInsight_UI.PlantInsights_title))

					extentTest.log(LogStatus.PASS, "Navigated To PlantInsights", "Navigated To PlantInsights");
				else
					extentTest.log(LogStatus.FAIL, "unable to navigate to the plantinsights",
							"unable to navigate to the plantinsights");
			} catch (Exception e) {
				e.printStackTrace();

			}
		}
	}

	public void Navigate_To_SubContractor_Insights() {
		synchronized (ProductionInsight_Logic.class) {
			try {
				waitForPageToLoad();
				waitForElementTobeLocated(ProductionInsight_UI.SubContractorinsight_Header);
				doubleClick(ProductionInsight_UI.SubContractorinsight_Header);
				waitForPageToLoad();
				if (isDisplayed(ProductionInsight_UI.SubContractorinsightPageTittle))

					extentTest.log(LogStatus.PASS, "Navigated To Sub-contractor", "Navigated To Sub-contractor");
				else
					extentTest.log(LogStatus.FAIL, "unable to Navigate To Sub-contractor",
							"unable to navigate to the Sub-contractor");
			} catch (Exception e) {
				e.printStackTrace();

			}
		}
	}

	public void validate_LastUpdatedIsPresent_ProductionInsight() {
		synchronized (ProductionInsight_Logic.class) {
			boolean flag = false;
			try {
				isDisplayed(ProductionInsight_UI.ProductionSpan_LastUpdated);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
