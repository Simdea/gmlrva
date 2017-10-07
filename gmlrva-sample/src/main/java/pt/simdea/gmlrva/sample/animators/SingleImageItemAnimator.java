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
            runSingleImageEnterAnimation((SingleImageItemLayout.SingleImageItemViewHolder) holder);
            return false;
        }
        dispatchAddFinished(holder);
        return false;
    }

    private void runSingleImageEnterAnimation(@NonNull final SingleImageItemLayout.SingleImageItemViewHolder holder) {
        holder.runEnterAnimation(this);
    }

    @Override public void onAnimationEnd(@NonNull final RecyclerView.ViewHolder holder) {
        dispatchAddFinished(holder);
    }

}
