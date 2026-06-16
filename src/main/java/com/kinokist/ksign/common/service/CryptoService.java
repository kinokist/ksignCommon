package com.kinokist.ksign.common.service;

public interface CryptoService {
    String encrypt(String plainText);

    String decrypt(String cipherText);

    String hash(String value);
}
