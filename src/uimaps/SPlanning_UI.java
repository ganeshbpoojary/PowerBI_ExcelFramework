package uimaps;

import org.openqa.selenium.By;

public class SPlanning_UI {

	public static final By resetCalenderbutton= By.xpath("//*[text()=\"Reset Calendar\"]");
	public static final By alertMorebutton=By.xpath("//div[text()='Details']/..");
	public static final By alertSubCategory=By.xpath("//*[@class='innerContainer']");
	public static final By resetStatus= By.xpath("//text[text()=\"Y\"]");
	public static final By proeffPublished=By.xpath("//text[text()=\"Published\"]");
	public static final By proeffLive=By.xpath("(//text[text()=\"Live\"])[2]");
	public static final By plstatusASO=By.xpath("//text[text()=\"ASO\"]");
	public static final By plstatusSO=By.xpath("//text[text()=\"SO\"]");
	public static final By plstatusPending=By.xpath("//text[text()=\"Pending\"]");
	public static final By plstatusLive=By.xpath("(//text[text()=\"Live\"])[1]");
	public static final By planogramchart=By.xpath("//*[@class='slice setFocusRing' and //*[contains(text(),'Planogram Status') ]]");
	public static final By lasteUpdateDate=By.xpath("//*[@transform=\"translate(141,20.80127136486192)\"]");
	public static final By filterSearchButton=By.xpath("//*[@title=\"Search\"]");
	public static final By sales=By.xpath("//*[@title=\"Sales\"]");
	public static final By spaceProductivity=By.xpath("(//*[@class=\"fill ui-role-button-fill\"])[2]");
	public static final By salesOthers=By.xpath("//*[@title=\"Sales Others\"]"); 
	public static final By saleslinear =By.xpath("//*[@title=\"Sales/Linear\"]");
	public static final By  saleslinearOthers=By.xpath("//*[@title=\"Sales/Linear Others\"]");
	public static final By units =By.xpath("//*[@title=\"Units\"]");
	public static final By unitsOthers=By.xpath("//*[@title=\"Units Others\"]");
	public static final By unitlinear =By.xpath("//*[@title=\"Units/Linear\"]");
	public static final By  unitlinearOthers=By.xpath("//*[@title=\"Units/Linear Others\"]");
	public static final By profit =By.xpath("//*[@title=\"Profit\"]");
	public static final By profitOthers=By.xpath("//*[@title=\"Profit Others\"]");
	public static final By marginlinear =By.xpath("//*[@title=\"Margin/Linear\"]");
	public static final By  marginlinearOthers=By.xpath("//*[@title=\"Margin/Linear Others\"]");
	public static final By investigateButton=By.xpath("//*[text()='Investigate']/..");
	public static final By displayInsight =By.xpath("(//*[@class=\"visual visual-image allow-deferred-rendering\"])[3]");
	public static final By Storeinsighttable=By.xpath("//*[@class=\"visual visual-tableEx allow-deferred-rendering\"]"); 
	public static final By investigateback=By.xpath("//*[@clip-path=\"url(#clipPath47465714-8b5d-7dd8-5dc2-ca8b5fac6f75)\"]");
	public static final By spaceToggle=By.xpath("(//*[@class=\"visual visual-image allow-deferred-rendering\"])[2]");
	public static final By chart_ResetCalender = By.xpath("//div[contains(@aria-label,'Reset Calendar') and @role='group']//*[@class='axisGraphicsContext columnChart']");
	public static final By toggleOffQuestions=By.xpath("//*[@class=\"visual visual-actionButton allow-deferred-rendering\"]");
	public static final By movement_NPE_AE=By.xpath("//div[@class='content text ui-role-button-text' and contains(text(),'Movement-NPI/AE')]");
//	public static final By movement_NPE_AE=By.xpath("//*[@class=\"visualContainer unselectable droppableElement ui-droppable readMode hideBorder paddingDisabled noVisualTitle visualHeaderAbove\"]//*[@id=\"containerf287e281-4aca-53b8-2dae-25e246e8d193\"]");
	public static final By MovementNPIChart=By.xpath("(//*[@class=\"cartesianChart\"])[2]");
	public static final By MovementAEChart=By.xpath("(//*[@class=\"cartesianChart\"])[2]");
		
//	Capacity vs Demand ******   InventoryTurns- Branch1
	
	public static final  By lnk_InventoryTurns = By.xpath("//div[@aria-label='Bookmark . Navigate to Inventory Turns']");
	public static final By label_InventoryTurns = By.xpath("//div[@class='content text ui-role-button-text' and text()='Inventory Turns']");
	public static final By chart_InventoryTurns = By.xpath("//div[contains(@aria-label,'Inventory Turns') and @role='group']//*[@class='axisGraphicsContext columnChart']");
	public static final  By title_InventoryTurnsCard1 = By.xpath("//div[@class='content text ui-role-button-text' and text()='Inventory Turns']");
	public static final  By title_InventoryTurnsCard2 = By.xpath("//div[@title='Inventory Turns']");
	public static final  By label_Lastupdated = By.xpath("//*[contains(text(),'Last updated')]");

	public static final  By bulb_DisplayInsights = By.xpath("//div[@aria-label='Bookmark . Display Insights']");
	public static final  By opt_DisplayInsightsRows = By.xpath("//div[@class='bodyCells']//div[@role='row']");
	public static final  By btn_DisplayInsightsBackButton = By.xpath("(//*[@class='tileSVG'])[4]");

	public static final By lnk_CapacityDemand = By.xpath("//div[@aria-label='Bookmark . Navigate to Capacity vs Demand']");
	public static final By chart_CapacityDemand = By.xpath("//div[contains(@aria-label,'Capacity vs Demand')]");
	


	
	
	

    


}
