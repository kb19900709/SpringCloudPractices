package com.cathay.kb.practice.session.config;


import com.cathay.kb.practice.session.security.RestAuthenticationEntryPoint;
import com.cathay.kb.practice.session.security.UserAuthenticationProvider;
import com.cathay.kb.practice.session.security.filter.JwtAuthenticationFilter;
import com.cathay.kb.practice.session.security.filter.JwtLoginFilter;
import com.cathay.kb.practice.session.security.handler.SessionExpiredHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.session.security.SpringSessionBackedSessionRegistry;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private static final String LOGIN_URL = "/login";

    @Autowired
    private UserAuthenticationProvider userAuthenticationProvider;

    @Autowired
    private JwtAuthenticationFilter jwtAuthenticationFilter;

    @Autowired
    private SpringSessionBackedSessionRegistry sessionRegistry;

    @Autowired
    private SessionExpiredHandler sessionExpiredHandler;

    @Autowired
    private RestAuthenticationEntryPoint restAuthenticationEntryPoint;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.sessionManagement()
                .maximumSessions(1)
                .sessionRegistry(sessionRegistry)
                .expiredSessionStrategy(sessionExpiredHandler);

        http.exceptionHandling()
                .authenticationEntryPoint(restAuthenticationEntryPoint)
                .and()
                .csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, getWhitelist()).permitAll()
//                .antMatchers("/hello").hasAuthority("AUTH_WRITE")
//                .antMatchers("/world").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .addFilterBefore(jwtLoginFilter(), UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(userAuthenticationProvider);
    }

    @Bean
    public JwtLoginFilter jwtLoginFilter() throws Exception {
        return new JwtLoginFilter(LOGIN_URL, authenticationManager());
    }

    private String[] getWhitelist() {
        final String LOGIN_FORWARD_URL = "/auth/login/*";
        return new String[]{LOGIN_URL, LOGIN_FORWARD_URL};
    }
}
