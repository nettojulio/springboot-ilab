package br.com.exercicios.ilab.ecommerce.pgsql.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration 			
@EnableWebSecurity      
public class EcommerceSecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private EcommerceEntryPoint entryPoint; 
	
	
	public void configure(HttpSecurity httpSec) throws Exception{
		System.out.println("--> SETUP da configuração de segurança...");
		
		
		httpSec.csrf().disable()
					  .exceptionHandling().authenticationEntryPoint(entryPoint)
					  .and()
					  .authorizeRequests()
					  .antMatchers(HttpMethod.GET, "/produtos").permitAll()
					  .antMatchers(HttpMethod.GET, "/produtos/*").permitAll()
					  .antMatchers(HttpMethod.POST, "/login").permitAll()
					  .antMatchers(HttpMethod.GET,"/usuarios").permitAll()
					  .antMatchers(HttpMethod.GET,"/usuarios/*").permitAll()
					  .antMatchers(HttpMethod.POST, "/usuarios*").permitAll()
					  .antMatchers(HttpMethod.PUT, "/usuarios/*").permitAll()
					  .anyRequest().authenticated().and().cors();
		
		
		httpSec.addFilterBefore(new EcommerceFilter(), UsernamePasswordAuthenticationFilter.class);
		
	}
}
