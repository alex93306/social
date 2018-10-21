package org.mycompany.managers;

import org.mycompany.beans.AppUser;
import org.mycompany.beans.PrincipalUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private AppUserManager appUserManager;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        AppUser appUser = appUserManager.findByUsername(username);
        if (appUser == null) {
            throw new UsernameNotFoundException("User not found. username = " + username);
        }
        return new PrincipalUser(appUser);
    }
}
