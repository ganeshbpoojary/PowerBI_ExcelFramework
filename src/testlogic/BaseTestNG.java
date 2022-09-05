package testlogic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import net.sourceforge.stripes.util.ResolverUtil;
import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.apache.bcel.util.ClassLoader;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.SessionNotFoundException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.TestListenerAdapter;
import com.relevantcodes.extentreports.LogStatus;
import frameworkutils.DataBook;
import frameworkutils.ExtentManager;
import frameworkutils.ExtentTestManager;
import frameworkutils.FileHandler;
import frameworkutils.WebDriverFactory;
import junit.framework.AssertionFailedError;

/**
 * Base TestNG class which invokes multiple test cases in parallel for execution
 */

@SuppressWarnings("deprecation")
public class BaseTestNG extends TestListenerAdapter {
	private final static boolean quitDriver = false;
	private final static int IMPLICIT_WAIT_TIMEOUT = 120; // in seconds
	private final static int PAGELOAD_WAIT_TIMEOUT = 120; // in seconds
	public WebDriver driver = null;
	
	@DataProvider(name = "DataProvider", parallel = false)
	public static Object[][] getData() {
		ArrayList<ArrayList<HashMap<String, String>>> executionDetails = new ArrayList<ArrayList<HashMap<String, String>>>();
		FileHandler.closeExcelFile();
		ArrayList<String> testSuites = getTestSuiteFiles();
		for (String testSuite : testSuites) {
			ArrayList<ArrayList<HashMap<String, String>>> executionDetail = DataBook.getExecutableTestCases(testSuite);
			executionDetails.addAll(executionDetail);
		}

		// Iterate though arrayList to cast it into Object[][]
		Object[][] testExecutionSequence = new Object[executionDetails.size()][1];
		int i = 0;
		for (ArrayList<HashMap<String, String>> eachTestCaseSequnce : executionDetails) {
			testExecutionSequence[i++][0] = eachTestCaseSequnce;
		}
		return testExecutionSequence;
	}

	@BeforeSuite
	public void killProcess() {
		try {
//			Runtime.getRuntime().exec("Taskkill /IM IEDriverServer.exe /F");
			Runtime.getRuntime().exec("Taskkill /IM chromedriver.exe /F");
		} catch (Exception e) {
			System.out.println("ie driver is not present");
			System.out.println("chrome driver is not present");
		}
	}

	@BeforeMethod
	public void beforeMethod(Method caller) {
		ExtentTestManager.startTest(caller.getName());
	}
	


