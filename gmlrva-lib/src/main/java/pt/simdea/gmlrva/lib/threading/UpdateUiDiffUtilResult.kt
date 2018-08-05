/*
 * Copyright (c) 2017. Simdea.
 */

package pt.simdea.gmlrva.lib.threading

import androidx.annotation.UiThread
import androidx.recyclerview.widget.DiffUtil
import pt.simdea.gmlrva.lib.GenericMultipleLayoutAdapter
import pt.simdea.gmlrva.lib.IGenericRecyclerViewLayout

/**
 * Class meant to act as the [DiffUtil] calculations result dispatcher to the UIThread.
 *
 * Created by Paulo Ribeiro on 10/5/2017.
 * Simdea © All Rights Reserved.
 * paulo.ribeiro@simdea.pt
 */
internal class UpdateUiDiffUtilResult(private val mNewDataSet: List<IGenericRecyclerViewLayout<*>>?,
                                      private val mDiffResult: DiffUtil.DiffResult?,
                                      private val mAdapter: GenericMultipleLayoutAdapter?)
    : Runnable {
    /** {@inheritDoc}  */
    @UiThread
    override fun run() {
        mAdapter!!.applyDiffResult(mNewDataSet!!, mDiffResult!!)
    }

}
