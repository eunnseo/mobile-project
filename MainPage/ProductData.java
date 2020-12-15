package com.cookandroid.teamproject;

public class ProductData {

    private String member_id;
    private String member_name;
    private String member_category;
    private String member_price;
    private String member_store_loc;
    private String member_reservation;

    public String getMember_id() {
        return member_id;
    }

    public String getMember_name() {
        return member_name;
    }

    public String getMember_category() {
        return member_category;
    }

    public String getMember_price() {
        return member_price;
    }

    public String getMember_store_loc() {
        return member_store_loc;
    }

    public String getMember_reservation() {
        return member_reservation;
    }

    public void setMember_id(String member_id) {
        this.member_id = member_id;
    }

    public void setMember_name(String member_name) {
        this.member_name = member_name;
    }

    public void setMember_category(String member_category) { this.member_category = member_category; }

    public void setMember_price(String member_price) {
        this.member_price = member_price;
    }

    public void setMember_store_loc(String member_store_loc) { this.member_store_loc = member_store_loc; }

    public void setMember_reservation(String member_reservation) { this.member_reservation = member_reservation; }
}
