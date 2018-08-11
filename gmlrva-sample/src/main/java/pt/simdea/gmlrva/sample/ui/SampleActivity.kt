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
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import pt.simdea.gmlrva.lib.GenericMultipleLayoutAdapter
import pt.simdea.gmlrva.lib.IGenericRecyclerViewLayout
import pt.simdea.gmlrva.lib.animation.animators.ExampleItemAnimator
import pt.simdea.gmlrva.lib.decoration.decorators.SimpleDividerItemDecoration
import pt.simdea.gmlrva.lib.decoration.helpers.GenericDecorationDividerPosition
import pt.simdea.gmlrva.lib.decoration.helpers.GenericDecorationDividerPositionVars
import pt.simdea.gmlrva.lib.decoration.specs.SimpleDividerItemDecorationSpec
import pt.simdea.gmlrva.lib.utilities.GenericUtils
import pt.simdea.gmlrva.sample.R
import pt.simdea.gmlrva.sample.data.ClickListener
import pt.simdea.gmlrva.sample.data.FakeDataObject
import pt.simdea.gmlrva.sample.data.FakeDataProvider
import pt.simdea.gmlrva.sample.layouts.animation.ChangeAnimationTypesVars.Companion.ROTATION_TRIGGER
import pt.simdea.gmlrva.sample.layouts.holders.*
import pt.simdea.gmlrva.sample.viewmodel.SampleViewModel
import java.util.*

/**
 * Class responsible for the Sample Screen for the (GMLRVA) library.
 *
 * Created by Paulo Ribeiro on 7/16/2017.
 * Simdea © All Rights Reserved.
 * paulo.ribeiro@simdea.pt
 */
class SampleActivity : AppCompatActivity(), ClickListener {

    private lateinit var sampleViewModel: SampleViewModel
    private lateinit var mGenericTest: RecyclerView

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
            mGenericTest.adapter = GenericMultipleLayoutAdapter()
            mGenericTest.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)

            val thickness = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 3f, resources.displayMetrics)
            val spec = SimpleDividerItemDecorationSpec.DecorationSpecBuilder()
                    .withTopSpacing(25)
                    .withBottomSpacing(25)
                    .withStartSpacing(10)
                    .withEndSpacing(10)
                    .withDrawableDivider(ContextCompat.getDrawable(this, R.drawable.gmlrva_red_line_item_divider))
                    .withDividerPosition(GenericDecorationDividerPositionVars.POSITION_TOP_BOTTOM)
                    .withDrawnDivider(ContextCompat.getColor(this, R.color.gmlrvaColorAccent), thickness,
                            Paint.Style.STROKE, DashPathEffect(floatArrayOf(5f, 10f), 10f))
                    .withDrawnDivider(ContextCompat.getColor(this, R.color.gmlrvaColorAccent), thickness, null, null)
                    .buildDecorationSpec()
            mGenericTest.addItemDecoration(SimpleDividerItemDecoration(spec))

            GenericUtils.setOptimalConfigurationForRecyclerView(mGenericTest)
            mGenericTest.itemAnimator = ExampleItemAnimator()
            sampleViewModel = SampleViewModel(this)
            val adapter = mGenericTest.adapter as GenericMultipleLayoutAdapter?
            sampleViewModel.getArticleLiveData().observe(this,  Observer { pagedList -> adapter?.submitList(pagedList) })
        }
    }

    /** {@inheritDoc}  */
    override fun onClick() {
        if (mGenericTest != null) {
            //            rebuildGenericListExample()
            val adapter = mGenericTest.adapter as GenericMultipleLayoutAdapter?
            val item = adapter!![1]
            if (item != null) {
                //adapter.updateItem(item, ROTATION_TRIGGER)
            }
        }
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
