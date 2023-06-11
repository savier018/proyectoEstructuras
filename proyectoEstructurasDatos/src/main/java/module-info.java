module com.mycompany.proyectoestructurasdatos {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mycompany.proyectoestructurasdatos to javafx.fxml;
    exports com.mycompany.proyectoestructurasdatos;
}
