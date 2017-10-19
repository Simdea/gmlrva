/*
 * Copyright (c) 2017. Simdea.
 */

package pt.simdea.gmlrva.lib.decoration.helpers;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import lombok.AllArgsConstructor;

/**
 * Magic Constant Annotation Enum containing the possible {@link GenericDecorationDividerPosition} change key options.
 *
 * Created by Paulo Ribeiro on 10/14/2017.
 * Simdea © All Rights Reserved.
 * paulo.ribeiro@simdea.pt
 */
@SuppressWarnings({"WeakerAccess", "unused"})
@AllArgsConstructor
public class GenericDecorationDividerPosition {

    /* Constants */

    /** POSITION_TOP representing an item has its divider placed above it. */
    public static final int POSITION_TOP = 0;

    /** POSITION_BOTTOM representing an item has its divider placed below it. */
    public static final int POSITION_BOTTOM = 1;

    /** POSITION_START representing an item has its divider placed to it's left. */
    public static final int POSITION_START = 2;

    /** POSITION_END representing an item has its divider placed to it's right. */
    public static final int POSITION_END = 3;

    /** POSITION_START_END representing an item has its divider placed to it's left and to it's right. */
    public static final int POSITION_START_END = 4;

    /** POSITION_TOP_BOTTOM representing an item has its divider placed above and below it. */
    public static final int POSITION_TOP_BOTTOM = 5;

    // Declare the @StringDef for these constants
    @IntDef({ POSITION_TOP, POSITION_BOTTOM, POSITION_START, POSITION_END })
    @Retention(RetentionPolicy.SOURCE)
    public @interface GenericDecorationDividerPositionConstants { /* Do nothing here ... */ }

}
