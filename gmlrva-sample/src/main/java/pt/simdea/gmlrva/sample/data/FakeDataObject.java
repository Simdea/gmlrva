package pt.simdea.gmlrva.sample.data;

import android.support.annotation.NonNull;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * TODO...
 * Created by Paulo on 9/26/2017.
 */
@AllArgsConstructor @Getter public final class FakeDataObject implements Comparable<FakeDataObject> {

    private String mTitle, mDescription;

    @Override public int compareTo(@NonNull final FakeDataObject o) {
        return getTitle().compareToIgnoreCase(o.getTitle());
    }

}
