package com.provider.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;

/**
 * @author cainiao
 * @program: orange-provider
 * @description: 事件
 * @create: 2020-01-02 13:10
 **/
@Slf4j
public class SourceEvent extends ApplicationEvent {

    public SourceEvent(Object source) {
        super(source);
    }
}
