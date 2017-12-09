/*
 * Copyright (c) 2017. Simdea.
 */

package pt.simdea.gmlrva.sample.layouts.animation;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import lombok.AllArgsConstructor;

/**
 * Magic Constant Annotation Enum containing the possible {@link ChangeAnimationTypes} key options.
 *
 * Created by Paulo Ribeiro on 21/10/2017.
 * Simdea © All Rights Reserved.
 * paulo.ribeiro@simdea.pt
 */
@SuppressWarnings({"WeakerAccess", "unused"})
@AllArgsConstructor
public class ChangeAnimationTypes {

    /* Constants */

    /** ROTATION_TRIGGER representing a rotation custom animation. */
    public static final int ROTATION_TRIGGER = 0;

    // Declare the @StringDef for these constants
    @IntDef({ROTATION_TRIGGER})
    @Retention(RetentionPolicy.SOURCE)
    public @interface ChangeAnimationTypesConstants { /* Do nothing here ... */ }

}
