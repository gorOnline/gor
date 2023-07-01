package com.app.gorworld.model.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum PLAN {
    QUARTER("QUARTER", 30, 149.0, 1.0, 150.0),
    HALFYEAR("HALFYEAR", 182, 249.0, 51.0, 300.0),
    YEAR("YEAR", 365, 449.0, 151.0, 600.0);

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getOffer() {
        return offer;
    }

    public void setOffer(Double offer) {
        this.offer = offer;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;
    private Integer days;
    private Double price;
    private Double offer;
    private Double total;

    PLAN(String name, Integer days, Double price, Double offer, Double total) {
        this.name = name;
        this.days = days;
        this.price = price;
        this.offer = offer;
        this.total = total;
    }
}
