package uimaps;

import org.openqa.selenium.By;

public class AnamolyDetection_UI {
	
	public static final By AnamolyBusinessMeasureDropdown=By.xpath("");
	public static final By AnamolyPriorityMeasureDropdown = By.xpath("");
	                                                        //input[@aria-label='Search']//ancestor::div[@class='slicer-dropdown-content']//div[@class='slicerBody']//div[@class='row']
	public static final By AnamolyFromMeasureDropdown = By.xpath("");
	public static final By AnamolyToMeasureDropdown = By.xpath("");
	public static final By opt_dropDownRowsData = By.xpath("//input[@aria-label='Search']//ancestor::div[@class='slicer-dropdown-content']//div[@class='slicerBody']//div[@class='row']");
	public static final By anamolySearch = By.xpath("(//*[@aria-label='Search'])[3]");
	public static final By dd_SelectAll_option=By.xpath("//input[@aria-label='Search']//ancestor::div[@class='slicer-dropdown-content']//*[text()='Select all']//ancestor::div[@class='slicerItemContainer']");
	public static final By outlierItemStore=By.xpath("//span[contains(text(),'Outlier Item Stores')]");
	public static final By outlierUnits=By.xpath("//span[contains(text(),'Outlier Units')]");
	public static final By outlierSales =By.xpath("//span[contains(text(),'Outlier Sales ($)')]");
	public static final By outlierTransactions=By.xpath("//span[contains(text(),'Outlier Transactions')]");
	public static final By understandButton=By.xpath("(//*[contains(text(),'Understand')])[1]");
	public static final By drillThrough=By.xpath("//*[contains(text(),'Drill through')]");
	public static final By drillThroughUnderstand=By.xpath("//*[contains(text(),'Drill through')]");
	public static final By table_Understand=By.xpath("//div[@class='visual visual-tableEx allow-deferred-rendering']");

	
	public static final  By btn_Understand = By.xpath("//*[contains(@aria-label,'DrillDownMeasure Understand')]/..");
	public static final  By navBtn_DrillThrough = By.xpath("//button[@title='Drill through']");
	public static final  By navBtn_Understand = By.xpath("//button[@title='Understand']");
	public static final  By navBtn_Investigate = By.xpath("//button[@title='Investigate']");
	public static final  By navBtn_PricePromotionsPLC = By.xpath("//button[@title='Price, Promotions, PLC & Inventory']");	
	public static final  By title_Understand = By.xpath("//div[text()='Understand']//ancestor::div[@class='contentTable']");
	public static final  By title_Investigate = By.xpath("//div[text()='Investigate']//ancestor::div[@class='contentTable']");	
	public static final  By table_UnderStand_ColumnCount = By.xpath("//div[@role='presentation']//div[@role='columnheader']");
	public static final  By exploraryOutlierItemStores = By.xpath("//*[@class='y axis hideLinesOnAxis setFocusRing']//ancestor::div//*[@data-sub-selection-object-name=\"data-labels\"]");
	public static final  By exploraryOutlierItemStoresText = By.xpath("//*[@data-sub-selection-display-name='Visual_Axis_Title']");
	
	
	public static final  By Importance_forecastability_rowheader = By.xpath("//div[@class='rowHeaders']//ancestor::div[@class='pivotTableCellWrap cell-interactive tablixAlignCenter ']");
	public static final  By Importance_forecastability_coloumnheader=By.xpath("(//div[@class='innerContainer']//ancestor::div[@class='columnHeaders'])[2]");
	
	
	
	public static final  By table_UnderStand_RowCount = By.xpath("(//div[@role='row'])");	
	public static final  By span_OutlierInvestigationReportForItem = By.xpath("//span[contains(text(),'Outlier investigation report for Item')]");
	public static final  By span_AndStore = By.xpath("//span[contains(text(),'and Store')]");	
	public static final  By span_FirstITEM = By.xpath("//*[contains(@aria-label,'First ITEM')]");
	public static final  By span_FirstLOCATION = By.xpath("//*[contains(@aria-label,'First LOCATION')]");	
	public static final  By tableHeader_Investigate_option = By.xpath("(//div[@class='columnHeaders'])[2]//div[contains(@class,'pivotTableCellNoWrap cell-interactive')]");
	public static final  By table_OutlierInvestigation_option = By.xpath("((//div[@class='bodyCells'])[2]//div[contains(@class,'pivotTableCellWrap')])");
	public static final  By contextMenu_Option = By.xpath("//*[@role='menu']//button[@role='menuitem']");
	public static final  By contextMenu = By.xpath("//*[@role='menu']");	
	public static final  By btn_BusniessImpact = By.xpath("(//div[contains(@class,'pivotTableCellNoWrap')])[4]/..");
	
	public static final  By chart_OutlierInvestigation  = By.xpath("((//span[contains(text(),'Trend and Residual')]//ancestor::*[@class='ng-star-inserted'])[4]//*[@class='lineChartSVG']//*[@role='listbox'])[1]");	
	public static final By chart_OutlierInvestigation_option=By.xpath("((//*[@class='lineChartSVG']//*[@role='listbox'])[1]//*[@class='interactivity-line sub-selectable'])[2]");
	
	public static final  By chart_SeasonalityTrendResidual  = By.xpath("((//span[contains(text(),'Trend and Residual')]//ancestor::*[@class='ng-star-inserted'])[4]//*[@class='lineChartSVG']//*[@role='listbox'])[2]");	
	public static final By chart_SeasonalityTrendResidual_option=By.xpath("((//*[@class='lineChartSVG']//*[@role='listbox'])[2]//*[@class='interactivity-line sub-selectable'])[2]");
	
	public static final  By chart_InterPlayBtnSales  = By.xpath("//*[@class='ng-star-inserted']//*[@class='lineChartSVG']//*[@role='listbox']");	
	public static final By chart_InterPlayBtnSales_option=By.xpath("(//*[@class='ng-star-inserted']//*[@class='lineChartSVG']//*[@role='listbox']//*[@class='interactivity-line sub-selectable'])[2]");
	
	public static final By chart_popupText=By.xpath("//div[@id='screen_reader_alert_assertive']");
	public static final By dd_InsightsFor=By.xpath("(//div[@aria-label='DATE'])[1]");
	
	public static final By dd_InsightsFor_Option=By.xpath("//ancestor::div[@class='slicer-dropdown-content']//div[@class='slicerBody']//div[@class='row']");
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	

	

	
	


	
}


