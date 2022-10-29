import com.kms.katalon.core.util.internal.Base64
import internal.GlobalVariable

String httpBody = "aHR0cHM6Ly93d3cuZ29vZ2xlLmNvbQ=="

GlobalVariable.DecodedUrl = Base64.decode(httpBody)
println "DecodedUrl ${GlobalVariable.DecodedUrl}"
