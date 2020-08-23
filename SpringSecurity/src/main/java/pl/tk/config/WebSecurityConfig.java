package pl.tk.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    //Ćwiczenie 7
/*    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin().loginPage("/login")
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/student").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.POST, "/student").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.GET, "/student/list").authenticated()
                .antMatchers(HttpMethod.GET, "/grade").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.POST, "/grade").hasAuthority("ADMIN")
                .anyRequest().permitAll().and().rememberMe().tokenValiditySeconds(30);
    }*/

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin().loginPage("/login").and().authorizeRequests()
                .antMatchers(HttpMethod.GET, "/student").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.POST, "student").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.GET, "/grade").fullyAuthenticated()
                .antMatchers(HttpMethod.POST, "/grade").hasAuthority("ADMIN")
                .anyRequest().permitAll();
    }

    //Ćwiczenie 6
/*    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin().loginPage("/login").and().authorizeRequests()
                .antMatchers(HttpMethod.GET, "/student").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.POST, "/student").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.GET, "/student/list").authenticated()
                .antMatchers(HttpMethod.GET, "/grade").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.POST, "/grade").hasAuthority("ADMIN")
                .anyRequest().permitAll();
    }*/

    //Ćwiczenie 5
/*    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin().and().authorizeRequests()
                .antMatchers(HttpMethod.GET, "/student").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.POST, "/student").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.GET, "/student/list").authenticated()
                .antMatchers(HttpMethod.GET, "/grade").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.POST, "/grade").hasAuthority("ADMIN")
                .anyRequest().permitAll();
    }*/


    //hasAuthority vs hasRole ---> ROLE_

    //Ćwiczenie 4
/*    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.userDetailsService(new MyUserService());
    }*/


    //Ćwiczenie 3
/*    @Autowired
    DataSource dataSource;


    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(new BCryptPasswordEncoder());
    }*/

    //Ćwiczenie 2
/*  @Autowired
    DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource);
    }*/

    //ćwiczenie 1
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("marian").password("{noop}marian12345").authorities("USER").and()
                .withUser("admin").password("{noop}admin").authorities("USER", "ADMIN").and()
                .withUser("mariola").password("{noop}1qaz@WSX").authorities("GUEST").and()
                .withUser("jaroslaw").password("{noop}donald123").authorities("USER").accountLocked(true);
    }



    //dodatkowe
/*    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.formLogin().and().authorizeRequests()
                .antMatchers(HttpMethod.GET, "/student/list").hasAnyAuthority("ROLE_USER", "ROLE_ADMIN")
                .antMatchers(HttpMethod.GET, "/student/add").hasAuthority("ROLE_USER")
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("https://wp.pl");
    }*/
}
