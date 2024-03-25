package com.ohgiraffers.section01.DTO;

public class MenuAndCategory {

    private int code;
    private String name;
    private int price;
    private CategoryDTO category; // 값을 주려면 게터세터로 게터로 접근해서 카테고리 반환(return)
    private String orderableStatus;

    public MenuAndCategory() {
    }

    public MenuAndCategory(int code, String name, int price, CategoryDTO category, String orderableStatus) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.category = category;
        this.orderableStatus = orderableStatus;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public CategoryDTO getCategory() {
        return category;
    }

    public void setCategory(CategoryDTO category) {
        this.category = category;
    }

    public String getOrderableStatus() {
        return orderableStatus;
    }

    public void setOrderableStatus(String orderableStatus) {
        this.orderableStatus = orderableStatus;
    }

    @Override
    public String toString() {
        return "MenuAndCategory{" +
                "code=" + code +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", category=" + category +
                ", orderableStatus='" + orderableStatus + '\'' +
                '}';
    }
}
