package loc.sn.dao.admin.User;

import loc.sn.dao.AbstractDao;
import loc.sn.model.admin.User;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by oleksiy on 22.08.16.
 */
@Repository("userDao")
public class UserDaoImpl extends AbstractDao<Integer, User> implements UserDao {

    public List<User> findAllUsers() {
        Criteria criteria = createEntityCriteria();
        return (List<User>) criteria.list();
    }

    public User findById(int id) {
        return getByKey(id);
    }

    public void saveUser(User user) {
        persist(user);
    }

    public void deleteUser(String id) {
        Query query = getSession().createQuery("delete from User where id = :id");
        query.setString("id", id);
        query.executeUpdate();
    }
}
