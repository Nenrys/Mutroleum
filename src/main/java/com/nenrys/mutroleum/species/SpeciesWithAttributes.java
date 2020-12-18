package com.nenrys.mutroleum.species;

public class SpeciesWithAttributes extends Species{

    private int pow, reg, dom, pro;

    private int maxVP;

    public SpeciesWithAttributes(String name) {
        super(name);
        maxVP = 10;
        pow = 1;
        reg = 1;
        dom = 1;
        pro = 1;
    }

}
