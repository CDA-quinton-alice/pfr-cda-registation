package fr.afpa.projetregistation.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UtilisateurDetailService utilisateurDetailService;

	@Override
	protected void configure(AuthenticationManagerBuilder authManagerBuilder) throws Exception {
		authManagerBuilder.userDetailsService(utilisateurDetailService);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers(HttpMethod.POST, "/user").authenticated() // seuls les utilisateurs
																						// authtifiés ont accès
																						// à
																						// cette url
				.antMatchers(HttpMethod.GET, "/user/*").authenticated().antMatchers(HttpMethod.DELETE, "/user/*")
				.authenticated().antMatchers("/user").authenticated().anyRequest().permitAll() // toutes les autres url
																								// sont accessibles
				.and().csrf().disable() // authoriser l'envoi de donnée depuis des formulaire non genenrés depuis le
				.formLogin();
		// back-end
//				.formLogin().loginProcessingUrl("/login") // personnaliser l'url d'authentification
//				.successHandler(successHandler()) // succes authentification
//				.failureHandler(failureHandler()) // echec authentification
//				.and().exceptionHandling().authenticationEntryPoint(authenticationEntryPoint()) // utilisateur avec
		// session mais sans
		// droit sspring
		// suffisant et tente
		// d'acceder à l'url
//				.accessDeniedHandler(accessDeniedHandler()) // utilisateur sans session donc sans droit et tente
		// d'acceder à l'url
//				.and().headers().frameOptions().disable()// authoriser les requetes genenrées depuis des frames
		;
	}

	private AuthenticationEntryPoint authenticationEntryPoint() {
		return new AuthenticationEntryPoint() {
			@Override
			public void commence(HttpServletRequest request, HttpServletResponse response,
					AuthenticationException authException) throws IOException, ServletException {
				response.setStatus(403);
			}
		};
	}

	private AccessDeniedHandler accessDeniedHandler() {
		return new AccessDeniedHandler() {
			@Override
			public void handle(HttpServletRequest request, HttpServletResponse httpServletResponse,
					AccessDeniedException accessDeniedException) throws IOException, ServletException {
				httpServletResponse.getWriter().append("KO");
				httpServletResponse.setStatus(403);
			}
		};
	}

	private AuthenticationSuccessHandler successHandler() {
		return new AuthenticationSuccessHandler() {
			@Override
			public void onAuthenticationSuccess(HttpServletRequest httpServletRequest,
					HttpServletResponse httpServletResponse, Authentication authentication)
					throws IOException, ServletException {
				httpServletResponse.getWriter().append("OK");
				httpServletResponse.setStatus(200);
			}
		};
	}

	private AuthenticationFailureHandler failureHandler() {
		return new AuthenticationFailureHandler() {
			@Override
			public void onAuthenticationFailure(HttpServletRequest httpServletRequest,
					HttpServletResponse httpServletResponse, AuthenticationException e)
					throws IOException, ServletException {
				httpServletResponse.getWriter().append("Authentication failure");
				httpServletResponse.setStatus(401);
			}
		};
	}
}
