import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase

import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import java.util.stream.Collectors

import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import java.nio.file.Files
import java.nio.file.FileVisitResult
import java.nio.file.SimpleFileVisitor
import java.nio.file.attribute.BasicFileAttributes

List<Path> listChildDirectoriesOf(Path dir) throws IOException {
	return Files.list(dir)
		.filter { Files.isDirectory(it) }
		.collect(Collectors.toList());
}

// https://www.baeldung.com/java-list-directory-files#walking
List<Path> listDescendantDirectoriesOf(Path dir) throws IOException {
	List<Path> directoryList = new ArrayList<>()
	Files.walkFileTree(dir, new SimpleFileVisitor<Path>() {
		@Override
		public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
			if (!Files.isDirectory(file)) {
				directoryList.add(file.toAbsolutePath().getParent())
			}
			return FileVisitResult.CONTINUE
		}	
	})
	directoryList.sort()
	return directoryList
}

Path projectDir = Paths.get(RunConfiguration.getProjectDir())
Path scriptsDir = projectDir.resolve("Scripts")
Path myTestsFolder = scriptsDir.resolve("MyTestsFolder")
assert Files.exists(myTestsFolder)

//List<Path> testCases = listChildDirectoriesOf(myTestsFolder).sort()
List<Path> testCases = listDescendantDirectoriesOf(myTestsFolder).sort()
assert testCases.size() > 0

testCases.forEach({ p ->
	String n = scriptsDir.relativize(p).toString()
	println n
	WebUI.callTestCase(findTestCase(n), ["messageX": "xyzzy", "message1": "foo", "message2": "bar", "message3": "baz"])
})
