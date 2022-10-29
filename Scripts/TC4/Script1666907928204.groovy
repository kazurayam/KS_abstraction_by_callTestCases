import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import java.util.stream.Collectors

import com.kms.katalon.core.configuration.RunConfiguration

Path projectDir = Paths.get(RunConfiguration.getProjectDir())
Path dataDir = projectDir.resolve("Include/data")

List<Path> emlFiles = 
	Files.list(dataDir)
		.filter({ p -> p.toString().endsWith(".eml")})
		.collect(Collectors.toList())

// open the 1st eml file, print its HTTP Body part in its contents
String body = parseEmlFileForBody(emlFiles.get(0))
println body

String parseEmlFileForBody(Path eml) {
	String content = eml.toFile().text
	println indexOfSeparator(content)
	return content.substring(indexOfSeparator(content) + CRLF.length() + 1)

}

int indexOfSeparator(String content) {
	char CR  = (char) 0x0D
	char LF  = (char) 0x0A
	String CRLF = "" + CR + LF  // as specified by RFC-2616 HTTP/1.1, section 4.1 MessageType specifies 
	String LFLF = "" + LF + LF  // Mac wants LF as new line char
	int index = content.indexOf(CRLF)
	if (index > 0) {
		return index
	}
	// alternatively
	return content.indexOf(LFLF)
}