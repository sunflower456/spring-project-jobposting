package com.toyproject.jobposting.configuration;

import com.toyproject.jobposting.security.*;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.web.filter.CorsFilter;

@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;

    private final CorsFilter corsFilter;

    private final CustomUserDetailService customUserDetailService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers("/resources/**")
                .antMatchers("/css/**")
                .antMatchers("/vendor/**")
                .antMatchers("/js/**")
                .antMatchers("/favicon*/**")
                .antMatchers("/img/**")
                .antMatchers("/signup")
                .antMatchers("/");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()//보호된 리소스 URI에 접근할 수 있는 권한을 설정
                .antMatchers("/").permitAll() //전체 접근 허용
                .antMatchers("/signup").permitAll() //전체 접근 허용
                .antMatchers("/users").permitAll() //전체 접근 허용
                .anyRequest().authenticated()
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessHandler(logoutSuccessHandler())
                .and().csrf()//csrf 보안 설정을 비활성화
                .disable()//해당 기능을 사용하기 위해서는 프론트단에서 csrf토큰값 보내줘야함
                .addFilter(corsFilter)
                .addFilter(loginFilter())
                .exceptionHandling()
                .authenticationEntryPoint(authenticationEntryPoint());
    }

    @Bean
    public AuthenticationSuccessHandler authenticationSuccessHandler(){
        CustomAuthenticationSuccessHandler successHandler = new CustomAuthenticationSuccessHandler();
        successHandler.setDefaultTargetUrl("/main");
        return successHandler;
    }

    @Bean
    public LogoutSuccessHandler logoutSuccessHandler(){
        CustomLogoutSuccessHandler logoutSuccessHandler = new CustomLogoutSuccessHandler();
        logoutSuccessHandler.setDefaultTargetUrl("/signup");
        return logoutSuccessHandler;
    }

    @Bean
    public AuthenticationEntryPoint authenticationEntryPoint(){
        return new CustomAutenticationEntryPoint();
    }

    private LoginFilter loginFilter() throws Exception {
        LoginFilter loginFilter = new LoginFilter(authenticationManager());
        loginFilter.setFilterProcessesUrl("/");
        return loginFilter;
    }

}
