package debowski.rafal.fixerapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import debowski.rafal.fixerapp.MainActivity
import debowski.rafal.fixerapp.databinding.ActivityDetailsBinding
import debowski.rafal.fixerapp.models.Rate

class DetailsActivity : AppCompatActivity() {

    lateinit var binding: ActivityDetailsBinding

    lateinit var rate: Rate

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailsBinding.inflate(layoutInflater)
        binding.lifecycleOwner = this

        setContentView(binding.root)

        getBundleAndInitData(savedInstanceState)

        initButton()

    }

    private fun getBundleAndInitData(bundle: Bundle?) {
            val rateItem = intent.getStringExtra(MainActivity.RATE_ITEM)
            val date = intent.getStringExtra(MainActivity.DATE_VALUE)

//            rate = Rate(
//                date = date.orEmpty(),
//                rateValue = rateItem.orEmpty()
//            )

            binding.date.text = date
            binding.rateItem.text = rateItem
    }

    private fun initButton() {
        binding.buttonBack.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}