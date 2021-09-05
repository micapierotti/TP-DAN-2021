package com.example.zuulapigateway.security;

import org.keycloak.adapters.KeycloakConfigResolver;
import org.keycloak.adapters.springboot.KeycloakSpringBootConfigResolver;
import org.keycloak.adapters.springsecurity.KeycloakConfiguration;
import org.keycloak.adapters.springsecurity.authentication.KeycloakAuthenticationProvider;
import org.keycloak.adapters.springsecurity.config.KeycloakWebSecurityConfigurerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.authority.mapping.SimpleAuthorityMapper;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.web.authentication.session.RegisterSessionAuthenticationStrategy;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;

@KeycloakConfiguration
@Import(KeycloakSpringBootConfigResolver.class)
public class SecurityConfig extends KeycloakWebSecurityConfigurerAdapter {
    /**
     * Registers the KeycloakAuthenticationProvider with the authentication manager.
     */
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

        KeycloakAuthenticationProvider keycloakAuthenticationProvider = keycloakAuthenticationProvider();
        keycloakAuthenticationProvider.setGrantedAuthoritiesMapper(new SimpleAuthorityMapper());

        auth.authenticationProvider(keycloakAuthenticationProvider);
    }

    /**
     * Defines the session authentication strategy.
     */
    @Bean
    @Override
    protected SessionAuthenticationStrategy sessionAuthenticationStrategy() {
        return new RegisterSessionAuthenticationStrategy(new SessionRegistryImpl());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        super.configure(http);
        http
                .csrf().disable()
                .authorizeRequests()
                

                .antMatchers(HttpMethod.GET, "/*")
                .hasRole("administracion")
                .antMatchers(HttpMethod.POST, "/*")
                .hasRole("administracion")
                .antMatchers(HttpMethod.DELETE, "/*")
                .hasRole("administracion")
                .antMatchers(HttpMethod.PUT, "/*")
                .hasRole("administracion")

                .antMatchers(HttpMethod.GET, "/*/api/cliente/**")
                .hasAnyRole("lectura", "escritura")
                .antMatchers(HttpMethod.POST, "/*/api/cliente/**")
                .hasRole("escritura")
                .antMatchers(HttpMethod.PUT, "/*/api/cliente/**")
                .hasRole("escritura")
                .antMatchers(HttpMethod.DELETE, "/*/api/cliente/**")
                .hasRole("escritura")


                .antMatchers(HttpMethod.GET, "/api/pedido/**")
                .hasAnyRole("lectura", "escritura")
                .antMatchers(HttpMethod.POST, "/api/pedido/**")
                .hasRole("escritura")
                .antMatchers(HttpMethod.PUT, "/api/pedido/**")
                .hasRole("escritura")
                .antMatchers(HttpMethod.DELETE, "/api/pedido/**")
                .hasRole("escritura")


                .antMatchers(HttpMethod.GET, "/*/api/cuenta/**")
                .hasAnyRole("lectura", "escritura")
                .antMatchers(HttpMethod.POST, "/*/api/cuenta/**")
                .hasRole("escritura")
                .antMatchers(HttpMethod.PUT, "/*/api/cuenta/**")
                .hasRole("escritura")
                .antMatchers(HttpMethod.DELETE, "/*/api/cuenta/**")
                .hasRole("escritura")

                .antMatchers(HttpMethod.GET, "/*/api/productos/**")
                .hasAnyRole("lectura", "escritura")
                .antMatchers(HttpMethod.POST, "/*/api/productos/**")
                .hasRole("escritura")
                .antMatchers(HttpMethod.PUT, "/*/api/productos/**")
                .hasRole("escritura")
                .antMatchers(HttpMethod.DELETE, "/*/api/productos/**")
                .hasRole("escritura")

                .anyRequest()
                .permitAll();
    }

    @Bean
    public KeycloakConfigResolver KeycloakConfigResolver() {
        return new KeycloakSpringBootConfigResolver();
    }
}