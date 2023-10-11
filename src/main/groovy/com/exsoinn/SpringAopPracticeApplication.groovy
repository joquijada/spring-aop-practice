package com.exsoinn

import com.exsoinn.service.MyAwesomeService
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.Bean

@SpringBootApplication
class SpringAopPracticeApplication {

  static void main(String[] args) {
    SpringApplication.run(SpringAopPracticeApplication, args)
  }

  @Bean
  CommandLineRunner commandLineRunner(ApplicationContext ctx) {
    ({ String[] args ->
      MyAwesomeService myAwesomeService = ctx.getBean("myAwesomeService")
      myAwesomeService.doSomethingSpectacular()

      MyAwesomeService childMyAwesomeService = ctx.getBean("childMyAwesomeService")
      childMyAwesomeService.doSomethingSpectacular()
    })
  }
}
