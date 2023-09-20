module ict.skills.ictskillslogin {
    requires javafx.controls;
    requires javafx.fxml;

    requires javafx.graphics;
    requires java.base;
    requires java.desktop;
    requires java.naming;

//    db-stuff
    requires mysql.connector.j;
    requires static lombok;
    requires org.hibernate.orm.core;
    requires jakarta.persistence;

    opens ict.skills.ictskillslogin to javafx.fxml;
    exports ict.skills.ictskillslogin;
}