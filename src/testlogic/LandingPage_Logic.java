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
import uimaps.LandingPage_UI;

public class LandingPage_Logic extends WebDriverFactory {

	public LandingPage_Logic(WebDriver driver, Map<String, String> dataBook) {
		super(driver, dataBook);
	}

	String url = dataBook.get("Url");
	String email = dataBook.get("Email");
	String pwd = dataBook.get("Password");

	
	public void login() {
		synchronized (LandingPage_Logic.class) {
			try {
				refreshDataBook();
				launchAPP(url);
				waitForPageToLoad();
				Thread.sleep(1000);
				typeIn(LandingPage_UI.txt_email, email);
				clickOn(LandingPage_UI.btn_submitPowerBI);
				waitForPageToLoad();
				typeIn(LandingPage_UI.txt_password, pwd);
				clickOn(LandingPage_UI.btn_signinBY);
				clickOn(LandingPage_UI.btn_yesBY);
				waitForPageToLoad();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}