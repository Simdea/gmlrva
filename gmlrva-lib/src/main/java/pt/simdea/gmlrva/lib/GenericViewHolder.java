/*
 * Copyright (c) 2017. Simdea.
 */

package pt.simdea.gmlrva.lib;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import pt.simdea.gmlrva.lib.animators.GenericItemAnimator;

/**
 * TODO...
 * Created by Paulo on 10/7/2017.
 */
public abstract class GenericViewHolder extends RecyclerView.ViewHolder {

    /**
     * TODO...
     * @param itemView
     */
    public GenericViewHolder(@NonNull final View itemView) {
        super(itemView);
    }

    /**
     * TODO...
     */
    public abstract void runAddAnimation(@NonNull final GenericItemAnimator listener);

    /**
     * TODO...
     */
    public abstract void runRemoveAnimation(@NonNull final GenericItemAnimator listener);

    // TODO: Add remaining animation stages!

}
