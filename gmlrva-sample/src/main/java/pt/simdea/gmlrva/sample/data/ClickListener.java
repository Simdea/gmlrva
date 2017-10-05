/*
 * Copyright (c) 2017. Simdea.
 */

package pt.simdea.gmlrva.sample.data;

import pt.simdea.gmlrva.lib.IGenericRecyclerViewLayout;

/**
 * {@link IGenericRecyclerViewLayout} view listener meant to deal with click call to actions.
 *
 * Created by Paulo Ribeiro on 9/26/2017.
 * Simdea © All Rights Reserved.
 * paulo.ribeiro@simdea.pt
 */
public interface ClickListener {

    /** Procedure meant to handle click call to actions applied to the target {@link IGenericRecyclerViewLayout}. */
    void onClick();

}
