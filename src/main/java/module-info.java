module com.ale.alessandro {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires java.desktop;

    opens com.ale.alessandro to javafx.fxml;
    exports com.ale.alessandro;
}