module edu.asu.ptbs {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens edu.asu.ptbs to javafx.fxml;
    exports edu.asu.ptbs;
}