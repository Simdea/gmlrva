/*
 * Copyright (c) 2017. Simdea.
 */

package pt.simdea.gmlrva.lib.animators;

import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;

import pt.simdea.gmlrva.lib.GenericViewHolder;

import static pt.simdea.gmlrva.lib.animators.GenericAnimationFinishedOperation.ADD_ANIMATION_FINISHED;
import static pt.simdea.gmlrva.lib.animators.GenericAnimationFinishedOperation.REMOVE_ANIMATION_FINISHED;

/**
 * TODO...
 * Created by Paulo on 10/7/2017.
 */
public class GenericItemAnimator extends DefaultItemAnimator implements IAnimationFinished {

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
     * @param holder the {@link RecyclerView} item's {@link RecyclerView.ViewHolder}.
     * @return a boolean value indicating whether the {@link RecyclerView} should use an entry animation
     *         for the {@link RecyclerView.ViewHolder}. TODO: Review this JavaDoc
     */
    @Override
    public boolean animateAdd(@NonNull final RecyclerView.ViewHolder holder) {
        if (holder instanceof GenericViewHolder) {
            ((GenericViewHolder) holder).runAddAnimation(this);
            return false;
        }
        dispatchAddFinished(holder);
        return false;
    }

    /**
     * {@inheritDoc}
     *
     * @param holder the {@link RecyclerView} item's {@link RecyclerView.ViewHolder}.
     * @return a boolean value indicating whether the {@link RecyclerView} should use an exit animation
     *         for the {@link RecyclerView.ViewHolder}. TODO: Review this JavaDoc
     */
    @Override
    public boolean animateRemove(@NonNull final RecyclerView.ViewHolder holder) {
        if (holder instanceof GenericViewHolder) {
            ((GenericViewHolder) holder).runRemoveAnimation(this);
            return false;
        }
        dispatchRemoveFinished(holder);
        return false;
    }

    /**
     * TODO!
     * @param holder the {@link RecyclerView} item's {@link RecyclerView.ViewHolder}.
     * @param animationFinishedOperation TODO...
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
                throw new UnsupportedOperationException("Unsupported operation found."); // TODO!
        }
    }

}
