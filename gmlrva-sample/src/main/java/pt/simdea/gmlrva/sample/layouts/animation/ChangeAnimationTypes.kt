/*
 * Copyright (c) 2017. Simdea.
 */

package pt.simdea.gmlrva.sample.layouts.animation

import androidx.annotation.IntDef
import pt.simdea.gmlrva.sample.layouts.animation.ChangeAnimationTypesVars.Companion.ROTATION_TRIGGER

/**
 * Magic Constant Annotation Enum containing the possible [ChangeAnimationTypes] key options.
 *
 * Created by Paulo Ribeiro on 21/10/2017.
 * Simdea © All Rights Reserved.
 * paulo.ribeiro@simdea.pt
 */
@Retention(AnnotationRetention.SOURCE)
@IntDef(ROTATION_TRIGGER)
annotation class ChangeAnimationTypes

class ChangeAnimationTypesVars {
    companion object {
        /* Constants */

        /** ROTATION_TRIGGER representing a rotation custom animation.  */
        const val ROTATION_TRIGGER = 0
    }
}