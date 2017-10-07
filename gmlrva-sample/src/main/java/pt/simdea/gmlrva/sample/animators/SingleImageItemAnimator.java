package pt.simdea.gmlrva.sample.animators;

import android.animation.Animator;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.animation.DecelerateInterpolator;

import pt.simdea.gmlrva.lib.animators.GenericItemAnimator;
import pt.simdea.gmlrva.lib.utilities.ViewUtils;
import pt.simdea.gmlrva.sample.layouts.SingleImageItemLayout;

/**
 * TODO...
 * Created by Paulo on 10/7/2017.
 */
public class SingleImageItemAnimator extends GenericItemAnimator {

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
        final int screenHeight = ViewUtils.getDeviceScreenHeight(holder.itemView.getContext());
        holder.itemView.setTranslationY(screenHeight);
        holder.itemView.animate()
                .translationY(0)
                .setInterpolator(new DecelerateInterpolator(3.f))
                .setDuration(700)
                .setListener(new Animator.AnimatorListener() {
                    @Override public void onAnimationStart(@NonNull final Animator animation) {
                        /* Do nothing here */
                    }

                    @Override public void onAnimationEnd(@NonNull final Animator animation) {
                        dispatchAddFinished(holder);
                    }

                    @Override public void onAnimationCancel(@NonNull final Animator animation) {
                        /* Do nothing here */
                    }

                    @Override public void onAnimationRepeat(@NonNull final Animator animation) {
                        /* Do nothing here */
                    }
                }).start();
    }

}
