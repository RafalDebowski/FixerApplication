package debowski.rafal.fixerapp.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import debowski.rafal.fixerapp.databinding.ItemRateBinding

class RateAdapter(
    val onClickItem: (bundleData: String, data: String) -> Unit
) : RecyclerView.Adapter<RateAdapter.ViewHolder>() {

    var listItem: List<String> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    var date: String = ""


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemRateBinding.inflate(layoutInflater, parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        ViewHolder(holder.binding).bind(
            listItem[position]
        )
    }

    override fun getItemCount(): Int = listItem.size

    inner class ViewHolder(
        val binding: ItemRateBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: String) {
            binding.rate.text = item

            binding.root.setOnClickListener {
                onClickItem(item, date)
            }
        }
    }
}