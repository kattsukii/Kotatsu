package org.koitharu.kotatsu.core.parser

import org.koitharu.kotatsu.base.domain.MangaLoaderContext
import org.koitharu.kotatsu.core.model.MangaPage
import org.koitharu.kotatsu.core.model.MangaSource
import org.koitharu.kotatsu.core.model.MangaTag
import org.koitharu.kotatsu.core.model.SortOrder

abstract class RemoteMangaRepository(
	protected val loaderContext: MangaLoaderContext
) : MangaRepository {

	protected abstract val source: MangaSource

	protected val conf by lazy {
		loaderContext.getSettings(source)
	}

	override val sortOrders: Set<SortOrder> get() = emptySet()

	override suspend fun getPageFullUrl(page: MangaPage): String = page.url

	override suspend fun getTags(): Set<MangaTag> = emptySet()

	abstract fun onCreatePreferences(): Set<String>
}