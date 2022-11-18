package uimaps;

import org.openqa.selenium.By;

public class ProductionInsight_UI {
	//Executive summary 
	public static final By ProductionInsightHomepage=By.xpath("(//*[contains(text(),'Production Insights')])[2]");
	public static final By opt_dropDownRowsData = By.xpath("//input[@aria-label='Search']//ancestor::div[@class='slicer-dropdown-content']//div[@class='slicerBody']//div[@class='row']");
	public static final By tittle_FinalRateTrend=By.xpath("//*[contains(text(),'Fill Rate Trend ( Last 5Months )')]");
	public static final By monthparameterText=By.xpath("//*[@class='date-slicer-head']");
	public static final By plantProductionText=By.xpath("(//*[@class='visual visual-actionButton allow-deferred-rendering'])[5]");
	
	//year target and Actual and remaining 
	public static final By xaxies_Label_year=By.xpath("(//*[@class='x axis hideLinesOnAxis setFocusRing'])[2]");
	public static final By xaxies_Value_year=By.xpath("(//*[@class='y axis hideLinesOnAxis'])[2]");
	public static final By yaxies_label_year=By.xpath("(//*[@class='yAxisLabel sub-selectable'])[1]");
	public static final By graphvalues_year=By.xpath("//*[@class='label sub-selectable']");
	
	
	
	//month target and actual and remaining
	
	public static final By xaxies_Label_month=By.xpath("(//*[@class='x axis hideLinesOnAxis setFocusRing'])[3]");
	public static final By xaxies_Value_month=By.xpath("(//*[@class='y axis hideLinesOnAxis'])[3]");
	public static final By yaxies_label_month=By.xpath("(//*[@class='yAxisLabel sub-selectable'])[2]");
	public static final By graphvalues_month=By.xpath("//*[@class='label sub-selectable']");
	
	
//	Plant Insights
	public static final By PlantInsights_title=By.xpath("//*[text()='Plant']");
	public static final By PlantInsights_header=By.xpath("//*[contains(text(),'Plant Insights')]/..");
	public static final By PlantInsights_WhatisMyPlant=By.xpath("//*[contains(text(),'What is my plant fill rate')]/../../..");
	public static final By PlantInsights_Plantqualitytrend=By.xpath("//*[contains(text(),'Plant quality trend')]/../..");
	
	//
	
	
	//Plant insights month actual and remaining 
	public static final By xaxies_Label_Plantmonth=By.xpath("//*[@class='x axis hideLinesOnAxis setFocusRing']");
	public static final By xaxies_Value_Plantmonth=By.xpath("//*[@class='y axis hideLinesOnAxis']");
	public static final By yaxies_label_Plantmonth=By.xpath("//*[@class='yAxisLabel sub-selectable']");
	public static final By graphvalues_Plantmonth=By.xpath("//*[@class='label sub-selectable']");
	
	//Plant insight capacity utilization
	public static final By xaxies_Label_capacityUtilization=By.xpath("(//*[contains(text(),'Actual and Plan')])[2]");
	public static final By xaxies_Value_capacityUtilization=By.xpath("(//*[@class='y axis hideLinesOnAxis'])[2]");
	public static final By yaxies_label_capacityUtilization=By.xpath("(//*[@class='yAxisLabel sub-selectable'])[2]");
	public static final By graphvalues_capacityUtilization=By.xpath("(//*[@class='label sub-selectable'])[2]");
	public static final By graphvalues_RejectionRateTittle=By.xpath("//*[contains(text(),'Rejection Rate %')]");
	public static final By graphvalues_Actualtittle=By.xpath("//*[@title='Plan']");
	public static final By graphvalues_Plantittle=By.xpath("//*[@title='Actual']");
	
	
	//Sub-Contractor insight 
	
	public static final By SubContractorinsight_Header =By.xpath("//*[contains(text(),'Sub-Contractor Insights')]/..");
	public static final By SubContractorinsightPageTittle =By.xpath("//*[contains(text(),'Sub-Contractor')]");
	public static final By SubContractor_WhatisMycontractUsage=By.xpath("//*[contains(text(),'What is my contract usage')]/../../..");
	public static final By SubContractor_QualityTrend=By.xpath("//*[contains(text(),'Sub-Contractor quality trend')]/../../..");
	
	
		
		public static final By xaxies_Value_SubcontractoQualityTrend=By.xpath("(//*[@class='y axis hideLinesOnAxis'])[2]");
		public static final By yaxies_label_SubcontractoQualityTrend=By.xpath("(//*[@class='yAxisLabel sub-selectable'])[2]");
		public static final By graphvalues_SubcontractoQualityTrend=By.xpath("(//*[@class='label sub-selectable'])[2]");
		public static final By Rejection_SubcontractoQualityTrend=By.xpath("//*[contains(text(),'Rejection Rate %')]");
		public static final By ProducedQuantity_SubcontractoQualityTrend=By.xpath("//*[@title='Produced Quantity']");
		public static final By ProductionSpan_LastUpdated = By.xpath("(//*[@class='value'])[1]");
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
