package com.kinokist.ksign.common.aspect;

import com.kinokist.ksign.common.service.CryptoService;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import java.lang.reflect.Field;

@Aspect
@RequiredArgsConstructor
public class EncryptAspect {

    private final CryptoService cryptoService;

    @Before("execution(* com.project..controller..*(..))")
    public void encrypt(JoinPoint joinPoint) throws IllegalAccessException {

        for (Object arg : joinPoint.getArgs()) {
            if (arg == null) continue;

            for (Field field : arg.getClass().getDeclaredFields()) {
                if (field.getName().equals("phone") || field.getName().equals("ssn")) {

                    field.setAccessible(true);
                    Object val = field.get(arg);

                    if (val != null) {
                        field.set(arg, cryptoService.encrypt(val.toString()));
                    }
                }
            }
        }
    }
}
