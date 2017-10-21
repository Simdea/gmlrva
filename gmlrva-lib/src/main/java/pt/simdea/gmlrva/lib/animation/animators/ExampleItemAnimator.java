package pt.simdea.gmlrva.lib.animation.animators;

import android.animation.AnimatorSet;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import pt.simdea.gmlrva.lib.animation.helpers.GenericAnimatedViewHolderInfo;
import pt.simdea.gmlrva.lib.animation.GenericItemAnimator;
import pt.simdea.gmlrva.lib.animation.helpers.IAnimatedViewHolder;

import static pt.simdea.gmlrva.lib.utilities.GMLRVAConstants.UNSUPPORTED_ERROR;

/**
 * TODO...
 * Created by Paulo on 21/10/2017.
 */
public final class ExampleItemAnimator extends GenericItemAnimator {

    // TODO
    @Nullable
    @Override
    public AnimatorSet handleCustomAnimation(@NonNull final GenericAnimatedViewHolderInfo holderInfo,
                                             @NonNull final IAnimatedViewHolder holder) {
        switch (holderInfo.getUpdateAction()) {
            case 0:
                return holder.runChangeAnimation(this);
            default:
                throw new UnsupportedOperationException(UNSUPPORTED_ERROR);
        }
    }

}
