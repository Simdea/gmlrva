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
import android.widget.TextView;
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

import pt.simdea.gmlrva.sample.layouts.GenericRecyclerViewLayoutTypes;

/**
 * Class representing a Carousel Item Layout meant to be used on a {@link GenericMultipleLayoutAdapter}.
 *
 * Created by Paulo Ribeiro on 7/16/2017.
 * Simdea © All Rights Reserved.
 * paulo.ribeiro@simdea.pt
 */
@AllArgsConstructor
public class CarouselItemLayout
        implements IGenericRecyclerViewLayout<CarouselItemLayout.CarouselItemViewHolder> {

    private final String mTitle;
    private final String mDescription;
    @IntRange(from = 0)
    private final int mCoverResource;

    @NonNull
    @Override
    public CarouselItemViewHolder createViewHolder(@NonNull final ViewGroup parent) {
        final View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.gmlrva_layout_carousel_item, parent, false);
        return new CarouselItemViewHolder(view);
    }

    @Override
    public void setElements(@NonNull final CarouselItemViewHolder holder) {
        holder.getTitle().setText(mTitle);
        holder.getDescription().setText(mDescription);
        holder.getCover().setImageResource(mCoverResource);
    }

    @NonNull
    @Override
    public Object getTag() {
        return mTitle;
    }

    @Override
    public int getViewType() {
        return GenericRecyclerViewLayoutTypes.CAROUSEL_ITEM;
    }

    /** Class meant to define the {@link RecyclerView.ViewHolder} for a Carousel Item Layout instance. */
    class CarouselItemViewHolder extends RecyclerView.ViewHolder implements IAnimatedViewHolder, View.OnClickListener, IViewHolder {

        @Getter
        private TextView mTitle;
        @Getter
        private TextView mDescription;
        @Getter
        private ImageView mCover;

        /**
         * Instantiates a new CarouselItemViewHolder.
         * @param view this {@link RecyclerView.ViewHolder}'s root view.
         */
        CarouselItemViewHolder(@NonNull final View view) {
            super(view);
            bindViews(view);
            bindListeners();
        }

        /** {@inheritDoc} */
        @Override
        public void runAddAnimation(@NonNull final GenericItemAnimator listener) {
            listener.onAnimationFinished(this, GenericAnimationFinishedOperation.ADD_ANIMATION_FINISHED);
        }

        /** {@inheritDoc} */
        @Override
        public void runRemoveAnimation(@NonNull final GenericItemAnimator listener) {
            listener.onAnimationFinished(this, GenericAnimationFinishedOperation.REMOVE_ANIMATION_FINISHED);
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
            if (viewId == mTitle.getId()) {
                handleTitleClick();
            } else if (viewId == mDescription.getId()) {
                handleDescriptionClick();
            } else if (viewId == mCover.getId()) {
                handleCoverClick();
            } else {
                throw new UnsupportedOperationException(GMLRVAConstants.UNSUPPORTED_ERROR);
            }
        }

        /** Procedure meant to handle a Cover view Carousel Item Layout click action. */
        private void handleCoverClick() {
            Toast.makeText(itemView.getContext(), "Cover Click!", Toast.LENGTH_SHORT).show();
        }

        /** Procedure meant to handle a Description view Carousel Item Layout click action. */
        private void handleDescriptionClick() {
            Toast.makeText(itemView.getContext(), "Description Click!", Toast.LENGTH_SHORT).show();
        }

        /** Procedure meant to handle a Title view Carousel Item Layout click action. */
        private void handleTitleClick() {
            Toast.makeText(itemView.getContext(), "Title Click!", Toast.LENGTH_SHORT).show();
        }

        /** Procedure meant to bind this {@link RecyclerView.ViewHolder}'s listeners. */
        private void bindListeners() {
            final View[] clickableViews = {mTitle, mCover, mDescription};
            for (final View view : clickableViews) {
                view.setOnClickListener(this);
            }
        }

        /**
         * Procedure meant to bind this {@link RecyclerView.ViewHolder}'s views.
         * @param view this {@link CarouselItemViewHolder}'s root view.
         */
        private void bindViews(@NonNull final View view) {
            mTitle = view.findViewById(R.id.tvCarouselItemTitle);
            mDescription = view.findViewById(R.id.tvCarouselItemDescription);
            mCover = view.findViewById(R.id.ivCarouselItemCover);
        }

        @Override
        public void recycle() {

        }
    }

}
