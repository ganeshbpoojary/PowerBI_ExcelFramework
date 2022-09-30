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

	public static final By chart_OutlierInvestigation_option=By.xpath("((//*[@class='lineChartSVG']//*[@role='listbox'])[1]//*[@class='interactivity-line sub-selectable'])[2]");
	public static final By chart_SeasonalityTrendResidual  = By.xpath("((//span[contains(text(),'Trend and Residual')]//ancestor::*[@class='ng-star-inserted'])[4]//*[@class='lineChartSVG']//*[@role='listbox'])[2]");	
	public static final By chart_SeasonalityTrendResidual_option=By.xpath("((//*[@class='lineChartSVG']//*[@role='listbox'])[2]//*[@class='interactivity-line sub-selectable'])[2]");
	public static final By chart_InterPlayBtnSales  = By.xpath("//*[@class='ng-star-inserted']//*[@class='lineChartSVG']//*[@role='listbox']");	
	public static final By chart_InterPlayBtnSales_option=By.xpath("(//*[@class='ng-star-inserted']//*[@class='lineChartSVG']//*[@role='listbox']//*[@class='interactivity-line sub-selectable'])[2]");
	public static final By chart_popupText=By.xpath("//div[@id='screen_reader_alert_assertive']");
	public static final By dd_InsightsFor=By.xpath("(//div[@aria-label='DATE'])[1]");
	public static final By dd_InsightsFor_Option=By.xpath("//ancestor::div[@class='slicer-dropdown-content']//div[@class='slicerBody']//div[@class='row']");
			
	public static final By card_OutlierItemStores_MainText=By.xpath("(((//div[@class='vcGroupBody themableBackgroundColor themableBorderColorSolid'])[5]/visual-container-group)[3]//span[text()='Outlier Item Stores'])");
	public static final By card_OutlierItemStores_MainValue=By.xpath("(((//div[@class='vcGroupBody themableBackgroundColor themableBorderColorSolid'])[5]/visual-container-group)[3]//*[@class='value'])[1]");
	public static final By card_OutlierItemStores_ItemStoresText=By.xpath("(((//div[@class='vcGroupBody themableBackgroundColor themableBorderColorSolid'])[5]/visual-container-group)[3]//span[text()='Item Stores'])");
	public static final By card_OutlierItemStores_ItemStoresValue=By.xpath("(((//div[@class='vcGroupBody themableBackgroundColor themableBorderColorSolid'])[5]/visual-container-group)[3]//*[@class='value'])[3]");
	public static final By card_OutlierItemStores_OutlierText=By.xpath("(((//div[@class='vcGroupBody themableBackgroundColor themableBorderColorSolid'])[5]/visual-container-group)[3]//span[text()='Outlier %'])");
	public static final By card_OutlierItemStores_OutlierValue=By.xpath("(((//div[@class='vcGroupBody themableBackgroundColor themableBorderColorSolid'])[5]/visual-container-group)[3]//*[@class='value'])[2]");
	
	public static final By card_OutlierUnits_MainText=By.xpath("(((//div[@class='vcGroupBody themableBackgroundColor themableBorderColorSolid'])[5]/visual-container-group)[1]//span[text()='Outlier Units'])");
	public static final By card_OutlierUnits_MainValue=By.xpath("(((//div[@class='vcGroupBody themableBackgroundColor themableBorderColorSolid'])[5]/visual-container-group)[1]//*[@class='value'])[1]");
	public static final By card_OutlierUnits_UnitsText=By.xpath("(((//div[@class='vcGroupBody themableBackgroundColor themableBorderColorSolid'])[5]/visual-container-group)[1]//span[text()='Units'])");
	public static final By card_OutlierUnits_UnitsValue=By.xpath("(((//div[@class='vcGroupBody themableBackgroundColor themableBorderColorSolid'])[5]/visual-container-group)[1]//*[@class='value'])[2]");
	public static final By card_OutlierUnits_OutlierText=By.xpath("(((//div[@class='vcGroupBody themableBackgroundColor themableBorderColorSolid'])[5]/visual-container-group)[1]//span[text()='Outlier %'])");
	public static final By card_OutlierUnits_OutlierValue=By.xpath("(((//div[@class='vcGroupBody themableBackgroundColor themableBorderColorSolid'])[5]/visual-container-group)[1]//*[@class='value'])[3]");
	
	public static final By card_OutlierSales_MainText=By.xpath("(((//div[@class='vcGroupBody themableBackgroundColor themableBorderColorSolid'])[5]/visual-container-group)[4]//span[text()='Outlier Sales ($)'])");
	public static final By card_OutlierSales_MainValue=By.xpath("(((//div[@class='vcGroupBody themableBackgroundColor themableBorderColorSolid'])[5]/visual-container-group)[4]//*[@class='value'])[1]");
	public static final By card_OutlierSales_SalesText=By.xpath("(((//div[@class='vcGroupBody themableBackgroundColor themableBorderColorSolid'])[5]/visual-container-group)[4]//span[text()='Sales ($)'])");
	public static final By card_OutlierSales_SalesValue=By.xpath("(((//div[@class='vcGroupBody themableBackgroundColor themableBorderColorSolid'])[5]/visual-container-group)[4]//*[@class='value'])[2]");
	public static final By card_OutlierSales_OutlierText=By.xpath("(((//div[@class='vcGroupBody themableBackgroundColor themableBorderColorSolid'])[5]/visual-container-group)[4]//span[text()='Outlier %'])");
	public static final By card_OutlierSales_OutlierValue=By.xpath("(((//div[@class='vcGroupBody themableBackgroundColor themableBorderColorSolid'])[5]/visual-container-group)[4]//*[@class='value'])[3]");
	
	public static final By card_OutlierTransactions_MainText=By.xpath("(((//div[@class='vcGroupBody themableBackgroundColor themableBorderColorSolid'])[5]/visual-container-group)[2]//span[text()='Outlier Transactions'])");
	public static final By card_OutlierTransactions_MainValue=By.xpath("(((//div[@class='vcGroupBody themableBackgroundColor themableBorderColorSolid'])[5]/visual-container-group)[2]//*[@class='value'])[1]");
	public static final By card_OutlierTransactions_TransactionsText=By.xpath("(((//div[@class='vcGroupBody themableBackgroundColor themableBorderColorSolid'])[5]/visual-container-group)[2]//span[text()='Transactions'])");
	public static final By card_OutlierTransactions_TransactionsValue=By.xpath("(((//div[@class='vcGroupBody themableBackgroundColor themableBorderColorSolid'])[5]/visual-container-group)[2]//*[@class='value'])[2]");
	public static final By card_OutlierTransactions_OutlierText=By.xpath("(((//div[@class='vcGroupBody themableBackgroundColor themableBorderColorSolid'])[5]/visual-container-group)[2]//span[text()='Outlier %'])");
	public static final By card_OutlierTransactions_OutlierValue=By.xpath("(((//div[@class='vcGroupBody themableBackgroundColor themableBorderColorSolid'])[5]/visual-container-group)[2]//*[@class='value'])[3]");
	public static final By chart_HomePage=By.xpath("//*[@role='treeitem']");
	
	public static final By span_Department=By.xpath("(//*[@class='value'])[3]");
	public static final By span_SubCategory=By.xpath("(//*[@class='value'])[4]");
	public static final By span_Region=By.xpath("(//*[@class='value'])[5]");
	public static final By span_Category=By.xpath("(//*[@class='value'])[6]");
	public static final By span_ObervationsFor=By.xpath("(//*[@class='value']//*)[8]");
	
}



