# Example gradle multi-project

## Contents:

  * [dto](dto) - Data Transfer Objects in java
  * [tools](tools) - Generic utility classes in java and groovy
  * [rest-service](rest-service) - spring-boot application in groovy utilizing dependencies from [dto](dto) and [tools](tools)

## Requirements

  * java 8

## How to build documentation

```
./gradlew clean build
```

Documentation should be placed to:

  * ```rest-service/build/docs/swagger/generated/api.json``` (swagger2 json)
  * ```rest-service/build/asciidoc/html5``` (html5)
  * ```rest-service/build/docs/asciidoc/generated``` (asciidoc)
  * ```rest-service/build/docs/markdown/generated``` (markdown)

## How to run

```
./gradlew rest-service:bootRun
```

## Interesting URLs

  * [Swagger UI](http://localhost:8080/swagger-ui.html)
  * [API documentation in Swagger 2.0 JSON format](http://localhost:8080/docs/api)