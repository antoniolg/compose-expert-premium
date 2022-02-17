package com.antonioleiva.marvelcompose

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Qualifier

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @PrivateKey
    fun providePrivateKey(): String = BuildConfig.MARVEL_PRIVATE_KEY

    @Provides
    @PublicKey
    fun providePublicKey(): String = BuildConfig.MARVEL_PUBLIC_KEY
}

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class PrivateKey

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class PublicKey