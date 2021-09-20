package net.subroh0508.dagger2sample.legacy.components.view

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import net.subroh0508.dagger2sample.data.Anime
import net.subroh0508.dagger2sample.legacy.components.R
import net.subroh0508.dagger2sample.legacy.components.databinding.ListitemAnimeAbstractBinding
import net.subroh0508.dagger2sample.legacy.components.model.getItem
import net.subroh0508.dagger2sample.legacy.components.model.getItemId
import net.subroh0508.dagger2sample.legacy.components.model.itemCount
import net.subroh0508.dagger2sample.legacy.components.viewmodel.SearchAnimeViewModel

class AnimeAbstractsAdapter(
    private val inflater: LayoutInflater,
    private val viewModel: SearchAnimeViewModel,
) : RecyclerView.Adapter<AnimeAbstractsAdapter.ViewHolder>() {
    init { setHasStableIds(true) }

    override fun getItemCount() = viewModel.uiModel.itemCount
    override fun getItemId(position: Int) = viewModel.uiModel.getItemId(position)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(inflater, parent)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(viewModel.uiModel.getItem(position))

    class ViewHolder(
        inflater: LayoutInflater,
        parent: ViewGroup,
    ) : RecyclerView.ViewHolder(inflater.inflate(R.layout.listitem_anime_abstract, parent, false)) {
        private val binding by lazy { ListitemAnimeAbstractBinding.bind(itemView) }

        fun bind(item: Anime) = with (binding) {
            title.text = item.title
            abstractText.text = item.abstract

            linkWikipedia.setOnClickListener {
                itemView.context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(item.wikipediaUrl)))
            }
        }
    }
}
