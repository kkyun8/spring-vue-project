package com.rest.api.config.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@RequiredArgsConstructor
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final JwtTokenProvider jwtTokenProvider;

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic().disable() // BasicSetting disable, 基本設定は認証されてない場合、ログインFormに自動遷移
                .csrf().disable() // restApiなのでcsrfなし
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) // jwtTokenありなので、sessionなし
                .and()
                .authorizeRequests()
                    .antMatchers("/*/signin", "/*/signup").permitAll() // ログインページは誰でも接近可能
                    .antMatchers(HttpMethod.GET, "helloworld/**").permitAll() //helloworld pageも可能
                    .anyRequest().hasRole("USER") // 他のページは認証が必要
                .and()
                    .addFilterBefore(new JwtAuthenticationFilter(jwtTokenProvider), UsernamePasswordAuthenticationFilter.class);
    }

    // ignore check swagger resource
    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers("/v2/api-docs", "/swagger-resources/**",
                "/swagger-ui.html", "/webjars/**", "/swagger/**");

    }
}
