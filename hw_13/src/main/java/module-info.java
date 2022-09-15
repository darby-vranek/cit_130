module com.mycompany.darbyvranekcit130_hw {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.darbyvranekcit130_hw to javafx.fxml;
    exports com.mycompany.darbyvranekcit130_hw;
}
