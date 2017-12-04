package com.pollarusia2018.pollaupb.models;

/**
 * Created by Adrian on 12/4/2017.
 */

public class Partido {
    private Country equipo1, equipo2;


    public Partido(Country equipo1, Country equipo2) {
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
    }


    public Country getEquipo1() {
        return equipo1;
    }

    public void setEquipo1(Country equipo1) {
        this.equipo1 = equipo1;
    }

    public Country getEquipo2() {
        return equipo2;
    }

    public void setEquipo2(Country equipo2) {
        this.equipo2 = equipo2;
    }
}
