package br.com.ui.components.button

import android.content.Context
import android.content.ContextWrapper
import android.util.AttributeSet
import androidx.annotation.StringRes
import androidx.annotation.StyleRes
import androidx.appcompat.view.ContextThemeWrapper
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.withStyledAttributes
import br.com.ui.R


class BaseButton @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0) : AppCompatButton(context, attrs, defStyleAttr) {

//    @StringRes
//    var textRes: Int? = null
//    var text: String? = null

//    @StyleRes
//    var style: Int? = null
//
//    var onClick: (() -> Unit)? = null

    init {
        parseAttrs(context, attrs)
    }

    private fun parseAttrs(context: Context, attrs: AttributeSet?) {
        context.withStyledAttributes(attrs, R.styleable.BaseButton) {
            text = getString(R.styleable.BaseButton_btnText).orEmpty()
//            style = getResourceId(R.styleable.BaseButton_style, R.style.PrimaryBaseButton)
//            butt.text = getString(R.styleable.CardView_label).orEmpty()
        }
    }

//    override fun setOnClickListener(l: OnClickListener?) {
//        onClick?.let {
//            it.invoke()
//            return
//        }
//        super.setOnClickListener(l)
//    }


    class Builder(context: Context) {
        @StringRes
        var textRes: Int? = null
        var text: String? = null
        @StyleRes
        var style: Int = R.style.PrimaryBaseButton
        var onClick: (() -> Unit)? = null
    }
}
