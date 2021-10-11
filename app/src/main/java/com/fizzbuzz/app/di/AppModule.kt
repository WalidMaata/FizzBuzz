package com.fizzbuzz.app.di

import android.content.Context
import androidx.room.Room
import com.fizzbuzz.app.data.database.FizzBuzzDatabase
import com.fizzbuzz.app.data.repositories.FizzBuzzRepository
import com.fizzbuzz.app.data.repositories.FizzBuzzRepositoryImplem
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Singleton
    @Provides
    fun provideDataBase(@ApplicationContext context: Context): FizzBuzzDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            FizzBuzzDatabase::class.java,
            "FizzBuzz.db"
        ).build()
    }

    @Singleton
    @Provides
    fun provideFizzBuzzRepository(
        database: FizzBuzzDatabase
    ) : FizzBuzzRepository {
        return FizzBuzzRepositoryImplem(database.fizzBuzzDao())
    }

}
