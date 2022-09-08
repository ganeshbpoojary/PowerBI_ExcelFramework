package testlogic;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.ClickAction;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.LogStatus;

import frameworkutils.WebDriverFactory;
import uimaps.APPM_UI;
import uimaps.SPlanning_UI;

public class SPlanning_Logic extends WebDriverFactory{

	public SPlanning_Logic(WebDriver driver, Map<String, String> dataBook) {
		super(driver, dataBook);
		// TODO Auto-generated constructor stub
	}

	String filterName = dataBook.get("Fliter_Name");
	String filterOption = dataBook.get("Filter_Option");
	String chartName = dataBook.get("Chart_Name");
	String summaryHeader = dataBook.get("SummaryColumn_Header");
	String detailHeader = dataBook.get("DetailedViewColumn_Header");

	//click on the filter and validate the data
	public void validateDropDownHasData_Space() {

		synchronized (SPlanning_Logic.class) {
			try {
				
				clickonFilterandValidatethedata_Space(filterName);
				extentTest.log(LogStatus.PASS, "Drop Down Data presence validation", "Drop Down has Data");
			}				
			 catch (Exception e) {
				// TODO Auto-generated catch block
				 extentTest.log(LogStatus.FAIL, "Drop Down Data presence validation", "Drop Down has no Data");
				e.printStackTrace();
			}
		}
	}
	
	//click on the each filter and check for search button
	public void validateTheSearchButtonAndFromToFilter_Space()
	{
	synchronized (SPlanning_Logic.class) {
		try {
			
			clickonFilterandchecktheSearchButton_Space(filterName);
			extentTest.log(LogStatus.PASS, "Search Buttton is enabled", "Search Buttton has Data");
		}				
		 catch (Exception e) {
			// TODO Auto-generated catch block
			 extentTest.log(LogStatus.FAIL, "Search Buttton disabled", "Search Buttton has no Data");
			e.printStackTrace();
		}
	}
}
	
	 // check process efficiency module are displaying or not
	public void validateProcessEfficiency_Space()
	{
		synchronized (SPlanning_Logic.class) {
			try {
			waitForPageToLoad();
			waitForElementTobeLocated(SPlanning_UI.proeffPublished);
	        waitForPageToLoad();
	        isDisplayed(SPlanning_UI.proeffPublished);
	        isDisplayed(SPlanning_UI.proeffLive);
	       extentTest.log(LogStatus.PASS, "Proces efficiency details are enabled", "Proces efficiency has Data");
			}				
			 catch (Exception e) {
				// TODO Auto-generated catch block
				 extentTest.log(LogStatus.FAIL, "Proces efficiency details are disabled", "Proces efficiency has no Data");
				e.printStackTrace();
			}
		}
		  
	}

	//verify that last updated date is displaying or not 
public void validateLastUpdateData_Space()
	{
	synchronized (SPlanning_Logic.class) {
		try {
			waitForElementTobeLocated(SPlanning_UI.lasteUpdateDate);
	        waitForPageToLoad();
	        driver.findElement(SPlanning_UI.lasteUpdateDate).isDisplayed();
			extentTest.log(LogStatus.PASS, "date LastUpdated  is enabled", "date LastUpdated has Data");
		}				
		 catch (Exception e) {
			// TODO Auto-generated catch block
			 extentTest.log(LogStatus.FAIL, "date LastUpdated disabled", "date LastUpdated has no Data");
			e.printStackTrace();
		}
	}
}
	
//click on the space productivity and  validate the sales field 
	public void clickonSpaceProductivity_Space()
	{
		synchronized (SPlanning_Logic.class) {
			try {
				waitForVisibleElement(SPlanning_UI.spaceProductivity);
		        driver.findElement(SPlanning_UI.spaceProductivity).click();
		        clickOn(SPlanning_UI.spaceProductivity);
		        waitForPageToLoad();
		        isDisplayed(SPlanning_UI.sales);
		        extentTest.log(LogStatus.PASS, "SpaceProductivity button  is enabled", "SpaceProductivity has Data");
			}				
			 catch (Exception e) {
				// TODO Auto-generated catch block
				 extentTest.log(LogStatus.FAIL, "SpaceProductivity button disabled", "SpaceProductivity has no Data");
				e.printStackTrace();
			}
		}
	}
	
