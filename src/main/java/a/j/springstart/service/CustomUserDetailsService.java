/**
 * 
 */
package a.j.springstart.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import a.j.springstart.domain.User;
import a.j.springstart.domain.UserProfile;

/**
 * @author anjun
 *
 */
@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private UserService userService;

	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String ssoId) throws UsernameNotFoundException {
		User user = userService.findBySso(ssoId);
		logger.info("User : " + user);
		if (user == null) {
			System.out.println("User not found");
			throw new UsernameNotFoundException("Username not found");
		}
		return new org.springframework.security.core.userdetails.User(user.getSsoId(),
				user.getPassword(), user.getState().equals("Active"), true, true, true,
				getGrantedAuthorities(user));
	}

	private List<GrantedAuthority> getGrantedAuthorities(User user) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

		for (UserProfile userProfile : user.getUserProfiles()) {
			System.out.println("UserProfile : " + userProfile);
			authorities.add(new SimpleGrantedAuthority("ROLE_" + userProfile.getType()));
		}
		System.out.print("authorities :" + authorities);
		return authorities;
	}

}