package debowski.rafal.fixerapp.di

import dagger.Component
import debowski.rafal.fixerapp.MainActivity
import debowski.rafal.fixerapp.di.modules.MainViewModule
import debowski.rafal.fixerapp.di.modules.NetworkModule

@Component(
    modules = [
        MainViewModule::class,
        NetworkModule::class
    ]
)
interface AppComponent {

    fun injectApp(mainActivity: MainActivity)
}