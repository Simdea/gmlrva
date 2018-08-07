/*
 * Copyright (c) 2017. Simdea.
 */

package pt.simdea.gmlrva.sample.layouts.holders

import android.animation.AnimatorSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.IntRange
import androidx.recyclerview.widget.RecyclerView
import pt.simdea.gmlrva.lib.GenericMultipleLayoutAdapter
import pt.simdea.gmlrva.lib.IGenericRecyclerViewLayout
import pt.simdea.gmlrva.lib.ViewHolder
import pt.simdea.gmlrva.lib.animation.GenericItemAnimator
import pt.simdea.gmlrva.lib.animation.helpers.GenericAnimationFinishedOperationVars.Companion.ADD_ANIMATION_FINISHED
import pt.simdea.gmlrva.lib.animation.helpers.GenericAnimationFinishedOperationVars.Companion.CHANGE_ANIMATION_FINISHED
import pt.simdea.gmlrva.lib.animation.helpers.GenericAnimationFinishedOperationVars.Companion.REMOVE_ANIMATION_FINISHED
import pt.simdea.gmlrva.lib.animation.helpers.IAnimatedViewHolder
import pt.simdea.gmlrva.lib.utilities.GMLRVAConstantsVars
import pt.simdea.gmlrva.sample.R
import pt.simdea.gmlrva.sample.layouts.ViewTypes

/**
 * Class representing a Carousel Item Layout meant to be used on a [GenericMultipleLayoutAdapter].
 *
 * Created by Paulo Ribeiro on 7/16/2017.
 * Simdea © All Rights Reserved.
 * paulo.ribeiro@simdea.pt
 */
class CarouselItemLayout(
        private val mTitle: String,
        private val mDescription: String,
        @IntRange(from = 0) private val mCoverResource: Int
) : IGenericRecyclerViewLayout<CarouselItemLayout.CarouselItemViewHolder> {


    /** {@inheritDoc}  */
    override val tag: Any
        get() = mTitle

    /** {@inheritDoc}  */
    override val viewType: Int
        get() = ViewTypes.CAROUSEL_ITEM

    /** {@inheritDoc}  */
    override fun createViewHolder(parent: ViewGroup): CarouselItemViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.gmlrva_layout_carousel_item, parent, false)
        return CarouselItemViewHolder(view)
    }

    /** {@inheritDoc}  */
    override fun setElements(holder: CarouselItemViewHolder) {
        holder.mTitle.text = mTitle
        holder.mDescription.text = mDescription
        holder.mCover.setImageResource(mCoverResource)
    }

    /** Class meant to define the [RecyclerView.ViewHolder] for a Carousel Item Layout instance.  */
    inner class CarouselItemViewHolder(val view: View) : ViewHolder(view), IAnimatedViewHolder, View.OnClickListener {

        internal lateinit var mTitle: TextView
        internal lateinit var mDescription: TextView
        internal lateinit var mCover: ImageView

        init {
            bindViews(view)
            bindListeners()
        }

        /** {@inheritDoc}  */
        override fun recycle() {
            mTitle!!.text = null
            mDescription!!.text = null
            mCover!!.setImageDrawable(null)
        }

        /** {@inheritDoc}  */
        override fun runAddAnimation(listener: GenericItemAnimator) {
            listener.onAnimationFinished(this, ADD_ANIMATION_FINISHED)
        }

        /** {@inheritDoc}  */
        override fun runRemoveAnimation(listener: GenericItemAnimator) {
            listener.onAnimationFinished(this, REMOVE_ANIMATION_FINISHED)
        }

        /** {@inheritDoc}  */
        override fun runChangeAnimation(listener: GenericItemAnimator): AnimatorSet? {
            listener.onAnimationFinished(this, CHANGE_ANIMATION_FINISHED)
            return null
        }

        /** {@inheritDoc}  */
        override fun onClick(v: View) {
            val viewId = v.id
            if (viewId == mTitle!!.id) {
                handleTitleClick()
            } else if (viewId == mDescription!!.id) {
                handleDescriptionClick()
            } else if (viewId == mCover!!.id) {
                handleCoverClick()
            } else {
                throw UnsupportedOperationException(GMLRVAConstantsVars.UNSUPPORTED_ERROR)
            }
        }

        /** Procedure meant to handle a Cover view Carousel Item Layout click action.  */
        private fun handleCoverClick() {
            Toast.makeText(view.context, "Cover Click!", Toast.LENGTH_SHORT).show()
        }

        /** Procedure meant to handle a Description view Carousel Item Layout click action.  */
        private fun handleDescriptionClick() {
            Toast.makeText(view.context, "Description Click!", Toast.LENGTH_SHORT).show()
        }

        /** Procedure meant to handle a Title view Carousel Item Layout click action.  */
        private fun handleTitleClick() {
            Toast.makeText(view.context, "Title Click!", Toast.LENGTH_SHORT).show()
        }

        /** Procedure meant to bind this [RecyclerView.ViewHolder]'s listeners.  */
        private fun bindListeners() {
            val clickableViews = arrayOf<View>(mTitle, mCover, mDescription)
            for (view in clickableViews) {
                view.setOnClickListener(this)
            }
        }

        /**
         * Procedure meant to bind this [RecyclerView.ViewHolder]'s views.
         * @param view this [CarouselItemViewHolder]'s root view.
         */
        private fun bindViews(view: View) {
            mTitle = view.findViewById(R.id.tvCarouselItemTitle)
            mDescription = view.findViewById(R.id.tvCarouselItemDescription)
            mCover = view.findViewById(R.id.ivCarouselItemCover)
        }

    }

}
