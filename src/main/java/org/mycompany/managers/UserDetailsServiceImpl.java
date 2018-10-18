package org.mycompany.managers;

import org.mycompany.beans.ApplicationUser;
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
    private ApplicationUserManager applicationUserManager;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        List<ApplicationUser> applicationUser = applicationUserManager.findByUsername(username);
        if (applicationUser.isEmpty()) {
            throw new UsernameNotFoundException("User not found. username = " + username);
        }
        return new PrincipalUser(applicationUser.get(0));
    }
}
