package pt.simdea.gmlrva.sample.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import lombok.NoArgsConstructor;

/**
 * TODO...
 * Created by Paulo on 9/26/2017.
 */
@NoArgsConstructor public class FakeDataProvider {

    private static final int MAX_LENGTH = 10;
    private final RandomStringGenerator generator = new RandomStringGenerator();

    public FakeDataObject provideFakeData() {
        final Random random = new Random();
        return new FakeDataObject(generator.getRandomString(random.nextInt(MAX_LENGTH)),
                generator.getRandomString(random.nextInt(MAX_LENGTH)));
    }

    private final class RandomStringGenerator {
        private static final String ALLOWED_CHARACTERS ="0123456789qwertyuiopasdfghjklzxcvbnm";

        String getRandomString(final int sizeOfRandomString) {
            final Random random = new Random();
            final StringBuilder sb = new StringBuilder(sizeOfRandomString);
            for (int i = 0; i < sizeOfRandomString; i++) {
                sb.append(ALLOWED_CHARACTERS.charAt(random.nextInt(ALLOWED_CHARACTERS.length())));
            }
            return sb.toString();
        }

    }

}
