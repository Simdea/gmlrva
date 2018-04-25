/*
 * Copyright (c) 2017. Simdea.
 */

package pt.simdea.gmlrva.sample.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;

import java.util.ArrayList;
import java.util.List;

import pt.simdea.gmlrva.lib.GenericMultipleLayoutAdapter;
import pt.simdea.gmlrva.lib.IGenericRecyclerViewLayout;
import pt.simdea.gmlrva.lib.animation.animators.ExampleItemAnimator;
import pt.simdea.gmlrva.lib.decoration.decorators.SimpleDividerItemDecoration;
import pt.simdea.gmlrva.lib.decoration.helpers.GenericDecorationDividerPosition;
import pt.simdea.gmlrva.lib.decoration.specs.SimpleDividerItemDecorationSpec;
import pt.simdea.gmlrva.lib.utilities.GenericUtils;
import pt.simdea.gmlrva.sample.R;
import pt.simdea.gmlrva.sample.data.ClickListener;
import pt.simdea.gmlrva.sample.data.FakeDataObject;
import pt.simdea.gmlrva.sample.data.FakeDataProvider;
import pt.simdea.gmlrva.sample.layouts.holders.CarouselCategoryItemLayout;
import pt.simdea.gmlrva.sample.layouts.holders.CarouselCategoryItemWithOptionLayout;
import pt.simdea.gmlrva.sample.layouts.holders.CarouselItemLayout;
import pt.simdea.gmlrva.sample.layouts.holders.CarouselItemWithOptionLayout;
import pt.simdea.gmlrva.sample.layouts.holders.SingleImageItemLayout;
import pt.simdea.gmlrva.sample.layouts.holders.SingleTextItemLayout;

import static pt.simdea.gmlrva.sample.layouts.animation.ChangeAnimationTypes.ROTATION_TRIGGER;

/**
 * Class responsible for the Sample Screen for the (GMLRVA) library.
 *
 * Created by Paulo Ribeiro on 7/16/2017.
 * Simdea © All Rights Reserved.
 * paulo.ribeiro@simdea.pt
 */
