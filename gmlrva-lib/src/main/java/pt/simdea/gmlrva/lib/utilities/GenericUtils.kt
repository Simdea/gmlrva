/*
 * Copyright (c) 2017. Simdea.
 */

package pt.simdea.gmlrva.lib.utilities

import androidx.recyclerview.widget.RecyclerView

/**
 * Auxiliary Utils class.
 *
 * Created by Paulo Ribeiro on 7/6/2017.
 * Simdea © All Rights Reserved.
 * paulo.ribeiro@simdea.pt
 */
class GenericUtils
/**
 * Instantiates a new GenericUtils.
 * Private to prevent instantiation.
 * @throws AssertionError if this constructor is ever called. Utility classes should not be instantiated.
 */
private constructor() {

    init {
        throw AssertionError(GMLRVAConstantsVars.ASSERTION_ERROR) // Throw an exception if this *is* ever called
    }

    companion object {

        /**
         * Procedure meant to apply the optimal configuration on a target [RecyclerView] instance.
         * @param recyclerView a target [RecyclerView] instance.
         */
        fun setOptimalConfigurationForRecyclerView(recyclerView: RecyclerView) {
            recyclerView.setItemViewCacheSize(30)
            recyclerView.setHasFixedSize(true)
            recyclerView.isNestedScrollingEnabled = true
        }
    }

}
