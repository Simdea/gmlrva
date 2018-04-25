/*
 * Copyright (c) 2017. Simdea.
 */

package pt.simdea.gmlrva.lib.utilities;

import android.support.annotation.StringDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Utility class meant to hold all constants for the Generic Multiple Layout Recycler View Adapter (GMLRVA) library.
 *
 * Created Paulo Ribeiro on 7/16/2017.
 * Simdea © All Rights Reserved.
 * paulo.ribeiro@simdea.pt
 */
@Retention(RetentionPolicy.SOURCE)
@StringDef({
        GMLRVAConstants.ASSERTION_ERROR,
        GMLRVAConstants.UNSUPPORTED_ERROR
})
public @interface GMLRVAConstants {

    /** Exception Messages */
    String ASSERTION_ERROR = "Instantiating utility class.";
    String UNSUPPORTED_ERROR = "Unsupported operation.";

}
