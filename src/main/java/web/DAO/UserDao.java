package web.DAO;

import web.models.User;

import java.util.List;
import java.util.Optional;

public interface UserDao {
    List<User> allUsers();
    User showUser(int id);
    void saveUser(User user);
    void delUser(int id);
}
