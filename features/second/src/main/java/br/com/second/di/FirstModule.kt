package br.com.second.di

import br.com.navigation.secondfeature.SecondFeatureNavigation
import br.com.second.navigation.SecondFeatureNavigationImpl
import org.koin.dsl.module

val navigation = module {
    factory<SecondFeatureNavigation> { SecondFeatureNavigationImpl() }
}

val secondFeatureModules = listOf(navigation)
