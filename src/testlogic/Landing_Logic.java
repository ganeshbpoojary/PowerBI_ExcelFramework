package testlogic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.LogStatus;
import com.thoughtworks.selenium.webdriven.commands.IsVisible;

import frameworkutils.DataBook;
import frameworkutils.WebDriverFactory;
import uimaps.APPM_UI;

public class Landing_Logic extends WebDriverFactory {

	public Landing_Logic(WebDriver driver, Map<String, String> dataBook) {
		super(driver, dataBook);
	}

	String url = dataBook.get("Url");
	String email = dataBook.get("Email");
	String pwd = dataBook.get("Password");
	String filterName = dataBook.get("Fliter_Name");
	String filterOption = dataBook.get("Filter_Option");
	String chartName = dataBook.get("Chart_Name");
	String summaryHeader = dataBook.get("SummaryColumn_Header");
	String detailHeader = dataBook.get("DetailedViewColumn_Header");

	
	public void login() {
		synchronized (Landing_Logic.class) {
			try {
				refreshDataBook();
				launchAPP(url);
				waitForPageToLoad();
				Thread.sleep(1000);
				typeIn(APPM_UI.txt_email, email);
				clickOn(APPM_UI.btn_submitPowerBI);
				waitForPageToLoad();
				typeIn(APPM_UI.txt_password, pwd);
				clickOn(APPM_UI.btn_signinBY);
				clickOn(APPM_UI.btn_yesBY);
				waitForPageToLoad();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}