package com.derek.nasa_social_media_app.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

import com.derek.nasa_social_media_app.component.DataService;
import com.derek.nasa_social_media_app.component.UserProfileService;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration {


@Autowired
private UserProfileService userProfileService;

// @Autowired
// private DataService data;
 
 
 
    @Bean
     public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
         return httpSecurity
                 .cors(cors -> cors.configurationSource(corsConfigurationSource()))
                 .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(registry -> {

                registry.requestMatchers("/users/posts","/save","/user-posts","/profile/derek","/getNames/derek","/profile","/h2-console","/users/get", "/home","/names","/posts","/register/**","/verify")
                .permitAll();
                registry.requestMatchers("/admin/**").hasRole("ADMIN");
                registry.anyRequest().authenticated();

            }).headers(httpSecurityHeadersConfigurer -> {
                httpSecurityHeadersConfigurer
                    .frameOptions(HeadersConfigurer.FrameOptionsConfig::disable); // This disables X-Frame-Options
            }).formLogin(httpSecurityFormLoginConfigurer -> {
                httpSecurityFormLoginConfigurer
                        .loginPage("/login")
                        .successHandler(new SuccessHandler())
                        .permitAll();
            })
            .build();

            // .formLogin(AbstractAuthenticationFilterConfigurer::permitAll)
            // .build();
                
}

  @Bean
    public UserProfileService myUserProfileService() {
        return userProfileService;
    }

    // @Bean
    // public DataService myDataService(){
    // return data;
    // }
 @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userProfileService);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }


      @Bean
     public PasswordEncoder passwordEncoder() {
         return new BCryptPasswordEncoder();
     }

     @Bean
     public CorsConfigurationSource corsConfigurationSource() {
         CorsConfiguration configuration = new CorsConfiguration();
         configuration.setAllowedOriginPatterns(List.of("http://localhost:*"));
         configuration.addAllowedMethod("*");
         configuration.addAllowedHeader("*");
         configuration.setAllowCredentials(true);
         UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
         source.registerCorsConfiguration("/**", configuration);
         return source;
     }

}
