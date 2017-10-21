package pt.simdea.gmlrva.lib.animation.helpers;

import android.support.annotation.IntRange;
import android.support.v7.widget.RecyclerView;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * TODO...
 * Created by Paulo on 21/10/2017.
 */
@AllArgsConstructor
public class GenericAnimatedViewHolderInfo extends RecyclerView.ItemAnimator.ItemHolderInfo {
    @Getter
    @IntRange (from = 0)
    private int mUpdateAction;
}
