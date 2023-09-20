package ict.skills.ictskillslogin.db.repositories;

import ict.skills.ictskillslogin.db.DBUtil;
import ict.skills.ictskillslogin.db.models.Group;
import ict.skills.ictskillslogin.db.models.User;
import org.hibernate.query.Query;

import java.util.List;

public class GroupRepo {
    public static Boolean createGroup(Group group){
        return (Boolean) DBUtil.doWithTransaction(s -> {
            try{
                s.persist(group);
                return true;
            } catch (Error e) {
                return false;
            }
        });
    }
    public static List<Group> getAllGroups(){
        return (List<Group>) DBUtil.doWithTransaction(s -> {
            Query<Group> query = s.createQuery("from Group");
            return query.getResultList();
        });
    }
}
