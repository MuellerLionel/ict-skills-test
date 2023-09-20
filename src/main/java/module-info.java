module ict.skills.ictskillslogin {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.naming;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;

    opens ict.skills.ictskillslogin to javafx.fxml;
    exports ict.skills.ictskillslogin;
}