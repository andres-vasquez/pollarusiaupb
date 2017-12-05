package com.pollarusia2018.pollaupb.models;

/**
 * Created by Adrian on 12/4/2017.
 */

public class Partido {
    private Country equipo1, equipo2;
    private String score1, score2;
    private String hora, estadio;

    public Partido(Country equipo1, Country equipo2, String score1, String score2, String hora, String estadio) {
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        this.estadio = estadio;
        this.hora = hora;
        this.score1 = score1;
        this.score2 = score2;
    }

    public String getScore1() {
        return score1;
    }

    public void setScore1(String score1) {
        this.score1 = score1;
    }

    public String getScore2() {
        return score2;
    }

    public void setScore2(String score2) {
        this.score2 = score2;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getEstadio() {
        return estadio;
    }

    public void setEstadio(String estadio) {
        this.estadio = estadio;
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
