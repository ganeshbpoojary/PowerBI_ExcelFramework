package uimaps;

import org.openqa.selenium.By;



public class Supplier_UI {
	
	public static final By tab_ExecutiveSummary=By.xpath("//div[contains(text(),'Executive Summary')]//ancestor::div[@class='contentOuterContainer']/..");	
	public static final By tab_SupplierReview=By.xpath("//div[contains(text(),'Supplier Review')]//ancestor::div[@class='contentOuterContainer']/..");
	public static final By tab_SupplierScore=By.xpath("//div[contains(text(),'Supplier Score')]//ancestor::div[@class='contentOuterContainer']/..");
	
	public static final By dd_options_supplier=By.xpath("//input[@aria-label='Search']//ancestor::div[@class='slicer-dropdown-content']//div[@class='slicerBody']//div[@class='row']");
	
	public static final By span_Spend_value=By.xpath("(//div[contains(text(),'Spend')]/../../../../../../../../../../../..//*[@class='value']/*)[1]");
	public static final By span_Spend_percentage=By.xpath("(//div[contains(text(),'Spend')]/../../../../../../../../../../../..//*[@class='value']/*)[2]");
	public static final By span_Spend_arrow=By.xpath("(//div[contains(text(),'Spend')]/../../../../../../../../../../../..//*[@class='value']/*)[3]");
	public static final By span_Spend_arrowColor=By.xpath("(//div[contains(text(),'Spend')]/../../../../../../../../../../../..//*[@class='value'])[3]");

	public static final By span_ExecutiveSummary_Units_value=By.xpath("((//div[text()='Units' and contains(@class,'content text')]//ancestor::div[contains(@class,'isChildSelected')])[2]//*[@class='value'])[1]/*");	
	public static final By span_ExecutiveSummary_Units_percentage=By.xpath("((//div[text()='Units' and contains(@class,'content text')]//ancestor::div[contains(@class,'isChildSelected')])[2]//*[@class='value'])[2]/*");
	public static final By span_ExecutiveSummary_Units_arrow=By.xpath("((//div[text()='Units' and contains(@class,'content text')]//ancestor::div[contains(@class,'isChildSelected')])[2]//*[@class='value'])[3]/*");
	public static final By span_ExecutiveSummary_Units_arrowColor=By.xpath("((//div[text()='Units' and contains(@class,'content text')]//ancestor::div[contains(@class,'isChildSelected')])[2]//*[@class='value'])[3]");
	
	public static final By span_SupplierReview_Units_value=By.xpath("((//div[text()='Units' and contains(@class,'content text')]//ancestor::div[contains(@class,'isChildSelected')])[2]//*[@class='value'])[1]/*");
	public static final By span_SupplierReview_Units_percentage=By.xpath("((//div[text()='Units' and contains(@class,'content text')]//ancestor::div[contains(@class,'isChildSelected')])[2]//*[@class='value'])[3]/*");	
	public static final By span_SupplierReview_Units_arrow=By.xpath("((//div[text()='Units' and contains(@class,'content text')]//ancestor::div[contains(@class,'isChildSelected')])[2]//*[@class='value'])[2]/*");
	public static final By span_SupplierReview_Units_arrowColor=By.xpath("((//div[text()='Units' and contains(@class,'content text')]//ancestor::div[contains(@class,'isChildSelected')])[2]//*[@class='value'])[2]");
		
	public static final By span_ExecutiveSummary_ContractCoverage_value=By.xpath("((//div[contains(text(),'Contract Coverage') and contains(@class,'content text')]//ancestor::div[contains(@class,'isChildSelected')])[4]//*[@class='value'])[1]/*");
	public static final By span_ExecutiveSummary_ContractCoverage_percentage=By.xpath("((//div[contains(text(),'Contract Coverage') and contains(@class,'content text')]//ancestor::div[contains(@class,'isChildSelected')])[4]//*[@class='value'])[2]/*");
	public static final By span_ExecutiveSummary_ContractCoverage_arrow=By.xpath("((//div[contains(text(),'Contract Coverage') and contains(@class,'content text')]//ancestor::div[contains(@class,'isChildSelected')])[4]//*[@class='value'])[3]/*");
	public static final By span_ExecutiveSummary_ContractCoverage_arrowColor=By.xpath("((//div[contains(text(),'Contract Coverage') and contains(@class,'content text')]//ancestor::div[contains(@class,'isChildSelected')])[4]//*[@class='value'])[3]");

