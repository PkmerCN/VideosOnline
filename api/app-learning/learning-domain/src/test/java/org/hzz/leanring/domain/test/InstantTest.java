package org.hzz.leanring.domain.test;

import lombok.extern.slf4j.Slf4j;

import java.time.Instant;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/25
 */
@Slf4j
public class InstantTest {
    public static void main(String[] args) {
        Instant now = Instant.now();
        log.info("current: {}",now);
        // current: 2024-06-24T16:50:09.149919900Z
    }
}
