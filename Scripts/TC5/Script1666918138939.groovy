import java.nio.file.Paths

import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.util.internal.Base64

import internal.GlobalVariable

File emlfile = Paths.get(RunConfiguration.getProjectDir()).resolve("Include/data/test.eml").toFile();
def emlFileContents = emlfile.getText("UTF-8")
println("emlFileContents: " + emlFileContents)
//GlobalVariable.DecodedUrl = emlFileContents
//println("GlobalVariable.DecodedUrl: " + GlobalVariable.DecodedUrl)

// The following works to capture the Base64 encoded "aHR0cHM6Ly93d3cuZ29vZ2xlLmNvbQ==" from the test.eml file
// However when I attempt to decode the result I keep getting 'Illegal base64 character d' error messages
// Can you see where I am going wrong? I am using substring to capture the base64 encoded data
// Would there be a better solution for splitting out the data so there are no spaces?
// The following are my print results... It seems like I have a space but am not sure how to remove it.
// EncodedUrl:
//
// aHR0cHM6Ly93d3cuZ29vZ2xlLmNvbQ==
// 2022-10-27 16:26:58.191 INFO  c.k.katalon.core.main.TestCaseExecutor

work = emlFileContents
work = work.replace(' ', '')
int EncodedUrlLength = work.length()
println("work: " + work)
int startPos = (work.lastIndexOf("base64") + 6)
println("startPos: " + startPos)
int endPos = work.lastIndexOf("")
println("endPos: " + endPos)
work = work.substring(startPos, endPos)
work = work.replace(' ', '')
println("work: " + work)

//Failed attempted decoding
String body = work
GlobalVariable.DecodedUrl = Base64.decode(body)
println "DecodedUrl ${GlobalVariable.DecodedUrl}"

//Your code works fine when I use it...
//String httpBody = "aHR0cHM6Ly93d3cuZ29vZ2xlLmNvbQ=="
//GlobalVariable.DecodedUrl = Base64.decode(httpBody)
//println "DecodedUrl ${GlobalVariable.DecodedUrl}"
