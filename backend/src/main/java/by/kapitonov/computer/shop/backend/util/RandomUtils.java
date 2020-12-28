package by.kapitonov.computer.shop.backend.util;

import org.apache.commons.lang3.RandomStringUtils;

public final class RandomUtils {

    private static final Integer MIN_PASSWORD_LENGTH = 6;
    private static final Integer MAX_PASSWORD_LENGTH = 11;

    public static String generatePassword() {
        return RandomStringUtils.randomAlphabetic(MIN_PASSWORD_LENGTH, MAX_PASSWORD_LENGTH);
    }

}
