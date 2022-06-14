package br.com.first.di

import br.com.first.navigation.FirstFeatureNavigationImpl
import br.com.navigation.firstfeature.FirstFeatureNavigation
import org.koin.dsl.module

val navigation = module {

    factory<FirstFeatureNavigation> { FirstFeatureNavigationImpl() }
}

val firstFeatureModules = listOf(navigation)
