package com.auction_information_system;

public class Bid {
    private String timeOfBid, nameOfBidder, amountBid, object;

    public Bid(String timeOfBid, String nameOfBidder, String amountBid, String object) {
        if (Utilities.validTime(timeOfBid)) {
            this.timeOfBid = timeOfBid;
        } else this.timeOfBid = "XX:XX";
        this.amountBid = amountBid;
        this.nameOfBidder = nameOfBidder;
        this.object = object;
    }

    public String getTimeOfBid() {
        return timeOfBid;
    }
    public String getNameOfBidder() {
        return nameOfBidder;
    }
    public String getAmountBid() {
        return amountBid;
    }
    public String getObject() { return object; }

    public void setTimeOfBid(String timeOfBid) {
        this.timeOfBid = timeOfBid;
    }
    public void setNameOfBidder(String nameOfBidder) {
        this.nameOfBidder = nameOfBidder;
    }
    public void setAmountBid(String amountBid) {
        this.amountBid = amountBid;
    }
    public void setObject(String object) { this.object = object; }

    @Override
    public String toString() {
        return "Name of bidder: " + nameOfBidder +
                ", Amount bid: €" + amountBid +
                ", Time of bid: " + timeOfBid +
                " - placed on a " + object;
    }
}