	public static final By span_SupplierReview_ContractCoverage_value=By.xpath("((//div[contains(text(),'Contract Coverage') and contains(@class,'content text')]//ancestor::div[contains(@class,'isChildSelected')])[2]//*[@class='value'])[1]/*");
	public static final By span_SupplierReview_ContractCoverage_percentage=By.xpath("((//div[contains(text(),'Contract Coverage') and contains(@class,'content text')]//ancestor::div[contains(@class,'isChildSelected')])[2]//*[@class='value'])[3]/*");
	public static final By span_SupplierReview_ContractCoverage_arrow=By.xpath("((//div[contains(text(),'Contract Coverage') and contains(@class,'content text')]//ancestor::div[contains(@class,'isChildSelected')])[2]//*[@class='value'])[2]/*");
	public static final By span_SupplierReview_ContractCoverage_arrowColor=By.xpath("((//div[contains(text(),'Contract Coverage') and contains(@class,'content text')]//ancestor::div[contains(@class,'isChildSelected')])[2]//*[@class='value'])[2]");
	
	public static final By span_CurrrentScore_value=By.xpath("(//div[contains(text(),'Current Score')]/../../../../../../../../../../../..//*[@class='value']/*)[1]");
	public static final By span_BestScore_value=By.xpath("(//div[contains(text(),'Best Score')]/../../../../../../../../../../../..//*[@class='value']/*)[1]");
	public static final By span_LeastScore_value=By.xpath("(//div[contains(text(),'Least Score')]/../../../../../../../../../../../..//*[@class='value']/*)[1]");
	public static final By span_RecommendedTier_value=By.xpath("(//div[contains(text(),'Recommended Tier')]/../../../../../../../../../../../..//*[@class='value']/*)[1]");
	public static final By icon_RecommendedTier=By.xpath("//div[contains(text(),'Recommended Tier')]/../../../../../../../../../../../..//*[@cursor='pointer']");
	
	public static final By btn_HowHaveMyPurchaseOrderFillRatesPerformed=By.xpath("//div[contains(text(),'How have my purchase order fill rates performed')]");
	public static final By btn_WhatAreMyPurchasingTrendsWithRespectTosupplierContracts=By.xpath("//div[contains(text(),'What are my purchasing trends with respect to supplier contracts')]");
	public static final By btn_HowAreMyBehavioralMetricsPerforming=By.xpath("//div[contains(text(),'How are my behavioral metrics performing')]");
		
	public static final By btn_HowIsTheSupplierScoreTrendingAcrossMonths=By.xpath("//div[contains(text(),'How is the supplier score trending across months')]//ancestor::*[contains(@class,'bringToFront')]");
	public static final By btn_HowIsTheItemSupplierScoreTrendingAcrossMonths=By.xpath("//div[contains(text(),'How is the item supplier score trending across months')]//ancestor::*[contains(@class,'bringToFront')]");
	
	
	public static final By chart_BarGraph=By.xpath("//*[@data-automation-type='column-chart-rect']");
	
	public static final By txt_email=By.xpath("//input[@id='email']");
	public static final By txt_password=By.name("passwd");
	public static final By btn_submitPowerBI=By.id("submitBtn");
	public static final By btn_signinBY=By.xpath("//input[contains(@id,'idSIButton')]");
	public static final By btn_yesBY=By.xpath("//input[@value='Yes']");
	
	public static final By dd_productHierarchy=By.xpath("(//div[contains(@aria-label,'PRODUCT')])[1]");
	public static final By dd_supplier=By.xpath("//div[contains(@aria-label,'SUPPLIER')]");
	public static final By dd_from=By.xpath("//div[contains(@aria-label,'from_month') and @role='combobox']/div");
	public static final By dd_to=By.xpath("//div[contains(@aria-label,'to_month') and @role='combobox']/div");
	public static final By dd_SelectAll_option=By.xpath("//input[@aria-label='Search']//ancestor::div[@class='slicer-dropdown-content']//*[text()='Select all']//ancestor::div[@class='slicerItemContainer']");
		