	//verify sales module
	public void verifysalesModule_Space()
	{
		synchronized (SPlanning_Logic.class) {
			try {
				waitForPageToLoad();
				waitForVisibleElement(SPlanning_UI.saleslinear);
				isDisplayed(SPlanning_UI.saleslinear);
				isDisplayed(SPlanning_UI.salesOthers);
				isDisplayed(SPlanning_UI.saleslinearOthers);
				extentTest.log(LogStatus.PASS, "SpaceProductivity sales  button  is enabled", "SpaceProductivity sales has Data");
			}				
			 catch (Exception e) {
				// TODO Auto-generated catch block
				 extentTest.log(LogStatus.FAIL, "SpaceProductivity button disabled", "SpaceProductivity sales has no Data");
				e.printStackTrace();
			}
		}
	}
	
	//verify unit module
	public void verifyunitsModule_Space()
	{
		synchronized (SPlanning_Logic.class) {
			try {
				waitForPageToLoad();
				waitForVisibleElement(SPlanning_UI.unitsOthers);
				 
				isDisplayed(SPlanning_UI.unitsOthers);
				isDisplayed(SPlanning_UI.unitlinear);
				isDisplayed(SPlanning_UI.unitlinearOthers);
				extentTest.log(LogStatus.PASS, "SpaceProductivity sales  button  is enabled", "SpaceProductivity sales has Data");
			}				
			 catch (Exception e) {
				// TODO Auto-generated catch block
				 extentTest.log(LogStatus.FAIL, "SpaceProductivity button disabled", "SpaceProductivity sales has no Data");
				e.printStackTrace();
			}
		}
	}
	public void verifyMarginModule_Space()
	{
		synchronized (SPlanning_Logic.class) {
			try {
				WebDriverWait wait = new WebDriverWait(driver, 20);
				waitForPageToLoad();
				//verify the Margin module
				 driver.findElement(SPlanning_UI.profit).isDisplayed();
				    driver.findElement(SPlanning_UI.profitOthers).isDisplayed();
				    driver.findElement(SPlanning_UI.marginlinear).isDisplayed();
				    driver.findElement(SPlanning_UI.marginlinearOthers).isDisplayed();
				extentTest.log(LogStatus.PASS, "MarginModule  button  is enabled", "MarginModule  has Data");
			}				
			 catch (Exception e) {
				// TODO Auto-generated catch block
				 extentTest.log(LogStatus.FAIL, "MarginModule button is disabled", "MarginModule  has no Data");
				e.printStackTrace();
			}
		}
	}
	
	 //click on on the investigate module and verify the investigate module
	public void verifyInvestigateModule_Space()
	{
		synchronized (SPlanning_Logic.class) {
			try {
				waitForPageToLoad();
				waitForVisibleElement(SPlanning_UI.unitsOthers);
				clickOn(SPlanning_UI.unitsOthers);
					waitForPageToLoad();
					jsClickOn(SPlanning_UI.investigateButton);
					 
				extentTest.log(LogStatus.PASS, "MarginModule  button  is enabled", "MarginModule  has Data");
			}				
			 catch (Exception e) {
				// TODO Auto-generated catch block
				 extentTest.log(LogStatus.FAIL, "MarginModule button is disabled", "MarginModule  has no Data");
				e.printStackTrace();
			}
		}
	}
	
