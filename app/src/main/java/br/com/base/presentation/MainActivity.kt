package br.com.base.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.base.R
import br.com.navigation.firstfeature.FirstFeatureNavigation
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    private val firstFeatureNavigation: FirstFeatureNavigation by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        firstFeatureNavigation.navigateToFirst(this)
    }
}