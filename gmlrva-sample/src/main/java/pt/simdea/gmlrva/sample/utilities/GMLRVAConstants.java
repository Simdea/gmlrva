/*
 * Copyright (c) 2017. Simdea.
 */

package pt.simdea.gmlrva.sample.utilities;

/**
 * Utility class meant to hold all constants for the Generic Multiple Layout Recycler View Adapter (GMLRVA) library.
 *
 * Created Paulo Ribeiro on 7/16/2017.
 * Simdea © All Rights Reserved.
 * paulo.ribeiro@simdea.pt
 */

@SuppressWarnings("WeakerAccess")
public final class GMLRVAConstants {

    /** Logs */
    public static final String LOG_TAG = "GMLRVA";
    public static final String ERROR = "Error";
    public static final String EMPTY_STRING = "";

    /** Exception Messages */
    public static final String ASSERTION_ERROR = "Instantiating utility class.";
    public static final String UNSUPPORTED_ERROR = "Unsupported operation.";

    /**
     * Instantiates a new GMLRVAConstants.
     * Private to prevent instantiation.
     */
    private GMLRVAConstants() {
        throw new AssertionError(ASSERTION_ERROR); // Throw an exception if this *is* ever called
    }

}
