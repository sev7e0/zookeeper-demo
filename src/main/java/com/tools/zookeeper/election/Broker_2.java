package com.tools.zookeeper.election;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;

@Slf4j
public class Broker_2 {
    private static final CountDownLatch shutdownLatch = new CountDownLatch(1);
    private static final String name = "Broker_2";

    public static void main(String[] args) throws InterruptedException {
        ZkElectionUtil electionUtil = new ZkElectionUtil();
        try {
            electionUtil.electionMaster(name.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
        shutdownLatch.await();
    }
}
