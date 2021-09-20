package net.subroh0508.dagger2sample.legacy.dagger

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayoutMediator
import net.subroh0508.dagger2sample.basecomponents.coreComponent
import net.subroh0508.dagger2sample.legacy.components.databinding.ActivitySearchAnimeBinding
import net.subroh0508.dagger2sample.legacy.components.view.SearchAnimeFragmentAdapter_Factory
import net.subroh0508.dagger2sample.legacy.dagger.di.DaggerSearchAnimeWithDaggerActivityComponent
import net.subroh0508.dagger2sample.legacy.dagger.di.SearchAnimeWithDaggerActivityComponent
import javax.inject.Inject

class SearchAnimeWithDaggerActivity : AppCompatActivity(R.layout.activity_search_anime), ActivityComponentProvider {
    @Inject
    lateinit var fragmentAdapterAssistedFactory: SearchAnimeFragmentAdapter_Factory

    private val binding by lazy { ActivitySearchAnimeBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        inject()

        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.viewPager.adapter = fragmentAdapterAssistedFactory.get(
            this, letters,
        ) { index -> SearchAnimeWithDaggerFragment(letters[index]) }
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = letters[position]
        }.attach()
    }

    private val letters: List<String> by lazy { resources.getStringArray(R.array.letters).toList() }

    override lateinit var activityComponent: SearchAnimeWithDaggerActivityComponent

    private fun inject() {
        activityComponent = DaggerSearchAnimeWithDaggerActivityComponent.factory()
            .create(application.coreComponent, this)

        activityComponent.inject(this)
    }
}
