package com.kite.joco.recyclerontouchp1;

/**
 * Created by Joco on 2015.08.18..
 */
public class Person {

    String name;
    String haircolor;

    public Person(String name, String haircolor) {
        this.name = name;
        this.haircolor = haircolor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHaircolor() {
        return haircolor;
    }

    public void setHaircolor(String haircolor) {
        this.haircolor = haircolor;
    }


    @Override
    public String toString() {
        return "Obejct toString = Személy neve= " + name + ", hajszine= " + haircolor;
    }
}

