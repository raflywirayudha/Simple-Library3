module com.project.bukuproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.jetbrains.annotations;


    opens com.project.bukuproject to javafx.fxml;
    exports com.project.bukuproject;
}