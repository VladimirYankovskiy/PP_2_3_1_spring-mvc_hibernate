package web.Service;

import web.models.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> allUsers();
    User showUser(int id);
    void saveUser(User user);
    void delUser(int id);
}
