import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import java.nio.file.StandardOpenOption

import com.kms.katalon.core.configuration.RunConfiguration

Path projectDir = Paths.get(RunConfiguration.getProjectDir());
println "projedtDir=" + projectDir.toString()

Path tmp = projectDir.resolve("tmp");
Files.createDirectories(tmp);
println "tmp=" + tmp.toString();

Path testfile = tmp.resolve("testfile");
Files.write(testfile, "Hello, world".getBytes(),
	StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING)
