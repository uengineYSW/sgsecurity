package com.posco.carmng.s20a01.config;

import com.posco.carmng.s20a01.service.UserDetailsServiceImpl;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.CorsUtils;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private WebApplicationContext applicationContext;

    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    @PostConstruct
    public void completeSetup() {
        userDetailsService =
            applicationContext.getBean(UserDetailsServiceImpl.class);
    }

    /**
     * 생성자에 @Lazy 를 쓰는 이유는 Autowired 시 bean 이 등록된 후에 실행을 하기 위해서 사용되어진다.
     * @param authenticationManager
     */
    public WebSecurityConfig(
        @Lazy AuthenticationManager authenticationManager
    ) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web
            .ignoring()
            .antMatchers("/css/**")
            .antMatchers("/vendor/**")
            .antMatchers("/js/**")
            .antMatchers("/favicon*/**")
            .antMatchers("/img/**")
            .antMatchers("/.well-known/jwks.json");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth)
        throws Exception {
        auth
            .userDetailsService(userDetailsService)
            .passwordEncoder(passwordEncoder);
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    /**
     * websecurity 부분에 핵심적인 endpoint 를 설정해 주는 부분이다.
     * 특정 uri 를 허락하고싶다면
     * .antMatchers("/login").permitAll() 등으로 사용이 가능하다.
     * 현재는 cors 의 preflight 부분만 허용하고 있다.
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .cors()
            .and()
            .authorizeRequests()
            .antMatchers("/api/auth/**", "/login.html")
            .permitAll()
            .antMatchers("/login", "/signup", "/public/**")
            .permitAll()
            .antMatchers("/actuator/**")
            .hasRole("ADMIN")
            .antMatchers("/api/**")
            .authenticated()
            .requestMatchers(CorsUtils::isPreFlightRequest)
            .permitAll()
            .anyRequest()
            .authenticated()
            .and()
            .csrf()
            .disable()
            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(
            Arrays.asList(
                "http://localhost:8082",
                "https://your-production-domain.com"
            )
        );
        configuration.setAllowedMethods(
            Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS")
        );
        configuration.setAllowedHeaders(
            Arrays.asList("Authorization", "Content-Type")
        );
        configuration.setExposedHeaders(Arrays.asList("Authorization"));
        configuration.setAllowCredentials(true);
        configuration.setMaxAge(3600L);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}
