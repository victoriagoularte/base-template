package br.com.ui.dialogs.bottomsheet

import android.os.Parcelable
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.annotation.StyleRes
import kotlinx.parcelize.Parcelize

@Parcelize
data class HeaderBuilder(
    var title: String? = null,
    @StringRes var titleRes: Int = 0,
    @StyleRes var textStyle: Int,
    @DrawableRes var iconRes: Int,
    @ColorRes var iconTint: Int,
    var onIconClick: (() -> Unit)? = null,
) : Parcelable