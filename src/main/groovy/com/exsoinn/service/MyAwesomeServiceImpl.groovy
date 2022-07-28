package com.exsoinn.service

import groovy.util.logging.Slf4j

@Slf4j
class MyAwesomeServiceImpl implements MyAwesomeService {

  @Override
  void doSomethingSpectacular() {
    log.info "executing doSomethingSpectacular()"
  }

  @Override
  void doSomethingGreat() {
    log.info "executing doSomethingGreat()"
  }

  @Override
  Object doSomethingFantastic(final Map<String, String> argument) {
    log.info "executing doSomethingFantastic()"
    return null
  }
}