	@Test(dataProvider = "DataProvider")
	public void BaseTestNGExecutor(List<HashMap<String, String>> executionFlow) {
//		WebDriver driver = null;
		HashMap<String, String> callee = null;
		try {
			try {
				boolean initialized = false;
				List<Object> testClassInstances = null;
				Map<String, String> dataBook = null;
				for (int exeCounter = 0; exeCounter < executionFlow.size(); exeCounter++) {
					callee = executionFlow.get(exeCounter);
					String testCaseID = callee.get("TestCaseID");
					String methodName = callee.get("CallSequence");
					String testDataSheetName = callee.get("DataSheet");
					String testCaseIteration = callee.get("Iteration");
					String testCaseDescription = callee.get("Description");
					String fileName = callee.get("SuiteFileName");
					DataBook.updateMasterControllerStatus(callee, "Fail");
					dataBook = DataBook.getRunTimeData(testCaseID, testCaseIteration, fileName, testDataSheetName);
					if (!initialized) {
						driver = initializeWebDriver(dataBook.get("Browser"));
						testClassInstances = getSubClassObjectOfWebDriverFactory(driver, dataBook);
						initialized = true;
					}
					Object[][] objInstanceWithMethod = getInstanceOfDeclaredMethod(testClassInstances, methodName);
					if (exeCounter == 0) {/* To rename the default TestCase Descriptions in Report */
						ExtentTestManager.getTest().setDescription(testCaseDescription);
						ExtentTestManager.getTest().getTest().setName(testCaseID + "-" + testCaseIteration);
					}
					if (objInstanceWithMethod != null) {
						Method method = (Method) objInstanceWithMethod[0][1];
						if (method.getParameterCount() == 0) {
							ExtentTestManager.getTest().log(LogStatus.INFO, "<B>** " + methodName + " **</B>",
									"<B>** " + methodName + " </B>** is being executed");
							method.invoke(objInstanceWithMethod[0][0]);
							DataBook.updateTestStepStatus(callee, ExtentTestManager.getTest().getRunStatus().name());
							if (ExtentTestManager.getTest().getRunStatus().name().equalsIgnoreCase("FAIL")) {
								Assert.fail();
							}
						} else {
							ExtentTestManager.getTest().log(LogStatus.ERROR,
									"Method [" + methodName + "]should not contain any parameters",
									"Method contains parameters, expected: method with no parameters");
							Assert.fail();
						}
					} else {
						ExtentTestManager.getTest().log(LogStatus.ERROR,
								"Specified method name <B>[" + methodName + "]</B> should exist",
								"Specified method name doesn't exist in any of classes which are extending <B>WebDriverFactory</B> class");
						Assert.fail();
					}
				}
				DataBook.updateMasterControllerStatus(callee, ExtentTestManager.getTest().getRunStatus().name());
			} catch (InstantiationException e) {
				e.printStackTrace();
				Assert.fail();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
				Assert.fail();
			} catch (SecurityException e) {
				e.printStackTrace();
				Assert.fail();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
				Assert.fail();
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
				Assert.fail();
			} catch (Exception ex) {
				ex.printStackTrace();
				ExtentTestManager.getTest().log(LogStatus.FAIL, ex.getMessage());
				Assert.fail();
			}
		} catch (AssertionError e) {
			DataBook.updateMasterControllerStatus(callee, ExtentTestManager.getTest().getRunStatus().name());
			throw e;
		} finally {
			if (quitDriver) {
				if (!driver.toString().contains("null")) {
					driver.quit();
				}
			}
		}
	}

