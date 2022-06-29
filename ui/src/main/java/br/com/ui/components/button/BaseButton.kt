package br.com.ui.components.button

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.ButtonBarLayout
import androidx.core.content.withStyledAttributes
import br.com.ui.R

class BaseButton @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0) : AppCompatButton(context, attrs, defStyleAttr) {

    init {
        parseAttrs(context, attrs)
    }

    private fun parseAttrs(context: Context, attrs: AttributeSet?) {
        context.withStyledAttributes(attrs, R.styleable.BaseButton) {
            text = getString(R.styleable.BaseButton_btnText).orEmpty()
//            butt.text = getString(R.styleable.CardView_label).orEmpty()
//            subtitle.text = getString(R.styleable.CardView_description).orEmpty()
//            setIcon(getResourceId(R.styleable.LendingCommonUiActionItemView_lending_commonui_icon, UNDEFINED_RESOURCE))
        }
    }

}