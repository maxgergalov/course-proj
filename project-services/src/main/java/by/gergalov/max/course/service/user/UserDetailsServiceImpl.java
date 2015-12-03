package by.gergalov.max.course.service.user;


import by.gergalov.max.course.common.roles.UserRole;
import by.gergalov.max.course.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * A custom {@link UserDetailsService} where user information
 * is retrieved from a JPA repository
 */
@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {
        UserDetails userDetails = null;
        try {

            User user = userService.getByMail(username);

            userDetails = new CustomUserDetails(user,
                    true, true, true, true,
                    getAuthorities(user.getRole()));

        } catch (Exception e) {
            throw new UsernameNotFoundException("Error in retrieving user");
        }

        return userDetails;
    }

    public Collection<GrantedAuthority> getAuthorities(UserRole role) {

        List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>(2);
        //http://stackoverflow.com/questions/1750435/comparing-java-enum-members-or-equals
        if (role == UserRole.ROLE_ADMIN) {
            authList.add(new SimpleGrantedAuthority(UserRole.ROLE_ADMIN.name()));
        }
        authList.add(new SimpleGrantedAuthority(UserRole.ROLE_USER.name()));

        return authList;
    }
}
