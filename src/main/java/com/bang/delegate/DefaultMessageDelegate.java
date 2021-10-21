package com.bang.delegate;

import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.util.Map;

@Slf4j
public class DefaultMessageDelegate implements MessageDelegate{
    public void handleMessage(String message) {
        log.info("1");

        log.info("handleMessage : {}" + message);
    }

    public void handleMessage(Map message) {

        log.info("2");
    }

    public void handleMessage(byte[] message) {

        log.info("3");
    }

    public void handleMessage(Serializable message) {

        log.info("4");
    }
}
