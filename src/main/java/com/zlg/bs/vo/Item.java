package com.zlg.bs.vo;

import lombok.Data;

@Data
public class Item {
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    private String catalog;

    public String getCatalog() {
        return catalog;
    }

    public void setCatalog(String catalog) {
        this.catalog = catalog;
    }

    //图片url
    private String img;
    //商品标题
    private String title;
    private  String text;
    //现价
    private String ciurPic;
    //原价
    private String OriPic;
    //折扣
    private String discount;
    //现价
    private String price;
    //价格
    private String pri;
    //多少人付款
    private String nub;
    //原价
    private String original;
    private String color;
    private String cm;

    @Override
    public String toString() {
        return "Item{" +
                "img='" + img + '\'' +
                ", title='" + title + '\'' +
                ", ciurPic='" + ciurPic + '\'' +
                ", OriPic='" + OriPic + '\'' +
                ", discount='" + discount + '\'' +
                ", price='" + price + '\'' +
                ", pri='" + pri + '\'' +
                ", nub='" + nub + '\'' +
                ", original='" + original + '\'' +
                ", color='" + color + '\'' +
                ", cm='" + cm + '\'' +
                '}';
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCiurPic() {
        return ciurPic;
    }

    public void setCiurPic(String ciurPic) {
        this.ciurPic = ciurPic;
    }

    public String getOriPic() {
        return OriPic;
    }

    public void setOriPic(String oriPic) {
        OriPic = oriPic;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPri() {
        return pri;
    }

    public void setPri(String pri) {
        this.pri = pri;
    }

    public String getNub() {
        return nub;
    }

    public void setNub(String nub) {
        this.nub = nub;
    }

    public String getOriginal() {
        return original;
    }

    public void setOriginal(String original) {
        this.original = original;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCm() {
        return cm;
    }

    public void setCm(String cm) {
        this.cm = cm;
    }
}
