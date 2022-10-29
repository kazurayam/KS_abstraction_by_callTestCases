package screenSize

import org.openqa.selenium.WebDriver

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

public class screenSize_1 {

	@Keyword(keywordObject='WEB')
	def static enhanced_SetViewportSize(int width, int height) {
		WebDriver webDriver = DriverFactory.getWebDriver()
		int browserWidthGap = webDriver.manage().window().getSize().width - WebUI.executeJavaScript('return (window.innerWidth || 0)', null)
		int browserHeightGap = webDriver.manage().window().getSize().height - WebUI.executeJavaScript('return (window.innerHeight || 0)', null)
		float ratio = WebUI.executeJavaScript('return (window.devicePixelRatio || 1)', null)
		int actualWidth = Math.round((width + browserWidthGap * ratio) / ratio)
		int actualHeight = Math.round((height + browserHeightGap * ratio) / ratio)
		WebUI.setViewPortSize(actualWidth, actualHeight)
	}
}