package com.nenrys.mutroleum.species;

public class Species {

    public String[] genes = new String[6];
    private String name;

    public Species() {
        this("Mutroleum");
    }

    public Species(String name) {
        genes[0] = "nnnnnnn";
        genes[1] = "nnnnnnnn";
        genes[2] = "nnnnn";
        genes[3] = "nnnnn";
        genes[4] = "nnnnnnnnnn";
        genes[5] = "nnnn";
        this.name=name;
    }

}
