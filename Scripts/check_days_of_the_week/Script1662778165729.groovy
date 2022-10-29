import java.time.DayOfWeek
import java.time.LocalDate

import com.kms.katalon.core.util.KeywordUtil

List<DayOfWeek> myWorkingDays = [DayOfWeek.MONDAY, DayOfWeek.WEDNESDAY, DayOfWeek.FRIDAY]

Boolean isDayOn(LocalDate theDate, List<DayOfWeek> daysOn) {
	return (theDate.getDayOfWeek() in daysOn)
}

LocalDate today = LocalDate.now()
LocalDate yesterday = today.minusDays(1)
LocalDate tomorrow = today.plusDays(1)
LocalDate dayAfterTomorrow = today.plusDays(2)

println("yesterday was " + yesterday.getDayOfWeek() + " which was a day on: " + isDayOn(yesterday, myWorkingDays))
println("today is " + today.getDayOfWeek() + " which is a day on: " + isDayOn(today, myWorkingDays))
println("tomorrow will be " + tomorrow.getDayOfWeek() + " which is a day on: " + isDayOn(tomorrow, myWorkingDays))
println("day after tomorrow will be " + dayAfterTomorrow.getDayOfWeek() + " which is a day on: " + isDayOn(dayAfterTomorrow, myWorkingDays))

if (! isDayOn(today, myWorkingDays)) {
	KeywordUtil.markFailed("today is " + today.getDayOfWeek() + " which is not a day to work")
}


