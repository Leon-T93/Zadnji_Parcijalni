package algebra.spring_boot.security;

import algebra.spring_boot.Users.Users;
import algebra.spring_boot.Users.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Users> users = usersRepository.findByUsername(username);

        if (users.isEmpty()) {
            throw new UsernameNotFoundException("Wrong credentials");
        }
        return new CustomUserDetails(users.get());
    }
}
