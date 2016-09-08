package loc.sn.service.admin.User;

import loc.sn.dao.admin.User.UserDao;
import loc.sn.model.admin.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by oleksiy on 22.08.16.
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    public User findById(int id) {
        return userDao.findById(id);
    }

    public List<User> findAllUsers() {
        return userDao.findAllUsers();
    }

    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    public void deleteUser(String id) {
        userDao.deleteUser(id);
    }

    public void updateUser(User user) {
        User entity = userDao.findById(user.getId());
        if (entity != null) {
            entity.setFirstName(user.getFirstName());
            entity.setLastName(user.getLastName());
            entity.setOtch(user.getOtch());
            entity.setEmail(user.getEmail());
            entity.setPassword(user.getPassword());
        }
    }
}
