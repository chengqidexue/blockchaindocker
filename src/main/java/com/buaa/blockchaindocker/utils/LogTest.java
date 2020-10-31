package com.buaa.blockchaindocker.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogTest {
    private static final Logger logger = LoggerFactory.getLogger(LogTest.class);

    public static void main(String[] args) {
        logger.debug("debug");
        logger.warn("warm");
        logger.error("error");
    }
}
