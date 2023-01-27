package com.BackendEcomerce.security;


import com.BackendEcomerce.security.jwt.JwtEntryPoint;
import com.BackendEcomerce.security.jwt.JwtTokenFilter;
import com.BackendEcomerce.security.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
//con perPostEnabled se usa para indicar a q metodos puede acceder solo el admin
// Los metodos que no lleven anotación pueden acceder el admin como un generic user
// @preauthorized solo puede acceder el admin
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MainSecurity extends WebSecurityConfigurerAdapter {

   @Autowired
   UserDetailsServiceImpl userDetailsService;

   //Devuelve el mensaje de no autorizado
   @Autowired
   JwtEntryPoint jwtEntryPoint;

   @Bean
   public JwtTokenFilter jwtTokenFilter() {
      return new JwtTokenFilter();
   }

   @Bean
   public PasswordEncoder passwordEncoder() {
      return new BCryptPasswordEncoder();
   }

   @Override
   public void configure(AuthenticationManagerBuilder auth) throws Exception {
      auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
   }

   @Bean
   @Override
   public AuthenticationManager authenticationManagerBean() throws Exception {
      return super.authenticationManagerBean();
   }

   @Override
   protected AuthenticationManager authenticationManager() throws Exception {
      return super.authenticationManager();
   }

   @Override
   protected void configure(HttpSecurity http) throws Exception {
      //Desactivamos cookies ya que enviamos un token
      // cada vez que hacemos una petición
      http.cors().and().csrf().disable()
            .authorizeRequests()
            .antMatchers("/auth/**").permitAll()
            //   .antMatchers("/api/**").hasAuthority("ROLE_ADMIN")
            // .antMatchers("/ordenes/listar").hasAuthority("ROLE_USER").anyRequest().authenticated()
            // .antMatchers("/api/producto").hasAuthority("ROLE_USER")

            /*   .antMatchers("/producto/**").hasAuthority("ROLE_EMPRESA")
               .antMatchers("/api/cliente_empresa").hasAuthority("ROLE_EMPRESA")
               .antMatchers("/api/direccion").hasAuthority("ROLE_EMPRESA")
               .antMatchers("/api/feedback").hasAuthority("ROLE_EMPRESA")*/

            //   .anyRequest().authenticated()
            .and()
            .exceptionHandling().authenticationEntryPoint(jwtEntryPoint)
            .and()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
      http.addFilterBefore(jwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
   }
}
