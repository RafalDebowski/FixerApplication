package debowski.rafal.fixerapp.models

import com.google.gson.JsonObject
import com.google.gson.annotations.SerializedName

data class DailyRate(
    @SerializedName("success")
    val success : Boolean,

    @SerializedName("timestamp")
    val timestamp : Long,

    @SerializedName("base")
    val base : String,

    @SerializedName("date")
    val date : String,

    @SerializedName("rates")
    var rates: JsonObject,

    var listRates: List<String>
)