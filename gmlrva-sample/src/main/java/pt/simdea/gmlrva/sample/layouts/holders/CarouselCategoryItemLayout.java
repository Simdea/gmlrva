/*
 * Copyright (c) 2017. Simdea.
 */

package pt.simdea.gmlrva.sample.layouts.holders;

import android.animation.AnimatorSet;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pt.simdea.gmlrva.lib.GenericMultipleLayoutAdapter;
import pt.simdea.gmlrva.lib.IGenericRecyclerViewLayout;
import pt.simdea.gmlrva.lib.decoration.decorators.SimpleDividerItemDecoration;
import pt.simdea.gmlrva.lib.decoration.helpers.GenericDecorationDividerPosition;
import pt.simdea.gmlrva.lib.decoration.specs.SimpleDividerItemDecorationSpec;
import pt.simdea.gmlrva.lib.utilities.GenericUtils;
import pt.simdea.gmlrva.lib.animation.GenericItemAnimator;
import pt.simdea.gmlrva.lib.animation.helpers.GenericAnimationFinishedOperation;
import pt.simdea.gmlrva.lib.animation.helpers.IAnimatedViewHolder;
import pt.simdea.gmlrva.sample.R;
import pt.simdea.gmlrva.sample.layouts.GenericRecyclerViewLayoutTypes;

/**
 * Class representing a Carousel Category Layout meant to be used on a {@link GenericMultipleLayoutAdapter}.
 *
 * Created by Paulo Ribeiro on 7/16/2017.
 * Simdea © All Rights Reserved.
 * paulo.ribeiro@simdea.pt
 */
@AllArgsConstructor
public class CarouselCategoryItemLayout
        implements IGenericRecyclerViewLayout<CarouselCategoryItemLayout.CarouselCategoryViewHolder> {

    private final String mCategoryTitle;
    private final List<? extends IGenericRecyclerViewLayout> mCategoryData;
    private final Context mContext;

    @NonNull
    @Override
    public CarouselCategoryViewHolder createViewHolder(@NonNull final ViewGroup parent) {
        final View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.gmlrva_layout_carousel_category_item, parent, false);
        return new CarouselCategoryViewHolder(view);
    }

    @Override
    public void setElements(@NonNull final CarouselCategoryViewHolder holder) {
        holder.getTitle().setText(mCategoryTitle);
        final Drawable aux = ContextCompat
                .getDrawable(holder.itemView.getContext(), R.drawable.gmlrva_vertical_red_line_item_divider);
        if (aux != null) {
            loadItems(holder.getItems(), aux);
        }
    }

    @NonNull
    @Override
    public Object getTag() {
        return mCategoryTitle;
    }

    @Override
    public int getViewType() {
        return GenericRecyclerViewLayoutTypes.CAROUSEL_ITEM_CATEGORY;
    }

    /**
     * Procedure meant to load the Carousel Item Layout items, bound by this Carousel Category Layout.
     * @param items the {@link RecyclerView} which will hold the Carousel Item Layout items.
     * @param drawable the divider's target {@link Drawable} value.
     */
    private void loadItems(@NonNull final RecyclerView items, @NonNull final Drawable drawable) {
        items.setAdapter(new GenericMultipleLayoutAdapter(mCategoryData, mContext, false));
        items.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));

        final SimpleDividerItemDecorationSpec spec = new SimpleDividerItemDecorationSpec.DecorationSpecBuilder()
                .withDrawableDivider(drawable)
                .withDividerPosition(GenericDecorationDividerPosition.POSITION_END)
                .buildDecorationSpec();
        items.addItemDecoration(new SimpleDividerItemDecoration(spec));

        GenericUtils.setOptimalConfigurationForRecyclerView(items);
    }

    /** Class meant to define the {@link RecyclerView.ViewHolder} for a Carousel Category Layout instance. */
    class CarouselCategoryViewHolder extends RecyclerView.ViewHolder implements IAnimatedViewHolder {

        @Getter
        private TextView mTitle;
        @Getter
        private RecyclerView mItems;

        /**
         * Instantiates a new CarouselCategoryViewHolder.
         * @param view this {@link RecyclerView.ViewHolder}'s root view.
         */
        CarouselCategoryViewHolder(@NonNull final View view) {
            super(view);
            bindViews(view);
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

        /**
         * Procedure meant to bind this {@link RecyclerView.ViewHolder}'s views.
         * @param view this {@link CarouselCategoryViewHolder}'s root view.
         */
        private void bindViews(@NonNull final View view) {
            mTitle = view.findViewById(R.id.tvCarouselCategoryItemTitle);
            mItems = view.findViewById(R.id.rvCarouselCategoryItemData);
        }

    }

}
