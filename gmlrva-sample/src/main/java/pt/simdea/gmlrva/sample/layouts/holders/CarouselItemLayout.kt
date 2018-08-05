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

/**
 * Class representing a Carousel Item Layout meant to be used on a [GenericMultipleLayoutAdapter].
 *
 * Created by Paulo Ribeiro on 7/16/2017.
 * Simdea © All Rights Reserved.
 * paulo.ribeiro@simdea.pt
 */
@AllArgsConstructor
class CarouselItemLayout : IGenericRecyclerViewLayout<CarouselItemLayout.CarouselItemViewHolder> {

    private val mTitle: String? = null
    private val mDescription: String? = null
    @IntRange(from = 0)
    private val mCoverResource: Int = 0

    /** {@inheritDoc}  */
    override val tag: Any
        get() = mTitle

    /** {@inheritDoc}  */
    override val viewType: Int
        get() = GenericRecyclerViewLayoutTypes.CAROUSEL_ITEM

    /** {@inheritDoc}  */
    override fun createViewHolder(parent: ViewGroup): CarouselItemViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.gmlrva_layout_carousel_item, parent, false)
        return CarouselItemViewHolder(view)
    }

    /** {@inheritDoc}  */
    override fun setElements(holder: CarouselItemViewHolder) {
        holder.getTitle().setText(mTitle)
        holder.getDescription().setText(mDescription)
        holder.getCover().setImageResource(mCoverResource)
    }

    /** Class meant to define the [RecyclerView.ViewHolder] for a Carousel Item Layout instance.  */
    internal inner class CarouselItemViewHolder
    /**
     * Instantiates a new CarouselItemViewHolder.
     * @param view this [RecyclerView.ViewHolder]'s root view.
     */
    (view: View) : RecyclerView.ViewHolder(view), IAnimatedViewHolder, View.OnClickListener, IViewHolder {

        @Getter
        private var mTitle: TextView? = null
        @Getter
        private var mDescription: TextView? = null
        @Getter
        private var mCover: ImageView? = null

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
            listener.onAnimationFinished(this, GenericAnimationFinishedOperation.ADD_ANIMATION_FINISHED)
        }

        /** {@inheritDoc}  */
        override fun runRemoveAnimation(listener: GenericItemAnimator) {
            listener.onAnimationFinished(this, GenericAnimationFinishedOperation.REMOVE_ANIMATION_FINISHED)
        }

        /** {@inheritDoc}  */
        override fun runChangeAnimation(listener: GenericItemAnimator): AnimatorSet? {
            listener.onAnimationFinished(this, GenericAnimationFinishedOperation.CHANGE_ANIMATION_FINISHED)
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
                throw UnsupportedOperationException(GMLRVAConstants.Companion.getUNSUPPORTED_ERROR())
            }
        }

        /** Procedure meant to handle a Cover view Carousel Item Layout click action.  */
        private fun handleCoverClick() {
            Toast.makeText(itemView.context, "Cover Click!", Toast.LENGTH_SHORT).show()
        }

        /** Procedure meant to handle a Description view Carousel Item Layout click action.  */
        private fun handleDescriptionClick() {
            Toast.makeText(itemView.context, "Description Click!", Toast.LENGTH_SHORT).show()
        }

        /** Procedure meant to handle a Title view Carousel Item Layout click action.  */
        private fun handleTitleClick() {
            Toast.makeText(itemView.context, "Title Click!", Toast.LENGTH_SHORT).show()
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
