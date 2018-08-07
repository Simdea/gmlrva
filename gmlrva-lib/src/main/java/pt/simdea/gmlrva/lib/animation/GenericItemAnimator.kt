/*
 * Copyright (c) 2017. Simdea.
 */

package pt.simdea.gmlrva.lib.animation

import android.animation.AnimatorSet
import android.util.ArrayMap
import androidx.annotation.IntRange
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.RecyclerView
import pt.simdea.gmlrva.lib.IGenericRecyclerViewLayout
import pt.simdea.gmlrva.lib.animation.helpers.GenericAnimatedViewHolderInfo
import pt.simdea.gmlrva.lib.animation.helpers.GenericAnimationFinishedOperation
import pt.simdea.gmlrva.lib.animation.helpers.GenericAnimationFinishedOperationVars.Companion.ADD_ANIMATION_FINISHED
import pt.simdea.gmlrva.lib.animation.helpers.GenericAnimationFinishedOperationVars.Companion.CHANGE_ANIMATION_FINISHED
import pt.simdea.gmlrva.lib.animation.helpers.GenericAnimationFinishedOperationVars.Companion.REMOVE_ANIMATION_FINISHED
import pt.simdea.gmlrva.lib.animation.helpers.IAnimatedViewHolder
import pt.simdea.gmlrva.lib.animation.helpers.IAnimationFinished
import pt.simdea.gmlrva.lib.utilities.GMLRVAConstantsVars

/**
 * This class is meant to serve as a base [RecyclerView.ItemAnimator],
 * responsible for coordinating default animations performed by [RecyclerView].
 *
 * Created by Paulo Ribeiro on 10/7/2017.
 * Simdea © All Rights Reserved.
 * paulo.ribeiro@simdea.pt
 */
abstract class GenericItemAnimator : DefaultItemAnimator(), IAnimationFinished {

    /* View Holder Animations Map */
    private val mCustomAnimationsMap = ArrayMap<RecyclerView.ViewHolder, AnimatorSet>()

    /**
     * {@inheritDoc}
     *
     * When animating [RecyclerView] items, we can ask the [RecyclerView] to keep the previous
     * [RecyclerView.ViewHolder] of the item as-is and provide a new [RecyclerView.ViewHolder] which will
     * animate changes from the previous one (only the new [RecyclerView.ViewHolder] will be visible
     * on the [RecyclerView]).
     *
     * But when writing custom item animators the same [RecyclerView.ViewHolder] should be used and the
     * animations should be handled manually. For these cases this procedure returns true.
     *
     * @param holder the [RecyclerView] item's [RecyclerView.ViewHolder].
     * @return boolean value indicating whether the [RecyclerView] should reuse
     * the [RecyclerView.ViewHolder] or a new one.
     */
    override fun canReuseUpdatedViewHolder(holder: RecyclerView.ViewHolder): Boolean {
        return true
    }

    /**
     * {@inheritDoc}
     *
     * Item's whose [RecyclerView.ViewHolder]s implement the [IAnimatedViewHolder] interface will have
     * their [IAnimatedViewHolder.runAddAnimation] procedure called.
     *
     * @param holder the [RecyclerView] item's [RecyclerView.ViewHolder].
     * @return a boolean value indicating whether the [RecyclerView] should use an entry animation
     * for the [RecyclerView.ViewHolder].
     */
    override fun animateAdd(holder: RecyclerView.ViewHolder): Boolean {
        if (holder is IAnimatedViewHolder) {
            (holder as IAnimatedViewHolder).runAddAnimation(this)
            return false
        }
        dispatchAddFinished(holder)
        return false
    }

    /**
     * {@inheritDoc}
     *
     * Item's whose [RecyclerView.ViewHolder]s implement the [IAnimatedViewHolder] interface will have
     * their [IAnimatedViewHolder.runRemoveAnimation] procedure called.
     *
     * @param holder the [RecyclerView] item's [RecyclerView.ViewHolder].
     * @return a boolean value indicating whether the [RecyclerView] should use an exit animation
     * for the [RecyclerView.ViewHolder].
     */
    override fun animateRemove(holder: RecyclerView.ViewHolder): Boolean {
        if (holder is IAnimatedViewHolder) {
            (holder as IAnimatedViewHolder).runRemoveAnimation(this)
            return false
        }
        dispatchRemoveFinished(holder)
        return false
    }

