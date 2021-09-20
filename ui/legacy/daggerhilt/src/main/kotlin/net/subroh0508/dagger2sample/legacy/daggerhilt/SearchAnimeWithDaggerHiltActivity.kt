package net.subroh0508.dagger2sample.legacy.daggerhilt

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import net.subroh0508.dagger2sample.legacy.components.databinding.ActivitySearchAnimeBinding
import net.subroh0508.dagger2sample.legacy.components.view.SearchAnimeFragmentAdapter
import javax.inject.Inject

@AndroidEntryPoint
class SearchAnimeWithDaggerHiltActivity : AppCompatActivity(R.layout.activity_search_anime) {
    @Inject
    lateinit var fragmentAdapter: SearchAnimeFragmentAdapter

    private val binding by lazy { ActivitySearchAnimeBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.viewPager.adapter = fragmentAdapter
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = letters[position]
        }.attach()
    }

    internal val letters: List<String> by lazy { resources.getStringArray(R.array.letters).toList() }
}
