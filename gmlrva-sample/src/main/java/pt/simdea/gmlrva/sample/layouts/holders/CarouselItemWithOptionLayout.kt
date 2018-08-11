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
import pt.simdea.gmlrva.lib.utilities.GMLRVAConstantsVars
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
        get() = ViewTypes.CAROUSEL_ITEM_WITH_OPTIONS

    /** {@inheritDoc}  */
    override fun createViewHolder(parent: ViewGroup): CarouselItemWithOptionViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.gmlrva_layout_carousel_item_option, parent, false)
        return CarouselItemWithOptionViewHolder(view)
    }

    /** {@inheritDoc}  */
    override fun setElements(holder: CarouselItemWithOptionViewHolder) {
        holder.mTitle.text = mTitle
        holder.mDescription.text = mDescription
        holder.mCover.setImageResource(mCoverResource)
    }

    /** Class meant to define the [RecyclerView.ViewHolder] for a Carousel Item Layout instance.  */
    inner class CarouselItemWithOptionViewHolder(val view: View) : ViewHolder(view), IAnimatedViewHolder, View.OnClickListener {

        internal lateinit var mTitle: TextView
        internal lateinit var mDescription: TextView
        internal lateinit var mCover: ImageView
        internal lateinit var mOption: ImageView
        internal lateinit var mOptionSection: RelativeLayout
        internal lateinit var mLeftOption: View
        internal lateinit var mRightOption: View

        init {
            bindViews(view)
            bindListeners()
        }

        /** {@inheritDoc}  */
        override fun recycle() {
            mTitle.text = null
            mDescription.text = null
            mCover.setImageDrawable(null)
            mOption.setImageDrawable(null)
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
            when (viewId) {
                mTitle.id -> handleTitleClick()
                mDescription.id -> handleDescriptionClick()
                mCover.id -> handleCoverClick()
                mOption.id -> handleOptionClick()
                mLeftOption.id -> handleLeftOptionClick()
                mRightOption.id -> handleRightOptionClick()
                else -> throw UnsupportedOperationException(GMLRVAConstantsVars.UNSUPPORTED_ERROR)
            }
        }

        /** Procedure meant to handle a Left Option view Carousel Item Layout click action.  */
        private fun handleLeftOptionClick() {
            Toast.makeText(view.context, "Left Option selected!", Toast.LENGTH_SHORT).show()
            handleOptionClick()
        }

        /** Procedure meant to handle a Right Option view Carousel Item Layout click action.  */
        private fun handleRightOptionClick() {
            Toast.makeText(view.context, "Right Option selected!", Toast.LENGTH_SHORT).show()
            handleOptionClick()
        }

        /** Procedure meant to handle an Option view Carousel Item Layout click action.  */
        private fun handleOptionClick() {
            if (mOptionSection.visibility == View.GONE) {
                mOptionSection.visibility = View.VISIBLE
            } else {
                mOptionSection.visibility = View.GONE
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
            val clickableViews = arrayOf(mTitle, mCover, mDescription, mOption, mLeftOption, mRightOption)
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
