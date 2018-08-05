/*
 * Copyright (c) 2017. Simdea.
 */

package pt.simdea.gmlrva.lib.animation.helpers;

import androidx.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Magic Constant Annotation Enum containing the possible {@link GenericAnimationFinishedOperation} change key options.
 *
 * Created by Paulo Ribeiro on 10/7/2017.
 * Simdea © All Rights Reserved.
 * paulo.ribeiro@simdea.pt
 */
@Retention(RetentionPolicy.SOURCE)
@IntDef({
        GenericAnimationFinishedOperation.ADD_ANIMATION_FINISHED,
        GenericAnimationFinishedOperation.REMOVE_ANIMATION_FINISHED,
        GenericAnimationFinishedOperation.CHANGE_ANIMATION_FINISHED
})
public @interface GenericAnimationFinishedOperation {

    /* Constants */

    /** ADD_ANIMATION_FINISHED representing an item add animation conclusion. */
    int ADD_ANIMATION_FINISHED = 0;

    /** REMOVE_ANIMATION_FINISHED representing an item remove animation conclusion. */
    int REMOVE_ANIMATION_FINISHED = 1;

    /** CHANGE_ANIMATION_FINISHED representing an item change animation conclusion. */
    int CHANGE_ANIMATION_FINISHED = 2;

}
