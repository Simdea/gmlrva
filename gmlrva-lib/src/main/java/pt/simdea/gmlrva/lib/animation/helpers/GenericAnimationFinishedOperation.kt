/*
 * Copyright (c) 2017. Simdea.
 */

package pt.simdea.gmlrva.lib.animation.helpers

import androidx.annotation.IntDef
import pt.simdea.gmlrva.lib.animation.helpers.GenericAnimationFinishedOperationVars.Companion.ADD_ANIMATION_FINISHED
import pt.simdea.gmlrva.lib.animation.helpers.GenericAnimationFinishedOperationVars.Companion.CHANGE_ANIMATION_FINISHED
import pt.simdea.gmlrva.lib.animation.helpers.GenericAnimationFinishedOperationVars.Companion.REMOVE_ANIMATION_FINISHED

import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy

/**
 * Magic Constant Annotation Enum containing the possible [GenericAnimationFinishedOperation] change key options.
 *
 * Created by Paulo Ribeiro on 10/7/2017.
 * Simdea © All Rights Reserved.
 * paulo.ribeiro@simdea.pt
 */
@Retention(RetentionPolicy.SOURCE)
@IntDef(ADD_ANIMATION_FINISHED, REMOVE_ANIMATION_FINISHED, CHANGE_ANIMATION_FINISHED)
annotation class GenericAnimationFinishedOperation

class GenericAnimationFinishedOperationVars {
    companion object {
        /* Constants */

        /** ADD_ANIMATION_FINISHED representing an item add animation conclusion.  */
        const val ADD_ANIMATION_FINISHED = 0

        /** REMOVE_ANIMATION_FINISHED representing an item remove animation conclusion.  */
        const val REMOVE_ANIMATION_FINISHED = 1

        /** CHANGE_ANIMATION_FINISHED representing an item change animation conclusion.  */
        const val CHANGE_ANIMATION_FINISHED = 2
    }
}