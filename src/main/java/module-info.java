module com.gof.gameoflife {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.almasb.fxgl.all;

    opens com.gof.gameoflife to javafx.fxml;
    exports com.gof.gameoflife;
}