/*
 * Copyright (c) 2017. Simdea.
 */

package pt.simdea.gmlrva.sample.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import pt.simdea.gmlrva.lib.GenericMultipleLayoutAdapter;
import pt.simdea.gmlrva.lib.GenericRecyclerViewLayout;
import pt.simdea.gmlrva.sample.R;
import pt.simdea.gmlrva.sample.data.ClickListener;
import pt.simdea.gmlrva.sample.data.FakeDataObject;
import pt.simdea.gmlrva.sample.data.FakeDataProvider;
import pt.simdea.gmlrva.sample.layouts.CarouselCategoryItemLayout;
import pt.simdea.gmlrva.sample.layouts.CarouselCategoryItemWithOptionLayout;
import pt.simdea.gmlrva.sample.layouts.CarouselItemLayout;
import pt.simdea.gmlrva.sample.layouts.CarouselItemWithOptionLayout;
import pt.simdea.gmlrva.sample.layouts.SingleImageItemLayout;
import pt.simdea.gmlrva.sample.utilities.GenericUtils;

/**
 * Class responsible for the Sample Screen for the (GMLRVA) library.
 *
 * Created by Paulo Ribeiro on 7/16/2017.
 * Simdea © All Rights Reserved.
 * paulo.ribeiro@simdea.pt
 */
@SuppressWarnings("unchecked")
public class SampleActivity extends AppCompatActivity implements ClickListener {

    private RecyclerView mGenericTest;
    private FakeDataProvider dataProvider = new FakeDataProvider();
    private List<CarouselItemLayout> carouselItemData = new ArrayList<>();
    private List<CarouselItemWithOptionLayout> carouselItemDataWithOptions = new ArrayList<>();

    /**
     * Starter procedure for SampleActivity.
     * @param context the application's current context.
     */
    @SuppressWarnings("unused") public static void start(@NonNull final Context context) {
        final Intent starter = new Intent(context, SampleActivity.class);
        context.startActivity(starter);
    }

    /**
     * Called when SampleActivity is first created.
     * @param savedInstanceState Bundle object containing the activity's previously saved state.
     */
    @Override protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gmlrva_activity_sample);
    }

    /** Called when the activity is about to become visible. */
    @Override protected void onStart() {
        super.onStart();
        bindSampleActivityViews();
    }

    /** Called when the activity has become visible. */
    @Override protected void onResume() {
        super.onResume();
        if (mGenericTest != null) {
            mGenericTest.setAdapter(new GenericMultipleLayoutAdapter<>(buildGenericListExample()));
            mGenericTest.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
            GenericUtils.setOptimalConfigurationForRecyclerView(mGenericTest);
        }
    }

    @Override public void onClick() {
        if (mGenericTest != null) {
            rebuildGenericListExample();
        }
    }

    private void rebuildGenericListExample() {
        final List<GenericRecyclerViewLayout> exampleHolders = new ArrayList<>();

        /* Add a Single Image Item Example */
        final SingleImageItemLayout singleItemLayout = new SingleImageItemLayout(R.mipmap.gmlrva_ic_launcher, this);
        exampleHolders.add(singleItemLayout);

        /* Add a Carousel (Category + List) Item Example */
        carouselItemData = buildCarouselItemData(20);
        final CarouselCategoryItemLayout carouselCategoryItemLayout
                = new CarouselCategoryItemLayout("Carousel Title", carouselItemData, this);
        exampleHolders.add(carouselCategoryItemLayout);

        /* Add a Carousel (Category + List with options) Item Example */
        carouselItemDataWithOptions = buildCarouselItemWithOptionsData(20);
        final CarouselCategoryItemWithOptionLayout carouselCategoryItemWithOptionsLayout
                = new CarouselCategoryItemWithOptionLayout("Carousel Title With Option",
                carouselItemDataWithOptions, this);
        exampleHolders.add(carouselCategoryItemWithOptionsLayout);

        final GenericMultipleLayoutAdapter adapter = (GenericMultipleLayoutAdapter) mGenericTest.getAdapter();
        adapter.updateList(exampleHolders);
    }

    /**
     * Procedure meant to build the Sample List, showcasing multiple layout types manage by the same
     * {@link RecyclerView.Adapter} instance.
     * @return the intended Sample List.
     */
    private List<GenericRecyclerViewLayout> buildGenericListExample() {
        final List<GenericRecyclerViewLayout> exampleHolders = new ArrayList<>();

        /* Add a Single Image Item Example */
        final SingleImageItemLayout singleItemLayout = new SingleImageItemLayout(R.mipmap.gmlrva_ic_launcher, this);
        exampleHolders.add(singleItemLayout);

        /* Add a Carousel (Category + List) Item Example */
        carouselItemData = buildCarouselItemData(10);
        final CarouselCategoryItemLayout carouselCategoryItemLayout
                = new CarouselCategoryItemLayout("Carousel Title", carouselItemData, this);
        exampleHolders.add(carouselCategoryItemLayout);

        /* Add a Carousel (Category + List with options) Item Example */
        carouselItemDataWithOptions = buildCarouselItemWithOptionsData(10);
        final CarouselCategoryItemWithOptionLayout carouselCategoryItemWithOptionsLayout
                = new CarouselCategoryItemWithOptionLayout("Carousel Title With Option",
                carouselItemDataWithOptions, this);
        exampleHolders.add(carouselCategoryItemWithOptionsLayout);

        return exampleHolders;
    }

    /**
     * Auxiliary procedure meant to build the Carousel item list sample for the Carousel example present in this
     * activity's Sample List.
     * @param maxItemNumber the maximum number of carousel items.
     * @return the intended Carousel item list.
     */
    private List<CarouselItemLayout> buildCarouselItemData(final int maxItemNumber) {
        final List<CarouselItemLayout> carouselItemData = new ArrayList<>();

        String title, description;
        final int resource = R.mipmap.gmlrva_ic_launcher_round;
        FakeDataObject item;
        for (int i = 0; i < maxItemNumber; i++) {
            item = dataProvider.provideFakeData();
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
    private List<CarouselItemWithOptionLayout> buildCarouselItemWithOptionsData(final int maxItemNumber) {
        final List<CarouselItemWithOptionLayout> carouselItemData = new ArrayList<>();

        String title, description;
        final int resource = R.mipmap.gmlrva_ic_launcher_round;
        FakeDataObject item;
        for (int i = 0; i < maxItemNumber; i++) {
            item = dataProvider.provideFakeData();
            title = item.getTitle();
            description = item.getDescription();
            carouselItemData.add(new CarouselItemWithOptionLayout(title, description, resource));
        }

        return carouselItemData;
    }

    /** Procedure meant to bind this activity's views. */
    private void bindSampleActivityViews() {
        mGenericTest = (RecyclerView) findViewById(R.id.rvGeneric);
    }

}
