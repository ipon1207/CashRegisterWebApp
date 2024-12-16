package com.example.auto_record.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Autowired
    private UserDetailsService userDetailsService;

    /* ログイン・ログアウトの認証設定 */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                /* ログインページの許可設定 */
                // フォーム認証を利用
                .formLogin(login -> login
                        // login.htmlをログインページに設定
                        .loginPage("/toLogin")
                        // 認証成功時はmain.htmlへ遷移
                        .defaultSuccessUrl("/main", true)
                        .permitAll()
                )

                /* リクエストの許可設定 */
                .authorizeHttpRequests(authz -> authz
                        // index.htmlの参照権限
                        .requestMatchers("/")
                        .permitAll()
                        // main.htmlの参照権限
                        .requestMatchers("/main")
                        .hasAnyRole("USER", "ADMIN")
                        // admin.htmlの参照権限
                        .requestMatchers("/admin/**")
                        .hasRole("ADMIN")
                )

                /* ログアウトの設定 */
                .logout(logout -> logout
                        // ログアウト後にログインページへリダイレクト
                        .logoutSuccessUrl("/toLogin")
                        .permitAll()
                );

        return http.build();
    }

    /* DBとの連携による認証 */
    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        // ハッシュ化されたパスワードの認証
        provider.setPasswordEncoder(new BCryptPasswordEncoder(12));
        provider.setUserDetailsService(userDetailsService);
        return provider;
    }

}