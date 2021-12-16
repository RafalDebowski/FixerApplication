package debowski.rafal.fixerapp

import android.util.Log
import androidx.lifecycle.LiveData
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

     var latestRate = MutableLiveData<DailyRate>()

    fun getLatestRate() {
        CoroutineScope(Dispatchers.IO).launch {
            latestRate.value = rateRepository.getLatestRate()
        }

    }


    sealed class Action{
        object LatestRate : Action()
    }
}