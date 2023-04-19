import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import com.kms.katalon.core.model.FailureHandling as FailureHandling

import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.openBrowser("")
WebUI.navigateToUrl("http://localhost/alert.html") // I have a HTTP Server at http://localhost which makes the katalon project accessible as a web site. It does nothing special.
WebDriver wd = DriverFactory.getWebDriver();
WebElement elementOpen = wd.findElement(By.xpath("/html/body/button"));

elementOpen.click()

boolean present1 = WebUI.verifyAlertPresent(5, FailureHandling.STOP_ON_FAILURE)
// this line passed; it means an Aleart is there.
println("present1 :" + present1)

WebUI.delay(3)

// we will check if the Aler is still there...
boolean present2 = WebUI.verifyAlertPresent(1, FailureHandling.CONTINUE_ON_FAILURE)
// Chrome+FF+Edge; this line failed; it means no Alert is there.
// Safari; this line passed; it means an Alert is there. Safari seems to be a bit loose.
println("present2? :" + present2)

WebUI.closeBrowser()
