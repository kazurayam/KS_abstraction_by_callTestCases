package my

import com.kms.katalon.core.exception.StepFailedException
import com.kms.katalon.core.util.KeywordUtil

public class Assertions {

	public static void fail(String message) {
		throw new StepFailedException(message)
	}

	public static void failToStop(String message) {
		KeywordUtil.markFailedAndStop(message)
	}

	public static void failNonStop(String message) {
		KeywordUtil
	}
}
