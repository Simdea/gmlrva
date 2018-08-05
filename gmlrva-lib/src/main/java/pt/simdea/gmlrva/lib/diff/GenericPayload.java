/*
 * Copyright (c) 2017. Simdea.
 */

package pt.simdea.gmlrva.lib.diff;

import androidx.annotation.StringDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Magic Constant Annotation Enum containing the possible {@link GenericPayload} change key options.
 *
 * Created by Paulo Ribeiro on 9/26/2017.
 * Simdea © All Rights Reserved.
 * paulo.ribeiro@simdea.pt
 */
@Retention(RetentionPolicy.SOURCE)
@StringDef({
        GenericPayload.UPDATE_ITEM
})
public @interface GenericPayload {

    /* Constants */

    /** UPDATE_ITEM representing an item that needs to be updated. */
    String UPDATE_ITEM = "UPDATE_ITEM";

}
