package net.subroh0508.dagger2sample.repository.api.json

internal data class DBPediaResponse(
    val results: Result,
) {
    data class Result(
        val bindings: List<Binding>,
    )

    data class Binding(
        val id: Item,
        val title: Item,
        val abstract: Item,
        val wikipedia: Item,
    )

    data class Item(
        val type: String,
        val value: String,
    )
}
