/**
 * 
 */
package a.j.springstart.dao;



import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import a.j.springstart.domain.User;

/**
 * @author anjun
 *
 */
@Repository("userDao")
public class UserDaoImpl extends AbstractDao<Integer, User> implements UserDao {
 
    public User findById(int id) {
        return getByKey(id);
    }
 
    public User findBySSO(String sso) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("ssoId", sso));
        User u= (User) crit.uniqueResult();
  
        String hql = "FROM User";
        Query query = getSession().createQuery(hql);
        List results = query.list();
      
        return u;
    }
 
     
}