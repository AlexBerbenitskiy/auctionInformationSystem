package com.auction_information_system;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class BidderController implements Initializable {

    public TextField txtBidderName, txtAddress, txtPhone, txtEmail;
    public ListView<Bidder> ListViewBidder;
    public static CustomList<Bidder> bidders = new CustomList<>();

    Bidder bdr1 = new Bidder("Bob Smith", "17 Waterside Waterford", "0875677756", "bobs@gmail.com");
    Bidder bdr2 = new Bidder("John Walker", "57 Castle Street Cashel Tipperary", "0875778162", "johns@gmail.com");
    Bidder bdr3 = new Bidder("Peggy Olsen", "12 Hazelhatch Kerry", "0832718926", "peggy@gmail.com");

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        bidders.add(bdr1);
        bidders.add(bdr2);
        bidders.add(bdr3);
        listBidder();
    }

    /**
     * Method which takes in user input, uses it to create a bidder object, then adds the bidder to the list of bidders.
     */
    public void addBidder(){
        Bidder b = new Bidder(txtBidderName.getText(),txtAddress.getText(),txtPhone.getText(),txtEmail.getText());
        int i=0;
        while (i< bidders.size()) {
            if (bidders.get(i).getPhone().contains(txtPhone.getText())) {
                return;
            }
            i++;
        }
        bidders.addFirst(b);
    }

    /**
     * Method which adds every bidder in the bidders list to a viewable UI list.
     */
    public void listBidder() {
        ListViewBidder.getItems().clear();
        int i=0;
        while (i<bidders.size()) {
            if(!ListViewBidder.getItems().contains(bidders.get(i))) ListViewBidder.getItems().add(bidders.get(i));
            i++;
        }
        ListViewBidder.refresh();
    }


    /**
     * Method which calls the remove method after selecting an item from the list view.
     */
    @FXML
    public void deleteBidderBtn(){
        int toBeDeleted = ListViewBidder.getSelectionModel().getSelectedIndex();
        bidders.remove(toBeDeleted);
        listBidder();

    }

    /**
     * This method edits the selected Bidder
     */
    public void editBidder(){
        Bidder al = new Bidder(txtBidderName.getText(),txtAddress.getText(),txtPhone.getText(),txtEmail.getText());
        int alToBeEdited = ListViewBidder.getSelectionModel().getSelectedIndex();
        bidders.set(alToBeEdited, al);
        listBidder();

    }
}
