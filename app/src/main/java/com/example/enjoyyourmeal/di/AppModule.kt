package com.example.enjoyyourmeal.di

import com.example.enjoyyourmeal.data.datasource.OrderDataSource
import com.example.enjoyyourmeal.data.repo.OrderRepository
import com.example.enjoyyourmeal.retrofit.ApiUtils
import com.example.enjoyyourmeal.retrofit.YemeklerDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {


    @Provides
    @Singleton
    fun provideOrderDataSource(ydao:YemeklerDao) : OrderDataSource{
        return OrderDataSource(ydao)
    }

    @Provides
    @Singleton
    fun provideOrderRepository(ods: OrderDataSource) : OrderRepository{
        return OrderRepository(ods)
    }


    @Provides
    @Singleton
    fun provideYemeklerDao() : YemeklerDao{
        return ApiUtils.getYemeklerDao()
    }


}