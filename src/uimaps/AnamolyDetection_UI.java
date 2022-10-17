package uimaps;

import org.openqa.selenium.By;

public class AnamolyDetection_UI {	
	
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
			
	//Outlier Item Stores
	public static final By card_OutlierItemStores_MainText=By.xpath("(((//div[@class='vcGroupBody themableBackgroundColor themableBorderColorSolid'])[5]/visual-container-group)[3]//span[text()='Outlier Item Stores'])");
	public static final By card_OutlierItemStores_MainValue=By.xpath("(((//div[@class='vcGroupBody themableBackgroundColor themableBorderColorSolid'])[5]/visual-container-group)[3]//*[@class='value'])[1]");
	public static final By card_OutlierItemStores_ItemStoresText=By.xpath("(((//div[@class='vcGroupBody themableBackgroundColor themableBorderColorSolid'])[5]/visual-container-group)[3]//span[text()='Item Stores'])");
	public static final By card_OutlierItemStores_ItemStoresValue=By.xpath("(((//div[@class='vcGroupBody themableBackgroundColor themableBorderColorSolid'])[5]/visual-container-group)[3]//*[@class='value'])[3]");
	public static final By card_OutlierItemStores_OutlierText=By.xpath("(((//div[@class='vcGroupBody themableBackgroundColor themableBorderColorSolid'])[5]/visual-container-group)[3]//span[text()='Outlier %'])");
	public static final By card_OutlierItemStores_OutlierValue=By.xpath("(((//div[@class='vcGroupBody themableBackgroundColor themableBorderColorSolid'])[5]/visual-container-group)[3]//*[@class='value'])[2]");
	
	//Outlier Units
	public static final By card_OutlierUnits_MainText=By.xpath("(((//div[@class='vcGroupBody themableBackgroundColor themableBorderColorSolid'])[5]/visual-container-group)[1]//span[text()='Outlier Units'])");
	public static final By card_OutlierUnits_MainValue=By.xpath("(((//div[@class='vcGroupBody themableBackgroundColor themableBorderColorSolid'])[5]/visual-container-group)[1]//*[@class='value'])[1]");
	public static final By card_OutlierUnits_UnitsText=By.xpath("(((//div[@class='vcGroupBody themableBackgroundColor themableBorderColorSolid'])[5]/visual-container-group)[1]//span[text()='Units'])");
	public static final By card_OutlierUnits_UnitsValue=By.xpath("(((//div[@class='vcGroupBody themableBackgroundColor themableBorderColorSolid'])[5]/visual-container-group)[1]//*[@class='value'])[2]");
	public static final By card_OutlierUnits_OutlierText=By.xpath("(((//div[@class='vcGroupBody themableBackgroundColor themableBorderColorSolid'])[5]/visual-container-group)[1]//span[text()='Outlier %'])");
	public static final By card_OutlierUnits_OutlierValue=By.xpath("(((//div[@class='vcGroupBody themableBackgroundColor themableBorderColorSolid'])[5]/visual-container-group)[1]//*[@class='value'])[3]");
	
	//Outlier Sales
	public static final By card_OutlierSales_MainText=By.xpath("(((//div[@class='vcGroupBody themableBackgroundColor themableBorderColorSolid'])[5]/visual-container-group)[4]//span[text()='Outlier Sales ($)'])");
	public static final By card_OutlierSales_MainValue=By.xpath("(((//div[@class='vcGroupBody themableBackgroundColor themableBorderColorSolid'])[5]/visual-container-group)[4]//*[@class='value'])[1]");
	public static final By card_OutlierSales_SalesText=By.xpath("(((//div[@class='vcGroupBody themableBackgroundColor themableBorderColorSolid'])[5]/visual-container-group)[4]//span[text()='Sales ($)'])");
	public static final By card_OutlierSales_SalesValue=By.xpath("(((//div[@class='vcGroupBody themableBackgroundColor themableBorderColorSolid'])[5]/visual-container-group)[4]//*[@class='value'])[2]");
	public static final By card_OutlierSales_OutlierText=By.xpath("(((//div[@class='vcGroupBody themableBackgroundColor themableBorderColorSolid'])[5]/visual-container-group)[4]//span[text()='Outlier %'])");
	public static final By card_OutlierSales_OutlierValue=By.xpath("(((//div[@class='vcGroupBody themableBackgroundColor themableBorderColorSolid'])[5]/visual-container-group)[4]//*[@class='value'])[3]");
	
