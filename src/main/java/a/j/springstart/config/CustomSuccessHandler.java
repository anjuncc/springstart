/**
 * 
 */
package a.j.springstart.config;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import a.j.springstart.domain.User;
import a.j.springstart.domain.UserProfile;
import a.j.springstart.service.UserService;

/**
 * @author anjun
 *
 */
@Component
public class CustomSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	@Autowired
	private UserService userService;

	@Override
	protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException {
		String targetUrl = determineTargetUrl(authentication);

		if (response.isCommitted()) {
			logger.debug("Can't redirect");
			return;
		}

		redirectStrategy.sendRedirect(request, response, targetUrl);
	}

	protected String determineTargetUrl(Authentication authentication) {
		String url = "";

		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

		List<String> roles = new ArrayList<String>();

		for (GrantedAuthority a : authorities) {
			roles.add(a.getAuthority());
		}

		if (isDba(roles)) {
			url = "/db";
		} else if (isAdmin(roles)) {
			url = "/admin";
		} else if (isUser(roles)) {
			url = "/home";
		} else {
			url = "/accessDenied";
		}

		return url;
	}

	public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
		this.redirectStrategy = redirectStrategy;
	}

	protected RedirectStrategy getRedirectStrategy() {
		return redirectStrategy;
	}

	private boolean isUser(List<String> roles) {
		if (roles.contains("ROLE_USER")) {
			return true;
		}
		return false;
	}

	private boolean isAdmin(List<String> roles) {
		if (roles.contains("ROLE_ADMIN")) {
			return true;
		}
		return false;
	}

	private boolean isDba(List<String> roles) {
		if (roles.contains("ROLE_DBA")) {
			return true;
		}
		return false;
	}

//	@Transactional(readOnly = true)
//	public UserDetails loadUserByUsername(String ssoId) throws UsernameNotFoundException {
//		User user = userService.findBySso(ssoId);
//		System.out.println("User : " + user);
//		if (user == null) {
//			System.out.println("User not found");
//			throw new UsernameNotFoundException("Username not found");
//		}
//		return new org.springframework.security.core.userdetails.User(user.getSsoId(), user.getPassword(),
//				user.getState().equals("Active"), true, true, true, getGrantedAuthorities(user));
//	}
//
//	private List<GrantedAuthority> getGrantedAuthorities(User user) {
//		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
//
//		for (UserProfile userProfile : user.getUserProfiles()) {
//			System.out.println("UserProfile : " + userProfile);
//			authorities.add(new SimpleGrantedAuthority("ROLE_" + userProfile.getType()));
//		}
//		System.out.print("authorities :" + authorities);
//		return authorities;
//	}
}
