package top.yooonn.explore.notes.cloud.aio.other;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.Assert;

/**
 * @author yooonn
 * @date 2022.12.30
 */
// @Configuration(proxyBeanMethods = false)
@Configuration
@RequiredArgsConstructor
public class DeclareByConfiguration implements SmartInitializingSingleton {

    private final BeanFactory beanFactory;

    @Bean
    public B b() {
        return new B().setA(a());
    }

    @Bean
    public A a() {
        return new A();
    }

    @Override
    public void afterSingletonsInstantiated() {
        B b = beanFactory.getBean(B.class);
        A a = beanFactory.getBean(A.class);
        Assert.state(b.getA() == a, "must be same instance");
        // current class must be a bean
        DeclareByConfiguration bean = beanFactory.getBean(getClass());
    }
}
