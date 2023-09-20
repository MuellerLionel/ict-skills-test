package ict.skills.ictskillslogin.db;


import org.hibernate.Session;

public interface TransactionExecuter {
    Object execute(Session s);
}