	//Outlier Transactions
	public static final By card_OutlierTransactions_MainText=By.xpath("(((//div[@class='vcGroupBody themableBackgroundColor themableBorderColorSolid'])[5]/visual-container-group)[2]//span[text()='Outlier Transactions'])");
	public static final By card_OutlierTransactions_MainValue=By.xpath("(((//div[@class='vcGroupBody themableBackgroundColor themableBorderColorSolid'])[5]/visual-container-group)[2]//*[@class='value'])[1]");
	public static final By card_OutlierTransactions_TransactionsText=By.xpath("(((//div[@class='vcGroupBody themableBackgroundColor themableBorderColorSolid'])[5]/visual-container-group)[2]//span[text()='Transactions'])");
	public static final By card_OutlierTransactions_TransactionsValue=By.xpath("(((//div[@class='vcGroupBody themableBackgroundColor themableBorderColorSolid'])[5]/visual-container-group)[2]//*[@class='value'])[2]");
	public static final By card_OutlierTransactions_OutlierText=By.xpath("(((//div[@class='vcGroupBody themableBackgroundColor themableBorderColorSolid'])[5]/visual-container-group)[2]//span[text()='Outlier %'])");
	public static final By card_OutlierTransactions_OutlierValue=By.xpath("(((//div[@class='vcGroupBody themableBackgroundColor themableBorderColorSolid'])[5]/visual-container-group)[2]//*[@class='value'])[3]");
	public static final By chart_HomePage=By.xpath("//*[@role='treeitem']");
	

	//understnd Outerline item store
	public static final By understand_OutlierItemStores_MainText=By.xpath("((((//div[@class='vcGroupBody themableBackgroundColor themableBorderColorSolid'])))[7]/visual-container-group[3]//span[text()='Outlier Item Stores'])");
	public static final By understand_OutlierItemStores_MainValue=By.xpath("((((//div[@class='vcGroupBody themableBackgroundColor themableBorderColorSolid'])))[7]/visual-container-group[3]//*[@class='value'])[1]");
	public static final By understand_OutlierItemStores_ItemStoresText=By.xpath("((((//div[@class='vcGroupBody themableBackgroundColor themableBorderColorSolid'])))[7]/visual-container-group[3]//span[text()='Item Stores'])");
	public static final By understand_OutlierItemStores_ItemStoresValue=By.xpath("((((//div[@class='vcGroupBody themableBackgroundColor themableBorderColorSolid'])))[7]/visual-container-group[3]//*[@class='value'])[3]");
	public static final By understand_OutlierItemStores_OutlierText=By.xpath("((((//div[@class='vcGroupBody themableBackgroundColor themableBorderColorSolid'])))[7]/visual-container-group[3]//span[text()='Outlier %'])");
	
	//understand outlier units
	public static final By understand_outlier_MainText=By.xpath("((((//div[@class='vcGroupBody themableBackgroundColor themableBorderColorSolid'])))[7]/visual-container-group[1]//span[text()='Outlier Units'])");
	public static final By understand_outlier_MainValue=By.xpath("((((//div[@class='vcGroupBody themableBackgroundColor themableBorderColorSolid'])))[7]/visual-container-group[1]//*[@class='value'])[1]");
	public static final By understand_outlier_unitsText=By.xpath("((((//div[@class='vcGroupBody themableBackgroundColor themableBorderColorSolid'])))[7]/visual-container-group[1]//span[text()='Units'])");
	public static final By understand_outlier_unitsValue=By.xpath("((((//div[@class='vcGroupBody themableBackgroundColor themableBorderColorSolid'])))[7]/visual-container-group[1]//*[@class='value'])[3]");
	public static final By understand_outlier_OutlierText=By.xpath("((((//div[@class='vcGroupBody themableBackgroundColor themableBorderColorSolid'])))[7]/visual-container-group[1]//span[text()='Outlier %'])");
	
	
	//understand outlier_sales
	public static final By understand_outlier_sales_MainText=By.xpath("((((//div[@class='vcGroupBody themableBackgroundColor themableBorderColorSolid'])))[7]/visual-container-group[4]//span[text()='Outlier Sales ($)'])");
	public static final By understand_outlier_sales_MainValue=By.xpath("((((//div[@class='vcGroupBody themableBackgroundColor themableBorderColorSolid'])))[7]/visual-container-group[4]//*[@class='value'])[1]");
	public static final By understand_outlier_sales_salesText=By.xpath("((((//div[@class='vcGroupBody themableBackgroundColor themableBorderColorSolid'])))[7]/visual-container-group[4]//span[text()='Sales ($)'])");
	public static final By understand_outlier_sales_salesValue=By.xpath("((((//div[@class='vcGroupBody themableBackgroundColor themableBorderColorSolid'])))[7]/visual-container-group[4]//*[@class='value'])[3]");
	public static final By understand_outlier_sales_OutlierText=By.xpath("((((//div[@class='vcGroupBody themableBackgroundColor themableBorderColorSolid'])))[7]/visual-container-group[4]//span[text()='Outlier %'])");
	
	
	//understand outlier_transaction
	public static final By understand_outlier_transaction_MainText=By.xpath("((((//div[@class='vcGroupBody themableBackgroundColor themableBorderColorSolid'])))[7]/visual-container-group[2]//span[text()='Outlier Transactions'])");
	public static final By understand_outlier_transaction_MainValue=By.xpath("((((//div[@class='vcGroupBody themableBackgroundColor themableBorderColorSolid'])))[7]/visual-container-group[2]//*[@class='value'])[1]");
	public static final By understand_outlier_transactionsText=By.xpath("((((//div[@class='vcGroupBody themableBackgroundColor themableBorderColorSolid'])))[7]/visual-container-group[2]//span[text()='Transactions'])");
	public static final By understand_outlier_transactionsValue=By.xpath("((((//div[@class='vcGroupBody themableBackgroundColor themableBorderColorSolid'])))[7]/visual-container-group[2]//*[@class='value'])[3]");
	public static final By understand_outlier_transactionsOutlierText=By.xpath("((((//div[@class='vcGroupBody themableBackgroundColor themableBorderColorSolid'])))[7]/visual-container-group[2]//span[text()='Outlier %'])");
	

