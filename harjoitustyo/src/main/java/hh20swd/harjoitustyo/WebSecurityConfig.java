package hh20swd.harjoitustyo;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import hh20swd.harjoitustyo.webcontroller.UserDetailsServiceImpl;

	@Configuration
	@EnableGlobalMethodSecurity(prePostEnabled = true)
	@EnableWebSecurity
	public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
		@Autowired
		private UserDetailsServiceImpl userDetailsService;
		
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.authorizeRequests()
			.antMatchers("/css/**", "/sarjalista").permitAll()
			.antMatchers("/", "/poistasarja/{id}", "/muokkaasarja/**", "/lisaasarja").hasAuthority("ADMIN")
					.anyRequest().authenticated()
					.and()
					.formLogin().loginPage("/login").permitAll()
					.defaultSuccessUrl("/sarjalista")
			          .permitAll()
					.and().logout()
					.permitAll();
		}
			
	
			@Autowired
			public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
			auth.userDetailsService(userDetailsService).passwordEncoder(new
			BCryptPasswordEncoder());
			}
			
			@Bean
			@Override
			public UserDetailsService userDetailsService() {
				List<UserDetails> users = new ArrayList();
				UserDetails user = User.withDefaultPasswordEncoder().username("user").password("password").roles("USER")
						.build();

				users.add(user);

				user = User.withDefaultPasswordEncoder().username("admin").password("password").roles("USER", "ADMIN").build();

				users.add(user);

				return new InMemoryUserDetailsManager(users);
			}

		}
