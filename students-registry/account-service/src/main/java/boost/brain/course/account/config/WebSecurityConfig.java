package boost.brain.course.account.config;

import boost.brain.course.account.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers( Constants.LOGIN_PREFIX).permitAll()
                .antMatchers( Constants.REGISTRATION_PREFIX).permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage(Constants.LOGIN_PREFIX)
                .failureUrl("/login?error=true")
                .usernameParameter("email")
                .passwordParameter("password").permitAll()
                .permitAll()
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher(Constants.LOGOUT_PREFIX))
                .logoutSuccessUrl(Constants.LOGOUT_PREFIX)
                .permitAll();
    }


//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//                .antMatchers("/", "/registration", "/static/**", "/activate/*").permitAll()
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
                .usersByUsernameQuery("select email, password from accounts where email=?")
                .dataSource(dataSource)
                .passwordEncoder(bCryptPasswordEncoder);
            }
}
