package com.exsoinn.config

import com.exsoinn.service.ChildOneMyAwesomeServiceImpl
import com.exsoinn.service.MyAwesomeService
import com.exsoinn.service.MyAwesomeServiceImpl
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SpringAopPracticeConfiguration {

  @Bean
  MyAwesomeService myAwesomeService() {
    new MyAwesomeServiceImpl()
  }

  @Bean
  MyAwesomeService childMyAwesomeService() {
    new ChildOneMyAwesomeServiceImpl()
  }
}
