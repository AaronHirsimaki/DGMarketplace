package hh.sof003.JavaDGMarketplace;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import java.util.List;
import java.util.ArrayList;

// import static method
import static org.springframework.security.web.util.matcher.AntPathRequestMatcher.antMatcher;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = true)
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig {
		
	    @Bean
	    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
	      http
	      .authorizeHttpRequests( authorize -> authorize
	        	.requestMatchers(antMatcher("/styles/styles.css")).permitAll()
	        	.requestMatchers(antMatcher("/home")).permitAll()
	        	.anyRequest().authenticated()
	      )
	      .formLogin((form) -> form
	    		  .loginPage("/login")
	          .permitAll()
	      )
	      .logout(logout -> logout
	    		  .logoutSuccessUrl("/home")
	          .permitAll()
	      );
	      return http.build();
	    }
	    
	    @Bean
	    public UserDetailsService userDetailsService() {
	        List<UserDetails> users = new ArrayList<UserDetails>();

	        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

	        UserDetails user1 = User
	        		.withUsername("user")
	        		.password(passwordEncoder.encode("user"))
	        		.roles("USER")
	        		.build();

	        users.add(user1);

	        UserDetails user2 = User
	        		.withUsername("admin")
	        		.password(passwordEncoder.encode("admin"))
	        		.roles("USER", "ADMIN")
	        		.build();

	    	users.add(user2);

	        return new InMemoryUserDetailsManager(users);
	    }
	    
	   

	}

