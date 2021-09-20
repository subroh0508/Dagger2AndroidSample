package net.subroh0508.dagger2sample.legacy.components.view

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class SearchAnimeFragmentAdapter(
    activity: FragmentActivity,
    private val letters: List<String>,
    private val fragmentFactory: (Int) -> Fragment,
) : FragmentStateAdapter(activity) {
    override fun getItemCount() = letters.size

    override fun createFragment(position: Int) = fragmentFactory(position)
}
