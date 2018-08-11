package pt.simdea.gmlrva.sample.data

import android.content.Context
import androidx.paging.DataSource
import androidx.paging.DataSource.Factory
import pt.simdea.gmlrva.lib.IGenericRecyclerViewLayout
import pt.simdea.gmlrva.lib.ViewHolder

class GenericListDataFactory(private val context: Context): Factory<Any, IGenericRecyclerViewLayout<out ViewHolder>>() {

    private lateinit var feedDataSource: GenericListDataSource

    override fun create(): DataSource<Any, IGenericRecyclerViewLayout<out ViewHolder>> {
        feedDataSource = GenericListDataSource(context)
        return feedDataSource
    }

}