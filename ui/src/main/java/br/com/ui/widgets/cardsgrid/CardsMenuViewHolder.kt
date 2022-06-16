package br.com.ui.widgets.cardsgrid

import android.widget.TextView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView

private const val UNDEFINED_ICON = -1

internal class CardsViewHolder(private val rootView: CardView) :
    RecyclerView.ViewHolder(rootView) {

    fun bind(item: CardMenu) = with(rootView) {
//        icon.configIcon(item.icon, item.iconRes, item.iconColor ?: R.color.apl_grayscale_900)
        title.configTextInfo(item.title, item.titleRes)
        subtitle.configTextInfo(item.subtitle, item.subtitleRes)
    }

//    private fun AppCompatImageView.configIcon(icon: String?, iconRes: Int?, iconColor: Int) {
//        when {
//            iconRes == UNDEFINED_ICON -> isVisible = false
//            iconRes != null ->
//                setImageResource(iconRes)
//            icon != null -> load(icon)
//        }
//        isVisible = iconRes != null || icon != null
//        tintDrawable(iconColor)
//    }
//
    private fun TextView.configTextInfo(label: String?, labelRes: Int?) {
        if (label != null) {
            text = label
            isVisible = true
        } else if (labelRes != null) {
            setText(labelRes)
            isVisible = true
        }
    }
}