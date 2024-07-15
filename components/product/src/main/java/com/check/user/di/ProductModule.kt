package com.check.user.di

import com.check.user.data.dataSource.ProductIDataSource
import com.check.user.data.dataSource.remote.ProductRemoteDataSource
import com.check.user.data.repositories.ProductRepoImp
import com.check.user.domain.repositories.ProductIRepo
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class ProductModule {
    @Binds
    internal abstract fun provideProductRepository(productRepoImp: ProductRepoImp): ProductIRepo

    @Binds
    internal abstract fun provideProductDataSource(productRemoteDataSource: ProductRemoteDataSource): ProductIDataSource
}