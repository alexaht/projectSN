package loc.sn.dao.admin.User;

import loc.sn.model.admin.User;

import java.util.List;

/**
 * Created by oleksiy on 22.08.16.
 */
public interface UserDao {

    List<User> findAllUsers();

    User findById(int id);

    void saveUser(User user);

    void deleteUser(String id);

}
