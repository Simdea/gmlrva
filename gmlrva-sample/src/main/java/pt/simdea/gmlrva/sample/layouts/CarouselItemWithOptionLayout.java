/*
 * Copyright (c) 2017. Simdea.
 */

package pt.simdea.gmlrva.sample.layouts;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pt.simdea.gmlrva.lib.GenericMultipleLayoutAdapter;
import pt.simdea.gmlrva.lib.IGenericRecyclerViewLayout;
import pt.simdea.gmlrva.sample.R;

import static pt.simdea.gmlrva.sample.utilities.GMLRVAConstants.UNSUPPORTED_ERROR;

/**
 * Class representing a Carousel Item Layout meant to be used on a {@link GenericMultipleLayoutAdapter}.
 *
 * Created by Paulo Ribeiro on 9/14/2017.
 * Simdea © All Rights Reserved.
 * paulo.ribeiro@simdea.pt
 */
@AllArgsConstructor public class CarouselItemWithOptionLayout
        implements IGenericRecyclerViewLayout<CarouselItemWithOptionLayout.CarouselItemWithOptionViewHolder> {

    private final String mTitle;
    private final String mDescription;
    private final int mCoverResource;

    @NonNull @Override public CarouselItemWithOptionViewHolder createViewHolder(@NonNull final ViewGroup parent) {
        final View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.gmlrva_layout_carousel_item_option, parent, false);
        return new CarouselItemWithOptionViewHolder(view);
    }

    @Override public void setElements(@NonNull final CarouselItemWithOptionViewHolder holder) {
        holder.getTitle().setText(mTitle);
        holder.getDescription().setText(mDescription);
        holder.getCover().setImageResource(mCoverResource);
    }

    @NonNull @Override public Object getTag() {
        return mTitle;
    }

    @Override public int getViewType() {
        return 5;
    }

    /** Class meant to define the {@link RecyclerView.ViewHolder} for a Carousel Item Layout instance. */
    class CarouselItemWithOptionViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @Getter private TextView mTitle;
        @Getter private TextView mDescription;
        @Getter private ImageView mCover;
        @Getter private ImageView mOption;
        @Getter private RelativeLayout mOptionSection;
        @Getter private View mLeftOption;
        @Getter private View mRightOption;

        /**
         * Instantiates a new CarouselItemViewHolder.
         * @param view this {@link RecyclerView.ViewHolder}'s root view.
         */
        CarouselItemWithOptionViewHolder(@NonNull final View view) {
            super(view);
            bindViews(view);
            bindListeners();
        }

        @Override public void onClick(@NonNull final View v) {
            final int viewId = v.getId();
            if (viewId == mTitle.getId()) {
                handleTitleClick();
            } else if (viewId == mDescription.getId()) {
                handleDescriptionClick();
            } else if (viewId == mCover.getId()) {
                handleCoverClick();
            } else if (viewId == mOption.getId()) {
                handleOptionClick();
            } else if (viewId == mLeftOption.getId()) {
                handleLeftOptionClick();
            } else if (viewId == mRightOption.getId()) {
                handleRightOptionClick();
            } else {
                throw new UnsupportedOperationException(UNSUPPORTED_ERROR);
            }
        }

        /** Procedure meant to handle a Left Option view Carousel Item Layout click action. */
        private void handleLeftOptionClick() {
            Toast.makeText(itemView.getContext(), "Left Option selected!", Toast.LENGTH_SHORT).show();
            handleOptionClick();
        }

        /** Procedure meant to handle a Right Option view Carousel Item Layout click action. */
        private void handleRightOptionClick() {
            Toast.makeText(itemView.getContext(), "Right Option selected!", Toast.LENGTH_SHORT).show();
            handleOptionClick();
        }

        /** Procedure meant to handle an Option view Carousel Item Layout click action. */
        private void handleOptionClick() {
            if (mOptionSection.getVisibility() == View.GONE) {
                mOptionSection.setVisibility(View.VISIBLE);
            } else {
                mOptionSection.setVisibility(View.GONE);
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
            final View[] clickableViews = {mTitle, mCover, mDescription, mOption, mLeftOption, mRightOption};
            for (final View view : clickableViews) {
                view.setOnClickListener(this);
            }
        }

        /**
         * Procedure meant to bind this {@link RecyclerView.ViewHolder}'s views.
         * @param view this {@link CarouselItemWithOptionViewHolder}'s root view.
         */
        private void bindViews(@NonNull final View view) {
            mTitle = (TextView) view.findViewById(R.id.tvCarouselItemTitle);
            mDescription = (TextView) view.findViewById(R.id.tvCarouselItemDescription);
            mCover = (ImageView) view.findViewById(R.id.ivCarouselItemCover);
            mOption = (ImageView) view.findViewById(R.id.ivCarouselItemOption);
            mOptionSection = (RelativeLayout) view.findViewById(R.id.rlOptionSection);
            mLeftOption = view.findViewById(R.id.vOptionsSectionLeft);
            mRightOption = view.findViewById(R.id.vOptionsSectionRight);
        }

    }

}
