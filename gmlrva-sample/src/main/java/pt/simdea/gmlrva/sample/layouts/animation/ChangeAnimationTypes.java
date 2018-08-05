/*
 * Copyright (c) 2017. Simdea.
 */

package pt.simdea.gmlrva.sample.layouts.animation;

import androidx.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Magic Constant Annotation Enum containing the possible {@link ChangeAnimationTypes} key options.
 *
 * Created by Paulo Ribeiro on 21/10/2017.
 * Simdea © All Rights Reserved.
 * paulo.ribeiro@simdea.pt
 */
@Retention(RetentionPolicy.SOURCE)
@IntDef({
        ChangeAnimationTypes.ROTATION_TRIGGER
})
public @interface ChangeAnimationTypes {

    /* Constants */

    /** ROTATION_TRIGGER representing a rotation custom animation. */
    int ROTATION_TRIGGER = 0;

}
