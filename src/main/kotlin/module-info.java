module org.phase.paint {
    requires kotlin.stdlib;
    requires javafx.controls;
    requires javafx.graphics;

    // opens org.phase.paint to javafx.fxml; // Uncomment if u're using fxml.
    exports org.phase.paint;
}
