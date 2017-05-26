package com.markbudai.openfleet.configuration;

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
 * This class represents a configuration bean for ldap authentication.
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
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

    /**
     * Configures the {@link org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder} for LDAP authentication.
     * @param auth the {@link org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder} used to configure LDAP authenticaton.
     * @throws Exception if an error occurs when adding the LDAP authentication.
     */
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
        auth
                .ldapAuthentication()
                    .userDnPatterns("uid={0},ou=managers")
                    .groupSearchBase("ou=managers")
                    .contextSource(contextSource())
                    .passwordCompare()
                        .passwordEncoder(new LdapShaPasswordEncoder())
                        .passwordAttribute("userPassword");
     }

    /**
     * Provides a {@link org.springframework.security.ldap.DefaultSpringSecurityContextSource} for LDAP authenticaton.
     * @return a new {@link org.springframework.security.ldap.DefaultSpringSecurityContextSource} containing the {@code address} and the {@code baseDn} of the LDAP server.
     */
    @Bean
    public DefaultSpringSecurityContextSource contextSource(){
        return new DefaultSpringSecurityContextSource(Arrays.asList("ldap://localhost:8389/"),"dc=openfleet,dc=org");
    }
}
