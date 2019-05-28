package com.ylcyouth.spring2go.authcodeserver.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

/**
 * @author wjj
 * @create 2019/5/28 23:52
 *
 * 资源服务器配置类
 * atConfiguration
 * atEnableAuthorizationServer
 *
 */
public class Oauth2ResourceServer extends ResourceServerConfigurerAdapter {

    /**
     * @param http
     * @throws Exception
     *
     * 重写父类 ResourceServerConfigurerAdapter 的 configure 方法
     *
     * .authorizeRequests()
     * .anyRequest()
     * .authenticated()
     * .and()
     * .requestMatchers()
     * .antMatchers("/api/**")
     *
     */
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .anyRequest()
            .authenticated()
        .and()
            .requestMatchers()
            .antMatchers("/api/**");
    }
}
