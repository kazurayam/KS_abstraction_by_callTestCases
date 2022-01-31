package util

import org.openqa.selenium.WebDriver
import org.openqa.selenium.ie.InternetExplorerDriver

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

public class Launch {

	@Keyword
	public static void test() {

		String path = RunConfiguration.getProjectDir() + "/driver/IEDriverServer.exe"

		System.setProperty('webdriver.ie.driver', path)

		WebDriver driver = new InternetExplorerDriver()

		DriverFactory.changeWebDriver(driver)

		WebUI.navigateToUrl('https://www.google.co.in/')
	}
}
