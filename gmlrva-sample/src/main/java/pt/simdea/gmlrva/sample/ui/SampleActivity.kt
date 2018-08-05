/*
 * Copyright (c) 2017. Simdea.
 */

package pt.simdea.gmlrva.sample.ui

import android.content.Context
import android.content.Intent
import android.graphics.DashPathEffect
import android.graphics.Paint
import android.os.Bundle
import android.util.TypedValue
import androidx.annotation.IntRange
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import pt.simdea.gmlrva.lib.GenericMultipleLayoutAdapter
import pt.simdea.gmlrva.lib.IGenericRecyclerViewLayout
import pt.simdea.gmlrva.lib.animation.animators.ExampleItemAnimator
import pt.simdea.gmlrva.lib.decoration.decorators.SimpleDividerItemDecoration
import pt.simdea.gmlrva.lib.decoration.helpers.GenericDecorationDividerPosition
import pt.simdea.gmlrva.lib.decoration.specs.SimpleDividerItemDecorationSpec
import pt.simdea.gmlrva.lib.utilities.GenericUtils
import pt.simdea.gmlrva.sample.R
import pt.simdea.gmlrva.sample.data.ClickListener
import pt.simdea.gmlrva.sample.data.FakeDataObject
import pt.simdea.gmlrva.sample.data.FakeDataProvider
import pt.simdea.gmlrva.sample.layouts.holders.*
import java.util.*

/**
 * Class responsible for the Sample Screen for the (GMLRVA) library.
 *
 * Created by Paulo Ribeiro on 7/16/2017.
 * Simdea © All Rights Reserved.
 * paulo.ribeiro@simdea.pt
 */
class SampleActivity : AppCompatActivity(), ClickListener {

    private val mDataProvider = FakeDataProvider()

    private var mGenericTest: RecyclerView? = null
    private var mCarouselItemDataWithOptions: List<CarouselItemWithOptionLayout> = ArrayList()

    /**
     * Called when SampleActivity is first created.
     * @param savedInstanceState Bundle object containing the activity's previously saved state.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.gmlrva_activity_sample)
    }

    /** Called when the activity is about to become visible.  */
    override fun onStart() {
        super.onStart()
        bindSampleActivityViews()
    }

