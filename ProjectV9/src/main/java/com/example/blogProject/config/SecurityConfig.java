package com.example.blogProject.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


//시큐리티 영역
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    //패스워드 인코드
    @Bean
    PasswordEncoder psswordEncoder(){

        //passwordEncorder 은 인터페이스라 그것을 구현한 클래스를 이용해야 한다
        return new BCryptPasswordEncoder();


    }


    //이하 영역은 시큐리티가 무시
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/js/**","/css/**","/img/**");
    }


    //최소한의 코드로 확인할수 있는 계정
    //이름, 패스워드 , 권한 세가지 충족해야함 (WithUser,password,roles)
    @Override
    protected void configure(AuthenticationManagerBuilder auth)throws Exception{

        auth.inMemoryAuthentication().withUser("user1")
                .password("$2a$10$ruwATtfnK7brmLwO4WRiheH2kluid01UYAC.W/AJA8yFGrl97lYWq") //111
                .roles("USER");


    }


    //사이트 권한 (인가)
    @Override
    protected  void configure(HttpSecurity http)throws Exception{

        //url 접근제한
        http.authorizeRequests()
                .antMatchers("/").hasRole("USER") //권한이 있어야 볼수 있다.


                .and()


                //로그인
                .formLogin() // 로그인 실패시 로그인 화면으로
                .loginPage("/login/form")//로그인 페이지
                .usernameParameter("userId")//커스텀 파라메터 default : username
                .passwordParameter("password")//커스텀 파라메터 default : password
                .loginProcessingUrl("/login/perform")
                .defaultSuccessUrl("/login/success") //로그인 성공 url
                .failureUrl("/login/fail")// 로그인 실패 url

                .and()


                //로그아웃
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login/logout")
                .invalidateHttpSession(true)
                .and()
                .exceptionHandling().accessDeniedPage("/login/denied"); // 예외 = 접근거부 페이지





        http.csrf().disable(); //csrf 비활성
        http.logout(); // csrf 토큰 사용시 = post  / csrf 토큰 X  = get도 가능

    }

}
