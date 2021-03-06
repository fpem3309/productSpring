package com.home.prospring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/","/account/**","/css/**","/images/**",
                        "/cenAsiaGallery","/esAsiaGallery","/europeGallery","/indiaGallery",
                        "/meAsiaGallery","/ncAmericaGallery","/sAmericaGallery").permitAll()
                .anyRequest().authenticated()   // 전체 접근 허용
                .and()
                .formLogin()
                .loginPage("/account/login")
                .permitAll()
                .and()
                .logout()
                .permitAll();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                //.passwordEncoder(passwordEncoder())
                .usersByUsernameQuery("select name,password,enabled "  //인증처리
                        + "from member "
                        + "where name = ?")
                .authoritiesByUsernameQuery("select u.name, r.name "   //권한처리
                        + "from user_role ur inner join member u on ur.user_id = u.id "
                        + "inner join role r on ur.role_id = r.id "
                        + "where u.name = ?");
        /**
         * Authentication 로그인 인증
         * Authroization 권한
         */
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
