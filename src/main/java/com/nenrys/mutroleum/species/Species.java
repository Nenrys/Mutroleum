package com.nenrys.mutroleum.species;

import java.util.HashMap;
import java.util.List;

public class Species {

    private final String name;
    //chromosomes
    private HashMap<String, GENE> g_chrom = new HashMap<>();

    private HashMap<String, HashMap> chroms = new HashMap<>();

    public enum G_GENES {
        P_COLOR1,
        P_COLOR2,
        S_COLOR1,
        S_COLOR2
    }

    //for testing purposes
    public Species() {
        this("default");
    }

    public Species(String name) {
        this.name = name;

        chroms.put("genesis",g_chrom);

        for (G_GENES genes : G_GENES.values()) {
            g_chrom.put(genes.toString(), GENE.N);
        }

    }

    public GENE getGene(String chrom, String gene) {
        return (GENE)chroms.get(chrom).get(gene);
    }

    public void setGene(String chrom, String gene, GENE atcg) {
        this.chroms.get(chrom).put(gene, atcg);
    }

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
