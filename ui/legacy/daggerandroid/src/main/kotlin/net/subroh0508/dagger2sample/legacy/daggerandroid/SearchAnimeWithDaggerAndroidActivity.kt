package net.subroh0508.dagger2sample.legacy.daggerandroid

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayoutMediator
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import net.subroh0508.dagger2sample.basecomponents.coreComponent
import net.subroh0508.dagger2sample.legacy.components.databinding.ActivitySearchAnimeBinding
import net.subroh0508.dagger2sample.legacy.components.view.SearchAnimeFragmentAdapter
import net.subroh0508.dagger2sample.legacy.daggerandroid.di.DaggerSearchAnimeWithDaggerAndroidActivityComponent
import javax.inject.Inject

class SearchAnimeWithDaggerAndroidActivity : AppCompatActivity(R.layout.activity_search_anime), HasAndroidInjector {
    @Inject
    lateinit var fragmentAdapter: SearchAnimeFragmentAdapter

    private val binding by lazy { ActivitySearchAnimeBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        inject()

        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.viewPager.adapter = fragmentAdapter
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = letters[position]
        }.attach()
    }

    internal val letters: List<String> by lazy { resources.getStringArray(R.array.letters).toList() }

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    override fun androidInjector(): AndroidInjector<Any> = androidInjector

    private fun inject() {
        DaggerSearchAnimeWithDaggerAndroidActivityComponent.factory()
            .create(application.coreComponent, this)
            .inject(this)
    }
}
