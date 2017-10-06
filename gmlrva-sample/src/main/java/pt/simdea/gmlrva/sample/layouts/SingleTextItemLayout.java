/*
 * Copyright (c) 2017. Simdea.
 */

package pt.simdea.gmlrva.sample.layouts;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pt.simdea.gmlrva.lib.GenericMultipleLayoutAdapter;
import pt.simdea.gmlrva.lib.IGenericRecyclerViewLayout;
import pt.simdea.gmlrva.sample.R;
import pt.simdea.gmlrva.sample.data.ClickListener;

import static pt.simdea.gmlrva.sample.utilities.GMLRVAConstants.UNSUPPORTED_ERROR;

/**
 * Class representing a Single Text Layout meant to be used on a {@link GenericMultipleLayoutAdapter}.
 *
 * Created by Paulo Ribeiro on 10/6/2017.
 * Simdea © All Rights Reserved.
 * paulo.ribeiro@simdea.pt
 */
@AllArgsConstructor public class SingleTextItemLayout
        implements IGenericRecyclerViewLayout<SingleTextItemLayout.SingleTextItemViewHolder> {

    protected final String mTextResource;
    protected final ClickListener mListener;

    @NonNull @Override public SingleTextItemViewHolder createViewHolder(@NonNull final ViewGroup parent) {
        final View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.gmlrva_layout_generic_single_text_item, parent, false);
        return new SingleTextItemViewHolder(view);
    }

    @Override public void setElements(@NonNull final SingleTextItemViewHolder holder) {
        holder.getTitle().setText(mTextResource);
    }

    @NonNull @Override public Object getTag() {
        return mTextResource;
    }

    @Override public int getViewType() {
        return 6;
    }

    /** Class meant to define the {@link RecyclerView.ViewHolder} for a Single Text Layout instance. */
    final class SingleTextItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @Getter private TextView mTitle;

        /**
         * Instantiates a new SingleTextItemViewHolder.
         * @param view this {@link RecyclerView.ViewHolder}'s root view.
         */
        SingleTextItemViewHolder(@NonNull final View view) {
            super(view);
            bindViews(view);
            bindListeners();
        }

        @Override public void onClick(@NonNull final View v) {
            final int viewId = v.getId();
            if (viewId == mTitle.getId()) {
                handleCoverClick();
            } else {
                throw new UnsupportedOperationException(UNSUPPORTED_ERROR);
            }
        }

        /** Procedure meant to handle a Single Text Layout click action. */
        private void handleCoverClick() {
            Toast.makeText(itemView.getContext(), "Title Click!", Toast.LENGTH_SHORT).show();
            if (mListener != null) {
                mListener.onClick();
            }
        }

        /** Procedure meant to bind this {@link RecyclerView.ViewHolder}'s listeners. */
        private void bindListeners() {
            mTitle.setOnClickListener(this);
        }

        /**
         * Procedure meant to bind this {@link RecyclerView.ViewHolder}'s views.
         * @param view this {@link SingleTextItemViewHolder}'s root view.
         */
        private void bindViews(@NonNull final View view) {
            mTitle = (TextView) view.findViewById(R.id.tvSingleTextItemLayoutTitle);
        }

    }

}
