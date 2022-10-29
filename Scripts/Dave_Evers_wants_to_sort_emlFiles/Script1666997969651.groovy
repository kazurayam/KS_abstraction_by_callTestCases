import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import java.util.stream.Collectors
import com.kms.katalon.core.configuration.RunConfiguration
import java.text.SimpleDateFormat

dataDir = Paths.get(RunConfiguration.getProjectDir()).resolve("Include/data")

List<ComparablePath> emlFiles =
	Files.list(dataDir)
		.filter({ p -> p.toString().endsWith(".eml") })
		.map({ p -> new ComparablePath(p) })
		.collect(Collectors.toList())

// sort the list by descending order
emlFiles.sort(Comparator.reverseOrder());
		
// print path of all eml files
def RecordCnt = 0
emlFiles.forEach  { p ->
	RecordCnt ++
	println(RecordCnt + "\t" + p.toString() + "\t" + p.getTimestampFormatted())
}

// open the 1st eml file, print its contents
//String content = emlFiles.get(0).get().toFile().text
//println("\nContent: " + content)


/**
 * A wrapper of Path that enables comparison.
 * Default to comparing by lastModified propery of File
 */
class ComparablePath implements Comparable<ComparablePath> {
	
	protected Path p;
	protected long timestamp;
	
	public ComparablePath(Path p) {
		this.p = p
		this.timestamp = resolveTimestamp(p)
	}
	
	public Path get() {
		return this.p
	}
	
	public String getTimestampFormatted() {
		return new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date(timestamp));
	}
	
	protected long resolveTimestamp(Path p) {
		return p.toFile().lastModified()
	}
	
	@Override
	public int compareTo(ComparablePath other) {
		if (timestamp < other.timestamp) {
			return -1
		} else if (timestamp == other.timestamp) {
			return 0
		} else {
			return 1
		}
	}
	
	@Override
	public String toString() {
		return p.toString()
	}
}