import java.nio.charset.StandardCharsets
import java.net.URLEncoder
import java.net.URLDecoder

String encodeValue(String value) {
	return URLEncoder.encode(value, StandardCharsets.UTF_8.toString())
}
String decodeEncodedValue(String encoded) {
	return URLDecoder.decode(encoded, StandardCharsets.UTF_8.toString())
}

String emailAddress = 'test123@myemailtest.de'
println encodeValue(emailAddress)

String encodedAddress = 'test123%40myemailtest.de'
println decodeEncodedValue(encodedAddress)