package com.example.zuulapigateway.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


//@Configuration
public class SecurityConfigOld extends WebSecurityConfigurerAdapter {
   /* @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors()
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/**")
                .hasAuthority("administracion")
                .antMatchers(HttpMethod.POST, "/**")
                .hasAuthority("administracion")
                .antMatchers(HttpMethod.DELETE, "/**")
                .hasAuthority("administracion")
                .antMatchers(HttpMethod.PUT, "/**")
                .hasAuthority("administracion")

                .antMatchers(HttpMethod.GET, "/api/cliente/**")
                .hasAnyAuthority("lectura", "escritura")
                .antMatchers(HttpMethod.POST, "/api/cliente/**")
                .hasAnyAuthority("escritura")
                .antMatchers(HttpMethod.PUT, "/api/cliente/**")
                .hasAnyAuthority("escritura")
                .antMatchers(HttpMethod.DELETE, "/api/cliente/**")
                .hasAnyAuthority("escritura")

                .antMatchers(HttpMethod.GET, "/api/pedido/**")
                .hasAnyAuthority("lectura", "escritura")
                .antMatchers(HttpMethod.POST, "/api/pedido/**")
                .hasAnyAuthority("escritura")
                .antMatchers(HttpMethod.PUT, "/api/pedido/**")
                .hasAnyAuthority("escritura")
                .antMatchers(HttpMethod.DELETE, "/api/pedido/**")
                .hasAnyAuthority("escritura")

                .antMatchers(HttpMethod.GET, "/api/cuenta/hpla")
                .hasAnyAuthority("lectura", "escritura", "administracion")
                .antMatchers(HttpMethod.GET, "/api/cuenta/**")
                .hasAnyAuthority("lectura", "escritura")
                .antMatchers(HttpMethod.POST, "/api/cuenta/**")
                .hasAnyAuthority("escritura")
                .antMatchers(HttpMethod.PUT, "/api/cuenta/**")
                .hasAnyAuthority("escritura")
                .antMatchers(HttpMethod.DELETE, "/api/cuenta/**")
                .hasAnyAuthority("escritura")

                .antMatchers(HttpMethod.GET, "/api/productos/**")
                .hasAnyAuthority("lectura", "escritura")
                .antMatchers(HttpMethod.POST, "/api/productos/**")
                .hasAnyAuthority("escritura")
                .antMatchers(HttpMethod.PUT, "/api/productos/**")
                .hasAnyAuthority("escritura")
                .antMatchers(HttpMethod.DELETE, "/api/productos/**")
                .hasAnyAuthority("escritura")

                .anyRequest().authenticated()
                .and().oauth2ResourceServer()
                .jwt()
                .jwtAuthenticationConverter(new CustomJwtAuthenticationConverter());
    }

*/
}