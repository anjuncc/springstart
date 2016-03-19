/**
 * 
 */
package a.j.springstart.dao;

import java.util.List;

import a.j.springstart.domain.UserProfile;

/**
 * @author anjun
 *
 */
public interface UserProfileDao {
	List<UserProfile> findAll();

	UserProfile findByType(String type);

	UserProfile findById(int id);
}
