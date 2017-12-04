package com.pollarusia2018.pollaupb;

/**
 * Created by andresvasquez on 11/24/17.
 */

public class Amigo {

    private String name;

    //TODO Cambiar a String en un futuro (URL)
    private int profilePicture;


    public Amigo(String name, int profilePicture) {
        this.name = name;
        this.profilePicture = profilePicture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(int profilePicture) {
        this.profilePicture = profilePicture;
    }
}
