package br.com.ui.dialogs.bottomsheet

import android.app.Activity
import android.content.ClipDescription
import android.content.Context
import android.text.Spannable
import android.text.Spanned
import android.view.View
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity

data class BottomSheetDSLBuilder(
    val context: Context,
    val title: Spannable?,
    val description: Spannable?,
//    val setCustomView: (View, DialogFragment) -> Unit
) {

    constructor(builder: Builder) : this(
        builder.context,
        builder.title,
        builder.description,
//        builder.setCustomView
    )

    init {
        val bottomSheet = BaseBottomSheet()
        bottomSheet.title = title
        bottomSheet.description = description
//        frag.setCustomView(setCustomView)
        bottomSheet.show(
            (context as FragmentActivity).supportFragmentManager,
            "BaseBottomSheet"
        )
    }

    companion object {
        inline fun Activity.bottomSheet(block: Builder.() -> Unit) {
            Builder(this).apply(block).build()
        }

        inline fun Fragment.bottomSheet(block: Builder.() -> Unit) {
            Builder(this.requireActivity())
                .apply(block).build()
        }
    }

    class Builder(context: Context) {
        var context: Context = context
        var title: Spannable? = null
        var description: Spannable? = null
//        lateinit var setCustomView: (View, DialogFragment) -> Unit
        fun build() = BottomSheetDSLBuilder(this)
    }
}