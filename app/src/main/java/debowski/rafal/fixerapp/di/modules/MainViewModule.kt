package debowski.rafal.fixerapp.di.modules

import androidx.lifecycle.ViewModel
import dagger.Module
import dagger.Provides
import debowski.rafal.fixerapp.MainViewModel
import debowski.rafal.fixerapp.repository.RateRepository

@Module(
    includes = [
        RateRepositoryModule::class
    ]
)
class MainViewModule {

    @Provides
     fun provideMainViewModule(rateRepository: RateRepository): ViewModel =
         MainViewModel(rateRepository)
}