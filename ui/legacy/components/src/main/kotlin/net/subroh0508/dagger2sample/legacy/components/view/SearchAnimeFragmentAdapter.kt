package net.subroh0508.dagger2sample.legacy.components.view

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject

class SearchAnimeFragmentAdapter @AssistedInject constructor(
    @Assisted activity: FragmentActivity,
    @Assisted private val letters: List<String>,
    @Assisted private val fragmentFactory: (Int) -> Fragment,
) : FragmentStateAdapter(activity) {
    override fun getItemCount() = letters.size

    override fun createFragment(position: Int) = fragmentFactory(position)

    @AssistedFactory
    interface Factory {
        fun create(
            activity: FragmentActivity,
            letters: List<String>,
            fragmentFactory: (Int) -> Fragment,
        ): SearchAnimeFragmentAdapter
    }
}
