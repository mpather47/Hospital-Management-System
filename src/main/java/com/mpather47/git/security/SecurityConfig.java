package com.mpather47.git.security;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

    private static final String DOCTOR_ROLE = "DOCTOR";
    private static final String USER_ROLE = "USER";
    private static final String ADMIN_ROLE = "ADMIN";
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("admin")
                .password(encoder().encode("admin"))
                .roles(ADMIN_ROLE,USER_ROLE)
                .and()
                .withUser("client")
                .password(encoder().encode("password"))
                .roles(USER_ROLE);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST,"**/create","**/read/**","**/all").hasRole(ADMIN_ROLE)
                .antMatchers(HttpMethod.POST,"ward/**").hasRole(ADMIN_ROLE)
                .antMatchers(HttpMethod.GET,"ward/**").hasRole(ADMIN_ROLE)
                .antMatchers(HttpMethod.GET,"person/read/**","person/all").hasRole(USER_ROLE)
                .antMatchers(HttpMethod.GET,"contact/read/**","person/all").hasRole(USER_ROLE)
                .antMatchers(HttpMethod.GET,"address/read/**","person/all").hasRole(USER_ROLE)
                .antMatchers(HttpMethod.GET,"account/read/**","account/all").hasRole(USER_ROLE)
                .antMatchers(HttpMethod.GET,"invoice/read/**","invoice/all").hasRole(USER_ROLE)
                .antMatchers(HttpMethod.GET,"statement/read/**","statement/all").hasRole(USER_ROLE)
                .antMatchers(HttpMethod.GET,"job/read/**","employee/all").hasRole(USER_ROLE)
                . antMatchers(HttpMethod.GET,"position/read/**","employee/all").hasRole(USER_ROLE)
                .antMatchers(HttpMethod.GET,"visitation/read/**","visitation/all").hasRole(USER_ROLE)
                .antMatchers(HttpMethod.GET,"prescription/read/**","prescription/all").hasRole(USER_ROLE)
                .antMatchers(HttpMethod.GET,"medication/read/**","medication/all").hasRole(USER_ROLE)
                .antMatchers(HttpMethod.POST,"appointement/create").hasRole(USER_ROLE)
               .antMatchers(HttpMethod.GET,"appointement/delete/**").hasRole(ADMIN_ROLE)
                .antMatchers(HttpMethod.GET,"hospital/read/**","hospital/all").hasRole(USER_ROLE)
                .antMatchers(HttpMethod.GET,"room/read/**","hospital/all").hasRole(USER_ROLE)
                .antMatchers(HttpMethod.GET,"equipment/read/**","hospital/all").hasRole(USER_ROLE)
                .and()
                .csrf()
                .disable();

    }
    @Bean
    public PasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }

}
