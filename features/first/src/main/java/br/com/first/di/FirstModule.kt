package br.com.first.di

import br.com.first.data.service.FirstFeatureService
import br.com.first.navigation.FirstFeatureNavigationImpl
import br.com.navigation.firstfeature.FirstFeatureNavigation
import org.koin.dsl.module
import retrofit2.Retrofit

val navigationModule = module {

    factory { provideService(get()) }
    factory<FirstFeatureNavigation> { FirstFeatureNavigationImpl() }
}

val firstFeatureModules = listOf(navigationModule, networkModule)

fun provideService(retrofit: Retrofit): FirstFeatureService = retrofit.create(FirstFeatureService::class.java)
