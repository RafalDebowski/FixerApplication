package debowski.rafal.fixerapp.di.modules

import dagger.Module
import dagger.Provides
import debowski.rafal.fixerapp.api.RateApi
import debowski.rafal.fixerapp.models.DailyRate
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    companion object{
         const val BASE_URL = "http://data.fixer.io/api/"
    }

    lateinit var retrofit: Retrofit

    @Provides
    fun provideRetrofit() : Retrofit {
       retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()

        return retrofit
    }

    @Provides
    fun provideDailyRateApi(retrofit: Retrofit): RateApi =
        retrofit.create(RateApi::class.java)

}