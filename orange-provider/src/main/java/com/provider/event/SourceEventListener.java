package com.provider.event;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author cainiao
 * @program: orange-provider
 * @description:
 * @create: 2020-01-02 13:11
 **/
@Slf4j
@Component
public class SourceEventListener implements ApplicationListener<SourceEvent> {

    @SneakyThrows
    @Override
    public void onApplicationEvent(SourceEvent sourceEvent) {
        Thread.sleep(1000*10);
        log.info("我触发了");
    }
}
