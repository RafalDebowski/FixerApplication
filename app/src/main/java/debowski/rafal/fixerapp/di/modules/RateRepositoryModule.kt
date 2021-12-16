package debowski.rafal.fixerapp.di.modules

import dagger.Module
import dagger.Provides
import debowski.rafal.fixerapp.api.RateApi
import debowski.rafal.fixerapp.repository.RateRepository

@Module
class RateRepositoryModule {

    @Provides
    fun provideRateRepository(rateApi: RateApi): RateRepository =
        RateRepository(rateApi)
}