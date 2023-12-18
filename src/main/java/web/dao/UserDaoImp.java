package web.dao;

import web.model.User;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @PersistenceContext
   private EntityManager entityManager;

   @Override
   public List<User> getAllUsers() {
      return entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();//todo: codeStyle
   }

   @Override
   public User findById(int id) {
      return entityManager.find(User.class, id);
   }

   @Override
   public void createOrUpdateUser(User user) {
      userformCheck(user);
      if (user.getId() == null) {
         entityManager.persist(user);
      } else {
         entityManager.merge(user);
      }
   }

   private void userformCheck(User user) {//todo: не требовалось по тех.заданию (на проектах свобода мысли.. не всегда приветствуется)
      if (user.getFirstName() == "") {
         user.setFirstName("Default Name " +user.getId());
      }
      if (user.getLastName() == "") {
         user.setLastName("Default Surname " +user.getId());
      }
      if (user.getEmail() == "") {
         user.setEmail("n/a email");
      }
   }

   @Override
   public void deleteUser(int id) {
      entityManager.remove(findById(id));
   }
}
