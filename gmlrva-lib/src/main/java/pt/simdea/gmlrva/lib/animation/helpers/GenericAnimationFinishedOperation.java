/*
 * Copyright (c) 2017. Simdea.
 */

package pt.simdea.gmlrva.lib.animation.helpers;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import lombok.AllArgsConstructor;

/**
 * Magic Constant Annotation Enum containing the possible {@link GenericAnimationFinishedOperation} change key options.
 *
 * Created by Paulo Ribeiro on 10/7/2017.
 * Simdea © All Rights Reserved.
 * paulo.ribeiro@simdea.pt
 */
@SuppressWarnings({"WeakerAccess", "unused"})
@AllArgsConstructor
public class GenericAnimationFinishedOperation {

    /* Constants */

    /** ADD_ANIMATION_FINISHED representing an item add animation conclusion. */
    public static final int ADD_ANIMATION_FINISHED = 0;

    /** REMOVE_ANIMATION_FINISHED representing an item remove animation conclusion. */
    public static final int REMOVE_ANIMATION_FINISHED = 1;

    // Declare the @StringDef for these constants
    @IntDef({ ADD_ANIMATION_FINISHED, REMOVE_ANIMATION_FINISHED })
    @Retention(RetentionPolicy.SOURCE)
    public @interface GenericAnimationFinishedOperationConstants { /* Do nothing here ... */ }

}
