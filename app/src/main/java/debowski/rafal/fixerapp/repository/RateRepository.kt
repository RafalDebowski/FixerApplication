package debowski.rafal.fixerapp.repository

import debowski.rafal.fixerapp.api.RateApi
import debowski.rafal.fixerapp.models.DailyRate
import retrofit2.Call
import retrofit2.Response

class RateRepository constructor(private val rateApi: RateApi) {

    fun getLatestRate(): Call<DailyRate> =
        rateApi.getLatestRate()
}