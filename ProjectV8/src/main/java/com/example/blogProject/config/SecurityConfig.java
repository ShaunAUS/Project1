package com.example.blogProject.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


//시큐리티 영역
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Bean
    PasswordEncoder psswordEncoder(){

        //passwordEncorder 은 인터페이스라 그것을 구현한 클래스를 이용해야 한다
        return new BCryptPasswordEncoder();


    }

    //최소한의 코드로 확인할수 있는 계정
    @Override
    protected void configure(AuthenticationManagerBuilder auth)throws Exception{

        auth.inMemoryAuthentication().withUser("user1")
                /*.password()*/
                .roles("user");


    }


    //사이트 권한 (인가)
    @Override
    protected  void configure(HttpSecurity http)throws Exception{

        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/").hasRole("USER"); //권한이 있어야 볼수 있다.

        http.formLogin(); // 로그인 실패시 로그인 화면으로

    }

}
