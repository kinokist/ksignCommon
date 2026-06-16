package com.kinokist.ksign.common.util;

public class AgentManager {
    private static boolean initialized = false;

    public static void init() {
        if (!initialized) {
            try {
                // 실제 K-sign Agent 초기화 (예시)
                System.loadLibrary("ksign"); 

                // 환경설정 파일 로드
                // KSign.init("config/ksign.conf");

                initialized = true;
                System.out.println("KSign Agent Initialized");
            } catch (Exception e) {
                throw new RuntimeException("KSign Agent 초기화 실패", e);
            }
        }
    }
}
