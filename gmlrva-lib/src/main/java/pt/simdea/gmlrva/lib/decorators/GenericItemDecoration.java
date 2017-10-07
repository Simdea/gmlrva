package pt.simdea.gmlrva.lib.decorators;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;

/**
 * TODO...
 *
 * Created by Paulo Ribeiro on 10/7/2017.
 * Simdea © All Rights Reserved.
 * paulo.ribeiro@simdea.pt
 */
public class GenericItemDecoration extends RecyclerView.ItemDecoration {

    private int mTopSpacing = 0;
    private int mBottomSpacing = 0;
    private int mStartSpacing = 0;
    private int mEndSpacing = 0;

    @Nullable private Drawable mDivider;

    public GenericItemDecoration(@NonNull final Bundle configurationSpec) {
        applySpec(configurationSpec);
    }

    private void applySpec(@NonNull final Bundle configurationSpec) {
        // TODO
    }

}
