package by.gergalov.max.course.service.user;


import by.gergalov.max.course.entity.User;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

//http://stackoverflow.com/questions/1866225/how-to-manage-a-custom-user-object-in-session-when-spring-security-autheticates
public class CustomUserDetails extends org.springframework.security.core.userdetails.User{

    private User user;

    public CustomUserDetails(User user, Collection<? extends GrantedAuthority> authorities) {
        super(user.getName(), user.getPassword(), authorities);
        this.user = user;
    }

    public CustomUserDetails(User user, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
        super(user.getName(), user.getPassword(), enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
