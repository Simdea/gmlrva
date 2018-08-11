package pt.simdea.gmlrva.sample.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import pt.simdea.gmlrva.lib.IGenericRecyclerViewLayout
import pt.simdea.gmlrva.lib.ViewHolder
import pt.simdea.gmlrva.sample.data.GenericListDataFactory
import java.util.concurrent.Executor
import java.util.concurrent.Executors


class SampleViewModel(context: Context) : ViewModel() {
    private var executor: Executor = Executors.newFixedThreadPool(5)
    private var articleLiveData: LiveData<PagedList<IGenericRecyclerViewLayout<ViewHolder>>>

    init {
        val dataFactory = GenericListDataFactory(context)

        val pagedListConfig = PagedList.Config.Builder()
                .setEnablePlaceholders(false)
                .setInitialLoadSizeHint(10)
                .setPageSize(20).build()

        articleLiveData = LivePagedListBuilder(dataFactory, pagedListConfig)
                .setFetchExecutor(executor)
                .build()
    }

    fun getArticleLiveData(): LiveData<PagedList<IGenericRecyclerViewLayout<ViewHolder>>> {
        return articleLiveData
    }

}