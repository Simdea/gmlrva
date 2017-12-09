/*
 * Copyright (c) 2017. Simdea.
 */

package pt.simdea.gmlrva.lib.animation;

import android.animation.AnimatorSet;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.util.ArrayMap;

import java.util.List;

import pt.simdea.gmlrva.lib.IGenericRecyclerViewLayout;
import pt.simdea.gmlrva.lib.animation.helpers.GenericAnimatedViewHolderInfo;
import pt.simdea.gmlrva.lib.animation.helpers.GenericAnimationFinishedOperation;
import pt.simdea.gmlrva.lib.animation.helpers.IAnimatedViewHolder;
import pt.simdea.gmlrva.lib.animation.helpers.IAnimationFinished;
import pt.simdea.gmlrva.lib.utilities.GMLRVAConstants;

import static pt.simdea.gmlrva.lib.animation.helpers.GenericAnimationFinishedOperation.ADD_ANIMATION_FINISHED;
import static pt.simdea.gmlrva.lib.animation.helpers.GenericAnimationFinishedOperation.CHANGE_ANIMATION_FINISHED;
import static pt.simdea.gmlrva.lib.animation.helpers.GenericAnimationFinishedOperation.REMOVE_ANIMATION_FINISHED;

/**
 * This class is meant to serve as a base {@link RecyclerView.ItemAnimator},
 * responsible for coordinating default animations performed by {@link RecyclerView}.
 *
 * Created by Paulo Ribeiro on 10/7/2017.
 * Simdea © All Rights Reserved.
 * paulo.ribeiro@simdea.pt
 */
public abstract class GenericItemAnimator extends DefaultItemAnimator implements IAnimationFinished {

