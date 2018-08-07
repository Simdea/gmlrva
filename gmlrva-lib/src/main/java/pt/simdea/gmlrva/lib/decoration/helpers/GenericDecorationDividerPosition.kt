/*
 * Copyright (c) 2017. Simdea.
 */

package pt.simdea.gmlrva.lib.decoration.helpers

import androidx.annotation.IntDef
import pt.simdea.gmlrva.lib.decoration.helpers.GenericDecorationDividerPositionVars.Companion.POSITION_BOTTOM
import pt.simdea.gmlrva.lib.decoration.helpers.GenericDecorationDividerPositionVars.Companion.POSITION_END
import pt.simdea.gmlrva.lib.decoration.helpers.GenericDecorationDividerPositionVars.Companion.POSITION_START
import pt.simdea.gmlrva.lib.decoration.helpers.GenericDecorationDividerPositionVars.Companion.POSITION_START_END
import pt.simdea.gmlrva.lib.decoration.helpers.GenericDecorationDividerPositionVars.Companion.POSITION_TOP
import pt.simdea.gmlrva.lib.decoration.helpers.GenericDecorationDividerPositionVars.Companion.POSITION_TOP_BOTTOM
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
@IntDef(POSITION_TOP, POSITION_BOTTOM, POSITION_START, POSITION_END, POSITION_START_END, POSITION_TOP_BOTTOM)
annotation class GenericDecorationDividerPosition

class GenericDecorationDividerPositionVars {
    companion object {
        /* Constants */

        /** POSITION_TOP representing an item has its divider placed above it.  */
        const val POSITION_TOP = 0

        /** POSITION_BOTTOM representing an item has its divider placed below it.  */
        const val POSITION_BOTTOM = 1

        /** POSITION_START representing an item has its divider placed to it's left.  */
        const val POSITION_START = 2

        /** POSITION_END representing an item has its divider placed to it's right.  */
        const val POSITION_END = 3

        /** POSITION_START_END representing an item has its divider placed to it's left and to it's right.  */
        const val POSITION_START_END = 4

        /** POSITION_TOP_BOTTOM representing an item has its divider placed above and below it.  */
        const val POSITION_TOP_BOTTOM = 5
    }
}
