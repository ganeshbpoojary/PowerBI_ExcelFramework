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
	
	
	public static final  By btn_Understand = By.xpath("//*[contains(@aria-label,'DrillDownMeasure Understand')]/..");
	public static final  By navBtn_DrillThrough = By.xpath("//button[@title='Drill through']");
	public static final  By navBtn_Understand = By.xpath("//button[@title='Understand']");
	
	public static final  By title_Understand = By.xpath("//div[text()='Understand']//ancestor::div[@class='contentTable']");
	
	


	
}
