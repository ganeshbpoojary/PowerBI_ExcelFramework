package uimaps;

import org.openqa.selenium.By;



public class Shopper_UI {
	
	
	
	public static final By frame_PopularSubCategories=By.xpath("//iframe[@name='visual-sandbox']");
	
	public static final By tab_MarketBasketAnalysis=By.xpath("//div[contains(text(),'Market Basket Analysis')]//ancestor::div[@class='contentOuterContainer']/..");
	public static final By tab_MissionTripAnalysis=By.xpath("//div[contains(text(),'Mission Trip Analysis')]//ancestor::div[@class='contentOuterContainer']/..");
	public static final By tab_ShopperSegment=By.xpath("//div[contains(text(),'Shopper Segment')]//ancestor::div[@class='contentOuterContainer']/..");
	public static final By tab_CDTNeedStateAnalysis=By.xpath("//div[contains(text(),'CDT/Need State Analysis')]//ancestor::div[@class='contentOuterContainer']/..");
	
	public static final By chart_TopDistrictContribution_Option=By.xpath("//*[@class='scatterMarkerSeriesGroup']//*[@class='scatterMarker setFocusRing']");
	public static final By chart_TopDistrictContribution_PopMessage=By.xpath("//div[@id='screen_reader_alert_assertive']");
	
	public static final By chart_PopularSubCategories_Option=By.xpath("//div[@id='sandbox-host']//*[@class='word']");
	

	public static final By btn_HowHaveMyBasketMetricsPerformed=By.xpath("//div[contains(text(),'How have my basket metrics performed compared to previous week')]/..");
	public static final By btn_HowAreMyKeyBasketMetricsTrending=By.xpath("//div[contains(text(),'How are my key basket metrics trending')]/..");
	public static final By btn_WhatIsMyBasketValueSizeDuringEventRegularPeriods=By.xpath("//div[contains(text(),'What is my basket value and size during event and regular periods')]/..");
	public static final By btn_WhatInsightsCanIGetFromMyMarketBasketAnalysis=By.xpath("//div[contains(text(),'What insights can I get from my market basket analysis')]/..");
	public static final By btn_HowAreMyTripMissionstrending=By.xpath("//div[contains(text(),'How are my trip missions trending')]/..");

//	public static final By btn_ViewDemographicProfile=By.xpath("//div[contains(text(),'View demographic profile')]");

	
	public static final By dd_options=By.xpath("//input[@aria-label='Search']//ancestor::div[@class='slicer-dropdown-content']//div[@class='slicerBody']//div[@class='row']");	
	public static final By dd_SelectAll_option=By.xpath("//input[@aria-label='Search']//ancestor::div[@class='slicer-dropdown-content']//*[text()='Select all']//ancestor::div[@class='slicerItemContainer']");
	
	//KPI cards
	public static final By card_AvgBasketValue=By.xpath("(//span[contains(text(),'Avg. Basket Value')]//ancestor::div[contains(@class,'themableBorderColorSolid')])[3]");
	public static final By card_AvgBasketSize=By.xpath("(//span[contains(text(),'Avg. Basket Size')]//ancestor::div[contains(@class,'themableBorderColorSolid')])[3]");
	public static final By card_Customers=By.xpath("(//span[contains(text(),'Customers')]//ancestor::div[contains(@class,'themableBorderColorSolid')])[3]");
	public static final By card_Discounts=By.xpath("(//span[contains(text(),'Discount')]//ancestor::div[contains(@class,'themableBorderColorSolid')])[3]");
	
	
	//Card Main value
	public static final By card_AvgBasketValue_Val = By.xpath("((//span[contains(text(),'Avg. Basket Value')]//ancestor::div[contains(@class,'themableBorderColorSolid')])[3]//*[@class='value'])[1]");
	public static final By card_AvgBasketSize_Val = By.xpath("((//span[contains(text(),'Avg. Basket Size')]//ancestor::div[contains(@class,'themableBorderColorSolid')])[3]//*[@class='value'])[1]");
	public static final By card_CustomersValue_Val = By.xpath("((//span[contains(text(),'Customers')]//ancestor::div[contains(@class,'themableBorderColorSolid')])[3]//*[@class='value'])[1]");
	public static final By card_DiscountsValue_Val = By.xpath("((//span[contains(text(),'Discount')]//ancestor::div[contains(@class,'themableBorderColorSolid')])[3]//*[@class='value'])[1]");
	
