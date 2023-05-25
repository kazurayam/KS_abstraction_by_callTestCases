import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import groovy.json.JsonSlurper
import internal.GlobalVariable

// load the config file and put it into a variable of type Map
JsonSlurper slurper = new JsonSlurper()
def config = slurper.parse(new File('./config.json'))

WebUI.callTestCase(findTestCase("MyTestsFolder/TestCase1"), ["message1": config.message1, "message2": config.message2, "message3": config.message3])
WebUI.callTestCase(findTestCase("MyTestsFolder/TestCase2"), ["message1": config.message1, "message2": config.message2, "message3": config.message3])
WebUI.callTestCase(findTestCase("MyTestsFolder/TestCase3"), ["message1": config.message1, "message2": config.message2, "message3": config.message3])