	public static final By span_Department=By.xpath("(//*[@class='value'])[3]");
	public static final By span_SubCategory=By.xpath("(//*[@class='value'])[4]");
	public static final By span_Region=By.xpath("(//*[@class='value'])[5]");
	public static final By span_Category=By.xpath("(//*[@class='value'])[6]");
	public static final By span_ObervationsFor=By.xpath("(//*[@class='value']//*)[8]");


	public static final  By exploraryOutlierItemStores = By.xpath("//*[@class='y axis hideLinesOnAxis setFocusRing']//ancestor::div//*[@data-sub-selection-object-name='data-labels']");
	public static final  By exploraryOutlierItemStoresText = By.xpath("//*[@data-sub-selection-display-name='Visual_Axis_Title']");
	
	

	
	public static final  By Importance_forecastability_rowheader = By.xpath("//div[@class='rowHeaders']//ancestor::div[@class='pivotTableCellWrap cell-interactive tablixAlignCenter ']");
	public static final  By Importance_forecastability_coloumnheader=By.xpath("(//div[@class='innerContainer']//ancestor::div[@class='columnHeaders'])[2]");

	public static final By dd_options=By.xpath("//ancestor::div[@class='slicer-dropdown-content']//div[@class='slicerBody']//div[@class='row']");
	public static final By btn_Understand = By.xpath("//*[contains(@aria-label,'DrillDownMeasure Understand')]/..");
	public static final By navBtn_DrillThrough = By.xpath("//button[@title='Drill through']");
	public static final By navBtn_Understand = By.xpath("//button[@title='Understand']");
	public static final By navBtn_Investigate = By.xpath("//button[@title='Investigate']");
	public static final By navBtn_PricePromotionsPLC = By.xpath("//button[@title='Price, Promotions, PLC & Inventory']");	
	public static final By title_Understand = By.xpath("//div[text()='Understand']//ancestor::div[@class='contentTable']");
	public static final By title_Investigate = By.xpath("//div[text()='Investigate']//ancestor::div[@class='contentTable']");	
	public static final By table_UnderStand_ColumnCount = By.xpath("//div[@role='presentation']//div[@role='columnheader']");
	public static final By table_UnderStand_RowCount = By.xpath("(//div[@role='row'])");	
	public static final By span_OutlierInvestigationReportForItem = By.xpath("//span[contains(text(),'Outlier investigation report for Item')]");
	
	public static final By span_AndStore = By.xpath("//span[contains(text(),'and Store')]");	
	public static final By span_FirstITEM = By.xpath("//*[contains(@aria-label,'First ITEM')]");
	public static final By span_FirstLOCATION = By.xpath("//*[contains(@aria-label,'First LOCATION')]");
	public static final By span_InterPlaySalesPricePromo = By.xpath("//span[contains(text(),'Interplay between sales, price, promotions, PLC & inventory for Item')]");
	public static final By span_ItemFromIndex = By.xpath("(//*[@class='value'])[8]//*");
	public static final By span_LocationFromIndex = By.xpath("(//*[@class='value'])[7]//*");
	
	public static final By tableHeader_Investigate_option = By.xpath("(//div[@class='columnHeaders'])[2]//div[contains(@class,'pivotTableCellNoWrap cell-interactive')]");
	public static final By table_OutlierInvestigation_option = By.xpath("((//div[@class='bodyCells'])[2]//div[contains(@class,'pivotTableCellWrap')])");
	public static final By table_InterPlaySales_option = By.xpath("((//div[@class='bodyCells'])[1]//div[contains(@class,'pivotTableCellWrap')])");
	public static final By contextMenu_Option = By.xpath("//*[@role='menu']//button[@role='menuitem']");
	public static final By contextMenu = By.xpath("//*[@role='menu']");	
	public static final By btn_BusniessImpact = By.xpath("(//div[contains(@class,'pivotTableCellNoWrap')])[4]/..");	
	public static final By chart_OutlierInvestigation  = By.xpath("((//span[contains(text(),'Trend and Residual')]//ancestor::*[@class='ng-star-inserted'])[4]//*[@class='lineChartSVG']//*[@role='listbox'])[1]");
	public static final  By exploraryOutlierBars = By.xpath("//*[@class='bar sub-selectable setFocusRing']");
  
	
}



