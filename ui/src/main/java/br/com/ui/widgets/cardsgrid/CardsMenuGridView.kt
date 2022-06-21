package br.com.ui.widgets.cardsgrid

import android.content.Context
import android.util.AttributeSet
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import br.com.ui.R

private const val NUMBER_OF_COLS = 3

class CardsMenuGridView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
) : RecyclerView(context, attrs, defStyleAttr) {

    private val listAdapter = CardsAdapter()

    init {
        setupConfigs()
    }

    private fun setupConfigs() {
        adapter = listAdapter
        layoutManager = StaggeredGridLayoutManager(NUMBER_OF_COLS, LinearLayoutManager.VERTICAL)
    }

    fun setList(list: List<CardMenu>) {
        listAdapter.submitList(list)
    }

    fun setOnClickItemListener(onClick: OnClickItem) {
        listAdapter.callback = onClick
    }
}
