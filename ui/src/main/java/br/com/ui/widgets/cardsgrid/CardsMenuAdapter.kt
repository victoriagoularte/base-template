package br.com.ui.widgets.cardsgrid

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter

typealias OnClickItem = (card: CardMenu, position: Int) -> Unit

internal class CardsAdapter : ListAdapter<CardMenu, CardsViewHolder>(ItemDiff()) {

    var callback: OnClickItem? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        CardsViewHolder(CardView(parent.context))

    override fun onBindViewHolder(holder: CardsViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
        holder.itemView.setOnClickListener {
            callback?.invoke(item, position)
        }
    }

    private class ItemDiff : DiffUtil.ItemCallback<CardMenu>() {
        override fun areItemsTheSame(oldItem: CardMenu, newItem: CardMenu): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }

        override fun areContentsTheSame(
            oldItem: CardMenu,
            newItem: CardMenu
        ): Boolean {
            return oldItem == newItem
        }
    }
}