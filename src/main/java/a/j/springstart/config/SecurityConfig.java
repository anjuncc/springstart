/**
 * 
 */
package a.j.springstart.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author anjun
 *
 */

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("user").password("password").roles("USER");
		auth.inMemoryAuthentication().withUser("admin").password("root123").roles("ADMIN");
		auth.inMemoryAuthentication().withUser("dba").password("root123").roles("ADMIN", "DBA");
		logger.info("configureGlobal");
	}

//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http
//		.authorizeRequests()
//			.anyRequest().authenticated()
//			.and()
//		.formLogin().and()
//		.httpBasic();
//		http.authorizeRequests().antMatchers("/", "/index/index").permitAll().antMatchers("/admin/**")
//				.access("hasRole('ADMIN')").antMatchers("/db/**").access("hasRole('ADMIN') and hasRole('DBA')").and()
//				.formLogin().and().exceptionHandling().accessDeniedPage("/Access_Denied");
//	}
}
