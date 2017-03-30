package com.wenzhiguo.yunifang.bean;

import org.litepal.crud.DataSupport;

/**
 * Created by dell on 2017/3/28.
 * 购物车bean对象
 */

public class ShoppingBean extends DataSupport{
    private int id;
    private String title;
    private String imageViewUrl;
    private String price;
    private String markPrice;
    private boolean isChecked;

    public ShoppingBean(int id, String title, String imageViewUrl, String price, String markPrice) {
        this.id = id;
        this.title = title;
        this.imageViewUrl = imageViewUrl;
        this.price = price;
        this.markPrice = markPrice;
    }

    public ShoppingBean() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageViewUrl() {
        return imageViewUrl;
    }

    public void setImageViewUrl(String imageViewUrl) {
        this.imageViewUrl = imageViewUrl;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getMarkPrice() {
        return markPrice;
    }

    public void setMarkPrice(String markPrice) {
        this.markPrice = markPrice;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    @Override
    public String toString() {
        return "ShoppingDataBase{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", imageViewUrl='" + imageViewUrl + '\'' +
                ", price=" + price +
                ", markPrice=" + markPrice +
                ", isChecked=" + isChecked +
                '}';
    }
}
