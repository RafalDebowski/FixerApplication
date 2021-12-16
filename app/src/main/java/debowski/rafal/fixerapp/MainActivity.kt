package debowski.rafal.fixerapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import debowski.rafal.fixerapp.di.DaggerAppComponent
import debowski.rafal.fixerapp.models.DailyRate
import javax.inject.Inject

class MainActivity() : AppCompatActivity() {

    @Inject
    lateinit var viewModel: MainViewModel

    lateinit var dailyRate: DailyRate

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        DaggerAppComponent.builder().build().injectApp(this)


//        observeAction()
        viewModel.getLatestRate()
        observeData()

    }

//    private fun  observeAction(){
//        viewModel.action.observe(
//            this,
//            {
//                dailyRate = it
//            }
//        )
//    }

    private fun observeData(){
        viewModel.latestRate.observe(
            this,
            {
                dailyRate = it
            }
        )
    }
}