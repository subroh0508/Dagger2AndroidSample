package net.subroh0508.dagger2sample.legacy.daggerhilt

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import net.subroh0508.dagger2sample.legacy.components.databinding.FragmentSearchAnimeBinding
import net.subroh0508.dagger2sample.legacy.components.view.AnimeAbstractsAdapter
import net.subroh0508.dagger2sample.legacy.components.view.viewBinding
import net.subroh0508.dagger2sample.legacy.components.viewmodel.SearchAnimeViewModel
import javax.inject.Inject

@AndroidEntryPoint
class SearchAnimeWithDaggerHiltFragment : Fragment(R.layout.fragment_search_anime) {
    @Inject
    lateinit var viewModel: SearchAnimeViewModel
    @Inject
    lateinit var animeAbstractsAdapter: AnimeAbstractsAdapter

    private val binding by viewBinding(FragmentSearchAnimeBinding::bind)
    private val letter: String by lazy { requireArguments().getString(LETTER) ?: throw IllegalArgumentException() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.list.adapter = animeAbstractsAdapter
        binding.list.layoutManager = LinearLayoutManager(context)

        viewModel.uiModel.onEach {
            it.error?.let(::showErrorMessage)
            binding.progressCircular.isVisible = it.loading

            animeAbstractsAdapter.notifyDataSetChanged()
        }.launchIn(viewLifecycleOwner.lifecycleScope)

        viewModel.search(letter)
    }

    private fun showErrorMessage(error: Throwable) = Toast.makeText(
        context,
        getString(R.string.an_error_occurred, error.message ?: "Unknown"),
        Toast.LENGTH_LONG,
    ).show()

    companion object {
        private const val LETTER = "letter"

        operator fun invoke(letter: String) = SearchAnimeWithDaggerHiltFragment().apply {
            arguments = bundleOf(LETTER to letter)
        }
    }
}
