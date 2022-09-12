package com.nenrys.mutroleum.species;

import java.util.HashMap;

public class Species {

    private final String name;

    private HashMap<GENES, GENE> genes = new HashMap<>();
    private HashMap<ATTRIBUTES, Integer> attributes = new HashMap<>();

    public enum GENES {
        P_COLOR1,
        P_COLOR2,
        S_COLOR1,
        S_COLOR2
    }

    public enum ATTRIBUTES {
        VITALITY,
        POWER,
        SWARM,
        SANCTUM,
        EFFICIENCY,
        PRODUCTION,
        MUTRATION,
        TH8,
        SPREAD,
        MUTATION,
        GLUTTONY,
        INVASION
    }

    //for testing purposes
    public Species() {
        this("default");
    }

    public Species(String name) {
        this.name = name;

        for (GENES gene : GENES.values()) {
            setGene(gene, GENE.N);
        }
        for (ATTRIBUTES atr : ATTRIBUTES.values()) {
            setAttribute(atr, 0);
        }

    }

    public GENE getGene(GENES genes) {
        return this.genes.get(genes);
    }

    public void setGene(GENES genes, GENE gene) {
        this.genes.put(genes, gene);
    }

    public int getAttribute(ATTRIBUTES atr) {return this.attributes.get(atr); }

    public void setAttribute(ATTRIBUTES atr, int valofatr) { this.attributes.put(atr, valofatr); }

    public String getName() {
        return this.name;
    }

    public enum GENE {
        N,
        A,
        T,
        C,
        G
    }
}
