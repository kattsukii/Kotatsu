package org.koitharu.kotatsu.list.ui.model

import org.koitharu.kotatsu.list.ui.adapter.MangaListAdapter
import org.koitharu.kotatsu.parsers.model.Manga

class MangaGridModel(
	override val id: Long,
	override val title: String,
	override val coverUrl: String,
	override val manga: Manga,
	override val counter: Int,
	override val progress: Float,
) : MangaItemModel() {

	override fun equals(other: Any?): Boolean {
		if (this === other) return true
		if (javaClass != other?.javaClass) return false

		other as MangaGridModel

		if (id != other.id) return false
		if (title != other.title) return false
		if (coverUrl != other.coverUrl) return false
		if (manga != other.manga) return false
		if (counter != other.counter) return false
		return progress == other.progress
	}

	override fun hashCode(): Int {
		var result = id.hashCode()
		result = 31 * result + title.hashCode()
		result = 31 * result + coverUrl.hashCode()
		result = 31 * result + manga.hashCode()
		result = 31 * result + counter
		result = 31 * result + progress.hashCode()
		return result
	}
}
