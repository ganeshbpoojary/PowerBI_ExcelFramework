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
import uimaps.AnamolyDetection_UI;
import uimaps.RPCC_Supply_UI;

public class RPCC_Supply_Logic extends WebDriverFactory {

	public RPCC_Supply_Logic(WebDriver driver, Map<String, String> dataBook) {
		super(driver, dataBook);
		// TODO Auto-generated constructor stub
	}
	String filterName = dataBook.get("Fliter_Name");
	String filterOption = dataBook.get("Filter_Option");
	
	
	public void Navigate_RPCC_OutOfStock() {
		synchronized (RPCC_Supply_Logic.class) {
			try {
				waitForPageToLoad();
				waitForElementTobeClickable(RPCC_Supply_UI.navBtn_OutOfStock);
					waitForElementTobeLocated(RPCC_Supply_UI.navBtn_OutOfStock);
					if(clickOn(RPCC_Supply_UI.navBtn_OutOfStock))
						extentTest.log(LogStatus.PASS, "Navigated RPCC_OutOfStock", "Navigated RPCC_OutOfStock ");
					else
						extentTest.log(LogStatus.FAIL, "Unable to navigate to the RPCC out to stock", "Unable to navigate to the RPCC out to stock");
						
				}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	//Navigate to underStock
	public void Navigate_RPCC_UnderStock() {
		synchronized (RPCC_Supply_Logic.class) {
			try {
				waitForPageToLoad();
//				waitForElementTobeClickable(RPCC_Supply_UI.navBtn_understock);
					waitForElementTobeLocated(RPCC_Supply_UI.navBtn_understock);
					if(clickOn(RPCC_Supply_UI.navBtn_understock))
						extentTest.log(LogStatus.PASS, "Navigated RPCC_UnderStock", "Navigated RPCC_UnderStock");
					else
						extentTest.log(LogStatus.FAIL, "Unable to navigate to the RPCC UnderStock", "Unable to navigate to the RPCC UnderStock");
						
				}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	//Navigate to Excess stock
		public void Navigate_RPCC_ExcessStock() {
			synchronized (RPCC_Supply_Logic.class) {
				try {
					waitForPageToLoad();
//					waitForElementTobeClickable(RPCC_Supply_UI.navBtn_excessStock);
						waitForElementTobeLocated(RPCC_Supply_UI.navBtn_excessStock);
						if(clickOn(RPCC_Supply_UI.navBtn_excessStock))
							extentTest.log(LogStatus.PASS, "Navigated RPCC_ExcessStock", "Navigated RPCC_ExcessStock ");
						else
							extentTest.log(LogStatus.FAIL, "Unable to navigate to the RPCC Excess stock", "Unable to navigate to the RPCCExcessStock");
							
					}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	
	//
	public void validate_DropDownHasData_RPCC_Supply() {
		synchronized (RPCC_Supply_Logic.class) {
			try {
				By optCount = By
						.xpath("//div[@role='combobox' and @aria-label='"+filterName+"']//div[@class='slicer-restatement']/../..");
				if (clickOn(optCount))
					extentTest.log(LogStatus.PASS, "Drop Down should have data",
							"Drop Down has number of rows");
				else
					extentTest.log(LogStatus.FAIL, "Drop Down should have data", "Drop Down has no Data");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void validateValueInDropDown_RPCC_Supply() {
		synchronized (RPCC_Supply_Logic.class) {
			try {
				checkDropDownForOption_RPCC_Supply(filterOption);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	// check dropdown option in the dropdown list
		private boolean checkDropDownForOption_RPCC_Supply(String opt) {
			waitForPageToLoad();
			int rows = getFilterDropDownRowCount_RPCC_Supply();
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
		private int getFilterDropDownRowCount_RPCC_Supply() {
			WebDriverWait wait = new WebDriverWait(driver, 1200);
			wait.until(ExpectedConditions.visibilityOfElementLocated(RPCC_Supply_UI.opt_dropDownRowsData));
			try {
				List<WebElement> rows = driver.findElements(RPCC_Supply_UI.opt_dropDownRowsData);
				int size = rows.size();
				extentTest.log(LogStatus.INFO, "getDropDownRowCount: ", "Number of rows is- <B>[" + size + "]</B>");
				return size;
			} catch (NoSuchElementException nsex) {
				return -1;
			}
		}
		
		public void validate_NeedsAttention_DrillThrough_OutOfScope_RPCC_Supply() {
			synchronized (RPCC_Supply_Logic.class) {
				boolean flag = false;
				try {
					waitForPageToLoad();
					waitForElementTobeClickable(RPCC_Supply_UI.btn_NeedsAttention);
					actionClick(RPCC_Supply_UI.btn_NeedsAttention);
					waitForElementTobeLocated(RPCC_Supply_UI.table_AttentionReview);
					isDisplayed(RPCC_Supply_UI.table_AttentionReview);

					rightClick(RPCC_Supply_UI.table_AttentionReview_Options);
					waitForElementTobeClickable(RPCC_Supply_UI.navBtn_DrillThrough);
					clickOn(RPCC_Supply_UI.navBtn_DrillThrough);
					waitForElementTobeClickable(RPCC_Supply_UI.navBtn_Understand);
					clickOn(RPCC_Supply_UI.navBtn_Understand);
					waitForElementTobeLocated(RPCC_Supply_UI.title_Understand);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		public void validate_NeedsAttention_DrillThrough_UnderScope_RPCC_Supply() {
			synchronized (RPCC_Supply_Logic.class) {
				boolean flag = false;
				try {
					waitForPageToLoad();
					waitForElementTobeClickable(RPCC_Supply_UI.btn_NeedsAttention);
//					actionClick(RPCC_Supply_UI.btn_NeedsAttention);
					waitForElementTobeLocated(RPCC_Supply_UI.table_AttentionReview);
					isDisplayed(RPCC_Supply_UI.table_AttentionReview);

					rightClick(RPCC_Supply_UI.table_UnderStock_AttentionReview_Options);
					waitForElementTobeClickable(RPCC_Supply_UI.navBtn_DrillThrough);
					clickOn(RPCC_Supply_UI.navBtn_DrillThrough);
					waitForElementTobeClickable(RPCC_Supply_UI.drill_Understand);
					clickOn(RPCC_Supply_UI.drill_Understand);
					waitForElementTobeLocated(RPCC_Supply_UI.title_Understand);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		public void validate_NeedsReview_DrillThrough_RPCC_Supply() {
			synchronized (RPCC_Supply_Logic.class) {
				boolean flag = false;
				try {
					waitForPageToLoad();
					waitForElementTobeClickable(RPCC_Supply_UI.btn_NeedsReview);
					actionClick(RPCC_Supply_UI.btn_NeedsReview);
					waitForElementTobeLocated(RPCC_Supply_UI.table_AttentionReview);
					isDisplayed(RPCC_Supply_UI.table_AttentionReview);

					rightClick(RPCC_Supply_UI.table_AttentionReview_Options);
					waitForElementTobeClickable(RPCC_Supply_UI.navBtn_DrillThrough);
					clickOn(RPCC_Supply_UI.navBtn_DrillThrough);
					waitForElementTobeClickable(RPCC_Supply_UI.navBtn_Understand);
					clickOn(RPCC_Supply_UI.navBtn_Understand);
					waitForElementTobeLocated(RPCC_Supply_UI.title_Understand);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		public void validate_OutofScopeByClassAndDaily_MixOutOfScope() {
			synchronized (RPCC_Supply_Logic.class) {
				boolean flag = false;
				try {
					waitForPageToLoad();	
					isDisplayed(RPCC_Supply_UI.graph_dailymixItemOutOfStock);
					isDisplayed(RPCC_Supply_UI.chart_ItemOutOfStock);
					isDisplayed(RPCC_Supply_UI.chart_ItemOutOfStock_Location);
					 
					int graphnum= getElementsCount(RPCC_Supply_UI.graph_dailymixItemOutOfStock);
					int chartItem=getElementsCount(RPCC_Supply_UI.chart_ItemOutOfStock);
					int tablecount=getElementsCount(RPCC_Supply_UI.chart_ItemOutOfStock_Location);
					
					if(graphnum>0&&chartItem>0&&tablecount>0)
							extentTest.log(LogStatus.PASS, "Out of scope and MixOutOfScope has data",
								"Out of scope and MixOutOfScope has data");
					else
						extentTest.log(LogStatus.FAIL, "Out of scope and MixOutOfScope has no data",
								"Out of scope and MixOutOfScope has no data");				
					
							} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		public void validate_ExcessBookClassAndDaily_RPCC_Supply() {
			synchronized (RPCC_Supply_Logic.class) {
				boolean flag = false;
				try {
					waitForPageToLoad();	
					isDisplayed(RPCC_Supply_UI.graph_dailymixItemOutOfStock);
					isDisplayed(RPCC_Supply_UI.chart_ItemOutOfStock);
					isDisplayed(RPCC_Supply_UI.chart_ItemOutOfStock_Location);
					 
					int graphnum= getElementsCount(RPCC_Supply_UI.graph_dailymixItemOutOfStock);
					int chartItem=getElementsCount(RPCC_Supply_UI.chart_ItemOutOfStock);
					int tablecount=getElementsCount(RPCC_Supply_UI.chart_ItemOutOfStock_Location);
					
					if(graphnum>0&&chartItem>0&&tablecount>0)
							extentTest.log(LogStatus.PASS, "Out of scope and MixOutOfScope has data",
								"Out of scope and MixOutOfScope has data");
					else
						extentTest.log(LogStatus.FAIL, "Out of scope and MixOutOfScope has no data",
								"Out of scope and MixOutOfScope has no data");				
					
							} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		public void goto_UnderstandPage_RPCC_Supply() {
			synchronized (RPCC_Supply_Logic.class) {
				try {
					waitForPageToLoad();
					waitForElementTobeClickable(RPCC_Supply_UI.navBtn_Understand);
					rightClick(RPCC_Supply_UI.navBtn_Understand);
					waitForElementTobeClickable(RPCC_Supply_UI.navBtn_DrillThrough);
					clickOn(AnamolyDetection_UI.navBtn_DrillThrough);
					waitForElementTobeClickable(RPCC_Supply_UI.drill_Understand);
					clickOn(RPCC_Supply_UI.drill_Understand);
					waitForElementTobeLocated(RPCC_Supply_UI.understandpage_title);
					if (isDisplayed(RPCC_Supply_UI.understandpage_title))
						extentTest.log(LogStatus.PASS, "Navigates to Understand Page", "Navigated to Understand Page");
					else
						extentTest.log(LogStatus.FAIL, "Navigates to Understand Page",
								"Did not navigate to Understand Page");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		public void outOfScopeAnadNavigateToUnderstand_RPCC_Supply() {
			synchronized (RPCC_Supply_Logic.class) {
				try {
					waitForPageToLoad();
					waitForElementTobeClickable(RPCC_Supply_UI.outOfStockItem);
					rightClick(RPCC_Supply_UI.outOfStockItem);
					waitForElementTobeClickable(RPCC_Supply_UI.navBtn_DrillThrough);
					clickOn(RPCC_Supply_UI.navBtn_DrillThrough);
					waitForElementTobeClickable(RPCC_Supply_UI.drill_Understand);
					clickOn(RPCC_Supply_UI.drill_Understand);
					waitForPageToLoad();
//					waitForElementTobeLocated(RPCC_Supply_UI.understandpage_title);
					if (isDisplayed(RPCC_Supply_UI.understandpage_title))
						extentTest.log(LogStatus.PASS, "Navigates to Understand Page through out of scope", "Navigated to Understand Page through out of scope");
					else
						extentTest.log(LogStatus.FAIL, "Navigates to Understand Page through out of scope",
								"Did not navigate to Understand Page through out of scope");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		public void resetButtonWorking_RPCC_Supply() {
			synchronized (RPCC_Supply_Logic.class) {
				try {
					waitForPageToLoad();
					waitForElementTobeClickable(RPCC_Supply_UI.resetLogo);
					clickOn(RPCC_Supply_UI.resetLogo);
					waitForElementTobeClickable(RPCC_Supply_UI.resetButton);
					clickOn(RPCC_Supply_UI.resetButton);
					waitForElementTobeClickable(RPCC_Supply_UI.underStockchartafterReset);
//					waitForElementTobeLocated(RPCC_Supply_UI.outOfScopechartafterReset);
					if(isDisplayed(RPCC_Supply_UI.underStockchartafterReset))
					
						extentTest.log(LogStatus.PASS, "reset button is working", "reset button is working");
					else
						extentTest.log(LogStatus.FAIL, "reset button is not working",
								"reset button is not working");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		public boolean checkPlayBookButtonIsWorkingOrNot_RPCC_Supply() {
			synchronized (RPCC_Supply_Logic.class) {
				try {
					waitForPageToLoad();
					waitForElementTobeClickable(RPCC_Supply_UI.playBook);
					clickOn(RPCC_Supply_UI.playBook);
					if(isDisplayed(RPCC_Supply_UI.playBookPage_Tittle )&&
					isDisplayed(RPCC_Supply_UI.playBookStock_Status))
					
					
						extentTest.log(LogStatus.PASS, "reset button is working", "reset button is working");
					else
						extentTest.log(LogStatus.FAIL, "reset button is not working",
								"reset button is not working");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return false;
		}
		
		public void checkAnalyseInventory_RPCC_Supply() {
			synchronized (RPCC_Supply_Logic.class) {
				try {
					waitForPageToLoad();
					waitForElementTobeClickable(RPCC_Supply_UI.resetLogo);
					clickOn(RPCC_Supply_UI.resetLogo);
					waitForElementTobeClickable(RPCC_Supply_UI.resetButton);
					clickOn(RPCC_Supply_UI.resetButton);
					waitForElementTobeClickable(RPCC_Supply_UI.outOfStockchartafterReset);
//					waitForElementTobeLocated(RPCC_Supply_UI.outOfScopechartafterReset);
					if(isDisplayed(RPCC_Supply_UI.outOfStockchartafterReset))
					
						extentTest.log(LogStatus.PASS, "reset button is working", "reset button is working");
					else
						extentTest.log(LogStatus.FAIL, "reset button is not working",
								"reset button is not working");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		public void validate_CompositScoreHasValue_RPCC_Supply() {
			synchronized (RPCC_Supply_Logic.class) {
				try {
					waitForPageToLoad();
					waitForElementTobeClickable(RPCC_Supply_UI.suply_CompositeScore);
					clickOn(RPCC_Supply_UI.suply_CompositeScore);
					int size = getElementsCount(RPCC_Supply_UI.suply_CompositeScore);
					if(size>0)					

						extentTest.log(LogStatus.PASS, "CompositScore Has Value", "CompositScore Has Value");
					else
						extentTest.log(LogStatus.FAIL, "CompositScore has no value",
								"CompositScore has no value");
										
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		public void validate_AnalyzeInventoryButtonIsWorking_RPCC_Supply() {
			synchronized (RPCC_Supply_Logic.class) {
				try {
					waitForPageToLoad();
					waitForElementTobeClickable(RPCC_Supply_UI.analyze_Inventory);
					actionClick(RPCC_Supply_UI.analyze_Inventory);
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
		
		public void validate_LastUpdatedIsPresent_RPCC_Supply() {
			synchronized (RPCC_Supply_Logic.class) {
				boolean flag = false;
				try {
					isDisplayed(RPCC_Supply_UI.supplySpan_LastUpdated);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		// validate From filter has data
		public void validate_Understand_FilterFromWeekHasData_RPCC_Supply() {
			synchronized (RPCC_Supply_Logic.class) {
				try {
					waitForPageToLoad();
					waitForElementTobeClickable(RPCC_Supply_UI.dd_FromWeek);
					clickOn(RPCC_Supply_UI.dd_FromWeek);
					waitForElementTobeClickable(RPCC_Supply_UI.dd_FromWeek_Options);
					if (getElementsCount(RPCC_Supply_UI.dd_FromWeek_Options) > 0)
						extentTest.log(LogStatus.PASS, "Drop Down should have data", "Drop Down has <B>["
								+ getElementsCount(RPCC_Supply_UI.dd_FromWeek_Options) + "]</B> number of rows");
					else
						extentTest.log(LogStatus.FAIL, "Drop Down should have data", "Drop Down has no Data");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		// validate To filter has data
		public void validate_Understand_FilterToWeekHasData_RPCC_Supply() {
			synchronized (RPCC_Supply_Logic.class) {
				try {
					waitForPageToLoad();
					waitForElementTobeClickable(RPCC_Supply_UI.dd_ToWeek);
					clickOn(RPCC_Supply_UI.dd_ToWeek);
					waitForElementTobeClickable(RPCC_Supply_UI.dd_ToWeek_Options);
					if (getElementsCount(RPCC_Supply_UI.dd_ToWeek_Options) > 0)
						extentTest.log(LogStatus.PASS, "Drop Down should have data", "Drop Down has <B>["
								+ getElementsCount(RPCC_Supply_UI.dd_ToWeek_Options) + "]</B> number of rows");
					else
						extentTest.log(LogStatus.FAIL, "Drop Down should have data", "Drop Down has no Data");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		public void validate_ItemScoreTableHasDrillTrough_RPCC_Supply() {
			synchronized (RPCC_Supply_Logic.class) {
				try {
					waitForPageToLoad();
						By elm = By.xpath(
								"((//div[@role='columnheader' and text()='Item Store'])[1]//ancestor::div[@class='innerContainer']//div[contains(@class,'pivotTableCellWrap cell-interactive') or contains(@class,'cell-interactive')])[7]");					
							rightClick(elm);
							isDisplayed(RPCC_Supply_UI.contextMenu_Supply);
							clickOn(RPCC_Supply_UI.drillThrough);
										waitForElementTobeClickable(RPCC_Supply_UI.navBtn_Analyze_Supply);
									if(clickOn(RPCC_Supply_UI.navBtn_Analyze_Supply))
																	extentTest.log(LogStatus.PASS, "Table should have Drill through", "Table is having Drill through");
								
							
							else
									extentTest.log(LogStatus.FAIL, "Table should have Drill through", "Table is not having Drill through");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		public void validate_ExcessStockHasDrillTrough_RPCC_Supply() {
			synchronized (RPCC_Supply_Logic.class) {
				try {
					waitForPageToLoad();
						By elm = By.xpath(
								"//*[@class='parentGroup treemapNode setFocusRing'][1]");					
							rightClick(elm);
							isDisplayed(RPCC_Supply_UI.contextMenu_Supply);
							clickOn(RPCC_Supply_UI.drillThrough);
										waitForElementTobeClickable(RPCC_Supply_UI.drill_Understand);
									clickOn(RPCC_Supply_UI.drill_Understand);
									if (isDisplayed(RPCC_Supply_UI.understandpage_title))
																	extentTest.log(LogStatus.PASS, "Table should have Drill through", "Table is having Drill through");
								
							
							else
									extentTest.log(LogStatus.FAIL, "Table should have Drill through", "Table is not having Drill through");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		public void validate_UnderstockInstanceTableHasDrillTrough_RPCC_Supply() {
			synchronized (RPCC_Supply_Logic.class) {
				try {
					waitForPageToLoad();
						By elm = By.xpath("//*[@class='pivotTableContainer']//ancestor::div[@class='rowHeaders']");					
							rightClick(elm);
							isDisplayed(RPCC_Supply_UI.contextMenu_Supply);
							clickOn(RPCC_Supply_UI.drillThrough);
										waitForElementTobeClickable(RPCC_Supply_UI.navBtn_Analyze_Supply);
									if(clickOn(RPCC_Supply_UI.navBtn_Analyze_Supply))
																	extentTest.log(LogStatus.PASS, "Table should have Drill through", "Table is having Drill through");
								
							
							else
									extentTest.log(LogStatus.FAIL, "Table should have Drill through", "Table is not having Drill through");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		public void validate_ToDropDownHasData_RPCC_Supply() {
			synchronized (RPCC_Supply_Logic.class) {
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
		
		
	
		
		
	
	
}
