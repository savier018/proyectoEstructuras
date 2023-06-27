module com.mycompany.proyectoestructurasdatos {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires javafx.base;
    requires javafx.graphics;

    opens com.mycompany.proyectoestructurasdatos to javafx.fxml;
    exports com.mycompany.proyectoestructurasdatos;
}