	public static final By opt_dropDownRowsData = By.xpath("//input[@aria-label='Search']//ancestor::div[@class='slicer-dropdown-content']//div[@class='slicerBody']//div[@class='row']");
	
	public static final By header_SummaryChart = By.xpath("//div[@class='innerContainer']//div[text()='Routing' or text()='Destination']");
	
	public static final By row_SummaryChart_option1=By.xpath("//div[contains(@class,'expandableCell cell-interactive')]");
	public static final By row_SummaryChart_option2=By.xpath("//div[contains(@class,'rowHeaders')]//div[contains(@class,'pivotTableCellWrap cell-interactive')]");
	
	public static final By tab_Capacity=By.xpath("//div[contains(text(),'Capacity')]//ancestor::div[@class='contentOuterContainer']/..");
	
	public static final By btn_SupplierLeadTime=By.xpath("//div[text()='Supplier lead time']//ancestor::div[@class='contentOuterContainer']/..");
	public static final By btn_DistributionLeadTime=By.xpath("//div[text()='Distribution lead time']//ancestor::div[@class='contentOuterContainer']/..");
	public static final By btn_ProductionYield=By.xpath("//div[text()='Production Yield']//ancestor::div[@class='contentOuterContainer']/..");
	public static final By btn_ProductionRate=By.xpath("//div[contains(text(),'Production rate')]//ancestor::div[@class='contentOuterContainer']/..");
	
	public static final By frame_DataDistribution=By.xpath("//iframe[@name='visual-sandbox']");
	public static final By chart_DataDistribution=By.xpath("//div[@id='sandbox-host']");	
	
	public static final By btn_DetailedViewChart=By.xpath("//div[contains(text(),'Detailed view') or contains(text(),'Detailed View')]//ancestor::div[@class='contentOuterContainer']/..");	
	public static final By btn_SummaryViewChart=By.xpath("//div[contains(text(),'Summary')]//ancestor::div[@class='contentOuterContainer']/..");
	
	public static final By table_Top3Supplier=By.xpath("(//div[@class='bodyCells'])[1]");
	public static final By rows_Top3Supplier=By.xpath("(//div[@class='bodyCells'])[1]//div[@role='row']");
	
	public static final By table_Buttom3Supplier=By.xpath("(//div[@class='bodyCells'])[2]");
	public static final By rows_Buttom3Supplier=By.xpath("(//div[@class='bodyCells'])[2]//div[@role='row']");
	public static final By chart_XAxisItem=By.xpath("//*[@name='Line and clustered column chart' or  @class='axisGraphicsContext scatterChart playChart']//*[@data-automation-type='axis-tick-text']");
	
	public static final By iconChartView=By.xpath("//div[contains(@aria-label,'Chart View')]");
	public static final By iconTableView=By.xpath("//div[contains(@aria-label,'Table View')]");
	
	public static final By matrixRows=By.xpath("//div[@class='bodyCells']//div[contains(@class,'pivotTableCellWrap')]");
	
	public static final By lineGraph=By.xpath("//*[@class='lineChartSVG']//*[@class='markerPaths']");

	
	public static final By barGraph=By.xpath("//*[@class='columnChartUnclippedGraphicsContext']//*[@class='series']");
	
	public static final By xAxis_label=By.xpath("//*[@class='xAxisLabel sub-selectable']");
	public static final By yAxis_label=By.xpath("//*[@class='yAxisLabel sub-selectable']");
	
	public static final By Yaxis_StartValue=By.xpath("(//*[@class='y axis showLinesOnAxis']//*[@fill='currentColor'])[1]");
	public static final By Yaxis_EndValue=By.xpath("(//*[@class='y axis showLinesOnAxis']//*[@fill='currentColor'])[3]");
	
	public static final By chart_labels=By.xpath("//*[@class='mainGraphicsContext']//*[@class='scatterMarker setFocusRing']");
	public static final By chart_popupText=By.xpath("//div[@id='screen_reader_alert_assertive']");
	
	public static final By span_Old_Value=By.xpath("(//*[text()='Old']//ancestor::*[contains(@class,'visual-container-component')]/..//visual-container)[3]//*[@class='value']");
	public static final By span_Latest_Value=By.xpath("(//*[text()='Latest']//ancestor::*[contains(@class,'visual-container-component')]/..//visual-container)[5]//*[@class='value']");
	
}
