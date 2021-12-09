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
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

import static com.example.security.usuarios.websecurity.UserRole.*;

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
        http // CSRF Cross Site Request Forgery
            //.csrf().disable() // Permite acceder a las rutas - post, delete, update; ya que por defecto estan prohibidas - protegidas
            .csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
            .and()
            .authorizeRequests()                   
                .antMatchers("/*").permitAll()  
                .antMatchers("/api/usuarios").hasRole(ADMIN.name())
                .antMatchers("/api/usuario").hasAnyRole(ADMIN.name(), SUPERVISOR.name(), TESTER.name())
                .antMatchers("/api/productos").hasAnyRole(ADMIN.name(), SUPERVISOR.name(), TESTER.name())                
                .anyRequest()
                .authenticated()
                .and()
                .formLogin();
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
