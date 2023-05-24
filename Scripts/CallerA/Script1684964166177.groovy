import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.callTestCase(findTestCase("MyTestsFolder/TestCase1"), ["message1": "foo"])

WebUI.callTestCase(findTestCase("MyTestsFolder/TestCase2"), ["message2": "bar"])

WebUI.callTestCase(findTestCase("MyTestsFolder/TestCase3"), ["message3": "buz"])
