/**
 * 
 */
package a.j.springstart.dao;

import a.j.springstart.domain.User;

/**
 * @author anjun
 *
 */
public interface UserDao {
	 
    User findById(int id);
     
    User findBySSO(String sso);
     
}