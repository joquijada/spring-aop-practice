package com.exsoinn.config.aop

import groovy.util.logging.Slf4j
import org.aspectj.lang.JoinPoint
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Pointcut
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.EnableAspectJAutoProxy

@EnableAspectJAutoProxy
@Aspect
//@Configuration
@Slf4j
class SpringAopAspectConfiguration {

  /**
   * Pointcut declarations
   */
  @Pointcut("execution(* com.exsoinn.service.MyAwesomeService.*(..))")
  void interceptAnyMethodInMyAwesomeServiceInterface() {

  }

  /**
   * Advice declarations
   */
  @Around("com.exsoinn.config.aop.SpringAopAspectConfiguration.interceptAnyMethodInMyAwesomeServiceInterface()")
  Object aroundAdvice(ProceedingJoinPoint proceedingJoinPoint) {
    log.info "${'*' * 10} BEGIN ADVICE: aroundAdvice ${'*' * 10}"
    Object retVal = proceedingJoinPoint.proceed()
    logJoinPoint(proceedingJoinPoint, ['Return Value': retVal.toString()])
    log.info "${'*' * 10} END ADVICE: aroundAdvice ${'*' * 10}"
    return retVal
  }

  @Around("com.exsoinn.config.aop.SpringAopAspectConfiguration.interceptAnyMethodInMyAwesomeServiceInterface()")
  Object aroundAdviceNoOp(ProceedingJoinPoint proceedingJoinPoint) {
    log.info "${'*' * 10} BEGIN ADVICE: aroundAdviceNoOp ${'*' * 10}"
    log.info "${'*' * 10} DOING A NOOP!!!! ${'*' * 10}"
    Object retVal = null
    logJoinPoint(proceedingJoinPoint, ['Return Value': retVal.toString()])
    log.info "${'*' * 10} END ADVICE: aroundAdviceNoOp ${'*' * 10}"
    return retVal
  }

  private void logJoinPoint(JoinPoint joinPoint, Map<String, String> moreStuff = [:]) {
    joinPoint.with {
      log.info("""\
                  Args: $args
                  Target: $target.class.name
                  Proxy: ${getThis().class.name}
                  Method: $signature
                  """.stripIndent())
      log.info moreStuff.collect { String key, String value ->
        "$key: $value"
      }.join("\n")
    }
  }

}
