import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.testobject.HttpBodyContent
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS

ResponseObject response = WS.sendRequest(findTestObject("CURA_header_image"))
HttpBodyContent httpBodyContent = response.getBodyContent()
InputStream inputStream = httpBodyContent.getInputStream()

File outJpeg = new File("./header.jpeg");
OutputStream outputStream = new FileOutputStream(outJpeg)
copy(inputStream, outputStream)
assert outJpeg.exists()
assert outJpeg.length() > 0

String html = """<html><body><img src="./header.jpeg" alt="header"></body></html>"""
File outHtml = new File("header.html")
copy(new StringReader)

void copy(InputStream source, OutputStream target) throws IOException {
	byte[] buf = new byte[8192];
	int length;
	while ((length = source.read(buf)) > 0) {
		target.write(buf, 0, length);
	}
}

