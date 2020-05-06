package com.gbs.log;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

public class LogTest {
    private static final Logger logger = LoggerFactory.getLogger(LogTest.class);
    public static void main(String[] args) {
        int n = 16;
        String s = "abc";
        if (logger.isDebugEnabled()) {
            logger.debug("{} is a debug info {}", s, n);
            logger.debug("name: {} is a error info", s);
        }

    }
}
