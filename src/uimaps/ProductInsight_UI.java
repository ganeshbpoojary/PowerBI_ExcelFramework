package uimaps;

import org.openqa.selenium.By;

public class ProductInsight_UI {
	
	
	public static final By titleMixAlanyses=By.xpath("//*[text()='Mix Analysis']/../..");
	public static final By questionProductMixSubGroup=By.xpath("//*[contains(text(),'What is my product')]/..");
	public static final By questionSubGroupitemcountbymonth=By.xpath("//*[contains(text(),'Sub group item count by month')]/..");
	public static final By questionWhatAreMyKeyValueItem=By.xpath("//*[contains(text(),'What are my key value')]/..");
	public static final By titleDemandInsight=By.xpath("//*[text()='Demand Insights']/../..");
	public static final By titleFinancialPerformance=By.xpath("//*[text()='Financial Performance']/../..");
	public static final By itemdistrubutionchart=By.xpath("//*[@name='100% Stacked column chart']");
	public static final By itemchart=By.xpath("//*[@name='Clustered column chart']");
	public static final By metricchart=By.xpath("//*[@name='Ribbon chart']");
	public static final  By label_Lastupdated = By.xpath("//*[contains(text(),'Last updated')]");
	public static final By opt_dropDownRowsData = By.xpath("//input[@aria-label='Search']//ancestor::div[@class='slicer-dropdown-content']//div[@class='slicerBody']//div[@class='row']");
	public static final By MetriSales=By.xpath("//span[text()='Sales Units']/..");
	
	//What are my key value and their corrospoding contribution to the sales Question elements
	
	public static final By keyValueItem= By.xpath("//*[@aria-label='KEY VALUE ITEM']");
	
	public static final By KVIchart=By.xpath("//*[@name='Clustered column chart']");
	
	public static final By questionHowAreMyKVI=By.xpath("//*[text()='How are my KVIs performing?']/../..");
	
	public static final By detailsKVIAndNonKVIitemshareAndCount=By.xpath("//*[contains(text(),'KVI and non KVI')]/..");
	
	public static final By questiondetailsKVIAndNonKVIitemshareAndCount=By.xpath("//*[contains(text(),'How are my KVIs performing')]/..");
	
	public static final By KVIPerformingChart=By.xpath("//*[@class='visual visual-tableEx allow-deferred-rendering']");
	
	public static final By yaxiesMetricValue=By.xpath("//*[@data-sub-selection-display-name='Visual_Axis_Title']");
	
	public static final By others=By.xpath("//*[@title='OTHERS']");
	
	//how are my KVIs performing 
	
	public static final By tableKVIsperfroming=By.xpath("//*[@class='tableEx']");
		
	public static final By tabletitleItem=By.xpath("//*[@title='Item']");
	
	public static final By tabletitleProductName=By.xpath("//*[@title='Product Name']");
	
	public static final By tabletitleRevenue=By.xpath("//*[@title='Revenue Share (%)']");
	
	public static final By tabletitleSales_Units_Share =By.xpath("//*[@title='Sales Units Share (%)']");
	
	public static final By tabletitleGrossProfitShare =By.xpath("//*[@title='Gross Profit Share (%)']");
	
	public static final By tabletitleMargin =By.xpath("//*[@title='Margin (%)']");
	
	public static final By tabletitleAverageUnitRetail =By.xpath("//*[@title='Average Unit Retail (£)']");
	
	public static final By tabletitlePurchaseFrequency =By.xpath("//*[@title='Purchase Frequency (%)']");
	
	public static final By tablevalueintable=By.xpath("//*[@class='pivotTableCellWrap cell-interactive tablixAlignRight ']");
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// Ganesh added
	
	public static final By title_ProductInsights=By.xpath("//title[text()='Product Insights - Power BI']");
	//title[text()='Product Insights - Power BI']
	public static final By tab_Financial_Perfomance=By.xpath("//div[text()='Financial Performance']//ancestor::div[@class='contentOuterContainer']/..");
	public static final By tab_Demand_Insights=By.xpath("//div[text()='Demand Insights']//ancestor::div[@class='contentOuterContainer']/..");
	public static final By tab_Mix_Analysis=By.xpath("//div[text()='Mix Analysis']//ancestor::div[@class='contentOuterContainer']/..");

	
	public static final By btn_FinancialPerformanceSummary=By.xpath("//div[text()='Financial Performance Summary']//ancestor::div[@class='contentOuterContainer']/..");
	public static final By btn_WhatIsTheRevenueUnitsPrice=By.xpath("//div[text()='What is the revenue, units, price, promotion and inventory trend?']//ancestor::div[@class='contentOuterContainer']/..");
	public static final By btn_WhatIsMyGroupShareContribution=By.xpath("//div[text()='What is my group share and contribution?']//ancestor::div[@class='contentOuterContainer']/..");
	public static final By btn_WhatIsTheRegionClusterStoreContribution=By.xpath("//div[text()='What is the region/cluster/store contribution?']//ancestor::div[@class='contentOuterContainer']/..");
	public static final By btn_WhatIsTheMixOfPromotionalRegularSales=By.xpath("//div[text()='What is the mix of promotional and regular sales in my group?']//ancestor::div[@class='contentOuterContainer']/..");
//	public static final By opt_dropDownRowsData = By.xpath("//input[@aria-label='Search']//ancestor::div[@class='slicer-dropdown-content']//div[@class='slicerBody']//div[@class='row']");

	
	//div[text()='Financial Performance Summary']//ancestor::div[@class='contentOuterContainer']/..
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
