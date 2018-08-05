/*
 * Copyright (c) 2017. Simdea.
 */

package pt.simdea.gmlrva.sample.layouts.holders

import android.animation.AnimatorSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.annotation.IntRange
import androidx.recyclerview.widget.RecyclerView
import lombok.AllArgsConstructor
import lombok.Getter
import pt.simdea.gmlrva.lib.GenericMultipleLayoutAdapter
import pt.simdea.gmlrva.lib.IGenericRecyclerViewLayout
import pt.simdea.gmlrva.lib.IViewHolder
import pt.simdea.gmlrva.lib.animation.GenericItemAnimator
import pt.simdea.gmlrva.lib.animation.helpers.GenericAnimationFinishedOperation
import pt.simdea.gmlrva.lib.animation.helpers.IAnimatedViewHolder
import pt.simdea.gmlrva.lib.utilities.GMLRVAConstants
import pt.simdea.gmlrva.sample.R
import pt.simdea.gmlrva.sample.data.ClickListener
import pt.simdea.gmlrva.sample.layouts.animation.ViewHolderAnimationHelper

/**
 * Class representing a Single Image Layout meant to be used on a [GenericMultipleLayoutAdapter].
 *
 * Created by Paulo Ribeiro on 7/16/2017.
 * Simdea © All Rights Reserved.
 * paulo.ribeiro@simdea.pt
 */
@AllArgsConstructor
class SingleImageItemLayout : IGenericRecyclerViewLayout<SingleImageItemLayout.SingleImageItemViewHolder> {

    @IntRange(from = 0)
    private val mCoverResource: Int = 0
    protected val mListener: ClickListener? = null

    /** {@inheritDoc}  */
    override val tag: Any
        get() = mCoverResource

    /** {@inheritDoc}  */
    override val viewType: Int
        get() = GenericRecyclerViewLayoutTypes.SINGLE_IMAGE_ITEM

    /** {@inheritDoc}  */
    override fun createViewHolder(parent: ViewGroup): SingleImageItemViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.gmlrva_layout_generic_single_image_item, parent, false)
        return SingleImageItemViewHolder(view)
    }

    /** {@inheritDoc}  */
    override fun setElements(holder: SingleImageItemViewHolder) {
        holder.getCover().setImageResource(mCoverResource)
    }

    /** Class meant to define the [RecyclerView.ViewHolder] for a Single Image Layout instance.  */
    internal inner class SingleImageItemViewHolder
    /**
     * Instantiates a new SingleImageItemViewHolder.
     * @param view this [RecyclerView.ViewHolder]'s root view.
     */
    (view: View) : RecyclerView.ViewHolder(view), View.OnClickListener, IAnimatedViewHolder, IViewHolder {

        @Getter
        private var mCover: ImageView? = null

        init {
            bindViews(view)
            bindListeners()
        }

        /** {@inheritDoc}  */
        override fun recycle() {
            mCover!!.setImageDrawable(null)
        }

        /** {@inheritDoc}  */
        override fun runAddAnimation(listener: GenericItemAnimator) {
            ViewHolderAnimationHelper.runTestAddAnimation(this, itemView, listener)
        }

        /** {@inheritDoc}  */
        override fun runRemoveAnimation(listener: GenericItemAnimator) {
            ViewHolderAnimationHelper.runTestRemoveAnimation(this, itemView, listener)
        }

        /** {@inheritDoc}  */
        override fun runChangeAnimation(listener: GenericItemAnimator): AnimatorSet? {
            listener.onAnimationFinished(this, GenericAnimationFinishedOperation.CHANGE_ANIMATION_FINISHED)
            return null
        }

        /** {@inheritDoc}  */
        override fun onClick(v: View) {
            val viewId = v.id
            if (viewId == mCover!!.id) {
                handleCoverClick()
            } else {
                throw UnsupportedOperationException(GMLRVAConstants.Companion.getUNSUPPORTED_ERROR())
            }
        }

        /** Procedure meant to handle a Single Image Layout click action.  */
        private fun handleCoverClick() {
            Toast.makeText(itemView.context, "Cover Click!", Toast.LENGTH_SHORT).show()
            mListener?.onClick()
        }

        /** Procedure meant to bind this [RecyclerView.ViewHolder]'s listeners.  */
        private fun bindListeners() {
            mCover!!.setOnClickListener(this)
        }

        /**
         * Procedure meant to bind this [RecyclerView.ViewHolder]'s views.
         * @param view this [SingleImageItemViewHolder]'s root view.
         */
        private fun bindViews(view: View) {
            mCover = view.findViewById(R.id.ivSingleImageItemLayoutCover)
        }

    }

}
