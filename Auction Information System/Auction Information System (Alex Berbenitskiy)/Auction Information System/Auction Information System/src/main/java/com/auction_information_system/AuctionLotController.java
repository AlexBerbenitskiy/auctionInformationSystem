package com.auction_information_system;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class AuctionLotController implements Initializable {
    public static CustomList<AuctionLot> auctionLots = new CustomList<>();
    public TextField txtName, txtDescription, txtType, txtOrigin, txtAskingPrice;
    public Button listButton;
    public ListView<AuctionLot> listViewAuction;
    public ListView<Bid> listViewBid;

    AuctionLot al1 = new AuctionLot("BMW M5", "E61 M5 Estate", "Car", "2007", "18500", "");
    AuctionLot al2 = new AuctionLot("Mercedes-Benz 500E", "W124 E-Class Saloon", "Car", "1996", "10500", "");
    AuctionLot al3 = new AuctionLot("Subaru Legacy", "Saloon", "Car", "2005", "3500", "");
    AuctionLot al4 = new AuctionLot("Orbea Occam H20", "Long-travel trail bike", "Mountain Bike", "2021", "2200", "");
    AuctionLot al5 = new AuctionLot("BMW 325i", "E46 325i Saloon", "Car", "2003", "1800", "");

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        auctionLots.add(al1);
        auctionLots.add(al2);
        auctionLots.add(al3);
        auctionLots.add(al4);
        auctionLots.add(al5);
        listAuctionLot();
    }

    /**
     * This method collects the data required to create an Auction lot and calls a method which creates it.
     */
    public void addAuctionLot(){
        AuctionLot al = new AuctionLot(txtName.getText(),txtDescription.getText(),txtType.getText(),txtOrigin.getText(),txtAskingPrice.getText(),"");
        auctionLots.addFirst(al);
    }

    public void listAuctionLot() {
        listViewAuction.getItems().clear();
        int i=0;
        while (i<auctionLots.size()) {
            if(!listViewAuction.getItems().contains(auctionLots.get(i))) listViewAuction.getItems().add(auctionLots.get(i));
            i++;
        }
        listViewAuction.refresh();
    }

    public void listBidsHigh() {
        if (listViewAuction.getSelectionModel().getSelectedItem() != null) {
            listViewBid.getItems().clear();
            int i = 0;
            while (i < listViewAuction.getSelectionModel().getSelectedItem().getBids().length) {
                if (!listViewBid.getItems().contains(listViewAuction.getSelectionModel().getSelectedItem().getBids()[i]) && listViewAuction.getSelectionModel().getSelectedItem().getBids()[i] != null)
                    listViewBid.getItems().add(listViewAuction.getSelectionModel().getSelectedItem().getBids()[i]);
                i++;
            }
            Sorting.quicksortHigh(listViewBid, 0, listViewBid.getItems().size()-1);
            listViewBid.refresh();
        }
    }

    public void listBidsLow() {
        if (listViewAuction.getSelectionModel().getSelectedItem() != null) {
            listViewBid.getItems().clear();
            int i = 0;
            while (i < listViewAuction.getSelectionModel().getSelectedItem().getBids().length) {
                if (!listViewBid.getItems().contains(listViewAuction.getSelectionModel().getSelectedItem().getBids()[i]) && listViewAuction.getSelectionModel().getSelectedItem().getBids()[i] != null)
                    listViewBid.getItems().add(listViewAuction.getSelectionModel().getSelectedItem().getBids()[i]);
                i++;
            }
            Sorting.quicksortLow(listViewBid, 0, listViewBid.getItems().size()-1);
            listViewBid.refresh();
        }
    }

    /**
     * Method which calls the remove method after selecting an item from the list view.
     */
    @FXML
    public void deleteLotBtn(){
        int alToBeDeleted = listViewAuction.getSelectionModel().getSelectedIndex();
        auctionLots.remove(alToBeDeleted);
        listAuctionLot();
    }

    /**
     * This method edits the selected Auction Lot
     */
    public void editLot(){
        AuctionLot al = new AuctionLot(txtName.getText(),txtDescription.getText(),txtType.getText(),txtOrigin.getText(),txtAskingPrice.getText(),"");
        int alToBeEdited = listViewAuction.getSelectionModel().getSelectedIndex();
        auctionLots.set(alToBeEdited, al);
        listAuctionLot();
    }

    public void sellLot() {
        if (listViewAuction.getSelectionModel().getSelectedItem() != null) {
            listBidsHigh();
            int selectedIndex = auctionLots.indexOf(listViewAuction.getSelectionModel().getSelectedItem());
            auctionLots.get(selectedIndex).setSalePrice(listViewBid.getItems().get(0).getAmountBid());
            for (int i =0; i < auctionLots.get(selectedIndex).getBids().length; i++) {
                auctionLots.get(selectedIndex).getBids()[i] = null;
            }
        }
        listAuctionLot();
        listBidsHigh();
    }
}