	//verify the display insight page
	public void verifyDisplayInsights_Space()
	{
		synchronized (SPlanning_Logic.class) {
			try {
				waitForPageToLoad();
				waitForVisibleElement(SPlanning_UI.displayInsight);
				clickOn(SPlanning_UI.displayInsight);
				waitForPageToLoad();
				isDisplayed(SPlanning_UI.Storeinsighttable);
				extentTest.log(LogStatus.PASS, "DisplayInsights  is enabled", "DisplayInsights has Data");
			}				
			 catch (Exception e) {
				// TODO Auto-generated catch block
				 extentTest.log(LogStatus.FAIL, "DisplayInsights is disabled", "DisplayInsights  has no Data");
				e.printStackTrace();
			}
		}
	}
	//verify that scrolling the page is working 
	 public void verifyscrolling_Space()
	    {
		 synchronized (SPlanning_Logic.class) {
			 try {
				 waitForPageToLoad();
					waitForVisibleElement(SPlanning_UI.displayInsight);
					waitForPageToLoad();
					 clickOn(SPlanning_UI.displayInsight);
				        JavascriptExecutor js = (JavascriptExecutor) driver;
				        js.executeScript("window.scrollBy(0,500)", "");
				        js.executeScript("window.scrollBy(0,-500)");
					extentTest.log(LogStatus.PASS, "Scrolling is working fine ", "Scrolling is working fine");
				}				
				 catch (Exception e) {
					// TODO Auto-generated catch block
					 extentTest.log(LogStatus.FAIL, "Scrolling is not  working fine", "Scrolling is not working fine");
					e.printStackTrace();
				}
		 }
	    }
	//click on the space toggle and verify the displayed questions
	 public void verifytoggle_Space()
	    {
		 synchronized (SPlanning_Logic.class) {
				try {
					waitForPageToLoad();
					waitForVisibleElement(SPlanning_UI.spaceProductivity);
					waitForPageToLoad();
					 clickOn(SPlanning_UI.spaceProductivity);
					 clickOn(SPlanning_UI.spaceToggle);
					 isDisplayed(SPlanning_UI.toggleOffQuestions);
					extentTest.log(LogStatus.PASS, "Toggle  is enabled", "Toggle is enabled");
				}				
				 catch (Exception e) {
					// TODO Auto-generated catch block
					 extentTest.log(LogStatus.FAIL, "Toggle  is enabled", "Toggle  is enabled");
					e.printStackTrace();
				}
			}
	    }
	 
	 
	//click on the movement toggle and verify the questions 
	 public void verifyMovementtoggle_Space()
	    {
		 synchronized (SPlanning_Logic.class) {
				try {
					waitForPageToLoad();
					waitForElementTobeLocated(SPlanning_UI.movement_NPE_AE);
					clickOn(SPlanning_UI.movement_NPE_AE);
					waitForPageToLoad();
					clickOn(SPlanning_UI.spaceToggle);
					isDisplayed(SPlanning_UI.toggleOffQuestions);
			      	extentTest.log(LogStatus.PASS, " Movement tab Toggle  is enabled", "Toggle is enabled");
				}				
				 catch (Exception e) {
					// TODO Auto-generated catch block
					 extentTest.log(LogStatus.FAIL, " Movement tab Toggle  is enabled", "Toggle  is enabled");
					e.printStackTrace();
				}
			}
	    }
	//click on the capacity Demand toggle and verify the questions 
	 public void verifyCapacityDemandtoggle_Space()
	    {
		 synchronized (SPlanning_Logic.class) {
				try {
					waitForPageToLoad();
					waitForElementTobeLocated(SPlanning_UI.chart_CapacityDemand);
					waitForPageToLoad();
					clickOn(SPlanning_UI.spaceToggle);
					isDisplayed(SPlanning_UI.toggleOffQuestions);
					extentTest.log(LogStatus.PASS, " CapacityDemand Toggle  is enabled", " CapacityDemand Toggle is enabled");
				}				
				 catch (Exception e) {
					// TODO Auto-generated catch block
					 extentTest.log(LogStatus.FAIL, " CapacityDemand Toggle  is disabled", "CapacityDemand Toggle  is disabled");
					e.printStackTrace();
				}
			}
	    }
	//click on the inventory toggle and verify the questions
	 public void verifyInventoryTurnsToggle_Space()
	 {
		 synchronized (SPlanning_Logic.class) {
			try {
				waitForPageToLoad();
				waitForElementTobeLocated(SPlanning_UI.lnk_InventoryTurns);
				waitForPageToLoad();
				clickOn(SPlanning_UI.lnk_InventoryTurns);
				clickOn(SPlanning_UI.spaceToggle);
				isDisplayed(SPlanning_UI.toggleOffQuestions);
				extentTest.log(LogStatus.PASS, " InventoryTurnsToggle  is enabled", " InventoryTurns Toggle is enabled");
			}				
			 catch (Exception e) {
				// TODO Auto-generated catch block
				extentTest.log(LogStatus.FAIL, " InventoryTurnsToggle  is disabled", "InventoryTurnsToggle  is disabled");
				e.printStackTrace();
			}
		}
		 
		 
	 }
	//Bar graph section
	 public void validate_CapacityDemand_Chart_Space()
	 {
		 synchronized (SPlanning_Logic.class) {
				try {
					waitForPageToLoad();
					waitForElementTobeLocated(SPlanning_UI.lnk_CapacityDemand);
					waitForElementTobeLocated(SPlanning_UI.chart_CapacityDemand);
					List<WebElement> chartElm = driver.findElements(SPlanning_UI.chart_CapacityDemand);
			        if (chartElm.size() > 0) {
			        	isDisplayed(SPlanning_UI.chart_CapacityDemand);
			            extentTest.log(LogStatus.PASS, " CapacityDemand_Chart  is enabled", "CapacityDemand_Chart is enabled");
			        }
			        return ;
					
				}				
				 catch (Exception e) {
					// TODO Auto-generated catch block
					 extentTest.log(LogStatus.FAIL, " CapacityDemand_Chart  is disabled", "CapacityDemand_Chart  is enabled");
					e.printStackTrace();
				}
			}
	 }
	 
