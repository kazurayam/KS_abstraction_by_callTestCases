import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.openBrowser('http://demo.automationtesting.in/Alerts.html')

//Record the AlertBtn object or
//Create a manual AlertBtn object with XPath = //button[@onclick='alertbox()']
WebUI.waitForElementVisible(findTestObject('0.1 AlertChecks/AlertBtn'), 30, FailureHandling.OPTIONAL)

WebUI.click(findTestObject('0.1 AlertChecks/AlertBtn'), FailureHandling.OPTIONAL)

if (WebUI.verifyAlertPresent(30)) {
	println('Alert is present')
}

WebUI.closeBrowser()