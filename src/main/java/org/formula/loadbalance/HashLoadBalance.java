package org.formula.loadbalance;

import java.util.ArrayList;
import java.util.List;

/**
 * @author krisjin on 2018/1/6
 */
public class HashLoadBalance {
    static List<String> serverIpList = new ArrayList<>();

    static {
        serverIpList.add("192.168.1.100");
        serverIpList.add("192.168.1.101");
        serverIpList.add("192.168.1.102");
        serverIpList.add("192.168.1.103");
        serverIpList.add("192.168.1.104");
    }

    public static void main(String[] args) {
        String userId = "哒哒哒哒哒哒多";
        for (int i = 0; i < 10; i++) {
            System.out.println(getIp(userId));
        }
    }

    static String getIp(String userId) {
        int userCode = userId.hashCode();
        int serverPost = Math.abs(userCode % serverIpList.size());
        return serverIpList.get(serverPost);
    }

}
