package pt.simdea.gmlrva.lib.decorators;

import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;

import java.io.Serializable;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * Class responsible for defining a {@link RecyclerView.ItemDecoration}.
 * See {@link GenericItemDecoration} for more information.
 *
 * TODO...
 *
 * This class employs Builder Pattern, meaning this class contains all the required fields.
 * It's constructor receives all the required parameters. All optional parameters can be set via this class.
 *
 * Created by Paulo Ribeiro on 10/7/2017.
 * Simdea © All Rights Reserved.
 * paulo.ribeiro@simdea.pt
 */

@ToString @EqualsAndHashCode public class DecorationSpec implements Serializable {

    /** This ItemDecoration's top spacing value */
    @Getter private int mTopSpacing = 0;

    /** This ItemDecoration's bottom spacing value */
    @Getter private int mBottomSpacing = 0;

    /** This ItemDecoration's start spacing value */
    @Getter private int mStartSpacing = 0;

    /** This ItemDecoration's end spacing value */
    @Getter private int mEndSpacing = 0;

    /** This ItemDecoration's divider resource */
    @Nullable @Getter private Drawable mDivider;

    private DecorationSpec(@NonNull final DecorationSpecBuilder builder) {
        // TODO...
    }

    /** DecorationSpec builder class responsible for harboring all the required fields of a {@link DecorationSpec}. */
    public static class DecorationSpecBuilder {
        // TODO...
    }

}
