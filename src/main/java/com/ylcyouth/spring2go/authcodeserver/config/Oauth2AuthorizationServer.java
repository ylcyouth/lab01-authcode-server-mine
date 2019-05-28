package com.ylcyouth.spring2go.authcodeserver.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

/**
 * @author wjj
 * @create 2019/5/28 23:38
 *
 * 授权服务器配置类
 * atConfiguration
 * atEnableAuthorizationServer
 *
 */
@Configuration
@EnableAuthorizationServer
public class Oauth2AuthorizationServer extends AuthorizationServerConfigurerAdapter {

    /**
     * @param clients
     * @throws Exception
     *
     * 重写父类 AuthorizationServerConfigurerAdapter 的 configure 方法
     *
     * .inMemory() 表示在内存中
     * .withClient() 表示client的标识
     * .secret()    表示client的密码
     * .redirectUris() 表示验证xxx通过之后重定向的地址
     * .authorizedGrantTypes() 表示授权的方式 值authorization_code 表示授权码方式
     * .scopes() 表示xxx权限的范围，read_userinfo、read_contacts 表示xxx可以干这两件事
     *
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {

        clients.inMemory()
                .withClient("clientapp")
                .secret("123456")
                .redirectUris("http://localhost:9001/callback")
                .authorizedGrantTypes("authorization_code")
                .scopes("read_userinfo", "read_contacts");
    }
}
