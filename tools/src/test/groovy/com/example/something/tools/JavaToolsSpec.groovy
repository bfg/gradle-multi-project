package com.example.something.tools

import spock.lang.Specification
import spock.lang.Unroll

class JavaToolsSpec extends Specification {
    @Unroll
    def "should produce random number up to #max"() {
        when:
        def res = JavaTools.randomInt(max)

        then:
        assert res >= 0
        assert res <= max

        where:
        max << [1, 5, 10, 100, 1000]
    }
}
