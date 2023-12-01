package top.yooonn.explore.javaspi;

import top.yooonn.explore.javaspi.api.Payment;
import lombok.extern.slf4j.Slf4j;
import sun.misc.Service;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @author yooonn
 * @date 2021.03.30
 */
@Slf4j
public class JavaSpiVerifyPortalApplication {

    public static void main(String[] args) {
        ServiceLoader<Payment> serviceLoader = ServiceLoader.load(Payment.class);
        for (Payment payment : serviceLoader) {
            payment.payFor(10000L, "共享单车");
        }

        Iterator<Payment> providers = Service.providers(Payment.class);
        while (providers.hasNext()) {
            Payment next = providers.next();
            next.payFor(200L, "共享单车");
        }
    }
}
