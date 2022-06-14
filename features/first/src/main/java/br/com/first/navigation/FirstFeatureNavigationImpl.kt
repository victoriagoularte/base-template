package br.com.first.navigation

import android.content.Context
import android.content.Intent
import br.com.first.presentation.FirstMainActivity
import br.com.navigation.firstfeature.FirstFeatureNavigation

internal class FirstFeatureNavigationImpl : FirstFeatureNavigation {

    override fun navigateToFirst(context: Context) {
        context.startActivity(Intent(context, FirstMainActivity::class.java))
    }
}