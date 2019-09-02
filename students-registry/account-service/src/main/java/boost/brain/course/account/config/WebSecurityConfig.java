package boost.brain.course.account.config;

import boost.brain.course.account.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.www.DigestAuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.DigestAuthenticationFilter;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

//    @Autowired
//    private BCryptPasswordEncoder bCryptPasswordEncoder;

//    @Bean
//    public PasswordEncoder passwordEncoder(){
//        PasswordEncoder encoder = new BCryptPasswordEncoder();
//        return encoder;
//    }
//
//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        web.ignoring().antMatchers("/api/account/**");
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//                .antMatchers("/", "/api/account/").permitAll()
//                .antMatchers( Constants.LOGIN_PREFIX).permitAll()
//                .antMatchers( Constants.REGISTRATION_PREFIX).permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .formLogin()
//                .loginPage(Constants.LOGIN_PREFIX)
//                .failureUrl("/login?error=true")
//                .usernameParameter("email")
//                .passwordParameter("password").permitAll()
//                .permitAll()
//                .and()
//                .logout()
//                .logoutRequestMatcher(new AntPathRequestMatcher(Constants.LOGOUT_PREFIX))
//                .logoutSuccessUrl(Constants.LOGOUT_PREFIX)
//                .permitAll();
//    }


//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//                .antMatchers("/").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .formLogin()
//                .loginPage("/login")
//                .permitAll()
//                .and()
//                .rememberMe()
//                .and()
//                .logout()
//                .permitAll();
//    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .passwordEncoder(NoOpPasswordEncoder.getInstance())
                .usersByUsernameQuery("select account_email, account_password from accounts where account_email=?")
                .authoritiesByUsernameQuery("select acc.account_email, ar.account_role from accounts acc inner join account_role ar on acc.account_email = ar.role_email where acc.account_email=?");
            }



    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
                .addFilter(digestAuthenticationFilter())              // register digest entry point
                .exceptionHandling().authenticationEntryPoint(digestEntryPoint())       // on exception ask for digest authentication
                .and()
                .httpBasic()                      // it indicate basic authentication is requires
                .and()
                .authorizeRequests()
                .antMatchers(  "/home", "/api/**").permitAll() // no need of any authentication
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/secure")
                .permitAll()
                .and()
                .rememberMe()
                .and()
                .logout()
                .permitAll();

    }


    DigestAuthenticationFilter digestAuthenticationFilter() throws Exception {
        DigestAuthenticationFilter digestAuthenticationFilter = new DigestAuthenticationFilter();
        digestAuthenticationFilter.setUserDetailsService(userDetailsServiceBean());
        digestAuthenticationFilter.setAuthenticationEntryPoint(digestEntryPoint());
        return digestAuthenticationFilter;
    }

    @Bean
    DigestAuthenticationEntryPoint digestEntryPoint() {
        DigestAuthenticationEntryPoint bauth = new DigestAuthenticationEntryPoint();
        bauth.setRealmName("Alex");
        bauth.setKey("MySecureKey");
        return bauth;
    }
    @Bean
    public AuthenticationManager customAuthenticationManager() throws Exception {
        return authenticationManager();
    }
}
