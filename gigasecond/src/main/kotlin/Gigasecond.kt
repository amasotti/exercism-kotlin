import java.time.LocalDate
import java.time.LocalDateTime

class Gigasecond(humanDate: LocalDateTime) {

    // Secondary constructor if LocalDate is passed instead of LocalDateTime
    constructor(humanDate: LocalDate) : this(humanDate.atStartOfDay())

    val date: LocalDateTime = humanDate.plusSeconds(1_000_000_000)
}
