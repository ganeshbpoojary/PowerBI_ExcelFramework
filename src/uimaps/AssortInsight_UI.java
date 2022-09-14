package uimaps;

import org.openqa.selenium.By;

public class AssortInsight_UI {
	public static final By opt_dropDownRowsData = By.xpath("//input[@aria-label='Search']//ancestor::div[@class='slicer-dropdown-content']//div[@class='slicerBody']//div[@class='row']");
	
	public static final By title_AssortmentPerformance =By.xpath("//*[contains(text(),'Assortment Performance')]/..");
	public static final By title_ProductPerformance =By.xpath("//*[contains(text(),'Product Performance')]//ancestor::div[@class='visual visual-actionButton allow-deferred-rendering']");
	public static final By title_StorePerformance =By.xpath("//*[contains(text(),'Store Performance')]//ancestor::div[@class='visual visual-actionButton allow-deferred-rendering']");
	
		
	public static final By AssortPerformTableChart=By.xpath("//*[@class='visual visual-tableEx allow-deferred-rendering']");
	public static final By AssortActualvsBudgetSalesChart=By.xpath("//*[@aria-label='Actual Vs Budget Sales ']");
	public static final By AssortActualvsBudgetMarginChart=By.xpath("//*[@aria-label='Actual Vs Budget Margin '] ");
	public static final By AssortSalesButton=By.xpath("//*[text()='Sales']//ancestor::div[@class='contentContainer']");
//	public static final By AssortMarginButton=By.xpath("//*[text()='Margin']//ancestor::div[@class='contentContainer']");
	public static final By AssortMarginButton=By.xpath("(//*[text()='Margin']/..)[2]");
	public static final  By label_Lastupdated = By.xpath("//*[contains(text(),'Last updated')]");
	public static final  By AssortSearch = By.xpath("//input[@aria-label='Search']");
	
//	
	
	
	public static final By ProductPerformanceTableChart=By.xpath("//*[@class='visual visual-tableEx allow-deferred-rendering']");
	public static final By ProductPerformanceOverallPerf=By.xpath("//*[@class='visual-sandbox']");
	public static final By ProductPerfProductInsight=By.xpath("//*[contains(text(),'Product Insight')]//ancestor::div[@class='visual visual-actionButton allow-deferred-rendering']");
	public static final By ProductPatrioSalesButton=By.xpath("//*[text()='Sales']//ancestor::div[@class='slicerText flexDisplay']");
	public static final By ProductPatrioUnitsButton=By.xpath("//*[text()='Units']//ancestor::div[@class='slicerText flexDisplay']");
	public static final By ProductParetoMarginButton=By.xpath("//*[text()='Margin']//ancestor::div[@class='slicerText flexDisplay']");
	public static final By ProductParetoChart=By.xpath("//*[@class='visual visual-lineStackedColumnComboChart allow-deferred-rendering']");
	public static final By ProductParetocumulative=By.xpath("//*[@aria-label='Cumulative Sales %']");
	public static final By StorePerformanceTableChart=By.xpath("//*[@class='visual visual-tableEx allow-deferred-rendering']");
	public static final By StorePerfProductInsight=By.xpath("//*[contains(text(),'Store Insight')]//ancestor::div[@class='visual visual-actionButton allow-deferred-rendering']");
	public static final By StorePerfCPIBYStoreID=By.xpath("//*[@aria-label='CPI by Store ID ']");
	
	
	
	
	
	////*[@class='y axis showLinesOnAxis']
}
