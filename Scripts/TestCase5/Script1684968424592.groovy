import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.callTestCase(findTestCase("MyTestsFolder/TestCase1"), ["message1": message1, "message2": message2, "message3": message3])
WebUI.callTestCase(findTestCase("MyTestsFolder/TestCase2"), ["message1": message1, "message2": message2, "message3": message3])
WebUI.callTestCase(findTestCase("MyTestsFolder/TestCase3"), ["message1": message1, "message2": message2, "message3": message3])
