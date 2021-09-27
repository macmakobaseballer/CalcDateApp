package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	//セキュリティの対象外を設定
	@Override
	public void configure (WebSecurity web) throws Exception {
		
		//セキュリティを適用しない
		web
		  .ignoring()
		    .antMatchers("/webjars/**")
		    .antMatchers("/css/**")
		    .antMatchers("/js/**")
		    .antMatchers("/h2-console/**");
		
	}
	//セキュリティの各種設定
	@Override
	protected void configure (HttpSecurity http) throws Exception {
		
		//ログイン不要ページの設定
		http
		  .authorizeRequests()
		    .antMatchers("/login").permitAll()//直リンクOK
		    .antMatchers("/user/signup").permitAll()//直リンクOK
		    .anyRequest().authenticated();//それ以外は直リンク禁止
		
		//ログイン処理
		http
		  .formLogin()
		    .loginProcessingUrl("/login")//ログイン処置のパス
		    .loginPage("/login")//ログインページの指定
		    .failureUrl("/login?error")//ログイン失敗時の遷移先
		    .usernameParameter("userId")//ログインページのユーザーId
		    .passwordParameter("password")//ログインページのパスワード
		    .defaultSuccessUrl("/calc" , true);//成功後の遷移先
		

		//h2consoleを使用可能（SpringSecurityを入れている場合consoleで接続を拒否される）
		http.headers().frameOptions().disable();

		//CSRF処理の無効化（一時）
		http.csrf().disable();
	}
	
	//認証設定（インメモリ）
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		PasswordEncoder encoder = passwordEncoder();
		//インメモリ認証
		auth
		  .inMemoryAuthentication()
		    .withUser("user")
		      .password(encoder.encode("user"))
		        .roles("GENERAL")
		    .and()
		    .withUser("admin")
		      .password(encoder.encode("admin"))
		        .roles("ADMIN");
		
	}
		    
	
}
