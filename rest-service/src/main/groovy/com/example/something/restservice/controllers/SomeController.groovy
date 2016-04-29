package com.example.something.restservice.controllers

import com.example.something.tools.GroovyTools
import com.example.something.tools.JavaTools
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

@RestController
@RequestMapping("/some")
@CompileStatic
@Api(protocols = "http,https")
class SomeController {

    @ApiOperation(value = "returns map containing random string", notes = "Well, this is random string notes.")
    @ApiResponses([
            @ApiResponse(code = 200, message = "Operation completed successfully :: 1")
    ])
    @RequestMapping(value = "/string", method = RequestMethod.GET)
    Map<String, ?> someString(
            @ApiParam(value = "Maximum string length") @RequestParam(required = false, defaultValue = "10") int len) {
        [ok: true, str: GroovyTools.randomString(len)]
    }

    @ApiOperation(value = "returns map containing random integer", notes = "Well, this is random int notes.")
    @ApiResponses([
            @ApiResponse(code = 200, message = "Operation completed successfully :: 2")
    ])
    @RequestMapping(value = "/int", method = RequestMethod.GET)
    Map<String, ?> someInt(
            @ApiParam("Maximum integer size") @RequestParam(required = false, defaultValue = "100000") int max
    ) {
        [ok: true, int: JavaTools.randomInt(max)]
    }
}