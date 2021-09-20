package net.subroh0508.dagger2sample.legacy.daggerhilt.di

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ActivityContext
import net.subroh0508.dagger2sample.legacy.components.view.SearchAnimeFragmentAdapter
import net.subroh0508.dagger2sample.legacy.daggerhilt.SearchAnimeWithDaggerHiltActivity
import net.subroh0508.dagger2sample.legacy.daggerhilt.SearchAnimeWithDaggerHiltFragment

@Module
@InstallIn(ActivityComponent::class)
class SearchAnimeWithDaggerHiltActivityModule {
    @Provides
    fun provideSearchAnimeFragmentAdapter(
        @ActivityContext context: Context,
    ) = (context as SearchAnimeWithDaggerHiltActivity).let { a ->
        SearchAnimeFragmentAdapter(
            a,
            a.letters,
        ) { index -> SearchAnimeWithDaggerHiltFragment(a.letters[index]) }
    }
}
