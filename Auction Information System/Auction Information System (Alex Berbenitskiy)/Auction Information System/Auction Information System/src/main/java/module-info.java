module com.auction_information_system {
    requires javafx.controls;
    requires javafx.fxml;
    requires xstream;


    opens com.auction_information_system to javafx.fxml;
    exports com.auction_information_system;
}