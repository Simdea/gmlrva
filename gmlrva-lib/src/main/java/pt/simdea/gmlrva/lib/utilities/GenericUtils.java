/*
 * Copyright (c) 2017. Simdea.
 */

package pt.simdea.gmlrva.lib.utilities;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;

/**
 * Auxiliary Utils class.
 *
 * Created by Paulo Ribeiro on 7/6/2017.
 * Simdea © All Rights Reserved.
 * paulo.ribeiro@simdea.pt
 */
public final class GenericUtils {

    /**
     * Instantiates a new GenericUtils.
     * Private to prevent instantiation.
     * @throws AssertionError if this constructor is ever called. Utility classes should not be instantiated.
     */
    private GenericUtils() {
        throw new AssertionError(GMLRVAConstants.ASSERTION_ERROR); // Throw an exception if this *is* ever called
    }

    /**
     * Procedure meant to apply the optimal configuration on a target {@link RecyclerView} instance.
     * @param recyclerView a target {@link RecyclerView} instance.
     */
    public static void setOptimalConfigurationForRecyclerView(@NonNull final RecyclerView recyclerView) {
        recyclerView.setItemViewCacheSize(30);
        recyclerView.setDrawingCacheEnabled(true);
        recyclerView.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);
        recyclerView.setHasFixedSize(true);
        recyclerView.setNestedScrollingEnabled(true);
    }

}