    /* View Holder Animations Map */
    private final ArrayMap<RecyclerView.ViewHolder, AnimatorSet> mCustomAnimationsMap = new ArrayMap<>();

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
     * {@inheritDoc}
     *
     * Custom animations should be triggered on the {@link IGenericRecyclerViewLayout} implementation.
     * Since changes are usually triggered by the {@link RecyclerView.Adapter#notifyItemChanged(int, Object)} procedure,
     * we can pass additional arguments to it which will help the {@link IGenericRecyclerViewLayout} decide what
     * animation should be performed.
     * This procedure is used to catch the data before changes occur. The {@link RecyclerView} then calls
     * {@link RecyclerView.Adapter#onBindViewHolder(RecyclerView.ViewHolder, int, List)} and finally,
     * {@link RecyclerView.ItemAnimator} will call {@link RecyclerView.ItemAnimator
     * #recordPostLayoutInformation(RecyclerView.State, RecyclerView.ViewHolder)}.
     *
     * @param state the current {@link RecyclerView.State}.
     * @param holder the {@link RecyclerView} item's {@link RecyclerView.ViewHolder}.
     * @param changeFlags additional information about what changes happened in the Adapter
     *                    about the Item represented by this ViewHolder. For instance, if
     *                    item is deleted from the adapter, {@link #FLAG_REMOVED} will be set.
     * @param payloads The payload list that was previously passed to
     *                 {@link RecyclerView.Adapter#notifyItemChanged(int, Object)} or
     *                 {@link RecyclerView.Adapter#notifyItemRangeChanged(int, int, Object)}.
     * @return an ItemHolderInfo instance that preserves necessary information about the ViewHolder.
     */
    @NonNull
    @Override
    public ItemHolderInfo recordPreLayoutInformation(@NonNull final RecyclerView.State state,
                                                     @NonNull final RecyclerView.ViewHolder holder,
                                                     @IntRange(from = 0) final int changeFlags,
                                                     @NonNull final List<Object> payloads) {
        if (changeFlags == FLAG_CHANGED) {
            for (final Object payload : payloads) {
                if (payload instanceof Integer) {
                    return new GenericAnimatedViewHolderInfo((Integer) payload);
                }
            }
        }
        return super.recordPreLayoutInformation(state, holder, changeFlags, payloads);
    }

    /**
     * {@inheritDoc}
     *
     * Item's whose {@link RecyclerView.ViewHolder}s implement the {@link IAnimatedViewHolder} interface will have
     * their {@link IAnimatedViewHolder#runChangeAnimation(GenericItemAnimator)} procedure called.
     *
     * @param oldHolder the old {@link RecyclerView} item's {@link RecyclerView.ViewHolder}. Might be the same
     *                  instance with newHolder.
     * @param newHolder the new {@link RecyclerView} item's {@link RecyclerView.ViewHolder}. Might be the same
     *                  instance with oldHolder.
     * @param preInfo The information that was returned from
     *                {@link #recordPreLayoutInformation(RecyclerView.State, RecyclerView.ViewHolder, int, List)}.
     * @param postInfo The information that was returned from {@link
     *                 #recordPreLayoutInformation(RecyclerView.State, RecyclerView.ViewHolder, int, List)}.
     * @return a boolean value indicating whether the {@link RecyclerView} should use a change animation
     *         for the {@link RecyclerView.ViewHolder}.
     */
    @Override
    public boolean animateChange(@NonNull final RecyclerView.ViewHolder oldHolder,
                                 @NonNull final RecyclerView.ViewHolder newHolder,
                                 @NonNull final ItemHolderInfo preInfo, @NonNull final ItemHolderInfo postInfo) {
        cancelCurrentAnimationIfExists(newHolder);
        if (preInfo instanceof GenericAnimatedViewHolderInfo && newHolder instanceof IAnimatedViewHolder) {
            final GenericAnimatedViewHolderInfo holderInfo = (GenericAnimatedViewHolderInfo) preInfo;
            final IAnimatedViewHolder holder = (IAnimatedViewHolder) newHolder;

            /* Call custom animation handlers */
            final AnimatorSet animatorSet = handleCustomAnimation(holderInfo, holder);
            if (animatorSet != null) {
                mCustomAnimationsMap.put(newHolder, animatorSet);
                animatorSet.start();
            }
        }
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
            case CHANGE_ANIMATION_FINISHED:
                dispatchChangeFinished(holder, false);
                if (mCustomAnimationsMap.containsKey(holder)) {
                    mCustomAnimationsMap.remove(holder);
                }
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
        for (final AnimatorSet animatorSet : mCustomAnimationsMap.values()) {
            animatorSet.cancel();
        }
    }

    /**
     * Abstract procedure meant to dispatch the intended animations whenever
     * {@link #animateChange(RecyclerView.ViewHolder, RecyclerView.ViewHolder, ItemHolderInfo, ItemHolderInfo)} is
     * called.
     * This procedure should be implement by classes extending this Item Animator base class.
     *
     * @param holderInfo The information that was returned from
     *                   {@link #recordPreLayoutInformation(RecyclerView.State, RecyclerView.ViewHolder, int, List)}.
     * @param holder the {@link RecyclerView} item's {@link RecyclerView.ViewHolder}.
     * @return the resulting {@link AnimatorSet} for the {@link RecyclerView} item's {@link RecyclerView.ViewHolder}.
     */
    @Nullable
    public abstract AnimatorSet handleCustomAnimation(@NonNull final GenericAnimatedViewHolderInfo holderInfo,
                                                      @NonNull final IAnimatedViewHolder holder);

    /**
     * Auxiliary procedure meant to allow {@link RecyclerView} to stop animations on its items, when they
     * disappear from the device's screen, thus being ready to be recycled.
     * @param item the {@link RecyclerView} item's {@link RecyclerView.ViewHolder}.
     */
    private void cancelCurrentAnimationIfExists(@NonNull final RecyclerView.ViewHolder item) {
        if (mCustomAnimationsMap.containsKey(item)) {
            mCustomAnimationsMap.get(item).cancel();
        }
    }

}
