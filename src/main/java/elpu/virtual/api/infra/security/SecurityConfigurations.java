package elpu.virtual.api.infra.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;

@Configuration
@EnableWebSecurity
public class SecurityConfigurations {
    @Autowired
    SecurityFilter securityFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.csrf()
                .disable()
                .cors(cors -> cors // Habilitar la configuración de CORS
                        .configurationSource(request -> new CorsConfiguration().applyPermitDefaultValues()))

                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS) //se indica el tipo de session
                .and()
                .authorizeHttpRequests((authorize) -> authorize
                        .requestMatchers(HttpMethod.GET, "/").permitAll()
                        .requestMatchers("/css/**").permitAll()
                        .requestMatchers("/img/**").permitAll()
                        .requestMatchers("/descargar").permitAll()
                        .requestMatchers("/versions/**").permitAll()
                        .requestMatchers(HttpMethod.POST,  "/api/login").permitAll()
                        .requestMatchers(HttpMethod.PUT,  "/api/login").permitAll()
                        .requestMatchers("/api/registro").permitAll()
                        .requestMatchers(HttpMethod.POST, "/api/enviarFoto").permitAll()
                        .requestMatchers(HttpMethod.POST, "/api/reclamo").permitAll()
                        .requestMatchers(HttpMethod.POST, "/api/recuperar").permitAll()

                        .anyRequest().authenticated()
                        .and()
                        .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class))

                .build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
