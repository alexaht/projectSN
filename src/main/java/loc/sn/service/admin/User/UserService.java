package loc.sn.service.admin.User;

import loc.sn.model.admin.User;

import java.util.List;

/**
 * Created by oleksiy on 22.08.16.
 */
public interface UserService {

    User findById(int id);

    List<User> findAllUsers();

    void saveUser(User user);

    void updateUser(User user);

    void deleteUser(String id);
}
