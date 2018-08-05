/*
 * Copyright (c) 2017. Simdea.
 */

package pt.simdea.gmlrva.sample.data;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;

import java.util.Random;

import lombok.NoArgsConstructor;

/**
 * Class meant to provide random fake data.
 *
 * Created by Paulo Ribeiro on 9/26/2017.
 * Simdea © All Rights Reserved.
 * paulo.ribeiro@simdea.pt
 */
@NoArgsConstructor
public final class FakeDataProvider {

    private static final int MAX_LENGTH = 10;

    /**
     * Procedure meant to return a {@link FakeDataObject} instance, containing the randomly generated data.
     * @return the {@link FakeDataObject} instance, containing the randomly generated data.
     */
    @NonNull
    public FakeDataObject provideFakeData() {
        final Random random = new Random();
        return new FakeDataObject(RandomStringGenerator.getRandomString(random.nextInt(MAX_LENGTH)),
                RandomStringGenerator.getRandomString(random.nextInt(MAX_LENGTH)));
    }

    /** Auxiliary class meant to handle the random generation of data. */
    private static final class RandomStringGenerator {

        private static final String ALLOWED_CHARACTERS = "0123456789qwertyuiopasdfghjklzxcvbnm";

        /**
         * Procedure meant to generate and return a {@link String} object containing randomly generated output.
         * @param sizeOfRandomString the desired size of the resulting {@link String} object.
         * @return the {@link String} object containing randomly generated output.
         */
        @NonNull
        private static String getRandomString(@IntRange(from = 0) final int sizeOfRandomString) {
            final Random random = new Random();
            final StringBuilder sb = new StringBuilder(sizeOfRandomString);
            for (int i = 0; i < sizeOfRandomString; i++) {
                sb.append(ALLOWED_CHARACTERS.charAt(random.nextInt(ALLOWED_CHARACTERS.length())));
            }
            return sb.toString();
        }

    }

}
