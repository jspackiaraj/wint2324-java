module in.net.jsp {
    requires javafx.controls;
    requires javafx.fxml;

    opens in.net.jsp to javafx.fxml;
    exports in.net.jsp;
}
