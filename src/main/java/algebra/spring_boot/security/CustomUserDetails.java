package algebra.spring_boot.security;

import algebra.spring_boot.Users.Users;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CustomUserDetails implements UserDetails {

    private String username;

    private String password;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return new ArrayList<>();
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    public CustomUserDetails(Users users) {
        this.username = users.getUsername();
        this.password = users.getPassword();
    }

    public CustomUserDetails(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
