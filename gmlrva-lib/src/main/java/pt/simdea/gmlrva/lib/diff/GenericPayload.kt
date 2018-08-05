/*
 * Copyright (c) 2017. Simdea.
 */

package pt.simdea.gmlrva.lib.diff

import androidx.annotation.StringDef
import pt.simdea.gmlrva.lib.diff.Const.Companion.UPDATE_ITEM

/**
 * Magic Constant Annotation Enum containing the possible [GenericPayload] change key options.
 *
 * Created by Paulo Ribeiro on 9/26/2017.
 * Simdea © All Rights Reserved.
 * paulo.ribeiro@simdea.pt
 */
@Retention(AnnotationRetention.SOURCE)
@StringDef(UPDATE_ITEM)
annotation class GenericPayload

class Const {
    companion object {
        /* Constants */

        /** UPDATE_ITEM representing an item that needs to be updated.  */
        const val UPDATE_ITEM = "UPDATE_ITEM"
    }
}

