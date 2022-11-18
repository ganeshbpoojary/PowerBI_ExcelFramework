package testlogic;

import java.io.FileInputStream;
import java.util.Map;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import frameworkutils.WebDriverFactory;
import uimaps.LandingPage_UI;

public class LandingPage_Logic extends WebDriverFactory {

	public LandingPage_Logic(WebDriver driver, Map<String, String> dataBook) {
		super(driver, dataBook);
	}
	String url = dataBook.get("Url");
	public void login() {
		synchronized (LandingPage_Logic.class) {
			Properties property = new Properties();
			try {
				property.load(new FileInputStream("SeleniumConstants.properties"));
				waitForPageToLoad();
				String email = property.getProperty("username");
				String pwd = property.getProperty("password");
//				refreshDataBook();				
				launchAPP(url);
				waitForPageToLoad();
//				Thread.sleep(2000);
				waitForElementTobeClickable(LandingPage_UI.txt_email);
				typeIn(LandingPage_UI.txt_email, email);
				clickOn(LandingPage_UI.btn_submitPowerBI);
				waitForPageToLoad();
				typeIn_Password(LandingPage_UI.txt_password, pwd);
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