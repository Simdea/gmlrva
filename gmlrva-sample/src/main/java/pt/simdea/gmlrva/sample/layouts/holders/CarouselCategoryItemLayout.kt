/*
 * Copyright (c) 2017. Simdea.
 */

package pt.simdea.gmlrva.sample.layouts.holders

import android.animation.AnimatorSet
import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.paging.PagedList
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import pt.simdea.gmlrva.lib.GenericMultipleLayoutAdapter
import pt.simdea.gmlrva.lib.IGenericRecyclerViewLayout
import pt.simdea.gmlrva.lib.ViewHolder
import pt.simdea.gmlrva.lib.animation.GenericItemAnimator
import pt.simdea.gmlrva.lib.animation.helpers.GenericAnimationFinishedOperationVars.Companion.ADD_ANIMATION_FINISHED
import pt.simdea.gmlrva.lib.animation.helpers.GenericAnimationFinishedOperationVars.Companion.CHANGE_ANIMATION_FINISHED
import pt.simdea.gmlrva.lib.animation.helpers.GenericAnimationFinishedOperationVars.Companion.REMOVE_ANIMATION_FINISHED
import pt.simdea.gmlrva.lib.animation.helpers.IAnimatedViewHolder
import pt.simdea.gmlrva.lib.decoration.decorators.SimpleDividerItemDecoration
import pt.simdea.gmlrva.lib.decoration.helpers.GenericDecorationDividerPositionVars.Companion.POSITION_END
import pt.simdea.gmlrva.lib.decoration.specs.SimpleDividerItemDecorationSpec
import pt.simdea.gmlrva.lib.utilities.GenericUtils
import pt.simdea.gmlrva.sample.R
import pt.simdea.gmlrva.sample.layouts.ViewTypes

/**
 * Class representing a Carousel Category Layout meant to be used on a [GenericMultipleLayoutAdapter].
 *
 * Created by Paulo Ribeiro on 7/16/2017.
 * Simdea © All Rights Reserved.
 * paulo.ribeiro@simdea.pt
 */
class CarouselCategoryItemLayout(private val mCategoryTitle: String,
                                 private val mCategoryData: PagedList<IGenericRecyclerViewLayout<ViewHolder>>,
                                 private val mContext: Context) : IGenericRecyclerViewLayout<CarouselCategoryItemLayout.CarouselCategoryViewHolder> {

    /** {@inheritDoc}  */
    override val tag: Any
        get() = mCategoryTitle

    /** {@inheritDoc}  */
    override val viewType: Int
        get() = ViewTypes.CAROUSEL_ITEM_CATEGORY

    /** {@inheritDoc}  */
    override fun createViewHolder(parent: ViewGroup): CarouselCategoryViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.gmlrva_layout_carousel_category_item, parent, false)
        return CarouselCategoryViewHolder(view)
    }

    /** {@inheritDoc}  */
    override fun setElements(holder: CarouselCategoryViewHolder) {
        holder.getTitle().text = mCategoryTitle
        val aux = ContextCompat
                .getDrawable(holder.view.context, R.drawable.gmlrva_vertical_red_line_item_divider)
        if (aux != null) {
            loadItems(holder.getItems(), aux)
        }
    }

    /**
     * Procedure meant to load the Carousel Item Layout items, bound by this Carousel Category Layout.
     * @param items the [RecyclerView] which will hold the Carousel Item Layout items.
     * @param drawable the divider's target [Drawable] value.
     */
    private fun loadItems(items: RecyclerView, drawable: Drawable) {
        items.adapter = GenericMultipleLayoutAdapter()
        (items.adapter as GenericMultipleLayoutAdapter).submitList(mCategoryData)
        items.layoutManager = LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false)

        val spec = SimpleDividerItemDecorationSpec.DecorationSpecBuilder()
                .withDrawableDivider(drawable)
                .withDividerPosition(POSITION_END)
                .buildDecorationSpec()
        items.addItemDecoration(SimpleDividerItemDecoration(spec))

        GenericUtils.setOptimalConfigurationForRecyclerView(items)
    }

    /** Class meant to define the [RecyclerView.ViewHolder] for a Carousel Category Layout instance.  */
    inner class CarouselCategoryViewHolder(var view: View) : ViewHolder(view), IAnimatedViewHolder {

        private lateinit var mTitle: TextView
        private lateinit var mItems: RecyclerView

        init {
            bindViews(view)
        }

        fun getTitle(): TextView = mTitle

        fun getItems(): RecyclerView = mItems

        /** {@inheritDoc}  */
        override fun recycle() {
            mTitle.text = null
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

        /**
         * Procedure meant to bind this [RecyclerView.ViewHolder]'s views.
         * @param view this [CarouselCategoryViewHolder]'s root view.
         */
        private fun bindViews(view: View) {
            mTitle = view.findViewById(R.id.tvCarouselCategoryItemTitle)
            mItems = view.findViewById(R.id.rvCarouselCategoryItemData)
        }

    }

}
