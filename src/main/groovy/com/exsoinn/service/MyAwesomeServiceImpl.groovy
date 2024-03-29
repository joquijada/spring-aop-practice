package com.exsoinn.service

import groovy.util.logging.Slf4j

@Slf4j
class MyAwesomeServiceImpl implements MyAwesomeService {

  @Override
  void doSomethingSpectacular() {
    log.info "executing doSomethingSpectacular() in ${this.class.name}"
  }

  @Override
  void doSomethingGreat() {
    log.info "executing doSomethingGreat() in ${this.class.name}"
  }

  @Override
  Object doSomethingFantastic(final Map<String, String> argument) {
    log.info "executing doSomethingFantastic()  in ${this.class.name}"
    return null
  }
}
