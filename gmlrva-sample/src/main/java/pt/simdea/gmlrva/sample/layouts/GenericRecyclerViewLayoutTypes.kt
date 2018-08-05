/*
 * Copyright (c) 2017. Simdea.
 */

package pt.simdea.gmlrva.sample.layouts

import androidx.annotation.IntDef
import pt.simdea.gmlrva.lib.IGenericRecyclerViewLayout

/**
 * Magic Constant Annotation Enum containing the possible [IGenericRecyclerViewLayout] view types.
 *
 * Created by Paulo Ribeiro on 21/10/2017.
 * Simdea © All Rights Reserved.
 * paulo.ribeiro@simdea.pt
 */
class ViewTypes {
    companion object {

        /* Constants */

        /** SINGLE_IMAGE_ITEM representing an item with a single image.  */
        const val SINGLE_IMAGE_ITEM = 0

        /** CAROUSEL_ITEM_CATEGORY representing an item for a carousel category, i.e. with a title and an item list.  */
        const val CAROUSEL_ITEM_CATEGORY = 1

        /** CAROUSEL_ITEM representing an item for a carousel's category list simple item.  */
        const val CAROUSEL_ITEM = 2

        /** CAROUSEL_ITEM_CATEGORY_WITH_OPTIONS representing an item for a carousel category,
         * i.e. with a title and an item list with options.  */
        const val CAROUSEL_ITEM_CATEGORY_WITH_OPTIONS = 3

        /** CAROUSEL_ITEM_WITH_OPTIONS representing an item for a carousel's category list item with options.  */
        const val CAROUSEL_ITEM_WITH_OPTIONS = 4

        /** SINGLE_TEXT_ITEM representing an item with a single text.  */
        const val SINGLE_TEXT_ITEM = 5
    }

    @Retention(AnnotationRetention.SOURCE)
    @IntDef(ViewTypes.SINGLE_IMAGE_ITEM, ViewTypes.CAROUSEL_ITEM_CATEGORY,
            ViewTypes.CAROUSEL_ITEM, ViewTypes.CAROUSEL_ITEM_CATEGORY_WITH_OPTIONS,
            ViewTypes.CAROUSEL_ITEM_WITH_OPTIONS, ViewTypes.SINGLE_TEXT_ITEM)
    annotation class GenericRecyclerViewLayoutTypes

}
