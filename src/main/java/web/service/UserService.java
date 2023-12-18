package web.service;

import web.model.User;
import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User findById(int id);

    void createOrUpdateUser(User user);

    void deleteUser(int id);
}
