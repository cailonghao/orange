package com.provider.filter;

import com.provider.event.SourceEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author cainiao
 * @program: orange-provider
 * @description:
 * @create: 2020-01-02 13:13
 **/
@Slf4j
@Order(-1)
@Component
public class OwnFilter extends OncePerRequestFilter {
    @Autowired
    ApplicationEventPublisher eventPublisher;
    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        log.info("自定义filter");
        eventPublisher.publishEvent(new SourceEvent(new Object()));
        log.info("filter");
        filterChain.doFilter(httpServletRequest,httpServletResponse);
    }
}
