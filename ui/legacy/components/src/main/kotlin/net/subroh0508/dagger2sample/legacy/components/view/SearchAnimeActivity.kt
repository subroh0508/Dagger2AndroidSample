package net.subroh0508.dagger2sample.legacy.components.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayoutMediator
import net.subroh0508.dagger2sample.legacy.components.R
import net.subroh0508.dagger2sample.legacy.components.databinding.ActivitySearchAnimeBinding
import javax.inject.Inject

class SearchAnimeActivity : AppCompatActivity(R.layout.activity_search_anime) {
    @Inject
    lateinit var fragmentAdapter: SearchAnimeFragmentAdapter

    private val binding by lazy { ActivitySearchAnimeBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.viewPager.adapter = fragmentAdapter
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = letters[position]
        }.attach()
    }

    val letters: List<String> by lazy(resources.getStringArray(R.array.letters)::toList)
}

class SearchAnimeFragmentAdapter(
    activity: FragmentActivity,
    private val letters: List<String>,
    private val fragmentFactory: (Int) -> AbstractSearchAnimeFragment,
) : FragmentStateAdapter(activity) {
    override fun getItemCount() = letters.size

    override fun createFragment(position: Int) = fragmentFactory(position)
}
