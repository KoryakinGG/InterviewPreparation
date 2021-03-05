package ru.koryaking.eigthhomework;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private UserDetailsService userDetailsService;

    @Autowired
    public void setUserDetailsService(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void configure (HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/authenticated/**").authenticated() // если хочет пройти по этому адресу, то не должен быть гостем
                .antMatchers("/admins/**").hasAuthority("ADMIN") // должен иметь роль АДМИНА
                .antMatchers("/manager/**").hasAuthority("MANAGER") // должен иметь роль АДМИНА
                .antMatchers("/user/**").hasAuthority("USER") // должен иметь роль АДМИНА
                .anyRequest().permitAll() //по всем остальным не указанным запросам гость может ходить
                .and()
                .httpBasic() // форма для ввода логина и пароля
                .and()
                .csrf().disable()
                .logout().logoutSuccessUrl("/"); //юзер выходит, то попадает по этому адресу
    }
    // преобразует пароль из базы в кри
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        authenticationProvider.setUserDetailsService(userDetailsService);
        return authenticationProvider;
    }
}
