package br.com.ui.widgets.cardsgrid

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.content.res.AppCompatResources
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CardsGridView @JvmOverloads constructor(
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
        layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        val dividerDecoration = DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
        AppCompatResources.getDrawable(context, R.drawable.lending_commonui_divider_horizontal)
            ?.let { divider ->
            dividerDecoration.setDrawable(divider)
        }
        setBackgroundResource(R.drawable.lending_commonui_bg_divider_horizontal)
        addItemDecoration(dividerDecoration)
    }

    fun setList(list: List<LendingAction>) {
        listAdapter.submitList(list)
    }

    fun setOnClickItemListener(onClick: OnClickItem) {
        listAdapter.callback = onClick
    }
}
