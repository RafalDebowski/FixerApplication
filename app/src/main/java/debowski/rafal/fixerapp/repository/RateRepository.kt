package debowski.rafal.fixerapp.repository

import debowski.rafal.fixerapp.api.RateApi
import debowski.rafal.fixerapp.models.DailyRate

class RateRepository constructor(private val rateApi: RateApi) {

    fun getLatestRate(): DailyRate =
        rateApi.getLatestRate()

}