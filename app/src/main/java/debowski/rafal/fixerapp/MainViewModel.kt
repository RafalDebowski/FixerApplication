package debowski.rafal.fixerapp

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import debowski.rafal.fixerapp.models.DailyRate
import debowski.rafal.fixerapp.repository.RateRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val rateRepository: RateRepository
) : ViewModel() {

    var latestRate = MutableLiveData<MutableList<DailyRate>>()
    private var localLatestRate: MutableList<DailyRate> = mutableListOf()

    fun getLatestRate() {
        CoroutineScope(Dispatchers.IO).launch {
            val dailyRate = rateRepository.getLatestRate().execute().body()
            val rates = modifyString(dailyRate?.rates.toString())

            dailyRate.apply {
                this?.listRates = rates
            }

            dailyRate?.let {
                localLatestRate.add(dailyRate)
            }

            latestRate.postValue(localLatestRate)
        }
    }

    fun getDailyRateByDate(dateString: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val dailyRate = rateRepository.getDailyRateByDate(
                getPreviousDate(dateString)
            ).execute().body()

            val rates = modifyString(dailyRate?.rates.toString())

            dailyRate.apply {
                this?.listRates = rates
            }

            dailyRate?.let {
                localLatestRate.add(dailyRate)
            }

            latestRate.postValue(localLatestRate)
        }
    }

    private fun getPreviousDate(dateString: String): String {
        val dateFormat = SimpleDateFormat("yyyy-MM-dd")
        try {
            val date = dateFormat.parse(dateString)

            val cal = Calendar.getInstance()
            cal.time = date
            cal.add(Calendar.DATE, -1)

            dateFormat.format(cal.time)

            return dateFormat.format(cal.time)

        } catch (e: ParseException) {
            e.printStackTrace()
        }

        return MainActivity.EMPTY_STRING
    }

    private fun modifyString(rateString: String): List<String> =
        rateString.replace("{", "").replace("}", "").replace("\"", " ").split(",")
}