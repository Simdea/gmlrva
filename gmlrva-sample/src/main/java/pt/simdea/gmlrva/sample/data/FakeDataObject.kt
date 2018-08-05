/*
 * Copyright (c) 2017. Simdea.
 */

package pt.simdea.gmlrva.sample.data

/**
 * Class meant to model a random fake data object.
 *
 * Created by Paulo Ribeiro on 9/26/2017.
 * Simdea © All Rights Reserved.
 * paulo.ribeiro@simdea.pt
 */
class FakeDataObject(private val mTitle: String, private val mDescription: String) : Comparable<FakeDataObject> {

    override fun compareTo(other: FakeDataObject): Int {
        return mTitle.compareTo(other.mTitle, true)
    }

}
