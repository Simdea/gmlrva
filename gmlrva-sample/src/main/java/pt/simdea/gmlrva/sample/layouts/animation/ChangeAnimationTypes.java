package pt.simdea.gmlrva.sample.layouts.animation;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import lombok.AllArgsConstructor;

/**
 * TODO...
 * Created by Paulo on 21/10/2017.
 */
@SuppressWarnings({"WeakerAccess", "unused"})
@AllArgsConstructor
public class ChangeAnimationTypes {

    /* Constants */

    /** TODO */
    public static final int TOAST_TRIGGER = 0;

    // Declare the @StringDef for these constants
    @IntDef({TOAST_TRIGGER})
    @Retention(RetentionPolicy.SOURCE)
    public @interface ChangeAnimationTypesConstants { /* Do nothing here ... */ }

}
