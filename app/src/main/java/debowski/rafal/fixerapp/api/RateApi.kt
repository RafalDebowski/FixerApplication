package debowski.rafal.fixerapp.api

import debowski.rafal.fixerapp.models.DailyRate
import retrofit2.http.GET


interface RateApi {

    @GET("latest?access_key=2195826b45e02e60d8aec6b0c150fcd5")
    fun getLatestRate(): DailyRate
}