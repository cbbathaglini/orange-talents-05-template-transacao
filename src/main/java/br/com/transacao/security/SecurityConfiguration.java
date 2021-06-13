package br.com.transacao.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.headers().httpStrictTransportSecurity().disable();
        http.authorizeRequests(request->
                request.antMatchers("/transacoes/**").hasAuthority("SCOPE_transacoes")
                       .antMatchers(HttpMethod.GET, "/actuator/**").permitAll()
        ).
                oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt)
                .sessionManagement(s->s.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
    }

}

