package com.example.something.tools;

import lombok.experimental.UtilityClass;

import java.util.Random;

@UtilityClass
public class JavaTools {
    private static final Random RAND = new Random();

    /**
     * Returns next random number.
     *
     * @param max max
     * @return random number.
     */
    public static int randomInt(int max) {
        return RAND.nextInt(max);
    }
}
