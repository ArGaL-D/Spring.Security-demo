package com.example.security.usuarios.websecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

    private final PasswordEncoder passwordEncoder;

    @Autowired    
    public SecurityConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    // Login and routes

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()   
                .antMatchers("/*")
                .permitAll() 
                .antMatchers("/api/usuarios").hasRole(UserRole.ADMIN.name())
                .antMatchers("/api/productos").hasAnyRole(UserRole.ADMIN.name(), UserRole.SUPERVISOR.name(), UserRole.TESTER.name())
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }

    // Users in Memory

    @Bean
    @Override
    protected UserDetailsService userDetailsService() {
        UserDetails juan = User.builder()
                            .username("juan")
                            .password(passwordEncoder.encode("juan123"))
                            .roles(UserRole.TESTER.name())
                            .build();
        
        UserDetails brenda = User.builder()
                            .username("brenda")
                            .password(passwordEncoder.encode("brenda123"))
                            .roles(UserRole.SUPERVISOR.name())
                            .build();
        
        UserDetails pablo = User.builder()
                            .username("pablo")
                            .password(passwordEncoder.encode("pablo123"))
                            .roles(UserRole.ADMIN.name())
                            .build();

        InMemoryUserDetailsManager userDetailsManager = new InMemoryUserDetailsManager(juan,brenda,pablo);                            

        return userDetailsManager;
    }


}
