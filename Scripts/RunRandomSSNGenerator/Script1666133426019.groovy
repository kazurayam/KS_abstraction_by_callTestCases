import my.RandomSSNGenerator

Tuple ssnT = RandomSSNGenerator.randomSSNasTuple()
println("as Tuple: " + ssnT[0] + ", " + ssnT[1] + ", " + ssnT[2])

List<List> ssnL = RandomSSNGenerator.randomSSNasList()
println("as List: " + ssnL[0] + ", " + ssnL[1] + ", " + ssnL[2])

Map<String, Integer> ssnM = RandomSSNGenerator.randomSSNasMap()
println("as Map: "  + ssnM["ssn1"] + ", " + ssnM["ssn2"] + ", " + ssnM["ssn3"])