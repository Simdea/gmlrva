/*
 * Copyright (c) 2017. Simdea.
 */

package pt.simdea.gmlrva.sample.layouts.holders

import android.animation.AnimatorSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
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
import pt.simdea.gmlrva.lib.utilities.GMLRVAConstants
import pt.simdea.gmlrva.sample.R
import pt.simdea.gmlrva.sample.layouts.ViewTypes

/**
 * Class representing a Carousel Item Layout meant to be used on a [GenericMultipleLayoutAdapter].
 *
 * Created by Paulo Ribeiro on 9/14/2017.
 * Simdea © All Rights Reserved.
 * paulo.ribeiro@simdea.pt
 */
class CarouselItemWithOptionLayout(
        private val mTitle: String,
        private val mDescription: String,
        @IntRange(from = 0) private val mCoverResource: Int
) : IGenericRecyclerViewLayout<CarouselItemWithOptionLayout.CarouselItemWithOptionViewHolder> {

    /** {@inheritDoc}  */
    override val tag: Any
        get() = mTitle

    /** {@inheritDoc}  */
    override val viewType: Int
        get() = ViewTypes.GenericRecyclerViewLayoutTypes.CAROUSEL_ITEM_WITH_OPTIONS

    /** {@inheritDoc}  */
    override fun createViewHolder(parent: ViewGroup): CarouselItemWithOptionViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.gmlrva_layout_carousel_item_option, parent, false)
        return CarouselItemWithOptionViewHolder(view)
    }

    /** {@inheritDoc}  */
    override fun setElements(holder: CarouselItemWithOptionViewHolder) {
        holder.getTitle().setText(mTitle)
        holder.getDescription().setText(mDescription)
        holder.getCover().setImageResource(mCoverResource)
    }

    /** Class meant to define the [RecyclerView.ViewHolder] for a Carousel Item Layout instance.  */
    public inner class CarouselItemWithOptionViewHolder(val view: View) : ViewHolder(view), IAnimatedViewHolder, View.OnClickListener {

        internal var mTitle: TextView? = null
        internal var mDescription: TextView? = null
        internal var mCover: ImageView? = null
        internal var mOption: ImageView? = null
        internal var mOptionSection: RelativeLayout? = null
        internal var mLeftOption: View? = null
        internal var mRightOption: View? = null

        init {
            bindViews(view)
            bindListeners()
        }

        /** {@inheritDoc}  */
        override fun recycle() {
            mTitle!!.text = null
            mDescription!!.text = null
            mCover!!.setImageDrawable(null)
            mOption!!.setImageDrawable(null)
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
            } else if (viewId == mOption!!.id) {
                handleOptionClick()
            } else if (viewId == mLeftOption!!.id) {
                handleLeftOptionClick()
            } else if (viewId == mRightOption!!.id) {
                handleRightOptionClick()
            } else {
                throw UnsupportedOperationException(GMLRVAConstants.Companion.getUNSUPPORTED_ERROR())
            }
        }

        /** Procedure meant to handle a Left Option view Carousel Item Layout click action.  */
        private fun handleLeftOptionClick() {
            Toast.makeText(itemView.context, "Left Option selected!", Toast.LENGTH_SHORT).show()
            handleOptionClick()
        }

        /** Procedure meant to handle a Right Option view Carousel Item Layout click action.  */
        private fun handleRightOptionClick() {
            Toast.makeText(itemView.context, "Right Option selected!", Toast.LENGTH_SHORT).show()
            handleOptionClick()
        }

        /** Procedure meant to handle an Option view Carousel Item Layout click action.  */
        private fun handleOptionClick() {
            if (mOptionSection!!.visibility == View.GONE) {
                mOptionSection!!.visibility = View.VISIBLE
            } else {
                mOptionSection!!.visibility = View.GONE
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
            val clickableViews = arrayOf<View>(mTitle, mCover, mDescription, mOption, mLeftOption, mRightOption)
            for (view in clickableViews) {
                view.setOnClickListener(this)
            }
        }

        /**
         * Procedure meant to bind this [RecyclerView.ViewHolder]'s views.
         * @param view this [CarouselItemWithOptionViewHolder]'s root view.
         */
        private fun bindViews(view: View) {
            mTitle = view.findViewById(R.id.tvCarouselItemTitle)
            mDescription = view.findViewById(R.id.tvCarouselItemDescription)
            mCover = view.findViewById(R.id.ivCarouselItemCover)
            mOption = view.findViewById(R.id.ivCarouselItemOption)
            mOptionSection = view.findViewById(R.id.rlOptionSection)
            mLeftOption = view.findViewById(R.id.vOptionsSectionLeft)
            mRightOption = view.findViewById(R.id.vOptionsSectionRight)
        }

    }

}
