package uimaps;

import org.openqa.selenium.By;

public class AnamolyDetection_UI {
	
	public static final By AnamolyBusinessMeasureDropdown=By.xpath("");
	public static final By AnamolyPriorityMeasureDropdown = By.xpath("");
	                                                        //input[@aria-label='Search']//ancestor::div[@class='slicer-dropdown-content']//div[@class='slicerBody']//div[@class='row']
	public static final By AnamolyFromMeasureDropdown = By.xpath("");
	public static final By AnamolyToMeasureDropdown = By.xpath("");
	public static final By opt_dropDownRowsData = By.xpath("//input[@aria-label='Search']//ancestor::div[@class='slicer-dropdown-content']//div[@class='slicerBody']//div[@class='row']");
	public static final  By AnamolySearch = By.xpath("(//*[@aria-label='Search'])[3]");
	public static final By AD_SelectAll_option=By.xpath("//input[@aria-label='Search']//ancestor::div[@class='slicer-dropdown-content']//*[text()='Select all']//ancestor::div[@class='slicerItemContainer']");
	public static final By ADOutlierItemStore=By.xpath("//span[contains(text(),'Outlier Item Stores')]");
	public static final By ADOutlierUnits=By.xpath("//span[contains(text(),'Outlier Units')]");
	public static final By ADOutlierSales =By.xpath("//span[contains(text(),'Outlier Sales ($)')]");
	public static final By ADOutlierTransactions=By.xpath("//span[contains(text(),'Outlier Transactions')]");
	public static final By ADUnderstandButton=By.xpath("(//*[contains(text(),'Understand')])[1]");
	public static final By ADDrillThrough=By.xpath("//*[contains(text(),'Drill through')]");
	public static final By ADDrillThroughUnderstand=By.xpath("//*[contains(text(),'Drill through')]");
	public static final By ADunderstandTable=By.xpath("//div[@class='visual visual-tableEx allow-deferred-rendering']");

	
	public static final  By btn_Understand = By.xpath("//*[contains(@aria-label,'DrillDownMeasure Understand')]/..");
	public static final  By navBtn_DrillThrough = By.xpath("//button[@title='Drill through']");
	public static final  By navBtn_Understand = By.xpath("//button[@title='Understand']");
	public static final  By navBtn_Investigate = By.xpath("//button[@title='Investigate']");
	public static final  By navBtn_PricePromotionsPLC = By.xpath("//button[@title='Price, Promotions, PLC & Inventory']");	
	public static final  By title_Understand = By.xpath("//div[text()='Understand']//ancestor::div[@class='contentTable']");
	public static final  By title_Investigate = By.xpath("//div[text()='Investigate']//ancestor::div[@class='contentTable']");	
	public static final  By table_UnderStand_ColumnCount = By.xpath("//div[@role='presentation']//div[@role='columnheader']");
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
	
	
	
	
	

	
	
	
	
	
	
	

	

	
	


	
}
