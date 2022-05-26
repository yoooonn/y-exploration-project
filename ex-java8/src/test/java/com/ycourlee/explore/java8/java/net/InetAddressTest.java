package com.ycourlee.explore.java8.java.net;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Arrays;

/**
 * @author yooonn
 * @date 2021.12.27
 */
@Slf4j
public class InetAddressTest {

    @Test
    public void mainTest() throws SocketException, UnknownHostException {
        InetAddress localHost = InetAddress.getLocalHost();
        String hostAddress = localHost.getHostAddress();
        String canonicalHostName = localHost.getCanonicalHostName();
        String hostName = localHost.getHostName();
        NetworkInterface byInetAddress = NetworkInterface.getByInetAddress(localHost);
        byte[] hardwareAddress = byInetAddress.getHardwareAddress();
        byte[] address = localHost.getAddress();
        log.info("Arrays.toString(hardwareAddress): {}", Arrays.toString(hardwareAddress));
        log.info("Arrays.toString(address): {}", Arrays.toString(address));
        log.info("hostAddress: {}", hostAddress);
        log.info("canonicalHostName: {}", canonicalHostName);
        log.info("hostName: {}", hostName);
    }
}