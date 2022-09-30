package com.auction_information_system;

public class AuctionLot {

    private String name, description, type, dateOfOrigin, askingPrice, salePrice;
    private Bid[] bids = new Bid[1000];

    public AuctionLot(String name, String description, String type, String dateOfOrigin, String askingPrice, String salePrice) {
        if(name.length()==0) this.name = "Invalid";
        else if(Utilities.max50Chars(name)) this.name=name;
        else this.name = name.substring(0,46)+"...";

        if(description.length()==0) this.description = "Invalid";
        else if(!Utilities.max100Chars(description)) this.description = description.substring(0,96)+"...";
        else this.description = description;

        if(type.length()==0) this.type = "Invalid";
        else if(!Utilities.max30Chars(type)) this.type = type.substring(0,26)+"...";
        else this.type = type;

        this.dateOfOrigin = dateOfOrigin;
        this.askingPrice = askingPrice;

        if (salePrice.equals("")) this.salePrice = "Not sold";
        else this.salePrice = salePrice;
    }

    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public String getType() {
        return type;
    }
    public String getDateOfOrigin() {
        return dateOfOrigin;
    }
    public String getAskingPrice() {
        return askingPrice;
    }
    public String getSalePrice() {
        return salePrice;
    }
    public Bid[] getBids() {
        return bids;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setType(String type) {
        this.type = type;
    }
    public void setDateOfOrigin(String dateOfOrigin) {
        this.dateOfOrigin = dateOfOrigin;
    }
    public void setAskingPrice(String askingPrice) {
        this.askingPrice = askingPrice;
    }
    public void setSalePrice(String salePrice) {
        this.salePrice = salePrice;
    }
    public void setBids(Bid[] bids) {
        this.bids = bids;
    }

    @Override
    public String toString() {
        return "Name: " + name +
                ", Description: " + description +
                ", Type: " + type +
                ", Year of origin: " + dateOfOrigin +
                ", Asking price: " + askingPrice +
                ", Sale price: " + salePrice;
    }
}