	//Rest Calendar Card visible validation
	 public void validate_CapacityDemand_ResetCalendarChart_Space()
	 {
		 synchronized (SPlanning_Logic.class) {
				try {
					waitForPageToLoad();
					waitForElementTobeLocated(SPlanning_UI.lnk_CapacityDemand);
					clickOn(SPlanning_UI.lnk_CapacityDemand);
			       waitForElementTobeLocated(SPlanning_UI.chart_ResetCalender);        
			        List<WebElement> restChart = driver.findElements(SPlanning_UI.chart_ResetCalender);
			        if (restChart.size() > 0) {
			        	isDisplayed(SPlanning_UI.chart_ResetCalender);
			            extentTest.log(LogStatus.PASS, "CapacityDemand_ResetCalendarChart is enabled", "CapacityDemand_ResetCalendarChart is enabled");
			        }
			        return;
					
				}				
				 catch (Exception e) {
					// TODO Auto-generated catch block
					 extentTest.log(LogStatus.FAIL, "CapacityDemand_ResetCalendarChart is disabled", "CapacityDemand_ResetCalendarChart  is enabled");
					e.printStackTrace();
				}
			}
		 
	 }
	 
	
    //Verify the ResetCalender
    public void verifyResetCalender_Space() {
    synchronized (SPlanning_Logic.class) {
		try {
			waitForPageToLoad();
			waitForElementTobeLocated(SPlanning_UI.resetCalenderbutton);
			clickOn(SPlanning_UI.resetCalenderbutton);
			isDisplayed(SPlanning_UI.resetStatus);
         List<WebElement> restChart = driver.findElements(SPlanning_UI.chart_ResetCalender);
        if (restChart.size() > 0) {
            return;
        }
		}	
		 catch (Exception e) {
			// TODO Auto-generated catch block
			 extentTest.log(LogStatus.FAIL, "Search Buttton disabled", "Drop Down has no Data");
			e.printStackTrace();
		}
	}
		  
}   
    
    
  //verify the planogram status
    public void verifyPlanogramStatus_Space()
	{
		synchronized (SPlanning_Logic.class) {
			try {
				waitForPageToLoad();
				waitForElementTobeLocated(SPlanning_UI.plstatusASO);
				isDisplayed(SPlanning_UI.plstatusASO);
				isDisplayed(SPlanning_UI.plstatusSO);
				isDisplayed(SPlanning_UI.plstatusPending);
				isDisplayed(SPlanning_UI.plstatusLive);
	         List<WebElement> chart = driver.findElements(SPlanning_UI.planogramchart);
	        if( chart.size()>0)
	        {
	        	return;
	        	
	        }
	        
			}				
			 catch (Exception e) {
				// TODO Auto-generated catch block
				 extentTest.log(LogStatus.FAIL, "Planogram disabled", "Planogram no Data");
				e.printStackTrace();
			}
		}
		  
	}
  //verify the movement tab
    public void verifymovementtab_Space()
	{
		synchronized (SPlanning_Logic.class) {
			try {
				waitForPageToLoad();
				waitForElementTobeLocated(SPlanning_UI.movement_NPE_AE);
	            clickOn(SPlanning_UI.movement_NPE_AE);
		        waitForPageToLoad();
		        isDisplayed(SPlanning_UI.MovementAEChart);
		        isDisplayed(SPlanning_UI.MovementNPIChart);
	        extentTest.log(LogStatus.PASS, "movement tab is enabled", "movement tab is enabled");
			}				
			 catch (Exception e) {
				// TODO Auto-generated catch block
				 extentTest.log(LogStatus.FAIL, "movement tab is disabled", "movement tab has no Data");
				e.printStackTrace();
			}
		}
		  
	}
    
