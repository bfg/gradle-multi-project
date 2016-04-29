package com.example.something.rest.dto

import spock.lang.Specification

class SampleDTOSpec extends Specification {

    def "should work as expected"() {
        given:
        def name = "some name"
        def age = 27 // almost dead

        when:
        def sample = Person.builder().name(name).age(age).build()

        then:
        with(sample) {
            assert getName() == name
            assert getAge() == age
        }
    }
}
