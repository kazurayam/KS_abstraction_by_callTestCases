package my

import com.kms.katalon.core.annotation.Keyword

public class CustomKeywords {
	private static Random random = new Random()

	@Keyword
	public static int nextRandomInt(int bound) {
		return random.nextInt(bound)
	}
}
