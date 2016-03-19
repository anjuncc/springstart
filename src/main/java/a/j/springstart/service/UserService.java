/**
 * 
 */
package a.j.springstart.service;

import a.j.springstart.domain.User;

/**
 * @author anjun
 *
 */
public interface UserService {
	 
    User findById(int id);
     
    User findBySso(String sso);

	/**
	 * @param user
	 */
	void save(User user);
     
}