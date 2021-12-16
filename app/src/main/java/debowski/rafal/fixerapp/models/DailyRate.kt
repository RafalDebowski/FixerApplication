package debowski.rafal.fixerapp.models

data class DailyRate(
    val success : Boolean,
    val timestamp : Long,
    val base : String,
    val date : String,
    val rates: List<Rate>
)