package ict.skills.ictskillslogin.db.repositories;

import ict.skills.ictskillslogin.db.DBUtil;
import ict.skills.ictskillslogin.db.models.Group;
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
            Query<User> query = s.createQuery("from User", User.class);
            return query.getResultList();
        });
    }
    public static User getUserByUsername(String username){
        return (User) DBUtil.doWithTransaction(s -> {
            Query<User> query = s.createQuery("from User where username=:username", User.class);
            query.setParameter("username", username);
            return query.getSingleResult();
        });
    }
    public static List<Group> getGroupsByUser(User user){
        return (List<Group>) DBUtil.doWithTransaction(s -> {
            Query<Group> query = s.createQuery("select g from group g join g.user u where u.id=:userId", Group.class);
            query.setParameter("userId", user.getId());
            return query.getResultList();
        });
    }
}
