package compose.about.me.database.di

import android.content.Context
import androidx.room.Room
import compose.about.me.database.ProjectDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object DatabaseModule {

    @Provides
    @Singleton
    fun provideProjectDatabase(
        @ApplicationContext context: Context
    ): ProjectDatabase = Room.databaseBuilder(
        context,
        ProjectDatabase::class.java,
        "composeAboutMeDatabase"
    ).build()
}
