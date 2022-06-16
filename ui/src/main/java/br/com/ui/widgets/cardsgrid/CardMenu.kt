package br.com.ui.widgets.cardsgrid

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class CardMenu(
    val id: String? = null,
    @DrawableRes val iconRes: Int? = null,
    val icon: String? = null,
    val iconColor: Int? = null,
    var title: String? = null,
    @StringRes var titleRes: Int? = null,
    var subtitle: String? = null,
    @StringRes var subtitleRes: Int? = null,
)