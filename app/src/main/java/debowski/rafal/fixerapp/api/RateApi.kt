package debowski.rafal.fixerapp.api

import debowski.rafal.fixerapp.models.DailyRate
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Path


interface RateApi {

    @GET("latest?access_key=73140d3a4199e960303ae6559a4e9809")
    fun getLatestRate(): Call<DailyRate>

    @GET("{date}?access_key=73140d3a4199e960303ae6559a4e9809")
    fun getDailyRateByDate(@Path("date") date: String) : Call<DailyRate>

}