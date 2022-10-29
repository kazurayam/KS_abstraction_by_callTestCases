package my

import com.kms.katalon.core.annotation.Keyword


public class RandomSSNGenerator {

	private static Integer ssn1
	private static Integer ssn2
	private static Integer ssn3

	private static generate() {
		Random rand = new Random();
		// Generate random SSN.
		ssn1 = rand.nextInt(600)+100;
		ssn2 = rand.nextInt(89)+10;
		ssn3 = rand.nextInt(8999)+1000;
	}

	public static Tuple randomSSNasTuple() {
		generate()
		return new Tuple(ssn1, ssn2, ssn3)
	}

	public static List<Integer> randomSSNasList() {
		generate()
		return [ssn1, ssn2, ssn3]
	}

	public static Map<String, Integer> randomSSNasMap() {
		generate()
		return ["ssn1": ssn1, "ssn2": ssn2, "ssn3": ssn3]
	}
}
