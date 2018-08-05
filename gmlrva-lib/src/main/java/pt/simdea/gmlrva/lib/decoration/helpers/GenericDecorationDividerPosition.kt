/*
 * Copyright (c) 2017. Simdea.
 */

package pt.simdea.gmlrva.lib.decoration.helpers

import androidx.annotation.IntDef

import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy

/**
 * Magic Constant Annotation Enum containing the possible [GenericDecorationDividerPosition] change key options.
 *
 * Created by Paulo Ribeiro on 10/14/2017.
 * Simdea © All Rights Reserved.
 * paulo.ribeiro@simdea.pt
 */
@Retention(RetentionPolicy.SOURCE)
@IntDef(GenericDecorationDividerPosition.POSITION_TOP, GenericDecorationDividerPosition.POSITION_BOTTOM, GenericDecorationDividerPosition.POSITION_START, GenericDecorationDividerPosition.POSITION_END)
annotation class GenericDecorationDividerPosition {
    companion object {

        /* Constants */

        /** POSITION_TOP representing an item has its divider placed above it.  */
        val POSITION_TOP = 0

        /** POSITION_BOTTOM representing an item has its divider placed below it.  */
        val POSITION_BOTTOM = 1

        /** POSITION_START representing an item has its divider placed to it's left.  */
        val POSITION_START = 2

        /** POSITION_END representing an item has its divider placed to it's right.  */
        val POSITION_END = 3

        /** POSITION_START_END representing an item has its divider placed to it's left and to it's right.  */
        val POSITION_START_END = 4

        /** POSITION_TOP_BOTTOM representing an item has its divider placed above and below it.  */
        val POSITION_TOP_BOTTOM = 5
    }

}
