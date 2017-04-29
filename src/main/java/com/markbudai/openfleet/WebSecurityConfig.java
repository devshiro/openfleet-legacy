package com.markbudai.openfleet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.encoding.LdapShaPasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.ldap.DefaultSpringSecurityContextSource;

import java.util.Arrays;

/**
 * Created by Mark on 2017. 04. 29..
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                    .antMatchers("/css/**","/js/**","/fonts/**","/img/**","/bower_components/**").permitAll()
                    .anyRequest().fullyAuthenticated()
                    .and()
                .formLogin()
                    .loginPage("/login")
                    .permitAll()
                    .and()
                .logout()
                    .permitAll();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
        //in memory auth for testing
        /*auth
                .inMemoryAuthentication()
                .withUser("user").password("password").roles("USER");*/
        auth
                .ldapAuthentication()
                    .userDnPatterns("uid={0},ou=people")
                    .groupSearchBase("ou=groups")
                    .contextSource(contextSource())
                    .passwordCompare()
                        .passwordEncoder(new LdapShaPasswordEncoder())
                        .passwordAttribute("userPassword");
     }


    @Bean
    public DefaultSpringSecurityContextSource contextSource(){
        return new DefaultSpringSecurityContextSource(Arrays.asList("ldap://localhost:8389/"),"dc=springframework,dc=org");
    }
}
