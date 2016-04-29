package com.example.something.tools

import spock.lang.Specification
import spock.lang.Unroll

class GroovyToolsSpec extends Specification {
    @Unroll
    def "should produce random string of length #len"() {
        when:
        def res = GroovyTools.randomString(len)

        then:
        assert res != null
        assert res.length() == len

        where:
        len << [1, 5, 10, 20]
    }
}
