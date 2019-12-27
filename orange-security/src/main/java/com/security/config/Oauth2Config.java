package com.security.config;

import com.security.security.OwnTokenConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;

import javax.annotation.Resource;
import javax.sql.DataSource;


/**
 * @author cainiao
 * @program: cloud-secutity
 * @description:
 * @create: 2019-12-17 11:40
 * http://localhost:40010/oauth/authorize?response_type=code&client_id=oauth2&redirect_uri=https://www.baidu.com&scope=all
 * http://106.52.181.161:40010/oauth/authorize?response_type=code&client_id=oauth2&redirect_uri=https://www.baidu.com&scope=all
 **/
@Configuration
public class Oauth2Config extends AuthorizationServerConfigurerAdapter {

    @Resource
    private AuthenticationManager authenticationManager;
    @Resource
    private DataSource dataSource;

    @Bean
    public TokenStore tokenStore() {
        //return new JdbcTokenStore(dataSource);
        return new JwtTokenStore(jwtAccessTokenConverter());
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        super.configure(security);
    }
    //keytool -genkeypair -alias oauth2 -keyalg RSA -keypass asyenc -keystore oauth2.jks -storepass asyenc  生成jks证书
    //keytool -list -v -keystore oauth2.jks 查看证书
    //keytool -list -rfc -keystore oauth2.jks -storepass asyenc 打印密钥
    //keytool -list -rfc --keystore oauth2.jks | openssl x509 -inform pem -pubkey 查看公钥

    /**
     * 令牌转换器
     */
    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter() {
        OwnTokenConverter ownTokenConverter = new OwnTokenConverter();
        KeyStoreKeyFactory keyStoreKeyFactory = new KeyStoreKeyFactory(
                new ClassPathResource("oauth2.jks"), "asyenc".toCharArray()
        );
        ownTokenConverter.setKeyPair(keyStoreKeyFactory.getKeyPair("oauth2"));
        return ownTokenConverter;
    }

    /**
     * token设置
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.withClientDetails(new JdbcClientDetailsService(dataSource));
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.authenticationManager(authenticationManager);
        endpoints.tokenStore(tokenStore());
        endpoints.accessTokenConverter(jwtAccessTokenConverter());
    }
}
