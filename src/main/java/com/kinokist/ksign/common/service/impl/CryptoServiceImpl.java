package com.kinokist.ksign.common.service.impl;

import org.springframework.stereotype.Service;

import com.kinokist.ksign.common.service.CryptoService;
import com.kinokist.ksign.common.util.AgentManager;

@Service
public class CryptoServiceImpl implements CryptoService {

    public CryptoServiceImpl() {
        AgentManager.init();
    }

    @Override
    public String encrypt(String plainText) {
        try {
            // 예시 (실제 K-sign API로 변경)
            // return KSign.encrypt(plainText);
            return "ENC(" + plainText + ")";
        } catch (Exception e) {
            throw new RuntimeException("암호화 실패", e);
        }
    }

    @Override
    public String decrypt(String cipherText) {
        try {
            // return KSign.decrypt(cipherText);
            return cipherText.replace("ENC(", "").replace(")", "");
        } catch (Exception e) {
            throw new RuntimeException("복호화 실패", e);
        }
    }

    @Override
    public String hash(String value) {
        try {
            // return KSign.hash(value);
            return Integer.toHexString(value.hashCode());
        } catch (Exception e) {
            throw new RuntimeException("해시 실패", e);
        }
    }
}
