package top.yooonn.explore.notes.nacos.provider.context;

import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.lang.NonNull;

/**
 * @author yooonn
 * @date 2022.03.14
 */
public class ApplicationEventPublisherHolder implements ApplicationEventPublisherAware {

    protected org.springframework.context.ApplicationEventPublisher publisher;

    @Override
    public void setApplicationEventPublisher(@NonNull org.springframework.context.ApplicationEventPublisher applicationEventPublisher) {
        publisher = applicationEventPublisher;
    }
}
