package debowski.rafal.fixerapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import debowski.rafal.fixerapp.models.DailyRate
import debowski.rafal.fixerapp.repository.RateRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val rateRepository: RateRepository
): ViewModel() {

    lateinit var action: MutableLiveData<Action>

     var latestRate = MutableLiveData<MutableList<DailyRate>>()
     var localLatestRate : MutableList<DailyRate> = mutableListOf()

    fun getLatestRate() {
        CoroutineScope(Dispatchers.IO).launch {
            val rates = rateRepository.getLatestRate().execute().body()?.rates.toString()
            val result = rates.split(",")

            val dailyRate = rateRepository.getLatestRate().execute().body()

            dailyRate.apply {
                this?.listRates = result
            }

            dailyRate?.let {
                localLatestRate.add(dailyRate)
            }

            latestRate.postValue(localLatestRate)
        }

    }


    sealed class Action{
        object LatestRate : Action()
    }
}