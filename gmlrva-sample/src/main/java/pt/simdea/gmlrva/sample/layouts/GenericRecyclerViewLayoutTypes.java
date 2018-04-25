/*
 * Copyright (c) 2017. Simdea.
 */

package pt.simdea.gmlrva.sample.layouts;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import pt.simdea.gmlrva.lib.IGenericRecyclerViewLayout;

/**
 * Magic Constant Annotation Enum containing the possible {@link IGenericRecyclerViewLayout} view types.
 *
 * Created by Paulo Ribeiro on 21/10/2017.
 * Simdea © All Rights Reserved.
 * paulo.ribeiro@simdea.pt
 */
@Retention(RetentionPolicy.SOURCE)
@IntDef({
        GenericRecyclerViewLayoutTypes.SINGLE_IMAGE_ITEM,
        GenericRecyclerViewLayoutTypes.CAROUSEL_ITEM_CATEGORY,
        GenericRecyclerViewLayoutTypes.CAROUSEL_ITEM,
        GenericRecyclerViewLayoutTypes.CAROUSEL_ITEM_CATEGORY_WITH_OPTIONS,
        GenericRecyclerViewLayoutTypes.CAROUSEL_ITEM_WITH_OPTIONS,
        GenericRecyclerViewLayoutTypes.SINGLE_TEXT_ITEM
})
public @interface GenericRecyclerViewLayoutTypes {

    /* Constants */

    /** SINGLE_IMAGE_ITEM representing an item with a single image. */
    int SINGLE_IMAGE_ITEM = 0;

    /** CAROUSEL_ITEM_CATEGORY representing an item for a carousel category, i.e. with a title and an item list. */
    int CAROUSEL_ITEM_CATEGORY = 1;

    /** CAROUSEL_ITEM representing an item for a carousel's category list simple item. */
    int CAROUSEL_ITEM = 2;

    /** CAROUSEL_ITEM_CATEGORY_WITH_OPTIONS representing an item for a carousel category,
     * i.e. with a title and an item list with options. */
    int CAROUSEL_ITEM_CATEGORY_WITH_OPTIONS = 3;

    /** CAROUSEL_ITEM_WITH_OPTIONS representing an item for a carousel's category list item with options. */
    int CAROUSEL_ITEM_WITH_OPTIONS = 4;

    /** SINGLE_TEXT_ITEM representing an item with a single text. */
    int SINGLE_TEXT_ITEM = 5;

}
