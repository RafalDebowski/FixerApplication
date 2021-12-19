package debowski.rafal.fixerapp.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import debowski.rafal.fixerapp.databinding.ItemDailyRateBinding
import debowski.rafal.fixerapp.models.DailyRate

class DailyRateAdapter(
    private val onClickItem: (bundleData: String, data: String) -> Unit
) : RecyclerView.Adapter<DailyRateAdapter.ViewHolder>() {

    var listItem: List<DailyRate> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    private var adapter = RateAdapter(
        onClickItem
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemDailyRateBinding.inflate(layoutInflater, parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        ViewHolder(holder.binding).bind(
            item = listItem[position]
        )
    }

    override fun getItemCount(): Int = listItem.size

    inner class ViewHolder(
        val binding: ItemDailyRateBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(
            item: DailyRate
        ) {
            binding.dayValue.text = item.date

            adapter.listItem = item.listRates

            adapter.date = item.date

            binding.recyclerView.adapter = adapter
        }
    }
}