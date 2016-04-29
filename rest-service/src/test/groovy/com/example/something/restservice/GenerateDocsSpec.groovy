package com.example.something.restservice

import groovy.json.JsonOutput
import groovy.json.JsonSlurper
import groovy.util.logging.Slf4j
import io.github.robwin.markup.builder.MarkupLanguage
import io.github.robwin.swagger2markup.Swagger2MarkupConverter
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.test.IntegrationTest
import org.springframework.boot.test.SpringApplicationConfiguration
import org.springframework.test.context.web.WebAppConfiguration
import spock.lang.Shared
import spock.lang.Specification

/**
 * Generates API documentation! NOT A REAL TEST
 */
@SpringApplicationConfiguration(classes = RestSpringApp)
@IntegrationTest
@WebAppConfiguration
@EnableAutoConfiguration
@Slf4j
class GenerateDocsSpec extends Specification {
    //static final String outPattern = "src/main/docs/%s/generated"
    static final String outPattern = "build/docs/%s/generated"

    // @Value('http://localhost:${server.port}${springfox.documentation.swagger.v2.path}')
    @Shared
    //String apiUrl = "http://localhost:8080/v2/api-docs"
    String apiUrl = "http://localhost:8080/docs/api"

    def "should generate API docs"() {
        when:
        generateSwaggerJson()
        generate(MarkupLanguage.MARKDOWN)
        generate(MarkupLanguage.ASCIIDOC)

        then:
        assert true
    }

    private void generateSwaggerJson() {
        def out = outDir("swagger")

        // this is bad and i feel bad
        def conn = (HttpURLConnection) new URL(apiUrl).openConnection()
        assert conn.getResponseCode() == 200
        def data = new JsonSlurper().parse(conn.getInputStream(), "UTF-8")
        def prettyJson = JsonOutput.prettyPrint(JsonOutput.toJson(data))

        def file = new File(out + "/api.json")
        file.getParentFile().mkdirs()
        log.info("Writing Swagger API json to: {}", file)
        file.write(prettyJson, "UTF-8")
    }

    private def generate(type) {
        def t = type.toString().toLowerCase()
        def out = outDir(t)
        log.info("Generating {} from: {} to {}", t, apiUrl, out)
        Swagger2MarkupConverter.from(apiUrl)
                               .withMarkupLanguage(type).build()
                               .intoFolder(out);
    }

    private String outDir(String type) {
        String.format(outPattern, type)
    }
}
