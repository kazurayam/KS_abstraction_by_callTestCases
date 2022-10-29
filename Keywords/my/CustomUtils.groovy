package my

public class CustomUtils {

	private static Random random = new Random()

	public static int nextRandomInt(int bound) {
		return random.nextInt(bound)
	}
}
