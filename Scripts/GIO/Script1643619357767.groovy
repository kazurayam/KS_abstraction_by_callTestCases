import com.kms.katalon.core.util.KeywordUtil

/**
 * https://forum.katalon.com/t/comparing-two-tables/62051
 */

List<List<String>> input1 = [
		[ "Customer A", "Retail B", "x" ],
		// [ "Customer B", "Retail A", "x" ],
		[ "Customer C", "Retail B", "x" ],
		[ "Customer D", "Key Account", "x" ],
		[ "Customer E", "Retail A", "x" ],
		[ "Customer F", "Key Account", "x" ],
		[ "Customer G", "Key Account", "x" ],
];

List<List<String>> input2 = [
		[ "Customer D", "Key Account" ],
		[ "Customer B", "Retail A" ],
		[ "Customer C", "Retail B" ],
		[ "Customer A", "Retail B" ],
		[ "Customer G", "Key Account" ],
		[ "Customer E", "Retail A" ],
		// [ "Customer F", "Key Account" ],
];

Map<String, Record> table1 = new TreeMap<>();
for (List<String> row in input1) {
	Record rc = new Record(row[0], row[1], row[2]);
	table1.put(rc.key(), rc);
}
Set<String> keySet1 = table1.keySet()
//println "keySet1: " + keySet1

Map<String, Record> table2 = new TreeMap<>();
for (List<String> row in input2) {
	Record rc = new Record(row[0], row[1]);
	table2.put(rc.key(), rc);
}
Set<String> keySet2 = table2.keySet()
//println "keySet2: " + keySet2

// print the tables
println "-------- table 1 --------"
for (String key in keySet1) {
	println table1.get(key)
}
println ""
println "-------- table 2 --------"
for (String key in keySet2) {
	println table2.get(key)
}
println ""

// comparing the key set of the input1 and the input2
Set<String> w1 = new TreeSet<>(keySet1);
Set<String> w2 = new TreeSet<>(keySet2);
w1.removeAll(w2)
if (w1.size() > 0) {
	for (String k1 in w1) {
		System.err.println "\"${k1}\" is contained in the input1, but is missing in the input2"
		
	}
	KeywordUtil.markFailed("input1 > input2")
}

println ""

w1 = new TreeSet<>(keySet1);
w2 = new TreeSet<>(keySet2);
w2.removeAll(w1)
if (w2.size() > 0) {
	for (String k2 in w2) {
		System.err.println "\"${k2}\" is contained in the input2, but is missing in the input1"
	}
	KeywordUtil.markFailed("input1 < input2")
}


/**
 *
 */
class Record implements Comparable<Record> {
	private final String CUSTOMER;
	private final String CHANNEL;
	private final String BRANCHES;
	Record(String customer, String channel) {
		this(customer, channel, '');
	}
	Record(String customer, String channel, String branches) {
		this.CUSTOMER = customer.trim();
		this.CHANNEL = channel.trim();
		this.BRANCHES = branches.trim();
	}
	String CUSTOMER() {
		return this.CUSTOMER;
	}
	String CHANNEL() {
		return this.CHANNEL;
	}
	String BRANCHES() {
		return this.BRANCHES;
	}
	String key() {
		return this.CUSTOMER() + "|" + this.CHANNEL()
	}

	@Override
	boolean equals(Object obj) {
		if (! obj instanceof Record) {
			return false;
		}
		Record other = (Record)obj;
		return this.CUSTOMER() == other.CUSTOMER() &&
				this.CHANNEL() == other.CHANNEL() &&
				this.BRANCHES() == other.BRANCHES()
	}

	@Override
	int hashCode() {
		int hash = 7;
		hash = 31 * hash + this.CUSTOMER().hashCode();
		hash = 31 * hash + this.CHANNEL().hashCode();
		hash = 31 * hash + this.BRANCHES().hashCode();
		return hash;
	}

	@Override
	String toString() {
		return "[" + this.CUSTOMER() + "|" + this.CHANNEL() + "|" + this.BRANCHES() + "]";
	}

	@Override
	int compareTo(Record other) {
		int result = this.CUSTOMER() <=> other.CUSTOMER();
		if (result != 0) {
			return result;
		} else {
			result = this.CHANNEL() <=> other.CHANNEL();
			if (result != 0) {
				return result;
			} else {
				result = this.BRANCHES() <=> other.BRANCHES();
				return result;
			}
		}
	}
}