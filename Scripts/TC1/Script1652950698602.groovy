import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import com.kms.katalon.core.util.KeywordUtil

String data0 = "13.05.2022 17h02"
assert validateDateTime(data0)

String data1 = "13.05.2022 17h99"
assert validateDateTime(data1)

boolean validateDateTime(String str) {
	DateTimeFormatter dtFormatter = DateTimeFormatter.ofPattern("dd.MM.uuuu HH'h'mm")
	try {
		LocalDateTime ldt = LocalDateTime.parse(str, dtFormatter)
		return true
	} catch (Exception e) {
		KeywordUtil.markWarning(e.getMessage())
		return false
	}
}