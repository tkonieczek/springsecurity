package pl.tk.config;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

//Zadanie 4
public class MyUserService implements UserDetailsService {

    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserData userData = userRepository.getUserByName(username);
        if (userData != null) {
            List<String> userAuthorities = userData.getAuthorities();
            List<GrantedAuthority> authorities = new ArrayList<>();
            for (String userAuthority : userAuthorities) {
                authorities.add(new SimpleGrantedAuthority(userAuthority));
            }
            return new User(userData.getName(), userData.getPassword(), authorities);
        }
        throw new UsernameNotFoundException("Nie znaleziono użytkownika '" + username + "'.");
    }
}
