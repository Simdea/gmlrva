/*
 * Copyright (c) 2017. Simdea.
 */

package pt.simdea.gmlrva.sample.layouts.holders;

import android.animation.AnimatorSet;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pt.simdea.gmlrva.lib.GenericMultipleLayoutAdapter;
import pt.simdea.gmlrva.lib.IGenericRecyclerViewLayout;
import pt.simdea.gmlrva.lib.IViewHolder;
import pt.simdea.gmlrva.lib.animation.GenericItemAnimator;
import pt.simdea.gmlrva.lib.animation.helpers.GenericAnimationFinishedOperation;
import pt.simdea.gmlrva.lib.animation.helpers.IAnimatedViewHolder;
import pt.simdea.gmlrva.lib.utilities.GMLRVAConstants;
import pt.simdea.gmlrva.sample.R;
import pt.simdea.gmlrva.sample.data.ClickListener;
import pt.simdea.gmlrva.sample.layouts.GenericRecyclerViewLayoutTypes;
import pt.simdea.gmlrva.sample.layouts.animation.ViewHolderAnimationHelper;

/**
 * Class representing a Single Image Layout meant to be used on a {@link GenericMultipleLayoutAdapter}.
 *
 * Created by Paulo Ribeiro on 7/16/2017.
 * Simdea © All Rights Reserved.
 * paulo.ribeiro@simdea.pt
 */
@AllArgsConstructor
public class SingleImageItemLayout
        implements IGenericRecyclerViewLayout<SingleImageItemLayout.SingleImageItemViewHolder> {

    @IntRange(from = 0)
    private final int mCoverResource;
    @SuppressWarnings("WeakerAccess")
    protected final ClickListener mListener;

    @NonNull
    @Override
    public SingleImageItemViewHolder createViewHolder(@NonNull final ViewGroup parent) {
        final View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.gmlrva_layout_generic_single_image_item, parent, false);
        return new SingleImageItemViewHolder(view);
    }

    @Override
    public void setElements(@NonNull final SingleImageItemViewHolder holder) {
        holder.getCover().setImageResource(mCoverResource);
    }

    @NonNull
    @Override
    public Object getTag() {
        return mCoverResource;
    }

    @Override
    public int getViewType() {
        return GenericRecyclerViewLayoutTypes.SINGLE_IMAGE_ITEM;
    }

    /** Class meant to define the {@link RecyclerView.ViewHolder} for a Single Image Layout instance. */
    final class SingleImageItemViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener, IAnimatedViewHolder, IViewHolder {

        @Getter
        private ImageView mCover;

        /**
         * Instantiates a new SingleImageItemViewHolder.
         * @param view this {@link RecyclerView.ViewHolder}'s root view.
         */
        SingleImageItemViewHolder(@NonNull final View view) {
            super(view);
            bindViews(view);
            bindListeners();
        }

        /** {@inheritDoc} */
        @Override
        public void runAddAnimation(@NonNull final GenericItemAnimator listener) {
            ViewHolderAnimationHelper.runTestAddAnimation(this, itemView, listener);
        }

        /** {@inheritDoc} */
        @Override
        public void runRemoveAnimation(@NonNull final GenericItemAnimator listener) {
            ViewHolderAnimationHelper.runTestRemoveAnimation(this, itemView, listener);
        }

        /** {@inheritDoc} */
        @Nullable
        @Override
        public AnimatorSet runChangeAnimation(@NonNull final GenericItemAnimator listener) {
            listener.onAnimationFinished(this, GenericAnimationFinishedOperation.CHANGE_ANIMATION_FINISHED);
            return null;
        }

        /** {@inheritDoc} */
        @Override
        public void onClick(@NonNull final View v) {
            final int viewId = v.getId();
            if (viewId == mCover.getId()) {
                handleCoverClick();
            } else {
                throw new UnsupportedOperationException(GMLRVAConstants.UNSUPPORTED_ERROR);
            }
        }

        /** Procedure meant to handle a Single Image Layout click action. */
        private void handleCoverClick() {
            Toast.makeText(itemView.getContext(), "Cover Click!", Toast.LENGTH_SHORT).show();
            if (mListener != null) {
                mListener.onClick();
            }
        }

        /** Procedure meant to bind this {@link RecyclerView.ViewHolder}'s listeners. */
        private void bindListeners() {
            mCover.setOnClickListener(this);
        }

        /**
         * Procedure meant to bind this {@link RecyclerView.ViewHolder}'s views.
         * @param view this {@link SingleImageItemViewHolder}'s root view.
         */
        private void bindViews(@NonNull final View view) {
            mCover = view.findViewById(R.id.ivSingleImageItemLayoutCover);
        }

        @Override
        public void recycle() {

        }
    }

}
