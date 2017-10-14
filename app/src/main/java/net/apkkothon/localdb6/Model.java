package net.apkkothon.localdb6;

/**
 * Created by joy on 10/11/17.
 */

public class Model {

    String name,profession;


    public Model(String name, String profession) {
        this.name = name;
        this.profession = profession;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }
}
