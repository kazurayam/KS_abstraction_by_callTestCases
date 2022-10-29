import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase

import java.time.LocalDateTime
import java.nio.file.Path
import java.nio.file.Paths

import com.kazurayam.timekeeper.Measurement
import com.kazurayam.timekeeper.Table
import com.kazurayam.timekeeper.Timekeeper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.configuration.RunConfiguration

Timekeeper tk = new Timekeeper()
Measurement m1 = new Measurement.Builder("How long the Callee took", ["Trial"]).build()
tk.add(new Table.Builder(m1).build())

for (int i = 1; i <= 53; i++) {
	LocalDateTime beforeCall = LocalDateTime.now()
	WebUI.callTestCase(findTestCase("Callee"), ["seq": i])
	LocalDateTime afterCall = LocalDateTime.now()
	m1.recordDuration(["Trial": Integer.toString(i)],
		beforeCall, afterCall)
}
WebUI.closeBrowser()

Path projectDir = Paths.get(RunConfiguration.getProjectDir())
Path markdown = projectDir.resolve("timed.md")
tk.report(markdown)

WebUI.comment("done")