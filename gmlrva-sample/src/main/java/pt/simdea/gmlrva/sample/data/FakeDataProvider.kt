/*
 * Copyright (c) 2017. Simdea.
 */

package pt.simdea.gmlrva.sample.data

import androidx.annotation.IntRange
import java.util.*

/**
 * Class meant to provide random fake data.
 *
 * Created by Paulo Ribeiro on 9/26/2017.
 * Simdea © All Rights Reserved.
 * paulo.ribeiro@simdea.pt
 */
class FakeDataProvider {

    /**
     * Procedure meant to return a [FakeDataObject] instance, containing the randomly generated data.
     * @return the [FakeDataObject] instance, containing the randomly generated data.
     */
    fun provideFakeData(): FakeDataObject {
        val random = Random()
        return FakeDataObject(RandomStringGenerator.getRandomString(random.nextInt(MAX_LENGTH)),
                RandomStringGenerator.getRandomString(random.nextInt(MAX_LENGTH)))
    }

    /** Auxiliary class meant to handle the random generation of data.  */
    private object RandomStringGenerator {

        private const val ALLOWED_CHARACTERS = "0123456789qwertyuiopasdfghjklzxcvbnm"

        /**
         * Procedure meant to generate and return a [String] object containing randomly generated output.
         * @param sizeOfRandomString the desired size of the resulting [String] object.
         * @return the [String] object containing randomly generated output.
         */
        internal fun getRandomString(@IntRange(from = 0) sizeOfRandomString: Int): String {
            val random = Random()
            val sb = StringBuilder(sizeOfRandomString)
            for (i in 0 until sizeOfRandomString) {
                sb.append(ALLOWED_CHARACTERS[random.nextInt(ALLOWED_CHARACTERS.length)])
            }
            return sb.toString()
        }

    }

    companion object {

        private const val MAX_LENGTH = 10
    }

}
