package com.example.citydbcompose.di


import com.example.citydbcompose.data.network.ApiService
import com.example.citydbcompose.data.repositories.CityRepositoryImpl
import com.example.citydbcompose.domain.repositories.CityRepository
import com.example.citydbcompose.domain.usecases.GetCitiesUseCase
import com.example.citydbcompose.domain.usecases.GetCityDetailsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideHttpClient(): HttpClient {
        return HttpClient(CIO)
    }

    @Provides
    @Singleton
    fun provideApiService(client: HttpClient): ApiService {
        return ApiService(client)
    }

    @Provides
    @Singleton
    fun provideCityRepository(apiService: ApiService): CityRepository {
        return CityRepositoryImpl(apiService)
    }

    @Provides
    @Singleton
    fun provideGetCitiesUseCase(repository: CityRepository): GetCitiesUseCase {
        return GetCitiesUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideGetCityDetailsUseCase(repository: CityRepository): GetCityDetailsUseCase {
        return GetCityDetailsUseCase(repository)
    }
}