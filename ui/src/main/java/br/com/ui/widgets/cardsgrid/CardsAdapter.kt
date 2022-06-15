package br.com.ui.widgets.cardsgrid

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter

class CardsAdapter(diffCallback: DiffUtil.ItemCallback<Card>) :
    ListAdapter<Card, CardView>(diffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardView {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: CardView, position: Int) {
        TODO("Not yet implemented")
    }


}