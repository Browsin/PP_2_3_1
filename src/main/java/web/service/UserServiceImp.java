package web.service;

import web.dao.UserDao;
import web.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class UserServiceImp implements UserService {

   @Autowired
   private UserDao userDao;

   @Transactional(readOnly = true)
   @Override
   public List<User> getAllUsers() {
      return userDao.getAllUsers();
   }

   @Transactional//todo: ..идет с предыдущей задачи
   @Override
   public User findById(int id) {
      return userDao.findById(id);
   }//todo: int id ..идет с предыдущей задачи

   @Transactional
   @Override
   public void createOrUpdateUser(User user) {
      userDao.createOrUpdateUser(user);
   }

   @Transactional
   @Override
   public void deleteUser(int id) {
      userDao.deleteUser(id);
   }
}
