package com.kinokist.ksign.common.aspect;

import com.kinokist.ksign.common.annotation.Encrypt;
import com.kinokist.ksign.common.service.CryptoService;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

@Aspect
@Component
@RequiredArgsConstructor
public class KSignCryptoAspect {

    private final CryptoService cryptoService;

    @Before("execution(* com.project..controller..*(..))")
    public void encryptBefore(JoinPoint joinPoint) throws IllegalAccessException {

        for (Object arg : joinPoint.getArgs()) {
            if (arg == null) continue;

            Field[] fields = arg.getClass().getDeclaredFields();

            for (Field field : fields) {
                if (field.isAnnotationPresent(Encrypt.class)) {
                    field.setAccessible(true);
                    Object value = field.get(arg);

                    if (value != null) {
                        String encrypted = cryptoService.encrypt(value.toString());
                        field.set(arg, encrypted);
                    }
                }
            }
        }
    }
}