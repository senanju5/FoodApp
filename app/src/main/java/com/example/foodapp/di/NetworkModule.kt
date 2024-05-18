package com.example.foodapp.di
import com.example.foodapp.utils.Constants.Companion.BASE_URL
import com.example.foodapp.data.network.FoodRecipeApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Singleton
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideHttpClient():OkHttpClient {
        return OkHttpClient.Builder()
            .readTimeout(15,TimeUnit.SECONDS)
            .connectTimeout(15, TimeUnit.SECONDS)
            .build()
    }

    @Singleton
    @Provides
    fun provideConverterFactoryInstance():GsonConverterFactory {
     return GsonConverterFactory.create()
    }
    
    @Singleton
    @Provides
    fun provideRetrofitInstance(
        okHttpClient: OkHttpClient,
        gsonConverterFactory: GsonConverterFactory
    ):Retrofit {
       return Retrofit.Builder()
           .baseUrl(BASE_URL)
           .client(okHttpClient)
           .addConverterFactory(gsonConverterFactory)
           .build()
    }

    @Singleton
    @Provides
    fun provideApiService(retrofit:Retrofit): FoodRecipeApi {
      return retrofit.create(FoodRecipeApi::class.java)
    }
}