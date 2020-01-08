package com.provider.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserRequest;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserService;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.oauth2.core.AuthenticationMethod;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.core.oidc.IdTokenClaimNames;


/**
 * @author cainiao
 * @program: orange-provider
 * @description:
 * @create: 2019-12-30 15:03
 **/
@Slf4j
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
                .clientSecret("oauth2")
                .clientAuthenticationMethod(ClientAuthenticationMethod.BASIC)
                .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
                .redirectUriTemplate("{baseUrl}/login/oauth2/code/orange")
                .scope("all")
                .authorizationUri("http://193.112.143.164:40000/oauth/authorize")
                .tokenUri("http://193.112.143.164:40000/oauth/token")
                .userInfoAuthenticationMethod(AuthenticationMethod.HEADER)
                .userInfoUri("http://193.112.143.164:40000/user/test1")
                .clientName("orange")
                .userNameAttributeName(IdTokenClaimNames.SUB)
                .build();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/oauth2/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .oauth2Login();
    }

}
