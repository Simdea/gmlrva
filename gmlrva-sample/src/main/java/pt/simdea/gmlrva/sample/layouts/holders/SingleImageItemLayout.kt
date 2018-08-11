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
import pt.simdea.gmlrva.lib.ViewHolder
import pt.simdea.gmlrva.lib.animation.GenericItemAnimator
import pt.simdea.gmlrva.lib.animation.helpers.GenericAnimationFinishedOperation
import pt.simdea.gmlrva.lib.animation.helpers.GenericAnimationFinishedOperationVars
import pt.simdea.gmlrva.lib.animation.helpers.IAnimatedViewHolder
import pt.simdea.gmlrva.lib.utilities.GMLRVAConstants
import pt.simdea.gmlrva.lib.utilities.GMLRVAConstantsVars
import pt.simdea.gmlrva.sample.R
import pt.simdea.gmlrva.sample.data.ClickListener
import pt.simdea.gmlrva.sample.layouts.ViewTypes
import pt.simdea.gmlrva.sample.layouts.animation.ViewHolderAnimationHelper

/**
 * Class representing a Single Image Layout meant to be used on a [GenericMultipleLayoutAdapter].
 *
 * Created by Paulo Ribeiro on 7/16/2017.
 * Simdea © All Rights Reserved.
 * paulo.ribeiro@simdea.pt
 */
@AllArgsConstructor
class SingleImageItemLayout(
        @IntRange(from = 0) private val mCoverResource: Int = 0
) : IGenericRecyclerViewLayout<SingleImageItemLayout.SingleImageItemViewHolder> {


    /** {@inheritDoc}  */
    override val tag: Any
        get() = mCoverResource

    /** {@inheritDoc}  */
    override val viewType: Int
        get() = ViewTypes.SINGLE_IMAGE_ITEM

    /** {@inheritDoc}  */
    override fun createViewHolder(parent: ViewGroup): SingleImageItemViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.gmlrva_layout_generic_single_image_item, parent, false)
        return SingleImageItemViewHolder(view)
    }

    /** {@inheritDoc}  */
    override fun setElements(holder: SingleImageItemViewHolder) {
        holder.mCover.setImageResource(mCoverResource)
    }

    /** Class meant to define the [RecyclerView.ViewHolder] for a Single Image Layout instance.  */
    inner class SingleImageItemViewHolder(val view: View) : ViewHolder(view), IAnimatedViewHolder {

        internal lateinit var mCover: ImageView

        init {
            bindViews(view)
        }

        /** {@inheritDoc}  */
        override fun recycle() {
            mCover.setImageDrawable(null)
        }

        /** {@inheritDoc}  */
        override fun runAddAnimation(listener: GenericItemAnimator) {
            ViewHolderAnimationHelper.runTestAddAnimation(this, view, listener)
        }

        /** {@inheritDoc}  */
        override fun runRemoveAnimation(listener: GenericItemAnimator) {
            ViewHolderAnimationHelper.runTestRemoveAnimation(this, view, listener)
        }

        /** {@inheritDoc}  */
        override fun runChangeAnimation(listener: GenericItemAnimator): AnimatorSet? {
            listener.onAnimationFinished(this, GenericAnimationFinishedOperationVars.CHANGE_ANIMATION_FINISHED)
            return null
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
