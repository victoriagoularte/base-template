package br.com.ui.widgets.cardsgrid

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.withStyledAttributes
import br.com.ui.R
import br.com.ui.databinding.CardViewBinding

private const val UNDEFINED_RESOURCE = -1

class CardView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private val binding: CardViewBinding =
        CardViewBinding.inflate(LayoutInflater.from(context), this, true)

    val title: TextView
        get() = binding.tvLabel

    val subtitle: TextView
        get() = binding.tvDescription

//    val icon: AppCompatImageView
//        get() = binding.ivIcon

    init {
        parseAttrs(context, attrs)
    }

    private fun parseAttrs(context: Context, attrs: AttributeSet?) {
        context.withStyledAttributes(attrs, R.styleable.CardView) {
            title.text = getString(R.styleable.CardView_label).orEmpty()
            subtitle.text = getString(R.styleable.CardView_description).orEmpty()
//            setIcon(getResourceId(R.styleable.LendingCommonUiActionItemView_lending_commonui_icon, UNDEFINED_RESOURCE))
        }
    }

//    fun setIcon(@DrawableRes image: Int) {
//        if (image != UNDEFINED_RESOURCE) {
//            icon.setImageResource(image)
//        }
//    }
//
//    fun setTintIcon(color: Int) {
//        icon.tintDrawable(color)
//    }
}