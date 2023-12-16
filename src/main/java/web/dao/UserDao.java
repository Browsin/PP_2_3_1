package web.dao;

import web.model.User;
import java.util.List;

public interface UserDao {
   List<User> getAllUsers();
   User findById(int id);
   void createOrUpdateUser(User user);
   void deleteUser(int id);
   }