	@AfterMethod
	public void afterMethod(ITestResult result) {
		if (result.isSuccess()) {
			ExtentTestManager.getTest().log(LogStatus.PASS, "Test passed", "Test passed");
			driver.close();
		} else if (result.getStatus() == ITestResult.FAILURE) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Test failed", "Test failed");
		} else if (result.getStatus() == ITestResult.SKIP) {
			ExtentTestManager.getTest().log(LogStatus.SKIP, "Test skipped", "Test skipped");
		}
		ExtentTestManager.endTest();
		ExtentManager.getInstance().flush();
		
	}

	/**
	 * 
	 * Returns list of instantiated objects which has extended WebDriverFactory
	 * Class
	 * 
	 * @return ArrayList of instantiated object of classes with have inherited
	 *         WebDriverFactory.class
	 * 
	 * @throws InstantiationException
	 * 
	 * @throws IllegalAccessException
	 * 
	 * @throws SecurityException
	 * 
	 * @throws NoSuchMethodException
	 * 
	 * @throws InvocationTargetException
	 * 
	 * @throws IllegalArgumentException
	 * 
	 */

	private List<Object> getSubClassObjectOfWebDriverFactory(WebDriver driver, Map<String, String> dataBook)
			throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException,
			NoSuchMethodException, SecurityException {
		List<Object> classInstances = new ArrayList<Object>();
		ResolverUtil<WebDriverFactory> resolver = new ResolverUtil<WebDriverFactory>();
		resolver.findImplementations(WebDriverFactory.class, "frameworkutils", "testlogic");
		Set<Class<? extends WebDriverFactory>> classes = resolver.getClasses();
		for (Class<? extends WebDriverFactory> clazz : classes) {
			if (!clazz.toString().contains("frameworkutils.WebDriverFactory")) {
				classInstances.add(clazz.asSubclass(clazz).getConstructor(WebDriver.class, Map.class)
						.newInstance(driver, dataBook));
			}
		}
		return classInstances;
	}

	/**
	 * 
	 * Returns the instance of a class by matching each methods of class contained
	 * in classInstances
	 * 
	 * @param classInstances ArrayList containing instances of classes
	 * 
	 * @param MethodName     Member Function Name of a Class that needs to be
	 *                       invoked
	 * 
	 * @return Object - instance of a class
	 * 
	 */

	private Object[][] getInstanceOfDeclaredMethod(List<Object> classInstances, String MethodName) {
		for (int index = 0; index < classInstances.size(); index++) {
			Method[] methods = classInstances.get(index).getClass().getDeclaredMethods();
			for (int mIndex = 0; mIndex < methods.length; mIndex++) {
				if (methods[mIndex].getName().toUpperCase().equals(MethodName.toUpperCase())) {
					return new Object[][] { { classInstances.get(index), methods[mIndex] } };
				}
			}
		}
		return null;
	}

	/**
	 * 
	 * Returns the WebDriver instance based on BrowserName
	 * 
	 * @param browserName "IEXPLORE", "FIREFOX"
	 * 
	 * @return Instance of WebDriver or null
	 * 
	 */

	private WebDriver initializeWebDriver(String browserName) {
		Properties property = new Properties();
		WebDriver driver = null;
		try {
			property.load(new FileInputStream("SeleniumConstants.properties"));
			if (browserName.equalsIgnoreCase("IEXPLORE")) {
				String ieDriverPath = System.getProperty("user.dir") + File.separator
						+ property.getProperty("ieDriverFileName");
				System.setProperty("webdriver.ie.driver", ieDriverPath);
				DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
				ieCapabilities.setCapability("nativeEvents", true);
				ieCapabilities.setCapability("unexpectedAlertBehaviour", "accept");
				ieCapabilities.setCapability("ignoreProtectedModeSettings", true);
				ieCapabilities.setCapability("disable-popup-blocking", true);
				ieCapabilities.setCapability("enablePersistentHover", true);
				ieCapabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
				driver = new InternetExplorerDriver();
			} else if (browserName.equalsIgnoreCase("FIREFOX")) {
				driver = new FirefoxDriver();
			} else if (browserName.equalsIgnoreCase("CHROME")) {
				String chromeDriverPath = System.getProperty("user.dir") + File.separator
						+ property.getProperty("chromeDriverFileName");
				System.setProperty("webdriver.chrome.driver", chromeDriverPath);
				driver = new ChromeDriver();
			}else if (browserName.equalsIgnoreCase("HEADLESS")) {
				String chromeDriverPath = System.getProperty("user.dir") + File.separator
						+ property.getProperty("chromeDriverFileName");
				System.setProperty("webdriver.chrome.driver", chromeDriverPath);
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless");
				driver = new ChromeDriver(options);
			} else {
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Valid Browser Names are [IEXPLORE, FIREFOX]",
						"Invalid Browser<B>" + browserName + "</B> has been passed");
				return null;
			}
			driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT_TIMEOUT, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(PAGELOAD_WAIT_TIMEOUT, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			return driver;
		} catch (SessionNotFoundException snfex) {
			if (snfex.getMessage().contains("Protected Mode settings are not the same for all zones"))
				ExtentTestManager.getTest().log(LogStatus.WARNING, "launch App",
						"Protected Mode settings are not the same for all zones. Goto Tools --> internet Options --> Security (Enable Protected Mode should be enabled/disabled for all zone.)");
			else
				ExtentTestManager.getTest().log(LogStatus.WARNING, "launch App", snfex.getMessage());
			return null;
		} catch (Exception ex) {
			ExtentTestManager.getTest().log(LogStatus.WARNING, "launch App", ex.getMessage());
			return null;
		}
	}

	/**
	 * 
	 * Returns the path names of the excel file that are set for execution
	 * 
	 * @return ArrayList - containing files names of excel that matches rules of
	 *         TestSuite
	 * 
	 */

	private static ArrayList<String> getTestSuiteFiles() {
		ArrayList<String> masterSheetColumnNames = new ArrayList<String>();
		ArrayList<String> executionFlowColumnNames = new ArrayList<String>();
		masterSheetColumnNames.add("TestCaseID");
		masterSheetColumnNames.add("Description");
		masterSheetColumnNames.add("IterationCount");
		masterSheetColumnNames.add("ExecutionRequired");
		executionFlowColumnNames.add("TestCaseID");
		executionFlowColumnNames.add("CallSequence");
		executionFlowColumnNames.add("DataSheet");
		File dir = new File("./test-data");
		File[] files = dir.listFiles(new FilenameFilter() {
			public boolean accept(File dir, String filename) {
				return (filename.endsWith(".xlsx") && !filename.startsWith("~$"));
			}
		});
		boolean isMasterControllerSheetPresent, isExecutionFlowSheetPresent;
		boolean areMasterColumnsPresent = true, areExecutionColumnPresent = true;
		ArrayList<String> fileNames = new ArrayList<String>();
		for (File file : files) {
			// Initialised to check if expected MasterController,ExecutionFlow Sheets are
			// present or not
			isMasterControllerSheetPresent = false;
			isExecutionFlowSheetPresent = false;
			FileInputStream fis;
			try {
				fis = new FileInputStream(file);
				XSSFWorkbook workbook = new XSSFWorkbook(fis);
				int sheetCount = workbook.getNumberOfSheets();
				for (int iSht = 0; iSht < sheetCount; iSht++) {
					String sheetName = workbook.getSheetName(iSht);
					if (sheetName.equals("MasterController")) {
						isMasterControllerSheetPresent = true;
						Row firstRow = workbook.getSheet(sheetName).getRow(0);
						int cellCount = firstRow.getLastCellNum();
						ArrayList<String> actualColumnNames = new ArrayList<String>();
						for (int iCell = 0; iCell < cellCount; iCell++) {
							String cellValue = firstRow.getCell(iCell).getStringCellValue().toString();
							actualColumnNames.add(cellValue);
						}
						for (String columnName : masterSheetColumnNames) {
							if (!actualColumnNames.contains(columnName)) {
								areMasterColumnsPresent = false;
								break;
							}
						}
					} else if (sheetName.equals("ExecutionFlow")) {
						isExecutionFlowSheetPresent = true;
						Row firstRow = workbook.getSheet(sheetName).getRow(0);
						int cellCount = firstRow.getLastCellNum();
						ArrayList<String> actualColumnNames = new ArrayList<String>();
						for (int iCell = 0; iCell < cellCount; iCell++) {
							String cellValue = firstRow.getCell(iCell).getStringCellValue().toString();
							actualColumnNames.add(cellValue);
						}
						for (String columnName : executionFlowColumnNames) {
							if (!actualColumnNames.contains(columnName)) {
								areExecutionColumnPresent = false;
								break;
							}
						}
					}
				}
				if (isExecutionFlowSheetPresent && isMasterControllerSheetPresent) {
					if (areMasterColumnsPresent && areExecutionColumnPresent) {
						fileNames.add(file.getCanonicalPath());
					} else {
						if (!areMasterColumnsPresent) {
							System.err.println("[info] Expected columns " + masterSheetColumnNames
									+ " are not present in file: " + file.getName() + " for Sheet[MasterController]");
						}
						if (!areExecutionColumnPresent) {
							System.err.println("[info] Expected columns " + executionFlowColumnNames
									+ " are not present in file: " + file.getName() + " for Sheet[ExecutionFlow]");
						}
					}
				} else {
					System.err.println("[info] Either of [MasterController,ExecutionFlow] Sheet is missing in file: "
							+ file.getName());
				}
				fis.close();
				workbook.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return fileNames;
	}

	@AfterSuite
	public void afterSuite() {
		ExtentManager.getInstance().flush();
		try {
			Desktop.getDesktop().browse(new File(ExtentManager.reportFileName).getCanonicalFile().toURI());			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

}
