module io.github.moehreag.krimiadvent {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;

    opens io.github.moehreag.krimiadvent to javafx.fxml;
    exports io.github.moehreag.krimiadvent;
}