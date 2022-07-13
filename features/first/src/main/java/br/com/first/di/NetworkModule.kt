package br.com.first.di
import br.com.first.BuildConfig
import br.com.first.data.service.FirstFeatureService
import br.com.first.network.DefaultQueryParameterInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    factory { DefaultQueryParameterInterceptor() }
    factory { providesHttpLoggingInterceptor() }
    factory { provideOkHttpClient(get()) }
    single { provideRetrofit(get()) }
}

fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder()
        .baseUrl(BuildConfig.API_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}

fun provideOkHttpClient(defaultInterceptor: DefaultQueryParameterInterceptor): OkHttpClient {
    return OkHttpClient()
        .newBuilder()
        .addInterceptor(defaultInterceptor)
        .build()
}

fun providesHttpLoggingInterceptor() = HttpLoggingInterceptor()
    .apply {
        level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else
            HttpLoggingInterceptor.Level.NONE
    }

fun provideFirstFeatureService(retrofit: Retrofit): FirstFeatureService =
    retrofit.create(FirstFeatureService::class.java)
