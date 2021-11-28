package com.sportyshoes.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;


@Configuration
@PropertySource("classPath:persistence-mysql.properties")
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	//Add a reference to our security data source
	
	@Autowired
	private DataSource securityDataSource;
	
	//ByCrypt configuration
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Value("${spring.queries.users-query}")
	private String usersQuery;

	@Value("${spring.queries.roles-query}")
	private String rolesQuery;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		// Add our users for memory authentication
		
		auth.jdbcAuthentication().usersByUsernameQuery(usersQuery).authoritiesByUsernameQuery(rolesQuery)
		.dataSource(securityDataSource).passwordEncoder(bCryptPasswordEncoder);
		
		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
//		http.authorizeRequests()
//		.antMatchers("/").hasRole("ADMIN_USER")
//		.antMatchers("/leaders/**").hasRole("ADMIN_USER")
//		.antMatchers("/systems/**").hasRole("ADMIN_USER")
//		.and()
//		.formLogin()
//			.loginPage("/login")
//			.loginProcessingUrl("/authenticateTheUser")
//			.permitAll()
//			.and()
//			.logout().permitAll()
//			.and()
//			.exceptionHandling().accessDeniedPage("/access-denied");
		

		http.authorizeRequests()
				// URLs matching for access rights
				.antMatchers("/").permitAll()
				.antMatchers("/login").permitAll()
				.antMatchers("/register").permitAll()
				.antMatchers("/shoe/kids").permitAll()
				.antMatchers("/shoe/men").permitAll()
				.antMatchers("/shoe/women").permitAll()
				
				.antMatchers("/shoe/newShoe").hasAnyAuthority("ADMIN_USER")
				.antMatchers("/purchase/buy").permitAll()
				//hasAnyAuthority("SUPER_USER", "ADMIN_USER", "SITE_USER")
				.anyRequest().authenticated()
				.and()
				// form login
				.csrf().disable().formLogin()
				.loginPage("/login")
				.loginProcessingUrl("/authenticateTheUser")
				.permitAll()
				.failureUrl("/login?error=true")
				.usernameParameter("email")
				.passwordParameter("password")
				.and()
				// logout
				.logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.logoutSuccessUrl("/").and()
				.exceptionHandling()
				.accessDeniedPage("/access-denied");
	}
	

	  @Override
		public void configure(WebSecurity web) throws Exception {
			web.ignoring().antMatchers("/resources/**","/resource/**",  "/static/**", "/css/**", "/js/**", "/images/**");
		}
	
	
	

}
