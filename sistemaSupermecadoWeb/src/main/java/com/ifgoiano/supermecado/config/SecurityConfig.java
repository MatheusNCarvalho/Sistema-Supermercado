/**
 * 
 */
package com.ifgoiano.supermecado.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * @author brunn
 *
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
			.withUser("joao").password("joao").roles("CADASTRAR_VINHO").and()
			.withUser("maria").password("maria").roles("CADASTRAR_VINHO", "LISTAR_VINHO").and()
			.withUser("admin").password("admin").roles("CADASTRAR_VINHO", "LISTAR_VINHO", "LISTAR_FORNECEDORES");
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring()
			.antMatchers("/layout/**")
			.antMatchers("/css/**");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/produtos/novo").hasRole("CADASTRAR_VINHO")
				.antMatchers("/produtos/**").hasRole("LISTAR_VINHO")
				.antMatchers("/fornecedores/**").hasRole("LISTAR_FORNECEDORES")
				.anyRequest().authenticated()
				.and()
			.formLogin()
				.loginPage("/login")
				.permitAll()
				.and()
			.logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
	}
	
	
	
	
}
