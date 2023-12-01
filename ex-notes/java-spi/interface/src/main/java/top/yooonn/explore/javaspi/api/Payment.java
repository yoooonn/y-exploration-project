package top.yooonn.explore.javaspi.api;

/**
 * @author yooonn
 * @date 2021.03.30
 */
public interface Payment {

    Integer payFor(Long amount, String businessLine);

    Integer payStatus(String payUniqueKey, String businessLine);
}
