// https://www.baeldung.com/java-download-file

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.testobject.HttpBodyContent
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS

String FILE_URL = "http://localhost:80/sample.docx"
URL url = new URL(FILE_URL)
InputStream inputStream = url.openStream()

File outFile = new File("./downloaded.docx");
OutputStream outputStream = new FileOutputStream(outFile)
copy(inputStream, outputStream)
outputStream.flush()
outputStream.close()

assert outFile.exists()
assert outFile.length() > 0

void copy(InputStream source, OutputStream target) throws IOException {
	byte[] buf = new byte[8192];
	int length;
	while ((length = source.read(buf)) > 0) {
		target.write(buf, 0, length);
	}
}