    /** Called when the activity has become visible.  */
    override fun onResume() {
        super.onResume()
        if (mGenericTest != null) {
            mGenericTest!!.adapter = GenericMultipleLayoutAdapter(buildGenericListExample(), this, false)
            mGenericTest!!.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

            val thickness = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 3f, resources.displayMetrics)
            val spec = SimpleDividerItemDecorationSpec.DecorationSpecBuilder()
                    .withTopSpacing(25)
                    .withBottomSpacing(25)
                    .withStartSpacing(10)
                    .withEndSpacing(10)
                    //                    .withDrawableDivider(ContextCompat.getDrawable(this, R.drawable.gmlrva_red_line_item_divider))
                    .withDividerPosition(GenericDecorationDividerPosition.POSITION_TOP_BOTTOM)
                    .withDrawnDivider(ContextCompat.getColor(this, R.color.gmlrvaColorAccent), thickness,
                            Paint.Style.STROKE, DashPathEffect(floatArrayOf(5f, 10f), 10f))
                    //                    .withDrawnDivider(ContextCompat.getColor(this, R.color.gmlrvaColorAccent), thickness, null, null)
                    .buildDecorationSpec()
            mGenericTest!!.addItemDecoration(SimpleDividerItemDecoration(spec))

            GenericUtils.setOptimalConfigurationForRecyclerView(mGenericTest!!)
            mGenericTest!!.itemAnimator = ExampleItemAnimator()
        }
    }

    /** {@inheritDoc}  */
    override fun onClick() {
        if (mGenericTest != null) {
            //            rebuildGenericListExample()
            val adapter = mGenericTest!!.adapter as GenericMultipleLayoutAdapter?
            val item = adapter!![1]
            if (item != null) {
                adapter.updateItem(item, ROTATION_TRIGGER)
            }
        }
    }

    /** Procedure meant to rebuild the existing data list.  */
    private fun rebuildGenericListExample() {
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
        val singleTextItemLayout = SingleTextItemLayout(getString(R.string.gmlrva_app_name), this)
        exampleHolders.add(singleTextItemLayout)

        val adapter = mGenericTest!!.adapter as GenericMultipleLayoutAdapter?
        adapter!!.updateList(exampleHolders)
    }

    /**
     * Procedure meant to build the Sample List, showcasing multiple layout types manage by the same
     * [RecyclerView.Adapter] instance.
     * @return the intended Sample List.
     */
    private fun buildGenericListExample(): List<IGenericRecyclerViewLayout<*>> {
        val exampleHolders = ArrayList<IGenericRecyclerViewLayout<*>>()

        /* Add a Single Image Item Example */
        val singleItemLayout = SingleImageItemLayout(R.mipmap.gmlrva_ic_launcher, this)
        exampleHolders.add(singleItemLayout)

        /* Add a Single Text Item Example */
        val singleTextItemLayout = SingleTextItemLayout(getString(R.string.gmlrva_app_name), this)
        exampleHolders.add(singleTextItemLayout)

        /* Add a Carousel (Category + List) Item Example */
        val mCarouselItemData = buildCarouselItemData(10)
        val carouselCategoryItemLayout = CarouselCategoryItemLayout("Carousel Title", mCarouselItemData, this)
        exampleHolders.add(carouselCategoryItemLayout)

        /* Add a Carousel (Category + List with options) Item Example */
        mCarouselItemDataWithOptions = buildCarouselItemWithOptionsData(10)
        val carouselCategoryItemWithOptionsLayout = CarouselCategoryItemWithOptionLayout("Carousel Title With Option",
                mCarouselItemDataWithOptions, this)
        exampleHolders.add(carouselCategoryItemWithOptionsLayout)

        /* Add a Single Image Item Example */
        val singleItemLayout3 = SingleImageItemLayout(R.mipmap.gmlrva_ic_launcher, this)
        exampleHolders.add(singleItemLayout3)

        /* Add a Single Image Item Example */
        val singleItemLayout4 = SingleImageItemLayout(R.mipmap.gmlrva_ic_launcher, this)
        exampleHolders.add(singleItemLayout4)

        /* Add a Single Image Item Example */
        val singleItemLayout5 = SingleImageItemLayout(R.mipmap.gmlrva_ic_launcher, this)
        exampleHolders.add(singleItemLayout5)

        /* Add a Single Image Item Example */
        val singleItemLayout6 = SingleImageItemLayout(R.mipmap.gmlrva_ic_launcher, this)
        exampleHolders.add(singleItemLayout6)

        return exampleHolders
    }

    /**
     * Auxiliary procedure meant to build the Carousel item list sample for the Carousel example present in this
     * activity's Sample List.
     * @param maxItemNumber the maximum number of carousel items.
     * @return the intended Carousel item list.
     */
    private fun buildCarouselItemData(@IntRange(from = 0) maxItemNumber: Int): List<IGenericRecyclerViewLayout<*>> {
        val carouselItemData = ArrayList<IGenericRecyclerViewLayout<*>>()

        var title: String
        var description: String
        val resource = R.mipmap.gmlrva_ic_launcher_round
        var item: FakeDataObject
        for (i in 0 until maxItemNumber) {
            item = mDataProvider.provideFakeData()
            title = item.getTitle()
            description = item.getDescription()
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
            title = item.getTitle()
            description = item.getDescription()
            carouselItemData.add(CarouselItemWithOptionLayout(title, description, resource))
        }

        return carouselItemData
    }

    /** Procedure meant to bind this activity's views.  */
    private fun bindSampleActivityViews() {
        mGenericTest = findViewById(R.id.rvGeneric)
    }

    companion object {

        /**
         * Starter procedure for SampleActivity.
         * @param context the application's current context.
         */
        fun start(context: Context) {
            val starter = Intent(context, SampleActivity::class.java)
            context.startActivity(starter)
        }
    }

}
