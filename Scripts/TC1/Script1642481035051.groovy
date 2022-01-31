import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable

WebUI.openBrowser('http://demoaut.katalon.com')
GlobalVariable.url = WebUI.getUrl()
WebUI.comment(GlobalVariable.url)
WebUI.delay(2)
WebUI.closeBrowser()