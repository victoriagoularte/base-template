package br.com.ui.dialogs.bottomsheet

import android.os.Parcelable
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import kotlinx.parcelize.Parcelize

data class BottomSheetBuilder(
    @DrawableRes var illustration: Int? = null,
    var title: CharSequence? = null,
    @StringRes var titleRes: Int? = null,
    var description: CharSequence? = null,
    @StringRes var descriptionRes: Int? = null,
    var button: ButtonBuilder? = null,
    var cancelButton: ButtonBuilder? = null,
    var isCancelable: Boolean = true,
) {
    fun button(block: ButtonBuilder.() -> Unit) {
        button = ButtonBuilder().apply(block)
    }

    fun cancelButton(block: ButtonBuilder.() -> Unit) {
        cancelButton = ButtonBuilder().apply(block)
    }
}

@Parcelize
class ActionListener(val action: () -> Unit) : Parcelable {
    fun execute() = action()
}