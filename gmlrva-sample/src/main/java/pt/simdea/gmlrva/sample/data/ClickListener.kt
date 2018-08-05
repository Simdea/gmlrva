/*
 * Copyright (c) 2017. Simdea.
 */

package pt.simdea.gmlrva.sample.data

import pt.simdea.gmlrva.lib.IGenericRecyclerViewLayout

/**
 * [IGenericRecyclerViewLayout] view listener meant to deal with click call to actions.
 *
 * Created by Paulo Ribeiro on 9/26/2017.
 * Simdea © All Rights Reserved.
 * paulo.ribeiro@simdea.pt
 */
interface ClickListener {

    /** Procedure meant to handle click call to actions applied to the target [IGenericRecyclerViewLayout].  */
    fun onClick()

}
