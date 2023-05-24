import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase

import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import java.util.stream.Collectors

import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

List<Path> listChildDirectoriesOf(Path dir) throws IOException {
	return Files.list(dir)
		.filter { Files.isDirectory(it) }
		.collect(Collectors.toList());
}

Path projectDir = Paths.get(RunConfiguration.getProjectDir())
Path scriptsDir = projectDir.resolve("Scripts")
Path myTestsFolder = scriptsDir.resolve("MyTestsFolder")
assert Files.exists(myTestsFolder)
List<Path> testCases = listChildDirectoriesOf(myTestsFolder).sort()
assert testCases.size() > 0

testCases.forEach({ p ->
	String n = scriptsDir.relativize(p).toString()
	println n
	WebUI.callTestCase(findTestCase(n), ["message1": "foo", "message2": "bar", "message3": "buz"])
})
