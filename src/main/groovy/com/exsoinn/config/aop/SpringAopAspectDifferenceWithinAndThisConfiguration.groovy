package com.exsoinn.config.aop;

import groovy.util.logging.Slf4j
import org.aspectj.lang.JoinPoint
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@Aspect
@Configuration
@Slf4j
class SpringAopAspectDifferenceWithinAndThisConfiguration {
    /**
     * Pointcut declarations
     */
    //@Pointcut("within(com.exsoinn.service.ChildOneMyAwesomeServiceImpl) && execution(public * *(..))")
    //@Pointcut("within(com.exsoinn.service.ChildOneMyAwesomeServiceImpl)")
    //@Pointcut("within(com.exsoinn.service.MyAwesomeServiceImpl))")  // advices only that type
    @Pointcut("this(com.exsoinn.service.MyAwesomeServiceImpl))") // advices this type and any children
    void interceptAnyPublicMethodInMyAwesomeServiceInterfaceUsingWithin() {

    }

    /**
     * Advice declarations
     */
    @Around("com.exsoinn.config.aop.SpringAopAspectDifferenceWithinAndThisConfiguration.interceptAnyPublicMethodInMyAwesomeServiceInterfaceUsingWithin()")
    Object aroundAdvice(ProceedingJoinPoint proceedingJoinPoint) {
        log.info "${'*' * 10} BEGIN ADVICE (com.exsoinn.config.SpringAopDifferenceWithinAndThisConfiguration.interceptAnyPublicMethodInMyAwesomeServiceInterfaceUsingWithin): aroundAdvice ${'*' * 10}"
        Object retVal = proceedingJoinPoint.proceed()
        logJoinPoint(proceedingJoinPoint, ['Return Value': retVal.toString()])
        log.info "${'*' * 10} END ADVICE (com.exsoinn.config.SpringAopDifferenceWithinAndThisConfiguration.interceptAnyPublicMethodInMyAwesomeServiceInterfaceUsingWithin): aroundAdvice ${'*' * 10}"
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
