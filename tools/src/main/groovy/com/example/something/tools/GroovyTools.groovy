package com.example.something.tools

import groovy.transform.CompileStatic

@CompileStatic
class GroovyTools {
    private static final Random RAND = new Random()

    /**
     * Generates random string.
     * @param len random string length
     * @return random string
     */
    static String randomString(int len) {
        def sb = new StringBuilder()
        (1..len).each { sb.append(Character.toChars((RAND.nextInt(25) + 48))) }
        sb.toString()
    }
}