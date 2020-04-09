package com.itsm.jira

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import springfox.documentation.swagger2.annotations.EnableSwagger2

@SpringBootApplication
  class JiraApplication

fun main(args: Array<String>) {
    runApplication<JiraApplication>(*args)
}
