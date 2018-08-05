/*
 * Copyright (c) 2017. Simdea.
 */

package pt.simdea.gmlrva.lib.utilities

import androidx.annotation.StringDef
import pt.simdea.gmlrva.lib.utilities.Const.Companion.ASSERTION_ERROR
import pt.simdea.gmlrva.lib.utilities.Const.Companion.UNSUPPORTED_ERROR


/**
 * Utility class meant to hold all constants for the Generic Multiple Layout Recycler View Adapter (GMLRVA) library.
 *
 * Created Paulo Ribeiro on 7/16/2017.
 * Simdea © All Rights Reserved.
 * paulo.ribeiro@simdea.pt
 */
@Retention(AnnotationRetention.SOURCE)
@StringDef(ASSERTION_ERROR, UNSUPPORTED_ERROR)
annotation class GMLRVAConstants

class Const {
    companion object {

        /** Exception Messages  */
        const val ASSERTION_ERROR = "Instantiating utility class."
        const val UNSUPPORTED_ERROR = "Unsupported operation."
    }
}
