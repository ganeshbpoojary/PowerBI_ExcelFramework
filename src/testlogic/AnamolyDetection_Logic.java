package testlogic;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.LogStatus;

import frameworkutils.WebDriverFactory;
import uimaps.AnamolyDetection_UI;


public class AnamolyDetection_Logic extends WebDriverFactory {

	public AnamolyDetection_Logic(WebDriver driver, Map<String, String> dataBook) {
		super(driver, dataBook);
		// TODO Auto-generated constructor stub
	}
	
	String url = dataBook.get("Url");
	String email = dataBook.get("Email");
	String pwd = dataBook.get("Password");
	String filterName = dataBook.get("Fliter_Name");
	String filterOption = dataBook.get("Filter_Option");
	String chartName = dataBook.get("Chart_Name");
	String summaryHeader = dataBook.get("SummaryColumn_Header");
	String detailHeader = dataBook.get("DetailedViewColumn_Header");
	
	
	public void validateDropDownHasData_Anamoly() {

		synchronized (AnamolyDetection_Logic.class) {
			try {
				waitForPageToLoad();
				clickonFilterandValidatethedata_Anamoly(filterName);
				extentTest.log(LogStatus.PASS, "Drop Down Data presence validation", "Drop Down has Data");
			}				
			 catch (Exception e) {
				// TODO Auto-generated catch block
				 extentTest.log(LogStatus.FAIL, "Drop Down Data presence validation", "Drop Down has no Data");
				e.printStackTrace();
			}
		}
	}
	
	//Validate value in the dropdown
	public void validateValueInDropDown_Anamoly() {
		synchronized (AnamolyDetection_Logic.class) {
			try {
				waitForPageToLoad();
				clickonFilterandValidatethedata_Anamoly(filterName);
				checkDropDownForOption_Anamoly(filterOption);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void clickonFilterandchecktheSearchButton_Anamoly()
	{
		synchronized (AnamolyDetection_Logic.class) {
			try {
				 waitForPageToLoad();
				 isDisplayed(AnamolyDetection_UI.AnamolySearch);
				 extentTest.log(LogStatus.PASS, "Anamoly Search is enabled", "Anamoly Search  has Data");
			
			}
			catch (Exception e) {
				// TODO Auto-generated catch block
				 extentTest.log(LogStatus.FAIL, "Anamoly Search  disabled", "Anamoly Search  has no Data");
				e.printStackTrace();
			}
		}
	    
	   
	    }
	//check dropdown option in the dropdown list 
	private boolean checkDropDownForOption_Anamoly(String opt) {
		waitForPageToLoad();
		int rows = getFilterDropDownRowCount_Anamoly();
		for (int i = 1; i <= rows; i++) {
			String value = driver.findElement(By.xpath(
					"(//input[@aria-label='Search']//ancestor::div[@class='slicer-dropdown-content']//div[@class='slicerBody']//div[@class='row'])["
							+ i + "]//span[@class='slicerText']"))
					.getText();
			if (value.equals(opt)) {
				extentTest.log(LogStatus.INFO, "checkDropDownForOption: ", "Option is present- <B>[" + opt + "]</B>");
				return true;
			} else {
				extentTest.log(LogStatus.FAIL, "checkDropDownForOption: ",
						"Option is not present- <B>[" + opt + "]</B>");
			}
		}
		return false;
	}
	
	private int getFilterDropDownRowCount_Anamoly() {
		WebDriverWait wait = new WebDriverWait(driver, 1200);
		wait.until(ExpectedConditions.visibilityOfElementLocated(AnamolyDetection_UI.opt_dropDownRowsData));
		try {
			List<WebElement> rows = driver.findElements(AnamolyDetection_UI.opt_dropDownRowsData);
			int size = rows.size();
			extentTest.log(LogStatus.INFO, "getDropDownRowCount: ", "Number of rows is- <B>[" + size + "]</B>");
			return size;
		} catch (NoSuchElementException nsex) {
			return -1;
		}
	}


	private void clickonFilterandValidatethedata_Anamoly(String Filtername) {
		// TODO Auto-generated method stub
		waitForPageToLoad();
	    driver.findElement(By.xpath("//*[@aria-label='"+Filtername+"']//ancestor::div[contains(@class,'slicer-container')]//div[@class='slicer-dropdown-menu']")).click();
	    List<WebElement> checkboxes = driver.findElements(By.xpath("//*[@class='slicerCheckbox']"));
	    if (checkboxes.size()>0) {
//	        driver.findElement(By.xpath("//*[@aria-label='"+Filtername+"']//ancestor::div[contains(@class,'slicer-container')]//div[@class='slicer-dropdown-menu']")).click();
	    	return ;
	    }
	}

}
