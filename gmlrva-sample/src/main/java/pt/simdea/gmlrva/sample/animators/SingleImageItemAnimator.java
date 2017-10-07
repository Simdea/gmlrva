package pt.simdea.gmlrva.sample.animators;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;

import pt.simdea.gmlrva.lib.animators.GenericItemAnimator;
import pt.simdea.gmlrva.sample.layouts.SingleImageItemLayout;

/**
 * TODO...
 * Created by Paulo on 10/7/2017.
 */
public class SingleImageItemAnimator extends GenericItemAnimator implements GenericItemAnimator.AnimationEndListener {

    /** {@inheritDoc} */
    @Override public boolean animateAdd(@NonNull final RecyclerView.ViewHolder holder) {
        if (holder.getItemViewType() == 0) {
            ((SingleImageItemLayout.SingleImageItemViewHolder) holder).runAddAnimation(this);
            return false;
        }
        dispatchAddFinished(holder);
        return false;
    }

    /** {@inheritDoc} */
    @Override public boolean animateRemove(@NonNull final RecyclerView.ViewHolder holder) {
        if (holder.getItemViewType() == 0) {
            ((SingleImageItemLayout.SingleImageItemViewHolder) holder).runRemoveAnimation(this);
            return false;
        }
        dispatchRemoveFinished(holder);
        return false;
    }

    @Override public void onAddAnimationEnd(@NonNull final RecyclerView.ViewHolder holder) {
        dispatchAddFinished(holder);
    }

    @Override public void onRemoveAnimationEnd(@NonNull final RecyclerView.ViewHolder holder) {
        dispatchRemoveFinished(holder);
    }

}
