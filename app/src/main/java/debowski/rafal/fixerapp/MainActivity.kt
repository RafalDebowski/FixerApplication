package debowski.rafal.fixerapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import debowski.rafal.fixerapp.databinding.ActivityMainBinding
import debowski.rafal.fixerapp.di.DaggerAppComponent
import debowski.rafal.fixerapp.ui.DailyRateAdapter
import debowski.rafal.fixerapp.ui.DetailsActivity
import javax.inject.Inject

class MainActivity() : AppCompatActivity() {

    companion object{
        const val RATE_ITEM = "RATE_ITEM"
        const val DATE_VALUE ="DATE_VALUE"
    }

    @Inject
    lateinit var viewModel: MainViewModel

    lateinit var binding: ActivityMainBinding

    private var adapter = DailyRateAdapter(
        ::onClickItem
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        DaggerAppComponent.builder().build().injectApp(this)

        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.lifecycleOwner = this
        binding.recyclerView.adapter = adapter

        viewModel.getLatestRate()
        observeData()

        setContentView(binding.root)

    }

    private fun observeData(){
        viewModel.latestRate.observe(
            this,
            {
                it?.let {
                    adapter.listItem = it
                }
            }
        )
    }

    private fun onClickItem(bundleData: String, date: String){
        val intent = Intent(this, DetailsActivity::class.java)
        intent.putExtra(RATE_ITEM, bundleData)
        intent.putExtra(DATE_VALUE, date)
        startActivity(intent)
    }
}