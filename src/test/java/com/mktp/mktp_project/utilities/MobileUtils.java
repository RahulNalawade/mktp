package com.mktp.mktp_project.utilities;
import java.io.ByteArrayInputStream;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.aventstack.extentreports.ExtentTest;
import com.cucumber.listener.Reporter;
import com.mktp.mktp_project.prerequisites.GlobalVariables;
import com.mktp.mktp_project.prerequisites.InitialSetUp;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileBy.ByAccessibilityId;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class MobileUtils extends InitialSetUp {

	public static MobileElement element = null;
	private static final String IOS = null;
	private static final String ANDROID = null;
	static Dimension size;
	static ExtentTest logger = null;
	public static void swipeDown() {
		Dimension size = InitialSetUp.wd.manage().window().getSize();
		int startX = size.width / 2;
		int startY = (int) (size.height * 0.60);
		int endY = (int) (size.height * 0.30);
		//TouchAction action = new TouchAction(InitialSetUp.wd).press(549, 1490).waitAction(30).moveTo(549, 610).release().perform();
		//action.moveTo(startX, endY);
		TouchAction action =new TouchAction(wd).press(startX, startY).moveTo(startX, endY).release().perform();
	}


	public static void tapOnPoint(int x, int y) {
		TouchAction deleteAlbum = new TouchAction(InitialSetUp.wd);
		deleteAlbum.tap(x, y).perform();

	}

	public static void WaitUntil(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Dimension getDimensionOfScreen() {
		MobileDriver driver = InitialSetUp.wd;
		if (driver == null) {
			return null;
		} else {
			return driver.manage().window().getSize();
		}

	}

	public static Point getLocationOfElement(WebElement element) {
		if (element == null) {
			return null;
		} else {
			return element.getLocation();
		}
	}

	public static Duration getDuration(long durationInMilliSecond) {
		return Duration.between(Instant.now(),
				Instant.now().plusMillis(durationInMilliSecond));
	}

	

	public static boolean swipe(int xStartCoordinate, int yStartCoordinate,
			int xEndCoordinate, int yEndCoordinate) {

		MobileDriver driver = InitialSetUp.wd;

		StringBuilder message = new StringBuilder("Swipe : ");

		if (driver == null) {
		} else {
			try {
				TouchAction actions = new TouchAction(driver);
				actions = actions.press(xStartCoordinate, yStartCoordinate)
						.waitAction().moveTo(xEndCoordinate, yEndCoordinate)
						.release().perform();

				if (actions == null) {
					message = message.append(", not able to perform swipe.");
					String message1=message.toString();
					logger.fail(message1);
					message = null;
				} else {
					message = message.append(", swipe press successful.");
					String message1=message.toString();
					logger.pass(message1);
					message = null;
					return true;
				}
			} catch (Exception e) {
				message = message
						.append(", not able to perform swipe. Reason - ");
				message = message.append(e.getMessage());
				String message1=message.toString();
				logger.fail(message1);
				message = null;
			}
		}
		return false;
	}

	public static boolean swipe(MobileElement startElement,
			MobileElement endElement) {

		MobileDriver driver = InitialSetUp.wd;

		if (driver == null) {
		} else {

			if (startElement == null)
				return false;
			if (endElement == null)
				return false;

			StringBuilder message = new StringBuilder("Swipe : ");
			try {
				TouchAction actions = new TouchAction(driver);
				actions = actions.press(startElement).moveTo(endElement)
						.release().perform();
				if (actions == null) {
					message = message.append(", not able to perform swipe.");
					String message1=message.toString();
					logger.fail(message1);
					message = null;
				} else {
					message = message.append(", swipe press successful.");
					String message1=message.toString();
					logger.pass(message1);
					message = null;
					return true;
				}
			} catch (Exception e) {
				message = message
						.append(", not able to perform swipe. Reason - ");
				message = message.append(e.getMessage());
				String message1=message.toString();
				logger.fail(message1);
				message = null;
			}
		}
		return false;
	}


	

	public static String getAttribute(MobileElement element,
			String requiredAttribute) {
		String attribute = "";
		if (element != null) {
			attribute = element.getAttribute(requiredAttribute);
			return attribute == null ? "Attribute Not Present" : attribute;
		}

		return attribute;
	}

	public static boolean launchSettingsAppOnIOS() {

		boolean flag = false;

		MobileDriver driver = InitialSetUp.wd;

		HashMap<String, String> settings = new HashMap<>();
		settings.put("name", "Settings");
		try {
			driver.execute("mobile:application:open", settings);
		} catch (Exception e) {
		}
		flag = true;
		return flag;

	}

	public static boolean closeSettingsAppOnIOS() {

		boolean flag = false;

		MobileDriver driver = InitialSetUp.wd;

		HashMap<String, String> settings = new HashMap<>();
		settings.put("name", "Settings");

		try {
			driver.execute("mobile:application:close", settings);

		} catch (Exception e) {
		}
		return flag;
	}

	@SuppressWarnings("unused")
	private static MobileElement scrollToAndroid(String label) {

		MobileDriver driver = InitialSetUp.wd;

		if (driver != null) {
			String uiAutomator = String
					.format("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().descriptionContains(\"%s\").instance(0));new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"%s\").instance(0));",
							label, label);
			try {
				return (MobileElement) driver.findElement(MobileBy
						.AndroidUIAutomator(uiAutomator));
			} catch (Exception e) {
				return null;
			}
		} else {
			return null;
		}

	}

	@SuppressWarnings("unused")
	private static MobileElement scrollToIOS(String label) {

		MobileDriver driver = InitialSetUp.wd;
		if (driver != null) {
			try {
				FluentWait<MobileDriver> fWait = new FluentWait<MobileDriver>(
						driver);
				fWait.withTimeout(1, TimeUnit.SECONDS);
				fWait.pollingEvery(200, TimeUnit.MILLISECONDS);

				List<WebElement> element = fWait.until(ExpectedConditions
						.presenceOfAllElementsLocatedBy(ByAccessibilityId
								.id(label)));

				if (element.size() == 0) {
				} else {
					if (element.get(0).isDisplayed()) {
						return (MobileElement) element.get(0);
					} else {

						String xpathCells = String
								.format("//*[@name='%s']/ancestor::*[contains(@type,'Table')]/*[contains(@type,'Cell') and @visible='true']",
										label);

						String xpathVisibleBelow = String
								.format("//*[@name='%s']/following::*[contains(@type,'Cell') and @visible='true' and @name!='StandardLocationTrackingOn' and @value!='SSID']",
										label);

						String pageSource = driver.getPageSource();

						int direction = -1;

						int height = 0;
						int startY = 0;

						DocumentBuilderFactory builderFactory = DocumentBuilderFactory
								.newInstance();
						DocumentBuilder builder = null;
						try {
							builder = builderFactory.newDocumentBuilder();

							Document xmlDocument = (Document) builder
									.parse(new ByteArrayInputStream(pageSource
											.getBytes()));

							XPath xPath = XPathFactory.newInstance().newXPath();

							NodeList nodeCellsList = (NodeList) xPath.compile(
									xpathCells).evaluate(xmlDocument,
									XPathConstants.NODESET);

							NodeList nodeList = (NodeList) xPath.compile(
									xpathVisibleBelow).evaluate(xmlDocument,
									XPathConstants.NODESET);
							int elementsVisibleBelow = nodeList.getLength();

							Node firstCell = nodeCellsList.item(0);
							Node lastCell = nodeCellsList.item(nodeCellsList
									.getLength() - 1);

							if (elementsVisibleBelow > 0) {
								direction = 1;
								startY = Integer.parseInt(((Element) firstCell)
										.getAttribute("y").toString());
								startY = startY
										+ Integer
												.parseInt(((Element) firstCell)
														.getAttribute("height")
														.toString()) + 2;
								height = Integer.parseInt(((Element) lastCell)
										.getAttribute("y").toString());
							} else {
								startY = Integer.parseInt(((Element) lastCell)
										.getAttribute("y").toString());
								height = startY;
								// Integer.parseInt(((Element)firstCell).getAttribute("y").toString());
							}

						} catch (ParserConfigurationException e) {
						}

						while (element.size() != 0) {
							if (MobileUtils.swipe(5, startY, 5,
									(height * direction))) {
								element = fWait
										.until(ExpectedConditions
												.presenceOfAllElementsLocatedBy(ByAccessibilityId
														.id(label)));

								if (element.size() == 0) {
									break;
								} else {
									if (element.get(0).isDisplayed()) {
										return (MobileElement) element.get(0);
									}
								}
							} else {
								break;
							}
						}
					}
				}

			} catch (Exception e) {
			}
		}

		return null;
	}

	public static void clearRecentNotification() {

		MobileDriver driver = InitialSetUp.wd;
		String os = GlobalVariables.platform;
		if (driver == null) {
			return;
		}

		if (os.equalsIgnoreCase("Android")) {

			Dimension dimension = MobileUtils.getDimensionOfScreen();

			MobileUtils.swipe(5, 5, 0, dimension.getHeight() / 2);

			String xpath = "//*[@label='Recent']/following-sibling::UIAButton";
			MobileElement clear = (MobileElement) InitialSetUp.wd
					.findElement(By.xpath(xpath));
			if (clear == null) {
				// Clear button doesn't Exists
			} else {
				try {
					clear.click();

					clear = (MobileElement) InitialSetUp.wd.findElement(By
							.xpath(xpath));

					if (clear != null) {
						clear.click();
					}

					swipe(5, dimension.getHeight() - 5, 5,
							dimension.getHeight() / -2);
				} catch (Exception e) {
				}

			}
		} else {
			clearNotificationAndroidOnly();
		}
	}

	public static boolean clearNotificationAndroidOnly(String... message) {

		boolean flag = true;
		MobileDriver driver = InitialSetUp.wd;

		if (GlobalVariables.platform.equalsIgnoreCase("Android")) {

		} else {
			return false;
		}

		if (driver != null) {
			if (MobileUtils.showNotificationAndroidOnly(driver)) {
				try {
					driver.findElement(
							By.id("com.android.systemui:id/clear_all_button"))
							.click();
				} catch (Exception e) {
					try {
						driver.findElement(
								By.id("com.android.systemui:id/dismiss_text"))
								.click();
					} catch (Exception e1) {
						MobileUtils.pressBackButton();
					}
				}

			} else {
				flag = false;
			}
		} else {
			flag = false;
		}

		if (message.length > 0) {
			StringBuilder stepMess = new StringBuilder(message[0]);
			if (flag) {
				stepMess = stepMess
						.append(" Clear Notification : Cleared the notification");
				String message1=stepMess.toString();
				logger.pass(message1);
			} else {
				stepMess = stepMess
						.append(" Clear Notification : Unable to clear the notification");
				String message1=stepMess.toString();
				logger.fail(message1);
			}
		}

		return flag;
	}

	private static void pressBackButton() {
		// TODO Auto-generated method stub
		// InitialSetUp.wd.navigate().back();
		((AndroidDriver) InitialSetUp.wd).pressKeyCode(4);
	}

	public static boolean showNotificationAndroidOnly(MobileDriver driver) {

		boolean flag = true;
		AndroidDriver driver1 = (AndroidDriver) InitialSetUp.wd;
		if (driver != null) {
			try {
				((AndroidDriver) driver1).openNotifications();
				Thread.sleep(10000);
			} catch (Exception e) {
				flag = false;
			}
		} else {
			flag = false;
		}
		return flag;
	}

	public static boolean clickOnElement(MobileElement element) {
		boolean flag = true;
		element.click();
		return flag;
	}

	
	public static boolean clickOnElementUsingText(String Text) {
		boolean flag = true;
		MobileElement element=(MobileElement) InitialSetUp.wd.findElement(By.xpath("//*[contains(@text,'"+Text+"') or contains(@text,'"+Text.toUpperCase()+"')]"));
		element.click();
		return flag;
	}
	
	public static boolean clickOnElementUsingID(String Text) {
		boolean flag = true;
		MobileElement element=(MobileElement) InitialSetUp.wd.findElement(By.xpath("//*[@id="+Text+"]"));
		element.click();
		return flag;
	}
	public static boolean clearTextFiledElement(MobileElement element) {
		boolean flag = true;
		element.clear();
		return flag;
	}

	public static boolean setValueToElement(MobileElement mobElement,
			String value, String... message) {
		boolean success = true;

		if (mobElement != null) {

			for (int counter = 0; counter < 3; ++counter) {
				try {
					mobElement.sendKeys(value);
					break;
				} catch (Exception e) {
					if (counter <= 2) {
						mobElement.clear();
					} else {
						success = false;
					}
				}
			}

		} else {
			success = false;
		}

		return success;
	}



	public static String getCurrentDate() {
		// TODO Auto-generated method stubSimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//dd/MM/yyyy
		SimpleDateFormat sdfDate = new SimpleDateFormat("yyyyMMdd");
		Date now = new Date();
		sdfDate.setTimeZone(TimeZone.getTimeZone("IST"));
	    String strDate = sdfDate.format(now);
		return strDate;
	}
	
	public static String getCurrentDateTimeHr() {
		// TODO Auto-generated method stubSimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//dd/MM/yyyy
		SimpleDateFormat sdfDate = new SimpleDateFormat("yyyyMMddHH");
		Date now = new Date();
		sdfDate.setTimeZone(TimeZone.getTimeZone("IST"));
	    String strDate = sdfDate.format(now);
		return strDate;
	}

	public static String getNextDate() {
		// TODO Auto-generated method stub
		SimpleDateFormat sdfDate = new SimpleDateFormat("yyyyMMdd");
		Date now = new Date();
		sdfDate.setTimeZone(TimeZone.getTimeZone("IST"));
	    String strDate = sdfDate.format(now);
		return strDate;
	}
	
	@SuppressWarnings("static-access")
	public static boolean isElementexitsusingXpath(String element, String xpath)
	{
		boolean flag = true;
		try{
			flag=InitialSetUp.wd.findElement(By.xpath(xpath)).isDisplayed();
			if(flag)
			{
				org.testng.Reporter r= new org.testng.Reporter();
				r.log(element+" is displayed");
			}
			else
			{
				flag = false;
				org.testng.Reporter r= new org.testng.Reporter();
				r.log(element+" is not displayed");
			}
		}
		catch(NoSuchElementException e)
		{
			e.getMessage();
			flag = false;
			org.testng.Reporter r= new org.testng.Reporter();
			r.log(element+" is not displayed");
			//InitialSetUp.wd.navigate().back();
		}
		
		return flag;
	}
	
	@SuppressWarnings("static-access")
	public static boolean isElementexitsusingId(String element, String id)
	{
		boolean flag = true;
		try{
			flag=InitialSetUp.wd.findElement(By.id(id)).isDisplayed();
			if(flag)
			{
				org.testng.Reporter r= new org.testng.Reporter();
				r.log(element+" is displayed");
			}
			else
			{
				flag = false;
				org.testng.Reporter r= new org.testng.Reporter();
				r.log(element+" is not displayed");
			}
		}
		catch(NoSuchElementException e)
		{
			e.getMessage();
		}
		
		return flag;
	}
	
	@SuppressWarnings("static-access")
	public static void scrollTo(String text){  
		MobileDriver driver = InitialSetUp.wd;
		((AndroidDriver) driver).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+text+"\").instance(0))");
	   }
	
	
	public static WebElement findElementUsingString(String string, MobileDriver wd) {
		
		return element = (MobileElement) InitialSetUp.wd.findElement(By.xpath("//*[@text='"+string+"']"));

	}
	
	public static WebElement findElementUsingClass(String string, MobileDriver wd) {
			
			return element = (MobileElement) InitialSetUp.wd.findElement(By.xpath("//*[@class='"+string+"']"));
	
	}
	
	public static WebElement findElementUsingXpath(String string, MobileDriver wd) {
		
		return element = (MobileElement) InitialSetUp.wd.findElement(By.xpath(string));

}
	
	public static String ordinal(int num)
	{
	    String[] suffix = {"th", "st", "nd", "rd", "th", "th", "th", "th", "th", "th"};
	    int m = num % 100;
	    return String.valueOf(num) + suffix[(m > 3 && m < 21) ? 0 : (m % 10)];
	}
}
