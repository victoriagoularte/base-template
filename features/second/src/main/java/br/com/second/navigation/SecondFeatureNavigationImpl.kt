package br.com.second.navigation

import android.content.Context
import android.content.Intent
import br.com.navigation.secondfeature.SecondFeatureNavigation
import br.com.second.presentation.SecondMainActivity

internal class SecondFeatureNavigationImpl : SecondFeatureNavigation {

    override fun navigateToSecond(context: Context) {
        context.startActivity(Intent(context, SecondMainActivity::class.java))
    }
}