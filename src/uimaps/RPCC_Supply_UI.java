package uimaps;

import org.openqa.selenium.By;

public class RPCC_Supply_UI {
	
	public static final By navBtn_OutOfStock=By.xpath("(//div[@class='visual visual-image allow-deferred-rendering'])[1]/../..");
	public static final By navBtn_understock=By.xpath("(//div[@class='visual visual-image allow-deferred-rendering'])[2]/../..");
	public static final By navBtn_excessStock=By.xpath("(//div[@class='visual visual-image allow-deferred-rendering'])[3]/../..");
	public static final By navBtn_orderVariance=By.xpath("(//div[@class='visual visual-image allow-deferred-rendering'])[4]/../..");
	public static final By navBtn_StoreOverrides=By.xpath("(//div[@class='visual visual-image allow-deferred-rendering'])[5]/../..");
	public static final By opt_dropDownRowsData = By.xpath("//input[@aria-label='Search']//ancestor::div[@class='slicer-dropdown-content']//div[@class='slicerBody']//div[@class='row']");

	
//	public static final By needsAttention=By.xpath("//*[contains(text(),'Needs Attention')]");
	
	public static final By btn_NeedsAttention = By.xpath("//span[text()='Needs Attention']//ancestor::div[@role='document']/../..");
	public static final By table_AttentionReview = By.xpath("(//div[@role='presentation' and @class='bodyCells'])[2]");
	public static final By table_AttentionReview_Options = By.xpath("((//div[@role='presentation' and @class='bodyCells'])[3]//div[@role='row'])[1]//div[@aria-colindex='4']");
	public static final By table_UnderStock_AttentionReview_Options = By.xpath("((//div[@role='presentation' and @class='bodyCells'])[2]//div[@role='row'])[1]//div[@aria-colindex='4']");
	public static final By navBtn_DrillThrough = By.xpath("//button[@title='Drill through']");
	public static final By drill_Understand = By.xpath("//button[@title='Understand']");
	public static final By title_Understand = By.xpath("//span[contains(text(),'Understand')]");
	public static final By table_NeedsReview = By.xpath("(//div[@role='grid' and @class='innerContainer'])[3]");
	public static final By btn_NeedsReview = By.xpath("//span[text()='Needs Review']//ancestor::div[@role='document']/../..");
	public static final By graph_dailymixItemOutOfStock=By.xpath("//*[@class='visual visual-lineStackedColumnComboChart allow-deferred-rendering']");
	public static final By chart_ItemOutOfStock=By.xpath("//*[@class='visual visual-clusteredBarChart allow-deferred-rendering']");
	public static final By chart_ItemOutOfStock_Location=By.xpath("(//*[@class='visual visual-tableEx allow-deferred-rendering'])[1]");
	public static final By navBtn_Understand=By.xpath("(//*[contains(text(),'UNDERSTAND')])[1]");
	public static final By drillThrough=By.xpath("//*[contains(text(),'Drill through')]");
	public static final By understandpage_title=By.xpath("//*[contains(text(),'Understand')]");
	public static final By analyze_Inventory=By.xpath("//*[contains(text(),'Analyze Inventory')]/../..");
	public static final By outOfStockItem=By.xpath("//*[@class='parentGroup treemapNode setFocusRing']");
	public static final By resetLogo=By.xpath("//*[@aria-label=\"Reset filters, slicers, and other data view changes you've made.\"]");
	public static final By resetButton=By.xpath("//*[text()='Reset']");
	public static final By outOfStockchartafterReset=By.xpath("(//*[@class='visual visual-tableEx allow-deferred-rendering'])[2]");
	public static final By underStockchartafterReset=By.xpath("//*[@class='visual visual-pivotTable allow-deferred-rendering']");
	public static final By chartafterReset=By.xpath("(//*[@class='visual visual-tableEx allow-deferred-rendering'])[2]");
	public static final By playBook=By.xpath("(//*[@class='visual visual-image allow-deferred-rendering'])[2]");
	public static final By playBookPage_Tittle=By.xpath("//*[text()='Playbook']");
	public static final By playBookStock_Status=By.xpath("//*[contains(text(),'Stock Status')]");	
	public static final By supplySpan_LastUpdated = By.xpath("(//*[@class='value'])[1]");
	
	//filter from and To options
	public static final By dd_FromWeek = By.xpath("//*[text()='From Day']/../../../..//div[@role='combobox']");
	public static final By dd_ToWeek = By.xpath("//*[text()='To Day']/../../../..//div[@role='combobox']");
	public static final By dd_FromWeek_Options = By.xpath("(//div[@class='slicerBody'])[7]//div[@class='row']");
	public static final By dd_ToWeek_Options = By.xpath("(//div[@class='slicerBody'])[8]//div[@class='row']");
	public static final By contextMenu_Supply = By.xpath("//*[@role='menu']");
	public static final By navBtn_Analyze_Supply = By.xpath("//button[contains(@title,'Analyze')]");
	public static final By btn_Reset_Supply = By.xpath("(//*[@class='tileSVG'])[3]/../..");
	public static final By table_ItemScore_Options_Supply = By.xpath("(//div[@role='columnheader' and text()='Item Store'])[1]//ancestor::div[@class='innerContainer']//div[contains(@class,'pivotTableCellWrap cell-interactive') or contains(@class,'cell-interactive')]");
	
	
	public static final By suply_CompositeScore = By.xpath("//div[@aria-label='Composite Score' and @role='combobox']");
	

	
	
	
	
	
	
	

	
	
	
	
	

	
	
	
	
	
	

}
