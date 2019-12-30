package com.provider.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.core.oidc.IdTokenClaimNames;

/**
 * @author cainiao
 * @program: orange-provider
 * @description:
 * @create: 2019-12-30 15:03
 **/
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public ClientRegistrationRepository clientRegistrationRepository() {
        return new InMemoryClientRegistrationRepository(this.googleClientRegistration());
    }
    /**
    * @exception: 认证域名和客户端域名一样会报错    [authorization_request_not_found]
    * @DESP:
    * @Date: 2019/12/30 cai
    */
    private ClientRegistration googleClientRegistration() {
        return ClientRegistration.withRegistrationId("orange")
                .clientId("oauth2")
                .clientSecret("123456")
                .clientAuthenticationMethod(ClientAuthenticationMethod.BASIC)
                .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
                .redirectUriTemplate("{baseUrl}/login/oauth2/code/orange")
                .scope("all")
                .authorizationUri("http://193.112.143.164:40008/oauth/authorize")
                .tokenUri("http://orange.security.com:40008/oauth/token")
                .userInfoUri("http://193.112.143.164:40008/oauth/user")
                .clientName("orange")
                .build();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/login/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .oauth2Login();
    }
}