@SuppressWarnings({"unchecked", "SameParameterValue"})
public class SampleActivity extends AppCompatActivity
        implements ClickListener {

    private final FakeDataProvider mDataProvider = new FakeDataProvider();

    private RecyclerView mGenericTest;
    private List<CarouselItemWithOptionLayout> mCarouselItemDataWithOptions = new ArrayList<>();

    /**
     * Starter procedure for SampleActivity.
     * @param context the application's current context.
     */
    public static void start(@NonNull final Context context) {
        final Intent starter = new Intent(context, SampleActivity.class);
        context.startActivity(starter);
    }

    /**
     * Called when SampleActivity is first created.
     * @param savedInstanceState Bundle object containing the activity's previously saved state.
     */
    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gmlrva_activity_sample);
    }

    /** Called when the activity is about to become visible. */
    @Override
    protected void onStart() {
        super.onStart();
        bindSampleActivityViews();
    }

    /** Called when the activity has become visible. */
    @Override
    protected void onResume() {
        super.onResume();
        if (mGenericTest != null) {
            mGenericTest.setAdapter(new GenericMultipleLayoutAdapter(buildGenericListExample(), this, false));
            mGenericTest.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

            final float thickness
                    = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 3, getResources().getDisplayMetrics());
            final SimpleDividerItemDecorationSpec spec = new SimpleDividerItemDecorationSpec.DecorationSpecBuilder()
                    .withTopSpacing(25)
                    .withBottomSpacing(25)
                    .withStartSpacing(10)
                    .withEndSpacing(10)
//                    .withDrawableDivider(ContextCompat.getDrawable(this, R.drawable.gmlrva_red_line_item_divider))
                    .withDividerPosition(GenericDecorationDividerPosition.POSITION_TOP_BOTTOM)
                    .withDrawnDivider(ContextCompat.getColor(this, R.color.gmlrvaColorAccent), thickness,
                            Paint.Style.STROKE, new DashPathEffect(new float[]{5, 10}, 10))
//                    .withDrawnDivider(ContextCompat.getColor(this, R.color.gmlrvaColorAccent), thickness, null, null)
                    .buildDecorationSpec();
            mGenericTest.addItemDecoration(new SimpleDividerItemDecoration(spec));

            GenericUtils.setOptimalConfigurationForRecyclerView(mGenericTest);
            mGenericTest.setItemAnimator(new ExampleItemAnimator());
        }
    }

    /** {@inheritDoc} */
    @Override
    public void onClick() {
        if (mGenericTest != null) {
//            rebuildGenericListExample()
            final GenericMultipleLayoutAdapter adapter = (GenericMultipleLayoutAdapter) mGenericTest.getAdapter();
            final IGenericRecyclerViewLayout item = adapter.get(1);
            if (item != null) {
                adapter.updateItem(item, ROTATION_TRIGGER);
            }
        }
    }

    /** Procedure meant to rebuild the existing data list. */
    @SuppressWarnings("unused")
    private void rebuildGenericListExample() {
        final List<IGenericRecyclerViewLayout> exampleHolders = new ArrayList<>();

        /* Add a Single Image Item Example */
        final SingleImageItemLayout singleItemLayout = new SingleImageItemLayout(R.mipmap.gmlrva_ic_launcher, this);
        exampleHolders.add(singleItemLayout);

        /* Add a Carousel (Category + List with options) Item Example */
        mCarouselItemDataWithOptions = buildCarouselItemWithOptionsData(20);
        final CarouselCategoryItemWithOptionLayout carouselCategoryItemWithOptionsLayout
                = new CarouselCategoryItemWithOptionLayout("Carousel Title With Option",
                mCarouselItemDataWithOptions, this);
        exampleHolders.add(carouselCategoryItemWithOptionsLayout);

        /* Add a Single Text Item Example */
        final SingleTextItemLayout singleTextItemLayout
                = new SingleTextItemLayout(getString(R.string.gmlrva_app_name), this);
        exampleHolders.add(singleTextItemLayout);

        final GenericMultipleLayoutAdapter adapter = (GenericMultipleLayoutAdapter) mGenericTest.getAdapter();
        adapter.updateList(exampleHolders);
    }

    /**
     * Procedure meant to build the Sample List, showcasing multiple layout types manage by the same
     * {@link RecyclerView.Adapter} instance.
     * @return the intended Sample List.
     */
    private List<IGenericRecyclerViewLayout> buildGenericListExample() {
        final List<IGenericRecyclerViewLayout> exampleHolders = new ArrayList<>();

        /* Add a Single Image Item Example */
        final SingleImageItemLayout singleItemLayout = new SingleImageItemLayout(R.mipmap.gmlrva_ic_launcher, this);
        exampleHolders.add(singleItemLayout);

        /* Add a Single Text Item Example */
        final SingleTextItemLayout singleTextItemLayout
                = new SingleTextItemLayout(getString(R.string.gmlrva_app_name), this);
        exampleHolders.add(singleTextItemLayout);

        /* Add a Carousel (Category + List) Item Example */
        final List<IGenericRecyclerViewLayout> mCarouselItemData = buildCarouselItemData(10);
        final CarouselCategoryItemLayout carouselCategoryItemLayout
                = new CarouselCategoryItemLayout("Carousel Title", mCarouselItemData, this);
        exampleHolders.add(carouselCategoryItemLayout);

        /* Add a Carousel (Category + List with options) Item Example */
        mCarouselItemDataWithOptions = buildCarouselItemWithOptionsData(10);
        final CarouselCategoryItemWithOptionLayout carouselCategoryItemWithOptionsLayout
                = new CarouselCategoryItemWithOptionLayout("Carousel Title With Option",
                mCarouselItemDataWithOptions, this);
        exampleHolders.add(carouselCategoryItemWithOptionsLayout);

        /* Add a Single Image Item Example */
        final SingleImageItemLayout singleItemLayout3 = new SingleImageItemLayout(R.mipmap.gmlrva_ic_launcher, this);
        exampleHolders.add(singleItemLayout3);

        /* Add a Single Image Item Example */
        final SingleImageItemLayout singleItemLayout4 = new SingleImageItemLayout(R.mipmap.gmlrva_ic_launcher, this);
        exampleHolders.add(singleItemLayout4);

        /* Add a Single Image Item Example */
        final SingleImageItemLayout singleItemLayout5 = new SingleImageItemLayout(R.mipmap.gmlrva_ic_launcher, this);
        exampleHolders.add(singleItemLayout5);

        /* Add a Single Image Item Example */
        final SingleImageItemLayout singleItemLayout6 = new SingleImageItemLayout(R.mipmap.gmlrva_ic_launcher, this);
        exampleHolders.add(singleItemLayout6);

        return exampleHolders;
    }

    /**
     * Auxiliary procedure meant to build the Carousel item list sample for the Carousel example present in this
     * activity's Sample List.
     * @param maxItemNumber the maximum number of carousel items.
     * @return the intended Carousel item list.
     */
    private List<IGenericRecyclerViewLayout> buildCarouselItemData(@IntRange(from = 0) final int maxItemNumber) {
        final List<IGenericRecyclerViewLayout> carouselItemData = new ArrayList<>();

        String title;
        String description;
        final int resource = R.mipmap.gmlrva_ic_launcher_round;
        FakeDataObject item;
        for (int i = 0; i < maxItemNumber; i++) {
            item = mDataProvider.provideFakeData();
            title = item.getTitle();
            description = item.getDescription();
            carouselItemData.add(new CarouselItemLayout(title, description, resource));
        }

        return carouselItemData;
    }

    /**
     * Auxiliary procedure meant to build the Carousel item list with options sample for the Carousel example present
     * in this activity's Sample List.
     * @param maxItemNumber the maximum number of carousel items.
     * @return the intended Carousel item list.
     */
    private List<CarouselItemWithOptionLayout> buildCarouselItemWithOptionsData(@IntRange(from = 0) final int maxItemNumber) {
        final List<CarouselItemWithOptionLayout> carouselItemData = new ArrayList<>();

        String title;
        String description;
        final int resource = R.mipmap.gmlrva_ic_launcher_round;
        FakeDataObject item;
        for (int i = 0; i < maxItemNumber; i++) {
            item = mDataProvider.provideFakeData();
            title = item.getTitle();
            description = item.getDescription();
            carouselItemData.add(new CarouselItemWithOptionLayout(title, description, resource));
        }

        return carouselItemData;
    }

    /** Procedure meant to bind this activity's views. */
    private void bindSampleActivityViews() {
        mGenericTest = findViewById(R.id.rvGeneric);
    }

}
