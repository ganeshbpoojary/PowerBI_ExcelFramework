package uimaps;

import org.openqa.selenium.By;

public class RPCC_Demand_UI {
	
	public static final By treeMap_Product=By.xpath("(//*[@class='treemap'])[1]");
	public static final By treeMap_Product_Options=By.xpath("(//*[@class='treemap'])[1]//*[@class='parentGroup treemapNode setFocusRing']");	
	public static final By treeMap_Location=By.xpath("(//*[@class='treemap'])[2]");
	public static final By treeMap_Location_Options=By.xpath("(//*[@class='treemap'])[2]//*[@class='parentGroup treemapNode setFocusRing']");
	public static final By link_Title = By.xpath("(//*[@class='tileSVG'])[1]");
	public static final By navBtn_DrillThrough = By.xpath("//button[@title='Drill through']");
	public static final By navBtn_Understand = By.xpath("//button[@title='Understand']");
	public static final By navBtn_ReviewOutOfStock = By.xpath("//button[contains(@title,'Review Out-Of-Stock')]");
	public static final By navBtn_ReviewUnderStock = By.xpath("//button[contains(@title,'Review Under Stock')]");
	public static final By navBtn_Analyze = By.xpath("//button[contains(@title,'Analyze')]");
	public static final By chart_ForecastTrends = By.xpath("(//*[@class='columnChartUnclippedGraphicsContext'])[6]//*[@class='column sub-selectable setFocusRing']");
	public static final By table_Understand_Options = By.xpath("(//div[@class='bodyCells'])[2]//div[contains(@class,'pivotTableCellWrap cell-interactive')]");
	public static final By table_ItemScore_Options = By.xpath("(//div[@role='columnheader' and text()='Item Store'])[1]//ancestor::div[@class='innerContainer']//div[contains(@class,'pivotTableCellWrap cell-interactive') or contains(@class,'cell-interactive')]");
	public static final By table_UnderStock_options = By.xpath("(//div[@class='innerContainer'])[2]//div[@class='flex-container cell-interactive ']");
	
	
	public static final By img_Playbook = By.xpath("(//div[@class='imageBackground'])[2]");
	public static final By btn_AnalyzeInventory = By.xpath("//div[text()='Analyze Inventory']//ancestor::div[@class='contentOuterContainer']");
	public static final By dd_CompositeScore = By.xpath("//div[@aria-label='Composite Score' and @role='combobox']");
	
	
	
	//Understand page filter From & To
	public static final By dd_FromWeek = By.xpath("//*[text()='From Week']/../../../..//div[@role='combobox']");
	public static final By dd_ToWeek = By.xpath("//*[text()='To Week']/../../../..//div[@role='combobox']");
	public static final By dd_FromWeek_Options = By.xpath("(//div[@class='slicerBody'])[9]//div[@class='row']");
	public static final By dd_ToWeek_Options = By.xpath("(//div[@class='slicerBody'])[10]//div[@class='row']");
	//Other page filter From & To
	public static final By dd_FromDay = By.xpath("//*[text()='From Day']/../../../..//div[@role='combobox']");
	public static final By dd_ToDay = By.xpath("//*[text()='To Day']/../../../..//div[@role='combobox']");	
	public static final By dd_FromDay_Options = By.xpath("(//div[@class='slicerBody'])[7]//div[@class='row']");
	public static final By dd_ToDay_Options = By.xpath("(//div[@class='slicerBody'])[8]//div[@class='row']");
	
