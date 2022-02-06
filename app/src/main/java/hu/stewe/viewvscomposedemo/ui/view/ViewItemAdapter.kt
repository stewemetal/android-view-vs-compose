package hu.stewemetal.viewvscomposedemo.ui.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import hu.stewemetal.viewvscomposedemo.R
import hu.stewemetal.viewvscomposedemo.model.Item
import hu.stewemetal.viewvscomposedemo.ui.view.ViewItemAdapter.ItemViewHolder

class ViewItemAdapter : ListAdapter<Item, ItemViewHolder>(ItemDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder =
        ItemViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.layout_item, parent, false)
        )

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ItemViewHolder(itemView: View) : ViewHolder(itemView) {
        private val itemText: TextView = itemView.findViewById(R.id.itemText)

        fun bind(item: Item) {
            itemText.text = item.text
        }
    }
}

class ItemDiffUtil : DiffUtil.ItemCallback<Item>() {
    override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
        return oldItem == newItem
    }
}
