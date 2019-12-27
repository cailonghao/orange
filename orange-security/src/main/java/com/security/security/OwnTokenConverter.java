package com.security.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author cainiao
 * @program: cloud-secutity
 * @description: 自定义token转换器
 * @create: 2019-12-18 16:59
 **/
@Slf4j
public class OwnTokenConverter extends JwtAccessTokenConverter {


    /**token生成*/
    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        DefaultOAuth2AccessToken result = new DefaultOAuth2AccessToken(accessToken);
        Map<String, Object> info = new LinkedHashMap(accessToken.getAdditionalInformation());
        result.getAdditionalInformation().put("user",authentication.getPrincipal());
        result.getAdditionalInformation().put("GrantedAuthority",authentication.getAuthorities());
        return super.enhance(result, authentication);
    }


}
