package com.whertotravel.security.config;

import com.whertotravel.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

    httpSecurity
      .httpBasic().and()
      .authorizeHttpRequests(authorize ->
        authorize.requestMatchers(Config.API_V_1 + "user").permitAll()
          .requestMatchers(Config.API_V_1 + "destination").authenticated()
          .requestMatchers(Config.API_V_1 + "destination/**").permitAll()
          .requestMatchers("/images/**").permitAll()
          .requestMatchers(Config.API_V_1 + "user/all").authenticated()
          .requestMatchers("db").denyAll()
      );
    httpSecurity.cors().and().csrf().disable();
    return httpSecurity.build();
  }

  @Bean
  public WebMvcConfigurer corsConfigurer() {
    return new WebMvcConfigurer() {
      @Override
      public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins("http://localhost:3000").allowCredentials(true);
      }
    };
  }

  @Bean
  PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
}
