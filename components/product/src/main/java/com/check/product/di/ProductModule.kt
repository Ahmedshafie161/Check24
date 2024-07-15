package com.check.product.di

import com.check.product.data.dataSource.ProductIDataSource
import com.check.product.data.dataSource.remote.ProductRemoteDataSource
import com.check.product.data.repositories.ProductRepoImp
import com.check.product.domain.repositories.ProductIRepo
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