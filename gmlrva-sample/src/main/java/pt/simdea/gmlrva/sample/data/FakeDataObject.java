/*
 * Copyright (c) 2017. Simdea.
 */

package pt.simdea.gmlrva.sample.data;

import android.support.annotation.NonNull;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * Class meant to model a random fake data object.
 *
 * Created by Paulo Ribeiro on 9/26/2017.
 * Simdea © All Rights Reserved.
 * paulo.ribeiro@simdea.pt
 */
@AllArgsConstructor
@Getter
@EqualsAndHashCode(exclude = "mDescription")
public final class FakeDataObject implements Comparable<FakeDataObject> {

    private String mTitle;
    private String mDescription;

    @Override
    public int compareTo(@NonNull final FakeDataObject o) {
        return getTitle().compareToIgnoreCase(o.getTitle());
    }

}
