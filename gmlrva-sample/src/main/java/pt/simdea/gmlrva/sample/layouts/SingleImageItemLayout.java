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
import android.widget.Toast;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pt.simdea.gmlrva.lib.GenericMultipleLayoutAdapter;
import pt.simdea.gmlrva.lib.GenericRecyclerViewLayout;
import pt.simdea.gmlrva.sample.R;

import static pt.simdea.gmlrva.sample.utilities.GMLRVAConstants.UNSUPPORTED_ERROR;

/**
 * Class representing a Single Image Layout meant to be used on a {@link GenericMultipleLayoutAdapter}.
 *
 * Created by Paulo Ribeiro on 7/16/2017.
 * Simdea © All Rights Reserved.
 * paulo.ribeiro@simdea.pt
 */
@AllArgsConstructor public class SingleImageItemLayout
        implements GenericRecyclerViewLayout<SingleImageItemLayout.SingleImageItemViewHolder> {

    private final int mCoverResource;

    @Override public SingleImageItemViewHolder createViewHolder(@NonNull final ViewGroup parent) {
        final View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.gmlrva_layout_generic_single_image_item, parent, false);
        return new SingleImageItemViewHolder(view);
    }

    @Override public void setElements(@NonNull final SingleImageItemViewHolder holder) {
        holder.getCover().setImageResource(mCoverResource);
    }

    /** Class meant to define the {@link RecyclerView.ViewHolder} for a Single Image Layout instance. */
    class SingleImageItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @Getter private ImageView mCover;

        /**
         * Instantiates a new SingleImageItemViewHolder.
         * @param view this {@link RecyclerView.ViewHolder}'s root view.
         */
        SingleImageItemViewHolder(@NonNull final View view) {
            super(view);
            bindViews(view);
            bindListeners();
        }

        @Override public void onClick(@NonNull final View v) {
            final int viewId = v.getId();
            if (viewId == mCover.getId()) {
                handleCoverClick();
            } else {
                throw new UnsupportedOperationException(UNSUPPORTED_ERROR);
            }
        }

        /** Procedure meant to handle a Single Image Layout click action. */
        private void handleCoverClick() {
            Toast.makeText(itemView.getContext(), "Cover Click!", Toast.LENGTH_SHORT).show();
        }

        /** Procedure meant to bind this {@link RecyclerView.ViewHolder}'s listeners. */
        private void bindListeners() {
            mCover.setOnClickListener(this);
        }

        /** Procedure meant to bind this {@link RecyclerView.ViewHolder}'s views. */
        private void bindViews(@NonNull final View view) {
            mCover = (ImageView) view.findViewById(R.id.ivSingleImageItemLayoutCover);
        }
    }
}
