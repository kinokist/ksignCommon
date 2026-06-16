package com.kinokist.ksign.common.config;

import com.kinokist.ksign.common.handler.DecryptTypeHandler;
import com.kinokist.ksign.common.service.CryptoService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class MyBatisConfig {

    private final CryptoService cryptoService;

    @PostConstruct
    public void init() {
        DecryptTypeHandler.setCryptoService(cryptoService);
    }
}
