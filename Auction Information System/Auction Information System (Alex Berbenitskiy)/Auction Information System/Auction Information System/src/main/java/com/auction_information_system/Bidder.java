package com.auction_information_system;

public class Bidder {

    private String bidderName;
    private String address, phone, email;

    public Bidder(String bidderName, String address, String phone, String email) {
        this.bidderName = bidderName;
        this.address = address;
        if (Utilities.validPhone(phone)) {
            this.phone = phone;
        } else {
            this.phone = "0000000000";
        }

        this.email = email;
    }

    public String getBidderName() {
        return bidderName;
    }
    public String getAddress() {
        return address;
    }
    public String getPhone() {
        return phone;
    }
    public String getEmail() {
        return email;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public void setBidderName(String bidderName) {
        this.bidderName = bidderName;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Name: " + bidderName +
                ", Address: " + address +
                ", Phone: " + phone +
                ", Email: " + email;
    }
}
