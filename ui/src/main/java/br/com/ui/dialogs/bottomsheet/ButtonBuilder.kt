package br.com.ui.dialogs.bottomsheet

import android.os.Parcelable
import androidx.annotation.StringRes
import kotlinx.parcelize.Parcelize

@Parcelize
data class ButtonBuilder(
    var text: String? = null,
    @StringRes var textRes: Int = 0,
    var onClick: ActionListener? = null,
) : Parcelable