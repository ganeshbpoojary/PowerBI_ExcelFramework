package uimaps;

import org.openqa.selenium.By;



public class Shopper_UI {
	
	public static final By tab_MarketBasketAnalysis=By.xpath("//div[contains(text(),'Market Basket Analysis')]//ancestor::div[@class='contentOuterContainer']/..");
	public static final By tab_MissionTripAnalysis=By.xpath("//div[contains(text(),'Mission Trip Analysis')]//ancestor::div[@class='contentOuterContainer']/..");
	
	public static final By chart_TopDistrictContribution_Option=By.xpath("//*[@class='scatterMarkerSeriesGroup']//*[@class='scatterMarker setFocusRing']");
	public static final By chart_TopDistrictContribution_PopMessage=By.xpath("//div[@id='screen_reader_alert_assertive']");

	
	
	public static final By dd_options_supplier=By.xpath("//input[@aria-label='Search']//ancestor::div[@class='slicer-dropdown-content']//div[@class='slicerBody']//div[@class='row']");	
	
	
}
