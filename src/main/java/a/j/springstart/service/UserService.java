/**
 * 
 */
package a.j.springstart.service;

import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;

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
	
//    List<User> findAllUsers();
//    
//    @Secured("ROLE_ADMIN")
//    void updateUser(User user);
// 
//    @Secured({ "ROLE_DBA", "ROLE_ADMIN" })
//    void deleteUser();
    
//    @PostAuthorize ("returnObject.type == authentication.name")
//    User findById(int id);
// 
//    @PreAuthorize("hasRole('ADMIN')")
//    void updateUser(User user);
//     
//    @PreAuthorize("hasRole('ADMIN') AND hasRole('DBA')")
//    void deleteUser(int id);
    
     
}