	public static final By title_LuminateReplenishmentDemandInsights = By.xpath("//span[contains(text(),'Luminate Replenishment Demand Insights')]//ancestor::div[@class='textbox']");
	public static final By title_Understand = By.xpath("//span[contains(text(),'Understand')]");
	public static final By title_Playbook = By.xpath("(//span[contains(text(),'Playbook')])[2]");
	public static final By title_UnderstandOutOfStock = By.xpath("//span[contains(text(),'Understand(Out Of Stock)')]");
	public static final By title_UnderstandUnderStock = By.xpath("//span[contains(text(),'Under Stock')]");
	public static final By title_Analyze = By.xpath("//span[contains(text(),'Analyze')]");	
	public static final By chart_Scatter_Option=By.xpath("//*[@class='scatterMarkerSeriesGroup']//*[@class='scatterMarker setFocusRing']");
	public static final By chart_PopMessage=By.xpath("//div[@id='screen_reader_alert_assertive']");
	
	public static final By btn_NeedsAttention = By.xpath("//span[text()='Needs Attention']//ancestor::div[@role='document']/../..");
	public static final By btn_NeedsReview = By.xpath("//span[text()='Needs Review']//ancestor::div[@role='document']/../..");
	public static final By span_XAxis_Options = By.xpath("//*[@class='x axis hideLinesOnAxis setFocusRing']//*[@class='setFocusRing']");	
	public static final By table_AttentionReview = By.xpath("(//div[@role='presentation' and @class='bodyCells'])[2]");
	public static final By table_AttentionReview_Options = By.xpath("(((//div[@role='presentation' and @class='bodyCells'])[2]//div[@role='row'])[1]//div[@aria-colindex='4'])[1]");
	public static final By span_LastUpdated = By.xpath("(//*[@class='value'])[1]");
	public static final By chart_ForecastTrend = By.xpath("//*[contains(text(),'Forecast Trend')]//ancestor::div[@class='vcGroupBody themableBackgroundColor themableBorderColorSolid']//*[@class='mainGraphicsContext setFocusRing']//*[@class='column sub-selectable setFocusRing']");
	public static final By chart_popupText=By.xpath("//div[@id='screen_reader_alert_assertive']");	
	public static final By dd_options=By.xpath("//input[@aria-label='Search']//ancestor::div[@class='slicer-dropdown-content']//div[@class='slicerBody']//div[@class='row']");
	public static final By dd_SelectAll_option=By.xpath("//input[@aria-label='Search']//ancestor::div[@class='slicer-dropdown-content']//*[text()='Select all']//ancestor::div[@class='slicerItemContainer']");
	public static final By treeMap_HomePage_Options=By.xpath("(//*[contains(text(),'MAPE (%) across product (left) and location (right) hierarchies')]//ancestor::div[contains(@class,'themableBorderColorSolid')])[1]//*[@role='treeitem']");
	public static final By dd_OptionWindow=By.xpath("//div[@class='slicerBody']");
	public static final By contextMenu_Option = By.xpath("//*[@role='menu']//button[@role='menuitem']");
	public static final By contextMenu = By.xpath("//*[@role='menu']");
	public static final By tableHeader_ItemScore = By.xpath("(//div[@role='columnheader' and text()='Item Store'])[1]");
	public static final By btn_Reset = By.xpath("(//*[@class='tileSVG'])[3]/../..");
	
	
	//Card MAPE
	public static final By card_MAPE = By.xpath("((//div[@class='vcGroupBody themableBackgroundColor themableBorderColorSolid'])[3]/visual-container)[1]//*[text()='MAPE']");
	public static final By card_MAPEWeekly = By.xpath("(//div[@class='vcGroupBody themableBackgroundColor themableBorderColorSolid'])[3]//span[@class='textRun']");	
	public static final By card_MAPEMainValue = By.xpath("((//div[@class='vcGroupBody themableBackgroundColor themableBorderColorSolid'])[3]/visual-container)[5]//*[@class='value']");
	public static final By card_MAPESmallValue = By.xpath("((//div[@class='vcGroupBody themableBackgroundColor themableBorderColorSolid'])[3]/visual-container)[4]//*[@class='value']");
	public static final By card_MAPEArrow = By.xpath("((//div[@class='vcGroupBody themableBackgroundColor themableBorderColorSolid'])[3]/visual-container)[6]//*[@class='value']");
	
