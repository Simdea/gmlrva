/*
 * Copyright (c) 2017. Simdea.
 */

package pt.simdea.gmlrva.lib.animation;

import android.animation.AnimatorSet;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.util.ArrayMap;

import pt.simdea.gmlrva.lib.animation.helpers.GenericAnimationFinishedOperation;
import pt.simdea.gmlrva.lib.animation.helpers.IAnimationFinished;
import pt.simdea.gmlrva.lib.utilities.GMLRVAConstants;

import static pt.simdea.gmlrva.lib.animation.helpers.GenericAnimationFinishedOperation.ADD_ANIMATION_FINISHED;
import static pt.simdea.gmlrva.lib.animation.helpers.GenericAnimationFinishedOperation.REMOVE_ANIMATION_FINISHED;

/**
 * This class is meant to serve as a base {@link RecyclerView.ItemAnimator},
 * responsible for coordinating default animations performed by {@link RecyclerView}.
 *
 * Created by Paulo Ribeiro on 10/7/2017.
 * Simdea © All Rights Reserved.
 * paulo.ribeiro@simdea.pt
 */
public class GenericItemAnimator extends DefaultItemAnimator implements IAnimationFinished {

    private final ArrayMap<RecyclerView.ViewHolder, AnimatorSet> customAnimationsMap = new ArrayMap<>();

    /**
     * {@inheritDoc}
     *
     * When animating {@link RecyclerView} items, we can ask the {@link RecyclerView} to keep the previous
     * {@link RecyclerView.ViewHolder} of the item as-is and provide a new {@link RecyclerView.ViewHolder} which will
     * animate changes from the previous one (only the new {@link RecyclerView.ViewHolder} will be visible
     * on the {@link RecyclerView}).
     *
     * But when writing custom item animators the same {@link RecyclerView.ViewHolder} should be used and the
     * animations should be handled manually. For these cases this procedure returns true.
     *
     * @param holder the {@link RecyclerView} item's {@link RecyclerView.ViewHolder}.
     * @return boolean value indicating whether the {@link RecyclerView} should reuse
     *         the {@link RecyclerView.ViewHolder} or a new one.
     */
    @Override
    public boolean canReuseUpdatedViewHolder(@NonNull final RecyclerView.ViewHolder holder) {
        return true;
    }

    /**
     * {@inheritDoc}
     *
     * Item's whose {@link RecyclerView.ViewHolder}s implement the {@link IAnimatedViewHolder} interface will have
     * their {@link IAnimatedViewHolder#runAddAnimation(GenericItemAnimator)} procedure called.
     *
     * @param holder the {@link RecyclerView} item's {@link RecyclerView.ViewHolder}.
     * @return a boolean value indicating whether the {@link RecyclerView} should use an entry animation
     *         for the {@link RecyclerView.ViewHolder}.
     */
    @Override
    public boolean animateAdd(@NonNull final RecyclerView.ViewHolder holder) {
        if (holder instanceof IAnimatedViewHolder) {
            ((IAnimatedViewHolder) holder).runAddAnimation(this);
            return false;
        }
        dispatchAddFinished(holder);
        return false;
    }

    /**
     * {@inheritDoc}
     *
     * Item's whose {@link RecyclerView.ViewHolder}s implement the {@link IAnimatedViewHolder} interface will have
     * their {@link IAnimatedViewHolder#runRemoveAnimation(GenericItemAnimator)} procedure called.
     *
     * @param holder the {@link RecyclerView} item's {@link RecyclerView.ViewHolder}.
     * @return a boolean value indicating whether the {@link RecyclerView} should use an exit animation
     *         for the {@link RecyclerView.ViewHolder}.
     */
    @Override
    public boolean animateRemove(@NonNull final RecyclerView.ViewHolder holder) {
        if (holder instanceof IAnimatedViewHolder) {
            ((IAnimatedViewHolder) holder).runRemoveAnimation(this);
            return false;
        }
        dispatchRemoveFinished(holder);
        return false;
    }

    /**
     * Procedure meant to handle the report when the animation for the {@link RecyclerView.ViewHolder} has finished.
     * @param holder the {@link RecyclerView} item's {@link RecyclerView.ViewHolder}.
     * @param animationFinishedOperation an Integer value representing the animation operation that has finished.
     *                                   See {@link GenericAnimationFinishedOperation} for more details.
     */
    @Override
    public void onAnimationFinished(@NonNull final RecyclerView.ViewHolder holder,
                                    @IntRange(from = 0) final int animationFinishedOperation) {
        switch (animationFinishedOperation) {
            case ADD_ANIMATION_FINISHED:
                dispatchAddFinished(holder);
                break;
            case REMOVE_ANIMATION_FINISHED:
                dispatchRemoveFinished(holder);
                break;
            default:
                throw new UnsupportedOperationException(GMLRVAConstants.UNSUPPORTED_ERROR);
        }
    }

    /** {@inheritDoc} */
    @Override
    public void endAnimation(@NonNull final RecyclerView.ViewHolder item) {
        super.endAnimation(item);
        cancelCurrentAnimationIfExists(item);
    }

    /** {@inheritDoc} */
    @Override
    public void endAnimations() {
        super.endAnimations();
        for (final AnimatorSet animatorSet : customAnimationsMap.values()) {
            animatorSet.cancel();
        }
    }

    /**
     * Auxiliary procedure meant to allow {@link RecyclerView} to stop animations on its items, when they
     * disappear from the device's screen, thus being ready to be recycled.
     * @param item the {@link RecyclerView} item's {@link RecyclerView.ViewHolder}.
     */
    private void cancelCurrentAnimationIfExists(@NonNull final RecyclerView.ViewHolder item) {
        if (customAnimationsMap.containsKey(item)) {
            customAnimationsMap.get(item).cancel();
        }
    }

}