    /**
     * {@inheritDoc}
     *
     * Custom animations should be triggered on the [IGenericRecyclerViewLayout] implementation.
     * Since changes are usually triggered by the [RecyclerView.Adapter.notifyItemChanged] procedure,
     * we can pass additional arguments to it which will help the [IGenericRecyclerViewLayout] decide what
     * animation should be performed.
     * This procedure is used to catch the data before changes occur. The [RecyclerView] then calls
     * [RecyclerView.Adapter.onBindViewHolder] and finally,
     * [RecyclerView.ItemAnimator] will call [ #recordPostLayoutInformation(RecyclerView.State, RecyclerView.ViewHolder)][RecyclerView.ItemAnimator].
     *
     * @param state the current [RecyclerView.State].
     * @param holder the [RecyclerView] item's [RecyclerView.ViewHolder].
     * @param changeFlags additional information about what changes happened in the Adapter
     * about the Item represented by this ViewHolder. For instance, if
     * item is deleted from the adapter, [.FLAG_REMOVED] will be set.
     * @param payloads The payload list that was previously passed to
     * [RecyclerView.Adapter.notifyItemChanged] or
     * [RecyclerView.Adapter.notifyItemRangeChanged].
     * @return an ItemHolderInfo instance that preserves necessary information about the ViewHolder.
     */
    override fun recordPreLayoutInformation(state: RecyclerView.State,
                                            holder: RecyclerView.ViewHolder,
                                            @IntRange(from = 0) changeFlags: Int,
                                            payloads: List<Any>): RecyclerView.ItemAnimator.ItemHolderInfo {
        if (changeFlags == RecyclerView.ItemAnimator.FLAG_CHANGED) {
            for (payload in payloads) {
                if (payload is Int) {
                    return GenericAnimatedViewHolderInfo(payload)
                }
            }
        }
        return super.recordPreLayoutInformation(state, holder, changeFlags, payloads)
    }

    /**
     * {@inheritDoc}
     *
     * Item's whose [RecyclerView.ViewHolder]s implement the [IAnimatedViewHolder] interface will have
     * their [IAnimatedViewHolder.runChangeAnimation] procedure called.
     *
     * @param oldHolder the old [RecyclerView] item's [RecyclerView.ViewHolder]. Might be the same
     * instance with newHolder.
     * @param newHolder the new [RecyclerView] item's [RecyclerView.ViewHolder]. Might be the same
     * instance with oldHolder.
     * @param preInfo The information that was returned from
     * [.recordPreLayoutInformation].
     * @param postInfo The information that was returned from [                 ][.recordPreLayoutInformation].
     * @return a boolean value indicating whether the [RecyclerView] should use a change animation
     * for the [RecyclerView.ViewHolder].
     */
    override fun animateChange(oldHolder: RecyclerView.ViewHolder,
                               newHolder: RecyclerView.ViewHolder,
                               preInfo: RecyclerView.ItemAnimator.ItemHolderInfo, postInfo: RecyclerView.ItemAnimator.ItemHolderInfo): Boolean {
        cancelCurrentAnimationIfExists(newHolder)
        if (preInfo is GenericAnimatedViewHolderInfo && newHolder is IAnimatedViewHolder) {
            val holder = newHolder as IAnimatedViewHolder

            /* Call custom animation handlers */
            val animatorSet = handleCustomAnimation(preInfo, holder)
            if (animatorSet != null) {
                mCustomAnimationsMap[newHolder] = animatorSet
                animatorSet.start()
            }
        }
        return false
    }

    /**
     * Procedure meant to handle the report when the animation for the [RecyclerView.ViewHolder] has finished.
     * @param holder the [RecyclerView] item's [RecyclerView.ViewHolder].
     * @param animationFinishedOperation an Integer value representing the animation operation that has finished.
     * See [GenericAnimationFinishedOperation] for more details.
     */
    override fun onAnimationFinished(holder: RecyclerView.ViewHolder,
                                     @IntRange(from = 0) animationFinishedOperation: Int) {
        when (animationFinishedOperation) {
            ADD_ANIMATION_FINISHED -> dispatchAddFinished(holder)
            REMOVE_ANIMATION_FINISHED -> dispatchRemoveFinished(holder)
            CHANGE_ANIMATION_FINISHED -> {
                dispatchChangeFinished(holder, false)
                if (mCustomAnimationsMap.containsKey(holder)) {
                    mCustomAnimationsMap.remove(holder)
                }
            }
            else -> throw UnsupportedOperationException(GMLRVAConstantsVars.UNSUPPORTED_ERROR)
        }
    }

    /** {@inheritDoc}  */
    override fun endAnimation(item: RecyclerView.ViewHolder) {
        super.endAnimation(item)
        cancelCurrentAnimationIfExists(item)
    }

    /** {@inheritDoc}  */
    override fun endAnimations() {
        super.endAnimations()
        for (animatorSet in mCustomAnimationsMap.values) {
            animatorSet.cancel()
        }
    }

    /**
     * Abstract procedure meant to dispatch the intended animations whenever
     * [.animateChange] is
     * called.
     * This procedure should be implement by classes extending this Item Animator base class.
     *
     * @param holderInfo The information that was returned from
     * [.recordPreLayoutInformation].
     * @param holder the [RecyclerView] item's [RecyclerView.ViewHolder].
     * @return the resulting [AnimatorSet] for the [RecyclerView] item's [RecyclerView.ViewHolder].
     */
    abstract fun handleCustomAnimation(holderInfo: GenericAnimatedViewHolderInfo,
                                       holder: IAnimatedViewHolder): AnimatorSet?

    /**
     * Auxiliary procedure meant to allow [RecyclerView] to stop animations on its items, when they
     * disappear from the device's screen, thus being ready to be recycled.
     * @param item the [RecyclerView] item's [RecyclerView.ViewHolder].
     */
    private fun cancelCurrentAnimationIfExists(item: RecyclerView.ViewHolder) {
        if (mCustomAnimationsMap.containsKey(item)) {
            mCustomAnimationsMap[item]?.cancel()
        }
    }

}
