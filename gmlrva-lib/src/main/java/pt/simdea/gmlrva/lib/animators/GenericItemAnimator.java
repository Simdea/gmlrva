package pt.simdea.gmlrva.lib.animators;

import android.support.annotation.NonNull;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;

/**
 * TODO...
 * Created by Paulo on 10/7/2017.
 */
public abstract class GenericItemAnimator extends DefaultItemAnimator {

    /**
     * {@inheritDoc}
     *
     * When animating {@link RecyclerView} items, we can ask the {@link RecyclerView} to keep the previous
     * {@link RecyclerView.ViewHolder} of the item as-is and provide a new {@link RecyclerView.ViewHolder} which will
     * animate changes from the previous one (only the new {@link RecyclerView.ViewHolder} will be visible
     * on the {@link RecyclerView}).
     *
     * But when writing custom item animators the same {@link RecyclerView.ViewHolder} should be used and the
     * animations should be handled manually. For these cases this procedure returns true.
     *
     * @param holder the {@link RecyclerView} item's {@link RecyclerView.ViewHolder}.
     * @return boolean value indicating whether the {@link RecyclerView} should reuse
     *         the {@link RecyclerView.ViewHolder} or a new one.
     */
    @Override public boolean canReuseUpdatedViewHolder(@NonNull final RecyclerView.ViewHolder holder) {
        return true;
    }

    /**
     * {@inheritDoc}
     *
     * @param holder the {@link RecyclerView} item's {@link RecyclerView.ViewHolder}.
     * @return a boolean value indicating whether the {@link RecyclerView} should use an entry animation
     *         for the {@link RecyclerView.ViewHolder}. TODO: Review this JavaDoc
     */
    @Override public abstract boolean animateAdd(@NonNull final RecyclerView.ViewHolder holder);

    public interface AnimationEndListener {
        void onAnimationEnd(@NonNull final RecyclerView.ViewHolder holder);
    }

}
