package com.pollarusia2018.pollaupb.models;

public class Country {

    private String name;
    private String flagURL;

    public Country() {
    }

    public Country(String name, String flagURL) {
        this.name = name;
        this.flagURL = flagURL;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFlagURL() {
        return flagURL;
    }

    public void setFlagURL(String flagURL) {
        this.flagURL = flagURL;
    }
}
