/*
 * Copyright (c) 2017. Simdea.
 */

package pt.simdea.gmlrva.sample.layouts.holders

import android.animation.AnimatorSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
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
 * Class representing a Single Text Layout meant to be used on a [GenericMultipleLayoutAdapter].
 *
 * Created by Paulo Ribeiro on 10/6/2017.
 * Simdea © All Rights Reserved.
 * paulo.ribeiro@simdea.pt
 */
@AllArgsConstructor
class SingleTextItemLayout : IGenericRecyclerViewLayout<SingleTextItemLayout.SingleTextItemViewHolder> {

    private val mTextResource: String? = null
    protected val mListener: ClickListener? = null

    /** {@inheritDoc}  */
    override val tag: Any
        get() = mTextResource

    /** {@inheritDoc}  */
    override val viewType: Int
        get() = GenericRecyclerViewLayoutTypes.SINGLE_TEXT_ITEM

    /** {@inheritDoc}  */
    override fun createViewHolder(parent: ViewGroup): SingleTextItemViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.gmlrva_layout_generic_single_text_item, parent, false)
        return SingleTextItemViewHolder(view)
    }

    /** {@inheritDoc}  */
    override fun setElements(holder: SingleTextItemViewHolder) {
        holder.getTitle().setText(mTextResource)
    }

    /** Class meant to define the [RecyclerView.ViewHolder] for a Single Text Layout instance.  */
    internal inner class SingleTextItemViewHolder
    /**
     * Instantiates a new SingleTextItemViewHolder.
     * @param view this [RecyclerView.ViewHolder]'s root view.
     */
    (view: View) : RecyclerView.ViewHolder(view), IAnimatedViewHolder, View.OnClickListener, IViewHolder {

        @Getter
        private var mTitle: TextView? = null

        init {
            bindViews(view)
            bindListeners()
        }

        /** {@inheritDoc}  */
        override fun recycle() {
            mTitle!!.text = null
        }

        /** {@inheritDoc}  */
        override fun runAddAnimation(listener: GenericItemAnimator) {
            ViewHolderAnimationHelper.runTestAddAnimation(this, itemView, listener)
            //            listener.onAnimationFinished(this, ADD_ANIMATION_FINISHED)
        }

        /** {@inheritDoc}  */
        override fun runRemoveAnimation(listener: GenericItemAnimator) {
            listener.onAnimationFinished(this, GenericAnimationFinishedOperation.REMOVE_ANIMATION_FINISHED)
        }

        /** {@inheritDoc}  */
        override fun runChangeAnimation(listener: GenericItemAnimator): AnimatorSet? {
            return ViewHolderAnimationHelper.runTestChangeAnimation(this, mTitle!!, listener)
        }

        /** {@inheritDoc}  */
        override fun onClick(v: View) {
            val viewId = v.id
            if (viewId == mTitle!!.id) {
                handleTitleClick()
            } else {
                throw UnsupportedOperationException(GMLRVAConstants.Companion.getUNSUPPORTED_ERROR())
            }
        }

        /** Procedure meant to handle a Single Text Layout click action.  */
        private fun handleTitleClick() {
            Toast.makeText(itemView.context, "Title Click!", Toast.LENGTH_SHORT).show()
            mListener?.onClick()
        }

        /** Procedure meant to bind this [RecyclerView.ViewHolder]'s listeners.  */
        private fun bindListeners() {
            mTitle!!.setOnClickListener(this)
        }

        /**
         * Procedure meant to bind this [RecyclerView.ViewHolder]'s views.
         * @param view this [SingleTextItemViewHolder]'s root view.
         */
        private fun bindViews(view: View) {
            mTitle = view.findViewById(R.id.tvSingleTextItemLayoutTitle)
        }

    }

}
