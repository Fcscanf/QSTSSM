package com.fcant;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * Test
 * <p>
 * encoding:UTF-8
 *
 * @author Fcscanf
 * @description
 * @date 上午 8:49 2019-07-24/0024
 */
@Slf4j
public class Slf4jTest {
    @Test
    public void Test() {
        String name = "Fcc";
        log.info("Hello {}" , name);
    }
}
