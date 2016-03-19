/**
 * 
 */
package a.j.springstart.service;

import java.util.List;

import a.j.springstart.domain.UserProfile;

/**
 * @author anjun
 *
 */
public interface UserProfileService {
	 
    List<UserProfile> findAll();
     
    UserProfile findByType(String type);
     
    UserProfile findById(int id);
}