	//Card WMAPE
	public static final By card_WMAPE = By.xpath("((//div[@class='vcGroupBody themableBackgroundColor themableBorderColorSolid'])[4]/visual-container)[1]//*[text()='WMAPE']");
	public static final By card_WMAPEWeekly = By.xpath("(//div[@class='vcGroupBody themableBackgroundColor themableBorderColorSolid'])[4]//span[@class='textRun']");
	public static final By card_WMAPEMainValue = By.xpath("((//div[@class='vcGroupBody themableBackgroundColor themableBorderColorSolid'])[4]/visual-container)[5]//*[@class='value']");
	public static final By card_WMAPESmallValue = By.xpath("((//div[@class='vcGroupBody themableBackgroundColor themableBorderColorSolid'])[4]/visual-container)[4]//*[@class='value']");
	public static final By card_WMAPEArrow = By.xpath("((//div[@class='vcGroupBody themableBackgroundColor themableBorderColorSolid'])[4]/visual-container)[6]//*[@class='value']");

	//Card BIAS
	public static final By card_BIAS = By.xpath("((//div[@class='vcGroupBody themableBackgroundColor themableBorderColorSolid'])[5]/visual-container)[1]//*[text()='BIAS']");
	public static final By card_BIASWeekly = By.xpath("(//div[@class='vcGroupBody themableBackgroundColor themableBorderColorSolid'])[5]//span[@class='textRun']");
	public static final By card_BIASSmallValue = By.xpath("((//div[@class='vcGroupBody themableBackgroundColor themableBorderColorSolid'])[5]/visual-container)[5]//*[@class='value']");
	public static final By card_BIASMainValue = By.xpath("((//div[@class='vcGroupBody themableBackgroundColor themableBorderColorSolid'])[5]/visual-container)[4]//*[@class='value']");
	public static final By card_BIASArrow = By.xpath("((//div[@class='vcGroupBody themableBackgroundColor themableBorderColorSolid'])[5]/visual-container)[6]//*[@class='value']");
	
	//Card MAD
	public static final By card_MAD = By.xpath("((//div[@class='vcGroupBody themableBackgroundColor themableBorderColorSolid'])[6]/visual-container)[1]//*[text()='MAD']");
	public static final By card_MADWeekly = By.xpath("(//div[@class='vcGroupBody themableBackgroundColor themableBorderColorSolid'])[6]//span[@class='textRun']");
	public static final By card_MADSmallValue = By.xpath("((//div[@class='vcGroupBody themableBackgroundColor themableBorderColorSolid'])[6]/visual-container)[5]//*[@class='value']");
	public static final By card_MADMainValue = By.xpath("((//div[@class='vcGroupBody themableBackgroundColor themableBorderColorSolid'])[6]/visual-container)[4]//*[@class='value']");
	public static final By card_MADArrow = By.xpath("((//div[@class='vcGroupBody themableBackgroundColor themableBorderColorSolid'])[6]/visual-container)[6]//*[@class='value']");
	
	//Card RMSE
	public static final By card_RMSE = By.xpath("((//div[@class='vcGroupBody themableBackgroundColor themableBorderColorSolid'])[7]/visual-container)[1]//*[text()='RMSE']");
	public static final By card_RMSEWeekly = By.xpath("(//div[@class='vcGroupBody themableBackgroundColor themableBorderColorSolid'])[7]//span[@class='textRun']");
	public static final By card_RMSESmallValue = By.xpath("((//div[@class='vcGroupBody themableBackgroundColor themableBorderColorSolid'])[7]/visual-container)[5]//*[@class='value']");
	public static final By card_RMSEMainValue = By.xpath("((//div[@class='vcGroupBody themableBackgroundColor themableBorderColorSolid'])[7]/visual-container)[4]//*[@class='value']");
	public static final By card_RMSEArrow = By.xpath("((//div[@class='vcGroupBody themableBackgroundColor themableBorderColorSolid'])[7]/visual-container)[6]//*[@class='value']");
	
	
}