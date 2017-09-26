package pt.simdea.gmlrva.lib;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import lombok.AllArgsConstructor;

/**
 * TODO...
 * Created by Paulo on 9/26/2017.
 */
@AllArgsConstructor public class GenericPayload {

    /* Constants */

    /** UPDATE_ITEM representing an item that needs to be update. */
    public static final int UPDATE_ITEM = 0;

    // Declare the @IntDef for these constants
    @IntDef({ UPDATE_ITEM })
    @Retention(RetentionPolicy.SOURCE)
    public @interface GenericPayloadConstants { /* Do nothing here ... */ }

}
