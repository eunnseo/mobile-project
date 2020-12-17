package com.cookandroid.teamproject;

import android.graphics.Bitmap;

public class ProductData {

    private String member_id;
    private String member_name;
    private String member_category;
    private String member_price;
    private String member_store_loc;
    private String member_reservation;
    private Bitmap member_image1;
    private Bitmap member_image2;
    private Bitmap member_image3;
//    private Bitmap member_image4;
//    private Bitmap member_image5;
//    private Bitmap member_image6;

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

    public Bitmap getMember_image1() {
        return member_image1;
    }

    public Bitmap getMember_image2() {
        return member_image2;
    }

    public Bitmap getMember_image3() {
        return member_image3;
    }

//    public Bitmap getMember_image4() { return member_image4; }
//
//    public Bitmap getMember_image5() { return member_image5; }
//
//    public Bitmap getMember_image6() { return member_image6; }

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

    public void setMember_image1(Bitmap member_image1) { this.member_image1 = member_image1; }

    public void setMember_image2(Bitmap member_image2) { this.member_image2 = member_image2; }

    public void setMember_image3(Bitmap member_image3) { this.member_image3 = member_image3; }

//    public void setMember_image4(Bitmap member_image4) { this.member_image4 = member_image4; }
//
//    public void setMember_image5(Bitmap member_image5) { this.member_image5 = member_image5; }
//
//    public void setMember_image6(Bitmap member_image6) { this.member_image6 = member_image6; }
}
