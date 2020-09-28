package fr.afpa.projetregistation.security.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.HttpMethod;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import com.fasterxml.jackson.databind.ObjectMapper;

import fr.afpa.projetregistation.security.filter.JwtAuthenticationTokenFilter;
import fr.afpa.projetregistation.security.model.JwtToken;
import fr.afpa.projetregistation.security.service.JwtTokenService;
import fr.afpa.projetregistation.security.service.UtilisateurDetailService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UtilisateurDetailService utilisateurDetailService;

	@Autowired
	private JwtTokenService jwtTokenService;

	@Override
	protected void configure(AuthenticationManagerBuilder authManagerBuilder) throws Exception {
		authManagerBuilder.userDetailsService(utilisateurDetailService);
	}

	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Autowired
	private JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;

	protected void configure(HttpSecurity http) throws Exception {
		http.cors().and().csrf().disable().headers().frameOptions().disable()
				.and().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				.and().authorizeRequests()
				
				.antMatchers(HttpMethod.GET, "/helloresponsable").hasRole("RESPONSABLE")
				.antMatchers(HttpMethod.GET, "/helloemploye").hasAnyRole("EMPLOYE", "RESPONSABLE")
				
				.antMatchers("/login").permitAll()
				
				.anyRequest().authenticated()
				.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				.and()
				.addFilterBefore(this.jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);

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
				ObjectMapper objectMapper = new ObjectMapper();
				JwtToken tokens = jwtTokenService.createTokens(authentication);
				objectMapper.writeValue(httpServletResponse.getWriter(), tokens);
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

	@Bean
	public FilterRegistrationBean<CorsFilter> filterRegistrationBean() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration config = new CorsConfiguration();
		config.setAllowCredentials(true);
		config.addAllowedOrigin("*");
		config.addAllowedHeader("*");
		config.addAllowedMethod("*");
		source.registerCorsConfiguration("/**", config);
		FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<>(new CorsFilter(source));
		bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
		return bean;
	}

}
