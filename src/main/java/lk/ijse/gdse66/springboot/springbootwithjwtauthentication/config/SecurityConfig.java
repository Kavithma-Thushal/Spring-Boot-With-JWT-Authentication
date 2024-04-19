package lk.ijse.gdse66.springboot.springbootwithjwtauthentication.config;

import lk.ijse.gdse66.springboot.springbootwithjwtauthentication.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @author : Kavithma Thushal
 * @project : spring-boot-with-basic-auth
 * @since : 10:51 AM - 4/18/2024
 **/
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final UserService userService;
    private final JwtConfigurationFilter jwtConfigurationFilter;

    public SecurityConfig(UserService userService, JwtConfigurationFilter jwtConfigurationFilter) {
        this.userService = userService;
        this.jwtConfigurationFilter = jwtConfigurationFilter;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable) // disable CSRF protection
                .authorizeHttpRequests((authorize) -> authorize.requestMatchers("/api/v1/auth/**").permitAll() // authorize requests to "/api/v1/auth/**" without authentication
                        .anyRequest().authenticated()) // authorize any other request with authentication
                .sessionManagement((session) -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) // if there is no need to create sessions, you can use SessionCreationPolicy.STATELESS
                .authenticationProvider(authenticationProvider())
                .addFilterBefore(jwtConfigurationFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userService.userDetailsService());
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }
}
