package com.ohgiraffers.section01.model;

public class AddressDTO {

    private int addressNo;
    private String postNo;
    private String city;
    private String address1;
    private String address2;

    public AddressDTO() {
    }

    public AddressDTO(int addressNo, String postNo, String city, String address1, String address2) {
        this.addressNo = addressNo;
        this.postNo = postNo;
        this.city = city;
        this.address1 = address1;
        this.address2 = address2;
    }

    public int getAddressNo() {
        return addressNo;
    }

    public void setAddressNo(int addressNo) {
        this.addressNo = addressNo;
    }

    public String getPostNo() {
        return postNo;
    }

    public void setPostNo(String postNo) {
        this.postNo = postNo;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }


    @Override
    public String toString() {
        return "AddressDTO{" +
                "addressNo=" + addressNo +
                ", postNo='" + postNo + '\'' +
                ", city='" + city + '\'' +
                ", address1='" + address1 + '\'' +
                ", address2='" + address2 + '\'' +
                '}';
    }
}
