/*
 * Copyright (c) 2017. Simdea.
 */

package pt.simdea.gmlrva.lib.decoration.helpers;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Magic Constant Annotation Enum containing the possible {@link GenericDecorationDividerPosition} change key options.
 *
 * Created by Paulo Ribeiro on 10/14/2017.
 * Simdea © All Rights Reserved.
 * paulo.ribeiro@simdea.pt
 */
@Retention(RetentionPolicy.SOURCE)
@IntDef({
        GenericDecorationDividerPosition.POSITION_TOP,
        GenericDecorationDividerPosition.POSITION_BOTTOM,
        GenericDecorationDividerPosition.POSITION_START,
        GenericDecorationDividerPosition.POSITION_END
})
public @interface GenericDecorationDividerPosition {

    /* Constants */

    /** POSITION_TOP representing an item has its divider placed above it. */
    int POSITION_TOP = 0;

    /** POSITION_BOTTOM representing an item has its divider placed below it. */
    int POSITION_BOTTOM = 1;

    /** POSITION_START representing an item has its divider placed to it's left. */
    int POSITION_START = 2;

    /** POSITION_END representing an item has its divider placed to it's right. */
    int POSITION_END = 3;

    /** POSITION_START_END representing an item has its divider placed to it's left and to it's right. */
    int POSITION_START_END = 4;

    /** POSITION_TOP_BOTTOM representing an item has its divider placed above and below it. */
    int POSITION_TOP_BOTTOM = 5;

}
