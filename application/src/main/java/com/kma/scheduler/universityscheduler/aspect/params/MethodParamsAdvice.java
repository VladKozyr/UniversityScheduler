package com.kma.scheduler.universityscheduler.aspect.params;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class MethodParamsAdvice {
    @Before(value = "@annotation(com.kma.scheduler.universityscheduler.aspect.params.MethodParams)")
    public void logParams(JoinPoint joinPoint) {

        // Method Information
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();

        System.out.println("method name: " + signature.getMethod().getName());
        System.out.println("declaring type: " + signature.getDeclaringType());

        // Method args
        System.out.println("Method args names:");
        Arrays.stream(signature.getParameterNames())
                .forEach(s -> System.out.println("arg name: " + s));

        System.out.println("Method args types:");
        Arrays.stream(signature.getParameterTypes())
                .forEach(s -> System.out.println("arg type: " + s));

        System.out.println("Method args values:");
        Arrays.stream(joinPoint.getArgs())
                .forEach(o -> System.out.println("arg value: " + o.toString()));

        // Additional Information
        System.out.println("returning type: " + signature.getReturnType());

    }

    @AfterReturning(value = "@annotation(com.kma.scheduler.universityscheduler.aspect.params.MethodParams)", returning = "result")
    public void logReturnValue(JoinPoint joinPoint, Object result) {
        System.out.println("returning value: " + result);
    }
}
