package br.com.nfx.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private DataSource datasource;
	
	@Value("${spring.queries.users-query}")
	private String usersQuery;
	
	@Value("${spring.queries.roles-query}")
	private String rolesQuery;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.
		jdbcAuthentication()
			.usersByUsernameQuery(usersQuery)
			.authoritiesByUsernameQuery(rolesQuery)
			.dataSource(datasource)
			.passwordEncoder(bCryptPasswordEncoder)
			;
		 
		//System.out.println("AUTHENTICATION DETAILS: " + authentication.getDetails());
//		auth.inMemoryAuthentication()
//			.withUser("joao").password("joao").roles("CADASTRAR_VINHO").and()
//			.withUser("maria").password("maria").roles("CADASTRAR_VINHO", "LISTAR_VINHO");
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring()
			.antMatchers("/javax.faces.resource/**")
			.antMatchers("/templates/**");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http
		  .authorizeRequests()
	          .antMatchers("/index.jsf", "/javax.faces.resource/**").permitAll()
	          .antMatchers("/error/404.jsf", "/error/500.jsf", "/error/403.jsf").permitAll() // Precisa estar autenticado
	          .antMatchers("/GestaoEmpresas.jsf").hasAuthority("GESTAO_EMPRESAS") // Precisa ter permissão de...
	          .antMatchers("/GestaoTitulos.jsf").hasAuthority("GESTAO_TITULOS")
	          .antMatchers("/GestaoUsuarios.jsf").hasAuthority("GESTAO_USUARIOS")
	          .antMatchers("/relatorios/**").hasAnyRole("ADMINISTRADORES", "VENDEDORES")
	          .antMatchers("/usuarios/**").hasAnyRole("ADMINISTRADORES")
				.and()
			.formLogin()
				.loginPage("/index.jsf")
				 .failureUrl("/index.jsf?invalid=true")
				.permitAll()
				.and()
			.logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				 .and()
			     .exceptionHandling().accessDeniedPage("/error/403.jsf")
				.and()
				.rememberMe()
				.tokenRepository(persistentTokenRepository())
				.key("rem-me-key")
				.rememberMeParameter("remember-me")
				.rememberMeCookieName("my-remember-me")
				.tokenValiditySeconds(86400); 
	}
	
	
	@Bean
	public PersistentTokenRepository persistentTokenRepository() {
		JdbcTokenRepositoryImpl tokenRepository = new JdbcTokenRepositoryImpl();
		tokenRepository.setDataSource(datasource);
		return tokenRepository;
	}
}
