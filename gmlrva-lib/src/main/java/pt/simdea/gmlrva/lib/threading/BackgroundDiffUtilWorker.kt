/*
 * Copyright (c) 2017. Simdea.
 */

package pt.simdea.gmlrva.lib.threading

import android.app.Activity
import android.content.Context
import androidx.annotation.WorkerThread
import androidx.recyclerview.widget.DiffUtil

import lombok.AllArgsConstructor
import pt.simdea.gmlrva.lib.GenericMultipleLayoutAdapter
import pt.simdea.gmlrva.lib.IGenericRecyclerViewLayout
import pt.simdea.gmlrva.lib.diff.GmlrvaDiffCallback

/**
 * Class meant to act as a Worker thread for [DiffUtil] calculations.
 *
 * Created by Paulo Ribeiro on 10/5/2017.
 * Simdea © All Rights Reserved.
 * paulo.ribeiro@simdea.pt
 */
@AllArgsConstructor
class BackgroundDiffUtilWorker : Runnable {

    private val mOldDataSet: List<IGenericRecyclerViewLayout<*>>? = null
    private val mNewDataSet: List<IGenericRecyclerViewLayout<*>>? = null
    private val mContext: Context? = null
    private val mAdapter: GenericMultipleLayoutAdapter? = null

    /** {@inheritDoc}  */
    @WorkerThread
    override fun run() {
        val diffResult = DiffUtil.calculateDiff(GmlrvaDiffCallback(this.mOldDataSet!!, this.mNewDataSet!!))
        if (mContext != null) {
            (mContext as Activity).runOnUiThread(UpdateUiDiffUtilResult(this.mNewDataSet, diffResult, mAdapter))
        }
    }

}
