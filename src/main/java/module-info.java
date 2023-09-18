module ict.skills.ictskillslogin {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;

    requires mysql.connector.j;
    requires static lombok;
    requires org.hibernate.orm.core;
    requires jakarta.persistence;

    opens ict.skills.ictskillslogin to javafx.fxml;
    exports ict.skills.ictskillslogin;
}