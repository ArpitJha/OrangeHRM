package com.orangeHrmLive.qa.pages.enums;

public enum Country {

    UNITED_KINGDOM("United Kingdom"),

    UKRAINE("Ukraine");

    private String value;

    public String getCountry() {
        return value;
    }

    Country(String value) {
        this.value = value;
    }
}