    //Inventory Turns Card visible validation
    public void validate_InventoryTurns_Chart_Space()
    {
    	synchronized (SPlanning_Logic.class) {
			try {
				waitForPageToLoad();
				waitForElementTobeLocated(SPlanning_UI.lnk_InventoryTurns);
				clickOn(SPlanning_UI.lnk_InventoryTurns);
				waitForPageToLoad();
				waitForElementTobeLocated(SPlanning_UI.chart_InventoryTurns);
	            List<WebElement> chartElm = driver.findElements(SPlanning_UI.chart_InventoryTurns);
	        if (chartElm.size() > 0) {
	        	isDisplayed(SPlanning_UI.chart_InventoryTurns);
	            extentTest.log(LogStatus.PASS, "InventoryTurns_Chart is enabled", "InventoryTurns_Chart is enabled");
	        }
	        return;
	        
			}				
			 catch (Exception e) {
				// TODO Auto-generated catch block
				 extentTest.log(LogStatus.FAIL, "InventoryTurns_Chart is disabled", "InventoryTurns_Chart has no Data");
				e.printStackTrace();
			}
		}
    	
    	   	
    }
    
    //Inventory Turns Card visible validation and bulb icon
    public void validate_InventoryTurns_BulbIcon_Space()
	{
    	synchronized (SPlanning_Logic.class) {
			try {
				waitForPageToLoad();
				waitForVisibleElement(SPlanning_UI.lnk_InventoryTurns);
				clickOn(SPlanning_UI.lnk_InventoryTurns);
				waitForPageToLoad();
				waitForElementTobeLocated(SPlanning_UI.label_InventoryTurns);
				waitForElementTobeLocated(SPlanning_UI.bulb_DisplayInsights);
	        clickOn(SPlanning_UI.bulb_DisplayInsights);     
	        waitForPageToLoad();
	        waitForElementTobeLocated(SPlanning_UI.btn_DisplayInsightsBackButton);
	        List<WebElement> rows = driver.findElements(SPlanning_UI.opt_DisplayInsightsRows);
	        if (rows.size()>1){
	            rows.size();
	            extentTest.log(LogStatus.PASS, "Inventorytable is enabled", "Inventorytable is enabled");
	        }
	        return ;
	        			}				
			 catch (Exception e) {
				// TODO Auto-generated catch block
				 extentTest.log(LogStatus.FAIL, "Inventorytable is disabled", "Inventorytable has no Data");
				e.printStackTrace();
			}
		}
		
	}
    
    public void verifyAlertandMorePage_Space()
    {
    	synchronized (SPlanning_Logic.class) {
			try {
				waitForPageToLoad();
				waitForVisibleElement(SPlanning_UI.alertMorebutton);
				waitForPageToLoad();
//				clickOn(SPlanning_UI.alertMorebutton);
				jsClickOn(SPlanning_UI.alertMorebutton);
				isDisplayed(SPlanning_UI.alertSubCategory);
				List<WebElement> Alerttable = driver.findElements(SPlanning_UI.alertSubCategory);
				if(Alerttable.size()>1)
				{
					return;
				}
				
	
		        
		       extentTest.log(LogStatus.PASS, "Alert and details page   is enabled", " Alert and details page  is enabled");
			}				
			 catch (Exception e) {
				// TODO Auto-generated catch block
				 extentTest.log(LogStatus.FAIL, " Alert and details page   is disabled", "Alert and details page   is disabled");
				e.printStackTrace();
			}
		}
    	
    }
    
	
	
	
		
		
	
	public void clickonFilterandValidatethedata_Space(String Filtername)
    {

        driver.findElement(By.xpath("//*[@aria-label='"+Filtername+" ']//ancestor::div[contains(@class,'slicer-container')]//div[@class='slicer-dropdown-menu']")).click();
        waitForPageToLoad();
        List<WebElement> checkboxes = driver.findElements(By.xpath("//*[@class='slicerText']"));
        if (checkboxes.size()>0) {
            driver.findElement(By.xpath("//*[@aria-label='"+Filtername+" ']//ancestor::div[contains(@class,'slicer-container')]//div[@class='slicer-dropdown-menu']")).click();
        }

    }
	
	public void clickonFilterandchecktheSearchButton_Space(String Filtername)
    {

        driver.findElement(By.xpath("//*[@aria-label='"+Filtername+" ']//ancestor::div[contains(@class,'slicer-container')]//div[@class='slicer-dropdown-menu']")).click();
        waitForPageToLoad();
        driver.findElement(By.xpath("//input[@aria-label='Search']")).isEnabled();
       
        }

    

}


