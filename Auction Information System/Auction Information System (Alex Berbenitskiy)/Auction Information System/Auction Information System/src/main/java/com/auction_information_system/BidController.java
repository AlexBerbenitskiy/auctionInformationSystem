package com.auction_information_system;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class BidController {

    @FXML
    public TextField txtBidTime, txtBidAmount;
    @FXML
    public ListView<AuctionLot> listViewAuction;
    @FXML
    public ListView<Bid> listViewBid;
    @FXML
    public ListView<Bidder> listViewBidders;

    public void listAuctionLots() {
        listViewAuction.getItems().clear();
        int i=0;
        while (i<AuctionLotController.auctionLots.size()) {
            if(!listViewAuction.getItems().contains(AuctionLotController.auctionLots.get(i))) listViewAuction.getItems().add(AuctionLotController.auctionLots.get(i));
            i++;
        }
        listViewAuction.refresh();
    }

    public void listBidders() {
        listViewBidders.getItems().clear();
        int i=0;
        while (i<BidderController.bidders.size()) {
            if(!listViewBidders.getItems().contains(BidderController.bidders.get(i)) && BidderController.bidders.get(i) != null) listViewBidders.getItems().add(BidderController.bidders.get(i));
            i++;
        }
        listViewBidders.refresh();
    }

    public void listBids() {
        listViewBid.getItems().clear();
        for (int i=0; i<AuctionLotController.auctionLots.size(); i++) {
            for (int j=0; j<AuctionLotController.auctionLots.get(i).getBids().length; j++) {
                if (!listViewBid.getItems().contains(AuctionLotController.auctionLots.get(i).getBids()[j]) && AuctionLotController.auctionLots.get(i).getBids()[j] != null) {
                    listViewBid.getItems().add(AuctionLotController.auctionLots.get(i).getBids()[j]);
                }
            }
        }
        listViewBid.refresh();
    }

    /**
     * Method that uses quadratic probing to add bids to a hash table.
     */
    public void addBid() {
        if (!txtBidTime.getText().equals("") && !txtBidAmount.getText().equals("")                                      //If the user has entered text.
                && listViewBidders.getSelectionModel().getSelectedItem() != null                                        //If the user has selected a bidder,
                && listViewAuction.getSelectionModel().getSelectedItem() != null                                        //an auction lot,
                && listViewAuction.getSelectionModel().getSelectedItem().getSalePrice().equals("Not sold")) {           //and the object isn't already sold.
            Bid bid = new Bid(txtBidTime.getText(), listViewBidders.getSelectionModel().getSelectedItem().getBidderName(), txtBidAmount.getText(), listViewAuction.getSelectionModel().getSelectedItem().getName());    //Create a bid using the provided information.
            for (int i=0; i<listViewAuction.getSelectionModel().getSelectedItem().getBids().length; i++) {                                                                                      //Loop N times.
                int hashValue = Integer.parseInt(listViewBidders.getSelectionModel().getSelectedItem().getPhone()) % listViewAuction.getSelectionModel().getSelectedItem().getBids().length;    //Divide the bidders phone number by the size of the hash table and set hashValue as the difference.
                if(listViewAuction.getSelectionModel().getSelectedItem().getBids()[hashValue]==null) listViewAuction.getSelectionModel().getSelectedItem().getBids()[hashValue] = bid;          //If the space is empty (null) at index hashValue is empty (null), add the bid to the hash table.
                else {
                    for (int j=0; j<listViewAuction.getSelectionModel().getSelectedItem().getBids().length; j++) {                                                                              //Otherwise, loop through the table.
                        int newHashValue = (hashValue + j*j) % listViewAuction.getSelectionModel().getSelectedItem().getBids().length;                                                          //Divide the current hashValue plus the value of j squared by the table size and set newHashValue as the difference.
                        if(listViewAuction.getSelectionModel().getSelectedItem().getBids()[newHashValue]==null) {                                                                               //If the space is empty (null) at index newHashValue,
                            listViewAuction.getSelectionModel().getSelectedItem().getBids()[newHashValue] = bid;                                                                                //add the bid to the hash table.
                            break;
                        }
                    }
                }
            }
        }
        listBids();
    }

    public void deleteBid() {
        if (listViewBid.getSelectionModel().getSelectedItem() != null) {
            String name = listViewBid.getSelectionModel().getSelectedItem().getNameOfBidder();
            for (int i=0; i<AuctionLotController.auctionLots.size(); i++) {
                for (int j=0; j<AuctionLotController.auctionLots.get(i).getBids().length; j++) {
                    if (AuctionLotController.auctionLots.get(i).getBids()[j] != null) {
                        if (AuctionLotController.auctionLots.get(i).getBids()[j].getNameOfBidder().equals(name))
                            AuctionLotController.auctionLots.get(i).getBids()[j] = null;
                    }
                }
            }
        }
        listBids();
    }

    /** SAVE NOT WORKING
     *  Method to save the information which has been input by the user.
     *  @throws Exception if the information cannot be saved.
     */
    @FXML
    public void save() throws Exception {
        XStream xstream = new XStream(new DomDriver());
        ObjectOutputStream out1 = xstream.createObjectOutputStream(new FileWriter("auction-lots.xml"));
        ObjectOutputStream out2 = xstream.createObjectOutputStream(new FileWriter("bidders.xml"));
        out1.writeObject(AuctionLotController.auctionLots);
        out2.writeObject(BidderController.bidders);
        out1.close();
        out2.close();
    }

    /**  LOAD NOT WORKING
     *   Method to load the information which has been input by the user.
     * * @throws Exception if the information cannot be loaded.
     */
    @SuppressWarnings("unchecked")
    public void load() throws Exception {
        XStream xstream = new XStream(new DomDriver());
        ObjectInputStream read1 = xstream.createObjectInputStream(new FileReader("auction-lots.xml"));
        ObjectInputStream read2 = xstream.createObjectInputStream(new FileReader("bidders.xml"));
        AuctionLotController.auctionLots = (CustomList<AuctionLot>) read1.readObject();
        BidderController.bidders = (CustomList<Bidder>) read2.readObject();
        read1.close();
        read2.close();
    }
}
