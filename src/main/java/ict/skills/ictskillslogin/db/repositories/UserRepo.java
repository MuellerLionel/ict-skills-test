package ict.skills.ictskillslogin.db.repositories;

import ict.skills.ictskillslogin.db.DBUtil;
import ict.skills.ictskillslogin.db.models.User;
import org.hibernate.query.Query;

import java.util.List;

public class UserRepo {
    public static Boolean createUser(User user){
        return (Boolean) DBUtil.doWithTransaction(s -> {
            try{
                s.persist(user);
                return true;
            } catch (Error e) {
                return false;
            }
        });
    }
    public static List<User> getAllUsers(){
        return (List<User>) DBUtil.doWithTransaction(s -> {
            Query query = s.createQuery("from User", User.class);
            List<User> users = query.getResultList();
            return users;
        });
    }
    public static User getUserByUsername(String username){
        return (User) DBUtil.doWithTransaction(s -> {
            Query query = s.createQuery("from User where username=:username", User.class);
            query.setParameter("username", username);
            User user = (User) query.getSingleResult();
            return user;
        });
    }
}
