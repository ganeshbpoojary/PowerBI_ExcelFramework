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
	public static final By selectAll_option=By.xpath("//input[@aria-label='Search']//ancestor::div[@class='slicer-dropdown-content']//*[text()='Select all']//ancestor::div[@class='slicerItemContainer']");
	public static final By outlierItemStore=By.xpath("//span[contains(text(),'Outlier Item Stores')]");
	public static final By outlierUnits=By.xpath("//span[contains(text(),'Outlier Units')]");
	public static final By outlierSales =By.xpath("//span[contains(text(),'Outlier Sales ($)')]");
	public static final By outlierTransactions=By.xpath("//span[contains(text(),'Outlier Transactions')]");
	public static final By understandButton=By.xpath("(//*[contains(text(),'Understand')])[1]");
	public static final By drillThrough=By.xpath("//*[contains(text(),'Drill through')]");
	public static final By drillThroughUnderstand=By.xpath("//*[contains(text(),'Drill through')]");
	public static final By understandTable=By.xpath("//div[@class='visual visual-tableEx allow-deferred-rendering']");

	public static final  By btn_Understand = By.xpath("//*[contains(@aria-label,'DrillDownMeasure Understand')]/..");
	public static final  By navBtn_DrillThrough = By.xpath("//button[@title='Drill through']");
	public static final  By navBtn_Understand = By.xpath("//button[@title='Understand']");
	
	public static final  By title_Understand = By.xpath("//div[text()='Understand']//ancestor::div[@class='contentTable']");
	
	
	public static final  By table_UnderStand_ColumnCount = By.xpath("//div[@role='presentation']//div[@role='columnheader']");
	public static final  By table_UnderStand_RowCount = By.xpath("(//div[@role='row'])");
	

	

	
	


	
}
