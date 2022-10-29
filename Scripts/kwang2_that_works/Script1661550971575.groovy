import java.text.NumberFormat

NumberFormat format = NumberFormat.getInstance(Locale.US);

String a = '1,000.00000000'
String b = '2.71828'

Number number_a = format.parse(a)
Number number_b = format.parse(b)
Double c = number_a.doubleValue() * number_b.doubleValue()
println("c is " + c.toString())
