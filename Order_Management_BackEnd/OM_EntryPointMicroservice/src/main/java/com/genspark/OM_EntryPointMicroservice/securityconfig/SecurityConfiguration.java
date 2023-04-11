package com.genspark.OM_EntryPointMicroservice.securityconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
   // @Autowired
   // private BCryptPasswordEncoder passwordEncoder;
   /* @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider auth =new  DaoAuthenticationProvider();
        //auth.setUserDetailsService(userService);
        //auth.setPasswordEncoder(passwordEncoder);//());
        return auth;
    }*/
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("Hana")
                .password("0000")
                .roles("admin");
       // auth.authenticationProvider(authenticationProvider());
        //super.configure(auth);
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //super.configure(http);
            http.authorizeRequests().antMatchers("/**")
                    .fullyAuthenticated()
                    .and()
                    .httpBasic();

    }
}
