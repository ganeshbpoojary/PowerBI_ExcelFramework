package uimaps;

import org.openqa.selenium.By;



public class APPM_UI {
	
	public static final By txt_email=By.xpath("//input[@id='email']");
	public static final By txt_password=By.name("passwd");
	public static final By btn_submitPowerBI=By.id("submitBtn");
	public static final By btn_signinBY=By.xpath("//input[contains(@id,'idSIButton')]");
	public static final By btn_yesBY=By.xpath("//input[@value='Yes']");
	
	public static final By dd_productHierarchy=By.xpath("//*[@title='Product Hierarchy']//ancestor::div[contains(@class,'slicer-container')]//div[@class='slicer-dropdown-menu']");
	public static final By opt_dropDownRowsData = By.xpath("//input[@aria-label='Search']//ancestor::div[@class='slicer-dropdown-content']//div[@class='slicerBody']//div[@class='row']");
	                                                        //input[@aria-label='Search']//ancestor::div[@class='slicer-dropdown-content']//div[@class='slicerBody']//div[@class='row']
	public static final By header_SummaryChart = By.xpath("//div[@class='innerContainer']//div[text()='Routing' or text()='Destination']");
	
	public static final By row_SummaryChart_option1=By.xpath("//div[contains(@class,'expandableCell cell-interactive')]");
	public static final By row_SummaryChart_option2=By.xpath("//div[contains(@class,'rowHeaders')]//div[contains(@class,'pivotTableCellWrap cell-interactive')]");
	
	public static final By btn_DeepDiveProperty=By.xpath("//div[text()='Deep dive']");
	public static final By btn_DeepDive=By.xpath("//div[text()='Deep dive']//ancestor::div[@class='contentOuterContainer']/..");
	public static final By table_DeepDive=By.xpath("//*[@class='tableExContainer']");
	
	public static final By tab_leadTimeAnalysis=By.xpath("//div[contains(text(),'Lead Time Analysis')]//ancestor::div[@class='contentOuterContainer']/..");	
	public static final By tab_Yield=By.xpath("//div[contains(text(),'Yield')]//ancestor::div[@class='contentOuterContainer']/..");
	public static final By tab_Capacity=By.xpath("//div[contains(text(),'Capacity')]//ancestor::div[@class='contentOuterContainer']/..");
	
	public static final By btn_SupplierLeadTime=By.xpath("//div[text()='Supplier lead time']//ancestor::div[@class='contentOuterContainer']/..");
	public static final By btn_DistributionLeadTime=By.xpath("//div[text()='Distribution lead time']//ancestor::div[@class='contentOuterContainer']/..");
	public static final By btn_ProductionYield=By.xpath("//div[text()='Production Yield']//ancestor::div[@class='contentOuterContainer']/..");
	public static final By btn_ProductionRate=By.xpath("//div[contains(text(),'Production rate')]//ancestor::div[@class='contentOuterContainer']/..");
	
	public static final By frame_DataDistribution=By.xpath("//iframe[@name='visual-sandbox']");
	public static final By chart_DataDistribution=By.xpath("//div[@id='sandbox-host']");	
	
	public static final By btn_DetailedViewChart=By.xpath("//div[contains(text(),'Detailed view') or contains(text(),'Detailed View')]//ancestor::div[@class='contentOuterContainer']/..");	
	public static final By btn_SummaryViewChart=By.xpath("//div[contains(text(),'Summary')]//ancestor::div[@class='contentOuterContainer']/..");
	
	
	
	
	
	
	
//	public static final By btnlogout=By.xpath("//img[@src='/WebTours/images/in_home.gif']/..");  // UserName

}
