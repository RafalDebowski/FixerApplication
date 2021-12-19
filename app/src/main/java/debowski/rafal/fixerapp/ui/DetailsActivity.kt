package debowski.rafal.fixerapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import debowski.rafal.fixerapp.MainActivity
import debowski.rafal.fixerapp.databinding.ActivityDetailsBinding
import debowski.rafal.fixerapp.models.Rate

class DetailsActivity : AppCompatActivity() {

    lateinit var binding: ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailsBinding.inflate(layoutInflater)
        binding.lifecycleOwner = this

        setContentView(binding.root)

        getBundleAndInitData()

        initButton()
    }

    private fun getBundleAndInitData() {
        binding.date.text = intent.getStringExtra(MainActivity.DATE_VALUE)
        binding.rateItem.text = intent.getStringExtra(MainActivity.RATE_ITEM)
    }

    private fun initButton() {
        binding.buttonBack.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}