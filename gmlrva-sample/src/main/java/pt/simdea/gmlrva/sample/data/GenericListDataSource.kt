package pt.simdea.gmlrva.sample.data

import android.content.Context
import androidx.annotation.IntRange
import androidx.paging.PageKeyedDataSource
import pt.simdea.gmlrva.lib.IGenericRecyclerViewLayout
import androidx.recyclerview.widget.RecyclerView
import pt.simdea.gmlrva.lib.ViewHolder
import pt.simdea.gmlrva.sample.R
import pt.simdea.gmlrva.sample.layouts.holders.*
import java.util.ArrayList


class GenericListDataSource(
        private val context: Context
) : PageKeyedDataSource<Any, IGenericRecyclerViewLayout<ViewHolder>>() {

    private val mDataProvider = FakeDataProvider()
    private var mCarouselItemDataWithOptions: MutableList<CarouselItemWithOptionLayout> = ArrayList()

    override fun loadInitial(params: LoadInitialParams<Any>, callback: LoadInitialCallback<Any, IGenericRecyclerViewLayout<ViewHolder>>) {
        callback.onResult(buildGenericListExample(), null, 2)
    }

    override fun loadAfter(params: LoadParams<Any>, callback: LoadCallback<Any, IGenericRecyclerViewLayout<ViewHolder>>) {
    }

    override fun loadBefore(params: LoadParams<Any>, callback: LoadCallback<Any, IGenericRecyclerViewLayout<ViewHolder>>) {
    }

    /** Procedure meant to rebuild the existing data list.  */
    /*private fun rebuildGenericListExample() {
        val exampleHolders = ArrayList<IGenericRecyclerViewLayout<*>>()

        /* Add a Single Image Item Example */
        val singleItemLayout = SingleImageItemLayout(R.mipmap.gmlrva_ic_launcher, this)
        exampleHolders.add(singleItemLayout)

        /* Add a Carousel (Category + List with options) Item Example */
        mCarouselItemDataWithOptions = buildCarouselItemWithOptionsData(20)
        val carouselCategoryItemWithOptionsLayout = CarouselCategoryItemWithOptionLayout("Carousel Title With Option",
                mCarouselItemDataWithOptions, this)
        exampleHolders.add(carouselCategoryItemWithOptionsLayout)

        /* Add a Single Text Item Example */
        val singleTextItemLayout = SingleTextItemLayout(context.getString(R.string.gmlrva_app_name), this)
        exampleHolders.add(singleTextItemLayout)

        val adapter = mGenericTest!!.adapter as GenericMultipleLayoutAdapter?
        adapter!!.updateList(exampleHolders)
    }*/

    /**
     * Procedure meant to build the Sample List, showcasing multiple layout types manage by the same
     * [RecyclerView.Adapter] instance.
     * @return the intended Sample List.
     */
    private fun buildGenericListExample(): List<IGenericRecyclerViewLayout<ViewHolder>> {
        val exampleHolders = ArrayList<IGenericRecyclerViewLayout<ViewHolder>>()

        /* Add a Single Image Item Example */
        val singleItemLayout = SingleImageItemLayout(R.mipmap.gmlrva_ic_launcher)
        exampleHolders.add(singleItemLayout)

        /* Add a Single Text Item Example */
        val singleTextItemLayout = SingleTextItemLayout(context.getString(R.string.gmlrva_app_name))
        exampleHolders.add(singleTextItemLayout)

        /* Add a Carousel (Category + List) Item Example */
        val mCarouselItemData = buildCarouselItemData(10)
        val carouselCategoryItemLayout = CarouselCategoryItemLayout("Carousel Title", mCarouselItemData, context)
        exampleHolders.add(carouselCategoryItemLayout)

        /* Add a Carousel (Category + List with options) Item Example */
        mCarouselItemDataWithOptions = buildCarouselItemWithOptionsData(10)
        val carouselCategoryItemWithOptionsLayout = CarouselCategoryItemWithOptionLayout("Carousel Title With Option",
                mCarouselItemDataWithOptions, context)
        exampleHolders.add(carouselCategoryItemWithOptionsLayout)

        /* Add a Single Image Item Example */
        val singleItemLayout3 = SingleImageItemLayout(R.mipmap.gmlrva_ic_launcher)
        exampleHolders.add(singleItemLayout3)

        /* Add a Single Image Item Example */
        val singleItemLayout4 = SingleImageItemLayout(R.mipmap.gmlrva_ic_launcher)
        exampleHolders.add(singleItemLayout4)

        /* Add a Single Image Item Example */
        val singleItemLayout5 = SingleImageItemLayout(R.mipmap.gmlrva_ic_launcher)
        exampleHolders.add(singleItemLayout5)

        /* Add a Single Image Item Example */
        val singleItemLayout6 = SingleImageItemLayout(R.mipmap.gmlrva_ic_launcher)
        exampleHolders.add(singleItemLayout6)

        return exampleHolders
    }

    /**
     * Auxiliary procedure meant to build the Carousel item list sample for the Carousel example present in this
     * activity's Sample List.
     * @param maxItemNumber the maximum number of carousel items.
     * @return the intended Carousel item list.
     */
    private fun buildCarouselItemData(@IntRange(from = 0) maxItemNumber: Int): List<IGenericRecyclerViewLayout<ViewHolder>> {
        val carouselItemData = ArrayList<IGenericRecyclerViewLayout<ViewHolder>>()

        var title: String
        var description: String
        val resource = R.mipmap.gmlrva_ic_launcher_round
        var item: FakeDataObject
        for (i in 0 until maxItemNumber) {
            item = mDataProvider.provideFakeData()
            title = item.mTitle
            description = item.mDescription
            carouselItemData.add(CarouselItemLayout(title, description, resource))
        }

        return carouselItemData
    }

    /**
     * Auxiliary procedure meant to build the Carousel item list with options sample for the Carousel example present
     * in this activity's Sample List.
     * @param maxItemNumber the maximum number of carousel items.
     * @return the intended Carousel item list.
     */
    private fun buildCarouselItemWithOptionsData(@IntRange(from = 0) maxItemNumber: Int): List<CarouselItemWithOptionLayout> {
        val carouselItemData = ArrayList<CarouselItemWithOptionLayout>()

        var title: String
        var description: String
        val resource = R.mipmap.gmlrva_ic_launcher_round
        var item: FakeDataObject
        for (i in 0 until maxItemNumber) {
            item = mDataProvider.provideFakeData()
            title = item.mTitle
            description = item.mDescription
            carouselItemData.add(CarouselItemWithOptionLayout(title, description, resource))
        }

        return carouselItemData
    }


}