/*
 * Copyright (c) 2017. Simdea.
 */

package pt.simdea.gmlrva.sample.layouts;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import lombok.AllArgsConstructor;
import pt.simdea.gmlrva.lib.IGenericRecyclerViewLayout;

/**
 * Magic Constant Annotation Enum containing the possible {@link IGenericRecyclerViewLayout} view types.
 *
 * Created by Paulo Ribeiro on 21/10/2017.
 * Simdea © All Rights Reserved.
 * paulo.ribeiro@simdea.pt
 */
@SuppressWarnings({"WeakerAccess", "unused"})
@AllArgsConstructor
public class GenericRecyclerViewLayoutTypes {

    /* Constants */

    /** SINGLE_IMAGE_ITEM representing an item with a single image. */
    public static final int SINGLE_IMAGE_ITEM = 0;

    /** CAROUSEL_ITEM_CATEGORY representing an item for a carousel category, i.e. with a title and an item list. */
    public static final int CAROUSEL_ITEM_CATEGORY = 1;

    /** CAROUSEL_ITEM representing an item for a carousel's category list simple item. */
    public static final int CAROUSEL_ITEM = 2;

    /** CAROUSEL_ITEM_CATEGORY_WITH_OPTIONS representing an item for a carousel category,
     * i.e. with a title and an item list with options. */
    public static final int CAROUSEL_ITEM_CATEGORY_WITH_OPTIONS = 3;

    /** CAROUSEL_ITEM_WITH_OPTIONS representing an item for a carousel's category list item with options. */
    public static final int CAROUSEL_ITEM_WITH_OPTIONS = 4;

    /** SINGLE_TEXT_ITEM representing an item with a single text. */
    public static final int SINGLE_TEXT_ITEM = 5;

    // Declare the @StringDef for these constants
    @IntDef({ SINGLE_IMAGE_ITEM, CAROUSEL_ITEM_CATEGORY, CAROUSEL_ITEM, CAROUSEL_ITEM_CATEGORY_WITH_OPTIONS,
            CAROUSEL_ITEM_WITH_OPTIONS, SINGLE_TEXT_ITEM })
    @Retention(RetentionPolicy.SOURCE)
    public @interface GenericRecyclerViewLayoutTypesConstants { /* Do nothing here ... */ }

}
