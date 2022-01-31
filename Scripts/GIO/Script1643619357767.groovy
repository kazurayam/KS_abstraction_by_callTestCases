import bsh.This

List<List> table1 = [
	[ "Customer A", "Retail B", "x" ],
	[ "Customer B", "Retail A", "x" ],
	[ "Customer C", "Retail B", "x" ],
	[ "Customer D", "Key Account", "x" ],
	[ "Customer E", "Retail A", "x" ],
	[ "Customer F", "Key Account", "x" ],
	[ "Customer G", "Key Account", "x" ]
	]

List<List<String>> table2 = [
	[ "Customer D", "Key Account", "x" ],
	[ "Customer B", "Retail A", "x" ],
	[ "Customer C", "Retail B", "x" ],
	[ "Customer A", "Retail B", "x" ],
	[ "Customer G", "Key Account", "x" ]
	[ "Customer E", "Retail A", "x" ],
	[ "Customer F", "Key Account", "x" ],
	]
	
class Record {
	private final String CUSTOMER
	private final String CHANNEL
	private final String BRANCHES
	Record(String customer, String channel) {
		this(customer, channel, '')
	}
	Record(String customer, String channel, String branches) {
		this.CUSTOMER = customer
		this.CHANNEL = channel
		this.BRANCHES = branches
	}
	String CUSTOMER() {
		return this.CUSTOMER
	}
	String CHANNEL() {
		return this.CHANNEL
	}
	String BRANCHES() {
		return this.BRANCHES
	}
	@Override
	boolean equals(Object obj) {
		if (! obj instanceof Record) {
			return false
		}
		Record other = (Record)obj
		return this.CUSTOMER() == other.CUSTOMER() &&
		    this.CHANNEL() == other.CHANNEL() &&
			this.BRANCHES() == other.BRANCHES()
	}
	@Override
	int hashCode() {
		int hash = 7
		hash = 31 * hash + this.CUSTOMER().hashCode()
		hash = 31 * hash + this.CHANNEL().hashCode()
		hash = 31 * hash + this.BRANCHES().hashCode()
		return hash
	}
	@Override
	int toString() {
		return "[" + this.CUSTOMER() + "|" + this.CHANNEL() + "|" + this.BRANCHES() + "]"
	}
	
}