	//Percentage Value
	public static final By card_AvgBasketValue_Percent = By.xpath("((//span[contains(text(),'Avg. Basket Value')]//ancestor::div[contains(@class,'themableBorderColorSolid')])[3]//*[@class='value'])[2]//*");
	public static final By card_AvgBasketSize_Percent = By.xpath("((//span[contains(text(),'Avg. Basket Size')]//ancestor::div[contains(@class,'themableBorderColorSolid')])[3]//*[@class='value'])[2]//*");
	public static final By card_CustomersValue_Percent = By.xpath("((//span[contains(text(),'Customers')]//ancestor::div[contains(@class,'themableBorderColorSolid')])[3]//*[@class='value'])[2]//*");
	public static final By card_DiscountsValue_Percent = By.xpath("((//span[contains(text(),'Discount')]//ancestor::div[contains(@class,'themableBorderColorSolid')])[3]//*[@class='value'])[2]//*");
	
	//Percentage Value color
	public static final By card_AvgBasketValue_Color = By.xpath("((//span[contains(text(),'Avg. Basket Value')]//ancestor::div[contains(@class,'themableBorderColorSolid')])[3]//*[@class='value'])[2]");
	public static final By card_AvgBasketSize_Color = By.xpath("((//span[contains(text(),'Avg. Basket Size')]//ancestor::div[contains(@class,'themableBorderColorSolid')])[3]//*[@class='value'])[2]");
	public static final By card_CustomersValue_Color = By.xpath("((//span[contains(text(),'Customers')]//ancestor::div[contains(@class,'themableBorderColorSolid')])[3]//*[@class='value'])[2]");
	public static final By card_DiscountsValue_Color = By.xpath("((//span[contains(text(),'Discount')]//ancestor::div[contains(@class,'themableBorderColorSolid')])[3]//*[@class='value'])[2]");
	
	public static final By xAxis_label=By.xpath("(//*[contains(text(),'Top districts contribution')]//ancestor::div[@class='vcGroupBody themableBackgroundColor themableBorderColorSolid'])[2]//*[@class='xAxisLabel sub-selectable']");
	public static final By yAxis_label=By.xpath("(//*[contains(text(),'Top districts contribution')]//ancestor::div[@class='vcGroupBody themableBackgroundColor themableBorderColorSolid'])[2]//*[@class='yAxisLabel sub-selectable']");
	
	public static final By chart_popupText=By.xpath("//div[@id='screen_reader_alert_assertive']");
	
	public static final By radio_TimeOfDay=By.xpath("(//div[@class='imageBackground'])[3]");
	public static final By radio_DayOfWeek=By.xpath("(//div[@class='imageBackground'])[2]");
	
	public static final By table_SalesContribition=By.xpath("//div[@class='bodyCells']//div[contains(@class,'pivotTableCellWrap')]");
	public static final By table_BasketAnalysis=By.xpath("//div[contains(@class,'pivotTableCellWrap cell-interactive tablixAlignRight')]");

	
	
	public static final By span_TimeOfDayColumn=By.xpath("(//div[@class='innerContainer'])[1]//div[@class='columnHeaders']//div[contains(@class,'pivotTableCellWrap')]");
	public static final By span_DayOfWeekColumn=By.xpath("(//div[@class='innerContainer'])[2]//div[@class='columnHeaders']//div[contains(@class,'pivotTableCellWrap')]");

	public static final By span_AverageBasketSize=By.xpath("//div[text()='Average Basket Size']");
	public static final By span_AverageBasketValue=By.xpath("//div[text()='Average Basket Value']");
	public static final By span_PercentofSales=By.xpath("//div[text()='Percent of Sales $']");
	public static final By span_PercentTransactions=By.xpath("//div[text()='Percent Transactions']");
	public static final By span_FrequencyOfTransaction=By.xpath("//div[text()='Frequency of Transaction']");
	public static final By span_Discounts=By.xpath("//div[text()='Discounts ($)']");
	
	public static final By chart_DataBar=By.xpath("//*[@class='dataBar']");
	public static final By chart_DonutChart=By.xpath("//*[@class='donutChart']");
	public static final By btn_ViewDemographicProfile=By.xpath("//div[text()='View demographic profile']//ancestor::div[@class='contentOuterContainer']/..");
	
	public static final By span_WhatAreKeyDemographicMetricsEachShopperSegment=By.xpath("//span[text()='What are the key demographic metrics by each shopper segment?']");
	
	
	
	
	
	
	
	
}

