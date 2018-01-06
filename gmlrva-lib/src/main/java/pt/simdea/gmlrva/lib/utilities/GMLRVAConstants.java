/*
 * Copyright (c) 2017. Simdea.
 */

package pt.simdea.gmlrva.lib.utilities;

/**
 * Utility class meant to hold all constants for the Generic Multiple Layout Recycler View Adapter (GMLRVA) library.
 *
 * Created Paulo Ribeiro on 7/16/2017.
 * Simdea © All Rights Reserved.
 * paulo.ribeiro@simdea.pt
 */
@SuppressWarnings("WeakerAccess")
public final class GMLRVAConstants {

    /** Exception Messages */
    public static final String ASSERTION_ERROR = "Instantiating utility class.";
    public static final String UNSUPPORTED_ERROR = "Unsupported operation.";

    /**
     * Instantiates a new GMLRVAConstants.
     * Private to prevent instantiation.
     * @throws AssertionError if this constructor is ever called. Utility classes should not be instantiated.
     */
    private GMLRVAConstants() {
        throw new AssertionError(ASSERTION_ERROR); // Throw an exception if this *is* ever called
    }

}
