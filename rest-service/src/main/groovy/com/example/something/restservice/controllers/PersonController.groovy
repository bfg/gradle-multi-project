package com.example.something.restservice.controllers

import com.example.something.rest.dto.Person
import groovy.transform.CompileStatic
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiParam
import io.swagger.annotations.ApiResponse
import io.swagger.annotations.ApiResponses
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

import static com.example.something.tools.GroovyTools.randomString
import static com.example.something.tools.JavaTools.randomInt

@RestController
@RequestMapping("/persons")
@CompileStatic
@Api(protocols = "http,https")
class PersonController {

    @ApiOperation(
            value = "Returns random person",
            notes = "Some VEEERY long notes about this operation"
    )
    @ApiResponses([
            @ApiResponse(code = 200, message = "Operation completed successfully."),
            @ApiResponse(code = 400, message = "There was something wrong with your request - you should know better!"),
            @ApiResponse(code = 404, message = "No soup for you!"),
            @ApiResponse(code = 500, message = "Internal server error - we really don't care at all."),
            @ApiResponse(code = 503, message = "Service unavailable - we really don't care at all.")
    ])
    @RequestMapping(value = "/random", method = RequestMethod.GET)
    Person getRandomPerson(
            @ApiParam("Ignored id parameter") @RequestParam(required = false) String id,
            @ApiParam("Required test parameter") @RequestParam(required = true, defaultValue = "aha!") String test
    ) {
        Person.builder()
              .age(randomInt(100))
              .name(randomString(20))
              .interest(randomString(10))
              .interest(randomString(15))
              .build()
    }
}